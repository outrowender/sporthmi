/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.ifc.ISDARSTuner;
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

public abstract class AbstractSDARSCmd
extends AbstractRadioCmd
implements SDARSTunerListener {
    private final SDARSTunerListener defaultSDARSListener;
    protected final ISDARSTuner sdarsTuner;

    public AbstractSDARSCmd(Builder builder) {
        super(builder.framework, builder.lc, 6);
        this.defaultSDARSListener = builder.defaultSDARSListener;
        this.sdarsTuner = builder.sdarsTuner;
    }

    public void updateElectronicSerialCode(String string) {
        this.defaultSDARSListener.updateElectronicSerialCode(string);
    }

    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
        this.defaultSDARSListener.updateServiceStatus3(serviceStatus3);
    }

    public void updateSignalQuality(SignalQuality signalQuality) {
        this.defaultSDARSListener.updateSignalQuality(signalQuality);
    }

    public void updateSelectedStation(StationInfo stationInfo) {
        this.defaultSDARSListener.updateSelectedStation(stationInfo);
    }

    public void updateStationList(StationInfo[] stationInfoArray) {
        this.defaultSDARSListener.updateStationList(stationInfoArray);
    }

    public void updateCategoryList(CategoryInfo[] categoryInfoArray) {
        this.defaultSDARSListener.updateCategoryList(categoryInfoArray);
    }

    public void informationRadioText(RadioText radioText) {
        this.defaultSDARSListener.informationRadioText(radioText);
    }

    public void informationRadioText2(RadioText[] radioTextArray) {
        this.defaultSDARSListener.informationRadioText2(radioTextArray);
    }

    public void updateStaticTaggingInfo(String string, String string2) {
        this.defaultSDARSListener.updateStaticTaggingInfo(string, string2);
    }

    public void updateDetectedDevice(int n) {
        this.defaultSDARSListener.updateDetectedDevice(n);
    }

    public void selectStationStatus(int n) {
        this.defaultSDARSListener.selectStationStatus(n);
    }

    public void updateAvailability(int n) {
        this.defaultSDARSListener.updateAvailability(n);
    }

    public void updateStationDescription(StationDescription[] stationDescriptionArray) {
        this.defaultSDARSListener.updateStationDescription(stationDescriptionArray);
    }

    public void responseTime(DateTime dateTime) {
        this.defaultSDARSListener.responseTime(dateTime);
    }

    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.defaultSDARSListener.updateSubscriptionStatus(subscriptionStatus);
    }

    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
        this.defaultSDARSListener.informationEPGChannelList(ePGShortInfoArray);
    }

    public void informationChannelArt(ImageInformation[] imageInformationArray) {
        this.defaultSDARSListener.informationChannelArt(imageInformationArray);
    }

    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
        this.defaultSDARSListener.responseEPG24Hour(ePGShortInfo);
    }

    public void responseEPGDescription(EPGDescription ePGDescription) {
        this.defaultSDARSListener.responseEPGDescription(ePGDescription);
    }

    public static class Builder {
        private final LogChannel lc;
        private final ISDARSTuner sdarsTuner;
        private final SDARSTunerListener defaultSDARSListener;
        private final IFrameworkAccess framework;

        public Builder(IFrameworkAccess iFrameworkAccess, LogChannel logChannel, ISDARSTuner iSDARSTuner, SDARSTunerListener sDARSTunerListener) {
            this.framework = iFrameworkAccess;
            this.lc = logChannel;
            this.sdarsTuner = iSDARSTuner;
            this.defaultSDARSListener = sDARSTunerListener;
        }
    }
}

