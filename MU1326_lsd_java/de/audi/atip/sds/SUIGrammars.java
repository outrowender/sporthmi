/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sds;

public class SUIGrammars {
    public static final int SUI_TYPE_NONE = -1;
    public static final int SUI_TYPE_TRUFFLE_INITIAL = 0;
    public static final int SUI_TYPE_POI_CITY = 1;
    public static final int SUI_TYPE_ADDRESS = 2;
    public static final int SUI_TYPE_POI = 3;
    public static final int SUI_TYPE_CONTACT = 4;

    public static int getSUITypeForRule(int n) {
        switch (n) {
            case 400385: {
                return 0;
            }
            case 400357: {
                return 1;
            }
            case 800226: {
                return 2;
            }
            case 800225: {
                return 2;
            }
            case 800224: {
                return 2;
            }
            case 400256: {
                return 3;
            }
            case 400257: {
                return 1;
            }
            case 400258: {
                return 2;
            }
            case 800144: {
                return 2;
            }
            case 800143: {
                return 2;
            }
            case 800142: {
                return 2;
            }
            case 400243: {
                return 4;
            }
            case 400252: {
                return 1;
            }
            case 800110: {
                return 2;
            }
            case 800111: {
                return 2;
            }
            case 800109: {
                return 2;
            }
            case 400196: {
                return 2;
            }
            case 400195: {
                return 4;
            }
            case 400204: {
                return 3;
            }
            case 400207: {
                return 2;
            }
            case 400206: {
                return 4;
            }
            case 400208: {
                return 3;
            }
        }
        return -1;
    }

    public static final int[] getRulesForType(int n) {
        switch (n) {
            case 0: {
                return new int[]{400385};
            }
            case 1: {
                return new int[]{400357, 400257, 400252};
            }
            case 2: {
                return new int[]{800226, 800225, 800224, 400258, 800144, 800143, 800142, 800110, 800111, 800109, 400196, 400207};
            }
            case 3: {
                return new int[]{400256, 400204, 400208};
            }
            case 4: {
                return new int[]{400243, 400195, 400206};
            }
        }
        return new int[0];
    }

    public static final int[] getSUITypes() {
        return new int[]{0, 1, 2, 3, 4};
    }
}

