package com.recruite.recruiting.repository;

import com.recruite.recruiting.domains.Offers;
import com.recruite.recruiting.enums.OffersStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

public interface OffersRepository extends JpaRepository<Offers, Integer> {
    @Query("select count(e) from Offers e where e.status = ?1")
    Long countOffersByStatus(OffersStatus status);


}
