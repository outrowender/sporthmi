/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.online.coreservice;

import de.esolutions.fw.comm.asi.online.coreservice.KeyValPair;
import de.esolutions.fw.comm.asi.online.coreservice.RequestDescriptor;
import de.esolutions.fw.comm.core.method.MethodException;

public interface ExtOnlineCoreServiceC {
    public void init(String var1) throws MethodException;

    public void init(String var1, String var2) throws MethodException;

    public void registerService(String var1, String var2, boolean var3) throws MethodException;

    public void getServiceListEntry(String var1) throws MethodException;

    public void precheckOnlineServiceServiceID(String var1) throws MethodException;

    public void precheckOnlineService() throws MethodException;

    public void requestUpdateKeyStore() throws MethodException;

    public void getToken(String var1, boolean var2) throws MethodException;

    public void onlineRequest(RequestDescriptor var1, int var2, KeyValPair[] var3, KeyValPair[] var4, byte[] var5) throws MethodException;

    public void registerForCredentialUpdates(int[] var1) throws MethodException;
}

