/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.smartphoneintegration;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.smartphoneintegration.Device;

public interface DSISmartphoneIntegrationListener
extends DSIListener {
    public void updateDiscoveredDevices(Device[] var1, int var2);

    public void updateDeviceConnectionState(int var1, int var2, int var3, int var4);

    public void responseFactorySettings(int var1, boolean var2);

    public void updateSWaPStatus(int var1, int var2);

    public void updateUSBResetActive(boolean var1, int var2);

    public void updateAppConnectContextRequested(boolean var1, int var2);
}

