/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.sds;

public class SUIGrammars {
    public static final int SUI_TYPE_NONE;
    public static final int SUI_TYPE_TRUFFLE_INITIAL;
    public static final int SUI_TYPE_POI_CITY;
    public static final int SUI_TYPE_ADDRESS;
    public static final int SUI_TYPE_POI;
    public static final int SUI_TYPE_CONTACT;

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
                return new int[]{18613760};
            }
            case 1: {
                return new int[]{-451213824, -2128935424, 2082145792};
            }
            case 2: {
                return new int[]{-499840000, -516617216, -533394432, -2112158208, -1875571712, -1892348928, -1909126144, 1848970240, 1865747456, 1832193024, 1142621696, 1327171072};
            }
            case 3: {
                return new int[]{-2145712640, 1276839424, 1343948288};
            }
            case 4: {
                return new int[]{1931150848, 1125844480, 1310393856};
            }
        }
        return new int[0];
    }

    public static final int[] getSUITypes() {
        return new int[]{0, 1, 2, 3, 4};
    }
}

