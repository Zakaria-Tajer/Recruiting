package com.recruite.recruiting.services;

import com.recruite.recruiting.authResponse.AuthTokenResponse;
import com.recruite.recruiting.authResponse.AuthenticationResponse;
import com.recruite.recruiting.domains.Offers;
import com.recruite.recruiting.domains.Recruiter;
import com.recruite.recruiting.dto.AuthenticationRequest;
import com.recruite.recruiting.repository.OffersRepository;
import com.recruite.recruiting.repository.RecruiterRepository;
import com.recruite.recruiting.security.ApplicationConfig;
import com.recruite.recruiting.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.*;


@Service
@RequiredArgsConstructor
public class RecruiterService implements RecruiterSerInf{

    private final RecruiterRepository recruiterRepository;
    private final OffersRepository offersRepository;
    private final AuthenticationManager authenticationManager;
    private final ApplicationConfig applicationConfig;


    private final JwtService jwtService;
    @Override
    public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {

        Optional<Recruiter> recruiter = recruiterRepository.findByEmail(authenticationRequest.getEmail());

        if(recruiter.isEmpty()){
            return new AuthenticationResponse(null, Date.from(Instant.now()),400, "error","unauthenticated");
        }else if(!applicationConfig.passwordEncoder().matches(authenticationRequest.getPassword(), recruiter.get().getPassword())){
            return new AuthenticationResponse(null, Date.from(Instant.now()),400, "error","wrong password");

        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()
                )
        );
        String jwtToken = jwtService.generateToken(recruiter.get());

        return new AuthenticationResponse(jwtToken, Date.from(Instant.now()),200, "success","authenticated");

    }
    @Override
    public ResponseEntity<Offers> addAnOffer(Offers offer) {
        return ResponseEntity.ok().body(offersRepository.save(offer));
    }

    @Override
    public AuthTokenResponse isTokenValid(boolean isTokenValid, Date timestamp,int code ,String status, String message) {
        return new AuthTokenResponse(isTokenValid, timestamp, code, status, message);
    }

    @Override
    public List<Recruiter> getAllRecruiters() {
        return recruiterRepository.findAll();
    }


    @Override
    public Recruiter addARecruiter(Recruiter recruiter) {

        recruiter.setPassword(applicationConfig.passwordEncoder().encode(recruiter.getPassword()));
        return recruiterRepository.save(recruiter);

    }





}
