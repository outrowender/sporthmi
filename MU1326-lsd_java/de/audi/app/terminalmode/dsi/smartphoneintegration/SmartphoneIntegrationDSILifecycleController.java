/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.dsi.smartphoneintegration.ISMIDSIControllerListener
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.dsi.AbstractDSIController;
import de.audi.app.terminalmode.dsi.IDSIController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISMIDSIControllerListener;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.NullDSISmartphoneIntegration;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$1;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$2;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$3;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$4;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.statemachine.SyncPoint;
import de.audi.atip.utils.statemachine.SyncPoint$Builder;
import de.audi.mib.jdsi.DSIActivator;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener;

public class SmartphoneIntegrationDSILifecycleController
extends AbstractDSIController
implements IDSIController,
ITerminalModeComponent {
    private static final int INSTANCE_ID;
    private static final String SWAPSTATUS_CARPLAY;
    private static final String STARTUP_FINISHED;
    private volatile DSISmartphoneIntegration dsiSmartphoneIntegration;
    private volatile ISMIDSIControllerListener smiControllerListener;
    private final DSISmartphoneIntegration nullSmartphoneIntegration;
    private final DispatcherBase dispatcher;
    private final DSISmartphoneIntegrationListener dsiListener;
    private final SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIController dSMIDSIControllerImpl;
    private final IFrameworkAccess fw;
    private final SyncPoint startupSyncPoint;
    private final ITerminalModeConfiguration configuration;
    private int lastSentConnectDeviceId = -1;
    private final IEventBus eventBus;
    private static final int NO_CONNECT_PENDING;
    private volatile boolean usbResetActive;
    private volatile int pendingConnectDeviceId = -1;
    private volatile int pendingConnectMethodId = -1;
    static /* synthetic */ Class class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISMIDSIControllerListener;
    static /* synthetic */ Class class$org$dsi$ifc$carkombi$DSICarKombi;
    static /* synthetic */ Class class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates;
    static /* synthetic */ Class class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration;
    static /* synthetic */ Class class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener;

    public SmartphoneIntegrationDSILifecycleController(IContext iContext, IEventBus iEventBus) {
        super(0, iContext.getServiceManager(), iContext.getFramework(), iContext.getDispatcher(), true, iContext.getLogger().dsi());
        this.dispatcher = iContext.getDispatcher();
        this.configuration = iContext.getConfiguration();
        this.dsiSmartphoneIntegration = this.nullSmartphoneIntegration = new NullDSISmartphoneIntegration(iContext.getLogger().dsi());
        this.smiControllerListener = (ISMIDSIControllerListener)iContext.get(class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISMIDSIControllerListener == null ? (class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISMIDSIControllerListener = SmartphoneIntegrationDSILifecycleController.class$("de.audi.app.terminalmode.dsi.smartphoneintegration.ISMIDSIControllerListener")) : class$de$audi$app$terminalmode$dsi$smartphoneintegration$ISMIDSIControllerListener);
        this.dsiListener = new SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIListener(this, null);
        this.dSMIDSIControllerImpl = new SmartphoneIntegrationDSILifecycleController$SmartphoneIntegrationDSIController(this, null);
        this.fw = iContext.getFramework();
        this.startupSyncPoint = new SyncPoint$Builder().setCallback(new SmartphoneIntegrationDSILifecycleController$1(this)).setName("DSISmartphoneIntegration startup").setLogChannel(this.logger).addRequirement(class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).addRequirement(class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).addRequirement("SWAPSTATUS_CARPLAY").addRequirement("STARTUP_FINISHED").build();
        this.eventBus = iEventBus;
    }

    public final ISmartphoneIntegrationDSIController getSMIDSIController() {
        return this.dSMIDSIControllerImpl;
    }

    @Override
    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration;
    }

    @Override
    public void init() {
        this.startupSyncPoint.reset();
        this.startDSI();
        super.init();
        this.startDSI(class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        this.startDSI(class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates);
        this.eventBus.registerListener(new SmartphoneIntegrationDSILifecycleController$2(this));
        this.pendingConnectDeviceId = -1;
        this.pendingConnectMethodId = -1;
    }

    private void startDSI(Class clazz) {
        new DSIActivator(this.fw, clazz.getName(), "", new Integer(0), null, new SmartphoneIntegrationDSILifecycleController$3(this, clazz)).start(this.fw.getBundleCxt());
    }

    @Override
    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener;
    }

    @Override
    protected void addDSIService(DSIBase dSIBase) {
        if (null == dSIBase) {
            this.dsiSmartphoneIntegration = this.nullSmartphoneIntegration;
            return;
        }
        this.dsiSmartphoneIntegration = (DSISmartphoneIntegration)dSIBase;
        this.dsiSmartphoneIntegration.setNotification(3, (DSIListener)this.dsiListener);
    }

    @Override
    protected void removeDSIService() {
        this.dsiSmartphoneIntegration = this.nullSmartphoneIntegration;
        this.dispatcher.execute(new SmartphoneIntegrationDSILifecycleController$4(this, "SmartphoneIntegrationDSILifecycleController.removeDSIService"));
    }

    protected void updateUSBResetActive(boolean bl) {
        this.usbResetActive = bl;
        if (!bl && this.pendingConnectDeviceId != -1) {
            this.logger.log(1078071040, "-> [SmartphoneIntegrationDSILifecycleController.updateUSBResetActive] pending connectDevice available %1 %2", (long)this.pendingConnectDeviceId, (long)this.pendingConnectMethodId);
            this.dsiSmartphoneIntegration.connectDevice(this.pendingConnectDeviceId, this.pendingConnectMethodId);
            this.pendingConnectDeviceId = -1;
            this.pendingConnectMethodId = -1;
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

    static /* synthetic */ DSISmartphoneIntegrationListener access$200(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.dsiListener;
    }

    static /* synthetic */ DSISmartphoneIntegration access$300(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.dsiSmartphoneIntegration;
    }

    static /* synthetic */ SyncPoint access$400(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.startupSyncPoint;
    }

    static /* synthetic */ IEventBus access$500(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.eventBus;
    }

    static /* synthetic */ LogChannel access$600(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }

    static /* synthetic */ ISMIDSIControllerListener access$700(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.smiControllerListener;
    }

    static /* synthetic */ int access$802(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, int n) {
        smartphoneIntegrationDSILifecycleController.lastSentConnectDeviceId = n;
        return smartphoneIntegrationDSILifecycleController.lastSentConnectDeviceId;
    }

    static /* synthetic */ boolean access$900(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.usbResetActive;
    }

    static /* synthetic */ int access$1002(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, int n) {
        smartphoneIntegrationDSILifecycleController.pendingConnectDeviceId = n;
        return smartphoneIntegrationDSILifecycleController.pendingConnectDeviceId;
    }

    static /* synthetic */ int access$1102(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, int n) {
        smartphoneIntegrationDSILifecycleController.pendingConnectMethodId = n;
        return smartphoneIntegrationDSILifecycleController.pendingConnectMethodId;
    }

    static /* synthetic */ boolean access$1200(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, int n) {
        return smartphoneIntegrationDSILifecycleController.isValid(n);
    }

    static /* synthetic */ LogChannel access$1300(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1500(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }

    static /* synthetic */ DispatcherBase access$1600(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.dispatcher;
    }

    static /* synthetic */ boolean access$1700(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, int n) {
        return smartphoneIntegrationDSILifecycleController.isValid(n);
    }

    static /* synthetic */ LogChannel access$1800(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$1900(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$2000(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$2100(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }

    static /* synthetic */ boolean access$2200(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, int n) {
        return smartphoneIntegrationDSILifecycleController.isValid(n);
    }

    static /* synthetic */ LogChannel access$2300(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }

    static /* synthetic */ LogChannel access$2400(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }

    static /* synthetic */ int access$800(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.lastSentConnectDeviceId;
    }

    static /* synthetic */ LogChannel access$2500(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }

    static /* synthetic */ boolean access$2600(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController, int n) {
        return smartphoneIntegrationDSILifecycleController.isValid(n);
    }

    static /* synthetic */ LogChannel access$2700(SmartphoneIntegrationDSILifecycleController smartphoneIntegrationDSILifecycleController) {
        return smartphoneIntegrationDSILifecycleController.logger;
    }
}

