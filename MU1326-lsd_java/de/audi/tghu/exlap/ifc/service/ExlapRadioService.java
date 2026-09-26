/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.service;

import de.audi.tghu.exlap.ExlapService;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioBandContainer;
import de.audi.tghu.exlap.impl.container.RadioFrequencyContainer;
import de.audi.tghu.exlap.impl.container.RadioPresetIndexContainer;
import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;

public interface ExlapRadioService
extends ExlapService,
ExlapRadioListener {
    default public void activateRadioBand(int n, RadioBandContainer radioBandContainer) {
    }

    default public void tuneStation(int n, RadioStationInfoContainer radioStationInfoContainer) {
    }

    default public void tune(int n, RadioFrequencyContainer radioFrequencyContainer) {
    }

    default public void nextRadioStation(int n) {
    }

    default public void previousRadioStation(int n) {
    }

    default public void seekForward(int n) {
    }

    default public void seekBackward(int n) {
    }

    default public void increaseRadioFrequency(int n) {
    }

    default public void decreaseRadioFrequency(int n) {
    }

    default public void storePreset(int n, RadioPresetIndexContainer radioPresetIndexContainer) {
    }

    default public void deletePreset(int n, RadioPresetIndexContainer radioPresetIndexContainer) {
    }
}

