package com.gaurav.client;

import com.gaurav.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(new Customer("Zack", "Anderson"));
        session.save(new Customer("Cody", "Anderson"));

        session.getTransaction().commit();

        session.close();
        sessionFactory.close();
    }
}
