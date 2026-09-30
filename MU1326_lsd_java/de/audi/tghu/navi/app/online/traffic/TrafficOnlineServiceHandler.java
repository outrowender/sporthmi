/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.online.traffic;

import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;

public class TrafficOnlineServiceHandler
implements IOnlineServiceListener {
    public static final String APP_ID_VZO_LGI_TRACKER = "ncfstracker";
    public static final String APP_ID_VZO_LGI_DOWNLOAD = "ncfsdownload";
    protected final LogChannel logChannel;
    private IOnlineService service;
    private String appID;
    private int state = 0;

    public TrafficOnlineServiceHandler(String string, LogChannel logChannel) {
        this.appID = string;
        this.logChannel = logChannel;
    }

    public void setService(IOnlineService iOnlineService, int n) {
        this.logChannel.log(10000000, "TrafficOnlineServiceHandler[%1]#setService %2", (Object)this.appID, (Object)iOnlineService);
        this.service = iOnlineService;
        if (iOnlineService != null) {
            try {
                iOnlineService.addCallBackListener(this);
                this.setState(n);
            }
            catch (Exception exception) {
                this.logChannel.log(10000000, "TrafficOnlineServiceHandler[%1]#setService ERROR=%2", (Object)this.appID, (Throwable)exception);
            }
        }
    }

    public void setState(int n) {
        this.logChannel.log(10000000, "TrafficOnlineServiceHandler[%1]#setState %2", (Object)this.appID, (long)n);
        if (this.service != null) {
            try {
                this.service.setOnlineApplicationState(n, this);
                this.state = n;
            }
            catch (Exception exception) {
                this.logChannel.log(10000000, "TrafficOnlineServiceHandler[%1]#setState ERROR=%2", (Object)this.appID, (Throwable)exception);
            }
        } else {
            this.logChannel.log(10000000, "TrafficOnlineServiceHandler[%1]#setState no service availble", (Object)this.appID);
        }
    }

    public int getState() {
        return this.state;
    }

    public String getAppID() {
        return this.appID;
    }

    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.logChannel.log(100000000, "TrafficOnlineServiceHandler[%1]#getOnlineApplicationResponse %2", (Object)this.appID, (long)oSRApplication.getState());
    }

    public void activateLicenseResponse(int n) {
        this.logChannel.log(100000000, "TrafficOnlineServiceHandler[%1]#activateLicenseResponse %2", (Object)this.appID, (long)n);
    }

    public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
        this.logChannel.log(100000000, "TrafficOnlineServiceHandler[%1]#getLicenseInformationResult length: %2", (Object)this.appID, oSRLicenseArray != null ? (long)oSRLicenseArray.length : 0L);
    }

    public void getReminderStatusResult(int n) {
        this.logChannel.log(100000000, "TrafficOnlineServiceHandler[%1]#getReminderStatusResult %2", (Object)this.appID, (long)n);
    }

    public void setReminderStateResponse(int n) {
        this.logChannel.log(100000000, "TrafficOnlineServiceHandler[%1]#setReminderStateResponse %2", (Object)this.appID, (long)n);
    }

    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.logChannel.log(100000000, "TrafficOnlineServiceHandler[%1]#updateApplicationState length: %2", (Object)this.appID, oSRNotifyPropertiesArray != null ? (long)oSRNotifyPropertiesArray.length : 0L);
    }

    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }

    public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }
}

