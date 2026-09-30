/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IMessagingService {
    public static final int MSG_TYPE_SMS = 0;
    public static final int MSG_TYPE_MAIL = 1;
    public static final int DATA_INDEX_NONE = -1;

    public void composeMsgPresetRecipient(int var1, long var2, int var4);

    public void composeMsgPresetRecipient(int var1, long var2, int var4, int var5);

    public void composeMsgPresetRecipient(int var1, String var2);

    public void composeMsgAttachVCard(int var1, String var2, long var3);
}

