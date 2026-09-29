/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

public interface DrawerAnimationListener {
    public static final int ANIMATION_INDEX_SELECTION_DRAWER_MAIN;
    public static final int ANIMATION_INDEX_SELECTION_DRAWER_ICON;
    public static final int ANIMATION_INDEX_OPTION_DRAWER_MAIN;
    public static final int ANIMATION_INDEX_OPTION_DRAWER_ICON;
    public static final int ANIMATION_INDEX_ENTERTAINMENT_DRAWER;
    public static final int ANIMATION_INDEX_PARTIAL_POPUP_DESATURATION;
    public static final int ANIMATION_INDEX_SDS;
    public static final int ANIMATION_INDEX_VIEWSIZE;
    public static final int ANIMATION_INDEX_DROPDOWN_BOX_DESATURATION;
    public static final int ANIMATION_INDEX_SUBELEMENT_DESATURATION;
    public static final int ANIMATION_INDEX_OPTION_SCREEN;
    public static final int ANIMATION_INDEX_MAIN_AREA_DESATURATION;
    public static final int ANIMATION_INDEX_SCREEN_CHANGE_PROGRESS;
    public static final int ANIMATION_INDEX_SUPERIMPOSED_PARTIAL_POPUP_DESATURATION;
    public static final int ANIMATION_COUNT;

    default public void initializeDrawerAnimation(float[] fArray, float[] fArray2) {
    }

    default public void drawerAnimationTargetChanged(float[] fArray, float[] fArray2, int n) {
    }

    default public void setDrawerAnimation(float[] fArray, float[] fArray2, int n) {
    }

    default public void drawerAnimationFinished(float[] fArray, float[] fArray2, int n) {
    }

    default public int getDrawerAnimationMask() {
    }
}

