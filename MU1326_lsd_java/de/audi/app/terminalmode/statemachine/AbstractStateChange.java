/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.statemachine.IStateChange;
import de.audi.app.terminalmode.statemachine.StateChangeType;

public abstract class AbstractStateChange
implements IStateChange {
    protected static final StateChangeType APPLICATION = new StateChangeType("APPLICATION");
    protected static final StateChangeType RESOURCE = new StateChangeType("RESOURCE");
    protected static final StateChangeType RESOURCESTATE = new StateChangeType("RESOURCESTATE");
    protected final StateChangeType stateChangeType;

    public AbstractStateChange(StateChangeType stateChangeType) {
        this.stateChangeType = stateChangeType;
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.stateChangeType == null ? 0 : this.stateChangeType.hashCode());
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AbstractStateChange abstractStateChange = (AbstractStateChange)object;
        return !(this.stateChangeType == null ? abstractStateChange.stateChangeType != null : !this.stateChangeType.equals(abstractStateChange.stateChangeType));
    }
}

