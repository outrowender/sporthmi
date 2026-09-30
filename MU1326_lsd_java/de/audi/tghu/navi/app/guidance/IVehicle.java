/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.guidance;

import de.audi.tghu.navi.app.car.IVehicleStatesEventsProvider;
import de.audi.tghu.navi.app.guidance.IVehicleModelAccess;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.PosPosition;

public interface IVehicle {
    public void unitsChanged();

    public void refreshPositionDescription();

    public void refreshPosPosition(PosPosition var1);

    public void refreshHeight();

    public NavLocation getVehicleLocation();

    public NavLocation getVehicleLocationDescription();

    public NavLocation getVehicleCountryLocation();

    public void setVehicleCountryLocation(NavLocation var1);

    public boolean isMatchedToDigitalMap();

    public String getCountryAbbreviation();

    public String getCountry();

    public String getCity();

    public String getStreet();

    public String getLatitude();

    public String getLongitude();

    public int getHeading(PosPosition var1);

    public PosPosition getFrontUnitPosition();

    public PosPosition getPosition();

    public void updateESPData(int var1, boolean var2);

    public int getCarVelocity();

    public void vehicleStatesEventsProviderAdded(IVehicleStatesEventsProvider var1);

    public void setModelAccess(IVehicleModelAccess var1);

    public void cleanUp();
}

