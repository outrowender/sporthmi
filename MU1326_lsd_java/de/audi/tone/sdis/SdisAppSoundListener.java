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

    @Override
    public void updateAmplifier(int n) {
        try {
            this.asiSound.updateAmplifier(n);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateAmplifier] amplifier:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateAmplifier] method exception");
        }
    }

    @Override
    public void updatePresetPositionList(int n) {
        try {
            this.asiSound.updatePresetPositionList(n);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updatePresetPositionList] presetPositionList:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updatePresetPositionList] method exception");
        }
    }

    @Override
    public void updatePresetPosition(int n) {
        try {
            this.asiSound.updatePresetPosition(n);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updatePresetPosition] presetPosition:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updatePresetPosition] method exception");
        }
    }

    @Override
    public void updatePresetEqList(int n) {
        try {
            this.asiSound.updatePresetEQList(n);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updatePresetEqList] presetEqList:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updatePresetEqList] method exception");
        }
    }

    @Override
    public void updatePresetEq(int n) {
        try {
            this.asiSound.updatePresetEQ(n);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updatePresetEq] presetEq:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(-2137614336, "[SdisAppSoundListener.updatePresetEq] method exception");
        }
    }

    @Override
    public void updateThreeDMode(int n) {
        try {
            this.asiSound.updateThreeDModeValue(n);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateThreeDMode] threeDMode:%1", (long)n);
        }
        catch (MethodException methodException) {
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateThreeDMode] method exception");
        }
    }

    @Override
    public void updateThreeDModeRange(int n, int n2) {
        try {
            this.asiSound.updateThreeDModeRange(new SoundRange(n, n));
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateThreeDModeRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateThreeDModeRange] method exception");
        }
    }

    @Override
    public void updateBalance(short s) {
        try {
            this.asiSound.updateBalanceValue(s);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateBalance] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateBalance] method exception");
        }
    }

    @Override
    public void updateBalanceRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateBalanceRange(soundRange);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateBalanceRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateBalanceRange] method exception");
        }
    }

    @Override
    public void updateFader(short s) {
        try {
            this.asiSound.updateFaderValue(s);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateFader] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateFader] method exception");
        }
    }

    @Override
    public void updateFaderRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateFaderRange(soundRange);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateFaderRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateFaderRange] method exception");
        }
    }

    @Override
    public void updateBass(short s) {
        try {
            this.asiSound.updateBassValue(s);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateBass] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateBass] method exception");
        }
    }

    @Override
    public void updateBassRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateBassRange(soundRange);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateBassRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateBassRange] method exception");
        }
    }

    @Override
    public void updateTreble(short s) {
        try {
            this.asiSound.updateTrebleValue(s);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateTreble] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateTreble] method exception");
        }
    }

    @Override
    public void updateTrebleRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateTrebleRange(soundRange);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateTrebleRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateTrebleRange] method exception");
        }
    }

    @Override
    public void updateSubwoofer(short s) {
        try {
            this.asiSound.updateSubwooferValue(s);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateSubwoofer] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateSubwoofer] method exception");
        }
    }

    @Override
    public void updateSubwooferRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateSubwooferRange(soundRange);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateSubwooferRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateSubwooferRange] method exception");
        }
    }

    @Override
    public void updateSurroundLevel(short s) {
        try {
            this.asiSound.updateSurroundValue(s);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateSurroundLevel] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateSurroundLevel] method exception");
        }
    }

    @Override
    public void updateSurroundLevelRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateSurroundRange(soundRange);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateSurroundRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateSurroundRange] method exception");
        }
    }

    @Override
    public void updateNoiseCompensation(short s) {
        try {
            this.asiSound.updateNoiseCompensationValue(s);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateNoiseCompensation] value:%1", (long)s);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateNoiseCompensation] method exception");
        }
    }

    @Override
    public void updateNoiseCompensationRange(int n, int n2) {
        try {
            SoundRange soundRange = new SoundRange(n, n2);
            this.asiSound.updateNoiseCompensationRange(soundRange);
            this.lc.log(-2137614336, "[SdisAppSoundListener.updateNoiseCompensationRange] min:%1 max:%2", (long)n, (long)n2);
        }
        catch (MethodException methodException) {
            this.lc.log(10000, "[SdisAppSoundListener.updateNoiseCompensationRange] method exception");
        }
    }

    @Override
    public void distributeValuesAndRanges(ISoundHandlerListener iSoundHandlerListener) {
    }
}

