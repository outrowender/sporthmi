/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.telephone.CallStackEntry;
import org.dsi.ifc.telephone.MissedCallIndicator;

public interface DSICallStacksReply {
    public static final String IPL_COMM_UUID = "b4d4a6fb-dbca-5e1d-942b-304e14e8354d";
    public static final String IPL_COMM_INTERFACE_KEY = "77e0797d-7f62-56df-984f-75f67467400e";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.27";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.27";

    public void updateIsReverted(boolean var1, int var2) throws MethodException;

    public void updateLastAnsweredNumbers(CallStackEntry[] var1, int var2) throws MethodException;

    public void updateLastDialedNumbers(CallStackEntry[] var1, int var2) throws MethodException;

    public void updateMissedNumbers(CallStackEntry[] var1, int var2) throws MethodException;

    public void updateMEDataValidity(int var1, int var2) throws MethodException;

    public void updateMissedCallIndicator(MissedCallIndicator var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

