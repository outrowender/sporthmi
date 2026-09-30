/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdllogging;

import org.dsi.ifc.base.DSIListener;

public interface DSISwdlLoggingListener
extends DSIListener {
    public void getHistory(String[] var1, int[] var2);

    public void setUpdate(int var1);

    public void getGeneralInformation(boolean var1, String var2, String var3, boolean var4, String var5, String var6, int[] var7, boolean var8, int var9, int[] var10);

    public void getUnusualEvents(int[] var1, String[] var2);

    public void getUnusualEvent(int var1, String var2, String var3, String var4, byte var5, int var6);
}

