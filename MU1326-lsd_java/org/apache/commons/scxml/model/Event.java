/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml.model;

import java.util.Collection;
import org.apache.commons.logging.Log;
import org.apache.commons.scxml.ErrorReporter;
import org.apache.commons.scxml.EventDispatcher;
import org.apache.commons.scxml.SCInstance;
import org.apache.commons.scxml.TriggerEvent;
import org.apache.commons.scxml.model.Action;

public class Event
extends Action {
    private static final long serialVersionUID;
    private String name;

    public final String getName() {
        return this.name;
    }

    public final void setName(String string) {
        this.name = string;
    }

    @Override
    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) {
        if (log.isDebugEnabled()) {
            log.debug(new StringBuffer().append("<event>: Adding event named '").append(this.name).append("' to list of derived events.").toString());
        }
        TriggerEvent triggerEvent = new TriggerEvent(this.name, 3);
        collection.add(triggerEvent);
    }
}

