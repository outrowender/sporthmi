/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.view.Screen;

public interface IScreenData {
    public static final int SCREEN_ID_INVALID;
    public static final int DRAWER_ID_INVALID;
    public static final int CURSOR_FOCUS_INVALID;
    public static final int SCREEN_MODE_NONE;
    public static final int SCREEN_MODE_STANDARD_SCREEN;
    public static final int SCREEN_MODE_OPTION_SCREEN;

    default public String toString() {
    }

    default public int getId() {
    }

    default public int[] getPartialPopups() {
    }

    default public int getPopupId() {
    }

    default public int getPopupPriority() {
    }

    default public Screen getScreen() {
    }

    default public int[] getStates() {
    }

    default public boolean isAnimated() {
    }

    default public boolean isLocked() {
    }

    default public boolean isNotify() {
    }

    default public boolean isReinit() {
    }

    default public boolean isScreenIDValid() {
    }

    default public void setNotify(boolean bl) {
    }

    default public void setPartialPopups(int[] nArray) {
    }

    default public boolean isPartialPopupAvailable() {
    }

    default public boolean isPopup() {
    }

    default public void setScreen(Screen screen) {
    }

    default public void setContextIDs(long[] lArray) {
    }

    default public long[] getContextIDs() {
    }

    default public long getOptionsDrawerID() {
    }

    default public long getSelectionDrawerID() {
    }

    default public int getAnimationInfo() {
    }

    default public void setColorScheme(int n) {
    }

    default public int getColorScheme() {
    }

    default public void setScreenMode(int n) {
    }

    default public int getScreenMode() {
    }

    default public int getCursorPosition() {
    }

    default public boolean isStayOnFocusedElement() {
    }
}

