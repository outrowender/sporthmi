/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapNavigationListener;
import de.audi.tghu.exlap.ifc.service.ExlapNavigationService;
import de.audi.tghu.exlap.impl.container.AddressContainer;
import de.audi.tghu.exlap.impl.container.GuidanceRemainingContainer;
import de.audi.tghu.exlap.impl.container.GuidanceStateContainer;
import de.audi.tghu.exlap.impl.container.ImportGPXResultContainer;
import de.audi.tghu.exlap.impl.container.LastDestinationsContainer;
import de.audi.tghu.exlap.impl.container.StartGuidanceResultContainer;

public abstract class ExlapAbstractNavigationService
extends ExlapAbstractService
implements ExlapNavigationService,
ExlapNavigationListener {
    public void updateLocation(final AddressContainer addressContainer) {
        this.iterateListener(1, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapNavigationListener)exlapListener).updateLocation(addressContainer);
            }
        });
    }

    public void updateGuidanceState(final GuidanceStateContainer guidanceStateContainer) {
        this.iterateListener(7, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapNavigationListener)exlapListener).updateGuidanceState(guidanceStateContainer);
            }
        });
    }

    public void updateGuidanceDestination(final AddressContainer addressContainer) {
        this.iterateListener(8, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapNavigationListener)exlapListener).updateGuidanceDestination(addressContainer);
            }
        });
    }

    public void updateGuidanceRemaining(final GuidanceRemainingContainer guidanceRemainingContainer) {
        this.iterateListener(24, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapNavigationListener)exlapListener).updateGuidanceRemaining(guidanceRemainingContainer);
            }
        });
    }

    public void updateLastDestinations(final LastDestinationsContainer lastDestinationsContainer) {
        this.iterateListener(29, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapNavigationListener)exlapListener).updateLastDestinations(lastDestinationsContainer);
            }
        });
    }

    public void resultStartGuidance(int n, StartGuidanceResultContainer startGuidanceResultContainer) {
        this.actionResult(n, 2, startGuidanceResultContainer);
    }

    public void resultResolveAddress(int n, AddressContainer addressContainer) {
        this.actionResult(n, 5, addressContainer);
    }

    public void resultResolveLastDestination(int n, AddressContainer addressContainer) {
        this.actionResult(n, 20, addressContainer);
    }

    public void resultImportGPX(int n, ImportGPXResultContainer importGPXResultContainer) {
        this.actionResult(n, 38, importGPXResultContainer);
    }
}

