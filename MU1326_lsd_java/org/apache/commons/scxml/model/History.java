/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public class History
extends TransitionTarget {
    private static final long serialVersionUID = 1L;
    private boolean isDeep;
    private Transition transition;

    public final Transition getTransition() {
        return this.transition;
    }

    public final void setTransition(Transition transition) {
        this.transition = transition;
        this.transition.setParent(this);
    }

    public final boolean isDeep() {
        return this.isDeep;
    }

    public final void setType(String string) {
        if (string != null && string.equals("deep")) {
            this.isDeep = true;
        }
    }
}

