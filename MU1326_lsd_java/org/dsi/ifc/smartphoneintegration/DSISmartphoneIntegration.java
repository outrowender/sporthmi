/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.smartphoneintegration;

import org.dsi.ifc.base.DSIBase;

public interface DSISmartphoneIntegration
extends DSIBase {
    public static final String VERSION = "2.11.9";
    public static final int ATTR_DISCOVEREDDEVICES = 1;
    public static final int ATTR_DEVICECONNECTIONSTATE = 2;
    public static final int ATTR_SWAPSTATUS = 3;
    public static final int ATTR_USBRESETACTIVE = 4;
    public static final int ATTR_APPCONNECTCONTEXTREQUESTED = 5;
    public static final int RT_CONNECTDEVICE = 1001;
    public static final int RT_DISCONNECTDEVICE = 1002;
    public static final int RT_REQUESTFACTORYSETTINGS = 1003;
    public static final int RT_REQUESTAPPCONNECTCONTEXTACTIVE = 1004;
    public static final int RP_RESPONSEFACTORYSETTINGS = 2001;

    public void connectDevice(int var1, int var2);

    public void disconnectDevice(int var1);

    public void requestFactorySettings(int var1);

    public void requestAppConnectContextActive(boolean var1);
}

