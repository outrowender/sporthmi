/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi;

import de.audi.app.terminalmode.dsi.IResource;
import de.audi.app.terminalmode.dsi.IResource$OwnershipType;
import de.esolutions.fw.util.commons.Buffer;

public abstract class AbstractResource
implements IResource {
    private final int resourceId;
    private final int owner;
    private final IResource$OwnershipType ownershipType;

    public AbstractResource(int n, int n2, IResource$OwnershipType iResource$OwnershipType) {
        this.resourceId = n;
        this.owner = n2;
        this.ownershipType = iResource$OwnershipType;
    }

    public AbstractResource(int n, int n2) {
        this(n, n2, IResource$OwnershipType.UNSPECIFIED);
    }

    @Override
    public int getResourceId() {
        return this.resourceId;
    }

    @Override
    public int getOwner() {
        return this.owner;
    }

    @Override
    public IResource$OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("Resource [resourceId=");
        buffer.append(this.getResourceString(this.resourceId));
        buffer.append(", owner=");
        buffer.append(this.getOwnerString(this.owner));
        if (this.ownershipType.isNot(IResource$OwnershipType.UNSPECIFIED)) {
            buffer.append("(").append(this.ownershipType.name()).append(")");
        }
        buffer.append("]");
        return buffer.toString();
    }

    private String getOwnerString(int n) {
        switch (n) {
            case 2: {
                return "DEVICE";
            }
            case 1: {
                return "MAINUNIT";
            }
        }
        return "UNKNOWN";
    }

    private String getResourceString(int n) {
        switch (n) {
            case 3: {
                return "AUDIO_MEDIA";
            }
            case 4: {
                return "AUDIO_PHONE";
            }
            case 5: {
                return "AUDIO_SPEECH";
            }
            case 2: {
                return "MAIN_AUDIO";
            }
            case 1: {
                return "SCREEN";
            }
            case 6: {
                return "AUDIO_GUIDANCE";
            }
            case 7: {
                return "RESOURCE_AUDIO_RINGTONE";
            }
            case 8: {
                return "RESOURCE_NOTIFICATION";
            }
        }
        return "UNKNOWN";
    }

    public int hashCode() {
        int n = 1;
        n = 31 * n + this.owner;
        n = 31 * n + (this.ownershipType == null ? 0 : this.ownershipType.hashCode());
        n = 31 * n + this.resourceId;
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
        AbstractResource abstractResource = (AbstractResource)object;
        if (this.owner != abstractResource.owner) {
            return false;
        }
        if (this.ownershipType == null ? abstractResource.ownershipType != null : !this.ownershipType.equals(abstractResource.ownershipType)) {
            return false;
        }
        return this.resourceId == abstractResource.resourceId;
    }
}

