/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.util.sm;

import de.audi.tv.app.util.InnerClassInflator;
import de.audi.tv.app.util.sm.State;
import de.audi.tv.app.util.sm.StateMachine;
import java.lang.reflect.InvocationTargetException;

public class StateMachineInflator {
    private final InnerClassInflator inflator;

    public StateMachineInflator(final StateMachine stateMachine) {
        this.inflator = new InnerClassInflator(new InnerClassInflator.HierarchyBuilder(){

            public void add(Object object) {
                stateMachine.addState((State)object);
            }

            public void add(Object object, Object object2) {
                stateMachine.addState((State)object, (State)object2);
            }
        }, stateMachine);
    }

    public void inflate() throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        this.inflator.inflate();
    }
}

