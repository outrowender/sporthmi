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
import org.apache.commons.scxml.SCXMLExpressionException;
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
    private static final String NAMESPACES_KEY = "_ALL_NAMESPACES";

    public final Executable getParent() {
        return this.parent;
    }

    public final void setParent(Executable executable) {
        this.parent = executable;
    }

    public final Map getNamespaces() {
        return this.namespaces;
    }

    public final void setNamespaces(Map map) {
        this.namespaces = map;
    }

    public final State getParentState() throws ModelException {
        TransitionTarget transitionTarget = this.parent.getParent();
        if (transitionTarget instanceof State) {
            State state = (State)transitionTarget;
            return state;
        }
        if (transitionTarget instanceof Parallel || transitionTarget instanceof History) {
            State state = (State)transitionTarget.getParent();
            return state;
        }
        throw new ModelException("Unknown TransitionTarget subclass:" + transitionTarget.getClass().getName());
    }

    public final TransitionTarget getParentTransitionTarget() throws ModelException {
        TransitionTarget transitionTarget = this.parent.getParent();
        if (transitionTarget instanceof State || transitionTarget instanceof Parallel) {
            return transitionTarget;
        }
        if (transitionTarget instanceof History || transitionTarget instanceof Initial) {
            return transitionTarget.getParent();
        }
        throw new ModelException("Unknown TransitionTarget subclass:" + transitionTarget.getClass().getName());
    }

    public abstract void execute(EventDispatcher var1, ErrorReporter var2, SCInstance var3, Log var4, Collection var5) throws ModelException, SCXMLExpressionException;

    protected static String getNamespacesKey() {
        return NAMESPACES_KEY;
    }
}

