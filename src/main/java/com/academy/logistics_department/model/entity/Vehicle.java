package com.academy.logistics_department.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "vehicle_name")
    private String name;
    @Column(name = "max_load_capacity")
    private Integer maxLoadCapacity;
    @Column(name = "max_trip_distance")
    private Integer maxTripDistance;
    @Column(name = "dim_X_restriction")
    private Integer dimXRestrictions;
    @Column(name = "dim_Y_restriction")
    private Integer dimYRestrictions;
    @Column(name = "dim_Z_restriction")
    private Integer dimZRestrictions;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "required_category_id")
    private Category requiredCategory;
}
