/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.interapp.ISDSServiceStatusListener;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.SDSService$ScreenConnectedSDSData;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullSDSService
extends NullService
implements SDSService {
    public NullSDSService(LogChannel logChannel) {
        super(logChannel, "SDSService");
    }

    @Override
    public void disablePTT(boolean bl, boolean bl2, byte by) {
        super.log();
    }

    @Override
    public void sendResult(int n) {
        super.log();
    }

    public void sendEvent(int n, int n2) {
        super.log();
    }

    @Override
    public void abortPostTraining() {
        super.log();
    }

    @Override
    public void abortSDSSession(boolean bl, byte by) {
        super.log();
    }

    @Override
    public boolean startDDSPress() {
        super.log();
        return false;
    }

    @Override
    public void cancelDDSPress() {
        super.log();
    }

    @Override
    public void endDDSPress() {
        super.log();
    }

    public void itemSelected(int n) {
        super.log();
    }

    @Override
    public void folderUpSelected() {
        super.log();
    }

    @Override
    public void turnDDSWheel() {
        super.log();
    }

    @Override
    public void movedDDSJoystick(JoystickEvent joystickEvent) {
        super.log();
    }

    @Override
    public boolean isSDSAborting() {
        super.log();
        return false;
    }

    @Override
    public boolean isSDSActive() {
        super.log();
        return false;
    }

    @Override
    public void keyTyped(int n, int n2) {
        super.log();
    }

    @Override
    public void registerStatusListener(ISDSServiceStatusListener iSDSServiceStatusListener) {
        super.log();
    }

    @Override
    public void unregisterStatusListener(ISDSServiceStatusListener iSDSServiceStatusListener) {
        super.log();
    }

    @Override
    public void itemSelected(int n, int n2) {
        super.log();
    }

    @Override
    public void playPrioPrompt(String string) {
        super.log();
    }

    @Override
    public void cancelTimers() {
        super.log();
    }

    @Override
    public void returnKeyPressed() {
        super.log();
    }

    @Override
    public void startVolumeSettingSession() {
        super.log();
    }

    @Override
    public void stopVolumeSettingSession() {
        super.log();
    }

    @Override
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

    @Override
    public boolean isExternalSDSActive() {
        super.log();
        return false;
    }

    @Override
    public void screenConnected(int n, int n2, boolean bl) {
    }

    @Override
    public void screenConnectedWithSDSData(int n, int n2, SDSService$ScreenConnectedSDSData sDSService$ScreenConnectedSDSData) {
    }

    @Override
    public boolean isVolumeSettingSessionActive() {
        return false;
    }

    @Override
    public void itemSelected(int n, int n2, int n3) {
        super.log();
    }

    @Override
    public void sendResponse(int n, int n2) {
        super.log();
    }

    @Override
    public void notifySpellerUserInteraction(int n) {
    }

    @Override
    public void updateExternalSDSActive() {
        super.log();
    }
}

