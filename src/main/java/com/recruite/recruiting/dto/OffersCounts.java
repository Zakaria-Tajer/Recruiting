package com.recruite.recruiting.dto;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class OffersCounts {
    private Long counts;

    public OffersCounts(Long counts) {
        this.counts = counts;
    }
}
