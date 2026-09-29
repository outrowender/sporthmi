/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.Collection;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.model.Action;

public class Log
extends Action {
    private static final long serialVersionUID;
    private String expr;
    private String label;

    public final String getExpr() {
        return this.expr;
    }

    public final void setExpr(String string) {
        this.expr = string;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String string) {
        this.label = string;
    }

    @Override
    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, org.apache.commons.logging.Log log, Collection collection) {
        Context context = sCInstance.getContext(this.getParentTransitionTarget());
        Evaluator evaluator = sCInstance.getEvaluator();
        context.setLocal(Log.getNamespacesKey(), this.getNamespaces());
        log.info(new StringBuffer().append(this.label).append(": ").append(String.valueOf(evaluator.eval(context, this.expr))).toString());
        context.setLocal(Log.getNamespacesKey(), null);
    }
}

