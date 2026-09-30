/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.smartphoneintegration;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.smartphoneintegration.Device;

public interface DSISmartphoneIntegrationReply {
    public static final String IPL_COMM_UUID = "b66bed86-0446-5574-bf7c-0a212b4857f5";
    public static final String IPL_COMM_INTERFACE_KEY = "c151f367-7bcf-50b9-9845-867e437d0e4f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.9";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.9";

    public void updateDiscoveredDevices(Device[] var1, int var2) throws MethodException;

    public void updateDeviceConnectionState(int var1, int var2, int var3, int var4) throws MethodException;

    public void responseFactorySettings(int var1, boolean var2) throws MethodException;

    public void updateSWaPStatus(int var1, int var2) throws MethodException;

    public void updateUSBResetActive(boolean var1, int var2) throws MethodException;

    public void updateAppConnectContextRequested(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

