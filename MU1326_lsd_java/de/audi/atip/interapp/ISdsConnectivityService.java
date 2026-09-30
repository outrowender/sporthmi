/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface ISdsConnectivityService {
    public void disclaimerAccept();

    public void activateNadModule();

    public void acceptOnce();

    public void acceptAlways();

    public void reject();

    public void activateOnlineConnection();

    public void deactivateOnlineConnection();

    public void activateRoaming();

    public void confirmRoaming();

    public void declineRoaming();
}

