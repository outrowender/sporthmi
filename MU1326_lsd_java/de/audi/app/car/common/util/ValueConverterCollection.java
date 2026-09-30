/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

public class ValueConverterCollection {
    public static final int INVALID = -1;

    public static int convertTemperatureUnitHMI2DSI(int n) {
        int n2;
        switch (n) {
            case 1: {
                n2 = 0;
                break;
            }
            case 2: {
                n2 = 1;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }

    protected int convertTemperatureUnitDSI2HMI(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 1;
                break;
            }
            case 1: {
                n2 = 2;
                break;
            }
            default: {
                n2 = -1;
            }
        }
        return n2;
    }
}

