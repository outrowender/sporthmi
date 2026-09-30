/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.sm.IState;

public class State
implements IState {
    public void enter(Message message) {
    }

    public void exit(Message message) {
    }

    public boolean processMessage(Message message) {
        return false;
    }

    public String getName() {
        String string = this.getClass().getName();
        int n = string.lastIndexOf(36);
        return string.substring(n + 1);
    }
}

