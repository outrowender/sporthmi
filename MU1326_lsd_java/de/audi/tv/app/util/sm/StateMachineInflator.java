/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.tv.app.util.InnerClassInflator;
import de.audi.tv.app.util.sm.StateMachine;
import de.audi.tv.app.util.sm.StateMachineInflator$1;

public class StateMachineInflator {
    private final InnerClassInflator inflator;

    public StateMachineInflator(StateMachine stateMachine) {
        this.inflator = new InnerClassInflator(new StateMachineInflator$1(this, stateMachine), stateMachine);
    }

    public void inflate() {
        this.inflator.inflate();
    }
}

