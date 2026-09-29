/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

public interface IEcallAudioCmdManager {
    default public void schedulePhoneEcallAudioScenario(int n, boolean bl) {
    }

    default public void schedulePhoneEcallHighAudioScenario(int n) {
    }

    default public void schedulePhoneVoiceHighAudioScenario(int n) {
    }

    default public void schedulePhoneVoiceLowAudioScenario(int n) {
    }

    default public void scheduleEcallMuteAudioScenario(int n) {
    }

    default public void scheduleMutePinAudioScenarioRequest() {
    }

    default public void scheduleReleaseAllConnections(boolean bl) {
    }

    default public void scheduleMutePinMuteRequest() {
    }

    default public void scheduleMutePinMuteRelease() {
    }
}

