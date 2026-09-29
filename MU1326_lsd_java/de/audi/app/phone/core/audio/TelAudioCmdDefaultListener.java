/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.audio.ITelAudioCmdListener;
import de.audi.app.phone.core.audio.TelAudioCmdManager;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.audio.AmplifierCapabilities;
import org.dsi.ifc.base.DSIListener;

class TelAudioCmdDefaultListener
implements DSIListener,
ITelAudioCmdListener {
    private final LogChannel log;
    private volatile int currentAudioScenario;
    private final TelAudioCmdManager cmdListManager;

    public TelAudioCmdDefaultListener(TelAudioCmdManager telAudioCmdManager, LogChannel logChannel) {
        this.log = logChannel;
        this.cmdListManager = telAudioCmdManager;
    }

    void setCurrentAudioScenario(int n) {
        this.currentAudioScenario = n;
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

    public void updateDynSoundControl(int n, int n2, short s, int n3) {
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

    public void updateSoundSet(int n, int n2, long l, int n3) {
    }

    public void updateSoundSetList(long l, int n) {
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

    public void updateVolLevelRange(int n, int n2, int n3) {
    }

    @Override
    public void updateVolume(int n, int n2, short s, int n3) {
    }

    public void updateVolumeLeveling(int n, int n2, short s, int n3) {
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
    public void updateVolumeLock(int n, int n2, boolean bl) {
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
    public void state(int n) {
    }

    @Override
    public void playToneInfo(int n) {
    }

    @Override
    public void updateAMAvailable(boolean bl) {
    }

    @Override
    public void stopConnection(int n, int n2) {
    }

    @Override
    public void pauseConnection(int n, int n2) {
    }

    @Override
    public void startConnection(int n, int n2) {
        int n3 = this.currentAudioScenario;
        boolean bl = n == 104 || n == 99 || n == 103 || n == 98 || n == 87;
        boolean bl2 = false;
        if (bl) {
            this.log.log(-1601830656, "[TelAudioCmdDefaultListener#startConnection] connection=%1, currentAudioScenario=%2", (long)n, (long)n3);
            switch (n) {
                case 104: {
                    bl2 = n3 == 12 || n3 == 13;
                    break;
                }
                case 99: {
                    bl2 = n3 == 6 || n3 == 7;
                    break;
                }
                case 103: {
                    bl2 = n3 == 1;
                    break;
                }
                case 98: {
                    bl2 = n3 == 3;
                    break;
                }
                case 87: {
                    boolean bl3 = bl2 = n3 == 17;
                }
            }
            if (bl2) {
                this.log.log(-1601830656, "[TelAudioCmdDefaultListener#startConnection] requesting fade in for %1", (long)n);
                this.cmdListManager.scheduleRequestConnection(n, 2);
            }
        }
    }

    @Override
    public void errorConnection(int n, int n2, int n3) {
    }

    @Override
    public void fadedIn(int n, int n2) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void volumeRange(int n, int n2, int n3, int n4, int n5) {
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

