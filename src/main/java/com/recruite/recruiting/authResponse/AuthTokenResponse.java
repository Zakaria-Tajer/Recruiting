package com.recruite.recruiting.authResponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class AuthTokenResponse extends Throwable {


    private boolean tokenIsValid;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private String status;

    private String message;

    public AuthTokenResponse(boolean tokenIsValid, Date timestamp, int code, String status, String message) {
        this.tokenIsValid = tokenIsValid;
        this.timestamp = timestamp;
        this.code = code;
        this.status = status;
        this.message = message;
    }
}
