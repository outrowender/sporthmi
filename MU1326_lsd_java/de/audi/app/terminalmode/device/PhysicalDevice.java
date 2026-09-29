/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GMap
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.PhysicalDevice$ConnectState;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GMap;
import de.audi.atip.utils.generics.Generics;
import org.dsi.ifc.smartphoneintegration.Device;

public class PhysicalDevice {
    private final Device device;
    private final GMap deviceControlMap;
    private final ISmartphoneIntegrationDSIController dsiController;
    private static final PhysicalDevice$ConnectState NO_INFO_AVAILABLE = new PhysicalDevice$ConnectState();
    private static final PhysicalDevice$ConnectState CONNECTED = new PhysicalDevice$ConnectState(Boolean.TRUE);
    private static final PhysicalDevice$ConnectState DISCONNECTED = new PhysicalDevice$ConnectState(Boolean.FALSE);

    public PhysicalDevice(Device device, ISmartphoneIntegrationDSIController iSmartphoneIntegrationDSIController) {
        this.device = device;
        this.deviceControlMap = Generics.newHashMapWithCapacity((int)2);
        this.dsiController = iSmartphoneIntegrationDSIController;
    }

    public void addTMDeviceControl(TMDeviceControl tMDeviceControl) {
        this.deviceControlMap.put((Object)tMDeviceControl, (Object)NO_INFO_AVAILABLE);
    }

    public Device getDevice() {
        return this.device;
    }

    public boolean disconnectDevice(TMDeviceControl tMDeviceControl) {
        this.deviceControlMap.put((Object)tMDeviceControl, (Object)DISCONNECTED);
        boolean bl = true;
        GIterator gIterator = this.deviceControlMap.values().iterator();
        while (gIterator.hasNext()) {
            if (!((PhysicalDevice$ConnectState)gIterator.next()).isConnected()) continue;
            bl = false;
            break;
        }
        if (bl) {
            this.dsiController.disconnectDevice(this.device.deviceID);
        }
        return bl;
    }

    public void connectDevice(TMDeviceControl tMDeviceControl) {
        this.deviceControlMap.put((Object)tMDeviceControl, (Object)CONNECTED);
    }

    public String toString() {
        return new StringBuffer().append("PhysicalDevice [device=").append(this.device).append("]").toString();
    }
}

