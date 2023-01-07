package com.recruite.recruiting.controllers;


import com.recruite.recruiting.authResponse.AuthenticationResponse;
import com.recruite.recruiting.domains.Recruiter;
import com.recruite.recruiting.dto.AuthenticationRequest;
import com.recruite.recruiting.services.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;

@RestController
@RequestMapping("/api/v1/recruiter")
@RequiredArgsConstructor
@CrossOrigin
public class RecruiterController {

    private final RecruiterService recruiterService;
    @PostMapping("/login")
//    @PreAuthorize("hasAuthority('RECRUITER')")
    public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest){
        System.out.println(authenticationRequest.getEmail() + " Email");
        return ResponseEntity.ok().body(recruiterService.login(authenticationRequest));
    }
    @GetMapping("/allRecruiters")
//    @PreAuthorize("hasAuthority('RECRUITER')")
    public ResponseEntity<List<Recruiter>> login(){
        return ResponseEntity.ok().body(recruiterService.getAllRecruiters());
    }


}
