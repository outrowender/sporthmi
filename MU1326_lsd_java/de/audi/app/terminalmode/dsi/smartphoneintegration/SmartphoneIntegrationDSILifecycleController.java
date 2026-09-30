/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.SmartphoneManager;
import de.audi.app.terminalmode.TerminalModeUtils;
import de.audi.app.terminalmode.dsi.AbstractDSIController;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.dsi.IDSIController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISMIDSIControllerListener;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.app.terminalmode.dsi.smartphoneintegration.NullDSISmartphoneIntegration;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.util.Enum;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.statemachine.SyncPoint;
import de.audi.mib.jdsi.DSIActivator;
import de.audi.mib.jdsi.IDSIClient;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration;
import org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener;
import org.dsi.ifc.smartphoneintegration.Device;

public class SmartphoneIntegrationDSILifecycleController
extends AbstractDSIController
implements IDSIController,
ITerminalModeComponent {
    private static final int INSTANCE_ID = 0;
    private static final String SWAPSTATUS_CARPLAY = "SWAPSTATUS_CARPLAY";
    private static final String STARTUP_FINISHED = "STARTUP_FINISHED";
    private volatile DSISmartphoneIntegration dsiSmartphoneIntegration;
    private volatile ISMIDSIControllerListener smiControllerListener;
    private final DSISmartphoneIntegration nullSmartphoneIntegration;
    private final DispatcherBase dispatcher;
    private final DSISmartphoneIntegrationListener dsiListener;
    private final SmartphoneIntegrationDSIController dSMIDSIControllerImpl;
    private final IFrameworkAccess fw;
    private final SyncPoint startupSyncPoint;
    private final ITerminalModeConfiguration configuration;
    private int lastSentConnectDeviceId = -1;
    private final IEventBus eventBus;
    private static final int NO_CONNECT_PENDING = -1;
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
        this.dsiListener = new SmartphoneIntegrationDSIListener();
        this.dSMIDSIControllerImpl = new SmartphoneIntegrationDSIController();
        this.fw = iContext.getFramework();
        this.startupSyncPoint = new SyncPoint.Builder().setCallback(new Runnable(){

            public void run() {
                SmartphoneIntegrationDSILifecycleController.this.dsiSmartphoneIntegration.setNotification(new int[]{1, 2, 4}, (DSIListener)SmartphoneIntegrationDSILifecycleController.this.dsiListener);
            }
        }).setName("DSISmartphoneIntegration startup").setLogChannel(this.logger).addRequirement(class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates).addRequirement(class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi).addRequirement(SWAPSTATUS_CARPLAY).addRequirement(STARTUP_FINISHED).build();
        this.eventBus = iEventBus;
    }

    public final ISmartphoneIntegrationDSIController getSMIDSIController() {
        return this.dSMIDSIControllerImpl;
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegration")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegration;
    }

    public void init() {
        this.startupSyncPoint.reset();
        this.startDSI();
        super.init();
        this.startDSI(class$org$dsi$ifc$carkombi$DSICarKombi == null ? (class$org$dsi$ifc$carkombi$DSICarKombi = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.carkombi.DSICarKombi")) : class$org$dsi$ifc$carkombi$DSICarKombi);
        this.startDSI(class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates == null ? (class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.carvehiclestates.DSICarVehicleStates")) : class$org$dsi$ifc$carvehiclestates$DSICarVehicleStates);
        this.eventBus.registerListener(new DefaultEventListener(){

            public void startupFinished() {
                SmartphoneIntegrationDSILifecycleController.this.startupSyncPoint.completeRequirement(SmartphoneIntegrationDSILifecycleController.STARTUP_FINISHED);
                SmartphoneIntegrationDSILifecycleController.this.eventBus.unregisterListener(this);
            }
        });
        this.pendingConnectDeviceId = -1;
        this.pendingConnectMethodId = -1;
    }

    private void startDSI(final Class clazz) {
        new DSIActivator(this.fw, clazz.getName(), "", new Integer(0), null, new IDSIClient(){

            public void setDSI(DSIBase dSIBase) {
                if (dSIBase != null) {
                    SmartphoneIntegrationDSILifecycleController.this.startupSyncPoint.completeRequirement(clazz);
                }
            }

            public int[] getAutoNotifications() {
                return null;
            }
        }).start(this.fw.getBundleCxt());
    }

    protected DSIListener getDSIListener() {
        return this.dsiListener;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener == null ? (class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener = SmartphoneIntegrationDSILifecycleController.class$("org.dsi.ifc.smartphoneintegration.DSISmartphoneIntegrationListener")) : class$org$dsi$ifc$smartphoneintegration$DSISmartphoneIntegrationListener;
    }

    protected void addDSIService(DSIBase dSIBase) {
        if (null == dSIBase) {
            this.dsiSmartphoneIntegration = this.nullSmartphoneIntegration;
            return;
        }
        this.dsiSmartphoneIntegration = (DSISmartphoneIntegration)dSIBase;
        this.dsiSmartphoneIntegration.setNotification(3, (DSIListener)this.dsiListener);
    }

    protected void removeDSIService() {
        this.dsiSmartphoneIntegration = this.nullSmartphoneIntegration;
        this.dispatcher.execute(new AbstractDispatcherRunnable("SmartphoneIntegrationDSILifecycleController.removeDSIService"){

            public void run() {
                SmartphoneIntegrationDSILifecycleController.this.logger.log(1000000, "<- [SmartphoneIntegrationDSILifecycleController.removeDSIService] send an empty device list");
                SmartphoneIntegrationDSILifecycleController.this.smiControllerListener.updateDiscoveredDevices(Generics.<Device>newArrayList());
            }
        });
    }

    protected void updateUSBResetActive(boolean bl) {
        this.usbResetActive = bl;
        if (!bl && this.pendingConnectDeviceId != -1) {
            this.logger.log(1000000, "-> [SmartphoneIntegrationDSILifecycleController.updateUSBResetActive] pending connectDevice available %1 %2", (long)this.pendingConnectDeviceId, (long)this.pendingConnectMethodId);
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

    /*
     * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
     */
    public static class ErrorCode
    extends Enum<ErrorCode> {
        public static final ErrorCode ERRORCODE_UNKNOWN = new ErrorCode(0, "ERRORCODE_UNKNOWN");
        public static final ErrorCode ERRORCODE_CODING = new ErrorCode(1, "ERRORCODE_CODING");
        public static final ErrorCode ERRORCODE_SWAP = new ErrorCode(2, "ERRORCODE_SWAP");
        public static final ErrorCode ERRORCODE_USBSTACK = new ErrorCode(3, "ERRORCODE_USBSTACK");
        public static final ErrorCode ERRORCODE_DEVICE = new ErrorCode(4, "ERRORCODE_DEVICE");
        public static final ErrorCode ERRORCODE_APP = new ErrorCode(5, "ERRORCODE_APP");
        public static final ErrorCode ERRORCODE_BUSY = new ErrorCode(6, "ERRORCODE_BUSY");
        public static final ErrorCode ERRORCODE_STATE = new ErrorCode(7, "ERRORCODE_STATE");
        public static final ErrorCode ERRORCODE_LAUNCH = new ErrorCode(8, "ERRORCODE_LAUNCH");

        private ErrorCode(int n, String string) {
            super(n, string);
        }

        public static ErrorCode valueOf(int n) {
            switch (n) {
                case 1: {
                    return ERRORCODE_CODING;
                }
                case 2: {
                    return ERRORCODE_SWAP;
                }
                case 3: {
                    return ERRORCODE_USBSTACK;
                }
                case 4: {
                    return ERRORCODE_DEVICE;
                }
                case 5: {
                    return ERRORCODE_APP;
                }
                case 6: {
                    return ERRORCODE_BUSY;
                }
                case 7: {
                    return ERRORCODE_STATE;
                }
                case 8: {
                    return ERRORCODE_LAUNCH;
                }
            }
            return ERRORCODE_UNKNOWN;
        }
    }

    private class SmartphoneIntegrationDSIListener
    implements DSISmartphoneIntegrationListener {
        private static final String LOGCLASS = "SmartphoneIntegrationDSIListener";

        private SmartphoneIntegrationDSIListener() {
        }

        public void updateDiscoveredDevices(final Device[] deviceArray, int n) {
            if (!SmartphoneIntegrationDSILifecycleController.this.isValid(n)) {
                SmartphoneIntegrationDSILifecycleController.this.logger.log(10000000, "<- [%1.updateDiscoveredDevices] Invalid.", (Object)LOGCLASS);
                return;
            }
            SmartphoneIntegrationDSILifecycleController.this.dispatcher.execute(new AbstractDispatcherRunnable("smartphoneIntegrationListener.updateDiscoveredDevices"){

                public void run() {
                    GList<Device> gList = Generics.newArrayList(deviceArray);
                    SmartphoneIntegrationDSILifecycleController.this.logger.log(1000000, "<- [%1.updateDiscoveredDevices] %2", (Object)SmartphoneIntegrationDSIListener.LOGCLASS, (Object)gList.toString());
                    SmartphoneIntegrationDSILifecycleController.this.smiControllerListener.updateDiscoveredDevices(gList);
                }
            });
        }

        public void updateDeviceConnectionState(final int n, final int n2, final int n3, int n4) {
            if (!SmartphoneIntegrationDSILifecycleController.this.isValid(n4)) {
                SmartphoneIntegrationDSILifecycleController.this.logger.log(10000000, "<- [%1.updateDeviceConnectionState] Invalid.", (Object)LOGCLASS);
                return;
            }
            SmartphoneIntegrationDSILifecycleController.this.dispatcher.execute(new AbstractDispatcherRunnable("smartphoneIntegrationListener.updateDeviceConnectionState"){

                public void run() {
                    SmartphoneIntegrationDSILifecycleController.this.logger.log(1000000, "<- [%1.updateDeviceConnectionState] id=%2 %3 %4", (Object)SmartphoneIntegrationDSIListener.LOGCLASS, (Object)Integer.toString(n), (Object)TerminalModeUtils.logConnectionState(n2), (Object)TerminalModeUtils.logConnectionMethod(n3));
                    SmartphoneIntegrationDSILifecycleController.this.smiControllerListener.updateDeviceConnectionState(n, n2, n3);
                }
            });
        }

        public void responseFactorySettings(int n, final boolean bl) {
            SmartphoneIntegrationDSILifecycleController.this.dispatcher.execute(new AbstractDispatcherRunnable("smartphoneIntegrationListener.responseFactorySettings"){

                public void run() {
                    SmartphoneIntegrationDSILifecycleController.this.logger.log(1000000, "<- [%1.responseFactorySettings] success=%2", (Object)SmartphoneIntegrationDSIListener.LOGCLASS, (Object)bl);
                    SmartphoneIntegrationDSILifecycleController.this.smiControllerListener.responseFactorySettings(bl);
                }
            });
        }

        public void updateSWaPStatus(int n, int n2) {
            SmartphoneIntegrationDSILifecycleController.this.logger.log(1000000, "<- [%1.updateSWaPStatus] %2", (Object)LOGCLASS, (long)n);
            if (SmartphoneIntegrationDSILifecycleController.this.isValid(n2) && n >= 2) {
                SmartphoneIntegrationDSILifecycleController.this.startupSyncPoint.completeRequirement(SmartphoneIntegrationDSILifecycleController.SWAPSTATUS_CARPLAY);
            }
        }

        public void asyncException(final int n, String string, int n2) {
            if (n2 == 1003) {
                SmartphoneIntegrationDSILifecycleController.this.dispatcher.execute(new AbstractDispatcherRunnable("smartphoneIntegrationListener.asyncException"){

                    public void run() {
                        SmartphoneIntegrationDSILifecycleController.this.logger.log(1000000, "<- [%1.asyncException] RT_REQUESTFACTORYSETTINGS", (Object)SmartphoneIntegrationDSIListener.LOGCLASS);
                        SmartphoneIntegrationDSILifecycleController.this.smiControllerListener.responseFactorySettings(false);
                    }
                });
            } else if (n2 == 1001) {
                SmartphoneIntegrationDSILifecycleController.this.dispatcher.execute(new AbstractDispatcherRunnable("smartphoneIntegrationListener.asyncException"){

                    public void run() {
                        ErrorCode errorCode = ErrorCode.valueOf(n);
                        SmartphoneIntegrationDSILifecycleController.this.logger.log(1000000, "<- [%1.asyncException] RT_CONNECTDEVICE, %2", (Object)SmartphoneIntegrationDSIListener.LOGCLASS, (Object)errorCode);
                        SmartphoneIntegrationDSILifecycleController.this.smiControllerListener.connectDeviceFailed(SmartphoneIntegrationDSILifecycleController.this.lastSentConnectDeviceId, errorCode);
                    }
                });
            } else {
                SmartphoneIntegrationDSILifecycleController.this.logger.log(1000000, "<- [%1.asyncException] %2, code=%3, RT=%4", (Object)LOGCLASS, (Object)string, (Object)Integer.toString(n), (long)n2);
            }
        }

        public void updateUSBResetActive(final boolean bl, int n) {
            if (SmartphoneIntegrationDSILifecycleController.this.isValid(n)) {
                SmartphoneIntegrationDSILifecycleController.this.dispatcher.execute(new AbstractDispatcherRunnable("smartphoneIntegrationListener.updateUSBResetActive"){

                    public void run() {
                        SmartphoneIntegrationDSILifecycleController.this.logger.log(1000000, "<- [%1.updateUSBResetActive] %2", (Object)SmartphoneIntegrationDSIListener.LOGCLASS, (Object)new Boolean(bl));
                        SmartphoneIntegrationDSILifecycleController.this.updateUSBResetActive(bl);
                    }
                });
            }
        }

        public void updateAppConnectContextRequested(boolean bl, int n) {
        }
    }

    private class SmartphoneIntegrationDSIController
    implements ISmartphoneIntegrationDSIController {
        private SmartphoneIntegrationDSIController() {
        }

        public void connectDevice(int n, SmartphoneManager.SmartphoneType smartphoneType) {
            int n2;
            SmartphoneIntegrationDSILifecycleController.this.lastSentConnectDeviceId = n;
            int n3 = smartphoneType.is(SmartphoneManager.SmartphoneType.CARPLAY) ? 2 : (n2 = smartphoneType.is(SmartphoneManager.SmartphoneType.CARLIFE) ? 32 : 8);
            if (SmartphoneIntegrationDSILifecycleController.this.usbResetActive) {
                SmartphoneIntegrationDSILifecycleController.this.pendingConnectDeviceId = n;
                SmartphoneIntegrationDSILifecycleController.this.pendingConnectMethodId = n2;
            } else {
                SmartphoneIntegrationDSILifecycleController.this.dsiSmartphoneIntegration.connectDevice(n, n2);
            }
        }

        public void disconnectDevice(int n) {
            SmartphoneIntegrationDSILifecycleController.this.dsiSmartphoneIntegration.disconnectDevice(n);
        }

        public void requestFactorySettings() {
            SmartphoneIntegrationDSILifecycleController.this.dsiSmartphoneIntegration.requestFactorySettings(1);
        }
    }
}

