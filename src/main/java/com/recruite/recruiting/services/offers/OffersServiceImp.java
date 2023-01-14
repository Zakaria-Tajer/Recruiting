package com.recruite.recruiting.services.offers;

import com.recruite.recruiting.domains.Offers;
import com.recruite.recruiting.dto.GetOffersStatus;
import com.recruite.recruiting.dto.OffersCounts;
import com.recruite.recruiting.repository.OffersRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class OffersServiceImp implements OffersService{

    private final OffersRepository offersRepository;
    @Override
    public List<Offers> getAllOffers() {
        return offersRepository.findAll();
    }

    @Override
    public Long getOffersCount(GetOffersStatus status) {


        return offersRepository.countOffersByStatus(status.getStatus());
    }



    @Override
    public Offers createOffer(Offers offers) {
        return offersRepository.save(offers);
    }
}
