/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.organizer.DataSet;

public interface DSIAdbDataResolutionReply {
    public static final String IPL_COMM_UUID = "c2865fe6-a451-5a7e-96a2-16632788603a";
    public static final String IPL_COMM_INTERFACE_KEY = "bf9f1f0f-c111-50ca-b2dd-023f9c450993";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.31";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.31";

    public void resolveMailAddressResult(int var1, DataSet[] var2) throws MethodException;

    public void resolvePhoneNumbersResult(int var1, DataSet[] var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

