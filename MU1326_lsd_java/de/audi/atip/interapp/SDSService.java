/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.interapp.AbstractSDSService;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService$ScreenConnectedSDSData;

public interface SDSService
extends AbstractSDSService {
    public static final byte SDS_ABORTER_NONE;
    public static final byte SDS_ABORTER_VOICE_COMMAND;
    public static final byte SDS_ABORTER_APS_OPS_RVC;
    public static final byte SDS_ABORTER_KBD;
    public static final byte SDS_ABORTER_WIDGET;
    public static final byte SDS_ABORTER_ADB;
    public static final byte SDS_ABORTER_MEDIA;
    public static final byte SDS_ABORTER_NAVI;
    public static final byte SDS_ABORTER_PHONE;
    public static final byte SDS_ABORTER_TUNER;
    public static final byte SDS_ABORTER_VOLUME_SETTING;
    public static final byte SDS_ABORTER_ONLINE;
    public static final byte SDS_ABORTER_POPUP;
    public static final byte SDS_ABORTER_PTT_DOUBLE;
    public static final byte SDS_ABORTER_PTT_LONG;

    default public void playPrioPrompt(String string) {
    }

    default public void itemSelected(int n, int n2) {
    }

    default public void itemSelected(int n, int n2, int n3) {
    }

    default public void keyTyped(int n, int n2) {
    }

    default public void folderUpSelected() {
    }

    default public void notifySpellerUserInteraction(int n) {
    }

    default public void abortSDSSession(boolean bl, byte by) {
    }

    default public void returnKeyPressed() {
    }

    default public boolean startDDSPress() {
    }

    default public void cancelDDSPress() {
    }

    default public void endDDSPress() {
    }

    default public void turnDDSWheel() {
    }

    default public void movedDDSJoystick(JoystickEvent joystickEvent) {
    }

    default public void registerStatusListener(ISDSServiceStatusListener iSDSServiceStatusListener) {
    }

    default public void unregisterStatusListener(ISDSServiceStatusListener iSDSServiceStatusListener) {
    }

    default public void cancelTimers() {
    }

    default public void startVolumeSettingSession() {
    }

    default public void stopVolumeSettingSession() {
    }

    default public boolean isVolumeSettingSessionActive() {
    }

    default public void textChanged(int n, String string, char c2) {
    }

    default public boolean isExternalSDSActive() {
    }

    default public void screenConnected(int n, int n2, boolean bl) {
    }

    default public void screenConnectedWithSDSData(int n, int n2, ScreenConnectedSDSData screenConnectedSDSData) {
    }

    default public void sendResponse(int n, int n2) {
    }

    default public void updateExternalSDSActive() {
    }
}

