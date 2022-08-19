package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Role;
import models.User;


public class UserDB {
    public User get(String email) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try {
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }
    
    public User getByUUID(String Uuid) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try {
            //User user = (User) em.createNamedQuery("User.findByResetPasswordUuid", User.class).getResultList();
            List<User> userList = em.createNamedQuery("User.findByResetPasswordUuid", User.class).setParameter(1,Uuid).getResultList();
            return userList.get(0);
        } finally {
            em.close();
        }
    }
    
    public void update(User user){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        try{
            Role role = user.getRole();
            role.getUserList().add(user);
            
            trans.begin();
            em.merge(user);
            
            em.merge(role);
            trans.commit();
        }catch (Exception e){
            trans.rollback();
        }finally{
            em.close();
        }
    }
    
     
}
