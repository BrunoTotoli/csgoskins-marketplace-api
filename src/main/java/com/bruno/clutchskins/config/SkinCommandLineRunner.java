package com.bruno.clutchskins.config;

import com.bruno.clutchskins.entities.Skin;
import com.bruno.clutchskins.entities.Weapon;
import com.bruno.clutchskins.entities.enums.Exterior;
import com.bruno.clutchskins.repositories.SkinRepository;
import com.bruno.clutchskins.repositories.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class SkinCommandLineRunner implements CommandLineRunner {

    @Autowired
    SkinRepository skinRepository;

    @Autowired
    WeaponRepository weaponRepository;

    @Override
    public void run(String... args) throws Exception {

        createWeapons();


    }

    private void createWeapons() {
        Weapon weaponSaved = weaponRepository.save(new Weapon(1L, "Ak-47", null));
        Skin savedSkin = skinRepository.save(
                new Skin(1L, "ASIMOV", "SkinBoat", 0.22F,
                        new BigDecimal("250.00"), false, false,
                        weaponSaved, Exterior.FIELDTESTED));
        weaponSaved.setSkins(Arrays.asList(savedSkin));
        weaponRepository.save(weaponSaved);

        Weapon weaponSaved1 = weaponRepository.save(new Weapon(2L, "USP", null));
        Skin savedSkin1 = skinRepository.save(
                new Skin(2L, "BLUEPRINT", "SkinBoat", 0.11F,
                        new BigDecimal("400.00"), false, false,
                        weaponSaved, Exterior.MINIMALWEAR));
        weaponSaved.setSkins(Arrays.asList(savedSkin1));
        weaponRepository.save(weaponSaved1);


        Weapon weaponSaved2 = weaponRepository.save(new Weapon(3L, "GLOCK", null));
        Skin savedSkin2 = skinRepository.save(
                new Skin(3L, "FUINHA", "SkinBoat", 0.31F,
                        new BigDecimal("11.00"), false, false,
                        weaponSaved2, Exterior.FIELDTESTED));
        weaponSaved2.setSkins(List.of(savedSkin2));
        weaponRepository.save(weaponSaved2);

        Weapon weaponSaved3 = weaponRepository.save(new Weapon(4L, "M4A1", null));
        Skin savedSkin3 = skinRepository.save(
                new Skin(4L, "HOWL", "SkinBoat", 0.05F,
                        new BigDecimal("25000.00"), false, false,
                        weaponSaved3, Exterior.FACTORYNEW));
        weaponSaved3.setSkins(List.of(savedSkin3));
        weaponRepository.save(weaponSaved3);

        Weapon weaponSaved4 = weaponRepository.save(new Weapon(5L, "AWP", null));
        Skin savedSkin4 = skinRepository.save(
                new Skin(5L, "DRAGON_LORE", "SkinBoat", 0.22F,
                        new BigDecimal("30000.00"), false, false,
                        weaponSaved4, Exterior.FIELDTESTED));
        weaponSaved4.setSkins(List.of(savedSkin4));
        weaponRepository.save(weaponSaved4);

        Weapon weaponSaved5 = weaponRepository.save(new Weapon(6L, "DEAGLE", null));
        Skin savedSkin5 = skinRepository.save(
                new Skin(6L, "BLAZE", "SkinBoat", 0.22F,
                        new BigDecimal("1500.00"), false, false,
                        weaponSaved5, Exterior.FIELDTESTED));
        weaponSaved5.setSkins(List.of(savedSkin5));
        weaponRepository.save(weaponSaved5);

        Weapon weaponSaved6 = weaponRepository.save(new Weapon(7L, "SCOUT", null));
        Skin savedSkin6 = skinRepository.save(
                new Skin(7L, "SCAUT", "SkinBoat", 0.22F,
                        new BigDecimal("250.00"), false, false,
                        weaponSaved6, Exterior.FIELDTESTED));
        weaponSaved6.setSkins(List.of(savedSkin6));
        weaponRepository.save(weaponSaved6);

        Weapon weaponSaved7 = weaponRepository.save(new Weapon(8L, "P250", null));
        Skin savedSkin7 = skinRepository.save(
                new Skin(8L, "TUBARAO", "SkinBoat", 0.22F,
                        new BigDecimal("250.00"), false, false,
                        weaponSaved7, Exterior.FIELDTESTED));
        weaponSaved7.setSkins(List.of(savedSkin7));
        weaponRepository.save(weaponSaved7);


        Skin savedSkin8 = skinRepository.save(
                new Skin(9L, "TUBARAO", "SkinBoat", 0.22F,
                        new BigDecimal("250.00"), false, false,
                        weaponSaved7, Exterior.FIELDTESTED));
        weaponSaved7.setSkins(List.of(savedSkin8));
        weaponRepository.save(weaponSaved7);

        Skin savedSkin9 = skinRepository.save(
                new Skin(10L, "TUBARAO", "SkinBoat", 0.22F,
                        new BigDecimal("250.00"), false, false,
                        weaponSaved7, Exterior.FIELDTESTED));
        weaponSaved7.setSkins(List.of(savedSkin9));

        Skin savedSkin10 = skinRepository.save(
                new Skin(11L, "TUBARAO", "SkinBoat", 0.22F,
                        new BigDecimal("250.00"), false, false,
                        weaponSaved7, Exterior.FIELDTESTED));



    }


}
