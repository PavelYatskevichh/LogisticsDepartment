package com.academy.logistics_department.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "application_id")
    private List<Item> items;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "loading_address_id")
    private Address loadingAddress;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "unloading_address_id")
    private Address unloadingAddress;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private User customer;
}
