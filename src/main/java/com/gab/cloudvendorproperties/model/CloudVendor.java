package com.gab.cloudvendorproperties.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class CloudVendor {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String phoneNumber;

}
