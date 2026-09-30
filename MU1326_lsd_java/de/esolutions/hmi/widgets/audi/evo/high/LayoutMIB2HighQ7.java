/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.HMIImageConstantsSystem;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.Layout;
import de.esolutions.hmi.widgets.audi.base.WidgetConstants;

public class LayoutMIB2HighQ7
implements Layout,
WidgetConstants {
    private static final int DISPLAY_WIDTH = 1024;
    private static final int DISPLAY_HEIGHT = 480;
    private static final String STANDARD_FONT_PLAIN = System.getProperty("STANDARD_FONT_PLAIN", "AudiTypeDisplayHigh-Normal_10.ttf");
    private static final String STANDARD_FONT_BOLD = System.getProperty("STANDARD_FONT_BOLD", "AudiTypeDisplayHigh-Bold_5.ttf");
    private static final String STANDARD_FONT_LIGHT = System.getProperty("STANDARD_FONT_LIGHT", "AudiTypeDisplayHigh-Normal_10.ttf");
    public static final int COMPOSITE_DEPTH_STATISTICS = -100;
    public static final int COMPOSITE_DEPTH_SCREEN_POPIN = 5;
    public static final int COMPOSITE_DEPTH_TA_OVERLAY = 0;
    public static final int COMPOSITE_DEPTH_OSD = 5;
    public static final int COMPOSITE_DEPTH_CURSOR = 65;
    public static final int COMPOSITE_DEPTH_SOFTKEY = 100;
    public static final int COMPOSITE_DEPTH_DRAWER = 55;
    public static final int COMPOSITE_DEPTH_SIDE_BAR_ITEMS = 30;
    public static final int COMPOSITE_DEPTH_TITLE_LINE = 40;
    public static final int COMPOSITE_DEPTH_STATUS_LINE = 60;
    public static final int COMPOSITE_DEPTH_SIDE_BAR = 40;
    public static final int COMPOSITE_DEPTH_MIXED_LIST = 10;
    public static final int COMPOSITE_DEPTH_COMBOBOX_OPEN = 50;
    public static final int COMPOSITE_DEPTH_TOOLTIP = 7;
    public static final int COMPOSITE_DEPTH_MENU = 60;
    public static final int COMPOSITE_DEPTH_SUBTITLE = 60;
    public static final int COMPOSITE_DEPTH_ROTARY = 60;
    public static final int COMPOSITE_DEPTH_SPELLER = 60;
    public static final int COMPOSITE_DEPTH_FUNC_WHEEL = 70;
    public static final int COMPOSITE_DEPTH_WIZARD_INFOBOX = 70;
    public static final int COMPOSITE_DEPTH_WIZARD = 80;
    public static final int COMPOSITE_DEPTH_WIZARD_TOOLTIP = 40;
    public static final int COMPOSITE_DEPTH_SCREEN_OVERLAY = 20;
    public static final int COMPOSITE_DEPTH_SCREEN_STANDARD = 30;
    public static final int COMPOSITE_DEPTH_SCREEN_BACKGROUND = 1000;
    public static final int COMPOSITE_DEPTH_SCREENSHOT_FOREGROUND = 19;
    public static final int COMPOSITE_DEPTH_SCREENSHOT_BACKGROUND = 31;
    private static final float FACTOR_MAPPING_FONTSIZES = 1.360413f;
    private static final int MENU_LINE_WIDTH = 800;
    protected static final int[] DISTANCE_CONSTANTS = new int[230];
    private static final float[] FLOAT_CONSTANTS = new float[18];
    private static final int[] TEXT_EXPORT_CONSTANTS = new int[20];
    private static final int[] INTEGER_CONSTANTS = new int[132];
    private static final int ROW_HEIGHT = 45;
    private static final int ROW_OVERALL = 50;
    private static final int ROW_HEIGHT_TOOLTIP = 35;
    private static final int ROW_OVERALL_TOOLTIP = 40;
    private static final int[] TEXT_PATTERN_ONE_ROW = new int[]{0};
    private static final int[] TEXT_PATTERN_TWO_ROWS = new int[]{0, 0};
    private static final int[] TEXT_PATTERN_THREE_ROWS = new int[]{1, 0, 0};
    private static final int[] TEXT_PATTERN_FOUR_ROWS = new int[]{1, 1, 0, 0};
    private static final int[] TEXT_PATTERN_FIVE_ROWS = new int[]{1, 1, 1, 0, 0};
    private static final int[] TEXT_PATTERN_SIX_ROWS = new int[]{2, 2, 1, 1, 0, 0};
    private static final int[] MAP_FONT_SIZES_TO_POINTS = new int[]{0, 2, 3, 4, 6, 7, 9, 10, 11, 13, 14, 15, 17, 18, 19, 20, 21, 23, 24, 26, 27, 28, 30, 31, 33, 34, 35, 37, 38, 39, 41, 42, 44, 45, 46, 48, 49, 51, 52, 53, 54, 55, 56, 58, 59, 61, 62, 63, 65, 66, 68, 69, 70, 72, 73, 75, 76, 77, 79, 80, 81, 83, 84, 85, 87, 88};
    private static final int[] MAP_FONT_SIZES_TO_PIXELS = new int[]{0, 1, 1, 2, 3, 4, 4, 5, 6, 6, 7, 8, 9, 9, 10, 11, 12, 12, 13, 14, 15, 16, 17, 17, 18, 19, 19, 20, 21, 22, 22, 23, 24, 24, 25, 26, 27, 27, 28, 29, 30, 30, 31, 32, 32, 33, 34, 35, 35, 36, 37, 37, 38, 39, 40, 41, 42, 43, 43, 44, 45, 45, 46, 47, 48, 48, 49, 50, 50, 51, 52, 53, 53, 54, 55, 55, 56, 57, 58, 58, 59, 60, 61, 61, 62, 63, 64, 64, 65};
    private static final int[][] STATIC_BITMAP_PARAMETERS = new int[3][3];
    private static final int UNSUPPORTED_DEVELOPMENT_BUILD_IMAGE_ID = HMIImageConstantsSystem.static_bitmap_unsupported_development_build;
    private static final int TEXT_EXPORT_TEXT_ICON_GAP_VALUE = 22;
    public static final int TEXT_EXPORT_TEXT_GAP_TEXTFIELD_VALUE = 17;
    private static int[] instructionTextLayoutParams = null;
    private static int[][] mainWizardIconDecoratorMapping = null;
    private static int[] mainWizardTextOffset = null;
    private static final String SPLASH_SCREEN_PATH = "/HBpersistence/Splashscreen.png";
    private static final int[][] TIME_ZONE_IMAGE_POSITONS = new int[][]{{8, 24}, {285, 22}, {273, 15}, {276, 116}, {254, 19}, {224, 36}, {226, 5}, {241, 78}, {210, 44}, {230, 76}, {219, 70}, {199, 21}, {212, 68}, {196, 40}, {197, 67}, {181, 4}, {171, 27}, {147, 6}, {133, 10}, {127, 16}, {121, 160}, {88, 0}, {101, 53}, {86, 10}, {88, 94}, {73, 1}, {54, 3}, {30, 9}, {25, 27}, {0, 24}, {25, 113}, {2, 84}, {329, 117}};

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
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[1] = 1024;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[2] = 480;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[3] = 750;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[22] = 6;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[23] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[8] = 26;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[9] = 2;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[11] = 385;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[14] = 20;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[37] = 55;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[169] = 29;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[10] = 21;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[16] = UNSUPPORTED_DEVELOPMENT_BUILD_IMAGE_ID;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[17] = 9;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[18] = 12;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[19] = 20;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[20] = 50;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[12] = 64;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[13] = 11;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[21] = 29;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[24] = 95;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[25] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[26] = 32;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[27] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[28] = 9;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[168] = 286;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[29] = 32;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[30] = 31;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[31] = 32;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[32] = 2;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[33] = 12;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[173] = 20;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[174] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[175] = 28;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[176] = -67;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[177] = 130;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[178] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[34] = 50;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[35] = 1;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[39] = 175;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[40] = 141;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[41] = 231;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[42] = 276;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[81] = 29;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[82] = 29;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[43] = 74;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[44] = 74;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[45] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[46] = 30;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[47] = 25;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[48] = 1;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[49] = 9;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[4] = 20;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[5] = 50;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[6] = 30;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[7] = 33;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[50] = 21;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[51] = 47;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[52] = 49;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[53] = 220;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[54] = 8;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[55] = 11;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[56] = 10;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[57] = 11;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[58] = 18;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[59] = 18;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[60] = 21;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[61] = 21;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[62] = 20;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[63] = 21;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[64] = 21;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[65] = 20;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[66] = 18;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[67] = 8;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[68] = 60;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[69] = 27;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[70] = 18;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[71] = 76;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[72] = 108;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[150] = 6;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[73] = 10;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[74] = 15;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[75] = 27;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[76] = 11;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[77] = 7;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[78] = 40;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[79] = 72;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[80] = 10;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[87] = 52;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[88] = 3;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[89] = 2;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[90] = 26;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[83] = -38;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[84] = -33;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[85] = 24;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[86] = -34;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[91] = 13;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[92] = 272;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[93] = 365;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[96] = 45;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[97] = 27;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[98] = 17;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[99] = 18;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[100] = 26;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[101] = 41;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[105] = 22;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[102] = 90;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[103] = 8;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[104] = -9;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[106] = 11;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[107] = 5;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[108] = 29;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[109] = 75;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[110] = 2;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[111] = 10;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[112] = 8;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[113] = 25;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[119] = -10;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[114] = 25;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[115] = 16;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[116] = 46;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[117] = 34;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[118] = 52;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[120] = 16;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[121] = 197;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[122] = 191;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[123] = 3;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[124] = 10;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[125] = 18;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[126] = 78;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[127] = 1;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[128] = 1;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[129] = 86;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[130] = 100;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[132] = 16;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[131] = 7;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[133] = 9;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[134] = 10;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[135] = 8;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[136] = 16;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[137] = 26;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[138] = 33;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[139] = -6;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[140] = -7;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[141] = 13;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[182] = 20;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[142] = 328;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[143] = 124;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[144] = 354;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[145] = 358;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[146] = 147;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[147] = 27;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[148] = 17;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[179] = 6;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[180] = 14;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[181] = 3;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[149] = 12;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[151] = 12;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[152] = 41;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[153] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[154] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[155] = 800;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[156] = 480;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[157] = 256;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[158] = 256;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[159] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[160] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[161] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[162] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[163] = 800;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[164] = 480;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[165] = 47;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[166] = 27;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[167] = 25;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[170] = 86;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[171] = 42;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[172] = 14;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[183] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[184] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[185] = 66;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[186] = 8;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[190] = 225;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[191] = 495;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[192] = 26;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[193] = 26;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[194] = 48;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[195] = 164;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[196] = 250;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[197] = 308;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[198] = 100;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[199] = 500;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[200] = 97;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[201] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[202] = 313;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[203] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[204] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[205] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[206] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[207] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[208] = 81;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[209] = 55;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[214] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[215] = 0;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[210] = -31;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[211] = -54;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[212] = 17;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[213] = 9;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[216] = 21;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[217] = 35;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[218] = 19;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[219] = 24;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[220] = 24;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[221] = 95;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[222] = 32;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[223] = 43;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[224] = 40;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[225] = 65;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[226] = 58;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[227] = 15;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[229] = 12;
        LayoutMIB2HighQ7.DISTANCE_CONSTANTS[228] = 1154;
    }

    private static void initializeFloatConstants() {
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[0] = 4.0f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[1] = 1.55f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[2] = 0.07853982f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[3] = 1.3f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[4] = -5.0f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[5] = 6.0f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[6] = 4.0f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[7] = 3.0f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[8] = 16.0f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[9] = 18.0f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[13] = 0.5f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[12] = 0.5f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[11] = 0.5f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[10] = 0.5f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[14] = 1.0f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[16] = 0.935f;
        LayoutMIB2HighQ7.FLOAT_CONSTANTS[17] = 0.405f;
    }

    private static void initializeIntegerConstants() {
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[0] = 0;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[1] = 436;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[2] = 457;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[3] = 126;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[4] = 7;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[5] = 10;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[6] = 16;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[8] = 7;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[7] = 10;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[9] = 11;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[10] = 11;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[11] = 11;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[12] = 39;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[13] = 69;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[63] = 30;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[14] = 18;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[15] = 23;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[16] = 10;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[17] = 10;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[18] = 7;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[19] = 7;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[20] = 5;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[21] = 8;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[22] = 12;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[23] = 12;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[24] = 25;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[25] = 43;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[26] = 45;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[27] = 11;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[28] = 13;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[29] = 125;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[30] = 125;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[31] = 250;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[32] = 16;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[33] = 11;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[34] = 33;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[35] = 21;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[36] = 2;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[37] = 4;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[38] = 4;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[39] = 12;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[40] = 12;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[41] = 5;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[42] = 15;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[43] = 7;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[77] = 272;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[44] = 10;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[45] = 22;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[46] = 27;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[47] = 270;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[48] = 170;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[49] = 36;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[50] = 680;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[51] = 382;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[52] = 20;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[53] = 20;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[54] = 78;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[55] = 100;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[56] = 907;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[57] = 400;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[64] = 100;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[67] = 10;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[58] = 1045;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[59] = 199;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[60] = 1083;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[61] = 112;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[68] = 220;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[69] = 278;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[70] = 22;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[71] = 0;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[72] = 11;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[73] = -24;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[78] = -15;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[74] = 231;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[75] = 507;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[76] = 8;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[96] = 3;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[79] = -1;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[94] = 28;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[105] = 6;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[106] = 123;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[108] = 0;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[109] = 18;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[80] = 0;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[81] = 0;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[110] = -2;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[111] = -65;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[112] = 0;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[113] = 23;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[114] = 1024;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[115] = 436;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[118] = 59;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[119] = 27;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[120] = 210;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[121] = 153;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[122] = 59;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[123] = 27;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[124] = 210;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[125] = 153;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[126] = 20;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[127] = 20;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[128] = 23;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[129] = 20;
        LayoutMIB2HighQ7.INTEGER_CONSTANTS[130] = 14;
    }

    private static void initializeTextExportConstants() {
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[5] = 17;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[8] = 39;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[6] = 49;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[1] = 0;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[3] = 12;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[4] = 0;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[9] = 12;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[0] = 606;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[7] = 55;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[2] = 22;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[10] = 300;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[11] = 25;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[12] = 25;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[13] = 25;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[15] = 127;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[14] = 25;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[16] = 17;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[17] = 32;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[19] = 240;
        LayoutMIB2HighQ7.TEXT_EXPORT_CONSTANTS[18] = 9999;
    }

    public int[] getStaticBitmapParameters(int n) {
        return STATIC_BITMAP_PARAMETERS[n];
    }

    public int getRowHeight() {
        return 45;
    }

    public int getRowOverall() {
        return 50;
    }

    public int getRowHeightToolTip() {
        return 35;
    }

    public int getRowOverallToolTip() {
        return 40;
    }

    public int getDistance(int n) {
        try {
            return DISTANCE_CONSTANTS[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            IWidgetLogChannel.logChannel.log(10000, "LayoutMIBHigh#getDistance unknown distance type: %1 - returning 0", (long)n);
            return 0;
        }
    }

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
        AbstractWidget.logChannel.log(1000000, "LayoutMIBHigh#getDepth type: %1 is not supported by this layout", (long)n);
        return 0;
    }

    public float getFloatConstant(int n) {
        try {
            return FLOAT_CONSTANTS[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            IWidgetLogChannel.logChannel.log(10000, "LayoutMIBHigh#getFloatConstant unknown float constant type: %1 - returning 1.f", (long)n);
            return 1.0f;
        }
    }

    public int getIntegerConstant(int n) {
        try {
            return INTEGER_CONSTANTS[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            IWidgetLogChannel.logChannel.log(10000, "LayoutMIBHigh#getIntegerConstant unknown int constant type: %1 - returning 1", (long)n);
            return 1;
        }
    }

    public int getTextExportWidth(int n) {
        try {
            return TEXT_EXPORT_CONSTANTS[n];
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            IWidgetLogChannel.logChannel.log(10000, "LayoutMIBHigh#getTextExportWidth unknown type: %1 - returning 0", (long)n);
            return 0;
        }
    }

    public int getMenuLineWidth() {
        return 800;
    }

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
        AbstractWidget.logChannel.log(10000000, "LayoutMIBHigh#getTextPattern no pattern for noOfRows: %1", (long)n);
        return null;
    }

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
                return (int)((float)n * 1.360413f);
            }
            if (nArray[n] == 0) {
                nArray[n] = (int)((float)n * 1.360413f);
            }
        } else {
            nArray = MAP_FONT_SIZES_TO_PIXELS;
            if (n >= nArray.length) {
                AbstractWidget.logChannel.log(10000, "LayoutMIBHigh#getMappedFontSize no mapping for font with point-size: %1", (long)n);
                return (int)((float)n / 1.360413f);
            }
            if (nArray[n] == 0) {
                nArray[n] = (int)((float)n / 1.360413f);
            }
        }
        return nArray[n];
    }

    public String getSplashscreenPath() {
        return SPLASH_SCREEN_PATH;
    }

    public int[][] getTimeZoneImagePositions() {
        return TIME_ZONE_IMAGE_POSITONS;
    }

    public int[] getInstructionTextLayoutParams() {
        if (instructionTextLayoutParams == null) {
            instructionTextLayoutParams = new int[]{51, 96, 146, 197, 248, 299, 51, 102, 153, 204, 255, 51, 18, -3, 0, 24, 21, 0, 22, 15, 15, 35, 42, 17, 15, 15, 80, 131, 146, 197, 248, 299, 86, 137, 153, 204, 255, 51, 32, -3, 22, 22, 5, -7, 49, 0, 50, 42, 35, 30, 37, 4, 55};
        }
        return instructionTextLayoutParams;
    }

    public int[][] getMainWizardIconDecoratorMapping() {
        if (mainWizardIconDecoratorMapping == null) {
            mainWizardIconDecoratorMapping = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}, {7, 7}, {8, 8}, {9, 9}, {10, 10}, {11, 11}, {12, 3}, {13, 3}, {14, 5}, {15, 5}, {17, 12}, {18, 12}, {19, 12}, {20, 12}};
        }
        return mainWizardIconDecoratorMapping;
    }

    public int[] getMainWizardTextOffset() {
        if (mainWizardTextOffset == null) {
            mainWizardTextOffset = new int[]{0, -1, -1, -1, -1};
        }
        return mainWizardTextOffset;
    }

    public int[] getDisplayablePosition(int n) {
        return new int[]{0, 0};
    }

    public int getUserHintLabelOffset() {
        return 57;
    }

    static {
        LayoutMIB2HighQ7.initializeDistances();
        LayoutMIB2HighQ7.initializeFloatConstants();
        LayoutMIB2HighQ7.initializeTextExportConstants();
        LayoutMIB2HighQ7.initializeIntegerConstants();
    }
}

