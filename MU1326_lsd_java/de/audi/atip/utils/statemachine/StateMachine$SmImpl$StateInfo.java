/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.State;
import de.audi.atip.utils.statemachine.StateMachine$1;
import de.audi.atip.utils.statemachine.StateMachine$SmImpl;

class StateMachine$SmImpl$StateInfo {
    State state;
    StateMachine$SmImpl$StateInfo parentStateInfo;
    boolean active;
    private final /* synthetic */ StateMachine$SmImpl this$0;

    private StateMachine$SmImpl$StateInfo(StateMachine$SmImpl stateMachine$SmImpl) {
        this.this$0 = stateMachine$SmImpl;
    }

    public String toString() {
        return new StringBuffer().append("state=").append(this.state.getName()).append(",active=").append(this.active).append(",parent=").append(this.parentStateInfo == null ? "null" : this.parentStateInfo.state.getName()).toString();
    }

    /* synthetic */ StateMachine$SmImpl$StateInfo(StateMachine$SmImpl stateMachine$SmImpl, StateMachine$1 stateMachine$1) {
        this(stateMachine$SmImpl);
    }
}

