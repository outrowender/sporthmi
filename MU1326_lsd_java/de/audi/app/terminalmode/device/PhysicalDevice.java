/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import org.dsi.ifc.smartphoneintegration.Device;

public class PhysicalDevice {
    private final Device device;
    private final GMap<TMDeviceControl, ConnectState> deviceControlMap;
    private final ISmartphoneIntegrationDSIController dsiController;
    private static final ConnectState NO_INFO_AVAILABLE = new ConnectState();
    private static final ConnectState CONNECTED = new ConnectState(Boolean.TRUE);
    private static final ConnectState DISCONNECTED = new ConnectState(Boolean.FALSE);

    public PhysicalDevice(Device device, ISmartphoneIntegrationDSIController iSmartphoneIntegrationDSIController) {
        this.device = device;
        this.deviceControlMap = Generics.newHashMapWithCapacity(2);
        this.dsiController = iSmartphoneIntegrationDSIController;
    }

    public void addTMDeviceControl(TMDeviceControl tMDeviceControl) {
        this.deviceControlMap.put(tMDeviceControl, NO_INFO_AVAILABLE);
    }

    public Device getDevice() {
        return this.device;
    }

    public boolean disconnectDevice(TMDeviceControl tMDeviceControl) {
        this.deviceControlMap.put(tMDeviceControl, DISCONNECTED);
        boolean bl = true;
        GIterator<ConnectState> gIterator = this.deviceControlMap.values().iterator();
        while (gIterator.hasNext()) {
            if (!gIterator.next().isConnected()) continue;
            bl = false;
            break;
        }
        if (bl) {
            this.dsiController.disconnectDevice(this.device.deviceID);
        }
        return bl;
    }

    public void connectDevice(TMDeviceControl tMDeviceControl) {
        this.deviceControlMap.put(tMDeviceControl, CONNECTED);
    }

    public String toString() {
        return new StringBuffer().append("PhysicalDevice [device=").append(this.device).append("]").toString();
    }

    private static class ConnectState {
        private final Boolean connected;

        public ConnectState() {
            this.connected = null;
        }

        public ConnectState(Boolean bl) {
            this.connected = bl;
        }

        public boolean isConnectStateAvailable() {
            return null != this.connected;
        }

        public boolean isConnected() {
            return null == this.connected || this.connected != false;
        }
    }
}

