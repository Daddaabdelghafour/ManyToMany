package daoImpl;

import dao.CourseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import models.Course;

import java.util.List;

public class CourseDaoImpl implements CourseDao {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CourseDaoImpl() {
        emf = Persistence.createEntityManagerFactory("myJpaUnit");
        em = emf.createEntityManager();
    }

    @Override
    public void save(Course course) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(course);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public Course findById(int id) {
        return em.find(Course.class, id);
    }

    @Override
    public List<Course> findAll() {
        TypedQuery<Course> query = em.createQuery("SELECT c FROM Course c", Course.class);
        return query.getResultList();
    }

    @Override
    public void update(Course course) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(course);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Course course) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.contains(course) ? course : em.merge(course));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
        }
    }

    public void close() {
        em.close();
        emf.close();
    }
}