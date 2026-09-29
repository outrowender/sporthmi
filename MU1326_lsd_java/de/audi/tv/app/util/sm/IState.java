/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.tv.app.util.Message;

public interface IState {
    public static final boolean HANDLED;
    public static final boolean NOT_HANDLED;

    default public void enter(Message message) {
    }

    default public void exit(Message message) {
    }

    default public boolean processMessage(Message message) {
    }

    default public String getName() {
    }
}

