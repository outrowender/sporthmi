/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.TransitionTarget;

public abstract class Executable
implements Serializable {
    private List actions = new ArrayList();
    private TransitionTarget parent;

    public final List getActions() {
        return this.actions;
    }

    public final void addAction(Action action) {
        if (action != null) {
            this.actions.add(action);
        }
    }

    public final TransitionTarget getParent() {
        return this.parent;
    }

    public final void setParent(TransitionTarget transitionTarget) {
        this.parent = transitionTarget;
    }
}

