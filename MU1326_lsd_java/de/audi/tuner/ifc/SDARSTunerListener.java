/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.ifc.CmdDefaultListener;
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

public interface SDARSTunerListener
extends CmdDefaultListener {
    default public void updateElectronicSerialCode(String string) {
    }

    default public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
    }

    default public void updateSignalQuality(SignalQuality signalQuality) {
    }

    default public void updateSelectedStation(StationInfo stationInfo) {
    }

    default public void updateStationList(StationInfo[] stationInfoArray) {
    }

    default public void updateCategoryList(CategoryInfo[] categoryInfoArray) {
    }

    default public void informationRadioText(RadioText radioText) {
    }

    default public void informationRadioText2(RadioText[] radioTextArray) {
    }

    default public void updateStaticTaggingInfo(String string, String string2) {
    }

    default public void updateDetectedDevice(int n) {
    }

    default public void selectStationStatus(int n) {
    }

    default public void updateAvailability(int n) {
    }

    default public void updateStationDescription(StationDescription[] stationDescriptionArray) {
    }

    default public void responseTime(DateTime dateTime) {
    }

    default public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
    }

    default public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
    }

    default public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
    }

    default public void responseEPGDescription(EPGDescription ePGDescription) {
    }

    default public void informationChannelArt(ImageInformation[] imageInformationArray) {
    }
}

