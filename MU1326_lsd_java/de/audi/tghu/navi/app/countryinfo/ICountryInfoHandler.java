/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.countryinfo;

import de.audi.tghu.command.CommandList;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public interface ICountryInfoHandler {
    default public void updateRoadClassSpeedInfo(RoadClassSpeedInfo[] roadClassSpeedInfoArray) {
    }

    default public void updateCountryInfo(CountryInfo countryInfo) {
    }

    default public void startCountryInput(boolean bl) {
    }

    default public void startCountryInput(boolean bl, char c2) {
    }

    default public void initiateCountry() {
    }

    default public void setCountry(NavLocation navLocation) {
    }

    default public void setCountry(NavLocation navLocation, CommandList commandList) {
    }
}

