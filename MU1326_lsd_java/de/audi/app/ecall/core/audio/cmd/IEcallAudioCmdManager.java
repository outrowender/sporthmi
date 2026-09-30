/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

public interface IEcallAudioCmdManager {
    public void schedulePhoneEcallAudioScenario(int var1, boolean var2);

    public void schedulePhoneEcallHighAudioScenario(int var1);

    public void schedulePhoneVoiceHighAudioScenario(int var1);

    public void schedulePhoneVoiceLowAudioScenario(int var1);

    public void scheduleEcallMuteAudioScenario(int var1);

    public void scheduleMutePinAudioScenarioRequest();

    public void scheduleReleaseAllConnections(boolean var1);

    public void scheduleMutePinMuteRequest();

    public void scheduleMutePinMuteRelease();
}

