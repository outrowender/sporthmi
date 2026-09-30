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
    public void startGuidance(int var1, AddressContainer var2);

    public void resultStartGuidance(int var1, StartGuidanceResultContainer var2);

    public void resolveAddress(int var1, AddressContainer var2);

    public void resultResolveAddress(int var1, AddressContainer var2);

    public void stopGuidance(int var1);

    public void resolveLastDestination(int var1, LastDestinationContainer var2);

    public void resultResolveLastDestination(int var1, AddressContainer var2);

    public void importGPX(int var1, ImportGPXDataContainer var2);

    public void resultImportGPX(int var1, ImportGPXResultContainer var2);
}

