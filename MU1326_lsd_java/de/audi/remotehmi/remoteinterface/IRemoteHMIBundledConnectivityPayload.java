/*
 * Decompiled with CFR 0.152.
 */
package de.audi.remotehmi.remoteinterface;

public interface IRemoteHMIBundledConnectivityPayload {
    public int getPopupServiceType();

    public String getServiceId();

    public String getServiceContext();

    public void setAppServiceType(int var1);

    public int getAppServiceType();
}

