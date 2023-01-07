package com.recruite.recruiting.repository;

import com.recruite.recruiting.domains.Offers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffersRepository extends JpaRepository<Offers, Integer> {
}
