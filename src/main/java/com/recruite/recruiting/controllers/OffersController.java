package com.recruite.recruiting.controllers;


import com.recruite.recruiting.domains.Offers;
import com.recruite.recruiting.dto.GetOffersStatus;
import com.recruite.recruiting.dto.OffersCounts;
import com.recruite.recruiting.services.offers.OffersServiceImp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offers")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class OffersController {


    private final OffersServiceImp offersServiceImp;

    @GetMapping("/allOffers")
    public List<Offers> getAllOffers(){
        return offersServiceImp.getAllOffers();

    }

    @PostMapping("/offersByStatus")
    public ResponseEntity<Long> getOffersCount(@RequestBody GetOffersStatus getOffersStatus){
        return  ResponseEntity.ok(offersServiceImp.getOffersCount(getOffersStatus));
    }

    @PostMapping("/create")
    public Offers createOffers(@RequestBody Offers offers){
        return offersServiceImp.createOffer(offers);
    }

}
