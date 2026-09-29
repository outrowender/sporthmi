/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.util.EnumHelper;

public class RemoteHMIGuideIcon {
    private static final EnumHelper enumHelper = new EnumHelper();
    public static final RemoteHMIGuideIcon EMPTY = new RemoteHMIGuideIcon("EMPTY");
    public static final RemoteHMIGuideIcon TOP_WIZARD_BACKGROUND = new RemoteHMIGuideIcon("TOP_WIZARD_BACKGROUND");
    public static final RemoteHMIGuideIcon POI_ONLINE = new RemoteHMIGuideIcon("POI_ONLINE");
    public static final RemoteHMIGuideIcon DEST_IMPORT = new RemoteHMIGuideIcon("DEST_IMPORT");
    public static final RemoteHMIGuideIcon GOOGLE_EARTH = new RemoteHMIGuideIcon("GOOGLE_EARTH");
    public static final RemoteHMIGuideIcon SPECIAL_DEST = new RemoteHMIGuideIcon("SPECIAL_DEST");
    public static final RemoteHMIGuideIcon PIC_NAV = new RemoteHMIGuideIcon("PIC_NAV");
    public static final RemoteHMIGuideIcon WLAN = new RemoteHMIGuideIcon("WLAN");
    public static final RemoteHMIGuideIcon MAP_CARE = new RemoteHMIGuideIcon("MAP_CARE");
    public static final RemoteHMIGuideIcon ONLINE_TRAFFIC = new RemoteHMIGuideIcon("ONLINE_TRAFFIC");
    public static final RemoteHMIGuideIcon STREETVIEW = new RemoteHMIGuideIcon("STREETVIEW");
    public static final RemoteHMIGuideIcon SMS_DICTATION = new RemoteHMIGuideIcon("SMS_DICTATION");
    public static final RemoteHMIGuideIcon EMAIL_DICTATION = new RemoteHMIGuideIcon("EMAIL_DICTATION");
    public static final RemoteHMIGuideIcon WIFI_PLAYER = new RemoteHMIGuideIcon("WIFI_PLAYER");
    public static final RemoteHMIGuideIcon CARFINDER = new RemoteHMIGuideIcon("CARFINDER");
    public static final RemoteHMIGuideIcon ALERTSERVICES = new RemoteHMIGuideIcon("ALERT_SERVICES");
    public static final RemoteHMIGuideIcon REMOTE_LOCK_UNLOCK = new RemoteHMIGuideIcon("REMOTE_LOCK_UNLOCK");
    public static final RemoteHMIGuideIcon REMOTE_HEATER = new RemoteHMIGuideIcon("REMOTE_HEATER");
    public static final RemoteHMIGuideIcon RHMI_USER_SETTINGS = new RemoteHMIGuideIcon("RHMI_USER_SETTINGS");
    public static final RemoteHMIGuideIcon TRAFFICLIGHT = new RemoteHMIGuideIcon("TRAFFICLIGHT");
    public static final RemoteHMIGuideIcon MOBILE_KEY = new RemoteHMIGuideIcon("MOBILE_KEY");
    private final String name;

    private RemoteHMIGuideIcon(String string) {
        this.name = string;
        enumHelper.addInstance(string, this);
    }

    public String getName() {
        return this.name;
    }

    public final String toString() {
        return this.name;
    }

    public static RemoteHMIGuideIcon valueOf(String string) {
        return (RemoteHMIGuideIcon)enumHelper.valueOf(string);
    }
}

