/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal;

public interface EALViewportsAndLayers {
    public static final int LAYER_DEFAULT_INDEX = 0;
    public static final int VIEWPORT_SEAT_POPUPS = -60;
    public static final int VIEWPORT_MIXEDLIST = -50;
    public static final int VIEWPORT_COLOR_ROTARY_OFFSCREEN = -40;
    public static final int VIEWPORT_OPS_OFFSCREEN = -30;
    public static final int VIEWPORT_OFFSCREEN_SUB = -20;
    public static final int VIEWPORT_OFFSCREEN_MAIN = -10;
    public static final int VIEWPORT_BACKGROUND_IMAGE = 0;
    public static final int VIEWPORT_ARA = 100;
    public static final int VIEWPORT_CARVIEWER = 110;
    public static final int VIEWPORT_BELOW_SCREENS = 120;
    public static final int VIEWPORT_SCREENS = 130;
    public static final int VIEWPORT_DESATURATION_IMAGE = 140;
    public static final int VIEWPORT_ABOVE_SCREENS = 150;
    public static final int VIEWPORT_ABOVE_SCREENS_MAP_BORDER = 160;
    public static final int VIEWPORT_MAINWIZARD = 170;
    public static final int VIEWPORT_BALANCEFADER = 180;
    public static final int VIEWPORT_POPUPS_BEHIND_DRAWERS = 190;
    public static final int VIEWPORT_SELECTION_DRAWER = 200;
    public static final int VIEWPORT_MAIN = 210;
    public static final int VIEWPORT_MAIN_LAYER_SELECTION_DRAWER_CLOSED = 10;
    public static final int VIEWPORT_MAIN_LAYER_OPTION_DRAWER_CLOSED = 20;
    public static final int VIEWPORT_MAIN_LAYER_OPTION_DRAWER = 30;
    public static final int VIEWPORT_MAIN_LAYER_BETWEEN_DRAWER = 40;
    public static final int VIEWPORT_MAIN_LAYER_ENTERTAINMENT_DRAWER = 50;
    public static final int VIEWPORT_MAIN_LAYER_POPUP_IN_FRONT_OF_DRAWERS = 60;
    public static final int VIEWPORT_MAIN_LAYER_PRESET_POPUP = 70;
    public static final int VIEWPORT_MAIN_LAYER_SCREEN_PARTIAL_POPUPS = 80;
    public static final int VIEWPORT_G24_KDK_BACKGROUND = 220;
    public static final int VIEWPORT_VISUAL_FEEDBACK = 230;
    public static final int VIEWPORT_STATISTICS = 240;

    public static class Helper {
        public static boolean isOnlyOffscreenViewport(int n) {
            boolean bl;
            switch (n) {
                case -20: 
                case -10: {
                    bl = true;
                }
            }
            bl = false;
            return bl;
        }
    }
}

