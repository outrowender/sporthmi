/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.combi;

public abstract class AbstractCombiElement {
    public boolean dirty = false;
    private boolean mergingAllowed = true;

    public boolean isMergingAllowed() {
        return this.mergingAllowed;
    }

    public void setMergingAllowed(boolean bl) {
        this.mergingAllowed = bl;
    }

    public final void copyTo(AbstractCombiElement abstractCombiElement) {
        abstractCombiElement.dirty = this.dirty;
    }

    public abstract void reset();
}

