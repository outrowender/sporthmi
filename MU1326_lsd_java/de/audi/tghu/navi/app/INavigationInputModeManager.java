/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.NavigationEnv;

public interface INavigationInputModeManager {
    public static final int START_ROUTE_GUIDANCE_CHOICE_MODEL_STATUS = 0;
    public static final int ADDRESS_BOOK_CHOICE_MODEL_STATUS = 1;
    public static final int HOME_ADDRESS_MODEL_STATUS = 2;
    public static final int REMOTE_HMI_WEATHER = 4;
    public static final int REMOTE_HMI_ADDRESS = 5;
    public static final int ONLINE_SEARCH_AREA = 6;
    public static final int TOURPLAN = 7;
    public static final int OFFICE_ADDRESS_MODEL_STATUS = 8;
    public static final int DEMO_MODE = 9;
    public static final int FAVORITE_ADDRESS_MODEL_STATUS = 10;
    public static final int EDIT_SAVED_FAVORITE_ADDRESS_MODEL_STATUS = 11;

    public void setInputMode(int var1, NavigationEnv var2);

    public int getInputMode();

    public void setSdsActiveStatus(boolean var1);

    public boolean isSdsActive();

    public void setSdsDestinationType(int var1);

    public int getSdsDestinationType();

    public void resetSDSDestinationType();

    public boolean isNavigationActive();

    public void setNavigationActive(boolean var1);

    public void setTpegPOIActive(boolean var1);

    public boolean isTpegPOIActive();
}

