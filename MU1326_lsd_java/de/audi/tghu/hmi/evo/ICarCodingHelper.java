/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface ICarCodingHelper {
    public static final int CAR_TYPE_UNKNOWN = -1;
    public static final int CAR_TYPE_Q7 = 10;
    public static final int CAR_TYPE_Q7_PHEV = 11;
    public static final int CAR_TYPE_Q5 = 12;
    public static final int CAR_TYPE_Q2 = 13;
    public static final int CAR_TYPE_Q5_PHEV = 14;
    public static final int CAR_TYPE_TT = 20;
    public static final int CAR_TYPE_TT_ROADSTER = 21;
    public static final int CAR_TYPE_B9_LIMO = 30;
    public static final int CAR_TYPE_B9_AVANT = 31;
    public static final int CAR_TYPE_B9_ALLROAD = 32;
    public static final int CAR_TYPE_B9_SPORTBACK = 33;
    public static final int CAR_TYPE_B9_COUPE = 34;
    public static final int CAR_TYPE_B9_CABRIO = 35;
    public static final int CAR_TYPE_R8_COUPE = 40;
    public static final int CAR_TYPE_R8PA_COUPE = 41;
    public static final int CAR_TYPE_R8_SPIDER = 42;
    public static final int CAR_TYPE_R8PA_SPIDER = 43;
    public static final int CAR_TYPE_R8_ETRON = 44;
    public static final int CAR_TYPE_A3_KURZHECK = 50;
    public static final int CAR_TYPE_A3_LIMO = 51;
    public static final int CAR_TYPE_A3_SPORTBACK = 52;
    public static final int CAR_TYPE_A3_CABRIO = 53;
    public static final int CAR_TYPE_A3_PHEV = 54;

    public int getCarType();

    public String getKanziCarID();

    public boolean hasGyro();

    public boolean isR8orTT();

    public boolean isR8();

    public boolean isB9();

    public boolean isTT();

    public boolean isPHEVCar();

    public boolean isQ7();

    public boolean isA3();

    public boolean isQ2();

    public boolean isQ5();
}

