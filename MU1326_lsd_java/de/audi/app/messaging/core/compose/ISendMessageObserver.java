/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

public interface ISendMessageObserver {
    public static final int SENDING_IN_PROGRESS;
    public static final int SENDING_SUCCESS;
    public static final int SENDING_FAILURE;
    public static final int SENDING_SUCCESS_STORE_FAILED;

    default public void indicateCurrentSendingStatus(int n) {
    }
}

