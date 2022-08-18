package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.AccountService;

public class ResetPasswordServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String UUID = request.getParameter("uuid");
        if (UUID != null) {
            request.setAttribute("user_uuid", UUID);
            getServletContext().getRequestDispatcher("/WEB-INF/reset_new_password.jsp").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
        return;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        AccountService accountService = new AccountService();

        switch (action) {

            case "send_email":
                String userEmail = request.getParameter("user_email");
                String url = request.getRequestURL().toString();
                String path = getServletContext().getRealPath("/WEB-INF");

                accountService.resetPassword(userEmail, path, url);
                request.setAttribute("message", "If the email you entered is correct, you should recieve an email shortly.");
                getServletContext().getRequestDispatcher("/WEB-INF/reset.jsp").forward(request, response);
                return;
            case "set_password":
                String Uuid = request.getParameter("uuid");
                String newPassword = request.getParameter("new_password");

                if (accountService.changePassword(Uuid, newPassword)) {
                    request.setAttribute("message", "Password successfully changed");
                } else {
                    request.setAttribute("message", "Password was not changed");
                }
                getServletContext().getRequestDispatcher("/WEB-INF/reset_new_password.jsp").forward(request, response);
                return;
        }

    }

}
