/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd;

public class LangCodeMap {
    private static final int[][] langCodeMappingDSI = new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}, {8, 8}, {9, 9}, {10, 10}, {11, 11}, {12, 12}, {13, 13}, {14, 14}, {15, 15}, {16, 16}, {17, 17}, {18, 18}, {19, 19}, {20, 20}, {21, 21}, {22, 22}, {23, 23}};

    public static int getDSILangCode(int n) {
        int n2 = 0;
        for (int i2 = 0; i2 < langCodeMappingDSI.length; ++i2) {
            if (langCodeMappingDSI[i2][1] != n) continue;
            n2 = langCodeMappingDSI[i2][0];
            break;
        }
        return n2;
    }
}

