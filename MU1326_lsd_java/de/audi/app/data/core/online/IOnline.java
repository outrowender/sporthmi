/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.online;

import org.dsi.ifc.bluetooth.ReconnectInfo;

public interface IOnline {
    public void notifyLocalNetMode();

    public void updateSimState(int var1, boolean var2, boolean var3, boolean var4);

    public void updateProfileState(int var1);

    public void updatePermissionGeneral(int var1);

    public void updatePermission(int var1, int var2);

    public void updatePermissionRoaming(int var1);

    public void roamingSettingDeactivatedByUser();

    public void wlanHotspotActive(boolean var1);

    public void onlineAppEntered();

    public void onlineAppLeft();

    public void onlineCheckEntered();

    public void onlineCheckLeft();

    public void onlinePopupEntered();

    public void onlinePopupLeft();

    public void onlinePopupRemoved();

    public void onlineRequestEntered(int var1);

    public void telAppEntered();

    public void telAppLeft();

    public void telUnlockEntered();

    public void telUnlockLeft();

    public void hkTelPressed();

    public void updateReconnectInfo(ReconnectInfo var1);

    public void updateWlanMode(boolean var1, boolean var2);

    public void updateTrustedNetworks(boolean var1);
}

