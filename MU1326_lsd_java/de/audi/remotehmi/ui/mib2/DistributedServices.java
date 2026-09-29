/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.ui.mib2;

import de.audi.remotehmi.RemoteHMIGuideIcon;

public class DistributedServices {
    public static final String POI_ONLINE;
    public static final String DEST_IMPORT;
    public static final String MAP_GOOGLE_EARTH;
    public static final String MAP_TRAFFIC;
    public static final String ONLINE_MEDIA;
    public static final String RHMI_LOGIN;
    public static final String SPECIAL_DEST;
    public static final String PIC_NAV;
    public static final String WLAN;
    public static final String NAV_UPDATE;
    public static final String SMSDictation;
    public static final String EMAILDictation;
    public static final String WIFIMediaPlayer;
    public static final String LOCK;
    public static final String RHMI_CONNECTIVITY_SETTINGS;
    public static final String RHMI_LICENSING;
    public static final String MAP_STREETVIEW;
    public static final String PHONE_MESSAGING;
    public static final String NAVIGATION_FAV;
    public static final String RHMI_PRIVACY;
    public static final String RHMI_LICENSE_PREFIX;
    public static final String RHMI_LICENSE_EXPIRED;
    public static final String RHMI_TEASER_EXPIRED;
    public static final String RHMI_NOT_LICENSED;
    public static final String RHMI_NOT_ACTIVATED;
    public static final String RHMI_OFFERED;
    public static final String RHMI_REVOKED;
    public static final String RHMI_LICENSE_ERROR;
    public static final String RHMI_MAIN_WIZARD;
    public static final String RHMI_STEPUP_SCREEN;
    public static final String RHMI_USER_SETTINGS;
    public static final String RHMI_USER_SETTINGS_OPTION;
    public static final String RHMI_ALERT_SERVICES;
    public static final String RHMI_CARFINDER;
    public static final String RHMI_TRAFFICLIGHT;
    public static final String RHMI_MOBILE_KEY;
    public static final int LICENSE_STATE_NOT_ACTIVATED;
    public static final int LICENSE_STATE_NOT_LICENSED;
    public static final int LICENSE_STATE_EXPIRED;
    public static final int LICENSE_STATE_OFFERED;
    public static final int LICENSE_STATE_LICENSE_ERROR;
    public static final int LICENSE_STATE_LICENSE_REVOKED;
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

