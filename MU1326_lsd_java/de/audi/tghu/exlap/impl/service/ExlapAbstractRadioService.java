/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.ifc.service.ExlapRadioService;
import de.audi.tghu.exlap.impl.container.RadioBandsContainer;
import de.audi.tghu.exlap.impl.container.RadioFrequencyRangesContainer;
import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;
import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.container.RadioTextContainer;
import de.audi.tghu.exlap.impl.container.TrafficAnnouncementContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$1;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$10;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$11;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$12;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$13;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$2;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$3;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$4;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$5;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$6;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$7;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$8;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService$9;

public abstract class ExlapAbstractRadioService
extends ExlapAbstractService
implements ExlapRadioService,
ExlapRadioListener {
    @Override
    public void updateAvailableRadioBands(RadioBandsContainer radioBandsContainer) {
        this.iterateListener(28, new ExlapAbstractRadioService$1(this, radioBandsContainer));
    }

    @Override
    public void updateAvailableAMStations(RadioStationsContainer radioStationsContainer) {
        this.iterateListener(31, new ExlapAbstractRadioService$2(this, radioStationsContainer));
    }

    @Override
    public void updateAvailableFMStations(RadioStationsContainer radioStationsContainer) {
        this.iterateListener(32, new ExlapAbstractRadioService$3(this, radioStationsContainer));
    }

    @Override
    public void updateAvailableDABEnsembles(RadioStationsContainer radioStationsContainer) {
        this.iterateListener(33, new ExlapAbstractRadioService$4(this, radioStationsContainer));
    }

    @Override
    public void updateAvailableDABServices(RadioStationsContainer radioStationsContainer) {
        this.iterateListener(34, new ExlapAbstractRadioService$5(this, radioStationsContainer));
    }

    @Override
    public void updateAvailableDABServiceComponents(RadioStationsContainer radioStationsContainer) {
        this.iterateListener(35, new ExlapAbstractRadioService$6(this, radioStationsContainer));
    }

    @Override
    public void updateRadioAMPresets(RadioPresetsContainer radioPresetsContainer) {
        this.iterateListener(36, new ExlapAbstractRadioService$7(this, radioPresetsContainer));
    }

    @Override
    public void updateRadioFMPresets(RadioPresetsContainer radioPresetsContainer) {
        this.iterateListener(37, new ExlapAbstractRadioService$8(this, radioPresetsContainer));
    }

    @Override
    public void updateRadioDABPresets(RadioPresetsContainer radioPresetsContainer) {
        this.iterateListener(38, new ExlapAbstractRadioService$9(this, radioPresetsContainer));
    }

    @Override
    public void updateRadioTuner(RadioStationInfoContainer radioStationInfoContainer) {
        this.iterateListener(39, new ExlapAbstractRadioService$10(this, radioStationInfoContainer));
    }

    @Override
    public void updateRadioFrequencyRanges(RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
        this.iterateListener(40, new ExlapAbstractRadioService$11(this, radioFrequencyRangesContainer));
    }

    @Override
    public void updateTrafficAnnouncement(TrafficAnnouncementContainer trafficAnnouncementContainer) {
        this.iterateListener(48, new ExlapAbstractRadioService$12(this, trafficAnnouncementContainer));
    }

    @Override
    public void updateRadioText(RadioTextContainer radioTextContainer) {
        this.iterateListener(49, new ExlapAbstractRadioService$13(this, radioTextContainer));
    }
}

