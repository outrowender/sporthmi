/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public class Initial
extends TransitionTarget {
    private static final long serialVersionUID = 1L;
    private Transition transition;

    public final Transition getTransition() {
        return this.transition;
    }

    public final void setTransition(Transition transition) {
        this.transition = transition;
        this.transition.setParent(this);
    }
}

