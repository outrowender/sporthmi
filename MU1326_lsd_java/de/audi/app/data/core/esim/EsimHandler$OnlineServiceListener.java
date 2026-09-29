/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.data.core.esim;

import de.audi.app.data.core.esim.EsimHandler;
import de.audi.app.data.core.esim.EsimHandler$1;
import de.audi.app.data.core.esim.ServiceFilterBuilder;
import de.audi.atip.interapp.online.IOnlineDataStateListener;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.esolutions.fw.util.commons.StringUtils;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;
import org.osgi.framework.InvalidSyntaxException;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class EsimHandler$OnlineServiceListener
implements ServiceTrackerCustomizer,
IOnlineServiceListener {
    private final String licenseId;
    private IOnlineService online;
    private ServiceTracker tracker;
    private volatile boolean licenseAvailable = false;
    private final /* synthetic */ EsimHandler this$0;

    private EsimHandler$OnlineServiceListener(EsimHandler esimHandler, String string) {
        this.this$0 = esimHandler;
        this.licenseId = string;
    }

    private void init() {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (EsimHandler.class$de$audi$atip$interapp$online$IOnlineService == null ? (EsimHandler.class$de$audi$atip$interapp$online$IOnlineService = EsimHandler.class$("de.audi.atip.interapp.online.IOnlineService")) : EsimHandler.class$de$audi$atip$interapp$online$IOnlineService).getName());
        serviceFilterBuilder.addProperty("ONLINE_APP_ID", this.licenseId);
        serviceFilterBuilder.endAnd();
        String string = serviceFilterBuilder.createFilterString();
        try {
            this.tracker = new ServiceTracker(EsimHandler.access$700(this.this$0), EsimHandler.access$800(this.this$0).createFilter(string), (ServiceTrackerCustomizer)this);
        }
        catch (InvalidSyntaxException invalidSyntaxException) {
            EsimHandler.access$900(this.this$0).log(-1601830656, "EsimHandler.OnlineServiceListener#init(): %1", (Throwable)invalidSyntaxException);
        }
        this.tracker.open();
    }

    private void deinit() {
        this.tracker.close();
    }

    @Override
    public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
        int n;
        EsimHandler.access$1000(this.this$0).log(1078071040, "EsimHandler.OnlineServiceListener#getLicenseInformationResult(): %1", (Object)StringUtils.toString(oSRLicenseArray));
        this.licenseAvailable = oSRLicenseArray != null && oSRLicenseArray.length > 0 ? (n = oSRLicenseArray[0].getState()) == 1 : true;
        EsimHandler.access$1100(this.this$0, this.licenseId, this.licenseAvailable);
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
        EsimHandler.access$1200(this.this$0).log(1078071040, "EsimHandler.OnlineServiceListener#updateApplicationState(): %1", (Object)StringUtils.toString(oSRNotifyPropertiesArray));
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
    }

    @Override
    public void activateLicenseResponse(int n) {
    }

    @Override
    public void getReminderStatusResult(int n) {
    }

    @Override
    public void setReminderStateResponse(int n) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = EsimHandler.access$1300(this.this$0).getService(serviceReference);
        if (object instanceof IOnlineService) {
            this.online = (IOnlineService)object;
            this.online.addCallBackListener(this);
            this.online.getLicenseInformation(this);
            return object;
        }
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnlineDataStateListener) {
            this.online = (IOnlineService)object;
        }
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IOnlineDataStateListener) {
            this.online = null;
        }
    }

    @Override
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
    }

    @Override
    public void getPreCheckResult(OSRServiceState oSRServiceState) {
    }

    /* synthetic */ EsimHandler$OnlineServiceListener(EsimHandler esimHandler, String string, EsimHandler$1 esimHandler$1) {
        this(esimHandler, string);
    }

    static /* synthetic */ void access$100(EsimHandler$OnlineServiceListener esimHandler$OnlineServiceListener) {
        esimHandler$OnlineServiceListener.init();
    }

    static /* synthetic */ void access$200(EsimHandler$OnlineServiceListener esimHandler$OnlineServiceListener) {
        esimHandler$OnlineServiceListener.deinit();
    }
}

