/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.model.Action;

public class Exit
extends Action {
    private static final long serialVersionUID;
    private String expr;
    private String namelist;

    public final String getExpr() {
        return this.expr;
    }

    public final void setExpr(String string) {
        this.expr = string;
    }

    public final String getNamelist() {
        return this.namelist;
    }

    public final void setNamelist(String string) {
        this.namelist = string;
    }

    @Override
    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) {
    }
}

