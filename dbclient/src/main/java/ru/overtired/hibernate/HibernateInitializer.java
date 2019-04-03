package ru.overtired.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ru.overtired.model.User;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class HibernateInitializer {

    private final SessionFactory sessionFactory;
    private Logger logger =  Logger.getLogger(HibernateInitializer.class.getName());

    public HibernateInitializer() {
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
        } catch(Exception e) {
            logger.log(Level.WARNING, "Can't connect to database");

            return null;
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void save(Object entity) {
        Session session = getSessionFactory().getCurrentSession();
        Transaction trans=session.beginTransaction();
        session.save(entity);
        trans.commit();
    }
}
