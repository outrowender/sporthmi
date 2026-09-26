/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.scxml.Context;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.Evaluator;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.model.Action;

public class Var
extends Action {
    private static final long serialVersionUID;
    private String name;
    private String expr;

    public final String getExpr() {
        return this.expr;
    }

    public final void setExpr(String string) {
        this.expr = string;
    }

    public final String getName() {
        return this.name;
    }

    public final void setName(String string) {
        this.name = string;
    }

    @Override
    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) {
        Context context = sCInstance.getContext(this.getParentTransitionTarget());
        Evaluator evaluator = sCInstance.getEvaluator();
        context.setLocal(Var.getNamespacesKey(), this.getNamespaces());
        Object object = evaluator.eval(context, this.expr);
        context.setLocal(Var.getNamespacesKey(), null);
        context.setLocal(this.name, object);
        if (log.isDebugEnabled()) {
            log.debug(new StringBuffer().append("<var>: Defined variable '").append(this.name).append("' with initial value '").append(String.valueOf(object)).append("'").toString());
        }
        TriggerEvent triggerEvent = new TriggerEvent(new StringBuffer().append(this.name).append(".change").toString(), 2);
        collection.add(triggerEvent);
    }
}

