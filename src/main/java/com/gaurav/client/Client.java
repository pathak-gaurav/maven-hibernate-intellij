package com.gaurav.client;

import com.gaurav.entity.Customer;
import com.gaurav.entity.CustomerDetails;
import com.gaurav.entity.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Client {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class).addAnnotatedClass(CustomerDetails.class).buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        /*session.save(new Customer("Zack", "Anderson"));
        session.save(new Customer("Cody", "Anderson"));*/

        session.save(new Customer("Zack","Anderson",
                new CustomerDetails(22L, Gender.MALE,"London")));
        session.save(new Customer("Becky","Smith",
                new CustomerDetails(28L, Gender.FEMALE,"Los Angeles")));
        session.getTransaction().commit();

        Customer customer = session.get(Customer.class, 1L);
        System.out.println(customer);

        session.close();
        sessionFactory.close();
    }
}
