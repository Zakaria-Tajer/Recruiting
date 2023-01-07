package com.recruite.recruiting.authResponse;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data

public class AuthenticationResponse {
    private String token;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    public AuthenticationResponse(String token, Date timestamp, int code, String status, String message) {
        this.token = token;
        this.timestamp = timestamp;
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
