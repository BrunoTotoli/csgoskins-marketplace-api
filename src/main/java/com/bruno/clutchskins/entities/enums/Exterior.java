package com.bruno.clutchskins.entities.enums;

public enum Exterior {
    FACTORYNEW(0.00F, 0.07F),
    MINIMALWEAR(0.07F, 0.15F),
    FIELDTESTED(0.15F, 0.37F),
    WELLWORN(0.37F, 0.44F),
    BATTLESCARED(0.44F, 1.00F);

    final float minFloat;
    final float maxFloat;

    Exterior(float minFloat, float maxFloat) {
        this.minFloat = minFloat;
        this.maxFloat = maxFloat;
    }

    public float getMinFloat() {
        return minFloat;
    }

    public float getMaxFloat() {
        return maxFloat;
    }
}
