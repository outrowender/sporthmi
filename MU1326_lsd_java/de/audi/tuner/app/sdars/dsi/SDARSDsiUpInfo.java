/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.epg.sdars.EPGShortInfoExt;
import de.audi.tuner.app.sdars.CategoryInfoExt;
import de.audi.tuner.app.sdars.StationInfoExt;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.LeagueEntry;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.SeekEntry;
import org.dsi.ifc.sdars.SeekPossibility;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.SubscriptionStatus;
import org.dsi.ifc.sdars.TeamEntry;
import org.dsi.ifc.sdars.TrafficWxEntry;

public class SDARSDsiUpInfo
extends RadioInfo {
    public void updateElectronicSerialCode(String string) {
    }

    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
    }

    public void updateSelectedStation(StationInfoExt stationInfoExt) {
    }

    public void updateStationList(StationInfoExt[] stationInfoExtArray) {
    }

    public void updateCategoryList(CategoryInfoExt[] categoryInfoExtArray) {
    }

    public void informationRadioText2(RadioText[] radioTextArray) {
    }

    public void updateStaticTaggingInfo(String string, String string2) {
    }

    public void updateDetectedDevice(int n) {
    }

    public void selectStationStatus(int n) {
    }

    public void updateAvailability(int n) {
    }

    public void responseTime(DateTime dateTime) {
    }

    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
    }

    public void informationEPGChannelList(EPGShortInfoExt[] ePGShortInfoExtArray) {
    }

    public void responseEPG24Hour(EPGShortInfoExt ePGShortInfoExt) {
    }

    public void responseEPGDescription(EPGDescription ePGDescription) {
    }

    public void updateStationDescription(StationDescription[] stationDescriptionArray) {
    }

    public void updateSeekPossibility(SeekPossibility seekPossibility) {
    }

    public void updateSeekList(SeekEntry[] seekEntryArray) {
    }

    public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray) {
    }

    public void updateSeekAlert(SeekAlert seekAlert) {
    }

    public void setSeekCommandResult(int n) {
    }

    public void manageSeekResult(int n) {
    }

    public void teamsOfLeague(TeamEntry[] teamEntryArray) {
    }

    public void leagues(LeagueEntry[] leagueEntryArray) {
    }

    public void updateSignalStatus(boolean bl) {
    }
}

