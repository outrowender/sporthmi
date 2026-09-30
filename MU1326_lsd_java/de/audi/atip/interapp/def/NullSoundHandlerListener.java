/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.audio.ISoundHandlerListener;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;

public class NullSoundHandlerListener
extends NullService
implements ISoundHandlerListener {
    private short balance;
    private short fader;
    private short bass;
    private short treble;
    private short subwoofer;
    private short surround;
    private short noiseCompensation;
    private int preset;
    private int presetList;
    private int balanceMin;
    private int balanceMax;
    private int faderMin;
    private int faderMax;
    private int bassMin;
    private int bassMax;
    private int trebleMin;
    private int trebleMax;
    private int subwooferMin;
    private int subwooferMax;
    private int surroundMin;
    private int surroundMax;
    private int noiseMin;
    private int noiseMax;
    private int amplifier;
    private int threeDMode;
    private int three3ModeMin;
    private int three3ModeMax;
    private int presetEq;
    private int presetEqList;

    public NullSoundHandlerListener(LogChannel logChannel) {
        super(logChannel, "SoundHandlerListener");
    }

    public void updateBalance(short s) {
        this.balance = s;
        this.log();
    }

    public void updateBalanceRange(int n, int n2) {
        this.balanceMin = n;
        this.balanceMax = n2;
        this.log();
    }

    public void updateFader(short s) {
        this.fader = s;
        this.log();
    }

    public void updateFaderRange(int n, int n2) {
        this.faderMin = n;
        this.faderMax = n2;
        this.log();
    }

    public void updateBass(short s) {
        this.bass = s;
        this.log();
    }

    public void updateBassRange(int n, int n2) {
        this.bassMin = n;
        this.bassMax = n2;
        this.log();
    }

    public void updateTreble(short s) {
        this.treble = s;
        this.log();
    }

    public void updateTrebleRange(int n, int n2) {
        this.trebleMin = n;
        this.trebleMax = n2;
        this.log();
    }

    public void updateSubwoofer(short s) {
        this.subwoofer = s;
        this.log();
    }

    public void updateSubwooferRange(int n, int n2) {
        this.subwooferMin = n;
        this.subwooferMax = n2;
        this.log();
    }

    public void updateSurroundLevel(short s) {
        this.surround = s;
        this.log();
    }

    public void updateSurroundLevelRange(int n, int n2) {
        this.surroundMin = n;
        this.surroundMax = n2;
        this.log();
    }

    public void updateNoiseCompensation(short s) {
        this.noiseCompensation = s;
        this.log();
    }

    public void updateNoiseCompensationRange(int n, int n2) {
        this.noiseMin = n;
        this.noiseMax = n2;
        this.log();
    }

    public void updateAmplifier(int n) {
        this.amplifier = n;
        this.log();
    }

    public void updateThreeDMode(int n) {
        this.threeDMode = n;
        this.log("updateThreeDMode");
    }

    public void updateThreeDModeRange(int n, int n2) {
        this.three3ModeMin = n;
        this.three3ModeMax = n2;
        this.log("updateThreeDModeRange");
    }

    public void updatePresetEqList(int n) {
        this.presetEqList = n;
        this.log("updatePresetEqList");
    }

    public void updatePresetEq(int n) {
        this.presetEq = n;
        this.log("updatePresetEq");
    }

    public void updatePresetPositionList(int n) {
        this.presetList = n;
        this.log();
    }

    public void updatePresetPosition(int n) {
        this.preset = n;
        this.log();
    }

    public void distributeValuesAndRanges(ISoundHandlerListener iSoundHandlerListener) {
        iSoundHandlerListener.updateAmplifier(this.amplifier);
        iSoundHandlerListener.updateBalance(this.balance);
        iSoundHandlerListener.updateBalanceRange(this.balanceMin, this.balanceMax);
        iSoundHandlerListener.updateBass(this.bass);
        iSoundHandlerListener.updateBassRange(this.bassMin, this.bassMax);
        iSoundHandlerListener.updateFader(this.fader);
        iSoundHandlerListener.updateFaderRange(this.faderMin, this.faderMax);
        iSoundHandlerListener.updateNoiseCompensation(this.noiseCompensation);
        iSoundHandlerListener.updateNoiseCompensationRange(this.noiseMin, this.noiseMax);
        iSoundHandlerListener.updatePresetPosition(this.preset);
        iSoundHandlerListener.updatePresetPositionList(this.presetList);
        iSoundHandlerListener.updateSubwoofer(this.subwoofer);
        iSoundHandlerListener.updateSubwooferRange(this.subwooferMin, this.subwooferMax);
        iSoundHandlerListener.updateSurroundLevel(this.surround);
        iSoundHandlerListener.updateSurroundLevelRange(this.surroundMin, this.surroundMax);
        iSoundHandlerListener.updateTreble(this.treble);
        iSoundHandlerListener.updateTrebleRange(this.trebleMin, this.trebleMax);
        iSoundHandlerListener.updateThreeDMode(this.threeDMode);
        iSoundHandlerListener.updateThreeDModeRange(this.three3ModeMin, this.three3ModeMax);
        iSoundHandlerListener.updatePresetEq(this.presetEq);
        iSoundHandlerListener.updatePresetEqList(this.presetEqList);
    }
}

