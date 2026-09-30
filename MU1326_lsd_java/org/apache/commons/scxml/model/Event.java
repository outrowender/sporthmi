/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.SCXMLExpressionException;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.model.Action;
import org.apache.commons.scxml.model.ModelException;

public class Event
extends Action {
    private static final long serialVersionUID = 1L;
    private String name;

    public final String getName() {
        return this.name;
    }

    public final void setName(String string) {
        this.name = string;
    }

    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) throws ModelException, SCXMLExpressionException {
        if (log.isDebugEnabled()) {
            log.debug("<event>: Adding event named '" + this.name + "' to list of derived events.");
        }
        TriggerEvent triggerEvent = new TriggerEvent(this.name, 3);
        collection.add(triggerEvent);
    }
}

