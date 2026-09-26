/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

public interface ITelServiceMessaging {
    public static final int CONTEXT_TYPE_SMS;
    public static final int CONTEXT_TYPE_EMAIL;

    default public void notifyNewMessagesAvailable(boolean bl, boolean bl2) {
    }

    default public void notifyActiveContextMessaging(int n) {
    }
}

