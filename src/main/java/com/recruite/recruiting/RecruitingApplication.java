package com.recruite.recruiting;

import com.recruite.recruiting.domains.Offers;
import com.recruite.recruiting.domains.Recruiter;
import com.recruite.recruiting.enums.OffersStatus;
import com.recruite.recruiting.enums.Role;
import com.recruite.recruiting.security.ApplicationConfig;
import com.recruite.recruiting.services.RecruiterService;
import com.recruite.recruiting.services.offers.OffersService;
import com.recruite.recruiting.services.offers.OffersServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@AllArgsConstructor

public class RecruitingApplication {


    private final RecruiterService recruiterService;
    private final OffersServiceImp offersServiceImp;
    private final ApplicationConfig applicationConfig;

    public static void main(String[] args) {
        SpringApplication.run(RecruitingApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(RecruiterService recruiterService, OffersServiceImp offersServiceImp) {

        return args -> {
            recruiterService.addARecruiter(
                    new Recruiter(
                            1,
                            "zk@gmail.com",
                            "katlife",
                            "0631703116",
                            "https://www.google.com/url?sa=i&url=https%3A%2F%2Fcomicbook.com%2Fgaming%2Fnews%2Fleague-of-legends-yasuo-origins%2F&psig=AOvVaw3ZLFuDeULVFofHlnOSDCcN&ust=1672413657822000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCJia9MGQn_wCFQAAAAAdAAAAABAJ",
                            Role.RECRUITER,
                            null
                    )

			);

            offersServiceImp.createOffer(
                    new Offers(
                            1,
                            "comicbook",
                            "random shit",
                            "dev",
                            "rabat",
                            "dosnt matter",
                            10000,
                            OffersStatus.UNPUBLISHED,
                            null
                    )
            );

        };
    }

}
