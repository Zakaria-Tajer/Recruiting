package com.recruite.recruiting.dto;


import com.recruite.recruiting.enums.OffersStatus;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class GetOffersStatus {

    @Enumerated(EnumType.STRING)

    private OffersStatus status;
}
