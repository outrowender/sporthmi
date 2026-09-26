/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.osr.OnlineService$1;
import de.audi.tghu.online.app.osr.OnlineService$10;
import de.audi.tghu.online.app.osr.OnlineService$11;
import de.audi.tghu.online.app.osr.OnlineService$12;
import de.audi.tghu.online.app.osr.OnlineService$2;
import de.audi.tghu.online.app.osr.OnlineService$3;
import de.audi.tghu.online.app.osr.OnlineService$4;
import de.audi.tghu.online.app.osr.OnlineService$5;
import de.audi.tghu.online.app.osr.OnlineService$6;
import de.audi.tghu.online.app.osr.OnlineService$7;
import de.audi.tghu.online.app.osr.OnlineService$8;
import de.audi.tghu.online.app.osr.OnlineService$9;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationHelper;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationSubsystem;
import de.audi.tghu.online.app.osr.command.OSRActivateLicenseCommand;
import de.audi.tghu.online.app.osr.command.OSRCommandList;
import de.audi.tghu.online.app.osr.command.OSRGetOnlineApplicationCommand;
import de.audi.tghu.online.app.osr.command.OSRPOnlineApplicationPreCheck;
import de.audi.tghu.online.app.osr.command.OSRSetApplicationPropertiesCommand;
import de.audi.tghu.online.app.osr.command.OSRSetOnlineApplicationStateCommand;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRApplicationProperties;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;
import org.osgi.framework.ServiceRegistration;

