/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface ICarCodingHelper {
    public static final int CAR_TYPE_UNKNOWN;
    public static final int CAR_TYPE_Q7;
    public static final int CAR_TYPE_Q7_PHEV;
    public static final int CAR_TYPE_Q5;
    public static final int CAR_TYPE_Q2;
    public static final int CAR_TYPE_Q5_PHEV;
    public static final int CAR_TYPE_TT;
    public static final int CAR_TYPE_TT_ROADSTER;
    public static final int CAR_TYPE_B9_LIMO;
    public static final int CAR_TYPE_B9_AVANT;
    public static final int CAR_TYPE_B9_ALLROAD;
    public static final int CAR_TYPE_B9_SPORTBACK;
    public static final int CAR_TYPE_B9_COUPE;
    public static final int CAR_TYPE_B9_CABRIO;
    public static final int CAR_TYPE_R8_COUPE;
    public static final int CAR_TYPE_R8PA_COUPE;
    public static final int CAR_TYPE_R8_SPIDER;
    public static final int CAR_TYPE_R8PA_SPIDER;
    public static final int CAR_TYPE_R8_ETRON;
    public static final int CAR_TYPE_A3_KURZHECK;
    public static final int CAR_TYPE_A3_LIMO;
    public static final int CAR_TYPE_A3_SPORTBACK;
    public static final int CAR_TYPE_A3_CABRIO;
    public static final int CAR_TYPE_A3_PHEV;

    default public int getCarType() {
    }

    default public String getKanziCarID() {
    }

    default public boolean hasGyro() {
    }

    default public boolean isR8orTT() {
    }

    default public boolean isR8() {
    }

    default public boolean isB9() {
    }

    default public boolean isTT() {
    }

    default public boolean isPHEVCar() {
    }

    default public boolean isQ7() {
    }

    default public boolean isA3() {
    }

    default public boolean isQ2() {
    }

    default public boolean isQ5() {
    }
}

