/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.sdis;

import de.audi.atip.interapp.audio.ISoundHandlerListener;
import de.audi.atip.log.LogChannel;
import de.audi.tone.sdis.ASIHMISyncSoundImpl;
import de.esolutions.fw.comm.asi.hmisync.sound.SoundRange;
import de.esolutions.fw.comm.core.method.MethodException;

public class SdisAppSoundListener
implements ISoundHandlerListener {
    private LogChannel lc;
    private ASIHMISyncSoundImpl asiSound;

    public SdisAppSoundListener(ASIHMISyncSoundImpl aSIHMISyncSoundImpl, LogChannel logChannel) {
        this.lc = logChannel;
        this.asiSound = aSIHMISyncSoundImpl;
    }

    public void updateAmplifier(int n) {
        try {
            this.asiSound.updateAmplifier(n);
            this.lc.log(10000000, "[SdisAppSoundListener.updateAmplifier] amplifier:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateAmplifier] method exception");
        }
    }

    public void updatePresetPositionList(int n) {
        try {
            this.asiSound.updatePresetPositionList(n);
            this.lc.log(10000000, "[SdisAppSoundListener.updatePresetPositionList] presetPositionList:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updatePresetPositionList] method exception");
        }
    }

    public void updatePresetPosition(int n) {
        try {
            this.asiSound.updatePresetPosition(n);
            this.lc.log(10000000, "[SdisAppSoundListener.updatePresetPosition] presetPosition:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updatePresetPosition] method exception");
        }
    }

    public void updatePresetEqList(int n) {
        try {
            this.asiSound.updatePresetEQList(n);
            this.lc.log(10000000, "[SdisAppSoundListener.updatePresetEqList] presetEqList:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updatePresetEqList] method exception");
        }
    }

    public void updatePresetEq(int n) {
        try {
            this.asiSound.updatePresetEQ(n);
            this.lc.log(10000000, "[SdisAppSoundListener.updatePresetEq] presetEq:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(10000000, "[SdisAppSoundListener.updatePresetEq] method exception");
        }
    }

    public void updateThreeDMode(int n) {
        try {
            this.asiSound.updateThreeDModeValue(n);
            this.lc.log(10000000, "[SdisAppSoundListener.updateThreeDMode] threeDMode:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(10000000, "[SdisAppSoundListener.updateThreeDMode] method exception");
        }
    }

    public void updateThreeDModeRange(int n, int n2) {
        try {
            this.asiSound.updateThreeDModeRange(new SoundRange(n, n));
            this.lc.log(10000000, "[SdisAppSoundListener.updateThreeDModeRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000000, "[SdisAppSoundListener.updateThreeDModeRange] method exception");
        }
    }

    public void updateBalance(short s) {
        try {
            this.asiSound.updateBalanceValue(s);
            this.lc.log(10000000, "[SdisAppSoundListener.updateBalance] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateBalance] method exception");
        }
    }

    public void updateBalanceRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateBalanceRange(soundRange);
            this.lc.log(10000000, "[SdisAppSoundListener.updateBalanceRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateBalanceRange] method exception");
        }
    }

    public void updateFader(short s) {
        try {
            this.asiSound.updateFaderValue(s);
            this.lc.log(10000000, "[SdisAppSoundListener.updateFader] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateFader] method exception");
        }
    }

    public void updateFaderRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateFaderRange(soundRange);
            this.lc.log(10000000, "[SdisAppSoundListener.updateFaderRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateFaderRange] method exception");
        }
    }

    public void updateBass(short s) {
        try {
            this.asiSound.updateBassValue(s);
            this.lc.log(10000000, "[SdisAppSoundListener.updateBass] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateBass] method exception");
        }
    }

    public void updateBassRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateBassRange(soundRange);
            this.lc.log(10000000, "[SdisAppSoundListener.updateBassRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateBassRange] method exception");
        }
    }

    public void updateTreble(short s) {
        try {
            this.asiSound.updateTrebleValue(s);
            this.lc.log(10000000, "[SdisAppSoundListener.updateTreble] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateTreble] method exception");
        }
    }

    public void updateTrebleRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateTrebleRange(soundRange);
            this.lc.log(10000000, "[SdisAppSoundListener.updateTrebleRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateTrebleRange] method exception");
        }
    }

    public void updateSubwoofer(short s) {
        try {
            this.asiSound.updateSubwooferValue(s);
            this.lc.log(10000000, "[SdisAppSoundListener.updateSubwoofer] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateSubwoofer] method exception");
        }
    }

    public void updateSubwooferRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateSubwooferRange(soundRange);
            this.lc.log(10000000, "[SdisAppSoundListener.updateSubwooferRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateSubwooferRange] method exception");
        }
    }

    public void updateSurroundLevel(short s) {
        try {
            this.asiSound.updateSurroundValue(s);
            this.lc.log(10000000, "[SdisAppSoundListener.updateSurroundLevel] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateSurroundLevel] method exception");
        }
    }

    public void updateSurroundLevelRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateSurroundRange(soundRange);
            this.lc.log(10000000, "[SdisAppSoundListener.updateSurroundRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateSurroundRange] method exception");
        }
    }

    public void updateNoiseCompensation(short s) {
        try {
            this.asiSound.updateNoiseCompensationValue(s);
            this.lc.log(10000000, "[SdisAppSoundListener.updateNoiseCompensation] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateNoiseCompensation] method exception");
        }
    }

    public void updateNoiseCompensationRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateNoiseCompensationRange(soundRange);
            this.lc.log(10000000, "[SdisAppSoundListener.updateNoiseCompensationRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateNoiseCompensationRange] method exception");
        }
    }

    public void distributeValuesAndRanges(ISoundHandlerListener iSoundHandlerListener) {
    }
}

