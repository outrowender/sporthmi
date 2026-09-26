/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.scxml.model.Datamodel;
import org.apache.commons.scxml.model.History;
import org.apache.commons.scxml.model.OnEntry;
import org.apache.commons.scxml.model.OnExit;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.Transition;

public abstract class TransitionTarget
implements Serializable {
    private String id;
    private OnEntry onEntry = new OnEntry();
    private OnExit onExit;
    private Datamodel datamodel;
    private TransitionTarget parent;
    private List transitions;
    private List history;

    public TransitionTarget() {
        this.onEntry.setParent(this);
        this.onExit = new OnExit();
        this.onExit.setParent(this);
        this.parent = null;
        this.transitions = new ArrayList();
        this.history = new ArrayList();
    }

    public final String getId() {
        return this.id;
    }

    public final void setId(String string) {
        this.id = string;
    }

    public final OnEntry getOnEntry() {
        return this.onEntry;
    }

    public final void setOnEntry(OnEntry onEntry) {
        this.onEntry = onEntry;
        this.onEntry.setParent(this);
    }

    public final OnExit getOnExit() {
        return this.onExit;
    }

    public final void setOnExit(OnExit onExit) {
        this.onExit = onExit;
        this.onExit.setParent(this);
    }

    public final Datamodel getDatamodel() {
        return this.datamodel;
    }

    public final void setDatamodel(Datamodel datamodel) {
        this.datamodel = datamodel;
    }

    public final TransitionTarget getParent() {
        return this.parent;
    }

    public final void setParent(TransitionTarget transitionTarget) {
        this.parent = transitionTarget;
    }

    public final State getParentState() {
        TransitionTarget transitionTarget = this.getParent();
        if (transitionTarget == null) {
            return null;
        }
        if (transitionTarget instanceof State) {
            return (State)transitionTarget;
        }
        return transitionTarget.getParentState();
    }

    public final Map getTransitions() {
        HashMap hashMap = new HashMap();
        for (int i2 = 0; i2 < this.transitions.size(); ++i2) {
            Transition transition = (Transition)this.transitions.get(i2);
            String string = transition.getEvent();
            if (!hashMap.containsKey(string)) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(transition);
                hashMap.put(string, arrayList);
                continue;
            }
            ((List)hashMap.get(string)).add(transition);
        }
        return hashMap;
    }

    public final List getTransitionsList(String string) {
        List list = null;
        for (int i2 = 0; i2 < this.transitions.size(); ++i2) {
            Transition transition = (Transition)this.transitions.get(i2);
            if ((string != null || transition.getEvent() != null) && (string == null || !string.equals(transition.getEvent()))) continue;
            if (list == null) {
                list = new ArrayList();
            }
            list.add(transition);
        }
        return list;
    }

    public final void addTransition(Transition transition) {
        this.transitions.add(transition);
        transition.setParent(this);
    }

    public final List getTransitionsList() {
        return this.transitions;
    }

    public final void addHistory(History history) {
        this.history.add(history);
        history.setParent(this);
    }

    public final boolean hasHistory() {
        return !this.history.isEmpty();
    }

    public final List getHistory() {
        return this.history;
    }
}

