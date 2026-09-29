/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.osr;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.online.app.AbstractOnlineActivator;
import de.audi.tghu.online.app.mobilekey.FactoryResetState;
import de.audi.tghu.online.app.osr.IOnlineLanguageListener;
import de.audi.tghu.online.app.osr.OnlineService;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationDataContainer;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationDefaultListener;
import de.audi.tghu.online.app.osr.OnlineServiceRegistrationListener;
import de.audi.tghu.online.app.osr.PrivacyModeActivationCommand;
import de.audi.tghu.online.app.osr.SubmitPrivacyModeToBackendCommand;
import de.audi.tghu.online.app.osr.auth.T2AuthenticationService;
import de.audi.tghu.online.app.osr.command.OSRCommandList;
import de.audi.tghu.online.app.osr.command.OSRGetOnlineApplicationListCommand;
import de.audi.tghu.online.app.osr.command.OSRSetLanguageCommand;
import de.audi.tghu.online.app.osr.command.OSRSetNotificationCommand;
import de.audi.tghu.online.app.osr.license.LicenseCollectionService;
import java.util.Iterator;
import org.dsi.ifc.online.DSIOnlineServiceRegistration;

public class OnlineServiceRegistrationSubsystem
implements IOnlineLanguageListener,
MsgListener {
    private final LogChannel logCh;
    private LogChannel logChCL;
    private final AbstractOnlineActivator activator;
    int dsiCounter = 0;
    private OnlineServiceRegistrationListener osrListener;
    private OnlineServiceRegistrationDefaultListener defaultListener;
    DSIOnlineServiceRegistration dsi;
    private CommandListManager cmdListMgr;
    private OnlineServiceRegistrationDataContainer container;
    private boolean isLoginCancelable = true;
    public static final String[] WHITE_FILTER = new String[]{"service_dsi_onlinetraffic", "service_trafficlight", "dictation", "service_dsi_poi", "service_dsi_satellitemaps", "ebnav", "awnavicore", "service_dsi_operatorcall", "weatherinmaponlineservice", "service_dsi_destimport", "service_core", "hotspotwlan", "ncfstracker", "ncfsdownload", "UpdateOverTheAir", "online_metadata_service_app"};
    public static final String APP_ID_CORE_SERVICES;
    public static final String LOCHANNEL_ORS;
    public static final String LOCHANNEL_ORS_CL;
    private final Object mutex = new Object();
    private final IFrameworkAccess framework;
    private T2AuthenticationService authenticationController;
    private LicenseCollectionService licenseCollector;
    private FactoryResetState factoryReset = null;
    private String activeLanguage;
    private boolean privacyModeIsActive = false;
    private boolean sendPrivacyModeOnDsiRegistration = true;

    public OnlineServiceRegistrationSubsystem(IFrameworkAccess iFrameworkAccess, AbstractOnlineActivator abstractOnlineActivator) {
        this.framework = iFrameworkAccess;
        this.activator = abstractOnlineActivator;
        this.logCh = iFrameworkAccess.getLogChannel("App.Online.ORS");
        this.logChCL = iFrameworkAccess.getLogChannel("App.Online.ORS.CL");
        this.init();
    }

    private void init() {
        this.container = new OnlineServiceRegistrationDataContainer(this);
        this.cmdListMgr = new CommandListManager(super.getClass().getName(), this.framework, this.logChCL, null, null);
        this.logCh.log(1078071040, "OnlineServiceRegistrationSubsystem#init container: %1, cmdListMgr: %2", (Object)this.container, (Object)this.cmdListMgr);
        this.defaultListener = new OnlineServiceRegistrationDefaultListener(this);
        this.authenticationController = new T2AuthenticationService(this.logCh, this);
        this.osrListener = new OnlineServiceRegistrationListener(this.logCh, this.cmdListMgr, this.defaultListener);
        this.cmdListMgr.start();
        this.logCh.log(-1601830656, "OnlineServiceRegistrationSubsystem#init defaultListener: %1, authenticationController: %2, osrListener: %3", (Object)this.defaultListener, (Object)this.authenticationController, (Object)this.osrListener);
    }

    public void setFactoryResetState(FactoryResetState factoryResetState) {
        this.logCh.log(1078071040, "OnlineServiceRegistrationSubsystem#setFactoryResetState %1", (Object)factoryResetState);
        this.factoryReset = factoryResetState;
    }

    public void setDsi(DSIOnlineServiceRegistration dSIOnlineServiceRegistration) {
        ++this.dsiCounter;
        if (dSIOnlineServiceRegistration != null) {
            this.dsi = dSIOnlineServiceRegistration;
            OSRCommandList oSRCommandList = this.createCommandList();
            oSRCommandList.add(new OSRSetNotificationCommand());
            oSRCommandList.add(new OSRGetOnlineApplicationListCommand(null));
            oSRCommandList.execute("OnlineServiceRegistrationSubsystem#SetNotificationsAndListAndStartServices");
            this.logCh.log(-2137614336, "OnlineServiceRegistrationSubsystem#setDsi: core services available");
            this.framework.getHmiServiceApp().getChoiceModel(2).setValue(1);
            this.activator.registerAuthenticationService(this.getAuthenticationController());
            if (this.activeLanguage != null) {
                this.setLanguage(this.activeLanguage);
            }
            if (this.sendPrivacyModeOnDsiRegistration) {
                this.triggerPrivacyMode(this.privacyModeIsActive);
                this.sendPrivacyModeOnDsiRegistration = false;
            }
        } else {
            this.logCh.log(-2137614336, "OnlineServiceRegistrationSubsystem#setDsi: core services not available");
            this.framework.getHmiServiceApp().getChoiceModel(2).setValue(0);
            this.dsi.clearNotification(this.getDSIListener());
            this.dsi = dSIOnlineServiceRegistration;
            this.killAll();
            this.activator.unregisterAuthenticationService();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void syncServices() {
        this.logCh.log(-2137614336, "OnlineServiceRegistrationSubsystem#syncServices: Called.");
        Object object = this.mutex;
        synchronized (object) {
            Iterator iterator = this.getContainer().getApplications().iterator();
            while (iterator.hasNext()) {
                OnlineService onlineService = (OnlineService)iterator.next();
                if (onlineService.getServiceRegistration() != null && onlineService.getOnlineApplication() == null) {
                    this.logCh.log(-2137614336, "OnlineServiceRegistrationSubsystem#syncServices: stopping service %1", (Object)onlineService.getServiceRegistration());
                    this.activator.unregisterOnlineApplicationService(onlineService);
                }
                if (onlineService.getServiceRegistration() != null || onlineService.getOnlineApplication() == null) continue;
                this.logCh.log(-2137614336, "OnlineServiceRegistrationSubsystem#syncServices: starting service %1", (Object)onlineService.getOnlineApplication().getId());
                this.activator.registerOnlineApplicationService(onlineService);
            }
        }
    }

    public DSIOnlineServiceRegistration getDsi() {
        return this.dsi;
    }

    public OnlineServiceRegistrationListener getDSIListener() {
        return this.osrListener;
    }

    public LogChannel getLogChannel() {
        return this.logCh;
    }

    public LogChannel getLogChannelCL() {
        return this.logChCL;
    }

    public CommandListManager getCommandListManager() {
        return this.cmdListMgr;
    }

    public IFrameworkAccess getFramework() {
        return this.framework;
    }

    public OSRCommandList createCommandList() {
        return new OSRCommandList(this);
    }

    public OSRCommandList createCommandList(int n) {
        return new OSRCommandList(this, n);
    }

    public OnlineServiceRegistrationDefaultListener getDefaultListener() {
        return this.defaultListener;
    }

    public OnlineServiceRegistrationDataContainer getContainer() {
        return this.container;
    }

    public T2AuthenticationService getAuthenticationController() {
        return this.authenticationController;
    }

    public void killAll() {
        Iterator iterator = this.getContainer().getApplications().iterator();
        while (iterator.hasNext()) {
            OnlineService onlineService = (OnlineService)iterator.next();
            onlineService.setOnlineApplication(null);
        }
        this.syncServices();
    }

    public void setLicenseListener(LicenseCollectionService licenseCollectionService) {
        this.licenseCollector = licenseCollectionService;
    }

    public LicenseCollectionService getLicenseListener() {
        return this.licenseCollector;
    }

    @Override
    public void setLanguage(String string) {
        if (this.dsi == null) {
            this.activeLanguage = string;
            return;
        }
        this.logCh.log(1078071040, "OnlineServiceRegistrationSubsystem#setLanguage: %1. Updating CoreServices", (Object)string);
        OSRCommandList oSRCommandList = this.createCommandList();
        oSRCommandList.add(new OSRSetLanguageCommand(string));
        oSRCommandList.execute("orsSubsystem - setLanguage");
    }

    @Override
    public void processMsg(int n) {
        if (n == 88) {
            this.logCh.log(1078071040, "OnlineServiceRegistrationSubsystem#processMsg resetNavSettings received");
            if (this.dsi == null) {
                this.logCh.log(-1601830656, "OnlineServiceRegistrationSubsystem#processMsg no dsi. No Reset done!");
                return;
            }
            if (this.factoryReset == null) {
                this.logCh.log(-1601830656, "OnlineServiceRegistrationSubsystem#processMsg no factory reset. No Reset done!");
                return;
            }
            if (this.factoryReset.isFactoryResetAllowed()) {
                this.dsi.resetToFactorySettings(null);
            } else {
                this.logCh.log(10000, "OnlineServiceRegistrationSubsystem#processMsg Factory reset was trigger but is not allowed. No Reset done!");
            }
        }
    }

    public void setLoginCancelable(boolean bl) {
        this.isLoginCancelable = bl;
    }

    public boolean isLoginCancelable() {
        return this.isLoginCancelable;
    }

    public void triggerPrivacyMode(boolean bl) {
        this.logCh.log(1078071040, "OnlineServiceRegistrationSubsystem#triggerPrivacyMode");
        this.privacyModeIsActive = bl;
        if (this.dsi == null) {
            this.logCh.log(1078071040, "OnlineServiceRegistrationSubsystem#triggerPrivacyMode: Delayed, waiting for DSI registration.");
            this.sendPrivacyModeOnDsiRegistration = true;
            return;
        }
        OSRCommandList oSRCommandList = this.createCommandList();
        oSRCommandList.add(new PrivacyModeActivationCommand(this.dsi, bl));
        oSRCommandList.add(new SubmitPrivacyModeToBackendCommand(this.dsi));
        oSRCommandList.execute("OnlineServiceRegistrationSubsystem.triggerPrivacyMode");
    }

    public int getDrawerCategory() {
        if (this.activator != null) {
            return this.activator.getDrawerCategory();
        }
        return -1;
    }

    public void restoreScreenTypeAfterAuthentication() {
    }
}

