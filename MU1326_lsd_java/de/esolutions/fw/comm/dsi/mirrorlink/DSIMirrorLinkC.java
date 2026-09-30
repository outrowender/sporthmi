/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mirrorlink;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.mirrorlink.ClientCapabilities;
import org.dsi.ifc.mirrorlink.Event;

public interface DSIMirrorLinkC {
    public void requestClientCapabilities(ClientCapabilities var1) throws MethodException;

    public void requestAccessMode(int var1) throws MethodException;

    public void requestDayNightMode(int var1) throws MethodException;

    public void requestUsableViewport(int var1, int var2, int var3, int var4) throws MethodException;

    public void requestContextVisible(boolean var1) throws MethodException;

    public void requestConnectDevice(int var1) throws MethodException;

    public void requestDisconnectDevice(int var1) throws MethodException;

    public void requestRotateScreen(int var1) throws MethodException;

    public void requestChangeOrientation(int var1) throws MethodException;

    public void requestSoftKeyEvent(int var1, int var2) throws MethodException;

    public void requestLaunchApp(int var1) throws MethodException;

    public void requestTerminateApp(int var1) throws MethodException;

    public void requestStartSpeller(String var1) throws MethodException;

    public void requestAddSpellerChars(String var1) throws MethodException;

    public void requestRemoveSpellerChar() throws MethodException;

    public void requestClearSpeller() throws MethodException;

    public void requestSendString(String var1) throws MethodException;

    public void requestAudioOption(int var1) throws MethodException;

    public void requestAudioConnectionAudible(int var1, boolean var2) throws MethodException;

    public void requestSendTouchEvents(Event[] var1, int var2) throws MethodException;

    public void requestKeyboardMode(int var1) throws MethodException;

    public void requestAvailableApplicationsWindow(int var1, int var2) throws MethodException;

    public void requestDisplayKeyboard() throws MethodException;

    public void requestDismissHMIKeyboard() throws MethodException;

    public void requestFactorySettings() throws MethodException;

    public void requestPhoneView() throws MethodException;

    public void requestContextSwitched(boolean var1) throws MethodException;

    public void invokeNotiAction(int var1, int var2) throws MethodException;

    public void requestNotificationServiceEnabled(boolean var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void requestLocationDataServicesEnabled(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

