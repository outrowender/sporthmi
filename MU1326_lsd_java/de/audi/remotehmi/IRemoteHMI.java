/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.RemoteHMIAction;

public interface IRemoteHMI {
    public static final String VERSION = "1.2.0";
    public static final int STATUS_OK = 0;
    public static final int ERROR_SERVER_NOT_AVAILABLE = 1000;
    public static final int ERROR_UNSPECIFIED = 9000;
    public static final int PERSISTENCE_CACHE_DB = 1;
    public static final String ROOT_CONTEXT = "top_wizard";

    public void setContext(String var1);

    public void stop();

    public void action(String var1, RemoteHMIAction var2);

    public String getServiceAdapterVersion();

    public void setHMILanguage(String var1);

    public void resetToFactorySettings();

    public String[] requestPosInfoAsia();
}

