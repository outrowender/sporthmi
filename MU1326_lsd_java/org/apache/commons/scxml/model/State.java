/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.scxml.model.Initial;
import org.apache.commons.scxml.model.Invoke;
import org.apache.commons.scxml.model.Parallel;
import org.apache.commons.scxml.model.Transition;
import org.apache.commons.scxml.model.TransitionTarget;

public class State
extends TransitionTarget {
    private static final long serialVersionUID = 2L;
    private Map children = new LinkedHashMap();
    private Parallel parallel;
    private Invoke invoke;
    private boolean isFinal;
    private Initial initial;
    private boolean done = false;

    public final boolean getIsFinal() {
        return this.isFinal;
    }

    public final void setIsFinal(boolean bl) {
        this.isFinal = bl;
    }

    public final boolean isFinal() {
        return this.isFinal;
    }

    public final void setFinal(boolean bl) {
        this.isFinal = bl;
    }

    public final Parallel getParallel() {
        return this.parallel;
    }

    public final void setParallel(Parallel parallel) {
        this.parallel = parallel;
    }

    public final Invoke getInvoke() {
        return this.invoke;
    }

    public final void setInvoke(Invoke invoke) {
        this.invoke = invoke;
    }

    public final Initial getInitial() {
        return this.initial;
    }

    public final void setInitial(Initial initial) {
        this.initial = initial;
        initial.setParent(this);
    }

    public final String getFirst() {
        if (this.initial != null) {
            return this.initial.getTransition().getNext();
        }
        return null;
    }

    public final void setFirst(String string) {
        Transition transition = new Transition();
        transition.setNext(string);
        Initial initial = new Initial();
        initial.setTransition(transition);
        initial.setParent(this);
        this.initial = initial;
    }

    public final Map getChildren() {
        return this.children;
    }

    public final void addChild(State state) {
        this.children.put(state.getId(), state);
        state.setParent(this);
    }

    public final void addChild(TransitionTarget transitionTarget) {
        this.children.put(transitionTarget.getId(), transitionTarget);
        transitionTarget.setParent(this);
    }

    public final boolean isSimple() {
        return this.parallel == null && this.children.isEmpty();
    }

    public final boolean isComposite() {
        return this.parallel != null || !this.children.isEmpty();
    }

    public final boolean isRegion() {
        return this.getParent() instanceof Parallel;
    }

    public final boolean isOrthogonal() {
        return this.parallel != null;
    }

    public final boolean isDone() {
        return this.done;
    }

    public final void setDone(boolean bl) {
        this.done = bl;
    }

    public String toString() {
        return this.getId();
    }
}

