/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.msg.core.dictation.LicenseManagerDiagPlugin
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.application.AbstractMsgApplication;
import de.audi.app.messaging.core.component.AbstractMessagingComponent;
import de.audi.app.messaging.core.dictation.LicenseManager$1;
import de.audi.app.messaging.core.dictation.LicenseManager$CoreActionProxy;
import de.audi.app.messaging.core.dictation.LicenseManager$DiagPlugIn;
import de.audi.app.messaging.core.dictation.LicenseManager$MyButtonListener;
import de.audi.app.messaging.core.dictation.LicenseManager$MyChoiceListener;
import de.audi.app.messaging.core.osgi.IServiceRegistry;
import de.audi.app.messaging.core.osgi.MessagingBundleContext;
import de.audi.app.messaging.core.osgi.ServiceFilterBuilder;
import de.audi.app.messaging.core.osgi.ServiceProperties;
import de.audi.app.messaging.core.swdiagnosis.IDiagPlugIn;
import de.audi.app.messaging.core.swdiagnosis.IDiagProvider;
import de.audi.app.messaging.core.util.Arrays;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.interapp.IMessagingLicenseService;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.interapp.online.IOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceListState;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.mib.swdiagnosis.msg.core.dictation.LicenseManagerDiagPlugin;
import java.util.Date;
import org.dsi.ifc.online.OSRApplication;
import org.dsi.ifc.online.OSRLicense;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRServiceState;
import org.osgi.framework.Filter;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public final class LicenseManager
extends AbstractMessagingComponent
implements IMessagingLicenseService,
IOnlineServiceListener,
IDiagProvider {
    public static final String ONLINE_SERVICE_ID;
    private static final int REMINDER_SETTING_OFF;
    private static final int REMINDER_SETTING_ON;
    private static final int LICENSE_ACTIVATION_NOT_SUCCESSFUL;
    private static final int LICENSE_ACTIVATION_SUCCESSFUL;
    private static final int LICENSE_STATE_UNDEFINED;
    private static final int LICENSE_STATE_ACTIVATED;
    private static final int LICENSE_STATE_INACTIVE;
    private static final int LICENSE_STATE_EXPIRED;
    private static final int LICENSE_STATE_NOLICENCE;
    private static final int LICENSE_STATE_ERROR;
    private final IHMIServiceApp hmiService;
    private volatile IOnlineService onlineService;
    private volatile boolean isLicenseInfoRequested;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingLicenseService;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IOnlineService;

    public LicenseManager(MessagingBundleContext messagingBundleContext) {
        super(messagingBundleContext, "App.Messaging.Main");
        this.hmiService = this.framework.getHmiServiceApp();
    }

    @Override
    public void init(AbstractMsgApplication abstractMsgApplication) {
        super.init(abstractMsgApplication);
        if (Boolean.getBoolean("enableOnlineDictationLicense")) {
            this.log.log(1078071040, "[LicenseManager#init] Development VM option set, setting license state to ENABLED.");
            this.hmiService.getChoiceModel(-1835917056).setValue(1);
        }
        this.hmiService.getButtonModel(-1903025920).setButtonListener(new LicenseManager$MyButtonListener(this, null));
        this.hmiService.getChoiceModel(-1819139840).setChoiceListener(new LicenseManager$MyChoiceListener(this, null));
        abstractMsgApplication.getActionProxyService().addSubscriber(new LicenseManager$CoreActionProxy(this, null));
        abstractMsgApplication.getMessagingSwDiagnosis().registerDiagProvider(this);
    }

    @Override
    public void connect(IServiceRegistry iServiceRegistry) {
        try {
            super.connect(iServiceRegistry);
            iServiceRegistry.registerService((class$de$audi$atip$interapp$IMessagingLicenseService == null ? (class$de$audi$atip$interapp$IMessagingLicenseService = LicenseManager.class$("de.audi.atip.interapp.IMessagingLicenseService")) : class$de$audi$atip$interapp$IMessagingLicenseService).getName(), (Object)this, ServiceProperties.createServiceProperties());
            iServiceRegistry.addTracker(this.createServiceTracker());
        }
        catch (Exception exception) {
            this.log.log(10000, "[LicenseManager#connect] An error occurred: ", (Throwable)exception);
        }
    }

    private ServiceTracker createServiceTracker() {
        ServiceFilterBuilder serviceFilterBuilder = new ServiceFilterBuilder();
        serviceFilterBuilder.beginAnd();
        serviceFilterBuilder.addProperty("objectClass", (class$de$audi$atip$interapp$online$IOnlineService == null ? (class$de$audi$atip$interapp$online$IOnlineService = LicenseManager.class$("de.audi.atip.interapp.online.IOnlineService")) : class$de$audi$atip$interapp$online$IOnlineService).getName());
        serviceFilterBuilder.addProperty("ONLINE_APP_ID", "dictation");
        serviceFilterBuilder.endAnd();
        String string = serviceFilterBuilder.createFilterString();
        Filter filter = this.bundleContext.createFilter(string);
        LicenseManager$1 licenseManager$1 = new LicenseManager$1(this, this.log, this.bundleContext);
        return new ServiceTracker(this.bundleContext, filter, (ServiceTrackerCustomizer)licenseManager$1);
    }

    private void setLicensingService(IOnlineService iOnlineService) {
        this.setOnlineService(iOnlineService);
    }

    private void removeLicensingService() {
        this.removeOnlineService();
    }

    private void emitResponseOnlineDictationLicenseInfo(int n) {
        this.log.log(-2137614336, "[LicenseManager#emitResponseOnlineDictationLicenseInfo] result = %1, isLicenseInfoRequested = %2", (Object)String.valueOf(n), (Object)String.valueOf(this.isLicenseInfoRequested));
    }

    private void setExpirationDateModels(OSRLicense oSRLicense) {
        DateMetric dateMetric = new DateMetric(new Date(oSRLicense.getExpires().getTime()), 0);
        this.hmiService.getMetricsModel(-1802362624).setMetric(dateMetric);
    }

    private void setOnlineService(IOnlineService iOnlineService) {
        this.log.log(-2137614336, "[LicenseManager#setOnlineService] onlineService = %1", (Object)iOnlineService);
        this.onlineService = iOnlineService;
        iOnlineService.addCallBackListener(this);
    }

    private void removeOnlineService() {
        this.log.log(-2137614336, "[LicenseManager#removeOnlineService]");
        this.onlineService = null;
    }

    private void logOnlineServiceUnavailable(String string) {
        this.log.log(-1601830656, "%1 Online dictation license service not available.", (Object)string);
    }

    private void checkOnlineDictationLicenseStatus() {
        this.log.log(-2137614336, "[LicenseManager#checkOnlineDictationLicenseStatus]");
        if (this.onlineService != null) {
            this.onlineService.getLicenseInformation(this);
        } else {
            this.logOnlineServiceUnavailable("[LicenseManager#checkOnlineDictationLicenseStatus]");
            this.emitResponseOnlineDictationLicenseInfo(0);
        }
    }

    private OSRLicense getFirstLicense(int n, OSRLicense[] oSRLicenseArray) {
        OSRLicense oSRLicense = null;
        for (int i2 = 0; i2 < oSRLicenseArray.length; ++i2) {
            if (oSRLicenseArray[i2].getState() != n) continue;
            oSRLicense = oSRLicenseArray[i2];
        }
        return oSRLicense;
    }

    private void enterLicenseQuery() {
        this.resetChoiceModels();
        this.checkOnlineDictationLicenseStatus();
    }

    private void exitLicenseQuery() {
        this.hmiService.getChoiceModel(-1869471488).setValue(0);
    }

    private void resetChoiceModels() {
        this.setLicenseState(0);
        this.hmiService.getChoiceModel(-1869471488).setValue(0);
    }

    private void setLicenseState(int n) {
        this.log.log(-2137614336, "[LicenseManager#setLicenseState] licenseState = %1", (long)n);
        this.log.log(1078071040, "[LicenseManager#setLicenseState] Overriding argument, setting the state that indicates an OK license.");
        int n2 = 1;
        this.hmiService.getChoiceModel(-1785585408).setValue(n2);
    }

    private int toReminderSetting(int n) {
        return n == 1 ? 0 : 1;
    }

    private void setReminderSetting(int n) {
        this.log.log(-2137614336, "[LicenseManager#setReminderSetting] reminderSetting = %1, i.e. reminders enabled: %2", (Object)String.valueOf(n), (Object)String.valueOf(n == 0));
        this.hmiService.getChoiceModel(-1819139840).setValue(n);
    }

    private int getReminderSetting() {
        return this.hmiService.getChoiceModel(-1819139840).getValue();
    }

    private boolean isShowExpirationWarning(OSRLicense oSRLicense) {
        return oSRLicense.isWarn() && this.getReminderSetting() == 0;
    }

    @Override
    public void getOnlineApplicationResponse(OSRApplication oSRApplication) {
        this.log.log(1078071040, "[LicenseManager#getOnlineApplicationResponse] osrApplication = %1", (Object)oSRApplication);
        int n = oSRApplication.getState() == 1 ? 1 : 0;
        this.hmiService.getChoiceModel(-1852694272).setValue(n);
        OSRLicense oSRLicense = this.getFirstLicense(1, oSRApplication.getLicenseList());
        if (oSRLicense != null) {
            this.hmiService.getChoiceModel(-1869471488).setValue(1);
            this.setExpirationDateModels(oSRLicense);
            this.setLicenseState(1);
        }
    }

    @Override
    public void getLicenseInformationResult(OSRLicense[] oSRLicenseArray) {
        this.log.log(1078071040, "[LicenseManager#getLicenseInformationResult] licenses = %1", (Object)Arrays.toMultiLineString(oSRLicenseArray));
        int n = 0;
        int n2 = 5;
        if (oSRLicenseArray == null || oSRLicenseArray.length == 0) {
            n2 = 4;
        } else {
            OSRLicense oSRLicense = this.getFirstLicense(1, oSRLicenseArray);
            OSRLicense oSRLicense2 = this.getFirstLicense(2, oSRLicenseArray);
            OSRLicense oSRLicense3 = this.getFirstLicense(4, oSRLicenseArray);
            if (oSRLicense != null) {
                this.setExpirationDateModels(oSRLicense);
                n2 = 1;
                n = this.isShowExpirationWarning(oSRLicense) ? 6 : 3;
            } else if (oSRLicense2 != null) {
                n2 = 2;
                n = 4;
            } else if (oSRLicense3 != null) {
                n2 = 3;
                n = 5;
            } else {
                n2 = 5;
                n = 0;
            }
        }
        this.setLicenseState(n2);
        this.emitResponseOnlineDictationLicenseInfo(n);
    }

    @Override
    public void getReminderStatusResult(int n) {
        this.log.log(1078071040, "[LicenseManager#getReminderStatusResult] reminderStatus = %1", (long)n);
        this.setReminderSetting(this.toReminderSetting(n));
    }

    @Override
    public void setReminderStateResponse(int n) {
        this.log.log(1078071040, "[LicenseManager#setReminderStateResponse] reminderStatus = %1", (long)n);
        this.setReminderSetting(this.toReminderSetting(n));
    }

    @Override
    public void activateLicenseResponse(int n) {
        this.log.log(1078071040, "[LicenseManager#activateLicenseResponse] status = %1", (long)n);
        this.hmiService.getChoiceModel(-1886248704).setValue(0);
        if (n == 0) {
            this.log.log(-2137614336, "[LicenseManager#activateLicenseResponse] License was activated, waiting for getOnlineApplicationResponse() which contains the newly activated license...");
        } else {
            this.hmiService.getChoiceModel(-1869471488).setValue(2);
        }
    }

    @Override
    public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
    }

    @Override
    public void requestOnlineDictationLicenseInfo() {
        this.log.log(1078071040, "[LicenseManager#requestOnlineDictationLicenseInfo]");
        this.isLicenseInfoRequested = true;
        this.checkOnlineDictationLicenseStatus();
    }

    @Override
    public void setExpirationWarning(boolean bl) {
        this.log.log(1078071040, "[LicenseManager#setExpirationWarning] enableWarning = %1", bl);
        if (this.onlineService != null) {
            int n = bl ? 1 : 0;
            this.onlineService.setReminderState(n, this);
        } else {
            this.logOnlineServiceUnavailable("[LicenseManager#setExpirationWarning]");
        }
    }

    @Override
    public IDiagPlugIn[] createDiagPlugIns() {
        return new IDiagPlugIn[]{new LicenseManager$DiagPlugIn(this), new LicenseManagerDiagPlugin(this)};
    }

    private void onlineLicenceActivateButton(int n, int n2) {
        this.log.log(1078071040, "[LicenseManager#onlineLicenceActivateButton]");
        if (this.onlineService != null) {
            this.hmiService.getChoiceModel(-1886248704).setValue(1);
            this.onlineService.activateLicense(this);
            this.hmiService.getModelApp(n).fireEvent(n2);
        } else {
            this.logOnlineServiceUnavailable("[LicenseManager#onlineLicenceActivateButton]");
        }
    }

    @Override
    public void updateServiceState(OnlineServiceListState onlineServiceListState) {
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

    static /* synthetic */ void access$300(LicenseManager licenseManager, IOnlineService iOnlineService) {
        licenseManager.setLicensingService(iOnlineService);
    }

    static /* synthetic */ void access$400(LicenseManager licenseManager) {
        licenseManager.removeLicensingService();
    }

    static /* synthetic */ void access$500(LicenseManager licenseManager, IOnlineService iOnlineService) {
        licenseManager.setOnlineService(iOnlineService);
    }

    static /* synthetic */ LogChannel access$600(LicenseManager licenseManager) {
        return licenseManager.log;
    }

    static /* synthetic */ void access$700(LicenseManager licenseManager) {
        licenseManager.enterLicenseQuery();
    }

    static /* synthetic */ LogChannel access$800(LicenseManager licenseManager) {
        return licenseManager.log;
    }

    static /* synthetic */ void access$900(LicenseManager licenseManager) {
        licenseManager.exitLicenseQuery();
    }

    static /* synthetic */ void access$1000(LicenseManager licenseManager, int n, int n2) {
        licenseManager.onlineLicenceActivateButton(n, n2);
    }

    static /* synthetic */ LogChannel access$1100(LicenseManager licenseManager) {
        return licenseManager.log;
    }

    static /* synthetic */ LogChannel access$1200(LicenseManager licenseManager) {
        return licenseManager.log;
    }

    static /* synthetic */ LogChannel access$1300(LicenseManager licenseManager) {
        return licenseManager.log;
    }
}

