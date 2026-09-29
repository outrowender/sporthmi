/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.tghu.navi.app.car.IVehicleStatesEventsProvider;
import de.audi.tghu.navi.app.guidance.IVehicleModelAccess;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public interface IVehicle {
    default public void unitsChanged() {
    }

    default public void refreshPositionDescription() {
    }

    default public void refreshPosPosition(PosPosition posPosition) {
    }

    default public void refreshHeight() {
    }

    default public NavLocation getVehicleLocation() {
    }

    default public NavLocation getVehicleLocationDescription() {
    }

    default public NavLocation getVehicleCountryLocation() {
    }

    default public void setVehicleCountryLocation(NavLocation navLocation) {
    }

    default public boolean isMatchedToDigitalMap() {
    }

    default public String getCountryAbbreviation() {
    }

    default public String getCountry() {
    }

    default public String getCity() {
    }

    default public String getStreet() {
    }

    default public String getLatitude() {
    }

    default public String getLongitude() {
    }

    default public int getHeading(PosPosition posPosition) {
    }

    default public PosPosition getFrontUnitPosition() {
    }

    default public PosPosition getPosition() {
    }

    default public void updateESPData(int n, boolean bl) {
    }

    default public int getCarVelocity() {
    }

    default public void vehicleStatesEventsProviderAdded(IVehicleStatesEventsProvider iVehicleStatesEventsProvider) {
    }

    default public void setModelAccess(IVehicleModelAccess iVehicleModelAccess) {
    }

    default public void cleanUp() {
    }
}

