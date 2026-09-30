/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataInitials;

public interface DSIFastListScrollingNavigationC {
    public void pushFunctionAvailabilityNavigation(int var1) throws MethodException;

    public void pushMOSTOperationStateNavigation(int var1) throws MethodException;

    public void responseNavBook(int var1, int var2, int var3, int var4, int var5, long var6, int var8, int var9, int var10, int var11, int var12, int var13, int var14) throws MethodException;

    public void responseNavBookArray(int var1, int var2, DataAddress[] var3) throws MethodException;

    public void responseGetInitialsNavigation(int var1, int var2, int var3, int var4, DataInitials[] var5) throws MethodException;

    public void pushLastDestList(int var1, int var2, DataAddress[] var3) throws MethodException;

    public void pushUpdateFavoriteDestList(int var1, int var2, DataAddress[] var3) throws MethodException;

    public void pushCurrentListSizeNavigation(int var1, int var2, int var3) throws MethodException;

    public void responseNavBookJobs(int var1, int var2, int var3) throws MethodException;

    public void responseNotifyCurrentListSizesNavigation(boolean var1) throws MethodException;

    public void responseNotifyFavoriteDestList(boolean var1) throws MethodException;

    public void responseNotifyLastDestList(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

