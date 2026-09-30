/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullSDSService
extends NullService
implements SDSService {
    public NullSDSService(LogChannel logChannel) {
        super(logChannel, "SDSService");
    }

    public void disablePTT(boolean bl, boolean bl2, byte by) {
        super.log();
    }

    public void sendResult(int n) {
        super.log();
    }

    public void sendEvent(int n, int n2) {
        super.log();
    }

    public void abortPostTraining() {
        super.log();
    }

    public void abortSDSSession(boolean bl, byte by) {
        super.log();
    }

    public boolean startDDSPress() {
        super.log();
        return false;
    }

    public void cancelDDSPress() {
        super.log();
    }

    public void endDDSPress() {
        super.log();
    }

    public void itemSelected(int n) {
        super.log();
    }

    public void folderUpSelected() {
        super.log();
    }

    public void turnDDSWheel() {
        super.log();
    }

    public void movedDDSJoystick(JoystickEvent joystickEvent) {
        super.log();
    }

    public boolean isSDSAborting() {
        super.log();
        return false;
    }

    public boolean isSDSActive() {
        super.log();
        return false;
    }

    public void keyTyped(int n, int n2) {
        super.log();
    }

    public void registerStatusListener(ISDSServiceStatusListener iSDSServiceStatusListener) {
        super.log();
    }

    public void unregisterStatusListener(ISDSServiceStatusListener iSDSServiceStatusListener) {
        super.log();
    }

    public void itemSelected(int n, int n2) {
        super.log();
    }

    public void playPrioPrompt(String string) {
        super.log();
    }

    public void cancelTimers() {
        super.log();
    }

    public void returnKeyPressed() {
        super.log();
    }

    public void startVolumeSettingSession() {
        super.log();
    }

    public void stopVolumeSettingSession() {
        super.log();
    }

    public void textChanged(int n, String string, char c2) {
        super.log();
    }

    public boolean isLowPrioPopup(int n) {
        super.log();
        return false;
    }

    public boolean isHighPrioPopup(int n) {
        super.log();
        return false;
    }

    public boolean isExternalSDSActive() {
        super.log();
        return false;
    }

    public void screenConnected(int n, int n2, boolean bl) {
    }

    public void screenConnectedWithSDSData(int n, int n2, SDSService.ScreenConnectedSDSData screenConnectedSDSData) {
    }

    public boolean isVolumeSettingSessionActive() {
        return false;
    }

    public void itemSelected(int n, int n2, int n3) {
        super.log();
    }

    public void sendResponse(int n, int n2) {
        super.log();
    }

    public void notifySpellerUserInteraction(int n) {
    }

    public void updateExternalSDSActive() {
        super.log();
    }
}

