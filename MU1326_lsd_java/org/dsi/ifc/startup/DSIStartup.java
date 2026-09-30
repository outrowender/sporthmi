/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.startup;

import org.dsi.ifc.base.DSIBase;

public interface DSIStartup
extends DSIBase {
    public static final String VERSION = "2.11.16";
    public static final int ATTR_DOMAINSTATUSROOT = 1;
    public static final int ATTR_DOMAINSTATUSTUNER = 2;
    public static final int ATTR_DOMAINSTATUSMEDIA = 3;
    public static final int ATTR_DOMAINSTATUSADDRESSBOOK = 4;
    public static final int ATTR_DOMAINSTATUSPHONE = 5;
    public static final int ATTR_DOMAINSTATUSNAV = 6;
    public static final int ATTR_DOMAINSTATUSINFO = 7;
    public static final int ATTR_DOMAINSTATUSCAR = 8;
    public static final int ATTR_DOMAINSTATUSAUDIO = 9;
    public static final int ATTR_DOMAINSTATUSSDS = 10;
    public static final int ATTR_DOMAINSTATUSSWDL = 11;
    public static final int ATTR_DOMAINSTATUSEARLYAPPS = 12;
    public static final int ATTR_DOMAINSTATUSPOSTSTARTUP = 13;
    public static final int ATTR_DOMAINSTATUSCOMMUNICATION = 14;
    public static final int ATTR_DOMAINSTATUSIPSERVICES = 15;
    public static final int ATTR_DOMAINSTATUSGEMMI = 16;
    public static final int ATTR_DOMAINSTATUSBAPKOMBI = 17;
    public static final int ATTR_DOMAINSTATUSBLUETOOTH = 18;
    public static final int ATTR_DOMAINSTATUSBROWSER = 19;
    public static final int ATTR_DOMAINSTATUSEXPLORER = 20;
    public static final int ATTR_DOMAINSTATUSCALENDAR = 21;
    public static final int ATTR_DOMAINSTATUSPICTURESTORE = 22;
    public static final int ATTR_DOMAINSTATUSSTREETVIEW = 23;
    public static final int ATTR_DOMAINSTATUSMOBILITYHORIZON = 24;
    public static final int ATTR_DOMAINSTATUSEXBOXM = 25;
    public static final int ATTR_DOMAINSTATUSMIRRORLINK = 26;
    public static final int ATTR_DOMAINSTATUSSFA = 27;
    public static final int ATTR_DOMAINSTATUSSEARCH = 28;
    public static final int ATTR_DOMAINSTATUSDIAGNOSIS = 29;
    public static final int ATTR_DOMAINSTATUSASIALANGUAGESUPPORT = 30;
    public static final int ATTR_DOMAINSTATUSEXLAP = 31;
    public static final int ATTR_DOMAINSTATUSTVTUNER = 32;
    public static final int ATTR_DOMAINSTATUSMEDIAONLINE = 33;
    public static final int ATTR_DOMAINSTATUSMEDIAROUTER = 34;
    public static final int ATTR_DOMAINSTATUSRADIODATASERVER = 35;
    public static final int ATTR_DOMAINSTATUSSMARTPHONEINTEGRATION = 36;
    public static final int ATTR_DOMAINSTATUSWIRELESSCHARGER = 37;
    public static final int RT_STARTDOMAIN = 1000;
    public static final int RT_HMICOMPLETELYSTARTED = 1001;
    public static final int RP_STARTDOMAIN = 2000;
    public static final int DOMAINID_STARTUP_DOMAIN_UNKNOWN = 0;
    public static final int DOMAINID_STARTUP_DOMAIN_ROOT = 1;
    public static final int DOMAINID_STARTUP_DOMAIN_TUNER = 2;
    public static final int DOMAINID_STARTUP_DOMAIN_MEDIA = 3;
    public static final int DOMAINID_STARTUP_DOMAIN_ADDRESSBOOK = 4;
    public static final int DOMAINID_STARTUP_DOMAIN_PHONE = 5;
    public static final int DOMAINID_STARTUP_DOMAIN_NAV = 6;
    public static final int DOMAINID_STARTUP_DOMAIN_INFO = 7;
    public static final int DOMAINID_STARTUP_DOMAIN_CAR = 8;
    public static final int DOMAINID_STARTUP_DOMAIN_AUDIO = 9;
    public static final int DOMAINID_STARTUP_DOMAIN_SDS = 10;
    public static final int DOMAINID_STARTUP_DOMAIN_SWDL = 11;
    public static final int DOMAINID_STARTUP_DOMAIN_EARLY_APPS = 12;
    public static final int DOMAINID_STARTUP_DOMAIN_POST = 13;
    public static final int DOMAINID_STARTUP_DOMAIN_COMMUNICATION = 14;
    public static final int DOMAINID_STARTUP_DOMAIN_IPSERVICES = 16;
    public static final int DOMAINID_STARTUP_DOMAIN_GEMMI = 17;
    public static final int DOMAINID_STARTUP_DOMAIN_BAPKOMBI = 18;
    public static final int DOMAINID_STARTUP_DOMAIN_BLUETOOTH = 19;
    public static final int DOMAINID_STARTUP_DOMAIN_BROWSER = 20;
    public static final int DOMAINID_STARTUP_DOMAIN_EXPLORER = 21;
    public static final int DOMAINID_STARTUP_DOMAIN_CALENDAR = 22;
    public static final int DOMAINID_STARTUP_DOMAIN_PICTURESTORE = 23;
    public static final int DOMAINID_STARTUP_DOMAIN_STREETVIEW = 24;
    public static final int DOMAINID_STARTUP_DOMAIN_MOBILITYHORIZON = 25;
    public static final int DOMAINID_STARTUP_DOMAIN_EXBOXM = 26;
    public static final int DOMAINID_STARTUP_DOMAIN_MIRRORLINK = 27;
    public static final int DOMAINID_STARTUP_DOMAIN_SFA = 28;
    public static final int DOMAINID_STARTUP_DOMAIN_SEARCH = 29;
    public static final int DOMAINID_STARTUP_DOMAIN_DIAGNOSIS = 30;
    public static final int DOMAINID_STARTUP_DOMAIN_ASIA_LANGUAGE_SUPPORT = 31;
    public static final int DOMAINID_STARTUP_DOMAIN_EXLAP = 32;
    public static final int DOMAINID_STARTUP_DOMAIN_TVTUNER = 33;
    public static final int DOMAINID_STARTUP_DOMAIN_MEDIA_ONLINE = 34;
    public static final int DOMAINID_STARTUP_DOMAIN_MEDIA_ROUTER = 35;
    public static final int DOMAINID_STARTUP_DOMAIN_RADIODATA_SERVER = 36;
    public static final int DOMAINID_STARTUP_DOMAIN_SMARTPHONE_INTEGRATION = 37;
    public static final int DOMAINID_STARTUP_DOMAIN_WIRELESS_CHARGER = 38;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_NOT_INIT = 0;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_NOT_STARTED = 1;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_AUDIBLE = 2;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_OPERABLE = 4;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_FULLY_OPERABLE = 8;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_ERROR = 16;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_ERROR_INDICATION_UNRECOVERABLE = 32;
    public static final int DOMAINSTATE_STARTUP_DOMAIN_STATE_ERROR_INDICATION_NOT_AVAILABLE = 64;

    public void startDomain(int var1, int var2);

    public void hmiCompletelyStarted();
}

