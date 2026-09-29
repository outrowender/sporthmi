/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.sdars;

import de.audi.tuner.app.cmd.AbstractRadioCmd;
import de.audi.tuner.app.cmd.sdars.AbstractSDARSCmd$Builder;
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

    public AbstractSDARSCmd(AbstractSDARSCmd$Builder abstractSDARSCmd$Builder) {
        super(AbstractSDARSCmd$Builder.access$000(abstractSDARSCmd$Builder), AbstractSDARSCmd$Builder.access$100(abstractSDARSCmd$Builder), 6);
        this.defaultSDARSListener = AbstractSDARSCmd$Builder.access$200(abstractSDARSCmd$Builder);
        this.sdarsTuner = AbstractSDARSCmd$Builder.access$300(abstractSDARSCmd$Builder);
    }

    @Override
    public void updateElectronicSerialCode(String string) {
        this.defaultSDARSListener.updateElectronicSerialCode(string);
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
        this.defaultSDARSListener.updateServiceStatus3(serviceStatus3);
    }

    @Override
    public void updateSignalQuality(SignalQuality signalQuality) {
        this.defaultSDARSListener.updateSignalQuality(signalQuality);
    }

    @Override
    public void updateSelectedStation(StationInfo stationInfo) {
        this.defaultSDARSListener.updateSelectedStation(stationInfo);
    }

    @Override
    public void updateStationList(StationInfo[] stationInfoArray) {
        this.defaultSDARSListener.updateStationList(stationInfoArray);
    }

    @Override
    public void updateCategoryList(CategoryInfo[] categoryInfoArray) {
        this.defaultSDARSListener.updateCategoryList(categoryInfoArray);
    }

    @Override
    public void informationRadioText(RadioText radioText) {
        this.defaultSDARSListener.informationRadioText(radioText);
    }

    @Override
    public void informationRadioText2(RadioText[] radioTextArray) {
        this.defaultSDARSListener.informationRadioText2(radioTextArray);
    }

    @Override
    public void updateStaticTaggingInfo(String string, String string2) {
        this.defaultSDARSListener.updateStaticTaggingInfo(string, string2);
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.defaultSDARSListener.updateDetectedDevice(n);
    }

    @Override
    public void selectStationStatus(int n) {
        this.defaultSDARSListener.selectStationStatus(n);
    }

    @Override
    public void updateAvailability(int n) {
        this.defaultSDARSListener.updateAvailability(n);
    }

    @Override
    public void updateStationDescription(StationDescription[] stationDescriptionArray) {
        this.defaultSDARSListener.updateStationDescription(stationDescriptionArray);
    }

    @Override
    public void responseTime(DateTime dateTime) {
        this.defaultSDARSListener.responseTime(dateTime);
    }

    @Override
    public void updateSubscriptionStatus(SubscriptionStatus subscriptionStatus) {
        this.defaultSDARSListener.updateSubscriptionStatus(subscriptionStatus);
    }

    @Override
    public void informationEPGChannelList(EPGShortInfo[] ePGShortInfoArray) {
        this.defaultSDARSListener.informationEPGChannelList(ePGShortInfoArray);
    }

    @Override
    public void informationChannelArt(ImageInformation[] imageInformationArray) {
        this.defaultSDARSListener.informationChannelArt(imageInformationArray);
    }

    @Override
    public void responseEPG24Hour(EPGShortInfo ePGShortInfo) {
        this.defaultSDARSListener.responseEPG24Hour(ePGShortInfo);
    }

    @Override
    public void responseEPGDescription(EPGDescription ePGDescription) {
        this.defaultSDARSListener.responseEPGDescription(ePGDescription);
    }
}

