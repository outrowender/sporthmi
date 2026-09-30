/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.accessibility;

public interface ISupportedBtProfiles {
    public static final int SERVICE_CLASS_PHONE = 0;
    public static final int SERVICE_CLASS_DATA = 1;
    public static final int SERVICE_CLASS_AUDI_CONNECT = 2;
    public static final int SERVICE_CLASS_MEDIA = 3;
    public static final int SERVICE_CLASS_OFFICE = 4;
    public static final int SERVICE_CLASS_MEDIA_WLAN = 5;
    public static final int SERVICE_CLASS_ALL = 6;

    public int getConnectableServices(int var1, boolean var2);

    public boolean isHfpSupportFaked();
}

