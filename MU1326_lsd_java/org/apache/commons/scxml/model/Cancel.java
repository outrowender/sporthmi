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

public class Cancel
extends Action {
    private static final long serialVersionUID;
    private String sendid;

    public String getSendid() {
        return this.sendid;
    }

    public void setSendid(String string) {
        this.sendid = string;
    }

    @Override
    public void execute(EventDispatcher eventDispatcher, ErrorReporter errorReporter, SCInstance sCInstance, Log log, Collection collection) {
        eventDispatcher.cancel(this.sendid);
    }
}

