/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;

public interface ICoMaList {
    public static final int CAT_PHONE = 0;
    public static final int CAT_DATA = 1;
    public static final int CAT_AUDI_CONNECT = 2;
    public static final int CAT_MEDIA = 3;
    public static final int CAT_OFFICE = 4;
    public static final int CAT_SECOND_PHONE = 5;
    public static final int CAT_SMARTPHONE = 6;
    public static final int CAT_MEDIA_WLAN = 7;

    public void languageChanged();

    public void updateDevices(AbstractCoMaDevice[] var1);

    public void setNewDeviceLineActivation(int var1, boolean var2, boolean var3);

    public void resetList();

    public void updateCategoryDeviceName(int var1, String var2);
}

