/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.compose;

public interface INewMessageObserver {
    default public void messageCleared() {
    }

    default public void indicateMessageLength(int n, int n2) {
    }
}

