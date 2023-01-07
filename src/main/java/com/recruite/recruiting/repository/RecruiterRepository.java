package com.recruite.recruiting.repository;

import com.recruite.recruiting.domains.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RecruiterRepository extends JpaRepository<Recruiter, Integer> {

    Optional<Recruiter> findByEmail(String email);

}
