/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.online.OperatorCallResult;

public interface DSIOperatorCallReply {
    public static final String IPL_COMM_UUID = "1f7c2f4e-9ee9-51d8-bc8d-f8217b5da57e";
    public static final String IPL_COMM_INTERFACE_KEY = "2d39ebd3-2cbc-582c-92a3-833b2cadd715";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public void responseOperatorCallResult(int var1, OperatorCallResult[] var2) throws MethodException;

    public void responseOperatorPhoneNumber(int var1, String var2, String[] var3, int var4) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

