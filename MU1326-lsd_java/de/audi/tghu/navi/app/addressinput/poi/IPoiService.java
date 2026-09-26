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
    default public void cleanup() {
    }

    default public void startPoiStackSequence(NavLocation navLocation) {
    }

    default public void vehicleStatesEventsProviderAdded(IVehicleStatesEventsProvider iVehicleStatesEventsProvider) {
    }

    default public void onFullyOperable() {
    }

    default public void onDisclaimerAccepted() {
    }

    default public CommandList getParkingNearDestinationSequenceWithDistanceFromCCP(NavLocation navLocation) {
    }

    default public CommandList getParkingNearDestinationSequenceWithDistanceFromDestination(NavLocation navLocation) {
    }

    default public void startParkingNearDestination(NavLocation navLocation) {
    }

    default public CommandList getParkingAlongTheRouteSequence() {
    }

    default public PoiWarningManager getPoiWarningManager() {
    }

    default public IPoiFuelWarningService getPoiFuelWarningService() {
    }

    default public void enterPoiMainScreen(boolean bl, boolean bl2) {
    }

    default public void destPOIHKReturn(int n, int n2) {
    }

    default public void navFuelFeatureActive(int n, int n2) {
    }

    default public void startPoiWithSearchContext(int n, NavLocation navLocation, boolean bl) {
    }

    default public void startPoiWithSearchContext(int n, NavLocation navLocation, boolean bl, boolean bl2) {
    }

    default public void startPoiWithSearchContextAlongRoute() {
    }

    default public void startPoiWithSearchContextLocationVicinity() {
    }

    default public void startPoiHybridSearch(int n, NavLocation navLocation, boolean bl) {
    }

    default public void deletePersonalPOIDataBases() {
    }

    default public IPoiSDSHandler getPoiSDSHandler() {
    }

    default public void setRouteGuidanceStartedByUser(boolean bl) {
    }

    default public void showPoiDetailScreen(NavLocation navLocation) {
    }

    default public boolean isFuelWarningActive() {
    }

    default public void setFuelWarningActive(boolean bl) {
    }

    default public void resetSearchContext() {
    }
}

