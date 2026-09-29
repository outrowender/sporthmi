/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.IState;
import de.audi.atip.utils.statemachine.Message;

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

