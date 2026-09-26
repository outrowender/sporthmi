/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

public interface IRemoteHMIEsimLicenseListener {
    public static final int UNKNOWN_STATE;
    public static final int TEASER_STATE;
    public static final int EXPIRED_STATE;
    public static final int LICENSED_STATE;
    public static final int NOT_LICENSED_STATE;

    default public void updateLicenseState(int n) {
    }
}

