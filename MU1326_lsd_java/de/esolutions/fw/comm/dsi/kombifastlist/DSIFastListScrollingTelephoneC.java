/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public interface DSIFastListScrollingTelephoneC {
    public void pushFunctionAvailabilityTelephone(int var1) throws MethodException;

    public void pushMOSTOperationStateTelephone(short var1) throws MethodException;

    public void responsePhonebook(int var1, int var2, int var3, int var4, int var5, long var6, int var8, int var9, int var10, int var11, int var12, int var13, int var14) throws MethodException;

    public void responsePhonebookArray(int var1, int var2, DataPhonebook[] var3) throws MethodException;

    public void responseGetInitialsTelephone(int var1, int var2, int var3, int var4, DataInitials[] var5) throws MethodException;

    public void pushupdateFavoriteList(int var1, int var2, DataFavoriteList[] var3) throws MethodException;

    public void pushCombinedNumbers(int var1, int var2, DataCombinedNumbers[] var3) throws MethodException;

    public void pushCurrentListSizeTelephone(int var1, int var2, int var3) throws MethodException;

    public void responsePhonebookJobs(int var1, int var2, int var3) throws MethodException;

    public void responseNotifyCombinedNumbersPush(boolean var1) throws MethodException;

    public void responseNotifyCurrentListSizes(boolean var1) throws MethodException;

    public void responseNotifyFavoriteListPush(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

