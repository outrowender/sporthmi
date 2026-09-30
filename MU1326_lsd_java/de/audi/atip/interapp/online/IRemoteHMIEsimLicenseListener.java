/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

public interface IRemoteHMIEsimLicenseListener {
    public static final int UNKNOWN_STATE = 1;
    public static final int TEASER_STATE = 2;
    public static final int EXPIRED_STATE = 3;
    public static final int LICENSED_STATE = 4;
    public static final int NOT_LICENSED_STATE = 5;

    public void updateLicenseState(int var1);
}

