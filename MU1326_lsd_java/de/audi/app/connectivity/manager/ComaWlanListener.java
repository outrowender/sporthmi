/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager;

import de.audi.app.connectivity.core.AbstractApplicationComponent;
import de.audi.app.connectivity.manager.ConnectivityManager;
import de.audi.app.connectivity.manager.contents.CoMaDeviceWlan;
import de.audi.app.wlan.core.client.Network;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import de.audi.atip.interapp.SDISConnectionStateListener;
import de.audi.atip.interapp.phone.ITelMESlotState;
import de.esolutions.fw.util.commons.StringUtils;
import java.util.ArrayList;
import org.osgi.framework.ServiceRegistration;

public class ComaWlanListener
extends AbstractApplicationComponent
implements IConnectivityPhoneStateListener,
SDISConnectionStateListener {
    private final ConnectivityManager coma;
    private ServiceRegistration registration;
    private volatile Network[] networks = new Network[0];
    private volatile boolean isDataUsedByNAD;
    private volatile boolean isSdisConnected;
    private ServiceRegistration sdisConStateListenerRegistration;
    static /* synthetic */ Class class$de$audi$atip$interapp$IConnectivityPhoneStateListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDISConnectionStateListener;

    ComaWlanListener(ConnectivityManager connectivityManager) {
        super(connectivityManager);
        this.coma = connectivityManager;
    }

    private synchronized void update() {
        ArrayList arrayList = new ArrayList(this.networks.length);
        int n = this.isDataUsedByNAD || this.isSdisConnected ? 0 : 4;
        for (int i2 = 0; i2 < this.networks.length; ++i2) {
            Network network = this.networks[i2];
            int n2 = network.isActive() ? n : 0;
            CoMaDeviceWlan coMaDeviceWlan = new CoMaDeviceWlan(4, n2, n, network.getNetworkName(), network.getBssidAddress());
            arrayList.add(coMaDeviceWlan);
        }
        this.coma.updateWlanDevices(arrayList);
    }

    void updateTrustedWlanNetworks(Network[] networkArray) {
        if (networkArray == null) {
            return;
        }
        this.log.log(1078071040, "ComaWlanListener#updateTrustedWlanNetworks(): %1", (Object)StringUtils.toString(networkArray));
        this.networks = networkArray;
        this.update();
    }

    @Override
    public void updateMESlotInfo(ITelMESlotState iTelMESlotState, ITelMESlotState iTelMESlotState2, ITelMESlotState iTelMESlotState3) {
        this.log.log(-2137614336, "ComaWlanListener#updateMESlotInfo(): %1", (Object)iTelMESlotState3);
        this.isDataUsedByNAD = iTelMESlotState3 != null && iTelMESlotState3.isDevicePossiblyAvailable();
        this.log.log(-2137614336, "ComaWlanListener#updateMESlotInfo(): %1", this.isDataUsedByNAD);
        this.update();
    }

    @Override
    public void updatePhoneState(int n, int n2) {
    }

    @Override
    public void updateESIMInfo(String string, String string2, boolean bl, boolean bl2) {
    }

    @Override
    public void telAppEntered() {
    }

    @Override
    public void telAppLeft() {
    }

    @Override
    public void telUnlockEntered() {
    }

    @Override
    public void telUnlockLeft() {
    }

    @Override
    public void updateConnectedGatewayState(boolean bl) {
    }

    @Override
    public void init() {
        this.registration = this.coma.getBundleContext().registerService((class$de$audi$atip$interapp$IConnectivityPhoneStateListener == null ? (class$de$audi$atip$interapp$IConnectivityPhoneStateListener = ComaWlanListener.class$("de.audi.atip.interapp.IConnectivityPhoneStateListener")) : class$de$audi$atip$interapp$IConnectivityPhoneStateListener).getName(), (Object)this, null);
        this.sdisConStateListenerRegistration = this.coma.getBundleContext().registerService((class$de$audi$atip$interapp$SDISConnectionStateListener == null ? (class$de$audi$atip$interapp$SDISConnectionStateListener = ComaWlanListener.class$("de.audi.atip.interapp.SDISConnectionStateListener")) : class$de$audi$atip$interapp$SDISConnectionStateListener).getName(), (Object)this, null);
    }

    @Override
    public void deinit() {
        this.registration.unregister();
        this.registration = null;
        this.sdisConStateListenerRegistration.unregister();
        this.sdisConStateListenerRegistration = null;
    }

    @Override
    public void updateSdisConnected(boolean bl) {
        this.log.log(1078071040, "ComaWlanListener#updateSdisConnected(): isSdis connected = %1", bl);
        this.isSdisConnected = bl;
        this.update();
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

