/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.JoystickEvent;
import de.audi.atip.interapp.AbstractSDSService;

public interface SDSHandlerService
extends AbstractSDSService {
    default public void abortSDSSession(boolean bl) {
    }

    default public void sendEvent(int n) {
    }

    default public void sendDDSEvent(int n, int n2) {
    }

    default public void sendResumeEvent(boolean bl) {
    }

    default public void sendSpeechSMEvent(int n, boolean bl, boolean bl2) {
    }

    default public void sendDDSSpeechSMEvent(int n) {
    }

    default public void sendResultEvent(int n) {
    }

    default public void sendResultEvent(int n, boolean bl) {
    }

    @Override
    default public void sendResult(int n) {
    }

    default public boolean isSDSPaused() {
    }

    default public boolean isSDSWaiting() {
    }

    default public boolean isExternalSDSRequested() {
    }

    default public void switchEntertainment(boolean bl) {
    }

    default public boolean isPTTDisabled() {
    }

    default public int resetSelectedRow() {
    }

    default public int getSelectedRow() {
    }

    default public void setSelectedRow(int n) {
    }

    default public int getSelectedModel() {
    }

    default public void setSelectedModel(int n) {
    }

    default public boolean getDDSFlag() {
    }

    default public void setDDSFlag(boolean bl) {
    }

    default public void setSDSNumberDialingActive(boolean bl) {
    }

    default public void triggerPauseStateAbortTimer(boolean bl) {
    }

    default public void triggerWaitStateAbortTimer(boolean bl) {
    }

    default public boolean isSDSVolumeSettingActive() {
    }

    default public void setSDSVolumeSettingActive(boolean bl) {
    }

    default public void cancelTimers() {
    }

    default public void turnDDSWheel() {
    }

    default public void movedDDSJoystick(JoystickEvent joystickEvent) {
    }

    default public boolean isBeepOn() {
    }

    default public boolean isExpertMode() {
    }

    default public boolean isQuickMode() {
    }

    default public boolean isCommandScreen() {
    }

    default public boolean isVoiceBargeIn() {
    }

    default public void setAbortWaitingStateOnCorrection(boolean bl) {
    }

    default public boolean isAbortWaitingStateOnCorrection() {
    }

    default public void handleLeavingWaitingState() {
    }

    default public void handleLeavingPauseState() {
    }

    default public void resetEventID() {
    }

    default public IFrameworkAccess getFramework() {
    }

    default public boolean isOnlineRecogResultsInvalid() {
    }

    default public void setOnlineRecogResultsInvalid(boolean bl) {
    }
}

