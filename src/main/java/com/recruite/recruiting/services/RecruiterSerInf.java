package com.recruite.recruiting.services;

import com.recruite.recruiting.authResponse.AuthTokenResponse;
import com.recruite.recruiting.authResponse.AuthenticationResponse;
import com.recruite.recruiting.domains.Offers;
import com.recruite.recruiting.domains.Recruiter;
import com.recruite.recruiting.dto.AuthenticationRequest;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface RecruiterSerInf {
    Recruiter addARecruiter(Recruiter recruiter);
    AuthenticationResponse login(AuthenticationRequest authenticationRequest);
    List<Recruiter> getAllRecruiters();
    ResponseEntity<Offers> addAnOffer(Offers offer);

    AuthTokenResponse isTokenValid(boolean isTokenValid, Date timestamp, int code , String status, String message);
}
