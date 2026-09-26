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
    private static final long TIMEOUT;
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

    @Override
    public long getTimeout() {
        return 0;
    }

    @Override
    public void inputGainOffsetRange(int n, int n2, int n3, int n4) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#inputGainOffsetRange] NOP!");
    }

    @Override
    public void menuVolEntRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#menuVolEntRange] NOP!");
    }

    @Override
    public void menuVolumeRange(int n, int n2, int n3, int n4) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#menuVolumeRange] NOP!");
    }

    @Override
    public void updateSurroundOnOff(int n, int n2, boolean bl, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSurroundOnOff] NOP!");
    }

    @Override
    public void updateBalance(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateBalance] NOP!");
    }

    @Override
    public void updateBalanceRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateBalanceRange] NOP!");
    }

    @Override
    public void updateBass(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateBass] NOP!");
    }

    @Override
    public void updateBassRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateBassRange] NOP!");
    }

    @Override
    public void createExportFileResult(int n, boolean bl) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#createExportFileResult] NOP!");
    }

    public void updateDynSoundControl(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateDynSoundControl] NOP!");
    }

    @Override
    public void updateFader(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateFader] NOP!");
    }

    @Override
    public void updateFaderRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateFaderRange] NOP!");
    }

    @Override
    public void importFileResponse(int n, boolean bl) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#importFileResponse] NOP!");
    }

    @Override
    public void updateInputGainOffset(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateInputGainOffset] NOP!");
    }

    @Override
    public void updateLoweringEntertainment(int n, int n2, int n3, short s, int n4) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateLoweringEntertainment] NOP!");
    }

    @Override
    public void updateMutePinState(boolean bl, int n) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateMutePinState] NOP!");
    }

    public void updateSoundSet(int n, int n2, long l, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSoundSet] NOP!");
    }

    public void updateSoundSetList(long l, int n) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSoundSetList] NOP!");
    }

    @Override
    public void updateSoundShapeActive(boolean bl, int n) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSoundShapeActive] NOP!");
    }

    @Override
    public void updateSubwoofer(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSubwoofer] NOP!");
    }

    @Override
    public void updateSubwooferRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSubwooferRange] NOP!");
    }

    @Override
    public void updateSurrLevelRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSurrLevelRange] NOP!");
    }

    @Override
    public void updateSurroundLevel(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSurroundLevel] NOP!");
    }

    @Override
    public void updateTreble(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateTreble] NOP!");
    }

    @Override
    public void updateTrebleRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateTrebleRange] NOP!");
    }

    public void updateVolLevelRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateVolLevelRange] NOP!");
    }

    @Override
    public void updateVolume(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateVolume] NOP!");
    }

    public void updateVolumeLeveling(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateVolumeLeveling] NOP!");
    }

    @Override
    public void updateVolumeRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateVolumeRange] NOP!");
    }

    @Override
    public void updateMiddle(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateMiddle] NOP!");
    }

    @Override
    public void updateMiddleRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateMiddleRange] NOP!");
    }

    @Override
    public void updateEqualizerRange(int n, int n2, int[] nArray, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateEqualizerRange] NOP!");
    }

    @Override
    public void updateEqualizer(int[] nArray, int[] nArray2, int n) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateEqualizer] NOP!");
    }

    @Override
    public void updateOnVolumeLimit(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateOnVolumeLimit] NOP!");
    }

    @Override
    public void updateOnVolumeLimitRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateOnVolumeLimitRange] NOP!");
    }

    @Override
    public void updateActiveAmplifierCapabilities(AmplifierCapabilities amplifierCapabilities, int n) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateActiveAmplifierCapabilities] NOP!");
    }

    @Override
    public void updateMuteTheftProtection(boolean bl, int n) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateMuteTheftProtection] NOP!");
    }

    @Override
    public void updateMicGainLevel(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateMicGainLevel] NOP!");
    }

    @Override
    public void updateVolumeFocus(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateVolumeFocus] NOP!");
    }

    @Override
    public void updateVolumeLock(int n, int n2, boolean bl) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateVolumeLock] NOP!");
    }

    @Override
    public void updateNoiseCompensation(int n, int n2, short s, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateNoiseCompensation] NOP!");
    }

    @Override
    public void updateNoiseCompensationRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateNoiseCompensationRange] NOP!");
    }

    @Override
    public void updateThreeDMode(int n, int n2, int n3, int n4) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateThreeDMode] NOP!");
    }

    @Override
    public void updateThreeDModeRange(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateThreeDModeRange] NOP!");
    }

    @Override
    public void updatePresetPosition(int n, int n2, int n3, int n4) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updatePresetPosition] NOP!");
    }

    @Override
    public void updatePresetPositionList(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updatePresetPositionList] NOP!");
    }

    @Override
    public void updatePresetEQList(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updatePresetEQList] NOP!");
    }

    @Override
    public void updatePresetEQ(int n, int n2, int n3, int n4) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updatePresetEQ] NOP!");
    }

    @Override
    public void updateSubwooferActivity(int n, int n2, boolean bl, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSubwooferActivity] NOP!");
    }

    @Override
    public void responseWidebandSpeech(int n, boolean bl) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#responseWidebandSpeech] NOP!");
    }

    @Override
    public void state(int n) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#state] NOP!");
    }

    @Override
    public void playToneInfo(int n) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#playToneInfo] NOP!");
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateAMAvailable] NOP!");
    }

    @Override
    public void stopConnection(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#stopConnection] NOP!");
    }

    @Override
    public void pauseConnection(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#pauseConnection] NOP!");
    }

    @Override
    public void startConnection(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#startConnection] NOP!");
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#errorConnection] NOP!");
    }

    @Override
    public void fadedIn(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#fadedIn] NOP!");
    }

    @Override
    public void volumeRange(int n, int n2, int n3, int n4, int n5) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#volumeRange] NOP!");
    }

    @Override
    public void updateSoundShape(short s, short s2, short s3, int n) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSoundShape] NOP!");
    }

    @Override
    public void updateSoundShapeRange(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateSoundShapeRange] NOP!");
    }

    @Override
    public void updateICCAvailable(boolean bl, int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateICCAvailable] NOP!");
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#updateProfileState] NOP!");
    }

    @Override
    public void profileChanged(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#profileChanged] NOP!");
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#profileCopied] NOP!");
    }

    @Override
    public void profileReset(int n, int n2) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#profileReset] NOP!");
    }

    @Override
    public void profileResetAll(int n) {
        this.logger.log(-2137614336, "[AbstractTelAudioCmd#profileResetAll] NOP!");
    }
}

