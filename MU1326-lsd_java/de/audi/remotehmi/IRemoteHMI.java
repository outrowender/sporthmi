/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi;

import de.audi.remotehmi.RemoteHMIAction;

public interface IRemoteHMI {
    public static final String VERSION;
    public static final int STATUS_OK;
    public static final int ERROR_SERVER_NOT_AVAILABLE;
    public static final int ERROR_UNSPECIFIED;
    public static final int PERSISTENCE_CACHE_DB;
    public static final String ROOT_CONTEXT;

    default public void setContext(String string) {
    }

    default public void stop() {
    }

    default public void action(String string, RemoteHMIAction remoteHMIAction) {
    }

    default public String getServiceAdapterVersion() {
    }

    default public void setHMILanguage(String string) {
    }

    default public void resetToFactorySettings() {
    }

    default public String[] requestPosInfoAsia() {
    }
}

