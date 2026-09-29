/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.apache.commons.scxml.SCXMLHelper;
import org.apache.commons.scxml.model.State;

public class Status
implements Serializable {
    private static final long serialVersionUID;
    private Set states = new HashSet();
    private Collection events = new ArrayList();

    public boolean isFinal() {
        boolean bl = true;
        Iterator iterator = this.states.iterator();
        while (iterator.hasNext()) {
            State state = (State)iterator.next();
            if (!state.isFinal()) {
                bl = false;
                break;
            }
            if (state.getParent() == null) continue;
            bl = false;
            break;
        }
        if (!this.events.isEmpty()) {
            bl = false;
        }
        return bl;
    }

    public Set getStates() {
        return this.states;
    }

    public Collection getEvents() {
        return this.events;
    }

    public Set getAllStates() {
        return SCXMLHelper.getAncestorClosure(this.states, null);
    }
}

