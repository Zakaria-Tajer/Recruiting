package com.recruite.recruiting.config;

import com.recruite.recruiting.interceptor.JwtInterceptor;
import com.recruite.recruiting.security.JwtService;
import com.recruite.recruiting.services.RecruiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebConfiguration implements WebMvcConfigurer {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final RecruiterService recruiterService;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("hello from interceptor");
        registry.addInterceptor(new JwtInterceptor(jwtService, userDetailsService, recruiterService));
    }
}
