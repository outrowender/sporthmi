/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars;

import de.esolutions.fw.comm.core.method.MethodException;
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

public interface DSISDARSTunerReply {
    public static final String IPL_COMM_UUID = "9513adb3-74d0-5976-8f10-298e5e449901";
    public static final String IPL_COMM_INTERFACE_KEY = "54f1a5de-eaca-5072-8ab7-8bc249d76713";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.20";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.20";

    public void updateElectronicSerialCode(String var1, int var2) throws MethodException;

    public void updateServiceStatus3(ServiceStatus3 var1, int var2) throws MethodException;

    public void updateSignalQuality(SignalQuality var1, int var2) throws MethodException;

    public void updateSelectedStation(StationInfo var1, int var2) throws MethodException;

    public void updateStationList(StationInfo[] var1, int var2) throws MethodException;

    public void updateCategoryList(CategoryInfo[] var1, int var2) throws MethodException;

    public void informationRadioText(RadioText var1) throws MethodException;

    public void informationRadioText2(RadioText[] var1) throws MethodException;

    public void updateStaticTaggingInfo(String var1, String var2, int var3) throws MethodException;

    public void updateDetectedDevice(int var1, int var2) throws MethodException;

    public void selectStationStatus(int var1) throws MethodException;

    public void responseTime(DateTime var1) throws MethodException;

    public void responseEPG24Hour(EPGShortInfo var1) throws MethodException;

    public void responseEPGDescription(EPGDescription var1) throws MethodException;

    public void updateAvailability(int var1, int var2) throws MethodException;

    public void updateStationDescription(StationDescription[] var1, int var2) throws MethodException;

    public void updateSubscriptionStatus(SubscriptionStatus var1, int var2) throws MethodException;

    public void informationEPGChannelList(EPGShortInfo[] var1) throws MethodException;

    public void informationChannelArt(ImageInformation[] var1) throws MethodException;

    public void informationBackgroundArt(ImageInformation[] var1) throws MethodException;

    public void informationAlbumArt(ImageInformation[] var1) throws MethodException;

    public void informationGenreArt(ImageInformation[] var1) throws MethodException;

    public void informationStudioArt(ImageInformation[] var1) throws MethodException;

    public void updateProfileState(int var1, int var2, int var3) throws MethodException;

    public void profileChanged(int var1, int var2) throws MethodException;

    public void profileCopied(int var1, int var2, int var3) throws MethodException;

    public void profileReset(int var1, int var2) throws MethodException;

    public void profileResetAll(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

