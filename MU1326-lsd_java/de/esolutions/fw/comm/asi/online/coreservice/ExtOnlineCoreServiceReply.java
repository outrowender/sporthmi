/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.OAuthToken;
import de.esolutions.fw.comm.asi.online.coreservice.Result;
import de.esolutions.fw.comm.asi.online.coreservice.ServiceListEntry;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.OSRNotifyPropertiesSL;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.OSRUser;

public interface ExtOnlineCoreServiceReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void initResponse(int n) {
    }

    default public void registerServiceResponse(int n) {
    }

    default public void enableApplication() {
    }

    default public void disableApplication() {
    }

    default public void getServiceListEntryResponse(int n, ServiceListEntry serviceListEntry) {
    }

    default public void updateApplicationState(OSRNotifyProperties[] oSRNotifyPropertiesArray) {
    }

    default public void updateServices(OSRNotifyPropertiesSL[] oSRNotifyPropertiesSLArray) {
    }

    default public void updateServiceState(int n) {
    }

    default public void precheckOnlineServiceServiceIDResponse(OSRServiceState oSRServiceState) {
    }

    default public void precheckOnlineServiceResponse(OSRServiceState[] oSRServiceStateArray) {
    }

    default public void keyStoreChanged() {
    }

    default public void updateLoggedInUser(OSRUser oSRUser, int n) {
    }

    default public void getTokenResponse(int n, OAuthToken oAuthToken, String string) {
    }

    default public void onlineResponse(int n, KeyValPair[] keyValPairArray) {
    }

    default public void dataResponse(int n, byte[] byArray) {
    }

    default public void finalResponse(int n, Result result) {
    }

    default public void updateCredentials(int n, int n2, String string, String string2, String string3) {
    }
}

