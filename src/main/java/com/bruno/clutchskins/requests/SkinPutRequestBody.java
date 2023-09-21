package com.bruno.clutchskins.requests;

import com.bruno.clutchskins.entities.Category;
import com.bruno.clutchskins.entities.Weapon;
import com.bruno.clutchskins.entities.enums.Exterior;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
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
    private Weapon weaponName;
    @Enumerated
    private Exterior exterior;
    private Category category;


}
