/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.calendar;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSICalendarExchangeReply {
    public static final String IPL_COMM_UUID = "e882d2fd-a102-5e1e-a0c9-3bdc5c9ef453";
    public static final String IPL_COMM_INTERFACE_KEY = "cab46280-5cc8-5c9e-8fc8-8b0ef1c6c895";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void parseICalResult(int var1) throws MethodException;

    public void parseICalDirectoryResult(int[] var1) throws MethodException;

    public void exportICalResult(int var1, String var2) throws MethodException;

    public void finishExportResult(int var1, long[] var2, int var3, String var4) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

