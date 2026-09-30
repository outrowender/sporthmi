/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.exlap;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.exlap.Service;

public interface DSIExlapReply {
    public static final String IPL_COMM_UUID = "80b0cedf-8e37-5df0-9bdc-e342cb6313d5";
    public static final String IPL_COMM_INTERFACE_KEY = "32f55de8-52f0-5d6a-bd2b-055b8f821146";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.3";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.3";

    public void startResult(int var1) throws MethodException;

    public void stopResult(int var1) throws MethodException;

    public void updateAvailableServices(Service[] var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

