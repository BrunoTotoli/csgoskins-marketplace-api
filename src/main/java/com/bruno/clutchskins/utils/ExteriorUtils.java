package com.bruno.clutchskins.utils;

import com.bruno.clutchskins.entities.enums.Exterior;
import com.bruno.clutchskins.exceptions.BadRequestException;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ExteriorUtils {

    public static Exterior createExteriorBySkinFloat(Float skinFloat) {
        if (skinFloat >= Exterior.FACTORYNEW.getMinFloat() && skinFloat <= Exterior.FACTORYNEW.getMaxFloat()) {
            return Exterior.FACTORYNEW;
        }
        if (skinFloat >= Exterior.MINIMALWEAR.getMinFloat() && skinFloat <= Exterior.MINIMALWEAR.getMaxFloat()) {
            return Exterior.MINIMALWEAR;
        }
        if (skinFloat >= Exterior.FIELDTESTED.getMinFloat() && skinFloat <= Exterior.FIELDTESTED.getMaxFloat()) {
            return Exterior.FIELDTESTED;
        }
        if (skinFloat >= Exterior.WELLWORN.getMinFloat() && skinFloat <= Exterior.WELLWORN.getMaxFloat()) {
            return Exterior.WELLWORN;
        }
        if (skinFloat >= Exterior.BATTLESCARED.getMinFloat() && skinFloat <= Exterior.BATTLESCARED.getMaxFloat()) {
            return Exterior.BATTLESCARED;
        }
        throw new BadRequestException("O FLOAT E INVALIDO");
    }

}
