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
    public void updateElectronicSerialCode(String var1);

    public void updateServiceStatus3(ServiceStatus3 var1);

    public void updateSignalQuality(SignalQuality var1);

    public void updateSelectedStation(StationInfo var1);

    public void updateStationList(StationInfo[] var1);

    public void updateCategoryList(CategoryInfo[] var1);

    public void informationRadioText(RadioText var1);

    public void informationRadioText2(RadioText[] var1);

    public void updateStaticTaggingInfo(String var1, String var2);

    public void updateDetectedDevice(int var1);

    public void selectStationStatus(int var1);

    public void updateAvailability(int var1);

    public void updateStationDescription(StationDescription[] var1);

    public void responseTime(DateTime var1);

    public void updateSubscriptionStatus(SubscriptionStatus var1);

    public void informationEPGChannelList(EPGShortInfo[] var1);

    public void responseEPG24Hour(EPGShortInfo var1);

    public void responseEPGDescription(EPGDescription var1);

    public void informationChannelArt(ImageInformation[] var1);
}

