package com.recruite.recruiting.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.recruite.recruiting.authResponse.AuthTokenResponse;
import com.recruite.recruiting.authResponse.AuthenticationResponse;
import com.recruite.recruiting.security.JwtService;
import com.recruite.recruiting.services.RecruiterService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.bridge.Message;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.time.Instant;
import java.util.Date;
import java.util.Objects;


@Slf4j
@Component
@AllArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {


    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    private final RecruiterService recruiterService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

//        log.info("preHandle invoked: " + " " + request.getRequestURI().toString());
//
//        if (!Objects.equals(request.getRequestURI(), "/api/v1/recruiter/login")) {
//
//            String token = request.getHeader("Authorization").substring(7);
//
//            String email = jwtService.extractUsername(token);
//
//            UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//
//
//            boolean tokenIsValid = jwtService.isTokenValid(token,userDetails);
//
//            if(tokenIsValid){
//                System.out.println("it is valid baiitch");
//                recruiterService.isTokenValid(tokenIsValid, Date.from(Instant.now()), 200, "success" ,"auth");
//            }
//
//            return tokenIsValid;
//
//
//
//        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
