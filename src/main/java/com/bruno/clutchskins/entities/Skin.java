package com.bruno.clutchskins.entities;

import com.bruno.clutchskins.entities.enums.Exterior;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private Float skinFloat;
    private BigDecimal price;
    private Boolean souvenir;
    private Boolean stattrak;

    @ManyToOne
    @JoinColumn(name = "weapon_id")
    private Weapon weaponName;

    @Enumerated(EnumType.STRING)
    private Exterior exterior;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

}
