package com.bruno.clutchskins.repositories;

import com.bruno.clutchskins.entities.Skin;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SkinRepository extends JpaRepository<Skin, Long> {
}
