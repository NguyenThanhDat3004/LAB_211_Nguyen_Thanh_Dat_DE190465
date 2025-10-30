package org.utills;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtill {
    private static final SessionFactory sessionFactory = buildSessionfactory();
    private static SessionFactory buildSessionfactory(){
        try{
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Can not initialize sessionFactory");
            return null;
        }

    }
    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }
    public static void shutdown(){
        getSessionFactory().close();
    }
}
