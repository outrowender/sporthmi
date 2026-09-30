/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

public interface ILoggingManager {
    public void doGetHistory();

    public void updateHistory(String[] var1, int[] var2);

    public void setUpdate(int var1);

    public void updateGeneralInformation(boolean var1, String var2, String var3, boolean var4, String var5, int var6, int[] var7, boolean var8, int var9);

    public void doGetUnusualEvents();

    public void updateUnusualEvents(String[] var1, String[] var2);

    public void doGetUnusualEvent(int var1);

    public void updateUnusualEvent(String var1, int var2, String var3, String var4, String var5, byte var6, int var7);

    public void selectHistory(int var1);

    public void selectUnusualEvent(int var1);
}

