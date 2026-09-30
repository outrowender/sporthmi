/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.RemoteHMIGuideIcon;

public class DistributedServices {
    public static final String POI_ONLINE = "poi_service";
    public static final String DEST_IMPORT = "myAudi_service";
    public static final String MAP_GOOGLE_EARTH = "google_service";
    public static final String MAP_TRAFFIC = "traffic_service";
    public static final String ONLINE_MEDIA = "media";
    public static final String RHMI_LOGIN = "login_service";
    public static final String SPECIAL_DEST = "specialDest_service";
    public static final String PIC_NAV = "picNav_service";
    public static final String WLAN = "wlan_service";
    public static final String NAV_UPDATE = "update_service";
    public static final String SMSDictation = "sms_service";
    public static final String EMAILDictation = "email_service";
    public static final String WIFIMediaPlayer = "wifiMediaPlayer_service";
    public static final String LOCK = "lock_service";
    public static final String RHMI_CONNECTIVITY_SETTINGS = "connectivitySettings";
    public static final String RHMI_LICENSING = "licensingScreen";
    public static final String MAP_STREETVIEW = "streetview_service";
    public static final String PHONE_MESSAGING = "phone";
    public static final String NAVIGATION_FAV = "Nav_Location";
    public static final String RHMI_PRIVACY = "DataPrivacy";
    public static final String RHMI_LICENSE_PREFIX = "licenseExpired_";
    public static final String RHMI_LICENSE_EXPIRED = "licenseExpired_0";
    public static final String RHMI_TEASER_EXPIRED = "licenseExpired_1";
    public static final String RHMI_NOT_LICENSED = "licenseExpired_2";
    public static final String RHMI_NOT_ACTIVATED = "licenseExpired_3";
    public static final String RHMI_OFFERED = "licenseExpired_4";
    public static final String RHMI_REVOKED = "licenseExpired_4";
    public static final String RHMI_LICENSE_ERROR = "licenseExpired_5";
    public static final String RHMI_MAIN_WIZARD = "rhmiMainWizard";
    public static final String RHMI_STEPUP_SCREEN = "stepUp";
    public static final String RHMI_USER_SETTINGS = "userSettings_service";
    public static final String RHMI_USER_SETTINGS_OPTION = "userSettings_service_opt";
    public static final String RHMI_ALERT_SERVICES = "alert_service";
    public static final String RHMI_CARFINDER = "carfinder_v1";
    public static final String RHMI_TRAFFICLIGHT = "service_trafficlight";
    public static final String RHMI_MOBILE_KEY = "mobilekey_sales_v1";
    public static final int LICENSE_STATE_NOT_ACTIVATED = 2;
    public static final int LICENSE_STATE_NOT_LICENSED = 3;
    public static final int LICENSE_STATE_EXPIRED = 4;
    public static final int LICENSE_STATE_OFFERED = 5;
    public static final int LICENSE_STATE_LICENSE_ERROR = 6;
    public static final int LICENSE_STATE_LICENSE_REVOKED = 7;
    private String category;
    private final boolean offlineAvailable;
    private String textConstant;
    private String serviceID;
    private int sortOrder = -1;
    private String symbolicName;
    private RemoteHMIGuideIcon guideIconBadge;

    public DistributedServices(String string, String string2, String string3, int n, RemoteHMIGuideIcon remoteHMIGuideIcon, String string4, boolean bl) {
        this.serviceID = string;
        this.textConstant = string2;
        this.category = string3;
        this.sortOrder = n;
        this.guideIconBadge = remoteHMIGuideIcon;
        this.symbolicName = string4;
        this.offlineAvailable = bl;
    }

    public String getCategory() {
        return this.category;
    }

    public String getTextConstant() {
        return this.textConstant;
    }

    public String getServiceID() {
        return this.serviceID;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public RemoteHMIGuideIcon getGuideIconBadge() {
        return this.guideIconBadge;
    }

    public String getSymbolicName() {
        return this.symbolicName;
    }

    public boolean isOfflineAvailable() {
        return this.offlineAvailable;
    }
}

