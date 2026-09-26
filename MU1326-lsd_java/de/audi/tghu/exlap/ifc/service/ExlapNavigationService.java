/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.service;

import de.audi.tghu.exlap.ExlapService;
import de.audi.tghu.exlap.ifc.listener.ExlapNavigationListener;
import de.audi.tghu.exlap.impl.container.AddressContainer;
import de.audi.tghu.exlap.impl.container.ImportGPXDataContainer;
import de.audi.tghu.exlap.impl.container.ImportGPXResultContainer;
import de.audi.tghu.exlap.impl.container.LastDestinationContainer;
import de.audi.tghu.exlap.impl.container.StartGuidanceResultContainer;

public interface ExlapNavigationService
extends ExlapService,
ExlapNavigationListener {
    default public void startGuidance(int n, AddressContainer addressContainer) {
    }

    default public void resultStartGuidance(int n, StartGuidanceResultContainer startGuidanceResultContainer) {
    }

    default public void resolveAddress(int n, AddressContainer addressContainer) {
    }

    default public void resultResolveAddress(int n, AddressContainer addressContainer) {
    }

    default public void stopGuidance(int n) {
    }

    default public void resolveLastDestination(int n, LastDestinationContainer lastDestinationContainer) {
    }

    default public void resultResolveLastDestination(int n, AddressContainer addressContainer) {
    }

    default public void importGPX(int n, ImportGPXDataContainer importGPXDataContainer) {
    }

    default public void resultImportGPX(int n, ImportGPXResultContainer importGPXResultContainer) {
    }
}

