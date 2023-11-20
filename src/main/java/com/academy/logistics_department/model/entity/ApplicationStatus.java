package com.academy.logistics_department.model.entity;

import com.academy.logistics_department.model.enums.ApplicationStatusEnum;
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
@Table(name = "application_status")
public class ApplicationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "status_name", unique = true)
    @Enumerated(EnumType.STRING)
    private ApplicationStatusEnum statusName;
}
