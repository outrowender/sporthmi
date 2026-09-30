/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

public interface IInquiry {
    public static final int STATE_IDLE = 0;
    public static final int STATE_ACTIVE = 1;
    public static final int STATE_ABORTING = 2;

    public void startInquiry(int var1);

    public void abortInquiry();
}

