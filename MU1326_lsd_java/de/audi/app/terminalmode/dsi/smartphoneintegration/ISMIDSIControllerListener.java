/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.smartphoneintegration;

import de.audi.app.terminalmode.dsi.smartphoneintegration.SmartphoneIntegrationDSILifecycleController;
import de.audi.atip.utils.generics.GList;
import org.dsi.ifc.smartphoneintegration.Device;

/*
 * This class specifies class file version 49.0 but uses Java 6 signatures.  Assumed Java 6.
 */
public interface ISMIDSIControllerListener {
    public void updateDiscoveredDevices(GList<Device> var1);

    public void updateDeviceConnectionState(int var1, int var2, int var3);

    public void responseFactorySettings(boolean var1);

    public void connectDeviceFailed(int var1, SmartphoneIntegrationDSILifecycleController.ErrorCode var2);
}

