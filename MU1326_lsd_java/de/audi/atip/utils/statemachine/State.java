/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.IState;
import de.audi.atip.utils.statemachine.Message;

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

