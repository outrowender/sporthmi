/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

public interface IInquiry {
    public static final int STATE_IDLE;
    public static final int STATE_ACTIVE;
    public static final int STATE_ABORTING;

    default public void startInquiry(int n) {
    }

    default public void abortInquiry() {
    }
}

