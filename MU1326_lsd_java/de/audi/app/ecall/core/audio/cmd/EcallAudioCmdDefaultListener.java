/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdListener;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.audio.AmplifierCapabilities;

public class EcallAudioCmdDefaultListener
extends AbstractEcallComponent
implements IEcallAudioCmdListener {
    public EcallAudioCmdDefaultListener(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.Audio");
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.log.log(1078071040, "EcallAudioCmdDefaultListener#updateAMAvailable(): available %1", bl);
    }

    @Override
    public void updateVolumeLock(int n, int n2, boolean bl) {
        this.log.log(1078071040, "EcallAudioCmdDefaultListener#updateVolumeLock(): volumeLockActive %1", bl);
    }

    @Override
    public void stopConnection(int n, int n2) {
        this.log.log(1078071040, "EcallAudioCmdDefaultListener#stopConnection(): connection: %1, hmiTerminal:%2", (long)n, (long)n2);
    }

    @Override
    public void pauseConnection(int n, int n2) {
        this.log.log(1078071040, "EcallAudioCmdDefaultListener#pauseConnection(): connection: %1, hmiTerminal:%2", (long)n, (long)n2);
    }

    @Override
    public void startConnection(int n, int n2) {
        this.log.log(1078071040, "EcallAudioCmdDefaultListener#startConnection(): connection: %1, hmiTerminal:%2", (long)n, (long)n2);
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        this.log.log(1078071040, "EcallAudioCmdDefaultListener#errorConnection(): connection: %1, hmiTerminal:%2, errorCode: %3", (long)n, (long)n2, (long)n3);
    }

    @Override
    public void fadedIn(int n, int n2) {
        this.log.log(1078071040, "EcallAudioCmdDefaultListener#fadedIn(): connection: %1, hmiTerminal:%2", (long)n, (long)n2);
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (this.log.isInfo()) {
            Buffer buffer = new Buffer("EcallAudioCmdDefaultListener#asyncException():");
            buffer.append(" errorCode: ").append(n).append(" errorMsg: ").append(string).append(" requestType: ").append(n2);
            this.log.log(1078071040, buffer.toString());
        }
    }

    @Override
    public void inputGainOffsetRange(int n, int n2, int n3, int n4) {
    }

    @Override
    public void menuVolEntRange(int n, int n2, int n3) {
    }

    @Override
    public void menuVolumeRange(int n, int n2, int n3, int n4) {
    }

    @Override
    public void volumeRange(int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void updateSurroundOnOff(int n, int n2, boolean bl, int n3) {
    }

    @Override
    public void updateBalance(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateBalanceRange(int n, int n2, int n3) {
    }

    @Override
    public void updateBass(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateBassRange(int n, int n2, int n3) {
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
    }

    @Override
    public void updateFader(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateFaderRange(int n, int n2, int n3) {
    }

    @Override
    public void importFileResponse(int n, boolean bl) {
    }

    @Override
    public void updateInputGainOffset(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
    }

    @Override
    public void updateMutePinState(boolean bl, int n) {
        this.log.log(1078071040, "EcallAudioCmdDefaultListener#updateMutePinState(): mutePinState: %1", bl);
    }

    @Override
    public void updateSubwoofer(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateSubwooferRange(int n, int n2, int n3) {
    }

    @Override
    public void updateSurrLevelRange(int n, int n2, int n3) {
    }

    @Override
    public void updateSurroundLevel(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateTreble(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateTrebleRange(int n, int n2, int n3) {
    }

    @Override
    public void updateVolume(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateVolumeRange(int n, int n2, int n3) {
    }

    @Override
    public void updateMiddle(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateMiddleRange(int n, int n2, int n3) {
    }

    @Override
    public void updateEqualizerRange(int n, int n2, int[] nArray, int n3) {
    }

    @Override
    public void updateEqualizer(int[] nArray, int[] nArray2, int n) {
    }

    @Override
    public void updateOnVolumeLimit(int n, int n2) {
    }

    @Override
    public void updateOnVolumeLimitRange(int n, int n2, int n3) {
    }

    @Override
    public void updateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
    }

    @Override
    public void updateMuteTheftProtection(boolean bl, int n) {
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
    }

    @Override
    public void updateVolumeFocus(int n, int n2, int n3) {
    }

    @Override
    public void updateNoiseCompensation(int n, int n2, short s, int n3) {
    }

    @Override
    public void updateNoiseCompensationRange(int n, int n2, int n3) {
    }

    @Override
    public void updateThreeDMode(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateThreeDModeRange(int n, int n2, int n3) {
    }

    @Override
    public void updatePresetPosition(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updatePresetPositionList(int n, int n2) {
    }

    @Override
    public void updatePresetEQList(int n, int n2) {
    }

    @Override
    public void updatePresetEQ(int n, int n2, int n3, int n4) {
    }

    @Override
    public void updateSubwooferActivity(int n, int n2, boolean bl, int n3) {
    }

    @Override
    public void responseWidebandSpeech(int n, boolean bl) {
    }

    @Override
    public void updateSoundShapeActive(boolean bl, int n) {
    }

    @Override
    public void updateSoundShape(short s, short s2, short s3, int n) {
    }

    @Override
    public void updateSoundShapeRange(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
    }

    @Override
    public void updateICCAvailable(boolean bl, int n, int n2) {
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
    }

    @Override
    public void profileChanged(int n, int n2) {
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
    }

    @Override
    public void profileReset(int n, int n2) {
    }

    @Override
    public void profileResetAll(int n) {
    }
}

