/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ifc.listener.ExlapNavigationListener;
import de.audi.tghu.exlap.ifc.service.ExlapNavigationService;
import de.audi.tghu.exlap.impl.container.AddressContainer;
import de.audi.tghu.exlap.impl.container.GuidanceRemainingContainer;
import de.audi.tghu.exlap.impl.container.GuidanceStateContainer;
import de.audi.tghu.exlap.impl.container.ImportGPXResultContainer;
import de.audi.tghu.exlap.impl.container.LastDestinationsContainer;
import de.audi.tghu.exlap.impl.container.StartGuidanceResultContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractNavigationService$1;
import de.audi.tghu.exlap.impl.service.ExlapAbstractNavigationService$2;
import de.audi.tghu.exlap.impl.service.ExlapAbstractNavigationService$3;
import de.audi.tghu.exlap.impl.service.ExlapAbstractNavigationService$4;
import de.audi.tghu.exlap.impl.service.ExlapAbstractNavigationService$5;

public abstract class ExlapAbstractNavigationService
extends ExlapAbstractService
implements ExlapNavigationService,
ExlapNavigationListener {
    @Override
    public void updateLocation(AddressContainer addressContainer) {
        this.iterateListener(1, new ExlapAbstractNavigationService$1(this, addressContainer));
    }

    @Override
    public void updateGuidanceState(GuidanceStateContainer guidanceStateContainer) {
        this.iterateListener(7, new ExlapAbstractNavigationService$2(this, guidanceStateContainer));
    }

    @Override
    public void updateGuidanceDestination(AddressContainer addressContainer) {
        this.iterateListener(8, new ExlapAbstractNavigationService$3(this, addressContainer));
    }

    @Override
    public void updateGuidanceRemaining(GuidanceRemainingContainer guidanceRemainingContainer) {
        this.iterateListener(24, new ExlapAbstractNavigationService$4(this, guidanceRemainingContainer));
    }

    @Override
    public void updateLastDestinations(LastDestinationsContainer lastDestinationsContainer) {
        this.iterateListener(29, new ExlapAbstractNavigationService$5(this, lastDestinationsContainer));
    }

    @Override
    public void resultStartGuidance(int n, StartGuidanceResultContainer startGuidanceResultContainer) {
        this.actionResult(n, 2, startGuidanceResultContainer);
    }

    @Override
    public void resultResolveAddress(int n, AddressContainer addressContainer) {
        this.actionResult(n, 5, addressContainer);
    }

    @Override
    public void resultResolveLastDestination(int n, AddressContainer addressContainer) {
        this.actionResult(n, 20, addressContainer);
    }

    @Override
    public void resultImportGPX(int n, ImportGPXResultContainer importGPXResultContainer) {
        this.actionResult(n, 38, importGPXResultContainer);
    }
}

