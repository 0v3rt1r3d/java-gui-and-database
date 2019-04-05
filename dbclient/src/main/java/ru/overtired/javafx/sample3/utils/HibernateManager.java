package ru.overtired.javafx.sample3.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import ru.overtired.javafx.sample3.models.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HibernateManager {

    private final SessionFactory sessionFactory;

    private EntityManager entityManager;
    private Logger logger = Logger.getLogger(HibernateManager.class.getName());

    public HibernateManager() {
        sessionFactory = buildSessionFactory();
    }

    private SessionFactory buildSessionFactory() {
        try {
            Properties dbConnectionProperties = new Properties();
            dbConnectionProperties.load(
                    ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties")
            );

            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(User.class);
            configuration.addProperties(dbConnectionProperties);

            return configuration.buildSessionFactory();
        } catch (Exception e) {
            logger.log(Level.WARNING, "Can't connect to database");

            return null;
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void save(Object entity) {
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        session.save(entity);
        trans.commit();
    }

    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();
        Query<User> userQuery = session.createQuery("Select u from User u", User.class);
        trans.commit();
        return userQuery.getResultList();
    }
}
