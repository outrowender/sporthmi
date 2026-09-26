/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.intra;

import de.audi.tone.app.ToneDefaultListener;
import de.audi.tone.app.intra.IAppAudioListener;
import de.audi.tone.app.intra.IAppSoundListener;

public class AbstractAppListener
extends ToneDefaultListener
implements IAppAudioListener,
IAppSoundListener {
    @Override
    public void updateConnectionStatus(int n, int n2, int n3) {
    }

    @Override
    public void updateAMAvailable(boolean bl) {
    }

    @Override
    public void updateMuteTheftProtection(boolean bl) {
    }

    @Override
    public void menuVolumeRange(int n, int n2, int n3) {
    }

    @Override
    public void menuVolEntRange(int n, int n2, int n3) {
    }

    @Override
    public void updateLoweringEntertainment(int n, int n2) {
    }

    @Override
    public void updateVolume(int n, int n2, int n3) {
    }

    @Override
    public void updateVolumeRange(int n, int n2) {
    }

    @Override
    public void updateAmplifier(int n) {
    }

    @Override
    public void inputGainOffsetRange(int n, int n2) {
    }

    @Override
    public void updateInputGainOffset(int n, int n2) {
    }

    @Override
    public void updateThreeDMode(int n) {
    }

    @Override
    public void updateThreeDModeRange(int n, int n2) {
    }

    @Override
    public void updatePresetPositionList(int n) {
    }

    @Override
    public void updatePresetPosition(int n) {
    }

    @Override
    public void updatePresetEQList(int n) {
    }

    @Override
    public void updatePresetEQ(int n) {
    }

    @Override
    public void updateFader(int n, int n2, int n3) {
    }

    @Override
    public void updateFaderRanges(int n, int n2) {
    }

    @Override
    public void updateBalance(int n, int n2, int n3) {
    }

    @Override
    public void updateBalanceRange(int n, int n2) {
    }
}

