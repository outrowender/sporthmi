/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.has.HASDataContainer;

public interface DSIHASReply {
    public static final String IPL_COMM_UUID = "e8b825cb-88b6-5891-b307-10ee3b08dd9c";
    public static final String IPL_COMM_INTERFACE_KEY = "184e7a94-37bf-56cc-890e-bf8fe7451678";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.6";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.6";

    public void actionRequest(int var1, int var2, HASDataContainer[] var3) throws MethodException;

    public void subscribeRequest(int var1, int var2) throws MethodException;

    public void unsubscribeRequest(int var1) throws MethodException;

    public void unsubscribeAllRequest() throws MethodException;

    public void getPropertyRequest(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

