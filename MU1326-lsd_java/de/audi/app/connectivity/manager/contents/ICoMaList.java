/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;

public interface ICoMaList {
    public static final int CAT_PHONE;
    public static final int CAT_DATA;
    public static final int CAT_AUDI_CONNECT;
    public static final int CAT_MEDIA;
    public static final int CAT_OFFICE;
    public static final int CAT_SECOND_PHONE;
    public static final int CAT_SMARTPHONE;
    public static final int CAT_MEDIA_WLAN;

    default public void languageChanged() {
    }

    default public void updateDevices(AbstractCoMaDevice[] abstractCoMaDeviceArray) {
    }

    default public void setNewDeviceLineActivation(int n, boolean bl, boolean bl2) {
    }

    default public void resetList() {
    }

    default public void updateCategoryDeviceName(int n, String string) {
    }
}

