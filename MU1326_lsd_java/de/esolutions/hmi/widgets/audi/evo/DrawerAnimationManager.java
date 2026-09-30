/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.tghu.hmi.evo.DrawerAnimationListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.AbstractScreenWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.DrawerController;

public interface DrawerAnimationManager {
    public static final String[] ANIMATION_NAMES = new String[]{"ANIMATION_INDEX_SELECTION_DRAWER_MAIN", "ANIMATION_INDEX_SELECTION_DRAWER_ICON", "ANIMATION_INDEX_OPTION_DRAWER_MAIN", "ANIMATION_INDEX_OPTION_DRAWER_ICON", "ANIMATION_INDEX_ENTERTAINMENT_DRAWER", "ANIMATION_INDEX_PARTIAL_POPUP_DESATURATION", "ANIMATION_INDEX_SDS", "ANIMATION_INDEX_VIEWSIZE", "ANIMATION_INDEX_DROPDOWN_BOX_DESATURATION", "ANIMATION_INDEX_SUBELEMENT_DESATURATION", "ANIMATION_INDEX_OPTION_SCREEN", "ANIMATION_INDEX_MAIN_AREA_DESATURATION", "ANIMATION_INDEX_SCREEN_CHANGE_PROGRESS"};
    public static final float DRAWER_ITEM_VALUE_INVISIBLE = 0.0f;
    public static final float DRAWER_ITEM_VALUE_VISIBLE = 1.0f;
    public static final int DRAWER_CLOSED = 1;
    public static final int DRAWER_OPENED = 2;
    public static final float SCREEN_FADE_OUT = 1.0f;
    public static final float SCREEN_FADE_IN = 0.0f;
    public static final float SDS_STATE_DISABLED = 0.0f;
    public static final float SDS_STATE_ENABLED = 1.0f;
    public static final int DESATURATION_ORIGIN_POPUP_FRONT = 0;
    public static final int DESATURATION_ORIGIN_POPUP_BEHIND = 1;
    public static final int DESATURATION_REQUEST_COUNT = 1;

    public void setDrawerState(int var1, boolean var2);

    public void setOptionDrawer(DrawerController var1, int var2);

    public void setSelectionDrawer(DrawerController var1, int var2);

    public void setEntertainmentDrawer(DrawerController var1, int var2);

    public void setScreen(AbstractScreenWidget var1, int var2);

    public void setDesaturationRequest(float var1, int var2);

    public void registerListener(DrawerAnimationListener var1);

    public void unregisterListener(DrawerAnimationListener var1);

    public void setViewSize(int var1, boolean var2);

    public void setSdsState(float var1, boolean var2);

    public void setViewSize(float var1, float[] var2, float[] var3);

    public void viewSizeChanged(float[] var1, float[] var2);

    public void closeCurrentOptionDrawer();

    public void initializeDrawerAnimation(DrawerAnimationListener var1);

    public void showSideOptionIcon(boolean var1);

    public void updateClosedDrawerIconVisibility();

    public void setIsEntertainmentDrawerVisible(boolean var1);

    public static class Helper {
        public static String getAnimationName(int n) {
            return ANIMATION_NAMES[n];
        }

        public static boolean hasFlag(int n, int n2) {
            return (n & 1 << n2) != 0;
        }

        public static String getMaskString(int n) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < ANIMATION_NAMES.length; ++i2) {
                if (!Helper.hasFlag(n, i2)) continue;
                buffer.append(ANIMATION_NAMES[i2]);
                buffer.append(' ');
            }
            return buffer.toString();
        }
    }
}

