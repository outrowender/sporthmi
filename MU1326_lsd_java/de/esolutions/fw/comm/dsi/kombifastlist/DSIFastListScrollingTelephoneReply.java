/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.kombifastlist.ArrayHeader;

public interface DSIFastListScrollingTelephoneReply {
    public static final String IPL_COMM_UUID = "b879c465-3f6c-5dad-8c9a-1c4f77696967";
    public static final String IPL_COMM_INTERFACE_KEY = "0d2d503d-cd11-52a4-b8cd-6c1d2c09795a";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public void indicationPhonebook(int var1, int var2, int var3, int var4, long var5, int var7, int var8, int var9, int var10, int var11, int var12) throws MethodException;

    public void indicationGetInitialsTelephone(int var1, int var2, int var3, int var4) throws MethodException;

    public void indicationNotifyFavoriteListPush(boolean var1, boolean var2) throws MethodException;

    public void indicationNotifyCombinedNumbersPush(boolean var1, boolean var2) throws MethodException;

    public void indicationNotifyCurrentListSizeTelephone(boolean var1, boolean var2) throws MethodException;

    public void indicationPhonebookJobs(int var1, int var2, int var3, ArrayHeader[] var4) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

