/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;
import org.dsi.ifc.audio.AmplifierCapabilities;

abstract class AbstractTelAudioCmd
extends Command
implements ITelAudioCmdListener {
    private static final long TIMEOUT = 10000L;
    protected final HMIAudioService audioService;

    protected String getConnectionStatusName(int n) {
        switch (n) {
            case 3: {
                return "START_REQUESTED";
            }
            case 2: {
                return "STARTED";
            }
            case 4: {
                return "PAUSED";
            }
            case 1: {
                return "FADEIN_REQUESTED";
            }
            case 0: {
                return "FADEDIN";
            }
            case 6: {
                return "STOP_REQUESTED";
            }
            case 5: {
                return "STOPPED";
            }
        }
        return "CONN_UNKNOWN";
    }

    AbstractTelAudioCmd(LogChannel logChannel, String string, HMIAudioService hMIAudioService) {
        super(logChannel, string);
        this.audioService = hMIAudioService;
    }

    public long getTimeout() {
        return 10000L;
    }

    public void inputGainOffsetRange(int n, int n2, int n3, int n4) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#inputGainOffsetRange] NOP!");
    }

    public void menuVolEntRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#menuVolEntRange] NOP!");
    }

    public void menuVolumeRange(int n, int n2, int n3, int n4) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#menuVolumeRange] NOP!");
    }

    public void updateSurroundOnOff(int n, int n2, boolean bl, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSurroundOnOff] NOP!");
    }

    public void updateBalance(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateBalance] NOP!");
    }

    public void updateBalanceRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateBalanceRange] NOP!");
    }

    public void updateBass(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateBass] NOP!");
    }

    public void updateBassRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateBassRange] NOP!");
    }

    public void createExportFileResult(int n, boolean bl) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#createExportFileResult] NOP!");
    }

    public void updateDynSoundControl(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateDynSoundControl] NOP!");
    }

    public void updateFader(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateFader] NOP!");
    }

    public void updateFaderRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateFaderRange] NOP!");
    }

    public void importFileResponse(int n, boolean bl) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#importFileResponse] NOP!");
    }

    public void updateInputGainOffset(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateInputGainOffset] NOP!");
    }

    public void updateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateLoweringEntertainment] NOP!");
    }

    public void updateMutePinState(boolean bl, int n) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateMutePinState] NOP!");
    }

    public void updateSoundSet(int n, int n2, long l, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSoundSet] NOP!");
    }

    public void updateSoundSetList(long l, int n) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSoundSetList] NOP!");
    }

    public void updateSoundShapeActive(boolean bl, int n) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSoundShapeActive] NOP!");
    }

    public void updateSubwoofer(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSubwoofer] NOP!");
    }

    public void updateSubwooferRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSubwooferRange] NOP!");
    }

    public void updateSurrLevelRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSurrLevelRange] NOP!");
    }

    public void updateSurroundLevel(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSurroundLevel] NOP!");
    }

    public void updateTreble(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateTreble] NOP!");
    }

    public void updateTrebleRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateTrebleRange] NOP!");
    }

    public void updateVolLevelRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateVolLevelRange] NOP!");
    }

    public void updateVolume(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateVolume] NOP!");
    }

    public void updateVolumeLeveling(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateVolumeLeveling] NOP!");
    }

    public void updateVolumeRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateVolumeRange] NOP!");
    }

    public void updateMiddle(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateMiddle] NOP!");
    }

    public void updateMiddleRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateMiddleRange] NOP!");
    }

    public void updateEqualizerRange(int n, int n2, int[] nArray, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateEqualizerRange] NOP!");
    }

    public void updateEqualizer(int[] nArray, int[] nArray2, int n) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateEqualizer] NOP!");
    }

    public void updateOnVolumeLimit(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateOnVolumeLimit] NOP!");
    }

    public void updateOnVolumeLimitRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateOnVolumeLimitRange] NOP!");
    }

    public void updateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateActiveAmplifierCapabilities] NOP!");
    }

    public void updateMuteTheftProtection(boolean bl, int n) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateMuteTheftProtection] NOP!");
    }

    public void updateMicGainLevel(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateMicGainLevel] NOP!");
    }

    public void updateVolumeFocus(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateVolumeFocus] NOP!");
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateVolumeLock] NOP!");
    }

    public void updateNoiseCompensation(int n, int n2, short s, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateNoiseCompensation] NOP!");
    }

    public void updateNoiseCompensationRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateNoiseCompensationRange] NOP!");
    }

    public void updateThreeDMode(int n, int n2, int n3, int n4) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateThreeDMode] NOP!");
    }

    public void updateThreeDModeRange(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateThreeDModeRange] NOP!");
    }

    public void updatePresetPosition(int n, int n2, int n3, int n4) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updatePresetPosition] NOP!");
    }

    public void updatePresetPositionList(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updatePresetPositionList] NOP!");
    }

    public void updatePresetEQList(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updatePresetEQList] NOP!");
    }

    public void updatePresetEQ(int n, int n2, int n3, int n4) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updatePresetEQ] NOP!");
    }

    public void updateSubwooferActivity(int n, int n2, boolean bl, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSubwooferActivity] NOP!");
    }

    public void responseWidebandSpeech(int n, boolean bl) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#responseWidebandSpeech] NOP!");
    }

    public void state(int n) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#state] NOP!");
    }

    public void playToneInfo(int n) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#playToneInfo] NOP!");
    }

    public void updateAMAvailable(boolean bl) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateAMAvailable] NOP!");
    }

    public void stopConnection(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#stopConnection] NOP!");
    }

    public void pauseConnection(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#pauseConnection] NOP!");
    }

    public void startConnection(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#startConnection] NOP!");
    }

    public void errorConnection(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#errorConnection] NOP!");
    }

    public void fadedIn(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#fadedIn] NOP!");
    }

    public void volumeRange(int n, int n2, int n3, int n4, int n5) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#volumeRange] NOP!");
    }

    public void updateSoundShape(short s, short s2, short s3, int n) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSoundShape] NOP!");
    }

    public void updateSoundShapeRange(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateSoundShapeRange] NOP!");
    }

    public void updateICCAvailable(boolean bl, int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateICCAvailable] NOP!");
    }

    public void updateProfileState(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#updateProfileState] NOP!");
    }

    public void profileChanged(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#profileChanged] NOP!");
    }

    public void profileCopied(int n, int n2, int n3) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#profileCopied] NOP!");
    }

    public void profileReset(int n, int n2) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#profileReset] NOP!");
    }

    public void profileResetAll(int n) {
        this.logger.log(10000000, "[AbstractTelAudioCmd#profileResetAll] NOP!");
    }
}

