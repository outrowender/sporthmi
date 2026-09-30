/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app;

import de.audi.atip.hmi.HMIService;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.tghu.online.app.remotehmi.AbstractCommandHandler;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMIComponent;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.IDistributedServiceCallListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractDistributedServiceComponent
extends AbstractRemoteHMIComponent {
    public static final int SERVICE_POIONLINE = 0;
    public static final int SERVICE_DESTIMPORT = 1;
    public static final int SERVICE_GOOGLE = 2;
    public static final int SERVICE_MEDIA = 3;
    public static final int SERVICE_SPECIAL = 4;
    public static final int SERVICE_PICNAV = 5;
    public static final int SERVICE_WLAN = 6;
    public static final int SERVICE_UPDATE = 7;
    public static final int SERVICE_SMS = 8;
    public static final int SERVICE_STREET = 9;
    public static final int SERVICE_TRAFFIC = 10;
    public static final int SERVICE_MAIN_WIZARD = 11;
    public static final int SERVICE_EMAIL = 12;
    public static final int SERVICE_WIFIPLAYER = 13;
    public static final int SERVICE_LOGIN = 21;
    public static final int SERVICE_USERSETTINGS = 22;
    public static final int SERVICE_ALERT_SERVICES = 23;
    public static final int SERVICE_TRAFFFICLIGHT = 24;
    public static final int WLAN_SLOT = 0;
    protected List listeners = new ArrayList(0);
    protected String appContext;
    protected HMIService hmiService;

    public void init(LogChannel logChannel, RemoteHMIService remoteHMIService) {
        super.init(logChannel, remoteHMIService);
        this.hmiService = this.getFrameworkAccess().getHMIService();
        this.remoteHmiService.addCommandHandler(0x9898D9, new AbstractCommandHandler("hmi-fct-call"){

            public void indicateCommand(int n, Object object) {
                String string = AbstractDistributedServiceComponent.this.extractDestination(object);
                boolean bl = AbstractDistributedServiceComponent.this.informListeners(string);
                AbstractDistributedServiceComponent.this.logChannel.log(1000000, "DistributedServiceComponent#indicateCommand handling Destination %1, handled = %2", (Object)string, (Object)Boolean.toString(bl));
                if (!bl) {
                    AbstractDistributedServiceComponent.this.initiateHMIJump(string);
                }
            }
        });
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

    protected abstract void initiateHMIJump(String var1);

    protected abstract boolean handleSDSJump(int var1, String var2);

    protected abstract void disableLineNumbers(HMIService var1);

    protected abstract void setLicenseDetailScreen(int var1);

    public abstract int getCurrentSelectedDistributedService();
}

