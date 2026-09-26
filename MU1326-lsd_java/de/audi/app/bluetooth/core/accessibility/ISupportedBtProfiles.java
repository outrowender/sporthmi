/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.accessibility;

public interface ISupportedBtProfiles {
    public static final int SERVICE_CLASS_PHONE;
    public static final int SERVICE_CLASS_DATA;
    public static final int SERVICE_CLASS_AUDI_CONNECT;
    public static final int SERVICE_CLASS_MEDIA;
    public static final int SERVICE_CLASS_OFFICE;
    public static final int SERVICE_CLASS_MEDIA_WLAN;
    public static final int SERVICE_CLASS_ALL;

    default public int getConnectableServices(int n, boolean bl) {
    }

    default public boolean isHfpSupportFaked() {
    }
}

