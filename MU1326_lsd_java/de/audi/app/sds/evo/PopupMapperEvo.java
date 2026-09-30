/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sds.evo;

import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.log.LogChannel;

class PopupMapperEvo {
    private static int[][] commandModeToPopupMappingID = new int[][]{{4, 102}, {2, 103}, {3, 104}, {1, 105}, {5, 106}, {0, 107}, {6, 108}, {8, 109}, {9, 110}, {10, 111}, {7, 112}};
    private static final int[][] helpModeToHelpPopupMappingID = new int[][]{{0, 120}, {4, 121}, {1, 122}, {2, 123}, {3, 124}, {5, 125}, {6, 126}, {7, 127}, {8, 128}, {9, 129}, {10, 130}, {11, 131}, {12, 132}, {13, 133}, {14, 134}, {15, 135}, {17, 136}, {18, 137}, {19, 138}, {20, 139}, {21, 140}, {16, 141}, {22, 142}, {23, 143}};
    private static final int[][] popupMappingToHMIPopup = new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 11}, {4, 19}, {70, 700000}, {71, 700001}, {72, 700002}, {73, 700003}, {74, 300015}, {75, 2200002}, {76, 2200006}, {77, 2200004}, {44, 400011}, {40, 400000}, {41, 400009}, {42, 400008}, {43, 400010}, {45, 400012}, {46, 400013}, {50, 400016}, {51, 400017}, {47, 400120}, {48, 400079}, {49, 400124}, {101, 14}, {113, 18}, {11, 100005}, {10, 100005}, {1000, 15}, {20, 200007}, {30, 300012}, {114, 20}, {115, 300000}, {78, 2200007}, {52, 400019}, {102, 12}, {103, 200008}, {104, 300008}, {105, 100004}, {106, 400007}, {107, 400006}, {108, 2300000}, {109, 2200000}, {110, 2200001}, {111, 2300003}, {112, 600008}, {120, 200006}, {121, 200002}, {122, 200005}, {123, 200004}, {124, 200003}, {125, 100000}, {126, 100003}, {127, 100001}, {126, 100002}, {129, 400001}, {130, 400003}, {131, 400005}, {132, 400004}, {133, 300007}, {134, 300001}, {135, 300002}, {136, 300004}, {137, 300005}, {138, 300006}, {139, 10}, {140, 400002}, {141, 600006}, {142, 2300001}, {143, 2300002}, {128, 100002}, {100, 13}, {80, 30}, {81, 31}, {82, 32}, {83, 33}, {84, 34}, {85, 35}, {86, 36}, {87, 37}, {88, 38}, {89, 39}, {90, 40}};
    private static final int[] bigCommandPopups = new int[]{12, 200008, 300008, 100004, 400007, 400006, 2300000, 600008, 2200000, 2200001, 2300003};
    private static final int[] furtherCommandPopups = new int[]{13, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40};
    private static final int[] disambiguationPopups = new int[]{14, 18};

    PopupMapperEvo() {
    }

    static int getCommandScreenPopupMapping(int n, LogChannel logChannel) {
        logChannel.log(10000000, "PopupMapper#getCommandScreenPopup: commandMode=%1", (long)n);
        int n2 = SDSUtils.translate(n, commandModeToPopupMappingID);
        return n2 == Integer.MIN_VALUE ? -1 : n2;
    }

    static int getHelpScreenPopupMapping(int n, LogChannel logChannel) {
        logChannel.log(10000000, "PopupMapper#getHelpScreenPopup: listMode=%1", (long)n);
        int n2 = SDSUtils.translate(n, helpModeToHelpPopupMappingID);
        return n2 == Integer.MIN_VALUE ? -1 : n2;
    }

    static int getPopupID(int n) {
        int n2 = SDSUtils.translate(n, popupMappingToHMIPopup);
        return n2 == Integer.MIN_VALUE ? -1 : n2;
    }

    static int getPopupMappingID(int n) {
        int n2 = SDSUtils.reverseTranslate(n, popupMappingToHMIPopup);
        return n2 == Integer.MIN_VALUE ? -1 : n2;
    }

    static int[] getSDSPopups() {
        int[] nArray = new int[popupMappingToHMIPopup.length];
        for (int i2 = 0; i2 < popupMappingToHMIPopup.length; ++i2) {
            nArray[i2] = popupMappingToHMIPopup[i2][1];
        }
        return nArray;
    }

    static boolean isSDSPopup(int n) {
        return Integer.MIN_VALUE != SDSUtils.reverseTranslate(n, popupMappingToHMIPopup);
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

