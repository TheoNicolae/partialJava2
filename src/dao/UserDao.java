package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Users;


public class UserDao {
    
    private EntityManager em;
    
    
    
    public UserDao(EntityManager em){
        this.em = em;
    }
    
    public void adaugaUser(Users u){
    
        em.persist(u);
    
    }
    
    public Users findUserByUsername(String nume){
    
      Query query = this.em.createNamedQuery("Users.findByUsername");
      query.setParameter("username", nume);
      List<Users> list =(List<Users>) query.getResultList();
      return list.isEmpty() ? null : list.get(0);
        
    }
    
}
