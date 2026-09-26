/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.model.Executable;
import org.apache.commons.scxml.model.History;
import org.apache.commons.scxml.model.Initial;
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.NamespacePrefixesHolder;
import org.apache.commons.scxml.model.Parallel;
import org.apache.commons.scxml.model.State;
import org.apache.commons.scxml.model.TransitionTarget;

public abstract class Action
implements NamespacePrefixesHolder,
Serializable {
    private Executable parent = null;
    private Map namespaces = null;
    private static final String NAMESPACES_KEY;

    public final Executable getParent() {
        return this.parent;
    }

    public final void setParent(Executable executable) {
        this.parent = executable;
    }

    @Override
    public final Map getNamespaces() {
        return this.namespaces;
    }

    @Override
    public final void setNamespaces(Map map) {
        this.namespaces = map;
    }

    public final State getParentState() {
        TransitionTarget transitionTarget = this.parent.getParent();
        if (transitionTarget instanceof State) {
            State state = (State)transitionTarget;
            return state;
        }
        if (transitionTarget instanceof Parallel || transitionTarget instanceof History) {
            State state = (State)transitionTarget.getParent();
            return state;
        }
        throw new ModelException(new StringBuffer().append("Unknown TransitionTarget subclass:").append(super.getClass().getName()).toString());
    }

    public final TransitionTarget getParentTransitionTarget() {
        TransitionTarget transitionTarget = this.parent.getParent();
        if (transitionTarget instanceof State || transitionTarget instanceof Parallel) {
            return transitionTarget;
        }
        if (transitionTarget instanceof History || transitionTarget instanceof Initial) {
            return transitionTarget.getParent();
        }
        throw new ModelException(new StringBuffer().append("Unknown TransitionTarget subclass:").append(super.getClass().getName()).toString());
    }

    public abstract void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) {
    }

    protected static String getNamespacesKey() {
        return "_ALL_NAMESPACES";
    }
}

