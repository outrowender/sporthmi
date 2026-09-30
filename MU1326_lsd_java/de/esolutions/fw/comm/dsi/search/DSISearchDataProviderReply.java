/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISearchDataProviderReply {
    public static final String IPL_COMM_UUID = "e807d634-9ea2-5397-904a-1df1e52b3d2c";
    public static final String IPL_COMM_INTERFACE_KEY = "a3cc537e-0364-51f9-bde3-953f3ce486e9";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.25";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.25";

    public void registerProviderSourceResult(int var1, int var2) throws MethodException;

    public void activateProviderSource(int var1) throws MethodException;

    public void invalidateAllDataResult(int var1, int var2) throws MethodException;

    public void provideData(int var1, int var2, int var3) throws MethodException;

    public void storeDataSetsResult(int var1, int var2) throws MethodException;

    public void deleteDataSetResult(int var1, int var2, long var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

