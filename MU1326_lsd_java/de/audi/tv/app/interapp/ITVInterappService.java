/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

public interface ITVInterappService {
    public void setActiveStation(long var1);

    public void setTerminalMode(byte var1);

    public void sendPressedPanelKey(short var1);

    public void logonToTV();

    public void logoffFromTV();
}

