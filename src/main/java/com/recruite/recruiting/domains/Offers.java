package com.recruite.recruiting.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.recruite.recruiting.enums.OffersStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Offers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int offresId;

    private String offreName;

    private String description;

    private String profilSearching;

    private String city;

    private String educationLevel;

    private int salary;

    @Enumerated(EnumType.STRING)
    private OffersStatus status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnore
    private Recruiter recruiterChief;


}
