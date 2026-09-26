/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;

public interface DrawerAnimationManager {
    public static final String[] ANIMATION_NAMES = new String[]{"ANIMATION_INDEX_SELECTION_DRAWER_MAIN", "ANIMATION_INDEX_SELECTION_DRAWER_ICON", "ANIMATION_INDEX_OPTION_DRAWER_MAIN", "ANIMATION_INDEX_OPTION_DRAWER_ICON", "ANIMATION_INDEX_ENTERTAINMENT_DRAWER", "ANIMATION_INDEX_PARTIAL_POPUP_DESATURATION", "ANIMATION_INDEX_SDS", "ANIMATION_INDEX_VIEWSIZE", "ANIMATION_INDEX_DROPDOWN_BOX_DESATURATION", "ANIMATION_INDEX_SUBELEMENT_DESATURATION", "ANIMATION_INDEX_OPTION_SCREEN", "ANIMATION_INDEX_MAIN_AREA_DESATURATION", "ANIMATION_INDEX_SCREEN_CHANGE_PROGRESS"};
    public static final float DRAWER_ITEM_VALUE_INVISIBLE;
    public static final float DRAWER_ITEM_VALUE_VISIBLE;
    public static final int DRAWER_CLOSED;
    public static final int DRAWER_OPENED;
    public static final float SCREEN_FADE_OUT;
    public static final float SCREEN_FADE_IN;
    public static final float SDS_STATE_DISABLED;
    public static final float SDS_STATE_ENABLED;
    public static final int DESATURATION_ORIGIN_POPUP_FRONT;
    public static final int DESATURATION_ORIGIN_POPUP_BEHIND;
    public static final int DESATURATION_REQUEST_COUNT;

    default public void setDrawerState(int n, boolean bl) {
    }

    default public void setOptionDrawer(DrawerController drawerController, int n) {
    }

    default public void setSelectionDrawer(DrawerController drawerController, int n) {
    }

    default public void setEntertainmentDrawer(DrawerController drawerController, int n) {
    }

    default public void setScreen(AbstractScreenWidget abstractScreenWidget, int n) {
    }

    default public void setDesaturationRequest(float f2, int n) {
    }

    default public void registerListener(DrawerAnimationListener drawerAnimationListener) {
    }

    default public void unregisterListener(DrawerAnimationListener drawerAnimationListener) {
    }

    default public void setViewSize(int n, boolean bl) {
    }

    default public void setSdsState(float f2, boolean bl) {
    }

    default public void setViewSize(float f2, float[] fArray, float[] fArray2) {
    }

    default public void viewSizeChanged(float[] fArray, float[] fArray2) {
    }

    default public void closeCurrentOptionDrawer() {
    }

    default public void initializeDrawerAnimation(DrawerAnimationListener drawerAnimationListener) {
    }

    default public void showSideOptionIcon(boolean bl) {
    }

    default public void updateClosedDrawerIconVisibility() {
    }

    default public void setIsEntertainmentDrawerVisible(boolean bl) {
    }
}

