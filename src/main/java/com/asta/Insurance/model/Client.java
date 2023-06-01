package com.asta.Insurance.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String fatherName;
    private LocalDate dateOfBirth;
    @ManyToOne
    private Agent idAgent;
    private LocalDate dateOfInsurance;
    private Long durationOfInsurance;
}

