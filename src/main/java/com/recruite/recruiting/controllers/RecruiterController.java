package com.recruite.recruiting.controllers;


import com.recruite.recruiting.authResponse.AuthenticationResponse;
import com.recruite.recruiting.domains.Recruiter;
import com.recruite.recruiting.dto.AuthenticationRequest;
import com.recruite.recruiting.dto.RecruiterDto;
import com.recruite.recruiting.email.EmailSevice;
import com.recruite.recruiting.repository.RecruiterRepository;
import com.recruite.recruiting.services.RecruiterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.Authenticator;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/recruiter")
@RequiredArgsConstructor
@CrossOrigin
@Slf4j
public class RecruiterController {

    private final RecruiterService recruiterService;
    private final RecruiterRepository recruiterRepository;
    private final EmailSevice emailSevice;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) {
        return ResponseEntity.ok().body(recruiterService.login(authenticationRequest));
    }

    @GetMapping("/allRecruiters")
    public ResponseEntity<List<Recruiter>> allRecruiters() {
        return ResponseEntity.ok().body(recruiterService.getAllRecruiters());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAnAccount(@RequestBody @Valid Recruiter recruiter) {

        Optional<Recruiter> getRecruiterByEmail = recruiterRepository.findByEmail(recruiter.getEmail());

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        if (getRecruiterByEmail.isEmpty()) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    emailSevice.sendMail("za.tajer@gmail.com", "account confirmation", "you're account has been confirmed");
                }
            });
            return ResponseEntity.ok().body(recruiterService.addARecruiter(recruiter));
        }
        return ResponseEntity.badRequest().body(new AuthenticationResponse(null, Date.from(Instant.now()), 400, "error", "Email is already taken"));

    }


}
