/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.Else;
import org.apache.commons.scxml.model.ElseIf;
import org.apache.commons.scxml.model.ModelException;
import org.apache.commons.scxml.model.TransitionTarget;

public class If
extends Action {
    private static final long serialVersionUID = 1L;
    private String cond;
    private List actions = new ArrayList();
    private boolean execute = false;

    public final List getActions() {
        return this.actions;
    }

    public final void addAction(Action action) {
        if (action != null) {
            this.actions.add(action);
        }
    }

    public final String getCond() {
        return this.cond;
    }

    public final void setCond(String string) {
        this.cond = string;
    }

    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) throws ModelException, SCXMLExpressionException {
        TransitionTarget transitionTarget = this.getParentTransitionTarget();
        Context context = sCInstance.getContext(transitionTarget);
        Evaluator evaluator = sCInstance.getEvaluator();
        context.setLocal(If.getNamespacesKey(), this.getNamespaces());
        this.execute = evaluator.evalCond(context, this.cond);
        context.setLocal(If.getNamespacesKey(), null);
        Iterator iterator = this.actions.iterator();
        while (iterator.hasNext()) {
            Action action = (Action)iterator.next();
            if (this.execute && !(action instanceof ElseIf) && !(action instanceof Else)) {
                action.execute(eventDispatcher, errorReporter, sCInstance, log, collection);
                continue;
            }
            if (this.execute && (action instanceof ElseIf || action instanceof Else)) break;
            if (action instanceof Else) {
                this.execute = true;
                continue;
            }
            if (!(action instanceof ElseIf)) continue;
            context.setLocal(If.getNamespacesKey(), this.getNamespaces());
            this.execute = evaluator.evalCond(context, ((ElseIf)action).getCond());
            context.setLocal(If.getNamespacesKey(), null);
        }
    }
}

