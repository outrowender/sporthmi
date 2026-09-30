/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider;

import de.esolutions.fw.comm.core.method.MethodException;

public interface SdisConfigProviderReply {
    public static final String IPL_COMM_UUID = "4005e13e-09f0-11e5-94dc-54ee7547f476";
    public static final String IPL_COMM_INTERFACE_KEY = "417013af-3c71-5487-8fc9-6d656a950fc5";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void updateConfig(int var1, long var2) throws MethodException;

    public void updateASIVersion(String var1, boolean var2) throws MethodException;
}

