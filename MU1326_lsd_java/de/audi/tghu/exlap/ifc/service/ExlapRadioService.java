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
    public void activateRadioBand(int var1, RadioBandContainer var2);

    public void tuneStation(int var1, RadioStationInfoContainer var2);

    public void tune(int var1, RadioFrequencyContainer var2);

    public void nextRadioStation(int var1);

    public void previousRadioStation(int var1);

    public void seekForward(int var1);

    public void seekBackward(int var1);

    public void increaseRadioFrequency(int var1);

    public void decreaseRadioFrequency(int var1);

    public void storePreset(int var1, RadioPresetIndexContainer var2);

    public void deletePreset(int var1, RadioPresetIndexContainer var2);
}

