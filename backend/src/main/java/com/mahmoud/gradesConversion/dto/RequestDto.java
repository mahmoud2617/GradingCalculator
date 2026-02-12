package com.mahmoud.gradesConversion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class RequestDto {
    @NotNull(message = "Value is Required.")
    @NotBlank(message = "Value cannot be empty.")
    private String value;

    private String from;
    private String to;
    private String fromTextContent;
}
