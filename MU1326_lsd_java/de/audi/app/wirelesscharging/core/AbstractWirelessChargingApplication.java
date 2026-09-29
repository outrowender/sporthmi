/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.wirelesscharging.IWirelessChargingDiagComponent
 *  de.mib.swdiagnosis.wirelesscharging.WirelessChargingDiag
 */
package de.audi.app.wirelesscharging.core;

import de.audi.app.wirelesscharging.core.IMessageDispatcher;
import de.audi.app.wirelesscharging.core.IWirelessChargingApplication;
import de.audi.app.wirelesscharging.core.IWirelessChargingComponent;
import de.audi.app.wirelesscharging.core.MessageDispatcher;
import de.audi.app.wirelesscharging.core.WirelessChargingServiceProvider;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.mib.swdiagnosis.wirelesscharging.IWirelessChargingDiagComponent;
import de.mib.swdiagnosis.wirelesscharging.WirelessChargingDiag;
import java.util.ArrayList;
import java.util.Hashtable;
import org.osgi.framework.BundleContext;

public abstract class AbstractWirelessChargingApplication
implements IWirelessChargingApplication,
HMIApplication {
    public static final int WIRELESS_CHARGING_REMINDER_POPUP_DISABLED;
    public static final int WIRELESS_CHARGING_REMINDER_POPUP_ENABLED;
    private final IFrameworkAccess frameworkAccess;
    private final BundleContext bundleContext;
    protected final LogChannel log;
    private final IMessageDispatcher messageDispatcher;
    private volatile WirelessChargingServiceProvider hmiApplicationService;
    private final ChoiceModelApp wlcInfoPopupModel;
    private final WirelessChargingDiag diagnosis;
    private final ArrayList components = new ArrayList();
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIApplication;

    public AbstractWirelessChargingApplication(IFrameworkAccess iFrameworkAccess, String string, BundleContext bundleContext) {
        this.frameworkAccess = iFrameworkAccess;
        this.bundleContext = bundleContext;
        this.log = iFrameworkAccess.getLogChannel(string);
        this.diagnosis = new WirelessChargingDiag(this.getFrameworkAccess().getLogChannel("App.WirelessCharging.Main"), bundleContext);
        this.messageDispatcher = new MessageDispatcher(this.log, bundleContext);
        this.wlcInfoPopupModel = iFrameworkAccess.getHMIService().getChoiceModel(4343);
    }

    protected abstract void addComponents() {
    }

    @Override
    public void init() {
        this.addComponents();
        this.initComponents();
        this.initDispatchers();
        this.registerHMIApplication();
        this.initDiagnosis();
    }

    @Override
    public void deinit() {
        this.deinitComponents();
        this.deinitDispatchers();
        this.deregisterHMIApplication();
    }

    private void initDiagnosis() {
        this.diagnosis.init();
    }

    private void registerHMIApplication() {
        this.log.log(-2137614336, "[AbstractEcallApplication#registerHMIApplication] called");
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppWirelessCharging");
        hashtable.put("moduleID", new Integer(this.getId()));
        this.hmiApplicationService = new WirelessChargingServiceProvider((class$de$audi$atip$hmi$HMIApplication == null ? (class$de$audi$atip$hmi$HMIApplication = AbstractWirelessChargingApplication.class$("de.audi.atip.hmi.HMIApplication")) : class$de$audi$atip$hmi$HMIApplication).getName(), this, hashtable, this.getBundleContext(), this.log);
        this.hmiApplicationService.startService();
    }

    private void deregisterHMIApplication() {
        this.log.log(-2137614336, "[AbstractEcallApplication#deregisterHMIApplication] called");
        if (this.hmiApplicationService != null) {
            this.hmiApplicationService.stopService();
        }
    }

    protected void addWirelessChargingComponent(IWirelessChargingComponent iWirelessChargingComponent) {
        this.components.add(iWirelessChargingComponent);
    }

    @Override
    public IFrameworkAccess getFrameworkAccess() {
        return this.frameworkAccess;
    }

    private void initComponents() {
        for (int i2 = 0; i2 < this.components.size(); ++i2) {
            ((IWirelessChargingComponent)this.components.get(i2)).init();
        }
    }

    private void initDispatchers() {
        this.messageDispatcher.init();
    }

    private void deinitComponents() {
        for (int i2 = 0; i2 < this.components.size(); ++i2) {
            ((IWirelessChargingComponent)this.components.get(i2)).deinit();
        }
    }

    private void deinitDispatchers() {
        this.messageDispatcher.deinit();
    }

    @Override
    public void addDiagnosisComponent(IWirelessChargingDiagComponent iWirelessChargingDiagComponent) {
        this.diagnosis.addDiagnosisComponent(iWirelessChargingDiagComponent);
    }

    @Override
    public void logStartupEvent(String string) {
        this.getFrameworkAccess().getStartupMgr().logStartupEvent(string);
    }

    @Override
    public BundleContext getBundleContext() {
        return this.bundleContext;
    }

    @Override
    public IMessageDispatcher getMessageDispatcher() {
        return this.messageDispatcher;
    }

    @Override
    public boolean isWLCInfoPopupEnabled() {
        if (this.wlcInfoPopupModel != null) {
            int n = this.wlcInfoPopupModel.getValue();
            this.log.log(1078071040, "AbstractWirelessChargingApplication#isWLCInfoPopupEnabled() value of WIRELESS_CHARGING_INFO_POPUP_CHOICE is %1", (long)n);
            return n == 0;
        }
        return false;
    }

    @Override
    public void resetFactorySettings() {
        this.frameworkAccess.getStorageMgr().setInt(1009, 10, 0);
        if (this.wlcInfoPopupModel != null) {
            this.wlcInfoPopupModel.setValue(0);
        }
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

