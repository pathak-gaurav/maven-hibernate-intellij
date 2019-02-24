package com.gaurav.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "CUSTOMER_DETAILS")
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_details_id")
    @SequenceGenerator(name = "customer_details_id", allocationSize = 1, initialValue = 1,
            sequenceName = "customer_details_id_sequ")
    private Long customerDetailsId;
    private Long age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String location;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customerDetails")
    private Customer customer;

    public CustomerDetails(Long age, Gender gender, String location, Customer customer) {
        this.age = age;
        this.gender = gender;
        this.location = location;
        this.customer = customer;
    }

    public CustomerDetails(Long age, Gender gender, String location) {
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    @Override
    public String toString() {
        return "CustomerDetails{" +
                "customerDetailsId=" + customerDetailsId +
                ", age=" + age +
                ", gender=" + gender +
                ", location='" + location + '\'' +
                '}';
    }
}
