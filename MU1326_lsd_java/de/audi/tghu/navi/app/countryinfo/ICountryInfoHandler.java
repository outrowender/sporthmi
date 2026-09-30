/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.countryinfo;

import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public interface ICountryInfoHandler {
    public void updateRoadClassSpeedInfo(RoadClassSpeedInfo[] var1);

    public void updateCountryInfo(CountryInfo var1);

    public void startCountryInput(boolean var1);

    public void startCountryInput(boolean var1, char var2);

    public void initiateCountry();

    public void setCountry(NavLocation var1);

    public void setCountry(NavLocation var1, CommandList var2);
}

