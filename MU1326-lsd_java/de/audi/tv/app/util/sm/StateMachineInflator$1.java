/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.tv.app.util.InnerClassInflator$HierarchyBuilder;
import de.audi.tv.app.util.sm.State;
import de.audi.tv.app.util.sm.StateMachine;
import de.audi.tv.app.util.sm.StateMachineInflator;

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

