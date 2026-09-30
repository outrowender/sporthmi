/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.online.OSRServiceState;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

public interface DSIPoiOnlineSearchReply {
    public static final String IPL_COMM_UUID = "66cd10bd-7fcb-5257-a3b3-fb17ef89a84c";
    public static final String IPL_COMM_INTERFACE_KEY = "570d8158-1fca-541c-bb86-991022902795";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public void poiResult(int var1, int var2, int var3) throws MethodException;

    public void poiSpellingSuggestion(int var1, String var2, String[] var3) throws MethodException;

    public void poiValueList(int var1, int var2, PoiOnlineSearchValuelist var3, int var4, int var5) throws MethodException;

    public void precheckDynamicPOICategoryResponse(int var1, OSRServiceState var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

