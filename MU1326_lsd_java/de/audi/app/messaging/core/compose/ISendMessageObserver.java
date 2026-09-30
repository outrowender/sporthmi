/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

public interface ISendMessageObserver {
    public static final int SENDING_IN_PROGRESS = 0;
    public static final int SENDING_SUCCESS = 1;
    public static final int SENDING_FAILURE = 2;
    public static final int SENDING_SUCCESS_STORE_FAILED = 3;

    public void indicateCurrentSendingStatus(int var1);

    public static class DefaultSendMessageObserver
    implements ISendMessageObserver {
        public void indicateCurrentSendingStatus(int n) {
        }
    }
}

