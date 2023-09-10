package com.bruno.clutchskins.entities;

import com.bruno.clutchskins.entities.enums.Exterior;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_skin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private float skinFloat;
    private BigDecimal price;
    private Boolean souvenir;
    private Boolean stattrak;
    @ManyToOne
    private Weapon weaponName;
    @Enumerated(EnumType.STRING)
    private Exterior exterior;

}
