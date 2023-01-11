package com.recruite.recruiting.execptionHandler.execptionsData;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;


@Data
@AllArgsConstructor
public class BodyMissingExecption {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;

    private int code;

    private HttpStatus status;

    private String message;

}
