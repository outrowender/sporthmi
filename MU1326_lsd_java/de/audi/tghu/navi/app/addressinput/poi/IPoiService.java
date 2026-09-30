/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.IPoiSDSHandler;
import de.audi.tghu.navi.app.addressinput.poi.fuelwarning.IPoiFuelWarningService;
import de.audi.tghu.navi.app.car.IVehicleStatesEventsProvider;
import de.audi.tghu.navi.app.poi.poiwarning.PoiWarningManager;
import org.dsi.ifc.global.NavLocation;

public interface IPoiService {
    public void cleanup();

    public void startPoiStackSequence(NavLocation var1);

    public void vehicleStatesEventsProviderAdded(IVehicleStatesEventsProvider var1);

    public void onFullyOperable();

    public void onDisclaimerAccepted();

    public CommandList getParkingNearDestinationSequenceWithDistanceFromCCP(NavLocation var1);

    public CommandList getParkingNearDestinationSequenceWithDistanceFromDestination(NavLocation var1);

    public void startParkingNearDestination(NavLocation var1);

    public CommandList getParkingAlongTheRouteSequence();

    public PoiWarningManager getPoiWarningManager();

    public IPoiFuelWarningService getPoiFuelWarningService();

    public void enterPoiMainScreen(boolean var1, boolean var2);

    public void destPOIHKReturn(int var1, int var2);

    public void navFuelFeatureActive(int var1, int var2);

    public void startPoiWithSearchContext(int var1, NavLocation var2, boolean var3);

    public void startPoiWithSearchContext(int var1, NavLocation var2, boolean var3, boolean var4);

    public void startPoiWithSearchContextAlongRoute();

    public void startPoiWithSearchContextLocationVicinity();

    public void startPoiHybridSearch(int var1, NavLocation var2, boolean var3);

    public void deletePersonalPOIDataBases();

    public IPoiSDSHandler getPoiSDSHandler();

    public void setRouteGuidanceStartedByUser(boolean var1);

    public void showPoiDetailScreen(NavLocation var1);

    public boolean isFuelWarningActive();

    public void setFuelWarningActive(boolean var1);

    public void resetSearchContext();
}

