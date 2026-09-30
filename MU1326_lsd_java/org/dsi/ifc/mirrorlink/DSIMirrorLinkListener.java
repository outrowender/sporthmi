/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.mirrorlink;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.mirrorlink.Application;
import org.dsi.ifc.mirrorlink.Device;
import org.dsi.ifc.mirrorlink.Notification;

public interface DSIMirrorLinkListener
extends DSIListener {
    public void responseClientCapabilities(int var1);

    public void responseAccessMode(int var1, int var2);

    public void responseDayNightMode(int var1, int var2);

    public void responseUsableViewPort(int var1, int var2, int var3, int var4, int var5);

    public void responseContextVisible(boolean var1, int var2);

    public void responseConnectDevice(int var1, int var2);

    public void responseDisconnectDevice(int var1, int var2);

    public void responseRotateScreen(int var1, int var2);

    public void responseSoftKeyEvent(int var1, int var2, int var3);

    public void responseLaunchApp(int var1, int var2);

    public void responseTerminateApp(int var1, int var2);

    public void responseSpellerResult(String var1, String var2, boolean var3, int var4);

    public void responseSendString(int var1);

    public void responseAudioOption(int var1, int var2);

    public void responseAudioConnectionAudible(int var1, boolean var2, int var3);

    public void responseSendTouchEvents(int var1);

    public void updateDiscoveredDevices(Device[] var1, int var2);

    public void updateDeviceConnectionStatus(int var1, int var2, int var3);

    public void updateDeviceSoftKeys(int[] var1, int var2);

    public void updateApplicationStatus(int var1, int var2, int var3, int var4);

    public void updateScreenOrientation(int var1, int var2);

    public void updateShowKeyboard(int var1, String var2, int var3);

    public void updateScreenOrientationAvailable(boolean var1, int var2);

    public void updateScreenRotationAvailable(boolean var1, int var2);

    public void updateAudioConnectionRequested(int var1, boolean var2, int var3);

    public void responseKeyboardMode(int var1, int var2);

    public void updateAvailableApplicationsList(int var1, int var2);

    public void responseAvailableApplicationsWindow(int var1, Application[] var2, int var3);

    public void updateSingleApplicationMode(boolean var1, int var2);

    public void responseDisplayKeyboard(int var1, int var2);

    public void responseDismissHMIKeyboard(int var1);

    public void responseFactorySettings(int var1);

    public void updatePhoneViewAvailable(boolean var1, int var2);

    public void responsePhoneView(int var1);

    public void updateUncertifiedContent(boolean var1, int var2);

    public void updateDeviceStatus(int var1, int var2);

    public void updateSWaPStatus(int var1, int var2);

    public void responseContextSwitched();

    public void updateShowNotification(Notification var1, int var2);

    public void updateNotificationServiceEnabled(boolean var1, int var2);

    public void updateLocationDataServicesEnabled(boolean var1, int var2);

    public void updateSwitchToClientNativeUI(int var1);
}

