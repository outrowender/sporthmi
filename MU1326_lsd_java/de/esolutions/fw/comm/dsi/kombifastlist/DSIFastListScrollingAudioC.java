/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.kombifastlist.DataCommonList;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public interface DSIFastListScrollingAudioC {
    public void pushFunctionAvailabilityAudio(int var1) throws MethodException;

    public void pushMOSTOperationStateAudio(int var1) throws MethodException;

    public void responseMediaBrowser(int var1, int var2, int var3, int var4, int var5, int var6, int var7, long var8, int var10, long var11, long var13, int var15, int var16, int var17) throws MethodException;

    public void responseMediaBrowserArray(long var1, int var3, DataMediaBrowser[] var4) throws MethodException;

    public void pushCommonList(long var1, int var3, DataCommonList[] var4) throws MethodException;

    public void pushReceptionList(long var1, int var3, DataReceptionList[] var4) throws MethodException;

    public void pushCurrentListSizeAudio(int var1, int var2, int var3) throws MethodException;

    public void responseMediaBrowserJobs(long var1, int var3, int var4) throws MethodException;

    public void responseNotifyCommonListPush(boolean var1) throws MethodException;

    public void responseNotifyCurrentListSizeAudio(boolean var1) throws MethodException;

    public void responseNotifyReceptionList(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

