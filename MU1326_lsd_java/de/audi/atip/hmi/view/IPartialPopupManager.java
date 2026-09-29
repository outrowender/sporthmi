/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

import de.audi.atip.hmi.event.GestureEventListener;
import de.audi.atip.hmi.event.LanguageChangedEvent;
import de.audi.atip.hmi.event.TouchPadEventListener;
import de.audi.atip.hmi.view.IPartialPopupController;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.i18n.I18NTarget;

public interface IPartialPopupManager
extends TouchPadEventListener,
GestureEventListener,
I18NTarget {
    public static final int SLOT_DEFAULT_POPUPS;
    public static final int SLOT_POPINS_LEFT;
    public static final int SLOT_POPINS_RIGHT;
    public static final int SLOT_STATUSBAR;
    public static final int SLOT_PARKING_POPUPS;
    public static final int SLOT_DEBUG_INFOS;
    public static final int SLOT_SMALL_STAGE_DECORATOR;
    public static final int SLOT_SMALL_COMMAND_DISPlAY_ACTIVATOR;
    public static final int SLOT_PARKING_POPUPS_2;
    public static final int SLOT_PARKING_POPUPS_3;
    public static final int SLOT_USER_HINTS;
    public static final int SLOT_OSD;
    public static final int SLOT_GREY_OUT_DUMMY_SLOT_G24;
    public static final int SLOT_CONVERSION_MATRIX;
    public static final int NUM_SLOTS;
    public static final int[] SLOTS_ALL_POPINS;

    default public int showPopup(int n) {
    }

    default public int hidePopup(int n) {
    }

    default public IPartialPopupController getPartialPopup(int n) {
    }

    default public void setPartialPopupsEnabled(boolean bl) {
    }

    default public boolean hasVisiblePopupInSlot(int n) {
    }

    default public IPartialPopupController getCurrentVisiblePopup(int n) {
    }

    default public void oldScreenDisconnecting(Screen screen) {
    }

    default public void processLanguageChangedEvent(LanguageChangedEvent languageChangedEvent) {
    }

    default public void hideAllPopupsAndRepaintScreen(int n) {
    }

    default public int hidePopupAndRepaintScreen(int n) {
    }

    default public int showPopupAndRepaintScreen(int n) {
    }

    default public String[] getRegisteredPopupsDebugOutput() {
    }

    default public String[] getVisiblePopupsDebugOutput() {
    }

    default public void checkPriosAgainstFullScreenPopup() {
    }

    static {
        SLOTS_ALL_POPINS = new int[]{1, 2};
    }
}

