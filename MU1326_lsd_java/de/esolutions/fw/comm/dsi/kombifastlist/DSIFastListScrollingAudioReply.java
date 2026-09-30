/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public interface DSIFastListScrollingAudioReply {
    public static final String IPL_COMM_UUID = "97acfc92-c952-5fc4-91b8-cf398b82e563";
    public static final String IPL_COMM_INTERFACE_KEY = "f7381f54-95fb-5d0f-ae7c-8848533e7e3f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public void indicationMediaBrowser(int var1, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12) throws MethodException;

    public void indicationNotifyCommonListPUSH(boolean var1, boolean var2) throws MethodException;

    public void indicationNotifyReceptionListPUSH(boolean var1, boolean var2) throws MethodException;

    public void indicationNotifyCurrentListSizeAudio(boolean var1, boolean var2) throws MethodException;

    public void indicationMediaBrowserJobs(int var1, int var2, int var3, ArrayHeader[] var4) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

