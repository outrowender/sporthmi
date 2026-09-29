/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.env;

import org.apache.commons.scxml.SCXMLListener;
import org.apache.commons.scxml.env.AbstractStateMachine;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public class AbstractStateMachine$EntryListener
implements SCXMLListener {
    private final /* synthetic */ AbstractStateMachine this$0;

    protected AbstractStateMachine$EntryListener(AbstractStateMachine abstractStateMachine) {
        this.this$0 = abstractStateMachine;
    }

    @Override
    public void onEntry(TransitionTarget transitionTarget) {
        this.this$0.invoke(transitionTarget.getId());
    }

    @Override
    public void onTransition(TransitionTarget transitionTarget, TransitionTarget transitionTarget2, Transition transition) {
    }

    @Override
    public void onExit(TransitionTarget transitionTarget) {
    }
}

