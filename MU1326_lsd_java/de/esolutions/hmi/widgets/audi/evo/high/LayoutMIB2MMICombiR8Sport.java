/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2MMICombiTT;

public class LayoutMIB2MMICombiR8Sport
extends LayoutMIB2MMICombiTT {
    private static final int DISPLAYABLE_BROWSER_ID = 18;
    private static final int DISPLAYABLE_BROWSER_OFFSET = -16;

    public int getIntegerConstant(int n) {
        switch (n) {
            case 80: {
                return -446;
            }
            case 81: {
                return -22;
            }
            case 82: {
                return 0;
            }
            case 83: {
                return -16;
            }
            case 84: {
                return -440;
            }
            case 85: {
                return -26;
            }
            case 86: {
                return 0;
            }
            case 87: {
                return -16;
            }
            case 88: {
                return -446;
            }
            case 89: {
                return 0;
            }
            case 90: {
                return 0;
            }
            case 91: {
                return -16;
            }
            case 58: {
                return 991;
            }
            case 59: {
                return 137;
            }
            case 60: {
                return 1105;
            }
            case 61: {
                return 114;
            }
            case 62: {
                return -400;
            }
            case 92: {
                return 32;
            }
            case 93: {
                return 3;
            }
            case 95: {
                return 20;
            }
            case 103: {
                return -39;
            }
            case 104: {
                return 33;
            }
            case 99: {
                return -47;
            }
            case 100: {
                return 38;
            }
            case 101: {
                return 40;
            }
            case 102: {
                return 33;
            }
            case 97: {
                return 47;
            }
            case 98: {
                return 38;
            }
            case 108: {
                return 0;
            }
            case 109: {
                return -15;
            }
            case 107: {
                return HMIImageConstantsSystem.kdk_background_r8_sport_small_stage;
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

    public int[] getDisplayablePosition(int n) {
        if (n == 18) {
            return new int[]{0, -16};
        }
        return new int[]{0, 0};
    }
}

