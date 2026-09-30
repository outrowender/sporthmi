/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.OAuthToken;
import de.esolutions.fw.comm.asi.online.coreservice.Result;
import de.esolutions.fw.comm.asi.online.coreservice.ServiceListEntry;
import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public interface ExtOnlineCoreServiceReply {
    public static final String IPL_COMM_UUID = "5bb8eff1-90a0-11e2-9e96-0800200c9a66";
    public static final String IPL_COMM_INTERFACE_KEY = "ffcc1b5d-eaea-5a1c-86e3-def3e28eb53d";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.9";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void initResponse(int var1) throws MethodException;

    public void registerServiceResponse(int var1) throws MethodException;

    public void enableApplication() throws MethodException;

    public void disableApplication() throws MethodException;

    public void getServiceListEntryResponse(int var1, ServiceListEntry var2) throws MethodException;

    public void updateApplicationState(OSRNotifyProperties[] var1) throws MethodException;

    public void updateServices(OSRNotifyPropertiesSL[] var1) throws MethodException;

    public void updateServiceState(int var1) throws MethodException;

    public void precheckOnlineServiceServiceIDResponse(OSRServiceState var1) throws MethodException;

    public void precheckOnlineServiceResponse(OSRServiceState[] var1) throws MethodException;

    public void keyStoreChanged() throws MethodException;

    public void updateLoggedInUser(OSRUser var1, int var2) throws MethodException;

    public void getTokenResponse(int var1, OAuthToken var2, String var3) throws MethodException;

    public void onlineResponse(int var1, KeyValPair[] var2) throws MethodException;

    public void dataResponse(int var1, byte[] var2) throws MethodException;

    public void finalResponse(int var1, Result var2) throws MethodException;

    public void updateCredentials(int var1, int var2, String var3, String var4, String var5) throws MethodException;
}

