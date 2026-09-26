/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.tv.app.util.Message;
import de.audi.tv.app.util.sm.State;
import de.audi.tv.app.util.sm.StateMachine$1;
import de.audi.tv.app.util.sm.StateMachine$SmImpl;

class StateMachine$SmImpl$HaltingState
extends State {
    private final /* synthetic */ StateMachine$SmImpl this$0;

    private StateMachine$SmImpl$HaltingState(StateMachine$SmImpl stateMachine$SmImpl) {
        this.this$0 = stateMachine$SmImpl;
    }

    @Override
    public boolean processMessage(Message message) {
        StateMachine$SmImpl.access$200(this.this$0).haltedProcessMessage(message);
        return true;
    }

    /* synthetic */ StateMachine$SmImpl$HaltingState(StateMachine$SmImpl stateMachine$SmImpl, StateMachine$1 stateMachine$1) {
        this(stateMachine$SmImpl);
    }
}

