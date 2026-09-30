/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRDevice;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRUser;

public interface DSIOnlineServiceRegistration
extends DSIBase {
    public static final String VERSION = "2.11.42";
    public static final int PROFILELRU_OK = 0;
    public static final int PROFILELRU_IOERROR = 1;
    public static final int PROFILELRU_INVALIDUSER = 2;
    public static final int PROFILELRU_INVALIDDOMAIN = 3;
    public static final int UPDATECONTROL_ADD = 0;
    public static final int UPDATECONTROL_REMOVE = 1;
    public static final int UPDATECONTROL_CHANGED = 2;
    public static final int UPDATECONTROL_ERROR = 3;
    public static final int UPDATECONTROL_EMPTY = 4;
    public static final int AUTOLOGIN_OK = 0;
    public static final int AUTOLOGIN_GONE = 1;
    public static final int AUTOLOGIN_ERROR = 2;
    public static final int DEVICECONNECTIONSTATE_DISCONNECTED = 0;
    public static final int DEVICECONNECTIONSTATE_INRANGE = 1;
    public static final int DEVICECONNECTIONSTATE_CONNECTED = 2;
    public static final int DEVICECONNECTIONSTATE_REMOVED = 3;
    public static final int LOGINFLAG_SHOWUSER = 1;
    public static final int LOGINFLAG_STOREPASSWORD = 2;
    public static final int LOGINFLAG_SHOWUSERANDSTOREPASSWORD = 3;
    public static final int LOGINFLAG_LOGIN = 4;
    public static final int LOGINFLAG_MMICONNECTAPP = 8;
    public static final int LOGINFLAG_AUTOCONNECT = 16;
    public static final int LOGINFLAG_LOGOUT = 128;
    public static final int LOGINFLAG_REMOVE = 256;
    public static final int PTYPE_INTERN = 0;
    public static final int PTYPE_BLUETOOTH = 1;
    public static final int PTYPE_IMSI = 2;
    public static final int PTYPE_ICC = 3;
    public static final int PTYPE_WLAN = 4;
    public static final int PTYPE_CARPROFILE = 5;
    public static final int GROUPID_BACKEND = 0;
    public static final int GROUPID_LOCAL = 1;
    public static final int GROUPID_ENABLER = 2;
    public static final int APPSTATE_DISABLED = 0;
    public static final int APPSTATE_ENABLED = 1;
    public static final int APPSTATE_ENABLED_ROAMING = 2;
    public static final int APPSTATE_ENABLED_POPUP = 4;
    public static final int LICENSE_STATE_ACTIVATED = 1;
    public static final int LICENSE_STATE_NOT_ACTIVATED = 2;
    public static final int LICENSE_STATE_NOT_LICENSED = 3;
    public static final int LICENSE_STATE_EXPIRED = 4;
    public static final int LICENSE_STATE_OFFERED = 5;
    public static final int LICENSE_STATE_LICENSE_ERROR = 6;
    public static final int LICENSE_STATE_LICENSE_REVOKED = 7;
    public static final int LICENSE_STATE_LICENSE_FREE = 8;
    public static final int LICENSETYPE_REGULAR = 0;
    public static final int LICENSETYPE_TRIAL = 1;
    public static final int LICENSETYPE_DEALER = 2;
    public static final int LICENCERESPONSE_ACTIVATED_OK = 0;
    public static final int LICENCERESPONSE_NETWORK_ERROR = 1;
    public static final int LICENCERESPONSE_INVALID = 2;
    public static final int LICENCERESPONSE_ERROR = 3;
    public static final int GENERICVERFICATION_OK = 0;
    public static final int GENERICVERFICATION_WRONG = 1;
    public static final int GENERICVERFICATION_CONNECTIVITY = 2;
    public static final int GENERICVERFICATION_ERROR = 3;
    public static final int GENERICVERFICATION_NOTAVAILABLE = 4;
    public static final int GENERICVERFICATION_AUTHSCHEME_NOT_SUPPORTED = 5;
    public static final int GENERICVERFICATION_TIMEOUT = 6;
    public static final int GENERICVERFICATION_CANCELED = 7;
    public static final int REMOVEUSERRESULT_OK = 0;
    public static final int REMOVEUSERRESULT_GENERICERROR = 1;
    public static final int OWNERVERIFICATION_OK = 0;
    public static final int OWNERVERIFICATION_WRONG = 1;
    public static final int OWNERVERIFICATION_CONNECTIVITY = 2;
    public static final int OWNERVERIFICATION_ERROR = 3;
    public static final int OWNERVERIFICATION_NOTAVAILABLE = 4;
    public static final int OWNERVERIFICATION_TIMEOUT = 6;
    public static final int OWNERVERIFICATION_CANCELED = 7;
    public static final int FILEDOWNLOAD_OK = 1;
    public static final int FILEDOWNLOAD_NOSERVICE = 2;
    public static final int FILEDOWNLOAD_SERVER = 3;
    public static final int FILEDOWNLOAD_NOTAFILE = 4;
    public static final int FILEDOWNLOAD_NOTWRITEABLE = 5;
    public static final int FILEDOWNLOAD_TIMEOUT = 6;
    public static final int FILEDOWNLOAD_IOERROR = 7;
    public static final int FILEDOWNLOAD_URLCORRUPT = 8;
    public static final int FILEDOWNLOAD_CANCELED = 9;
    public static final int FILEDOWNLOAD_CREATEFAILED = 10;
    public static final int FILEDOWNLOAD_GENERICERROR = 11;
    public static final int ERRORCODE_OK = 0;
    public static final int ERRORCODE_CORESERVICE_NOT_AVAILIBLE = 1;
    public static final int ERRORCODE_CORESERVICE_NOT_AVAILABLE = 1;
    public static final int ERRORCODE_CORESERVICE_CONFIGURATION = 2;
    public static final int ERRORCODE_CORESERVICE_SERVICE_NOT_ALLOWED = 3;
    public static final int ERRORCODE_CORESERVICE_SERVICELIST_URL_CORRUPT = 4;
    public static final int ERRORCODE_HTTPSERVICE_NOT_AVAILIBLE = 5;
    public static final int ERRORCODE_HTTPSERVICE_NOT_AVAILABLE = 5;
    public static final int ERRORCODE_CONNECTIVITY_ERROR = 6;
    public static final int ERRORCODE_AUTH_CONFIGURATION_ERROR = 7;
    public static final int ERRORCODE_AUTHMETHOD_NOT_IMPLEMENTED = 8;
    public static final int ERRORCODE_CREDENTIALS_NOT_AVAILIBLE = 9;
    public static final int ERRORCODE_CREDENTIALS_NOT_AVAILABLE = 9;
    public static final int ERRORCODE_AUTH_INTERNAL_ERROR = 10;
    public static final int ERRORCODE_AUTH_BACKEND_ERROR = 11;
    public static final int ERRORCODE_TRANSFER_CANCELED = 12;
    public static final int ERRORCODE_BACKEND_NOT_AVAILIBLE = 13;
    public static final int ERRORCODE_BACKEND_NOT_AVAILABLE = 13;
    public static final int ERRORCODE_BACKEND_PROBLEM = 14;
    public static final int ERRORCODE_BACKEND_PROBLEM_SERVICELIST_INVALID = 15;
    public static final int ERRORCODE_COULDNOTREGISTER = 16;
    public static final int ERRORCODE_COULDNOTGETSERVICELIST = 17;
    public static final int ERRORCODE_CORESERVICE_SERVICELIST_URL_MISSING = 18;
    public static final int ERRORCODE_PAIRING_CODE_INVALID = 19;
    public static final int ERRORCODE_PAIRING_NO_ACCOUNT = 20;
    public static final int ERRORCODE_COMPONENT_PROTECTION = 21;
    public static final int ERRORCODE_URL_INVALID = 22;
    public static final int ERRORCODE_AUTH_INCOMPLETE = 23;
    public static final int ERRORCODE_ONLINESERVICE_DISABLED = 24;
    public static final int ERRORCODE_NOT_INITALIZED_YET = 25;
    public static final int ERRORCODE_INVALID_AUTHSCHEME = 26;
    public static final int ERRORCODE_DIAGNOSE_NOT_AVAILABLE = 27;
    public static final int ERRORCODE_APPLICATION_NOT_AVAILABLE = 28;
    public static final int ERRORCODE_GENERIC_ERROR = 29;
    public static final int ERRORCODE_INVALID_USER = 30;
    public static final int ERRORCODE_PRIMARY_USER_REQUIRED = 31;
    public static final int ERRORCODE_ESIM_NODATAVOLUME = 32;
    public static final int ERRORCODE_COULDNOTRETRIEVEOAUTHTOKEN = 33;
    public static final int ERRORCODE_OAUTHSERVERNOTAVAILABLE = 34;
    public static final int ERRORCODE_SERVICEID_DISABLED = 35;
    public static final int ERRORCODE_SPIN_WRONG = 36;
    public static final int ERRORCODE_SPIN_LOCKED = 37;
    public static final int REASONPRIO_SERVICE_CONFIGURATION = 1;
    public static final int REASONPRIO_CONNECTION_STATE = 2;
    public static final int REASONPRIO_LICENSE_STATE = 3;
    public static final int REASONPRIO_UNKNOWNSERVICE = 4;
    public static final int REASONPRIO_BACKEND = 5;
    public static final int REASONUNKNOWNSERVICE_NOSERVICE = 1;
    public static final int REASONCONFIG_DISABLE = 1;
    public static final int REASONCONFIG_ROAMING = 2;
    public static final int REASONCONFIG_ONDEMAND = 3;
    public static final int REASONCONFIG_PRIVACY = 4;
    public static final int REASONCONFIG_SERVICEID_DISABLED = 5;
    public static final int REASONCONNECTIVITY_UNKNOWN = 1;
    public static final int REASONCONNECTIVITY_BLOCKED = 2;
    public static final int REASONCONNECTIVITY_ESIMLICENSENOTVALID = 3;
    public static final int REASONCONNECTIVITY_NODATAVOLUME = 4;
    public static final int REASONLICENSE_ACTIVATE = 1;
    public static final int REASONLICENSE_EXPIRED = 2;
    public static final int REASONLICENSE_NOTLICENSED = 3;
    public static final int REASONOWNERVERIFICATION_NOVERIFICATION = 1;
    public static final int USERTYPE_UNKNOWN = 0;
    public static final int USERTYPE_MAINUSER = 1;
    public static final int USERTYPE_SECONDARYUSER = 2;
    public static final int SERVICESTATE_CONNECTIVITY_BIT = 0;
    public static final int SERVICESTATE_SERVICELIST_OFFLINE_BIT = 1;
    public static final int SERVICESTATE_SERVICELIST_ONLINE_BIT = 2;
    public static final int SERVICESTATE_SERVICELIST_PENDING_BIT = 4;
    public static final int SERVICESTATE_DEVICESEARCH_PENDING = 5;
    public static final int SERVICESTATE_DEVICESEARCH_FOUNDDEVICES = 6;
    public static final int SERVICESTATE_GPSSERVICESACTIVE = 7;
    public static final int SERVICESTATE_OWNERVERIFICATION_OK = 8;
    public static final int SERVICESTATE_GPSPOPUPVALID = 9;
    public static final int SERVICESTATE_GPSPOPUPALLOWED = 10;
    public static final int SERVICESTATE_WAITING_GPSPOPUP = 11;
    public static final int SERVICESTATE_WAITING_INVENTORY = 12;
    public static final int SERVICESTATE_OWNERVERIFICATION_AVAILABLE = 16;
    public static final int PRIVACY_NONANONYMOUS_LOCATIONTRACKING = 0;
    public static final int PRIVACY_PSEUDONYMOUS_LOCATIONTRACKING = 1;
    public static final int PRIVACY_ANONYMOUS_LOCATIONTRACKING = 2;
    public static final int PRIVACY_PERSONALIZED_USERDATA = 3;
    public static final int PRIVACY_PERSONALIZED_VEHICLEDATA = 4;
    public static final int PRIVACY_FULL = 5;
    public static final int APN_NOTALLOWED = 0;
    public static final int APN_VENDOR = 1;
    public static final int APN_CUSTOMER = 2;
    public static final int REASONBACKEND_TERMS_AND_CONDITIONS_NOT_ACCEPTED = 0;
    public static final int REASONBACKEND_PRIMARY_USER_NOT_VERIFIED = 1;
    public static final int REASONBACKEND_NO_ACTIVE_LICENSE = 2;
    public static final int REASONBACKEND_INITIALLY_DISABLED = 3;
    public static final int REASONBACKEND_NOT_CONFIGURED = 4;
    public static final int REASONBACKEND_SWITCHED_OFF = 5;
    public static final int REASONBACKEND_DEACTIVATED = 6;
    public static final int SERVICETYPE_MBBINTERNAL = 1;
    public static final int SERVICETYPE_MBBESSENTIAL = 2;
    public static final int SERVICETYPE_WEBAPP = 3;
    public static final int SERVICETYPE_EXTERN = 4;
    public static final int SERVICETYPE_APP = 5;
    public static final int SERVICETYPE_VEHICLEONLY = 6;
    public static final int SERVICETYPE_MBB = 7;
    public static final int QOS_HIGH = 0;
    public static final int QOS_MED = 1;
    public static final int QOS_LOW = 2;
    public static final int AUTHLEVEL_T0X = 0;
    public static final int AUTHLEVEL_T1X = 1;
    public static final int AUTHLEVEL_T2X = 2;
    public static final int GPSUSEMODE_ACCEPT = 0;
    public static final int GPSUSEMODE_DECLINE = 1;
    public static final int GPSUSEMODE_NEVER = 2;
    public static final int RT_GETONLINEAPPLICATIONLIST = 1001;
    public static final int RT_GETONLINEAPPLICATION = 1002;
    public static final int RT_SETDEMANDSTATE = 1003;
    public static final int RT_SETONLINEAPPLICATIONSTATE = 1004;
    public static final int RT_ACTIVATELICENSE = 1005;
    public static final int RT_SETAPPLICATIONPROPERTIES = 1006;
    public static final int RT_SETCREDENTIAL = 1009;
    public static final int RT_VALIDATEOWNER = 1011;
    public static final int RT_CHECKOWNERSVERIFICATION = 1012;
    public static final int RT_PERFORMPORTALREGISTRATION = 1014;
    public static final int RT_RESETTOFACTORYSETTINGS = 1016;
    public static final int RT_DOWNLOAD = 1017;
    public static final int RT_CREATEUSERWITHUSERPASSWORD = 1018;
    public static final int RT_CHECKPASSWORD = 1019;
    public static final int RT_CHECKPAIRINGCODE = 1020;
    public static final int RT_SETPRIVACYFLAGS = 1021;
    public static final int RT_SETAUTOLOGIN = 1022;
    public static final int RT_LOGIN = 1023;
    public static final int RT_LOGOUT = 1024;
    public static final int RT_LOGOUTAUTHSCHEME = 1025;
    public static final int RT_GETUSERS = 1026;
    public static final int RT_REMOVEUSER = 1027;
    public static final int RT_CREATEUSERWITHPAIRINGCODE = 1028;
    public static final int RT_GETLICENSE = 1030;
    public static final int RT_GETLICENSES = 1031;
    public static final int RT_GETPROFILEFOLDER = 1032;
    public static final int RT_ADDORUPDATEAPPLICATIONPROPERTY = 1033;
    public static final int RT_GETCREDENTIALSFROMHEADER = 1034;
    public static final int RT_GETSERVICEURL = 1035;
    public static final int RT_GETCREDENTIALSFROMAUTHSCHEME = 1036;
    public static final int RT_SETLANGUAGE = 1037;
    public static final int RT_PRECHECKONLINESERVICE = 1038;
    public static final int RT_PRECHECKONLINESERVICESYMBOLICNAME = 1039;
    public static final int RT_PRECHECKONLINESERVICESERVICEID = 1040;
    public static final int RT_VALIDATEOWNERFORCE = 1041;
    public static final int RT_SETSERVICESTATE = 1042;
    public static final int RT_SETSERVICESTATESYMBOLICNAME = 1043;
    public static final int RT_SETACTIVEPRIVACYCATEGORYMASK = 1044;
    public static final int RT_SUBMITSERVICESTATECHANGESTOBACKEND = 1045;
    public static final int RT_PROFILECHANGE = 1046;
    public static final int RT_PROFILECOPY = 1047;
    public static final int RT_PROFILERESET = 1048;
    public static final int RT_PROFILERESETALL = 1049;
    public static final int RT_SETDEMANDSTATESERVICEID = 1050;
    public static final int RT_SETGPSUSEMODE = 1051;
    public static final int RT_SETINVENTORYFINISHED = 1052;
    public static final int RT_DOWNLOADRAW = 1053;
    public static final int RT_SETSPIN = 1054;
    public static final int RT_GETSPINHASH = 1055;
    public static final int RP_GETONLINEAPPLICATIONLISTRESPONSE = 2001;
    public static final int RP_GETONLINEAPPLICATIONRESPONSE = 2002;
    public static final int RP_ACTIVATELICENSERESPONSE = 2003;
    public static final int RP_SETCREDENTIALRESPONSE = 2006;
    public static final int RP_RESETTOFACTORYSETTINGSRESPONSE = 2008;
    public static final int RP_DOWNLOADRESPONSE = 2009;
    public static final int RP_VALIDATEOWNERRESPONSE = 2010;
    public static final int RP_CHECKOWNERSVERIFICATIONRESPONSE = 2011;
    public static final int RP_PERFORMPORTALREGISTRATIONRESPONSE = 2013;
    public static final int RP_CREATEUSERWITHPAIRINGCODERESPONSE = 2014;
    public static final int RP_CREATEUSERWITHUSERPASSWORDRESPONSE = 2015;
    public static final int RP_CHECKPASSWORDRESPONSE = 2016;
    public static final int RP_CHECKPAIRINGCODERESPONSE = 2017;
    public static final int RP_SETPRIVACYFLAGSRESPONSE = 2018;
    public static final int RP_SETAUTOLOGINRESPONSE = 2019;
    public static final int RP_LOGINRESPONSE = 2020;
    public static final int RP_LOGOUTRESPONSE = 2021;
    public static final int RP_LOGOUTAUTHSCHEMERESULT = 2022;
    public static final int RP_GETUSERSRESPONSE = 2023;
    public static final int RP_REMOVEUSERRESPONSE = 2024;
    public static final int RP_GETLICENSERESPONSE = 2026;
    public static final int RP_GETLICENSESRESPONSE = 2027;
    public static final int RP_GETPROFILEFOLDERRESPONSE = 2028;
    public static final int RP_GETCREDENTIALSFROMHEADERRESPONSE = 2029;
    public static final int RP_GETCREDENTIALSFROMAUTHSCHEMERESPONSE = 2030;
    public static final int RP_GETSERVICEURLRESPONSE = 2031;
    public static final int RP_PRECHECKONLINESERVICERESPONSE = 2032;
    public static final int RP_PRECHECKONLINESERVICESYMBOLICNAMERESPONSE = 2033;
    public static final int RP_PRECHECKONLINESERVICESERVICEIDRESPONSE = 2034;
    public static final int RP_SETSERVICESTATERESPONSE = 2035;
    public static final int RP_SETSERVICESTATESYMBOLICNAMERESPONSE = 2036;
    public static final int RP_SETACTIVEPRIVACYCATEGORYMASKRESPONSE = 2037;
    public static final int RP_SUBMITSERVICESTATECHANGESTOBACKENDRESPONSE = 2038;
    public static final int RP_PROFILECHANGED = 2039;
    public static final int RP_PROFILECOPIED = 2040;
    public static final int RP_PROFILERESET = 2041;
    public static final int RP_PROFILERESETALL = 2042;
    public static final int RP_SETDEMANDSTATESERVICEIDRESPONSE = 2043;
    public static final int RP_SETGPSUSEMODERESPONSE = 2044;
    public static final int RP_SETINVENTORYFINISHEDRESPONSE = 2045;
    public static final int RP_DOWNLOADRAWRESPONSE = 2046;
    public static final int RP_SETSPINRESPONSE = 2047;
    public static final int RP_GETSPINHASHRESULT = 2048;
    public static final int ATTR_APPLICATIONSTATE = 1;
    public static final int ATTR_DEVICEENUMERATOR = 3;
    public static final int ATTR_EXTERNALPROFILEINFO = 4;
    public static final int ATTR_COREPROFILEINFO = 5;
    public static final int ATTR_SERVICESTATE = 6;
    public static final int ATTR_SERVICELIST = 7;
    public static final int ATTR_PROFILESTATE = 8;
    public static final int ATTR_SERVICES = 9;
    public static final int ATTR_SERVICEREGISTRATION = 10;
    public static final int ATTR_SPINREQUIRED = 11;

    public void getOnlineApplicationList();

    public void getOnlineApplication(String var1);

    public void setOnlineApplicationState(String var1, int var2);

    public void activateLicense(OSRLicense var1);

    public void setDemandState(String var1, boolean var2);

    public void setDemandStateServiceID(String var1, boolean var2);

    public void setApplicationProperties(String var1, OSRApplicationProperties[] var2);

    public void addOrUpdateApplicationProperty(String var1, OSRApplicationProperties var2);

    public void setCredential(String var1, String var2, String var3);

    public void download(String var1, String var2, String var3, long var4, long var6);

    public void downloadRaw(String var1, String var2, String var3, long var4, long var6);

    public void validateOwner(String var1);

    public void validateOwnerForce(boolean var1);

    public void checkOwnersVerification();

    public void createUserWithPairingCode(String var1, String var2);

    public void createUserWithUserPassword(String var1, String var2, String var3);

    public void checkPassword(OSRUser var1, String var2, boolean var3);

    public void checkPairingCode(OSRUser var1, String var2, boolean var3);

    public void setPrivacyFlags(OSRUser var1, int var2);

    public void setAutoLogin(OSRUser var1, OSRDevice[] var2);

    public void login(OSRUser var1);

    public void logout(OSRUser var1);

    public void logoutAuthScheme(String var1);

    public void getUsers(String var1);

    public void removeUser(OSRUser var1);

    public void performPortalRegistration(String var1);

    public void getLicense(String var1);

    public void getLicenses(boolean var1, boolean var2);

    public void precheckOnlineServiceServiceID(String var1, String var2);

    public void precheckOnlineServiceSymbolicName(String var1, String var2);

    public void precheckOnlineService(String var1);

    public void getProfileFolder(OSRUser var1, String var2);

    public void getCredentialsFromHeader(int var1, String[] var2);

    public void getCredentialsFromAuthScheme(int var1);

    public void getServiceURL(String var1);

    public void resetToFactorySettings(String var1);

    public void setLanguage(String var1);

    public void setServiceState(String var1, int var2);

    public void setServiceStateSymbolicName(String var1, int var2);

    public void setActivePrivacyCategoryMask(int var1);

    public void submitServiceStateChangesToBackend();

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();

    public void setGPSUseMode(int var1);

    public void setInventoryFinished(boolean var1);

    public void setSPIN(String var1, String var2, String var3);

    public void getSPINHash(String var1, String var2, int var3, String var4);
}

