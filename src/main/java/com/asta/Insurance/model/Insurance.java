package com.asta.Insurance.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "insurance")
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long sum;
    @ManyToOne
    private Agent agent;
    @ManyToOne
    private Client client;
    private LocalDate dateOfInsurance;
    private Long durationOfInsurance;
}

