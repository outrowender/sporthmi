/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

public interface INewMessageObserver {
    public void messageCleared();

    public void indicateMessageLength(int var1, int var2);

    public static class DefaultNewMessageObserver
    implements INewMessageObserver {
        public void messageCleared() {
        }

        public void indicateMessageLength(int n, int n2) {
        }
    }
}

