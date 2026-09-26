/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.statemachine;

import de.audi.atip.utils.statemachine.InnerClassInflator$HierarchyBuilder;
import de.audi.atip.utils.statemachine.State;
import de.audi.atip.utils.statemachine.StateMachine;
import de.audi.atip.utils.statemachine.StateMachineInflator;

class StateMachineInflator$1
implements InnerClassInflator$HierarchyBuilder {
    private final /* synthetic */ StateMachine val$sm;
    private final /* synthetic */ StateMachineInflator this$0;

    StateMachineInflator$1(StateMachineInflator stateMachineInflator, StateMachine stateMachine) {
        this.this$0 = stateMachineInflator;
        this.val$sm = stateMachine;
    }

    @Override
    public void add(Object object) {
        this.val$sm.addState((State)object);
    }

    @Override
    public void add(Object object, Object object2) {
        this.val$sm.addState((State)object, (State)object2);
    }
}

