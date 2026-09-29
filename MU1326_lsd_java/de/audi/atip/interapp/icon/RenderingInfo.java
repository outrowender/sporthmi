/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.icon;

import de.esolutions.fw.util.commons.Buffer;

public class RenderingInfo {
    private int resourceId;
    private boolean valid;

    public RenderingInfo(int n, boolean bl) {
        this.resourceId = n;
        this.valid = bl;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    public boolean isValid() {
        return this.valid;
    }

    public String toString() {
        Buffer buffer = new Buffer(50);
        buffer.append("[resource ID: ");
        buffer.append(this.resourceId);
        buffer.append(", valid: ");
        buffer.append(this.valid);
        buffer.append(']');
        return buffer.toString();
    }
}

