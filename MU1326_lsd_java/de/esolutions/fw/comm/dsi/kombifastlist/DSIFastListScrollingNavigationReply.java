/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public interface DSIFastListScrollingNavigationReply {
    public static final String IPL_COMM_UUID = "241abe61-ec0b-50d4-a6c5-12746ef6981b";
    public static final String IPL_COMM_INTERFACE_KEY = "9f971fb4-d04a-5b22-9a68-2920f3688410";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public void indicationNavBook(int var1, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12) throws MethodException;

    public void indicationGetInitialsNavigation(int var1, int var2, int var3, int var4) throws MethodException;

    public void indicationNotifyLastDestListPUSH(boolean var1, boolean var2) throws MethodException;

    public void indicationNotifyFavoriteDestListPUSH(boolean var1, boolean var2) throws MethodException;

    public void indicationNotifyCurrentListSizeNavigation(boolean var1, boolean var2) throws MethodException;

    public void indicationNavBookJobs(int var1, int var2, int var3, ArrayHeader[] var4) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

