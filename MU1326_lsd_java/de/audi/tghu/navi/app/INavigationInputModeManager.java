/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.NavigationEnv;

public interface INavigationInputModeManager {
    public static final int START_ROUTE_GUIDANCE_CHOICE_MODEL_STATUS;
    public static final int ADDRESS_BOOK_CHOICE_MODEL_STATUS;
    public static final int HOME_ADDRESS_MODEL_STATUS;
    public static final int REMOTE_HMI_WEATHER;
    public static final int REMOTE_HMI_ADDRESS;
    public static final int ONLINE_SEARCH_AREA;
    public static final int TOURPLAN;
    public static final int OFFICE_ADDRESS_MODEL_STATUS;
    public static final int DEMO_MODE;
    public static final int FAVORITE_ADDRESS_MODEL_STATUS;
    public static final int EDIT_SAVED_FAVORITE_ADDRESS_MODEL_STATUS;

    default public void setInputMode(int n, NavigationEnv navigationEnv) {
    }

    default public int getInputMode() {
    }

    default public void setSdsActiveStatus(boolean bl) {
    }

    default public boolean isSdsActive() {
    }

    default public void setSdsDestinationType(int n) {
    }

    default public int getSdsDestinationType() {
    }

    default public void resetSDSDestinationType() {
    }

    default public boolean isNavigationActive() {
    }

    default public void setNavigationActive(boolean bl) {
    }

    default public void setTpegPOIActive(boolean bl) {
    }

    default public boolean isTpegPOIActive() {
    }
}

