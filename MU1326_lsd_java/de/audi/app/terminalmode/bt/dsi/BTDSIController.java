/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.bt.dsi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.bt.dsi.IBTDSIControllerListener;
import de.audi.app.terminalmode.bt.dsi.IBTDSIControllerListenerUpdateProvider;
import de.audi.app.terminalmode.dsi.AbstractDSIController;
import de.audi.app.terminalmode.dsi.AbstractDispatcherRunnable;
import de.audi.app.terminalmode.smartphone.BTState;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.bluetooth.DSIBluetoothListener;
import org.dsi.ifc.bluetooth.DiscoveredDevice;
import org.dsi.ifc.bluetooth.MasterRoleRequestStruct;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.RequestIncomingService;
import org.dsi.ifc.bluetooth.ServiceRequestStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class BTDSIController
extends AbstractDSIController
implements DSIBluetoothListener,
IBTDSIControllerListenerUpdateProvider,
ITerminalModeComponent {
    private static final String LOGCLASS = "BTDSIController";
    private final DispatcherBase dispatcher;
    private IBTDSIControllerListener listener;
    private IBTDSIControllerListener nullListener;
    private final IDSISmartphoneManager.ISmartphoneProperties smartphoneProperties;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;

    public BTDSIController(IContext iContext, IDSISmartphoneManager.ISmartphoneProperties iSmartphoneProperties) {
        super(0, iContext.getServiceManager(), iContext.getFramework(), iContext.getDispatcher(), false, iContext.getLogger().dsi());
        this.smartphoneProperties = iSmartphoneProperties;
        this.dispatcher = iContext.getDispatcher();
        this.listener = this.nullListener = new IBTDSIControllerListener(){

            public void updateBTState(int n) {
                BTDSIController.this.logger.log(1000000, "[NullBTDSIControllerListener.updateBTState]");
            }
        };
    }

    public void init() {
        this.startDSI();
    }

    public void addListener(IBTDSIControllerListener iBTDSIControllerListener) {
        if (null == iBTDSIControllerListener) {
            this.listener = this.nullListener;
        }
        this.listener = iBTDSIControllerListener;
    }

    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = BTDSIController.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth;
    }

    protected DSIListener getDSIListener() {
        return this;
    }

    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = BTDSIController.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener;
    }

    protected void addDSIService(DSIBase dSIBase) {
        if (null == dSIBase) {
            return;
        }
        dSIBase.setNotification(3, (DSIListener)this);
    }

    protected void removeDSIService() {
    }

    public void updateBTState(final int n, int n2) {
        if (!this.isValid(n2)) {
            this.logger.log(10000000, "<- [%1.updateBTState] Invalid.", (Object)LOGCLASS);
        }
        this.dispatcher.execute(new AbstractDispatcherRunnable("bluetoothListener.updateBTState"){

            public void run() {
                BTDSIController.this.logger.log(1000000, "<- [%1.updateBTState] bTState=%2", (Object)BTDSIController.LOGCLASS, (long)n);
                int n2 = BTDSIController.this.mapDSI2TMState(n);
                if (0 != n2) {
                    BTDSIController.this.listener.updateBTState(n2);
                }
                BTDSIController.this.smartphoneProperties.getPropertyBluetooth().accept(BTDSIController.this.mapDSI2BTState(n));
            }
        });
    }

    private int mapDSI2TMState(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 0: {
                return 2;
            }
        }
        return 0;
    }

    private BTState mapDSI2BTState(int n) {
        switch (n) {
            case 1: {
                return BTState.OFF;
            }
            case 0: {
                return BTState.ON;
            }
        }
        return BTState.UNKNOWN;
    }

    public void asyncException(int n, String string, int n2) {
    }

    public void responseAbortConnectService(int n) {
    }

    public void responseAbortInquiry(int n) {
    }

    public void responseAcceptIncomingServiceRequest(int n) {
    }

    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
    }

    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
    }

    public void responseDisconnectService(String string, int n, int n2) {
    }

    public void responseGetServices(String string, String string2, int n, int n2) {
    }

    public void responseInquiry(int n, int n2) {
    }

    public void responsePasskeyResponse(String string, String string2, int n) {
    }

    public void responseRemoveAuthentication(String string, String string2, int n) {
    }

    public void responseRestoreFactorySettings(int n) {
    }

    public void responseSetA2DPUserSetting(int n) {
    }

    public void responseSetAccessibleMode(int n) {
    }

    public void responseSwitchBTState(int n) {
    }

    public void removeAuthenticationNoSupport(String string, String string2) {
    }

    public void updateAccessibleMode(int n, boolean bl, int n2) {
    }

    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
    }

    public void updateHUCandBTHSState(int n, int n2) {
    }

    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
    }

    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
    }

    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
    }

    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
    }

    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
    }

    public void updateSupportedBTProfiles(int n, int n2) {
    }

    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
    }

    public void updateUserFriendlyName(String string, int n) {
    }

    public void updateA2DPUserSetting(boolean bl, int n) {
    }

    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
    }

    public void deviceDisonnectionInfo(String string, String string2, int n) {
    }

    public void serviceRejectNoSupport(String string, String string2) {
    }

    public void responseReconnectSuspend(int n) {
    }

    public void responseSetPriorizedDeviceReconnect(int n) {
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

