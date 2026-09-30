/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core;

import de.audi.app.connectivity.core.IApplication;
import de.audi.app.wlan.core.client.IConnection;
import de.audi.app.wlan.core.client.IInquiry;
import de.audi.app.wlan.core.client.ITrustedNetworkList;
import de.audi.atip.interapp.WlanService;

public interface IWlanApplication
extends IApplication {
    public static final String MODULE_NAME = "AppWlan";
    public static final String LOGCHANNEL = "App.Wlan.Main";
    public static final String LOGCHANNEL_CMD = "App.Wlan.Commands";

    public IConnection getConnection();

    public IInquiry getInquiry();

    public ITrustedNetworkList getTrustedNetworkList();

    public WlanService getMode();
}

