/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.msg;

import de.audi.atip.msg.MsgListener;

public interface IMessageDispatcher {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void addMessageListener(int n, MsgListener msgListener) {
    }

    default public void removeMessageListener(int n, MsgListener msgListener) {
    }
}

