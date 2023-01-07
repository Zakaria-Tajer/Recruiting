package com.recruite.recruiting.dto;

import com.recruite.recruiting.enums.OffersStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Offers {


    private String offreName;

    private String description;

    private String profilSearching;

    private String city;

    private String educationLevel;

    private int salary;

    @Enumerated(EnumType.STRING)
    private OffersStatus status;

}
