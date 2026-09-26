/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.listener;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.impl.container.RadioBandsContainer;
import de.audi.tghu.exlap.impl.container.RadioFrequencyRangesContainer;
import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;
import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.container.RadioTextContainer;
import de.audi.tghu.exlap.impl.container.TrafficAnnouncementContainer;

public interface ExlapRadioListener
extends ExlapListener {
    default public void updateAvailableRadioBands(RadioBandsContainer radioBandsContainer) {
    }

    default public void updateAvailableAMStations(RadioStationsContainer radioStationsContainer) {
    }

    default public void updateAvailableFMStations(RadioStationsContainer radioStationsContainer) {
    }

    default public void updateAvailableDABEnsembles(RadioStationsContainer radioStationsContainer) {
    }

    default public void updateAvailableDABServices(RadioStationsContainer radioStationsContainer) {
    }

    default public void updateAvailableDABServiceComponents(RadioStationsContainer radioStationsContainer) {
    }

    default public void updateRadioAMPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    default public void updateRadioFMPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    default public void updateRadioDABPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    default public void updateRadioTuner(RadioStationInfoContainer radioStationInfoContainer) {
    }

    default public void updateRadioFrequencyRanges(RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
    }

    default public void updateTrafficAnnouncement(TrafficAnnouncementContainer trafficAnnouncementContainer) {
    }

    default public void updateRadioText(RadioTextContainer radioTextContainer) {
    }
}

