/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.online.evo.trafficlight;

import de.audi.app.online.evo.trafficlight.TrafficLightOnlineServiceTrackerCustomizer;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ChoiceListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TrafficLightOnlineHandler
implements ButtonListener,
ChoiceListener,
IOnlineServiceListener {
    private static final int TRAFFICLIGHT_CHECKBOX_OFF;
    private static final int TRAFFICLIGHT_CHECKBOX_ON;
    private LogChannel logChannel;
    private HMIService hmiService;
    private ChoiceModelApp checkBoxModel;
    private ServiceTracker tracker;
    private IOnlineService onlineService;
    private RemoteHMIService remoteHmiService;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineService;

    public TrafficLightOnlineHandler(HMIService hMIService, LogChannel logChannel, BundleContext bundleContext) {
        this.hmiService = hMIService;
        this.logChannel = logChannel;
        this.checkBoxModel = this.hmiService.getChoiceModel(1864246016);
        this.checkBoxModel.setChoiceListener(this);
        this.checkBoxModel.setValue(0);
        this.tracker = new ServiceTracker(bundleContext, new String[]{(class$de$audi$atip$interapp$online$IOnlineService == null ? (class$de$audi$atip$interapp$online$IOnlineService = TrafficLightOnlineHandler.class$("de.audi.atip.interapp.online.IOnlineService")) : class$de$audi$atip$interapp$online$IOnlineService).getName()}, (ServiceTrackerCustomizer)new TrafficLightOnlineServiceTrackerCustomizer(this, logChannel, bundleContext));
        this.tracker.open();
    }

    protected void setOnlineService(IOnlineService iOnlineService) {
        this.logChannel.log(1078071040, "TrafficLightOnlineHandler#setOnlineService: got IOnlineService %1", (Object)iOnlineService);
        this.onlineService = iOnlineService;
        if (this.onlineService != null) {
            this.onlineService.addCallBackListener(this);
        }
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.logChannel.log(1078071040, "TrafficLightOnlineHandler#getOnlineApplicationResponse: got OSRApplication %1", (Object)oSRApplication);
        if (oSRApplication != null) {
            if (this.isAppEnabled(oSRApplication)) {
                this.checkBoxModel.setValue(1);
            } else {
                this.checkBoxModel.setValue(0);
            }
        } else {
            this.logChannel.log(-1601830656, "TrafficLightOnlineHandler#getOnlineApplicationResponse() - app is null! ");
        }
    }

    private boolean isAppEnabled(OSRApplication oSRApplication) {
        int n = oSRApplication.getState();
        this.logChannel.log(-2137614336, "TrafficLightOnlineHandler#isAppEnabled() - state: %1 ", (long)n);
        return (n & 1) != 0;
    }

    @Override
    public void activateLicenseResponse(int n) {
        this.logChannel.log(1078071040, "TrafficLightOnlineHandler#activateLicenseResponse: activated License Response status %1", (long)n);
    }

    @Override
    public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
        this.logChannel.log(1078071040, "TrafficLightOnlineHandler#getLicenseInformationResult: got OSRLicense length %1", (long)oSRLicenseArray.length);
    }

    public final void setReminderStatus(int n) {
    }

    @Override
    public void getReminderStatusResult(int n) {
    }

    @Override
    public void setReminderStateResponse(int n) {
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        this.logChannel.log(1078071040, "TrafficLightOnlineHandler#updateApplicationState() - props.length: %1 ", (long)(oSRNotifyPropertiesArray != null ? oSRNotifyPropertiesArray.length : -1));
        if (oSRNotifyPropertiesArray != null && this.logChannel.isDebug()) {
            for (int i2 = 0; i2 < oSRNotifyPropertiesArray.length; ++i2) {
                this.logChannel.log(-2137614336, "TrafficLightOnlineHandler#updateApplicationState() - props[%1] - priority: %2 reason: %3 ", (long)i2, (long)oSRNotifyPropertiesArray[i2].getPriority(), (long)oSRNotifyPropertiesArray[i2].getReason());
            }
        }
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        if (this.onlineService == null) {
            this.logChannel.log(-1601830656, "TrafficLightOnlineHandler#itemSelected: no online service");
            return;
        }
        int n5 = this.getNewApplicationState();
        this.logChannel.log(1078071040, "TrafficLightOnlineHandler#itemSelected: updating online application state to %1", (Object)Util.createInteger(n5));
        this.onlineService.setOnlineApplicationState(n5, this);
    }

    private int getNewApplicationState() {
        int n = this.checkBoxModel.getValue();
        if (n == 0) {
            return 1;
        }
        return 0;
    }

    @Override
    public void itemFocused(int n, int n2, int n3, int n4) {
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }

    public void setRemoteHmiService(RemoteHMIService remoteHMIService) {
        this.remoteHmiService = remoteHMIService;
    }

    public void triggerSDSConfiguration() {
        if (this.remoteHmiService != null && this.remoteHmiService.isSDSRunning()) {
            this.remoteHmiService.getASR().setDistributedServiceMoveType(2294);
        }
    }

    @Override
    public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

