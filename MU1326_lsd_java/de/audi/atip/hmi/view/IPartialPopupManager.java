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
    public static final int SLOT_DEFAULT_POPUPS = 0;
    public static final int SLOT_POPINS_LEFT = 1;
    public static final int SLOT_POPINS_RIGHT = 2;
    public static final int SLOT_STATUSBAR = 3;
    public static final int SLOT_PARKING_POPUPS = 4;
    public static final int SLOT_DEBUG_INFOS = 5;
    public static final int SLOT_SMALL_STAGE_DECORATOR = 6;
    public static final int SLOT_SMALL_COMMAND_DISPlAY_ACTIVATOR = 7;
    public static final int SLOT_PARKING_POPUPS_2 = 8;
    public static final int SLOT_PARKING_POPUPS_3 = 9;
    public static final int SLOT_USER_HINTS = 10;
    public static final int SLOT_OSD = 11;
    public static final int SLOT_GREY_OUT_DUMMY_SLOT_G24 = 12;
    public static final int SLOT_CONVERSION_MATRIX = 13;
    public static final int NUM_SLOTS = 14;
    public static final int[] SLOTS_ALL_POPINS = new int[]{1, 2};

    public int showPopup(int var1);

    public int hidePopup(int var1);

    public IPartialPopupController getPartialPopup(int var1);

    public void setPartialPopupsEnabled(boolean var1);

    public boolean hasVisiblePopupInSlot(int var1);

    public IPartialPopupController getCurrentVisiblePopup(int var1);

    public void oldScreenDisconnecting(Screen var1);

    public void processLanguageChangedEvent(LanguageChangedEvent var1);

    public void hideAllPopupsAndRepaintScreen(int var1);

    public int hidePopupAndRepaintScreen(int var1);

    public int showPopupAndRepaintScreen(int var1);

    public String[] getRegisteredPopupsDebugOutput();

    public String[] getVisiblePopupsDebugOutput();

    public void checkPriosAgainstFullScreenPopup();
}

