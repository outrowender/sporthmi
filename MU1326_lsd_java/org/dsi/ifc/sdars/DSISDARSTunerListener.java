/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.sdars;

import org.dsi.ifc.base.DSIListener;
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

public interface DSISDARSTunerListener
extends DSIListener {
    public void updateElectronicSerialCode(String var1, int var2);

    public void updateServiceStatus3(ServiceStatus3 var1, int var2);

    public void updateSignalQuality(SignalQuality var1, int var2);

    public void updateSelectedStation(StationInfo var1, int var2);

    public void updateStationList(StationInfo[] var1, int var2);

    public void updateCategoryList(CategoryInfo[] var1, int var2);

    public void informationRadioText(RadioText var1);

    public void informationRadioText2(RadioText[] var1);

    public void updateStaticTaggingInfo(String var1, String var2, int var3);

    public void updateDetectedDevice(int var1, int var2);

    public void selectStationStatus(int var1);

    public void responseTime(DateTime var1);

    public void responseEPG24Hour(EPGShortInfo var1);

    public void responseEPGDescription(EPGDescription var1);

    public void updateAvailability(int var1, int var2);

    public void updateStationDescription(StationDescription[] var1, int var2);

    public void updateSubscriptionStatus(SubscriptionStatus var1, int var2);

    public void informationEPGChannelList(EPGShortInfo[] var1);

    public void informationChannelArt(ImageInformation[] var1);

    public void informationBackgroundArt(ImageInformation[] var1);

    public void informationAlbumArt(ImageInformation[] var1);

    public void informationGenreArt(ImageInformation[] var1);

    public void informationStudioArt(ImageInformation[] var1);

    public void updateProfileState(int var1, int var2, int var3);

    public void profileChanged(int var1, int var2);

    public void profileCopied(int var1, int var2, int var3);

    public void profileReset(int var1, int var2);

    public void profileResetAll(int var1);
}

