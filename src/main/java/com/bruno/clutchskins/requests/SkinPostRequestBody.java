package com.bruno.clutchskins.requests;

import com.bruno.clutchskins.entities.Category;
import com.bruno.clutchskins.entities.Weapon;
import com.bruno.clutchskins.entities.enums.Exterior;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    private Float skinFloat;
    private BigDecimal price;
    private Boolean souvenir;
    private Boolean stattrak;
    private Weapon weaponName;
    private Exterior exterior;
    private Category category;

}
