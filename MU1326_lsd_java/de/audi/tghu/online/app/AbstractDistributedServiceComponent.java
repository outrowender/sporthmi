/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.tghu.online.app.AbstractDistributedServiceComponent$1;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.IDistributedServiceCallListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractDistributedServiceComponent
extends AbstractRemoteHMIComponent {
    public static final int SERVICE_POIONLINE;
    public static final int SERVICE_DESTIMPORT;
    public static final int SERVICE_GOOGLE;
    public static final int SERVICE_MEDIA;
    public static final int SERVICE_SPECIAL;
    public static final int SERVICE_PICNAV;
    public static final int SERVICE_WLAN;
    public static final int SERVICE_UPDATE;
    public static final int SERVICE_SMS;
    public static final int SERVICE_STREET;
    public static final int SERVICE_TRAFFIC;
    public static final int SERVICE_MAIN_WIZARD;
    public static final int SERVICE_EMAIL;
    public static final int SERVICE_WIFIPLAYER;
    public static final int SERVICE_LOGIN;
    public static final int SERVICE_USERSETTINGS;
    public static final int SERVICE_ALERT_SERVICES;
    public static final int SERVICE_TRAFFFICLIGHT;
    public static final int WLAN_SLOT;
    protected List listeners = new ArrayList(0);
    protected String appContext;
    protected HMIService hmiService;

    @Override
    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.hmiService = this.getFrameworkAccess().getHMIService();
        this.remoteHmiService.addCommandHandler(-644311040, new AbstractDistributedServiceComponent$1(this, "hmi-fct-call"));
    }

    public void addListener(IDistributedServiceCallListener iDistributedServiceCallListener) {
        this.listeners.add(iDistributedServiceCallListener);
    }

    private boolean informListeners(String string) {
        Iterator iterator = this.listeners.iterator();
        while (iterator.hasNext()) {
            if (!((IDistributedServiceCallListener)iterator.next()).informListener(string)) continue;
            return true;
        }
        return false;
    }

    private String extractDestination(Object object) {
        if (!(object instanceof HMIProperties)) {
            return null;
        }
        HMIProperties hMIProperties = (HMIProperties)object;
        String string = hMIProperties.getString("destination");
        return string;
    }

    public String getAppContext() {
        return this.appContext;
    }

    protected int mapServiceToModelValue(String string) {
        int n;
        if (string.equals("poi_service")) {
            n = 0;
        } else if (string.equals("myAudi_service")) {
            n = 1;
        } else if (string.equals("google_service")) {
            n = 2;
        } else if (string.equals("traffic_service")) {
            n = 10;
        } else if (string.equals("streetview_service")) {
            n = 9;
        } else if (string.startsWith("media")) {
            n = 3;
        } else if (string.equals("specialDest_service")) {
            n = 4;
        } else if (string.equals("picNav_service")) {
            n = 5;
        } else if (string.equals("update_service")) {
            n = 7;
        } else if (string.equals("sms_service")) {
            n = 8;
        } else if (string.equals("email_service")) {
            n = 12;
        } else if (string.equals("wifiMediaPlayer_service")) {
            n = 13;
        } else if (string.equals("streetview_service")) {
            n = 9;
        } else if (string.equals("traffic_service")) {
            n = 10;
        } else if (string.equals("login_service")) {
            n = 21;
        } else if (string.equals("userSettings_service")) {
            n = 22;
        } else if (string.equals("userSettings_service_opt")) {
            n = 22;
        } else if (string.equals("alert_service")) {
            n = 23;
        } else if (string.equals("service_trafficlight")) {
            n = 24;
        } else if (string.equals("licenseExpired_0")) {
            n = 0;
        } else if (string.equals("licenseExpired_1")) {
            n = 1;
        } else if (string.equals("licenseExpired_2")) {
            n = 2;
        } else if (string.equals("licenseExpired_5")) {
            n = 5;
        } else if (string.equals("licenseExpired_3")) {
            n = 3;
        } else if (string.equals("licenseExpired_4")) {
            n = 4;
        } else {
            return -1;
        }
        return n;
    }

    protected abstract void initiateHMIJump(String string) {
    }

    protected abstract boolean handleSDSJump(int n, String string) {
    }

    protected abstract void disableLineNumbers(HMIService hMIService) {
    }

    protected abstract void setLicenseDetailScreen(int n) {
    }

    public abstract int getCurrentSelectedDistributedService() {
    }

    static /* synthetic */ String access$000(AbstractDistributedServiceComponent abstractDistributedServiceComponent, Object object) {
        return abstractDistributedServiceComponent.extractDestination(object);
    }

    static /* synthetic */ boolean access$100(AbstractDistributedServiceComponent abstractDistributedServiceComponent, String string) {
        return abstractDistributedServiceComponent.informListeners(string);
    }

    static /* synthetic */ LogChannel access$200(AbstractDistributedServiceComponent abstractDistributedServiceComponent) {
        return abstractDistributedServiceComponent.logChannel;
    }
}

