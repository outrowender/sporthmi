/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.statemachine.AbstractStateChange;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceState;
import de.esolutions.fw.util.commons.Buffer;

public class ResourceStateChange
extends AbstractStateChange {
    private final Resource resourceId;
    private final ResourceState oldState;
    private final ResourceState newState;

    public ResourceStateChange(Resource resource, ResourceState resourceState, ResourceState resourceState2) {
        super(RESOURCESTATE);
        this.resourceId = resource;
        this.oldState = resourceState;
        this.newState = resourceState2;
    }

    @Override
    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + (this.newState == null ? 0 : this.newState.hashCode());
        n = 31 * n + (this.oldState == null ? 0 : this.oldState.hashCode());
        n = 31 * n + (this.resourceId == null ? 0 : this.resourceId.hashCode());
        return n;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        ResourceStateChange resourceStateChange = (ResourceStateChange)object;
        if (this.newState == null ? resourceStateChange.newState != null : !this.newState.equals(resourceStateChange.newState)) {
            return false;
        }
        if (this.oldState == null ? resourceStateChange.oldState != null : !this.oldState.equals(resourceStateChange.oldState)) {
            return false;
        }
        return !(this.resourceId == null ? resourceStateChange.resourceId != null : !this.resourceId.equals(resourceStateChange.resourceId));
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("[ResourceStateChange resource='");
        buffer.append(this.resourceId);
        buffer.append("' oldState='");
        buffer.append(this.oldState);
        buffer.append("' newState='");
        buffer.append(this.newState);
        buffer.append("']");
        return buffer.toString();
    }
}

