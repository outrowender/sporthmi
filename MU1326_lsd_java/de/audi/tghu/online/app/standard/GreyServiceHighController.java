/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.standard;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.interapp.bap.eni.data.Service;
import de.audi.atip.interapp.bap.eni.data.User;
import de.audi.atip.log.LogChannel;
import de.audi.remotehmi.HMIProperties;
import de.audi.remotehmi.RemoteHMIAction;
import de.audi.remotehmi.RemoteHMIGuideIcon;
import de.audi.remotehmi.ui.mib2.DistributedServices;
import de.audi.tghu.online.app.remotehmi.RemoteHMIDSIAccess;
import de.audi.tghu.online.app.remotehmi.RemoteHMIService;
import de.audi.tghu.online.app.standard.AbstractStandardController;
import de.audi.tghu.online.app.standard.IDistributedServiceCallListener;
import de.audi.tghu.online.app.standard.OnlineI18NHandler;
import java.util.ArrayList;
import java.util.List;

public class GreyServiceHighController
extends AbstractStandardController
implements IDistributedServiceCallListener,
RemoteHMIDSIAccess.IRemoteHMIDSIListener {
    public static final String SYMBOLIC_NAME_ALERT_SERVICES = "alert_services";
    private RemoteHMIAction pendingServiceAction = null;
    private RemoteHMIAction pendingUserAction = null;

    public GreyServiceHighController(LogChannel logChannel, HMIService hMIService, int n, OnlineI18NHandler onlineI18NHandler, IFrameworkAccess iFrameworkAccess) {
        super(logChannel, hMIService, n, onlineI18NHandler, iFrameworkAccess);
        logChannel.log(1000000, "GreyServiceHighController#c'tor");
    }

    public void init() {
        super.init();
        this.onServiceList(new Service[0]);
    }

    public void onServiceList(Service[] serviceArray) {
        super.onServiceList(serviceArray);
        this.createAction(serviceArray);
    }

    private void createAction(Service[] serviceArray) {
        List list = this.getServiceMap(serviceArray);
        HMIProperties hMIProperties = new HMIProperties();
        hMIProperties.put("value", list);
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(10008912);
        remoteHMIAction.setParameters(hMIProperties);
        if (this.remoteHmiService == null) {
            this.log.log(1000000, "GreyServiceHighController#createAction: remoteHmiService is null. Storing action.");
            this.pendingServiceAction = remoteHMIAction;
            return;
        }
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    public void setRemoteHmiService(RemoteHMIService remoteHMIService) {
        super.setRemoteHmiService(remoteHMIService);
        if (this.pendingServiceAction != null) {
            this.log.log(1000000, "GreyServiceHighController#setRemoteHmiService: sending stored service action.");
            this.remoteHmiService.invokeAction(this.pendingServiceAction);
        }
        if (this.pendingUserAction != null) {
            this.log.log(1000000, "GreyServiceHighController#setRemoteHmiService: sending stored user action.");
            this.remoteHmiService.invokeAction(this.pendingUserAction);
        }
    }

    private List getServiceMap(Service[] serviceArray) {
        ArrayList arrayList = new ArrayList();
        boolean bl = false;
        int n = serviceArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            String string = serviceArray[i2].getId();
            RemoteHMIGuideIcon remoteHMIGuideIcon = null;
            String string2 = serviceArray[i2].getName();
            if (string.equals("carfinder_v1")) {
                remoteHMIGuideIcon = RemoteHMIGuideIcon.CARFINDER;
                string2 = "{i18n:TEXT_CONST_RHMI_DISTR_CAR_FINDER_MAIN}";
                this.log.log(1000000, "GreyServiceHighController#getServiceMap: Adding Service to List id %1, name %2", (Object)string, (Object)string2);
                arrayList.add(new DistributedServices(string, string2, "carRemote", 1800, remoteHMIGuideIcon, serviceArray[i2].getName(), true));
                continue;
            }
            if (string.equals("geofence_v1") || string.equals("speedalert_v1") || string.equals("valetalert_v1")) {
                this.log.log(1000000, "GreyServiceHighController#getServiceMap: AlertService found id %1", (Object)string);
                bl = true;
                continue;
            }
            this.log.log(1000000, "GreyServiceHighController#getServiceMap: Skipping unknown service id %1", (Object)string);
        }
        if (bl) {
            this.log.log(1000000, "GreyServiceHighController#getServiceMap: Creating AlertServices for ServiceList");
            arrayList.add(new DistributedServices("alert_service", "{i18n:TEXT_CONST_RHMI_DISTR_ALERT_SERVICES_MAIN}", "carRemote", 1900, RemoteHMIGuideIcon.ALERTSERVICES, SYMBOLIC_NAME_ALERT_SERVICES, true));
        }
        if (this.isMobileKeyCoded()) {
            RemoteHMIGuideIcon remoteHMIGuideIcon = RemoteHMIGuideIcon.MOBILE_KEY;
            String string = "{i18n:TEXT_CONST_RHMI_DISTR_MOBILE_KEY}";
            this.log.log(1000000, "GreyServiceHighController#getServiceMap: Adding Mobile Key");
            arrayList.add(new DistributedServices("mobilekey_sales_v1", string, "carRemote", 1850, remoteHMIGuideIcon, null, true));
        }
        return arrayList;
    }

    public void onUserList(User[] userArray) {
        super.onUserList(userArray);
        this.createMainUserAvailableAction(userArray);
        if (this.licenseCollectionService != null) {
            this.licenseCollectionService.processLicensesForOverview(true);
        } else {
            this.log.log(100000, "GreyServiceHighController#onUserList: licenseCollectionService is null!");
        }
    }

    private void createMainUserAvailableAction(User[] userArray) {
        boolean bl = userArray != null && this.isMainUserAvailable(userArray);
        HMIProperties hMIProperties = new HMIProperties();
        hMIProperties.put("value", bl);
        RemoteHMIAction remoteHMIAction = new RemoteHMIAction(10008915);
        remoteHMIAction.setParameters(hMIProperties);
        if (this.remoteHmiService == null) {
            this.log.log(1000000, "GreyServiceHighController#createMainUserAvailableAction: remoteHmiService is null. Storing action.");
            this.pendingUserAction = remoteHMIAction;
            return;
        }
        this.remoteHmiService.invokeAction(remoteHMIAction);
    }

    private boolean isMainUserAvailable(User[] userArray) {
        for (int i2 = 0; i2 < userArray.length; ++i2) {
            if (!userArray[i2].isMainUser()) continue;
            return true;
        }
        return false;
    }

    public boolean informListener(String string) {
        return this.modelHandler.handleSelectedService(string);
    }

    public void resetUserResponse(User user, int n) {
    }

    public void remoteHmiDsiReady() {
    }

    public boolean isMobileKeyCoded() {
        return this.framework.getSysApp().getAdaptationANP().isMobileDeviceKeyProfile();
    }
}

