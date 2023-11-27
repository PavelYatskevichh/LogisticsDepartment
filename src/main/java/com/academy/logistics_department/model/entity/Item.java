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
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "item_name")
    private String name;
    @Column(name = "weight")
    private Integer weight;
    @Column(name = "dim_X")
    private Integer dimX;
    @Column(name = "dim_Y")
    private Integer dimY;
    @Column(name = "dim_Z")
    private Integer dimZ;
}
