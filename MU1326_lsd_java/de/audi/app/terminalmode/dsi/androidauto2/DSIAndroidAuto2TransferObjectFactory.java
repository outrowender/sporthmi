/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.androidauto2;

import de.audi.app.terminalmode.dsi.androidauto2.IDSIAndroidAuto2TransferObjectFactory;
import org.dsi.ifc.androidauto2.BluetoothServiceAnnouncement;
import org.dsi.ifc.androidauto2.ServiceConfiguration;

public class DSIAndroidAuto2TransferObjectFactory
implements IDSIAndroidAuto2TransferObjectFactory {
    public ServiceConfiguration createServiceConfiguration() {
        return new ServiceConfiguration();
    }

    public BluetoothServiceAnnouncement createBluetoothServiceAnnouncement() {
        return new BluetoothServiceAnnouncement();
    }
}

