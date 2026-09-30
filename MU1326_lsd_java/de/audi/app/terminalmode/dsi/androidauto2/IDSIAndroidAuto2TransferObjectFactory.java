/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.androidauto2;

import org.dsi.ifc.androidauto2.BluetoothServiceAnnouncement;
import org.dsi.ifc.androidauto2.ServiceConfiguration;

public interface IDSIAndroidAuto2TransferObjectFactory {
    public ServiceConfiguration createServiceConfiguration();

    public BluetoothServiceAnnouncement createBluetoothServiceAnnouncement();
}

