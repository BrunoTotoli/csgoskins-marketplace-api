package com.bruno.clutchskins.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Data
@Builder
public class SkinPutRequestBody {
    private Long id;
    private String name;
    private String description;
    private Float skinFloat;
    private BigDecimal price;
    private Boolean souvenir;
    private Boolean stattrak;


}
