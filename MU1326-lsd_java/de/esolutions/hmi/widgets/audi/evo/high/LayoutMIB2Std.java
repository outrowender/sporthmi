/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;

public class LayoutMIB2Std
implements Layout,
WidgetConstants {
    private static final int DISPLAY_WIDTH;
    private static final int DISPLAY_HEIGHT;
    private static final String STANDARD_FONT_PLAIN;
    private static final String STANDARD_FONT_BOLD;
    private static final String STANDARD_FONT_LIGHT;
    public static final int COMPOSITE_DEPTH_STATISTICS;
    public static final int COMPOSITE_DEPTH_SCREEN_POPIN;
    public static final int COMPOSITE_DEPTH_TA_OVERLAY;
    public static final int COMPOSITE_DEPTH_OSD;
    public static final int COMPOSITE_DEPTH_CURSOR;
    public static final int COMPOSITE_DEPTH_SOFTKEY;
    public static final int COMPOSITE_DEPTH_DRAWER;
    public static final int COMPOSITE_DEPTH_SIDE_BAR_ITEMS;
    public static final int COMPOSITE_DEPTH_TITLE_LINE;
    public static final int COMPOSITE_DEPTH_STATUS_LINE;
    public static final int COMPOSITE_DEPTH_SIDE_BAR;
    public static final int COMPOSITE_DEPTH_MIXED_LIST;
    public static final int COMPOSITE_DEPTH_COMBOBOX_OPEN;
    public static final int COMPOSITE_DEPTH_TOOLTIP;
    public static final int COMPOSITE_DEPTH_MENU;
    public static final int COMPOSITE_DEPTH_SUBTITLE;
    public static final int COMPOSITE_DEPTH_ROTARY;
    public static final int COMPOSITE_DEPTH_SPELLER;
    public static final int COMPOSITE_DEPTH_FUNC_WHEEL;
    public static final int COMPOSITE_DEPTH_WIZARD_INFOBOX;
    public static final int COMPOSITE_DEPTH_WIZARD;
    public static final int COMPOSITE_DEPTH_WIZARD_TOOLTIP;
    public static final int COMPOSITE_DEPTH_SCREEN_OVERLAY;
    public static final int COMPOSITE_DEPTH_SCREEN_STANDARD;
    public static final int COMPOSITE_DEPTH_SCREEN_BACKGROUND;
    public static final int COMPOSITE_DEPTH_SCREENSHOT_FOREGROUND;
    public static final int COMPOSITE_DEPTH_SCREENSHOT_BACKGROUND;
    private static final float FACTOR_MAPPING_FONTSIZES;
    private static final int MENU_LINE_WIDTH;
    protected static final int[] DISTANCE_CONSTANTS;
    private static final float[] FLOAT_CONSTANTS;
    private static final int[] INTEGER_CONSTANTS;
    private static final int[] TEXT_EXPORT_CONSTANTS;
    private static final int ROW_HEIGHT;
    private static final int ROW_OVERALL;
    private static final int ROW_HEIGHT_TOOLTIP;
    private static final int ROW_OVERALL_TOOLTIP;
    private static final int[] TEXT_PATTERN_ONE_ROW;
    private static final int[] TEXT_PATTERN_TWO_ROWS;
    private static final int[] TEXT_PATTERN_THREE_ROWS;
    private static final int[] TEXT_PATTERN_FOUR_ROWS;
    private static final int[] TEXT_PATTERN_FIVE_ROWS;
    private static final int[] TEXT_PATTERN_SIX_ROWS;
    private static final int[] MAP_FONT_SIZES_TO_POINTS;
    private static final int[] MAP_FONT_SIZES_TO_PIXELS;
    private static final int[][] STATIC_BITMAP_PARAMETERS;
    private static final int UNSUPPORTED_DEVELOPMENT_BUILD_IMAGE_ID;
    private static final int TEXT_EXPORT_TEXT_ICON_GAP_VALUE;
    public static final int TEXT_EXPORT_TEXT_GAP_TEXTFIELD_VALUE;
    private static int[] instructionTextLayoutParams;
    private static final String SPLASH_SCREEN_PATH;
    private static int[][] mainWizardIconDecoratorMapping;
    private static int[] mainWizardTextOffset;
    private static final int[][] TIME_ZONE_IMAGE_POSITONS;

    @Override
    public int getRotationalDirection(int n) {
        switch (n) {
            default: {
                AbstractWidget.logChannel.log(10000, "LayoutMIB2High#getRotationalDirection unknwon wheelButton event direction: %1 - default behavior is left turn", (long)n);
            }
            case 1: {
                return 2;
            }
            case 0: 
        }
        return 1;
    }

    @Override
    public String getFontName(int n) {
        switch (n) {
            case 0: {
                return STANDARD_FONT_PLAIN;
            }
            case 1: {
                return STANDARD_FONT_BOLD;
            }
            case 2: {
                return STANDARD_FONT_LIGHT;
            }
        }
        return STANDARD_FONT_PLAIN;
    }

    private static void initializeDistances() {
        LayoutMIB2Std.DISTANCE_CONSTANTS[1] = 400;
        LayoutMIB2Std.DISTANCE_CONSTANTS[2] = 240;
        LayoutMIB2Std.DISTANCE_CONSTANTS[3] = 750;
        LayoutMIB2Std.DISTANCE_CONSTANTS[22] = 6;
        LayoutMIB2Std.DISTANCE_CONSTANTS[23] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[8] = 26;
        LayoutMIB2Std.DISTANCE_CONSTANTS[9] = 2;
        LayoutMIB2Std.DISTANCE_CONSTANTS[11] = 385;
        LayoutMIB2Std.DISTANCE_CONSTANTS[14] = 20;
        LayoutMIB2Std.DISTANCE_CONSTANTS[37] = 55;
        LayoutMIB2Std.DISTANCE_CONSTANTS[169] = 29;
        LayoutMIB2Std.DISTANCE_CONSTANTS[10] = 21;
        LayoutMIB2Std.DISTANCE_CONSTANTS[16] = UNSUPPORTED_DEVELOPMENT_BUILD_IMAGE_ID;
        LayoutMIB2Std.DISTANCE_CONSTANTS[17] = 9;
        LayoutMIB2Std.DISTANCE_CONSTANTS[18] = 12;
        LayoutMIB2Std.DISTANCE_CONSTANTS[19] = 20;
        LayoutMIB2Std.DISTANCE_CONSTANTS[20] = 50;
        LayoutMIB2Std.DISTANCE_CONSTANTS[12] = 64;
        LayoutMIB2Std.DISTANCE_CONSTANTS[13] = 11;
        LayoutMIB2Std.DISTANCE_CONSTANTS[21] = 29;
        LayoutMIB2Std.DISTANCE_CONSTANTS[24] = 95;
        LayoutMIB2Std.DISTANCE_CONSTANTS[25] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[26] = 32;
        LayoutMIB2Std.DISTANCE_CONSTANTS[27] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[28] = 9;
        LayoutMIB2Std.DISTANCE_CONSTANTS[168] = 286;
        LayoutMIB2Std.DISTANCE_CONSTANTS[29] = 32;
        LayoutMIB2Std.DISTANCE_CONSTANTS[30] = 31;
        LayoutMIB2Std.DISTANCE_CONSTANTS[31] = 32;
        LayoutMIB2Std.DISTANCE_CONSTANTS[32] = 2;
        LayoutMIB2Std.DISTANCE_CONSTANTS[33] = 12;
        LayoutMIB2Std.DISTANCE_CONSTANTS[173] = 20;
        LayoutMIB2Std.DISTANCE_CONSTANTS[174] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[175] = 28;
        LayoutMIB2Std.DISTANCE_CONSTANTS[176] = -67;
        LayoutMIB2Std.DISTANCE_CONSTANTS[177] = 130;
        LayoutMIB2Std.DISTANCE_CONSTANTS[178] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[34] = 50;
        LayoutMIB2Std.DISTANCE_CONSTANTS[35] = 1;
        LayoutMIB2Std.DISTANCE_CONSTANTS[39] = 175;
        LayoutMIB2Std.DISTANCE_CONSTANTS[40] = 141;
        LayoutMIB2Std.DISTANCE_CONSTANTS[41] = 231;
        LayoutMIB2Std.DISTANCE_CONSTANTS[42] = 276;
        LayoutMIB2Std.DISTANCE_CONSTANTS[81] = 29;
        LayoutMIB2Std.DISTANCE_CONSTANTS[82] = 29;
        LayoutMIB2Std.DISTANCE_CONSTANTS[43] = 74;
        LayoutMIB2Std.DISTANCE_CONSTANTS[44] = 74;
        LayoutMIB2Std.DISTANCE_CONSTANTS[45] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[46] = 30;
        LayoutMIB2Std.DISTANCE_CONSTANTS[47] = 25;
        LayoutMIB2Std.DISTANCE_CONSTANTS[48] = 1;
        LayoutMIB2Std.DISTANCE_CONSTANTS[49] = 9;
        LayoutMIB2Std.DISTANCE_CONSTANTS[4] = 20;
        LayoutMIB2Std.DISTANCE_CONSTANTS[5] = 50;
        LayoutMIB2Std.DISTANCE_CONSTANTS[6] = 30;
        LayoutMIB2Std.DISTANCE_CONSTANTS[7] = 33;
        LayoutMIB2Std.DISTANCE_CONSTANTS[50] = 21;
        LayoutMIB2Std.DISTANCE_CONSTANTS[51] = 47;
        LayoutMIB2Std.DISTANCE_CONSTANTS[52] = 49;
        LayoutMIB2Std.DISTANCE_CONSTANTS[53] = 220;
        LayoutMIB2Std.DISTANCE_CONSTANTS[54] = 8;
        LayoutMIB2Std.DISTANCE_CONSTANTS[55] = 11;
        LayoutMIB2Std.DISTANCE_CONSTANTS[56] = 10;
        LayoutMIB2Std.DISTANCE_CONSTANTS[57] = 11;
        LayoutMIB2Std.DISTANCE_CONSTANTS[58] = 18;
        LayoutMIB2Std.DISTANCE_CONSTANTS[59] = 18;
        LayoutMIB2Std.DISTANCE_CONSTANTS[60] = 21;
        LayoutMIB2Std.DISTANCE_CONSTANTS[61] = 21;
        LayoutMIB2Std.DISTANCE_CONSTANTS[62] = 20;
        LayoutMIB2Std.DISTANCE_CONSTANTS[63] = 21;
        LayoutMIB2Std.DISTANCE_CONSTANTS[64] = 21;
        LayoutMIB2Std.DISTANCE_CONSTANTS[65] = 20;
        LayoutMIB2Std.DISTANCE_CONSTANTS[66] = 18;
        LayoutMIB2Std.DISTANCE_CONSTANTS[67] = 8;
        LayoutMIB2Std.DISTANCE_CONSTANTS[68] = 60;
        LayoutMIB2Std.DISTANCE_CONSTANTS[69] = 27;
        LayoutMIB2Std.DISTANCE_CONSTANTS[70] = 18;
        LayoutMIB2Std.DISTANCE_CONSTANTS[71] = 76;
        LayoutMIB2Std.DISTANCE_CONSTANTS[72] = 108;
        LayoutMIB2Std.DISTANCE_CONSTANTS[150] = 6;
        LayoutMIB2Std.DISTANCE_CONSTANTS[73] = 10;
        LayoutMIB2Std.DISTANCE_CONSTANTS[74] = 15;
        LayoutMIB2Std.DISTANCE_CONSTANTS[75] = 27;
        LayoutMIB2Std.DISTANCE_CONSTANTS[76] = 11;
        LayoutMIB2Std.DISTANCE_CONSTANTS[77] = 7;
        LayoutMIB2Std.DISTANCE_CONSTANTS[78] = 40;
        LayoutMIB2Std.DISTANCE_CONSTANTS[79] = 72;
        LayoutMIB2Std.DISTANCE_CONSTANTS[80] = 10;
        LayoutMIB2Std.DISTANCE_CONSTANTS[87] = 52;
        LayoutMIB2Std.DISTANCE_CONSTANTS[88] = 3;
        LayoutMIB2Std.DISTANCE_CONSTANTS[89] = 2;
        LayoutMIB2Std.DISTANCE_CONSTANTS[90] = 26;
        LayoutMIB2Std.DISTANCE_CONSTANTS[83] = -38;
        LayoutMIB2Std.DISTANCE_CONSTANTS[84] = -33;
        LayoutMIB2Std.DISTANCE_CONSTANTS[85] = 24;
        LayoutMIB2Std.DISTANCE_CONSTANTS[86] = -34;
        LayoutMIB2Std.DISTANCE_CONSTANTS[91] = 13;
        LayoutMIB2Std.DISTANCE_CONSTANTS[92] = 272;
        LayoutMIB2Std.DISTANCE_CONSTANTS[93] = 365;
        LayoutMIB2Std.DISTANCE_CONSTANTS[96] = 45;
        LayoutMIB2Std.DISTANCE_CONSTANTS[97] = 27;
        LayoutMIB2Std.DISTANCE_CONSTANTS[98] = 17;
        LayoutMIB2Std.DISTANCE_CONSTANTS[99] = 18;
        LayoutMIB2Std.DISTANCE_CONSTANTS[100] = 26;
        LayoutMIB2Std.DISTANCE_CONSTANTS[101] = 41;
        LayoutMIB2Std.DISTANCE_CONSTANTS[105] = 22;
        LayoutMIB2Std.DISTANCE_CONSTANTS[102] = 90;
        LayoutMIB2Std.DISTANCE_CONSTANTS[103] = 8;
        LayoutMIB2Std.DISTANCE_CONSTANTS[104] = -9;
        LayoutMIB2Std.DISTANCE_CONSTANTS[106] = 11;
        LayoutMIB2Std.DISTANCE_CONSTANTS[107] = 5;
        LayoutMIB2Std.DISTANCE_CONSTANTS[108] = 29;
        LayoutMIB2Std.DISTANCE_CONSTANTS[109] = 75;
        LayoutMIB2Std.DISTANCE_CONSTANTS[110] = 2;
        LayoutMIB2Std.DISTANCE_CONSTANTS[111] = 10;
        LayoutMIB2Std.DISTANCE_CONSTANTS[112] = 8;
        LayoutMIB2Std.DISTANCE_CONSTANTS[113] = 25;
        LayoutMIB2Std.DISTANCE_CONSTANTS[119] = -10;
        LayoutMIB2Std.DISTANCE_CONSTANTS[114] = 25;
        LayoutMIB2Std.DISTANCE_CONSTANTS[115] = 16;
        LayoutMIB2Std.DISTANCE_CONSTANTS[116] = 46;
        LayoutMIB2Std.DISTANCE_CONSTANTS[117] = 34;
        LayoutMIB2Std.DISTANCE_CONSTANTS[118] = 52;
        LayoutMIB2Std.DISTANCE_CONSTANTS[120] = 16;
        LayoutMIB2Std.DISTANCE_CONSTANTS[121] = 197;
        LayoutMIB2Std.DISTANCE_CONSTANTS[122] = 191;
        LayoutMIB2Std.DISTANCE_CONSTANTS[123] = 3;
        LayoutMIB2Std.DISTANCE_CONSTANTS[124] = 10;
        LayoutMIB2Std.DISTANCE_CONSTANTS[125] = 18;
        LayoutMIB2Std.DISTANCE_CONSTANTS[126] = 78;
        LayoutMIB2Std.DISTANCE_CONSTANTS[127] = 1;
        LayoutMIB2Std.DISTANCE_CONSTANTS[128] = 1;
        LayoutMIB2Std.DISTANCE_CONSTANTS[129] = 86;
        LayoutMIB2Std.DISTANCE_CONSTANTS[130] = 100;
        LayoutMIB2Std.DISTANCE_CONSTANTS[132] = 16;
        LayoutMIB2Std.DISTANCE_CONSTANTS[131] = 7;
        LayoutMIB2Std.DISTANCE_CONSTANTS[133] = 9;
        LayoutMIB2Std.DISTANCE_CONSTANTS[134] = 10;
        LayoutMIB2Std.DISTANCE_CONSTANTS[135] = 8;
        LayoutMIB2Std.DISTANCE_CONSTANTS[136] = 16;
        LayoutMIB2Std.DISTANCE_CONSTANTS[137] = 26;
        LayoutMIB2Std.DISTANCE_CONSTANTS[138] = 33;
        LayoutMIB2Std.DISTANCE_CONSTANTS[139] = -6;
        LayoutMIB2Std.DISTANCE_CONSTANTS[140] = -7;
        LayoutMIB2Std.DISTANCE_CONSTANTS[141] = 13;
        LayoutMIB2Std.DISTANCE_CONSTANTS[182] = 20;
        LayoutMIB2Std.DISTANCE_CONSTANTS[142] = 328;
        LayoutMIB2Std.DISTANCE_CONSTANTS[143] = 124;
        LayoutMIB2Std.DISTANCE_CONSTANTS[144] = 354;
        LayoutMIB2Std.DISTANCE_CONSTANTS[145] = 358;
        LayoutMIB2Std.DISTANCE_CONSTANTS[146] = 147;
        LayoutMIB2Std.DISTANCE_CONSTANTS[147] = 27;
        LayoutMIB2Std.DISTANCE_CONSTANTS[148] = 17;
        LayoutMIB2Std.DISTANCE_CONSTANTS[179] = 6;
        LayoutMIB2Std.DISTANCE_CONSTANTS[180] = 14;
        LayoutMIB2Std.DISTANCE_CONSTANTS[181] = 3;
        LayoutMIB2Std.DISTANCE_CONSTANTS[149] = 12;
        LayoutMIB2Std.DISTANCE_CONSTANTS[151] = 12;
        LayoutMIB2Std.DISTANCE_CONSTANTS[152] = 41;
        LayoutMIB2Std.DISTANCE_CONSTANTS[153] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[154] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[155] = 800;
        LayoutMIB2Std.DISTANCE_CONSTANTS[156] = 480;
        LayoutMIB2Std.DISTANCE_CONSTANTS[157] = 256;
        LayoutMIB2Std.DISTANCE_CONSTANTS[158] = 256;
        LayoutMIB2Std.DISTANCE_CONSTANTS[159] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[160] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[161] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[162] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[163] = 800;
        LayoutMIB2Std.DISTANCE_CONSTANTS[164] = 480;
        LayoutMIB2Std.DISTANCE_CONSTANTS[165] = 47;
        LayoutMIB2Std.DISTANCE_CONSTANTS[166] = 27;
        LayoutMIB2Std.DISTANCE_CONSTANTS[167] = 25;
        LayoutMIB2Std.DISTANCE_CONSTANTS[170] = 86;
        LayoutMIB2Std.DISTANCE_CONSTANTS[171] = 42;
        LayoutMIB2Std.DISTANCE_CONSTANTS[172] = 14;
        LayoutMIB2Std.DISTANCE_CONSTANTS[183] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[184] = 0;
        LayoutMIB2Std.DISTANCE_CONSTANTS[185] = 66;
        LayoutMIB2Std.DISTANCE_CONSTANTS[186] = 8;
        LayoutMIB2Std.DISTANCE_CONSTANTS[190] = 225;
        LayoutMIB2Std.DISTANCE_CONSTANTS[191] = 495;
        LayoutMIB2Std.DISTANCE_CONSTANTS[192] = 13;
        LayoutMIB2Std.DISTANCE_CONSTANTS[193] = 13;
        LayoutMIB2Std.DISTANCE_CONSTANTS[210] = -31;
        LayoutMIB2Std.DISTANCE_CONSTANTS[211] = -54;
        LayoutMIB2Std.DISTANCE_CONSTANTS[212] = 17;
        LayoutMIB2Std.DISTANCE_CONSTANTS[213] = 9;
        LayoutMIB2Std.DISTANCE_CONSTANTS[216] = 21;
        LayoutMIB2Std.DISTANCE_CONSTANTS[217] = 35;
        LayoutMIB2Std.DISTANCE_CONSTANTS[218] = 19;
        LayoutMIB2Std.DISTANCE_CONSTANTS[224] = 40;
        LayoutMIB2Std.DISTANCE_CONSTANTS[225] = 47;
        LayoutMIB2Std.DISTANCE_CONSTANTS[226] = -19;
        LayoutMIB2Std.DISTANCE_CONSTANTS[227] = 15;
        LayoutMIB2Std.DISTANCE_CONSTANTS[229] = 12;
        LayoutMIB2Std.DISTANCE_CONSTANTS[228] = 400;
    }

    private static void initializeFloatConstants() {
        LayoutMIB2Std.FLOAT_CONSTANTS[0] = 32832;
        LayoutMIB2Std.FLOAT_CONSTANTS[1] = 1718011455;
        LayoutMIB2Std.FLOAT_CONSTANTS[2] = 2094637117;
        LayoutMIB2Std.FLOAT_CONSTANTS[3] = 1718003263;
        LayoutMIB2Std.FLOAT_CONSTANTS[4] = 41152;
        LayoutMIB2Std.FLOAT_CONSTANTS[5] = 49216;
        LayoutMIB2Std.FLOAT_CONSTANTS[6] = 32832;
        LayoutMIB2Std.FLOAT_CONSTANTS[7] = 16448;
        LayoutMIB2Std.FLOAT_CONSTANTS[8] = 32833;
        LayoutMIB2Std.FLOAT_CONSTANTS[9] = 36929;
        LayoutMIB2Std.FLOAT_CONSTANTS[13] = 63;
        LayoutMIB2Std.FLOAT_CONSTANTS[12] = 63;
        LayoutMIB2Std.FLOAT_CONSTANTS[11] = 63;
        LayoutMIB2Std.FLOAT_CONSTANTS[10] = 63;
        LayoutMIB2Std.FLOAT_CONSTANTS[14] = 63;
        LayoutMIB2Std.FLOAT_CONSTANTS[16] = 693923647;
        LayoutMIB2Std.FLOAT_CONSTANTS[17] = 1.0f;
    }

    private static void initializeTextExportConstants() {
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[5] = 17;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[8] = 39;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[6] = 49;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[1] = 0;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[3] = 12;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[4] = 0;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[9] = 12;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[0] = 606;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[7] = 55;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[2] = 22;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[10] = 300;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[11] = 25;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[12] = 25;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[13] = 25;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[15] = 127;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[14] = 25;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[16] = 17;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[17] = 32;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[19] = 240;
        LayoutMIB2Std.TEXT_EXPORT_CONSTANTS[18] = 9999;
    }

    @Override
    public int[] getStaticBitmapParameters(int n) {
        return STATIC_BITMAP_PARAMETERS[n];
    }

    @Override
    public int getRowHeight() {
        return 45;
    }

    @Override
    public int getRowOverall() {
        return 50;
    }

    @Override
    public int getRowHeightToolTip() {
        return 35;
    }

    @Override
    public int getRowOverallToolTip() {
        return 40;
    }

    @Override
    public int getDistance(int n) {
        try {
            return DISTANCE_CONSTANTS[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            IWidgetLogChannel.logChannel.log(10000, "LayoutMIBHigh#getDistance unknown distance type: %1 - returning 0", (long)n);
            return 0;
        }
    }

    @Override
    public int getDepth(int n) {
        switch (n) {
            case 1: {
                return -100;
            }
            case 2: {
                return 5;
            }
            case 3: {
                return 0;
            }
            case 4: {
                return 5;
            }
            case 5: {
                return 65;
            }
            case 6: {
                return 100;
            }
            case 7: {
                return 30;
            }
            case 8: {
                return 40;
            }
            case 9: {
                return 60;
            }
            case 10: {
                return 40;
            }
            case 11: {
                return 10;
            }
            case 12: {
                return 50;
            }
            case 13: {
                return 7;
            }
            case 14: {
                return 60;
            }
            case 15: {
                return 60;
            }
            case 16: {
                return 60;
            }
            case 17: {
                return 60;
            }
            case 18: {
                return 70;
            }
            case 19: {
                return 80;
            }
            case 20: {
                return 40;
            }
            case 27: {
                return 70;
            }
            case 21: {
                return 20;
            }
            case 22: {
                return 30;
            }
            case 23: {
                return 30;
            }
            case 24: {
                return 19;
            }
            case 25: {
                return 31;
            }
            case 26: {
                return 55;
            }
        }
        AbstractWidget.logChannel.log(1078071040, "LayoutMIBHigh#getDepth type: %1 is not supported by this layout", (long)n);
        return 0;
    }

    @Override
    public float getFloatConstant(int n) {
        try {
            return FLOAT_CONSTANTS[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            IWidgetLogChannel.logChannel.log(10000, "LayoutMIBHigh#getFloatConstant unknown float constant type: %1 - returning 1.f", (long)n);
            return 1.0f;
        }
    }

    @Override
    public int getTextExportWidth(int n) {
        try {
            return TEXT_EXPORT_CONSTANTS[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            IWidgetLogChannel.logChannel.log(10000, "LayoutMIBHigh#getTextExportWidth unknown type: %1 - returning 0", (long)n);
            return 0;
        }
    }

    @Override
    public int getMenuLineWidth() {
        return 800;
    }

    @Override
    public int[] getTextPattern(int n) {
        switch (n) {
            case 1: {
                return TEXT_PATTERN_ONE_ROW;
            }
            case 2: {
                return TEXT_PATTERN_TWO_ROWS;
            }
            case 3: {
                return TEXT_PATTERN_THREE_ROWS;
            }
            case 4: {
                return TEXT_PATTERN_FOUR_ROWS;
            }
            case 5: {
                return TEXT_PATTERN_FIVE_ROWS;
            }
            case 6: {
                return TEXT_PATTERN_SIX_ROWS;
            }
        }
        AbstractWidget.logChannel.log(-2137614336, "LayoutMIBHigh#getTextPattern no pattern for noOfRows: %1", (long)n);
        return null;
    }

    @Override
    public int getMappedFontSize(int n, int n2) {
        int[] nArray;
        if (n < 0) {
            AbstractWidget.logChannel.log(10000, "LayoutMIBHigh#getMappedFontSize no mapping for font with pixel-size: %1", (long)n);
            return 1;
        }
        if (n2 == 1) {
            nArray = MAP_FONT_SIZES_TO_POINTS;
            if (n >= nArray.length) {
                AbstractWidget.logChannel.log(10000, "LayoutMIBHigh#getMappedFontSize no mapping for font with pixel-size: %1", (long)n);
                return (int)((float)n * 52604479);
            }
            if (nArray[n] == 0) {
                nArray[n] = (int)((float)n * 52604479);
            }
        } else {
            nArray = MAP_FONT_SIZES_TO_PIXELS;
            if (n >= nArray.length) {
                AbstractWidget.logChannel.log(10000, "LayoutMIBHigh#getMappedFontSize no mapping for font with point-size: %1", (long)n);
                return (int)((float)n / 52604479);
            }
            if (nArray[n] == 0) {
                nArray[n] = (int)((float)n / 52604479);
            }
        }
        return nArray[n];
    }

    @Override
    public String getSplashscreenPath() {
        return "/HBpersistence/Splashscreen.png";
    }

    @Override
    public int[][] getTimeZoneImagePositions() {
        return TIME_ZONE_IMAGE_POSITONS;
    }

    @Override
    public int[] getInstructionTextLayoutParams() {
        if (instructionTextLayoutParams == null) {
            instructionTextLayoutParams = new int[]{37, 66, 91, 123, 162, 162, 26, 33, 66, 91, 119, 32, 8, -1, 6, 13, 10, 4, 11, 9, 12, 21, 25, 23, 10, 19, 38, 61, 68, 91, 114, 137, 41, 72, 76, 102, 127, 29, -2, -1, 12, 12, 1, -7, 19, 0, 0, 30, 23, 55};
        }
        return instructionTextLayoutParams;
    }

    private static void initializeIntegerConstants() {
        LayoutMIB2Std.INTEGER_CONSTANTS[0] = 0;
        LayoutMIB2Std.INTEGER_CONSTANTS[1] = 436;
        LayoutMIB2Std.INTEGER_CONSTANTS[2] = 457;
        LayoutMIB2Std.INTEGER_CONSTANTS[3] = 126;
        LayoutMIB2Std.INTEGER_CONSTANTS[4] = 7;
        LayoutMIB2Std.INTEGER_CONSTANTS[5] = 10;
        LayoutMIB2Std.INTEGER_CONSTANTS[6] = 16;
        LayoutMIB2Std.INTEGER_CONSTANTS[8] = 7;
        LayoutMIB2Std.INTEGER_CONSTANTS[7] = 10;
        LayoutMIB2Std.INTEGER_CONSTANTS[9] = 11;
        LayoutMIB2Std.INTEGER_CONSTANTS[10] = 11;
        LayoutMIB2Std.INTEGER_CONSTANTS[11] = 6;
        LayoutMIB2Std.INTEGER_CONSTANTS[12] = 20;
        LayoutMIB2Std.INTEGER_CONSTANTS[13] = 38;
        LayoutMIB2Std.INTEGER_CONSTANTS[63] = 18;
        LayoutMIB2Std.INTEGER_CONSTANTS[14] = 9;
        LayoutMIB2Std.INTEGER_CONSTANTS[15] = 11;
        LayoutMIB2Std.INTEGER_CONSTANTS[16] = 10;
        LayoutMIB2Std.INTEGER_CONSTANTS[17] = 12;
        LayoutMIB2Std.INTEGER_CONSTANTS[18] = 7;
        LayoutMIB2Std.INTEGER_CONSTANTS[19] = 7;
        LayoutMIB2Std.INTEGER_CONSTANTS[20] = 5;
        LayoutMIB2Std.INTEGER_CONSTANTS[21] = 8;
        LayoutMIB2Std.INTEGER_CONSTANTS[22] = 12;
        LayoutMIB2Std.INTEGER_CONSTANTS[23] = 12;
        LayoutMIB2Std.INTEGER_CONSTANTS[24] = 25;
        LayoutMIB2Std.INTEGER_CONSTANTS[25] = 43;
        LayoutMIB2Std.INTEGER_CONSTANTS[26] = 45;
        LayoutMIB2Std.INTEGER_CONSTANTS[27] = 6;
        LayoutMIB2Std.INTEGER_CONSTANTS[28] = 4;
        LayoutMIB2Std.INTEGER_CONSTANTS[32] = 10;
        LayoutMIB2Std.INTEGER_CONSTANTS[33] = 5;
        LayoutMIB2Std.INTEGER_CONSTANTS[34] = 15;
        LayoutMIB2Std.INTEGER_CONSTANTS[35] = 21;
        LayoutMIB2Std.INTEGER_CONSTANTS[36] = -10;
        LayoutMIB2Std.INTEGER_CONSTANTS[37] = 5;
        LayoutMIB2Std.INTEGER_CONSTANTS[38] = 5;
        LayoutMIB2Std.INTEGER_CONSTANTS[39] = 12;
        LayoutMIB2Std.INTEGER_CONSTANTS[40] = 12;
        LayoutMIB2Std.INTEGER_CONSTANTS[41] = 5;
        LayoutMIB2Std.INTEGER_CONSTANTS[42] = 7;
        LayoutMIB2Std.INTEGER_CONSTANTS[43] = 7;
        LayoutMIB2Std.INTEGER_CONSTANTS[77] = 272;
        LayoutMIB2Std.INTEGER_CONSTANTS[44] = 10;
        LayoutMIB2Std.INTEGER_CONSTANTS[45] = 22;
        LayoutMIB2Std.INTEGER_CONSTANTS[46] = 4;
        LayoutMIB2Std.INTEGER_CONSTANTS[47] = 270;
        LayoutMIB2Std.INTEGER_CONSTANTS[48] = 170;
        LayoutMIB2Std.INTEGER_CONSTANTS[49] = 36;
        LayoutMIB2Std.INTEGER_CONSTANTS[50] = 340;
        LayoutMIB2Std.INTEGER_CONSTANTS[51] = 191;
        LayoutMIB2Std.INTEGER_CONSTANTS[52] = 13;
        LayoutMIB2Std.INTEGER_CONSTANTS[53] = 13;
        LayoutMIB2Std.INTEGER_CONSTANTS[54] = 20;
        LayoutMIB2Std.INTEGER_CONSTANTS[55] = 30;
        LayoutMIB2Std.INTEGER_CONSTANTS[56] = 367;
        LayoutMIB2Std.INTEGER_CONSTANTS[57] = 200;
        LayoutMIB2Std.INTEGER_CONSTANTS[64] = 60;
        LayoutMIB2Std.INTEGER_CONSTANTS[67] = 10;
        LayoutMIB2Std.INTEGER_CONSTANTS[68] = 100;
        LayoutMIB2Std.INTEGER_CONSTANTS[69] = 138;
        LayoutMIB2Std.INTEGER_CONSTANTS[70] = 12;
        LayoutMIB2Std.INTEGER_CONSTANTS[71] = 0;
        LayoutMIB2Std.INTEGER_CONSTANTS[72] = 11;
        LayoutMIB2Std.INTEGER_CONSTANTS[73] = -24;
        LayoutMIB2Std.INTEGER_CONSTANTS[78] = -15;
        LayoutMIB2Std.INTEGER_CONSTANTS[74] = -1;
        LayoutMIB2Std.INTEGER_CONSTANTS[75] = -1;
        LayoutMIB2Std.INTEGER_CONSTANTS[76] = 2;
        LayoutMIB2Std.INTEGER_CONSTANTS[96] = 0;
        LayoutMIB2Std.INTEGER_CONSTANTS[79] = -1;
        LayoutMIB2Std.INTEGER_CONSTANTS[94] = 24;
        LayoutMIB2Std.INTEGER_CONSTANTS[105] = 5;
        LayoutMIB2Std.INTEGER_CONSTANTS[114] = 400;
        LayoutMIB2Std.INTEGER_CONSTANTS[115] = 240;
        LayoutMIB2Std.INTEGER_CONSTANTS[113] = 18;
        LayoutMIB2Std.INTEGER_CONSTANTS[126] = 13;
        LayoutMIB2Std.INTEGER_CONSTANTS[127] = 13;
        LayoutMIB2Std.INTEGER_CONSTANTS[128] = 13;
        LayoutMIB2Std.INTEGER_CONSTANTS[129] = 13;
        LayoutMIB2Std.INTEGER_CONSTANTS[130] = 15;
    }

    @Override
    public int getIntegerConstant(int n) {
        try {
            return INTEGER_CONSTANTS[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            IWidgetLogChannel.logChannel.log(10000, "LayoutMIBHigh#getIntegerConstant unknown int constant type: %1 - returning 1", (long)n);
            return 1;
        }
    }

    @Override
    public int[][] getMainWizardIconDecoratorMapping() {
        if (mainWizardIconDecoratorMapping == null) {
            mainWizardIconDecoratorMapping = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {0, 0}, {0, 0}, {4, 4}, {0, 0}, {5, 5}, {6, 6}, {7, 7}, {8, 8}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}, {-1, -1}};
        }
        return mainWizardIconDecoratorMapping;
    }

    @Override
    public int[] getMainWizardTextOffset() {
        if (mainWizardTextOffset == null) {
            mainWizardTextOffset = new int[]{0, 0, 0, 0, 0};
        }
        return mainWizardTextOffset;
    }

    @Override
    public int[] getDisplayablePosition(int n) {
        return new int[]{0, 0};
    }

    @Override
    public int getUserHintLabelOffset() {
        return 37;
    }

    static {
        STANDARD_FONT_PLAIN = System.getProperty("STANDARD_FONT_PLAIN", "AudiTypeDisplayHigh-Normal_10.ttf");
        STANDARD_FONT_BOLD = System.getProperty("STANDARD_FONT_BOLD", "AudiTypeDisplayHigh-Bold_5.ttf");
        STANDARD_FONT_LIGHT = System.getProperty("STANDARD_FONT_LIGHT", "AudiTypeDisplayHigh-Normal_10.ttf");
        DISTANCE_CONSTANTS = new int[230];
        FLOAT_CONSTANTS = new float[18];
        INTEGER_CONSTANTS = new int[132];
        TEXT_EXPORT_CONSTANTS = new int[20];
        TEXT_PATTERN_ONE_ROW = new int[]{0};
        TEXT_PATTERN_TWO_ROWS = new int[]{0, 0};
        TEXT_PATTERN_THREE_ROWS = new int[]{1, 0, 0};
        TEXT_PATTERN_FOUR_ROWS = new int[]{1, 1, 0, 0};
        TEXT_PATTERN_FIVE_ROWS = new int[]{1, 1, 1, 0, 0};
        TEXT_PATTERN_SIX_ROWS = new int[]{2, 2, 1, 1, 0, 0};
        MAP_FONT_SIZES_TO_POINTS = new int[]{0, 2, 3, 4, 6, 7, 9, 10, 11, 13, 14, 15, 17, 18, 19, 20, 21, 23, 24, 26, 27, 28, 30, 31, 33, 34, 35, 37, 38, 39, 41, 42, 44, 45, 46, 48, 49, 51, 52, 53, 54, 55, 56, 58, 59, 61, 62, 63, 65, 66, 68, 69, 70, 72, 73, 75, 76, 77, 79, 80, 81, 83, 84, 85, 87, 88};
        MAP_FONT_SIZES_TO_PIXELS = new int[]{0, 1, 1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9, 9, 10, 11, 12, 12, 13, 14, 15, 16, 17, 17, 18, 19, 19, 20, 21, 22, 22, 23, 24, 24, 25, 26, 27, 27, 28, 29, 30, 30, 31, 32, 32, 33, 34, 35, 35, 36, 37, 37, 38, 39, 40, 41, 42, 43, 43, 44, 45, 45, 46, 47, 48, 48, 49, 50, 50, 51, 52, 53, 53, 54, 55, 55, 56, 57, 58, 58, 59, 60, 61, 61, 62, 63, 64, 64, 65};
        STATIC_BITMAP_PARAMETERS = new int[3][3];
        UNSUPPORTED_DEVELOPMENT_BUILD_IMAGE_ID = HMIImageConstantsSystem.static_bitmap_unsupported_development_build;
        instructionTextLayoutParams = null;
        mainWizardIconDecoratorMapping = null;
        mainWizardTextOffset = null;
        TIME_ZONE_IMAGE_POSITONS = new int[][]{{8, 24}, {285, 22}, {273, 15}, {276, 116}, {254, 19}, {224, 36}, {226, 5}, {241, 78}, {210, 44}, {230, 76}, {219, 70}, {199, 21}, {212, 68}, {196, 40}, {197, 67}, {181, 4}, {171, 27}, {147, 6}, {133, 10}, {127, 16}, {121, 160}, {88, 0}, {101, 53}, {86, 10}, {88, 94}, {73, 1}, {54, 3}, {30, 9}, {25, 27}, {0, 24}, {25, 113}, {2, 84}, {329, 117}};
        LayoutMIB2Std.initializeDistances();
        LayoutMIB2Std.initializeFloatConstants();
        LayoutMIB2Std.initializeIntegerConstants();
        LayoutMIB2Std.initializeTextExportConstants();
    }
}

