/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.ifc.service.ExlapRadioService;
import de.audi.tghu.exlap.impl.container.RadioBandsContainer;
import de.audi.tghu.exlap.impl.container.RadioFrequencyRangesContainer;
import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;
import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.container.RadioTextContainer;
import de.audi.tghu.exlap.impl.container.TrafficAnnouncementContainer;

public abstract class ExlapAbstractRadioService
extends ExlapAbstractService
implements ExlapRadioService,
ExlapRadioListener {
    public void updateAvailableRadioBands(final RadioBandsContainer radioBandsContainer) {
        this.iterateListener(28, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateAvailableRadioBands(radioBandsContainer);
            }
        });
    }

    public void updateAvailableAMStations(final RadioStationsContainer radioStationsContainer) {
        this.iterateListener(31, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateAvailableAMStations(radioStationsContainer);
            }
        });
    }

    public void updateAvailableFMStations(final RadioStationsContainer radioStationsContainer) {
        this.iterateListener(32, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateAvailableFMStations(radioStationsContainer);
            }
        });
    }

    public void updateAvailableDABEnsembles(final RadioStationsContainer radioStationsContainer) {
        this.iterateListener(33, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateAvailableDABEnsembles(radioStationsContainer);
            }
        });
    }

    public void updateAvailableDABServices(final RadioStationsContainer radioStationsContainer) {
        this.iterateListener(34, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateAvailableDABServices(radioStationsContainer);
            }
        });
    }

    public void updateAvailableDABServiceComponents(final RadioStationsContainer radioStationsContainer) {
        this.iterateListener(35, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateAvailableDABServiceComponents(radioStationsContainer);
            }
        });
    }

    public void updateRadioAMPresets(final RadioPresetsContainer radioPresetsContainer) {
        this.iterateListener(36, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateRadioAMPresets(radioPresetsContainer);
            }
        });
    }

    public void updateRadioFMPresets(final RadioPresetsContainer radioPresetsContainer) {
        this.iterateListener(37, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateRadioFMPresets(radioPresetsContainer);
            }
        });
    }

    public void updateRadioDABPresets(final RadioPresetsContainer radioPresetsContainer) {
        this.iterateListener(38, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateRadioDABPresets(radioPresetsContainer);
            }
        });
    }

    public void updateRadioTuner(final RadioStationInfoContainer radioStationInfoContainer) {
        this.iterateListener(39, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateRadioTuner(radioStationInfoContainer);
            }
        });
    }

    public void updateRadioFrequencyRanges(final RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
        this.iterateListener(40, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateRadioFrequencyRanges(radioFrequencyRangesContainer);
            }
        });
    }

    public void updateTrafficAnnouncement(final TrafficAnnouncementContainer trafficAnnouncementContainer) {
        this.iterateListener(48, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateTrafficAnnouncement(trafficAnnouncementContainer);
            }
        });
    }

    public void updateRadioText(final RadioTextContainer radioTextContainer) {
        this.iterateListener(49, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapRadioListener)exlapListener).updateRadioText(radioTextContainer);
            }
        });
    }
}

