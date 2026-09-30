/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

import de.audi.app.media.dsi.IRequestParameter;

public abstract class AbstractRequestParameter
implements IRequestParameter {
    private boolean outDated = false;
    protected boolean retry = false;

    public abstract boolean equals(Object var1);

    public void setOutDated(boolean bl) {
        this.outDated = bl;
    }

    public boolean isOutdated() {
        return this.outDated;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public boolean isRetry() {
        return this.retry;
    }
}

