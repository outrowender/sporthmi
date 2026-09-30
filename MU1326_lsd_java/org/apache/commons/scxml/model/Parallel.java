/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.LinkedHashSet;
import java.util.Set;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.TransitionTarget;

public class Parallel
extends TransitionTarget {
    private static final long serialVersionUID = 2L;
    private Set children = new LinkedHashSet();

    public final Set getStates() {
        return this.children;
    }

    public final void addState(State state) {
        if (state != null) {
            this.children.add(state);
            state.setParent(this);
        }
    }

    public final Set getChildren() {
        return this.children;
    }

    public final void addChild(TransitionTarget transitionTarget) {
        this.children.add(transitionTarget);
        transitionTarget.setParent(this);
    }
}

