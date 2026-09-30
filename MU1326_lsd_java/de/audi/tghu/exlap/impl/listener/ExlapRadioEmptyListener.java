/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.listener;

import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.RadioBandsContainer;
import de.audi.tghu.exlap.impl.container.RadioFrequencyRangesContainer;
import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;
import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.container.RadioTextContainer;
import de.audi.tghu.exlap.impl.container.TrafficAnnouncementContainer;

public class ExlapRadioEmptyListener
implements ExlapRadioListener {
    public void updateAvailableRadioBands(RadioBandsContainer radioBandsContainer) {
    }

    public void updateAvailableAMStations(RadioStationsContainer radioStationsContainer) {
    }

    public void updateAvailableFMStations(RadioStationsContainer radioStationsContainer) {
    }

    public void updateAvailableDABEnsembles(RadioStationsContainer radioStationsContainer) {
    }

    public void updateAvailableDABServices(RadioStationsContainer radioStationsContainer) {
    }

    public void updateAvailableDABServiceComponents(RadioStationsContainer radioStationsContainer) {
    }

    public void updateRadioAMPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    public void updateRadioFMPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    public void updateRadioDABPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    public void updateRadioTuner(RadioStationInfoContainer radioStationInfoContainer) {
    }

    public void updateRadioFrequencyRanges(RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
    }

    public void updateTrafficAnnouncement(TrafficAnnouncementContainer trafficAnnouncementContainer) {
    }

    public void updateRadioText(RadioTextContainer radioTextContainer) {
    }
}

