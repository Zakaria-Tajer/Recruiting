package com.recruite.recruiting.services.offers;

import com.recruite.recruiting.domains.Offers;
//import com.recruite.recruiting.dto.Offers
import com.recruite.recruiting.dto.GetOffersStatus;
import com.recruite.recruiting.dto.OffersCounts;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface OffersService {

    List<Offers> getAllOffers();
    Long getOffersCount(GetOffersStatus status);

    Offers createOffer(Offers offers);
}
