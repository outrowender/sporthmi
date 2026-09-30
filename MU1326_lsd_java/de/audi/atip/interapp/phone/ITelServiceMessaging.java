/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.phone;

public interface ITelServiceMessaging {
    public static final int CONTEXT_TYPE_SMS = 0;
    public static final int CONTEXT_TYPE_EMAIL = 1;

    public void notifyNewMessagesAvailable(boolean var1, boolean var2);

    public void notifyActiveContextMessaging(int var1);
}

