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
    public void updateAvailableRadioBands(RadioBandsContainer var1);

    public void updateAvailableAMStations(RadioStationsContainer var1);

    public void updateAvailableFMStations(RadioStationsContainer var1);

    public void updateAvailableDABEnsembles(RadioStationsContainer var1);

    public void updateAvailableDABServices(RadioStationsContainer var1);

    public void updateAvailableDABServiceComponents(RadioStationsContainer var1);

    public void updateRadioAMPresets(RadioPresetsContainer var1);

    public void updateRadioFMPresets(RadioPresetsContainer var1);

    public void updateRadioDABPresets(RadioPresetsContainer var1);

    public void updateRadioTuner(RadioStationInfoContainer var1);

    public void updateRadioFrequencyRanges(RadioFrequencyRangesContainer var1);

    public void updateTrafficAnnouncement(TrafficAnnouncementContainer var1);

    public void updateRadioText(RadioTextContainer var1);
}

