package com.gaurav.client;

import com.gaurav.entity.Customer;
import com.gaurav.entity.CustomerDetails;
import com.gaurav.entity.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Customer.class).addAnnotatedClass(CustomerDetails.class).buildSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            session.save(new Customer("Zack", "Anderson",
                    new CustomerDetails(22L, Gender.MALE, "London")));
            session.save(new Customer("Becky", "Smith",
                    new CustomerDetails(28L, Gender.FEMALE, "Los Angeles")));

           /*
           *Will Throw the ObjectNotFoundException
           System.out.println(session.load(Customer.class,3L));
           * */

            session.getTransaction().commit();

            session.beginTransaction();
            List<Customer> customerList = session.createQuery("from Customer", Customer.class).getResultList();
            System.out.println(customerList);
            session.getTransaction().commit();

        } catch (Exception exe) {
            exe.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }

    }
}
