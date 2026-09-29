/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.InnerClassInflator;
import de.audi.atip.utils.statemachine.StateMachine;
import de.audi.atip.utils.statemachine.StateMachineInflator$1;

public class StateMachineInflator {
    private final InnerClassInflator inflator;

    public StateMachineInflator(StateMachine stateMachine) {
        this.inflator = new InnerClassInflator(new StateMachineInflator$1(this, stateMachine), stateMachine);
    }

    public void inflate() {
        this.inflator.inflate();
    }
}

