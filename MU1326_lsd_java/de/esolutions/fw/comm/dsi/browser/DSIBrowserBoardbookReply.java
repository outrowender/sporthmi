/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.browser;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.browser.SearchHit;

public interface DSIBrowserBoardbookReply {
    public static final String IPL_COMM_UUID = "03f95510-eeb3-5745-b7b4-d75d7d980f85";
    public static final String IPL_COMM_INTERFACE_KEY = "4cab68e7-314f-5431-9fb3-c957c73e6c7e";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.18";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.18";

    public void indicateSearchResults(String var1, int var2, SearchHit[] var3, int var4) throws MethodException;

    public void updateBoardbookStatus(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

