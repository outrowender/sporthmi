/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio.cmd;

import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdListener;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import org.dsi.ifc.audio.AmplifierCapabilities;

abstract class AbstractEcallAudioCmd
extends Command
implements IEcallAudioCmdListener {
    protected final HMIAudioService audioService;

    public AbstractEcallAudioCmd(LogChannel logChannel, HMIAudioService hMIAudioService) {
        super(logChannel);
        this.audioService = hMIAudioService;
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.logger.log(-2137614336, "AbstractEcallAudioCmd#updateAMAvailable(): NOP");
    }

    @Override
    public void updateVolumeLock(int n, int n2, boolean bl) {
        this.logger.log(-2137614336, "AbstractEcallAudioCmd#updateVolumeLock(): NOP");
    }

    @Override
    public void stopConnection(int n, int n2) {
        this.logger.log(-2137614336, "AbstractEcallAudioCmd#stopConnection(): NOP");
    }

    @Override
    public void pauseConnection(int n, int n2) {
        this.logger.log(-2137614336, "AbstractEcallAudioCmd#pauseConnection(): NOP");
    }

    @Override
    public void startConnection(int n, int n2) {
        this.logger.log(-2137614336, "AbstractEcallAudioCmd#startConnection(): NOP");
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        this.logger.log(-2137614336, "AbstractEcallAudioCmd#errorConnection(): NOP");
    }

    @Override
    public void fadedIn(int n, int n2) {
        this.logger.log(-2137614336, "AbstractEcallAudioCmd#fadedIn(): NOP");
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

