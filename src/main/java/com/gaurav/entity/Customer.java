package com.gaurav.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_gen")
    @SequenceGenerator(name = "customer_id_gen", initialValue = 1, allocationSize = 1, sequenceName = "customer_id_sequ")
    private Long customerId;
    private String firstName;
    private String lastName;


    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_DETAILS_ID")
    @Fetch(FetchMode.JOIN)
    private CustomerDetails customerDetails;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(String firstName, String lastName, CustomerDetails customerDetails) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerDetails = customerDetails;
    }

}
