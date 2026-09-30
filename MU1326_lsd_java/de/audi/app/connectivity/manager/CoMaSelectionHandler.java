/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.connectivity.IDiagComponent
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.IEvoConnectivity;
import de.audi.app.connectivity.core.common.CommandSetNadRole;
import de.audi.app.connectivity.core.common.CommandTogglePhones;
import de.audi.app.connectivity.manager.CoMaRemoteHMIProxy;
import de.audi.app.connectivity.manager.ConnectivityManager;
import de.audi.app.connectivity.manager.ISelectionHandler;
import de.audi.app.connectivity.manager.TerminalModeProxy;
import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.app.connectivity.manager.contents.IDeviceSelection;
import de.audi.app.wlan.core.client.Network;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.SDISConnectionStateListener;
import de.audi.atip.log.LogChannel;
import de.mib.swdiagnosis.connectivity.IDiagComponent;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

class CoMaSelectionHandler
implements ISelectionHandler,
SDISConnectionStateListener {
    private static final int ASK_FOR_CONNECTION_BLUE = 1;
    private static final int ASK_FOR_CONNECTION_WLAN = 2;
    private static final int ASK_FOR_CONNECTION_BLUE_AND_WLAN_DATA = 4;
    private static final int SELECTION_BLUE_CONNECT = 0;
    private static final int SELECTION_BLUE_DISCONNECT = 1;
    private static final int SELECTION_BLUE_CHANGE = 2;
    private static final int SELECTION_NEW_DEVICE = 3;
    private static final int SELECTION_WLAN_CONNECT = 4;
    private static final int SELECTION_WLAN_DISCONNECT = 5;
    private static final int SELECTION_OTHER = 7;
    private volatile boolean isSdisConnected;
    private ServiceRegistration sdisConStateListenerRegistration;
    private final IEvoConnectivity connectivity;
    private final LogChannel log;
    private final IHMIServiceApp hmiService;
    private final CoMaRemoteHMIProxy rhmi;
    private final TerminalModeProxy smartphoneProxy;
    private ConnectivityManager coma;
    private final ChoiceModelApp comaDeviceSelected;
    private final ChoiceModelApp askForConnectionType;
    private boolean isDataDeviceChange = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDISConnectionStateListener;

    private static final int getServiceClassFromCategory(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 0;
                break;
            }
            case 5: {
                n2 = 0;
                break;
            }
            case 1: {
                n2 = 1;
                break;
            }
            case 3: {
                n2 = 3;
                break;
            }
            case 4: {
                n2 = 4;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    private static final boolean isPhone(TrustedDevice trustedDevice) {
        return (trustedDevice.getActiveServiceTypes() & 6) > 0;
    }

    CoMaSelectionHandler(IFrameworkAccess iFrameworkAccess, BundleContext bundleContext, IEvoConnectivity iEvoConnectivity, TerminalModeProxy terminalModeProxy, ConnectivityManager connectivityManager) {
        this.connectivity = iEvoConnectivity;
        this.log = iFrameworkAccess.getLogChannel("App.Connectivity.Main");
        this.hmiService = iFrameworkAccess.getHmiServiceApp();
        this.rhmi = new CoMaRemoteHMIProxy(bundleContext, this.log);
        this.smartphoneProxy = terminalModeProxy;
        this.coma = connectivityManager;
        this.comaDeviceSelected = this.hmiService.getChoiceModel(0x262622);
        this.askForConnectionType = this.hmiService.getChoiceModel(0x262623);
        iEvoConnectivity.getDiagnosis().addDiagnosisComponent(new IDiagComponent(){

            public void cmdComaSelectionHandlerEnableSDISConnection() {
                CoMaSelectionHandler.this.updateSdisConnected(true);
            }

            public void cmdComaSelectionHandlerDisableSDISConnection() {
                CoMaSelectionHandler.this.updateSdisConnected(false);
            }
        });
    }

    void responseConnectService(int n, int n2) {
        this.log.log(1000000, "CoMaSelectionHandler#responseConnectService(): requestedService=%1, connected=%2", (long)n, (long)n2);
        if (this.isDataDeviceChange && n == 4) {
            if (n == n2) {
                this.connectivity.getWlan().getMode().switchWlanState(true);
            } else {
                this.comaDeviceSelected.setValue(0);
            }
        }
    }

    public void deviceSelected(IDeviceSelection iDeviceSelection, int n) {
        this.log.log(1000000, "CoMaSelectionHandler#deviceSelected(): %2 %3, connected:%1", iDeviceSelection.isConnected(), (Object)iDeviceSelection.getName(), (Object)iDeviceSelection.getDeviceIdentifier());
        switch (iDeviceSelection.getType()) {
            case 0: {
                this.simSelected(iDeviceSelection, n);
                break;
            }
            case 1: {
                this.blueDeviceSelected(iDeviceSelection.getDeviceIdentifier(), n, iDeviceSelection.isConnected());
                break;
            }
            case 2: {
                this.wlanDeviceSelected(iDeviceSelection.getDeviceIdentifier());
                break;
            }
            case 7: {
                this.smartphoneSelected(iDeviceSelection.getDeviceIdentifier(), iDeviceSelection.isConnected());
                break;
            }
            case 4: {
                this.rhmiDeviceSelected(iDeviceSelection.getDeviceIdentifier(), iDeviceSelection.isConnected());
                break;
            }
            case 3: {
                this.upnpDeviceSelected();
                break;
            }
            default: {
                this.log.log(10000, "CoMaSelectionHandler#deviceSelected(): Device type unknown: %1", (long)iDeviceSelection.getType());
            }
        }
    }

    private void simSelected(IDeviceSelection iDeviceSelection, int n) {
        boolean bl = iDeviceSelection.isConnected();
        this.log.log(1000000, "CoMaSelectionHandler#simSelected(): isConnected=%1", bl);
        this.comaDeviceSelected.setValue(7);
        if (bl) {
            this.log.log(10000000, "CoMaSelectionHandler#simSelected(): NAD mode downgrade");
            CommandSetNadRole.schedule(this.connectivity.getBluetooth().getCommandListManager(), this.log, this.connectivity.getPhone(), 2);
        } else {
            AbstractCoMaDevice abstractCoMaDevice = this.coma.getSim();
            if (abstractCoMaDevice != null && abstractCoMaDevice.isConnected(3)) {
                this.log.log(10000000, "CoMaSelectionHandler#simSelected(): toggle phone roles");
                CommandTogglePhones.schedule(this.connectivity.getBluetooth().getCommandListManager(), this.log, this.connectivity.getPhone());
            } else {
                this.log.log(10000000, "CoMaSelectionHandler#simSelected(): NAD mode upgrade (via setNadRole)");
                this.coma.initNadModeUpgrade();
                CommandSetNadRole.schedule(this.connectivity.getBluetooth().getCommandListManager(), this.log, this.connectivity.getPhone(), n == 0 ? 0 : 1);
            }
        }
    }

    private void blueDeviceSelected(String string, int n, boolean bl) {
        TrustedDevice trustedDevice = this.connectivity.getBluetooth().getTrustedDeviceList().get(string);
        if (trustedDevice != null) {
            int n2 = CoMaSelectionHandler.getServiceClassFromCategory(n);
            int n3 = this.connectivity.getBluetooth().getSupportedBtProfiles().getConnectableServices(n2, n == 0);
            int n4 = trustedDevice.getOfferedServiceTypes() & n3;
            if (bl) {
                this.log.log(1000000, "CoMaSelectionHandler#blueDeviceSelected(): Disconnecting category %1", (long)n);
                this.comaDeviceSelected.setValue(1);
                this.connectivity.getBluetooth().getConnection().disconnectService(string, trustedDevice.getActiveServiceTypes() & n4);
            } else if (this.isPhoneSelectedForOtherRole(trustedDevice, n)) {
                this.log.log(1000000, "CoMaSelectionHandler#blueDeviceSelected(): Toggling phone roles");
                this.comaDeviceSelected.setValue(7);
                CommandTogglePhones.schedule(this.connectivity.getBluetooth().getCommandListManager(), this.log, this.connectivity.getPhone());
            } else {
                this.log.log(1000000, "CoMaSelectionHandler#blueDeviceSelected(): Connecting category %1, service %2", (long)n, (long)n4);
                if (n2 == 1) {
                    this.isDataDeviceChange = true;
                    this.comaDeviceSelected.setValue(2);
                } else {
                    this.isDataDeviceChange = false;
                    this.comaDeviceSelected.setValue(0);
                }
                boolean bl2 = n == 0 || n == 1;
                this.connectivity.getBluetooth().getConnection().connectService(string, n4, trustedDevice.getDeviceName(), bl2, false);
            }
        } else {
            this.log.log(10000, "CoMaSelectionHandler#blueDeviceSelected(): Trying to select device that does not exist into the trusted device list!!! address=%1", (Object)string);
        }
    }

    private boolean isPhoneSelectedForOtherRole(TrustedDevice trustedDevice, int n) {
        return CoMaSelectionHandler.isPhone(trustedDevice) && (n == 0 && trustedDevice.getDeviceRole() == 2 || n == 5 && trustedDevice.getDeviceRole() == 1);
    }

    private void wlanDeviceSelected(String string) {
        Network network = this.connectivity.getWlan().getTrustedNetworkList().getNetwork(string);
        if (network.isActive()) {
            this.log.log(1000000, "CoMaSelectionHandler#wlanDeviceSelected(): Disconnecting from WLAN hotspot %1", (Object)network);
            this.comaDeviceSelected.setValue(5);
            this.connectivity.getWlan().getConnection().disconnectNetwork(network.getNetworkName(), network.getBssidAddress());
        } else {
            this.log.log(1000000, "CoMaSelectionHandler#wlanDeviceSelected(): Connecting to WLAN hotspot %1", (Object)network);
            this.comaDeviceSelected.setValue(4);
            this.connectivity.getWlan().getConnection().connectNetwork(network);
        }
    }

    private void rhmiDeviceSelected(String string, boolean bl) {
        this.log.log(1000000, "CoMaSelectionHandler#rhmiDeviceSelected(): %2, currently connected=%1", bl, (Object)string);
        this.comaDeviceSelected.setValue(7);
        if (bl) {
            this.rhmi.disconnectAppServer(string);
        } else {
            this.rhmi.connectAppServer(string);
        }
    }

    private void smartphoneSelected(String string, boolean bl) {
        this.log.log(1000000, "CoMaSelectionHandler#smartphoneSelected(): %2, currently active=%1", bl, (Object)string);
        this.comaDeviceSelected.setValue(7);
        if (bl) {
            this.smartphoneProxy.deactivateSmartphone(string);
        } else {
            this.smartphoneProxy.activateSmartphone(string);
        }
    }

    private void upnpDeviceSelected() {
        this.log.log(1000000, "CoMaSelectionHandler#upnpDeviceSelected(): Doing nothing");
        this.comaDeviceSelected.setValue(7);
    }

    public void connectNewDeviceSelected(int n) {
        int n2;
        this.log.log(1000000, "CoMaSelectionHandler#connectNewDeviceSelected(): Service type %1", (long)n);
        boolean bl = true;
        switch (n) {
            case 16: {
                this.askForConnectionType.setValue(1);
                n2 = 3;
                break;
            }
            case 8: {
                this.askForConnectionType.setValue(2);
                n2 = 2;
                break;
            }
            case 1: 
            case 3: {
                this.askForConnectionType.setValue(1);
                n2 = 0;
                bl = true;
                break;
            }
            case 2: {
                this.askForConnectionType.setValue(1);
                n2 = 0;
                bl = false;
                break;
            }
            case 4: {
                this.askForConnectionType.setValue(this.isTetheringConnectionAllowed() ? 4 : 1);
                n2 = 1;
                break;
            }
            case 32: {
                this.askForConnectionType.setValue(1);
                n2 = 4;
                break;
            }
            case 128: {
                this.askForConnectionType.setValue(2);
                n2 = 5;
                break;
            }
            default: {
                this.askForConnectionType.setValue(1);
                n2 = 4;
            }
        }
        int n3 = this.connectivity.getBluetooth().getSupportedBtProfiles().getConnectableServices(n2, bl);
        this.connectivity.getBluetooth().getEvoInquiry().prepareServiceSpecificInquiry(n3, bl);
        this.comaDeviceSelected.setValue(3);
    }

    private boolean isTetheringConnectionAllowed() {
        return this.coma.isWifi() && !this.coma.isEsimAlwaysAvailable() && !this.coma.isSimOrRsapAvailable() && !this.isSdisConnected;
    }

    void init() {
        this.rhmi.init();
        this.sdisConStateListenerRegistration = this.coma.getBundleContext().registerService((class$de$audi$atip$interapp$SDISConnectionStateListener == null ? (class$de$audi$atip$interapp$SDISConnectionStateListener = CoMaSelectionHandler.class$("de.audi.atip.interapp.SDISConnectionStateListener")) : class$de$audi$atip$interapp$SDISConnectionStateListener).getName(), (Object)this, null);
    }

    void deinit() {
        this.rhmi.deinit();
        this.sdisConStateListenerRegistration.unregister();
        this.sdisConStateListenerRegistration = null;
    }

    public void updateSdisConnected(boolean bl) {
        this.log.log(1000000, "CoMaSelectionHandler#updateSdisConnected(): isSdis connected = %1", bl);
        this.isSdisConnected = bl;
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

