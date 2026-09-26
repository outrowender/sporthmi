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

public class ElseIf
extends Action {
    private static final long serialVersionUID;
    private String cond;

    public final String getCond() {
        return this.cond;
    }

    public final void setCond(String string) {
        this.cond = string;
    }

    @Override
    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) {
    }
}

