package com.bruno.clutchskins.exceptions;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ExceptionDetails {
    private String title;
    private int status;
    private String errorMessage;
    private String errorClass;
    private LocalDateTime timestamp;

}
