/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.upnp;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.upnp.ListEntry;

public interface DSIUPNPBrowserReply {
    public static final String IPL_COMM_UUID = "c595044a-be53-5cb5-a0bd-56eecee8fe4e";
    public static final String IPL_COMM_INTERFACE_KEY = "ed7163ca-c11b-587a-8ec4-a26a9780ba19";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void updateBrowseFolder(ListEntry[] var1, int var2) throws MethodException;

    public void updateListSize(int var1, int var2, int var3) throws MethodException;

    public void responseList(ListEntry[] var1, int var2) throws MethodException;

    public void invalidBrowsePath() throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

