/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.audio;

public interface ISoundHandlerListener {
    default public void updateBalance(short s) {
    }

    default public void updateBalanceRange(int n, int n2) {
    }

    default public void updateFader(short s) {
    }

    default public void updateFaderRange(int n, int n2) {
    }

    default public void updateBass(short s) {
    }

    default public void updateBassRange(int n, int n2) {
    }

    default public void updateTreble(short s) {
    }

    default public void updateTrebleRange(int n, int n2) {
    }

    default public void updateSubwoofer(short s) {
    }

    default public void updateSubwooferRange(int n, int n2) {
    }

    default public void updateSurroundLevel(short s) {
    }

    default public void updateSurroundLevelRange(int n, int n2) {
    }

    default public void updateNoiseCompensation(short s) {
    }

    default public void updateNoiseCompensationRange(int n, int n2) {
    }

    default public void updateThreeDMode(int n) {
    }

    default public void updateThreeDModeRange(int n, int n2) {
    }

    default public void updateAmplifier(int n) {
    }

    default public void updatePresetPositionList(int n) {
    }

    default public void updatePresetPosition(int n) {
    }

    default public void updatePresetEqList(int n) {
    }

    default public void updatePresetEq(int n) {
    }

    default public void distributeValuesAndRanges(ISoundHandlerListener iSoundHandlerListener) {
    }
}

