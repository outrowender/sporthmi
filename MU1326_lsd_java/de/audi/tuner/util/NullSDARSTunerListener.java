/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.ifc.SDARSTunerListener;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;

public class NullSDARSTunerListener
extends NullService
implements SDARSTunerListener {
    public NullSDARSTunerListener(LogChannel logChannel) {
        super(logChannel, "SDARSTunerListener");
    }

    public void updateElectronicSerialCode(String string) {
        this.log();
    }

    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
        this.log();
    }

    public void updateSignalQuality(SignalQuality signalQuality) {
        this.log();
    }

    public void updateSelectedStation(StationInfo stationInfo) {
        this.log();
    }

    public void updateStationList(StationInfo[] stationInfoArray) {
        this.log();
    }

    public void updateCategoryList(CategoryInfo[] categoryInfoArray) {
        this.log();
    }

    public void informationRadioText(RadioText radioText) {
        this.log();
    }

    public void informationRadioText2(RadioText[] radioTextArray) {
        this.log();
    }

    public void informationChannelArt(ImageInformation[] imageInformationArray) {
        this.log();
    }

    public void updateStaticTaggingInfo(String string, String string2) {
        this.log();
    }

    public void updateDetectedDevice(int n) {
        this.log();
    }

    public void selectStationStatus(int n) {
        this.log();
    }

    public void updateAvailability(int n) {
        this.log();
    }

    public void updateStationDescription(StationDescription[] stationDescriptionArray) {
        this.log();
    }

    public void responseTime(DateTime dateTime) {
        this.log();
    }

    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.log();
    }

    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
        this.log();
    }

    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
        this.log();
    }

    public void responseEPGDescription(EPGDescription ePGDescription) {
        this.log();
    }
}

