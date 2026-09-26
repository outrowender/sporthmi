/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sds.evo;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.log.LogChannel;

class PopupMapperEvo {
    private static int[][] commandModeToPopupMappingID = new int[][]{{4, 102}, {2, 103}, {3, 104}, {1, 105}, {5, 106}, {0, 107}, {6, 108}, {8, 109}, {9, 110}, {10, 111}, {7, 112}};
    private static final int[][] helpModeToHelpPopupMappingID = new int[][]{{0, 120}, {4, 121}, {1, 122}, {2, 123}, {3, 124}, {5, 125}, {6, 126}, {7, 127}, {8, 128}, {9, 129}, {10, 130}, {11, 131}, {12, 132}, {13, 133}, {14, 134}, {15, 135}, {17, 136}, {18, 137}, {19, 138}, {20, 139}, {21, 140}, {16, 141}, {22, 142}, {23, 143}};
    private static final int[][] popupMappingToHMIPopup = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 11}, {4, 19}, {70, 1622018560}, {71, 1638795776}, {72, 1655572992}, {73, 1672350208}, {74, -275577856}, {75, -1030676224}, {76, -963567360}, {77, -997121792}, {44, -1961228800}, {40, -2145778176}, {41, -1994783232}, {42, -2011560448}, {43, -1978006016}, {45, -1944451584}, {46, -1927674368}, {50, -1877342720}, {51, -1860565504}, {47, -132512256}, {48, -820378112}, {49, -65403392}, {101, 14}, {113, 18}, {11, -1517944576}, {10, -1517944576}, {1000, 15}, {20, 1192035072}, {30, -325909504}, {114, 20}, {115, -527236096}, {78, -946790144}, {52, -1827011072}, {102, 12}, {103, 1208812288}, {104, -393018368}, {105, -1534721792}, {106, -2028337664}, {107, -2045114880}, {108, 1612194560}, {109, -1064230656}, {110, -1047453440}, {111, 1662526208}, {112, -936965888}, {120, 1175257856}, {121, 1108148992}, {122, 1158480640}, {123, 1141703424}, {124, 1124926208}, {125, -1601830656}, {126, -1551499008}, {127, -1585053440}, {126, -1568276224}, {129, -2129000960}, {130, -2095446528}, {131, -2061892096}, {132, -2078669312}, {133, -409795584}, {134, -510458880}, {135, -493681664}, {136, -460127232}, {137, -443350016}, {138, -426572800}, {139, 10}, {140, -2112223744}, {141, -970520320}, {142, 1628971776}, {143, 1645748992}, {128, -1568276224}, {100, 13}, {80, 30}, {81, 31}, {82, 32}, {83, 33}, {84, 34}, {85, 35}, {86, 36}, {87, 37}, {88, 38}, {89, 39}, {90, 40}};
    private static final int[] bigCommandPopups = new int[]{12, 1208812288, -393018368, -1534721792, -2028337664, -2045114880, 1612194560, -936965888, -1064230656, -1047453440, 1662526208};
    private static final int[] furtherCommandPopups = new int[]{13, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
    private static final int[] disambiguationPopups = new int[]{14, 18};

    PopupMapperEvo() {
    }

    static int getCommandScreenPopupMapping(int n, LogChannel logChannel) {
        logChannel.log(-2137614336, "PopupMapper#getCommandScreenPopup: commandMode=%1", (long)n);
        int n2 = SDSUtils.translate(n, commandModeToPopupMappingID);
        return n2 == 128 ? -1 : n2;
    }

    static int getHelpScreenPopupMapping(int n, LogChannel logChannel) {
        logChannel.log(-2137614336, "PopupMapper#getHelpScreenPopup: listMode=%1", (long)n);
        int n2 = SDSUtils.translate(n, helpModeToHelpPopupMappingID);
        return n2 == 128 ? -1 : n2;
    }

    static int getPopupID(int n) {
        int n2 = SDSUtils.translate(n, popupMappingToHMIPopup);
        return n2 == 128 ? -1 : n2;
    }

    static int getPopupMappingID(int n) {
        int n2 = SDSUtils.reverseTranslate(n, popupMappingToHMIPopup);
        return n2 == 128 ? -1 : n2;
    }

    static int[] getSDSPopups() {
        int[] nArray = new int[popupMappingToHMIPopup.length];
        for (int i2 = 0; i2 < popupMappingToHMIPopup.length; ++i2) {
            nArray[i2] = popupMappingToHMIPopup[i2][1];
        }
        return nArray;
    }

    static boolean isSDSPopup(int n) {
        return 128 != SDSUtils.reverseTranslate(n, popupMappingToHMIPopup);
    }

    static int[] getBigCommandPopups() {
        return bigCommandPopups;
    }

    static int[] getFurtherCommandPopups() {
        return furtherCommandPopups;
    }

    static int[] getDisambiguationPopups() {
        return disambiguationPopups;
    }
}

