package com.bruno.clutchskins.repositories;

import com.bruno.clutchskins.entities.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepository extends JpaRepository<Weapon, Long> {
}