public class OnlineService
implements IOnlineService {
    private String applicationId;
    private final OnlineServiceRegistrationSubsystem system;
    private LogChannel logChannel;
    private ServiceRegistration serviceRegistration = null;
    private OSRApplication onlineApplication = null;
    private OSRNotifyProperties properties = null;
    private List serviceCallbacks = null;
    private int onlineApplicationState = 0;
    private boolean roamingActive;

    public OnlineService(String string, OnlineServiceRegistrationSubsystem onlineServiceRegistrationSubsystem) {
        this.applicationId = string;
        this.system = onlineServiceRegistrationSubsystem;
        this.logChannel = onlineServiceRegistrationSubsystem.getLogChannel();
        this.serviceCallbacks = new LinkedList();
    }

    @Override
    public void setOnlineApplicationState(int n, IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(-2137614336, "[OnlineService#setOnlineApplicationState] application:%1 state:%2 ", (Object)this.applicationId, (long)n);
        this.onlineApplicationState = n;
        int n2 = n == 1 ? 3 : 0;
        this.logChannel.log(-2137614336, "[OnlineService#setOnlineApplicationState] application:%1 stateWithRoaming:%2 ", (Object)this.applicationId, (long)n2);
        OSRCommandList oSRCommandList = this.system.createCommandList(1);
        oSRCommandList.add(new OSRSetOnlineApplicationStateCommand(this.applicationId, n2, iOnlineServiceListener));
        oSRCommandList.execute("ORSMediator#setOnlineApplicationState");
    }

    private int determineRoamingState(int n) {
        if (!this.roamingActive) {
            return n;
        }
        return n | 2;
    }

    @Override
    public void activateLicense(IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(-2137614336, "[OnlineService#activateLicense] application:%1", (Object)this.applicationId);
        OSRCommandList oSRCommandList = this.system.createCommandList();
        oSRCommandList.setErrorCommand(new OnlineService$1(this, "ErrorCommand", iOnlineServiceListener));
        OSRLicense[] oSRLicenseArray = this.onlineApplication.getLicenseList();
        if (oSRLicenseArray != null) {
            for (int i2 = 0; i2 < oSRLicenseArray.length; ++i2) {
                OSRLicense oSRLicense = oSRLicenseArray[i2];
                if (oSRLicense.getState() != 2) continue;
                this.logChannel.log(-2137614336, "[OnlineService#activateLicense] found activatable license with id: %1", (Object)oSRLicense.getId());
                OSRActivateLicenseCommand oSRActivateLicenseCommand = new OSRActivateLicenseCommand(this.applicationId, oSRLicense);
                oSRCommandList.add(oSRActivateLicenseCommand);
                oSRCommandList.add(new OnlineService$2(this, "TagCommand"));
                oSRCommandList.add(new OSRGetOnlineApplicationCommand(this.applicationId, iOnlineServiceListener));
                oSRCommandList.add(new OnlineService$3(this, "call callback", oSRActivateLicenseCommand, iOnlineServiceListener));
                break;
            }
        }
        oSRCommandList.execute("ORSMediator#activateLicense");
    }

    @Override
    public void setReminderState(int n, IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(-2137614336, "[OnlineService#setReminderState] application:%1 reminderStatus:%2", (Object)this.applicationId, (long)n);
        OSRCommandList oSRCommandList = this.system.createCommandList();
        oSRCommandList.setErrorCommand(new OnlineService$4(this, "ErrorCommand", iOnlineServiceListener));
        OSRApplicationProperties[] oSRApplicationPropertiesArray = OnlineServiceRegistrationHelper.changeReminderProperty(this.onlineApplication.getPropertyList(), n);
        OSRSetApplicationPropertiesCommand oSRSetApplicationPropertiesCommand = new OSRSetApplicationPropertiesCommand(this.applicationId, oSRApplicationPropertiesArray);
        oSRCommandList.add(oSRSetApplicationPropertiesCommand);
        oSRCommandList.add(new OnlineService$5(this, "call callback handler", iOnlineServiceListener));
        oSRCommandList.execute("ORSMediator#setReminderState");
    }

    @Override
    public void getLicenseInformation(IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(-2137614336, "[OnlineService#getLicenseInformation] application:%1", (Object)this.applicationId);
        OSRCommandList oSRCommandList = this.system.createCommandList();
        oSRCommandList.setErrorCommand(new OnlineService$6(this, "ErrorCommand", iOnlineServiceListener));
        oSRCommandList.add(new OnlineService$7(this, "check if license(s) are available and trigger #getServiceList if necessary"));
        oSRCommandList.add(new OnlineService$8(this, "call callback handler", iOnlineServiceListener));
        oSRCommandList.execute("ORSMediator#getLicenseInformation");
    }

    @Override
    public void getReminderStatus(IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(-2137614336, "[OnlineService#getReminderStatus] application:%1", (Object)this.applicationId);
        OSRCommandList oSRCommandList = this.system.createCommandList();
        oSRCommandList.setErrorCommand(new OnlineService$9(this, "ErrorCommand", iOnlineServiceListener));
        oSRCommandList.add(new OnlineService$10(this, "check if query is needed"));
        oSRCommandList.add(new OnlineService$11(this, "call callback handler", iOnlineServiceListener));
        oSRCommandList.execute("ORSMediator#getReminderStatus");
    }

    @Override
    public boolean addCallBackListener(IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(-2137614336, "[OnlineService#addCallBackListener] application:%1", (Object)this.applicationId);
        boolean bl = this.serviceCallbacks.add(iOnlineServiceListener);
        if (this.onlineApplication != null) {
            this.logChannel.log(-2137614336, "[OnlineService#setCallBackListener] propagating initial app status");
            iOnlineServiceListener.getOnlineApplicationResponse(this.onlineApplication);
        } else {
            this.logChannel.log(-2137614336, "[OnlineService#setCallBackListener] no online application set yet");
        }
        return bl;
    }

    @Override
    public boolean removeCallBackListener(IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(-2137614336, "[OnlineService#removeCallBackListener] application:%1", (Object)this.applicationId);
        return this.serviceCallbacks.remove(iOnlineServiceListener);
    }

    public void setOnlineApplication(OSRApplication oSRApplication) {
        this.onlineApplication = oSRApplication;
        if (oSRApplication == null) {
            this.logChannel.log(-2137614336, "[OnlineService#setOnlineApplication] deleting online app");
        }
    }

    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.logChannel.log(-2137614336, "[OnlineService#updateApplicationState] delegating status update to callback...");
        for (int i2 = 0; i2 < this.serviceCallbacks.size(); ++i2) {
            ((IOnlineServiceListener)this.serviceCallbacks.get(i2)).updateApplicationState(oSRNotifyPropertiesArray);
        }
    }

    public OSRNotifyProperties getProperties() {
        return this.properties;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public ServiceRegistration getServiceRegistration() {
        return this.serviceRegistration;
    }

    public void setServiceRegistration(ServiceRegistration serviceRegistration) {
        this.serviceRegistration = serviceRegistration;
    }

    public OSRApplication getOnlineApplication() {
        return this.onlineApplication;
    }

    public void updateRoamingState(boolean bl) {
        if (bl == this.roamingActive) {
            return;
        }
        this.roamingActive = bl;
    }

    @Override
    public void getOnlineApplicationPreCheck(IOnlineServiceListener iOnlineServiceListener, String string) {
        String string2 = "";
        string2 = string != null && string.length() > 0 && !string.equals(this.applicationId) ? string : this.getSymbolicnameForAppId(LicenseCollectionService.licenses);
        if (string2 == null) {
            this.logChannel.log(-1601830656, "[OnlineService#getOnlineApplicationPreCheck] no symbolic name for application:%1", (Object)this.applicationId);
            return;
        }
        this.logChannel.log(1078071040, "[OnlineService#getOnlineApplicationPreCheck] symbolic name for application:%1 symbolicName: %2", (Object)this.applicationId, (Object)string2);
        OSRCommandList oSRCommandList = this.system.createCommandList();
        oSRCommandList.setErrorCommand(new OnlineService$12(this, "ErrorCommand"));
        oSRCommandList.add(new OSRPOnlineApplicationPreCheck(this.applicationId, string2, this, iOnlineServiceListener));
        oSRCommandList.execute("OnlineService#getOnlineApplicationPreCheck");
    }

    private String getSymbolicnameForAppId(Map map) {
        if (this.applicationId.equals("service_dsi_satellitemaps")) {
            return "satellitemaps";
        }
        if (this.applicationId.equals("ebnav")) {
            return "satellitemaps_eb";
        }
        if (this.applicationId.equals("awnavicore")) {
            return "satellitemaps";
        }
        if (this.applicationId.equals("service_dsi_onlinetraffic")) {
            return "lic_traffic";
        }
        if (this.applicationId.equals("service_dsi_destimport")) {
            return "zieleinspeisung";
        }
        Iterator iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map$Entry map$Entry = (Map$Entry)iterator.next();
            String string = (String)map$Entry.getValue();
            if (!this.applicationId.equals(string)) continue;
            return (String)map$Entry.getKey();
        }
        return null;
    }

    @Override
    public void getOnlineApplicationPreCheckResult(String string, OSRServiceState oSRServiceState, IOnlineServiceListener iOnlineServiceListener) {
        this.logChannel.log(-2137614336, "[OnlineService#getOnlineApplicationPreCheckResult] preCheckResult for application %1: %2", (Object)string, (Object)oSRServiceState);
        iOnlineServiceListener.getPreCheckResult(oSRServiceState);
    }

    @Override
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
        this.logChannel.log(1078071040, "OnlineService#updateServiceState %1", (Object)onlineServiceListState);
        for (int i2 = 0; i2 < this.serviceCallbacks.size(); ++i2) {
            IOnlineServiceListener iOnlineServiceListener = (IOnlineServiceListener)this.serviceCallbacks.get(i2);
            this.logChannel.log(1078071040, "OnlineService#updateServiceState calling handler %1", (Object)iOnlineServiceListener);
            iOnlineServiceListener.updateServiceState(onlineServiceListState);
        }
    }

    static /* synthetic */ String access$000(OnlineService onlineService) {
        return onlineService.applicationId;
    }

    static /* synthetic */ LogChannel access$100(OnlineService onlineService) {
        return onlineService.logChannel;
    }

    static /* synthetic */ OSRApplication access$200(OnlineService onlineService) {
        return onlineService.onlineApplication;
    }

    static /* synthetic */ OnlineServiceRegistrationSubsystem access$300(OnlineService onlineService) {
        return onlineService.system;
    }
}

