/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.DSISDARSTunerListener;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;

public class NullDSISDARSTunerListener
extends NullService
implements DSISDARSTunerListener {
    public NullDSISDARSTunerListener(LogChannel logChannel) {
        super(logChannel, "DSISDARSTunerListener");
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.log();
    }

    @Override
    public void updateElectronicSerialCode(String string, int n) {
        this.log();
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3, int n) {
        this.log();
    }

    @Override
    public void updateSignalQuality(SignalQuality signalQuality, int n) {
        this.log();
    }

    @Override
    public void updateSelectedStation(StationInfo stationInfo, int n) {
        this.log();
    }

    @Override
    public void updateStationList(StationInfo[] stationInfoArray, int n) {
        this.log();
    }

    @Override
    public void updateCategoryList(CategoryInfo[] categoryInfoArray, int n) {
        this.log();
    }

    public void updateRadioText(RadioText radioText, int n) {
        this.log();
    }

    @Override
    public void updateStaticTaggingInfo(String string, String string2, int n) {
        this.log();
    }

    @Override
    public void updateDetectedDevice(int n, int n2) {
        this.log();
    }

    @Override
    public void selectStationStatus(int n) {
        this.log();
    }

    @Override
    public void updateAvailability(int n, int n2) {
        this.log();
    }

    @Override
    public void updateStationDescription(StationDescription[] stationDescriptionArray, int n) {
        this.log();
    }

    @Override
    public void responseTime(DateTime dateTime) {
        this.log();
    }

    @Override
    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus, int n) {
        this.log();
    }

    public void updateRadioText2(RadioText[] radioTextArray, int n) {
        this.log();
    }

    @Override
    public void informationRadioText(RadioText radioText) {
        this.log();
    }

    @Override
    public void informationRadioText2(RadioText[] radioTextArray) {
        this.log();
    }

    @Override
    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
        this.log();
    }

    @Override
    public void responseEPGDescription(EPGDescription ePGDescription) {
        this.log();
    }

    @Override
    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
        this.log();
    }

    @Override
    public void informationChannelArt(ImageInformation[] imageInformationArray) {
        this.log();
    }

    @Override
    public void informationBackgroundArt(ImageInformation[] imageInformationArray) {
        this.log();
    }

    @Override
    public void informationAlbumArt(ImageInformation[] imageInformationArray) {
        this.log();
    }

    @Override
    public void informationGenreArt(ImageInformation[] imageInformationArray) {
        this.log();
    }

    @Override
    public void informationStudioArt(ImageInformation[] imageInformationArray) {
        this.log();
    }

    @Override
    public void updateProfileState(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void profileChanged(int n, int n2) {
        this.log();
    }

    @Override
    public void profileCopied(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void profileReset(int n, int n2) {
        this.log();
    }

    @Override
    public void profileResetAll(int n) {
        this.log();
    }
}

