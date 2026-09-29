/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo;

import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.connectivity.reconnect.IPrioReconnect;
import de.audi.app.bluetooth.core.online.IConnectAppSetup;
import de.audi.app.bluetooth.evo.connectivity.search.IEvoInquiry;
import de.audi.app.bluetooth.evo.connectivity.trusted.IEvoTrustedDeviceList;
import de.audi.app.connectivity.IEvoConnectivity;

public interface IEvoBluetoothApplication
extends IBluetoothApplication {
    default public IEvoConnectivity getConnectivity() {
    }

    default public IEvoInquiry getEvoInquiry() {
    }

    default public IConnectAppSetup getAudiConnectSetup() {
    }

    default public IEvoTrustedDeviceList getEvoTrustedDeviceList() {
    }

    default public IPrioReconnect getPrioReconnect() {
    }
}

