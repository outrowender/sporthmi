/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface ADBSDSServiceListener {
    public void responseFillAdbPickList(int var1);

    public void responseFillTelNumberList(int var1, String var2, int var3, String var4, int[] var5);

    public void responseFillEmailList(int var1, String var2, int var3, String var4, int var5);

    public void responseShowAddresses(int var1, int[] var2, String var3);

    public void responseOpenEntryDetails(int var1, String var2);

    public void responseGetEntryNames(String[] var1);
}

