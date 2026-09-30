/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.Screen;

public interface IScreenData {
    public static final int SCREEN_ID_INVALID = -1;
    public static final int DRAWER_ID_INVALID = -1;
    public static final int CURSOR_FOCUS_INVALID = -1;
    public static final int SCREEN_MODE_NONE = -1;
    public static final int SCREEN_MODE_STANDARD_SCREEN = 1;
    public static final int SCREEN_MODE_OPTION_SCREEN = 2;

    public String toString();

    public int getId();

    public int[] getPartialPopups();

    public int getPopupId();

    public int getPopupPriority();

    public Screen getScreen();

    public int[] getStates();

    public boolean isAnimated();

    public boolean isLocked();

    public boolean isNotify();

    public boolean isReinit();

    public boolean isScreenIDValid();

    public void setNotify(boolean var1);

    public void setPartialPopups(int[] var1);

    public boolean isPartialPopupAvailable();

    public boolean isPopup();

    public void setScreen(Screen var1);

    public void setContextIDs(long[] var1);

    public long[] getContextIDs();

    public long getOptionsDrawerID();

    public long getSelectionDrawerID();

    public int getAnimationInfo();

    public void setColorScheme(int var1);

    public int getColorScheme();

    public void setScreenMode(int var1);

    public int getScreenMode();

    public int getCursorPosition();

    public boolean isStayOnFocusedElement();
}

