/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.sm.IState;

public class State
implements IState {
    @Override
    public void enter(Message message) {
    }

    @Override
    public void exit(Message message) {
    }

    @Override
    public boolean processMessage(Message message) {
        return false;
    }

    @Override
    public String getName() {
        String string = super.getClass().getName();
        int n = string.lastIndexOf(36);
        return string.substring(n + 1);
    }
}

