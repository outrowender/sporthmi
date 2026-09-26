/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2HighScaleA3;

public class LayoutMIB2HighScaleA3Sport
extends LayoutMIB2HighScaleA3 {
    @Override
    public int getIntegerConstant(int n) {
        switch (n) {
            case 80: {
                return -476;
            }
            case 58: {
                return 984;
            }
            case 59: {
                return 139;
            }
            case 122: {
                return 0;
            }
            case 123: {
                return 0;
            }
            case 124: {
                return 328;
            }
            case 125: {
                return 180;
            }
        }
        return super.getIntegerConstant(n);
    }
}

