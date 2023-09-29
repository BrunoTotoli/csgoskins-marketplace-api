package com.bruno.clutchskins.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
public class SkinPostRequestBody {
    @NotBlank
    private String name;
    private String description;
    @NotNull
    private Float skinFloat;
    private BigDecimal price;
    private Boolean souvenir;
    private Boolean stattrak;
}
