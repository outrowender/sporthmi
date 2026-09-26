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
    @Override
    public void updateAvailableRadioBands(RadioBandsContainer radioBandsContainer) {
    }

    @Override
    public void updateAvailableAMStations(RadioStationsContainer radioStationsContainer) {
    }

    @Override
    public void updateAvailableFMStations(RadioStationsContainer radioStationsContainer) {
    }

    @Override
    public void updateAvailableDABEnsembles(RadioStationsContainer radioStationsContainer) {
    }

    @Override
    public void updateAvailableDABServices(RadioStationsContainer radioStationsContainer) {
    }

    @Override
    public void updateAvailableDABServiceComponents(RadioStationsContainer radioStationsContainer) {
    }

    @Override
    public void updateRadioAMPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    @Override
    public void updateRadioFMPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    @Override
    public void updateRadioDABPresets(RadioPresetsContainer radioPresetsContainer) {
    }

    @Override
    public void updateRadioTuner(RadioStationInfoContainer radioStationInfoContainer) {
    }

    @Override
    public void updateRadioFrequencyRanges(RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
    }

    @Override
    public void updateTrafficAnnouncement(TrafficAnnouncementContainer trafficAnnouncementContainer) {
    }

    @Override
    public void updateRadioText(RadioTextContainer radioTextContainer) {
    }
}

