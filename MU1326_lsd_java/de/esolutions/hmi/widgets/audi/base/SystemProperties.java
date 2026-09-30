/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import java.util.StringTokenizer;

public class SystemProperties {
    public static final String IMAGE_ROOT = "ImageRoot";
    public static final String STANDARD_FONT_PLAIN = "STANDARD_FONT_PLAIN";
    public static final String STANDARD_FONT_BOLD = "STANDARD_FONT_BOLD";
    public static final String STANDARD_FONT_LIGHT = "STANDARD_FONT_LIGHT";
    public static final String SHOW_PARTIAL_POPUP_DEBUG_INFOS = "showPartialPopupDebugInfos";
    public static final String SHOW_GLOBAL_POPUP_PRIORITIES = "useGlobalPopupPriorities";
    public static final String SHOW_SCREEN_CHANGE_ANIMATION_INFO = "showScreenChangeAnimationInfo";
    public static final String LOG_SCREEN_CHANGE = "logScreenChange";
    public static final String SHOW_ANIMATION_STATISTICS = "showAnimationStatistics";

    public static boolean getBoolean(String string, boolean bl) {
        if (string == null || string.length() == 0) {
            return bl;
        }
        String string2 = System.getProperty(string);
        if (string2 == null) {
            return bl;
        }
        if (string2.equalsIgnoreCase("default")) {
            return bl;
        }
        return Boolean.valueOf(string2);
    }

    public static int[] getIntArray(String string, int[] nArray) {
        String string2 = System.getProperty(string);
        if (string2 == null) {
            return nArray;
        }
        int[] nArray2 = new int[nArray.length];
        StringTokenizer stringTokenizer = new StringTokenizer(string2, ",");
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (stringTokenizer.hasMoreElements()) {
                String string3 = stringTokenizer.nextToken();
                try {
                    int n;
                    nArray2[i2] = n = Integer.parseInt(string3);
                }
                catch (NumberFormatException numberFormatException) {
                    nArray2[i2] = nArray[i2];
                }
                continue;
            }
            nArray2[i2] = nArray[i2];
        }
        return nArray2;
    }

    private SystemProperties() {
    }
}

