/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.dsi;

import de.audi.tone.app.AmplifierVariant;
import org.dsi.ifc.audio.DSISound;

public interface IDSISoundHandler {
    default public void registerDSI(DSISound dSISound) {
    }

    default public void deregisterDSISound() {
    }

    default public void increaseVolume(int n, int n2, int n3) {
    }

    default public void decreaseVolume(int n, int n2, int n3) {
    }

    default public void changeBalance(int n, int n2) {
    }

    default public void setBalance(int n, int n2) {
    }

    default public void changeFader(int n, int n2) {
    }

    default public void setFader(int n, int n2) {
    }

    default public void changeBass(int n, int n2) {
    }

    default public void changeTreble(int n, int n2) {
    }

    default public void changeNoiseCompensation(int n) {
    }

    default public void setNoiseCompensation(int n) {
    }

    default public void changeSubwoofer(int n, int n2) {
    }

    default public void changeSurroundLevel(int n, int n2) {
    }

    default public void setVolume(int n, int n2, int n3) {
    }

    default public void getVolume(int n, int n2) {
    }

    default public void changeLoweringEntertainment(int n, int n2, int n3) {
    }

    default public void setLoweringEntertainment(int n, int n2) {
    }

    default public void revertToFactorySettings(int n, int[] nArray, String string) {
    }

    default public void revertToFactorySettings(int n, int n2) {
    }

    default public void setPresetPosition(int n, int n2) {
    }

    default public void setPresetEQ(int n, int n2) {
    }

    default public void getMenuVolumeRange(int n, int n2) {
    }

    default public void getMenuVolEntRange(int n) {
    }

    default public void getInputGainOffsetRange(int n, int n2) {
    }

    default public void getInputGainOffset(int n, int n2) {
    }

    default public void changeInputGainOffset(int n, int n2, int n3) {
    }

    default public void setMicGainLevel(int n) {
    }

    default public void setThreeDMode(int n) {
    }

    default public void setThreeDMode(int n, int n2, int n3) {
    }

    default public void setSurround(int n, int n2, boolean bl) {
    }

    default public void setSurround(int n, boolean bl) {
    }

    default public void setInputGainOffSet(int n, int n2, short s) {
    }

    default public void setDuration(int n, int n2) {
    }

    default public void getLoweringEntertainment(int n, int n2, int n3) {
    }

    default public AmplifierVariant getAmplifierVariant() {
    }
}

