package service;

import dao.MelodiiDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Melodii;

public class MelodiiService {

    EntityManagerFactory emf;

    private MelodiiService() {

        emf = Persistence.createEntityManagerFactory("ExPartialPU");

    }

    private static final class SingletonHolder {

        private static final MelodiiService SINGLETON = new MelodiiService();

    }

    public static final MelodiiService getInstance() {

        return SingletonHolder.SINGLETON;

    }

    public void addMelodie(String gen, String nume) {

        EntityManager em = this.emf.createEntityManager();
        try {
            em.getTransaction().begin();
            MelodiiDao mDao = new MelodiiDao(em);
            Melodii m = new Melodii();
            m.setGen(gen);
            m.setNume(nume);
            mDao.adaugaMelodie(m);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.getStackTrace();
            em.getTransaction().rollback();

        } finally {
            if (em != null) {
                em.close();
            }
        }

    }

    public List<Melodii> getMelodii() {

        EntityManager em = emf.createEntityManager();
        MelodiiDao mDao = new MelodiiDao(em);
        List<Melodii> list = mDao.getAllMelodii();
        return list;
    }
    
    
    
    
    
       public List<Melodii> getMelodiiById(int id) {

        EntityManager em = emf.createEntityManager();
        MelodiiDao mDao = new MelodiiDao(em);
        List<Melodii> list = mDao.getMelodiiById(id);
        return list;
    }
}
