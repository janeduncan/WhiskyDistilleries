package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;
import javax.persistence.EntityManager;


public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    @Autowired
    EntityManager entityManager;

    @Transactional
    public List<Whisky> findAllWhiskyByYear(int year) {
        List<Whisky> whiskies = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            cr.add(Restrictions.eq("year", year));
            whiskies = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return whiskies;
    }

    @Transactional
    public List<Whisky> findAllWhiskyByDistilleryAndAge(Distillery distillery, int age) {

        List<Whisky> whiskies = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Whisky.class);
            Conjunction objConjunction = Restrictions.conjunction();
            objConjunction.add(Restrictions.eq("distillery", distillery));
            objConjunction.add(Restrictions.eq("age", age));
            cr.add(objConjunction);
            whiskies = cr.list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return whiskies;
    }

    @Transactional
    public List<Whisky> findAllWhiskyByRegion(String region) {
        List<Whisky> whiskies = null;
        Session session = entityManager.unwrap(Session.class);
        try {

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return whiskies;
    }

}
