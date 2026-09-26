/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.bt.dsi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.bt.dsi.BTDSIController$1;
import de.audi.app.terminalmode.bt.dsi.BTDSIController$2;
import de.audi.app.terminalmode.bt.dsi.IBTDSIControllerListener;
import de.audi.app.terminalmode.bt.dsi.IBTDSIControllerListenerUpdateProvider;
import de.audi.app.terminalmode.dsi.AbstractDSIController;
import de.audi.app.terminalmode.smartphone.BTState;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.atip.log.LogChannel;
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
    private static final String LOGCLASS;
    private final DispatcherBase dispatcher;
    private IBTDSIControllerListener listener;
    private IBTDSIControllerListener nullListener;
    private final IDSISmartphoneManager$ISmartphoneProperties smartphoneProperties;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetooth;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIBluetoothListener;

    public BTDSIController(IContext iContext, IDSISmartphoneManager$ISmartphoneProperties iDSISmartphoneManager$ISmartphoneProperties) {
        super(0, iContext.getServiceManager(), iContext.getFramework(), iContext.getDispatcher(), false, iContext.getLogger().dsi());
        this.smartphoneProperties = iDSISmartphoneManager$ISmartphoneProperties;
        this.dispatcher = iContext.getDispatcher();
        this.listener = this.nullListener = new BTDSIController$1(this);
    }

    @Override
    public void init() {
        this.startDSI();
    }

    @Override
    public void addListener(IBTDSIControllerListener iBTDSIControllerListener) {
        if (null == iBTDSIControllerListener) {
            this.listener = this.nullListener;
        }
        this.listener = iBTDSIControllerListener;
    }

    @Override
    protected Class getDSIServiceClass() {
        return class$org$dsi$ifc$bluetooth$DSIBluetooth == null ? (class$org$dsi$ifc$bluetooth$DSIBluetooth = BTDSIController.class$("org.dsi.ifc.bluetooth.DSIBluetooth")) : class$org$dsi$ifc$bluetooth$DSIBluetooth;
    }

    @Override
    protected DSIListener getDSIListener() {
        return this;
    }

    @Override
    protected Class getDSIListenerClass() {
        return class$org$dsi$ifc$bluetooth$DSIBluetoothListener == null ? (class$org$dsi$ifc$bluetooth$DSIBluetoothListener = BTDSIController.class$("org.dsi.ifc.bluetooth.DSIBluetoothListener")) : class$org$dsi$ifc$bluetooth$DSIBluetoothListener;
    }

    @Override
    protected void addDSIService(DSIBase dSIBase) {
        if (null == dSIBase) {
            return;
        }
        dSIBase.setNotification(3, (DSIListener)this);
    }

    @Override
    protected void removeDSIService() {
    }

    @Override
    public void updateBTState(int n, int n2) {
        if (!this.isValid(n2)) {
            this.logger.log(-2137614336, "<- [%1.updateBTState] Invalid.", (Object)"BTDSIController");
        }
        this.dispatcher.execute(new BTDSIController$2(this, "bluetoothListener.updateBTState", n));
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

    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void responseAbortConnectService(int n) {
    }

    @Override
    public void responseAbortInquiry(int n) {
    }

    @Override
    public void responseAcceptIncomingServiceRequest(int n) {
    }

    @Override
    public void responseConnectService(String string, String string2, int n, int n2, int n3) {
    }

    @Override
    public void responseConnectServiceToInstance(String string, String string2, int n, int n2, int n3) {
    }

    @Override
    public void responseDisconnectService(String string, int n, int n2) {
    }

    @Override
    public void responseGetServices(String string, String string2, int n, int n2) {
    }

    @Override
    public void responseInquiry(int n, int n2) {
    }

    @Override
    public void responsePasskeyResponse(String string, String string2, int n) {
    }

    @Override
    public void responseRemoveAuthentication(String string, String string2, int n) {
    }

    @Override
    public void responseRestoreFactorySettings(int n) {
    }

    @Override
    public void responseSetA2DPUserSetting(int n) {
    }

    @Override
    public void responseSetAccessibleMode(int n) {
    }

    @Override
    public void responseSwitchBTState(int n) {
    }

    @Override
    public void removeAuthenticationNoSupport(String string, String string2) {
    }

    @Override
    public void updateAccessibleMode(int n, boolean bl, int n2) {
    }

    @Override
    public void updateDiscoveredDevices(DiscoveredDevice discoveredDevice, int n) {
    }

    @Override
    public void updateHUCandBTHSState(int n, int n2) {
    }

    @Override
    public void updateIncomingServiceRequest(RequestIncomingService requestIncomingService, int n) {
    }

    @Override
    public void updateMasterRoleRequestError(MasterRoleRequestStruct masterRoleRequestStruct, int n) {
    }

    @Override
    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
    }

    @Override
    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
    }

    @Override
    public void updateServiceRequestState(ServiceRequestStateStruct serviceRequestStateStruct, int n) {
    }

    @Override
    public void updateSupportedBTProfiles(int n, int n2) {
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
    }

    @Override
    public void updateUserFriendlyName(String string, int n) {
    }

    @Override
    public void updateA2DPUserSetting(boolean bl, int n) {
    }

    @Override
    public void updatePriorizedDeviceReconnect(boolean bl, String string, int n) {
    }

    @Override
    public void deviceDisonnectionInfo(String string, String string2, int n) {
    }

    @Override
    public void serviceRejectNoSupport(String string, String string2) {
    }

    @Override
    public void responseReconnectSuspend(int n) {
    }

    @Override
    public void responseSetPriorizedDeviceReconnect(int n) {
    }

    static /* synthetic */ LogChannel access$000(BTDSIController bTDSIController) {
        return bTDSIController.logger;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$100(BTDSIController bTDSIController) {
        return bTDSIController.logger;
    }

    static /* synthetic */ int access$200(BTDSIController bTDSIController, int n) {
        return bTDSIController.mapDSI2TMState(n);
    }

    static /* synthetic */ IBTDSIControllerListener access$300(BTDSIController bTDSIController) {
        return bTDSIController.listener;
    }

    static /* synthetic */ BTState access$400(BTDSIController bTDSIController, int n) {
        return bTDSIController.mapDSI2BTState(n);
    }

    static /* synthetic */ IDSISmartphoneManager$ISmartphoneProperties access$500(BTDSIController bTDSIController) {
        return bTDSIController.smartphoneProperties;
    }
}

