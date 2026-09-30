/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.mirrorlink.Application;
import org.dsi.ifc.mirrorlink.Device;
import org.dsi.ifc.mirrorlink.Notification;

public interface DSIMirrorLinkReply {
    public static final String IPL_COMM_UUID = "6fc7566e-a8c2-57e2-8cf0-22c0e333afe3";
    public static final String IPL_COMM_INTERFACE_KEY = "aeae54ea-8c0f-58f6-bd12-0a4bd5ec2950";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.13";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.13";

    public void responseClientCapabilities(int var1) throws MethodException;

    public void responseAccessMode(int var1, int var2) throws MethodException;

    public void responseDayNightMode(int var1, int var2) throws MethodException;

    public void responseUsableViewPort(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void responseContextVisible(boolean var1, int var2) throws MethodException;

    public void responseConnectDevice(int var1, int var2) throws MethodException;

    public void responseDisconnectDevice(int var1, int var2) throws MethodException;

    public void responseRotateScreen(int var1, int var2) throws MethodException;

    public void responseSoftKeyEvent(int var1, int var2, int var3) throws MethodException;

    public void responseLaunchApp(int var1, int var2) throws MethodException;

    public void responseTerminateApp(int var1, int var2) throws MethodException;

    public void responseSpellerResult(String var1, String var2, boolean var3, int var4) throws MethodException;

    public void responseSendString(int var1) throws MethodException;

    public void responseAudioOption(int var1, int var2) throws MethodException;

    public void responseAudioConnectionAudible(int var1, boolean var2, int var3) throws MethodException;

    public void responseSendTouchEvents(int var1) throws MethodException;

    public void updateDiscoveredDevices(Device[] var1, int var2) throws MethodException;

    public void updateDeviceConnectionStatus(int var1, int var2, int var3) throws MethodException;

    public void updateDeviceSoftKeys(int[] var1, int var2) throws MethodException;

    public void updateApplicationStatus(int var1, int var2, int var3, int var4) throws MethodException;

    public void updateScreenOrientation(int var1, int var2) throws MethodException;

    public void updateShowKeyboard(int var1, String var2, int var3) throws MethodException;

    public void updateScreenOrientationAvailable(boolean var1, int var2) throws MethodException;

    public void updateScreenRotationAvailable(boolean var1, int var2) throws MethodException;

    public void updateAudioConnectionRequested(int var1, boolean var2, int var3) throws MethodException;

    public void responseKeyboardMode(int var1, int var2) throws MethodException;

    public void updateAvailableApplicationsList(int var1, int var2) throws MethodException;

    public void responseAvailableApplicationsWindow(int var1, Application[] var2, int var3) throws MethodException;

    public void updateSingleApplicationMode(boolean var1, int var2) throws MethodException;

    public void responseDisplayKeyboard(int var1, int var2) throws MethodException;

    public void responseDismissHMIKeyboard(int var1) throws MethodException;

    public void responseFactorySettings(int var1) throws MethodException;

    public void updatePhoneViewAvailable(boolean var1, int var2) throws MethodException;

    public void responsePhoneView(int var1) throws MethodException;

    public void updateUncertifiedContent(boolean var1, int var2) throws MethodException;

    public void updateDeviceStatus(int var1, int var2) throws MethodException;

    public void updateSWaPStatus(int var1, int var2) throws MethodException;

    public void responseContextSwitched() throws MethodException;

    public void updateShowNotification(Notification var1, int var2) throws MethodException;

    public void updateNotificationServiceEnabled(boolean var1, int var2) throws MethodException;

    public void updateLocationDataServicesEnabled(boolean var1, int var2) throws MethodException;

    public void updateSwitchToClientNativeUI(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

