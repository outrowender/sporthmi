/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.statemachine.AbstractStateChange;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.esolutions.fw.util.commons.Buffer;

public class ResourceOwnerChange
extends AbstractStateChange {
    private final Resource resourceId;
    private final ResourceOwner oldOwner;
    private final ResourceOwner newOwner;

    public ResourceOwnerChange(Resource resource, ResourceOwner resourceOwner, ResourceOwner resourceOwner2) {
        super(RESOURCE);
        this.resourceId = resource;
        this.oldOwner = resourceOwner;
        this.newOwner = resourceOwner2;
    }

    public int hashCode() {
        int n = super.hashCode();
        n = 31 * n + this.newOwner.ordinal();
        n = 31 * n + this.oldOwner.ordinal();
        n = 31 * n + this.resourceId.ordinal();
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (this.getClass() != object.getClass()) {
            return false;
        }
        ResourceOwnerChange resourceOwnerChange = (ResourceOwnerChange)object;
        if (this.newOwner != resourceOwnerChange.newOwner) {
            return false;
        }
        if (this.oldOwner != resourceOwnerChange.oldOwner) {
            return false;
        }
        return this.resourceId == resourceOwnerChange.resourceId;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("[ResourceOwnerChange resource='");
        buffer.append(this.resourceId);
        buffer.append("' oldOwner='");
        buffer.append(this.oldOwner);
        buffer.append("' newOwner='");
        buffer.append(this.newOwner);
        buffer.append("']");
        return buffer.toString();
    }
}

