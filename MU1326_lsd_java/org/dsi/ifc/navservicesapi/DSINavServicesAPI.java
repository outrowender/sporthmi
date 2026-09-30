/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navservicesapi;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.navservicesapi.ADBPersonalData;
import org.dsi.ifc.navservicesapi.AddressData;
import org.dsi.ifc.navservicesapi.ProfileInfo;
import org.dsi.ifc.navservicesapi.TryMatchLocationData;

public interface DSINavServicesAPI
extends DSIBase {
    public static final String VERSION = "2.11.16";
    public static final int ATTR_LANGUAGE = 1;
    public static final int ATTR_AVAILABLELANGUAGES = 2;
    public static final int ATTR_ICONDIRECTORY = 3;
    public static final int ATTR_RECEIVABLESTATIONS = 4;
    public static final int ATTR_NAVIGATIONSTATE = 5;
    public static final int ATTR_CURRENTPOSITION = 6;
    public static final int NAVSTATE_NAVCORE_STATE_NOT_READY = 0;
    public static final int NAVSTATE_NAVCORE_STATE_READY = 1;
    public static final int ADBPROFILE_GLOBAL_PROFILE = 0;
    public static final int ADBPROFILE_PRIVATE_PROFILE_1 = 1;
    public static final int ADBPROFILE_PRIVATE_PROFILE_2 = 2;
    public static final int ADBPROFILE_PRIVATE_PROFILE_3 = 3;
    public static final int ADBPROFILE_PRIVATE_PROFILE_4 = 4;
    public static final int ADBTYPE_ADDRESS_TYPE_PRIVATE = 0;
    public static final int ADBTYPE_ADDRESS_TYPE_BUSINESS = 1;
    public static final int EFILINKCONTEXT_NAVIGATION = 0;
    public static final int EFILINKCONTEXT_REMOTE_HMI = 1;
    public static final int DATACONNECTION_ESTABLISHED = 0;
    public static final int DATACONNECTION_ABORTED = 1;
    public static final int DATACONNECTION_UNINITIALISED = 2;
    public static final int DATACONNECTION_ERROR = 3;
    public static final int RT_AUDIOSTART = 1002;
    public static final int RT_AUDIOSTOP = 1003;
    public static final int RT_SETDISTANCEUNIT = 1004;
    public static final int RT_SETLANGUAGE = 1005;
    public static final int RT_CREATEEXPORTFILE = 1006;
    public static final int RT_IMPORTFILE = 1007;
    public static final int RT_SETENGINEERINGMENUSTATE = 1008;
    public static final int RT_RESETTOFACTORYSETTINGS = 1009;
    public static final int RT_DELETECUSTOMERDATA = 1010;
    public static final int RT_INITIATEPHONECALLTOADBENTRYRESULT = 1013;
    public static final int RT_NAVIGATETO = 1016;
    public static final int RT_DELETEPROFILEDATA = 1017;
    public static final int RT_SETPROFILEINFO = 1018;
    public static final int RT_TTS2ANNOUNCEMENTFINISHED = 1020;
    public static final int RT_STARTROUTEGUIDANCE = 1021;
    public static final int RT_EFILINKSELECTED = 1022;
    public static final int RT_SELECTREMOTESEARCHLOCATION = 1023;
    public static final int RT_CHECKLICENSERESULT = 1024;
    public static final int RT_CHECKDATACONNECTIONRESULT = 1025;
    public static final int RT_LITRYMATCHLOCATION = 1026;
    public static final int RT_REQUESTRRDFORLOCATIONDATA = 1027;
    public static final int RP_CREATEEXPORTFILE = 2000;
    public static final int RP_IMPORTFILE = 2001;
    public static final int RP_RESETTOFACTORYSETTINGSRESULT = 2002;
    public static final int RP_DELETECUSTOMERDATARESULT = 2003;
    public static final int RP_EFILINKSELECTEDRESULT = 2004;
    public static final int RP_SELECTREMOTESEARCHLOCATIONRESULT = 2005;
    public static final int RP_REQUESTRRDFORLOCATIONDATARESULT = 2006;
    public static final int IN_PHONEDIALNUMBER = 3000;
    public static final int IN_AUDIOREQUEST = 3002;
    public static final int IN_INITIATEPHONECALLTOADBENTRY = 3004;
    public static final int IN_SETBROWSERURL = 3005;
    public static final int IN_PREPAREANDPLAYTTS2ANNOUNCEMENT = 3006;
    public static final int IN_ABORTTTS2ANNOUNCEMENT = 3007;
    public static final int IN_CHECKLICENSE = 3008;
    public static final int IN_CHECKDATACONNECTION = 3009;

    public void setProfileInfo(ProfileInfo[] var1, int var2);

    public void navigateTo(String var1, int var2, ADBPersonalData var3, boolean var4, AddressData[] var5);

    public void initiatePhoneCallToADBEntryResult(String var1, boolean var2);

    public void deleteProfileData(int var1);

    public void audioStart();

    public void audioStop();

    public void setDistanceUnit(int var1);

    public void setLanguage(String var1);

    public void createExportFile(String var1, int var2);

    public void importFile(String var1, int var2);

    public void setEngineeringMenuState(int var1);

    public void resetToFactorySettings();

    public void deleteCustomerData();

    public void efiLinkSelected(String var1, int var2);

    public void selectRemoteSearchLocation();

    public void tts2AnnouncementFinished(int var1);

    public void startRouteGuidance(int var1, int var2, ResourceLocator var3);

    public void checkLicenseResult(int var1, int var2, long var3);

    public void checkDataConnectionResult(int var1);

    public void liTryMatchLocation(TryMatchLocationData var1);

    public void requestRrdForLocationData(int var1, TryMatchLocationData[] var2);
}

