/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.kombipictureserver;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIKombiPictureServer
extends DSIBase {
    public static final String VERSION = "2.11.4";
    public static final int SOURCETYPE_NOSOURCE = 0;
    public static final int SOURCETYPE_FM = 1;
    public static final int SOURCETYPE_AM = 2;
    public static final int SOURCETYPE_DAB = 3;
    public static final int SOURCETYPE_SDARS_XM = 4;
    public static final int SOURCETYPE_SDARS_SIRIUS = 5;
    public static final int SOURCETYPE_CD = 6;
    public static final int SOURCETYPE_CD_CHANGER = 7;
    public static final int SOURCETYPE_DVD = 8;
    public static final int SOURCETYPE_TV = 9;
    public static final int SOURCETYPE_HDD = 10;
    public static final int SOURCETYPE_SD = 11;
    public static final int SOURCETYPE_TPMEMO_TIM = 12;
    public static final int SOURCETYPE_AUX_IN_AUDIO = 13;
    public static final int SOURCETYPE_AUX_IN_VIDEO = 14;
    public static final int SOURCETYPE_PORTABLE_DEVICE = 15;
    public static final int SOURCETYPE_GENERIC_PLAYER = 16;
    public static final int SOURCETYPE_AM_TI = 17;
    public static final int SOURCETYPE_DVD_CHANGER = 18;
    public static final int SOURCETYPE_USB = 19;
    public static final int SOURCETYPE_JUKEBOX = 20;
    public static final int SOURCETYPE_BT_STREAM = 21;
    public static final int SOURCETYPE_BT_RCP = 22;
    public static final int SOURCETYPE_DVB_VIDEO = 23;
    public static final int SOURCETYPE_DVB_AUDIO = 24;
    public static final int SOURCETYPE_FLASHMEMORY = 25;
    public static final int SOURCETYPE_AUX_IN_VIDEO_TV = 32;
    public static final int SOURCETYPE_HDMI = 33;
    public static final int SOURCETYPE_ONLINE_MASS_STORAGE = 28;
    public static final int SOURCETYPE_ONLINE_RADIO = 35;
    public static final int SOURCETYPE_UNKNOWN = 255;
    public static final int COVERARTTYPE_NOPICTURE = 0;
    public static final int COVERARTTYPE_NORMAL = 1;
    public static final int COVERARTTYPE_DEFAULT = 2;
    public static final int ICONTYPE_ACTIVESOURCE = 0;
    public static final int ICONTYPE_SOURCELIST = 1;
    public static final int PHONEINSTANCE_MAIN = 0;
    public static final int PHONEINSTANCE_FIRST = 1;
    public static final int PHONEINSTANCE_SECOND = 2;
    public static final int PHONEINSTANCE_THIRD = 3;
    public static final int ID_INVALID = 0;
    public static final int ID_UNKNOWN = 65535;
    public static final int ADDRESSTYPE_BAP = 0;
    public static final int ADDRESSTYPE_MOST = 1;
    public static final int IDTYPE_COVERART = 0;
    public static final int IDTYPE_ADDRESSBOOKCONTACT = 1;
    public static final int IDTYPE_STATIONART = 2;
    public static final int CALLID_NOCALL = 254;
    public static final int CALLID_UNKNOWN = 255;
    public static final int ACTIVECALLPICTURETYPE_NOPICTURE = 0;
    public static final int ACTIVECALLPICTURETYPE_CONTACT = 1;
    public static final int ACTIVECALLPICTURETYPE_INFO = 2;
    public static final int ACTIVECALLPICTURETYPE_SERVICE = 3;
    public static final int ACTIVECALLPICTURETYPE_EMERGENCY = 4;
    public static final int ACTIVECALLPICTURETYPE_CONFERENCE = 5;
    public static final int ACTIVECALLPICTURETYPE_DEFAULT = 6;
    public static final int ADBCONTACTPICTURETYPES_NOPICTURE = 0;
    public static final int ADBCONTACTPICTURETYPES_CONTACT = 1;
    public static final int ADBCONTACTPICTURETYPES_DEFAULT = 2;
    public static final int STATIONARTTYPE_NOPICTURE = 0;
    public static final int STATIONARTTYPE_NORMAL = 1;
    public static final int STATIONARTTYPE_DEFAULT = 2;
    public static final int RT_SETKOMBIHMIREADY = 1000;
    public static final int RT_RESPONSECOVERART = 1001;
    public static final int RT_RESPONSESTATIONART = 1002;
    public static final int RT_RESPONSEACTIVECALLPICTURE = 1003;
    public static final int RT_RESPONSEADBCONTACTPICTURE = 1004;
    public static final int RT_RESPONSEINTERNALADDRESSID = 1006;
    public static final int RT_RESPONSEPICTURESERVERABILITIES = 1007;
    public static final int RT_RESPONSEPICTURESTREAM = 1008;
    public static final int RT_RESPONSEACTIVECALLPICTUREINSTANCE = 1009;
    public static final int RT_RESPONSEDYNAMICICON = 1010;
    public static final int IN_INDICATIONCOVERART = 3000;
    public static final int IN_INDICATIONSTATIONART = 3001;
    public static final int IN_INDICATIONACTIVECALLPICTURE = 3002;
    public static final int IN_INDICATIONINTERNALADDRESSID = 3003;
    public static final int IN_INDICATIONADBCONTACTPICTURE = 3004;
    public static final int IN_INDICATIONPICTURESTREAMABILITIES = 3005;
    public static final int IN_INDICATIONPICTURESTREAM = 3006;
    public static final int IN_INDICATIONACTIVECALLPICTUREINSTANCE = 3007;
    public static final int IN_INDICATIONDYNAMICICON = 3008;
    public static final int AVAILABLEPICTURESOURCES_ONLINEAVAILABLE = 1;
    public static final int AVAILABLEPICTURESOURCES_AUDIOAVAILABLE = 2;
    public static final int AVAILABLEPICTURESOURCES_NAVIGATIONAVAILABLE = 4;
    public static final int AVAILABLEPICTURESOURCES_TELEPHONEAVAILABLE = 8;
    public static final int AVAILABLEPICTURESOURCES_PICNAVAVAILABLE = 16;
    public static final int AVAILABLEPICTURESOURCES_BRANDINGAVAILABLE = 32;
    public static final int LISTPOSTYPE_ARBITRARY = 0;
    public static final int LISTPOSTYPE_8BYTE = 1;
    public static final int PSSOURCETYPE_ONLINE = 0;
    public static final int PSSOURCETYPE_AUDIO = 1;
    public static final int PSSOURCETYPE_NAVIGATION = 2;
    public static final int PSSOURCETYPE_TELEPHONE = 3;
    public static final int PSSOURCETYPE_PICNAV = 4;
    public static final int PSSOURCETYPE_BRANDING = 5;

    public void setKombiHmiReady();

    public void responseCoverArt(long var1, int var3, int var4, int var5, ResourceLocator var6);

    public void responseStationArt(long var1, int var3, int var4, int var5, ResourceLocator var6);

    public void responseActiveCallPicture(int var1, int var2, ResourceLocator var3);

    public void responseActiveCallPictureInstance(int var1, int var2, int var3, ResourceLocator var4);

    public void responseDynamicIcon(int var1, int var2, boolean var3, ResourceLocator var4);

    public void responseAdbContactPicture(long var1, int var3, int var4, ResourceLocator var5);

    public void responseInternalAddressID(long var1, int var3, int var4);

    public void responsePictureServerAbilities(int var1);

    public void responsePictureStream(int var1, short var2, short var3, int var4, int var5, byte[] var6);
}

