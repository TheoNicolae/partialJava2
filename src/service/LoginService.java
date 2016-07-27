package service;

import dao.UserDao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Users;

public class LoginService {

    private EntityManagerFactory emf;

    private LoginService() {

        emf = Persistence.createEntityManagerFactory("ExPartialPU");

    }

    private static final class SingletonHolder {

        private static final LoginService SINGLETON = new LoginService();

    }

    public static final LoginService getInstance() {

        return SingletonHolder.SINGLETON;
    }

    public Users login(String username, String parola) {
        EntityManager em = emf.createEntityManager();

        UserDao uDao = new UserDao(em);

        Users user = uDao.findUserByUsername(username);
        if (user != null) {
            if (user.getUsername().equals(username) && user.getParola().equals(parola)) {
                return user;
            }

        }
        if (em != null) {
            em.close();
        }

        return null;

    }

    public void register(String username, String parola) {

        EntityManager em = emf.createEntityManager();
        UserDao uDao = new UserDao(em);
        Users user = null;

        try {
            em.getTransaction().begin();
            user = new Users();
            user.setUsername(username);
            user.setParola(parola);
            uDao.adaugaUser(user);
            em.getTransaction().commit();
        } catch (Exception e) {

            e.printStackTrace();
            em.getTransaction().rollback();

        } finally {

            if (em != null) {
                em.close();
            }
        }

    }

}
