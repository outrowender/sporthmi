/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.RequestDescriptor;

public interface ExtOnlineCoreServiceC {
    default public void init(String string) {
    }

    default public void init(String string, String string2) {
    }

    default public void registerService(String string, String string2, boolean bl) {
    }

    default public void getServiceListEntry(String string) {
    }

    default public void precheckOnlineServiceServiceID(String string) {
    }

    default public void precheckOnlineService() {
    }

    default public void requestUpdateKeyStore() {
    }

    default public void getToken(String string, boolean bl) {
    }

    default public void onlineRequest(RequestDescriptor requestDescriptor, int n, KeyValPair[] keyValPairArray, KeyValPair[] keyValPairArray2, byte[] byArray) {
    }

    default public void registerForCredentialUpdates(int[] nArray) {
    }
}

