package ru.overtired.javafx.sample3.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.overtired.javafx.sample3.models.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.io.IOException;
import java.util.List;
import java.util.Properties;


public class HibernateManager {
    private static HibernateManager instance = null;
    private EntityManager entityManager;

    private HibernateManager() {
        SessionFactory sessionFactory = buildSessionFactory();
        entityManager = sessionFactory.createEntityManager();
    }

    public static HibernateManager getInstance() {
        if (instance == null) {
            instance = new HibernateManager();
        }
        return instance;
    }

    private SessionFactory buildSessionFactory() throws Error {
        Properties dbConnectionProperties = new Properties();
        try {
            dbConnectionProperties.load(
                    ClassLoader.getSystemClassLoader().getResourceAsStream("hibernate.properties")
            );
        } catch (IOException e) {
            throw new Error("Cannot read hibernate properties");
        }

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);
        configuration.addProperties(dbConnectionProperties);

        return configuration.buildSessionFactory();
    }

    public void beginTransaction() {
        entityManager.getTransaction().begin();
    }

    public void endTransaction() {
        entityManager.getTransaction().commit();
    }

    public void save(Object entity) {
       entityManager.persist(entity);

    }

    public List<User> getAllUsers() {
        TypedQuery<User> userQuery = entityManager.createQuery("Select u from User u", User.class);
        return userQuery.getResultList();
    }
}
