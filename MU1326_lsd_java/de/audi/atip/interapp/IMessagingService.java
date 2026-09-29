/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface IMessagingService {
    public static final int MSG_TYPE_SMS;
    public static final int MSG_TYPE_MAIL;
    public static final int DATA_INDEX_NONE;

    default public void composeMsgPresetRecipient(int n, long l, int n2) {
    }

    default public void composeMsgPresetRecipient(int n, long l, int n2, int n3) {
    }

    default public void composeMsgPresetRecipient(int n, String string) {
    }

    default public void composeMsgAttachVCard(int n, String string, long l) {
    }
}

