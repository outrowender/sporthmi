/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sds;

public class SlotGrammars {
    public static final int SG_TYPE_NONE = -1;
    public static final int SG_TYPE_TITLE = 0;
    public static final int SG_TYPE_ALBUM = 1;
    public static final int SG_TYPE_ARTIST = 2;
    public static final int SG_TYPE_CONTACTCARD = 3;

    public static int getSlotTypeForSlot(int n) {
        switch (n) {
            case 200028: {
                return 0;
            }
            case 200030: {
                return 1;
            }
            case 200026: {
                return 2;
            }
            case 700000: {
                return 3;
            }
        }
        return -1;
    }

    public static final int[] getSlotsForType(int n) {
        switch (n) {
            case 0: {
                return new int[]{200028};
            }
            case 1: {
                return new int[]{200030};
            }
            case 2: {
                return new int[]{200026};
            }
            case 3: {
                return new int[]{700000};
            }
        }
        return new int[0];
    }

    public static final int[] getSlotTypes() {
        return new int[]{0, 1, 2, 3};
    }
}

