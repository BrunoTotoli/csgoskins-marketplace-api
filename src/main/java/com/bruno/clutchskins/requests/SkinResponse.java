package com.bruno.clutchskins.requests;

import com.bruno.clutchskins.entities.enums.Exterior;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@Builder
public class SkinResponse {

    private Long id;
    private String name;
    private String description;
    private Float skinFloat;
    private BigDecimal price;
    private Boolean souvenir;
    private Boolean stattrak;
    private Exterior exterior;
    private String weapon;

}
