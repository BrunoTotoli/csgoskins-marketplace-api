package com.bruno.clutchskins.requests;

import com.bruno.clutchskins.entities.Weapon;
import com.bruno.clutchskins.entities.enums.Exterior;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@AllArgsConstructor
@Builder
@Data
public class SkinPostRequestBody {

    private String name;
    private String description;
    private Float skinFloat;
    private BigDecimal price;
    private Boolean souvenir;
    private Boolean stattrak;
    private Weapon weaponName;
    private Exterior exterior;

}
