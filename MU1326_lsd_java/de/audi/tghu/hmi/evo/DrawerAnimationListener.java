/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface DrawerAnimationListener {
    public static final int ANIMATION_INDEX_SELECTION_DRAWER_MAIN = 0;
    public static final int ANIMATION_INDEX_SELECTION_DRAWER_ICON = 1;
    public static final int ANIMATION_INDEX_OPTION_DRAWER_MAIN = 2;
    public static final int ANIMATION_INDEX_OPTION_DRAWER_ICON = 3;
    public static final int ANIMATION_INDEX_ENTERTAINMENT_DRAWER = 4;
    public static final int ANIMATION_INDEX_PARTIAL_POPUP_DESATURATION = 5;
    public static final int ANIMATION_INDEX_SDS = 6;
    public static final int ANIMATION_INDEX_VIEWSIZE = 7;
    public static final int ANIMATION_INDEX_DROPDOWN_BOX_DESATURATION = 8;
    public static final int ANIMATION_INDEX_SUBELEMENT_DESATURATION = 9;
    public static final int ANIMATION_INDEX_OPTION_SCREEN = 10;
    public static final int ANIMATION_INDEX_MAIN_AREA_DESATURATION = 11;
    public static final int ANIMATION_INDEX_SCREEN_CHANGE_PROGRESS = 12;
    public static final int ANIMATION_INDEX_SUPERIMPOSED_PARTIAL_POPUP_DESATURATION = 13;
    public static final int ANIMATION_COUNT = 14;

    public void initializeDrawerAnimation(float[] var1, float[] var2);

    public void drawerAnimationTargetChanged(float[] var1, float[] var2, int var3);

    public void setDrawerAnimation(float[] var1, float[] var2, int var3);

    public void drawerAnimationFinished(float[] var1, float[] var2, int var3);

    public int getDrawerAnimationMask();
}

