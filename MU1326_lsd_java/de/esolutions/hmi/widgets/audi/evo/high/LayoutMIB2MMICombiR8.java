/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.esolutions.hmi.widgets.audi.evo.high.LayoutMIB2MMICombiTT;

public class LayoutMIB2MMICombiR8
extends LayoutMIB2MMICombiTT {
    private static final int DISPLAYABLE_BROWSER_ID;
    private static final int DISPLAYABLE_BROWSER_OFFSET;

    @Override
    public int getIntegerConstant(int n) {
        switch (n) {
            case 80: {
                return 0;
            }
            case 81: {
                return -16;
            }
            case 82: {
                return 0;
            }
            case 83: {
                return -16;
            }
            case 84: {
                return 0;
            }
            case 85: {
                return -16;
            }
            case 86: {
                return 0;
            }
            case 87: {
                return -16;
            }
            case 88: {
                return 0;
            }
            case 89: {
                return -16;
            }
            case 90: {
                return 0;
            }
            case 91: {
                return -16;
            }
            case 58: {
                return 1050;
            }
            case 59: {
                return 199;
            }
            case 60: {
                return 1105;
            }
            case 61: {
                return 114;
            }
            case 62: {
                return 0;
            }
            case 92: {
                return 0;
            }
            case 93: {
                return 0;
            }
            case 95: {
                return 0;
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
        }
        return super.getIntegerConstant(n);
    }

    @Override
    public int[] getDisplayablePosition(int n) {
        if (n == 18) {
            return new int[]{0, -16};
        }
        return new int[]{0, 0};
    }
}

