/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

import de.audi.app.media.dsi.IRequestParameter;

public abstract class AbstractRequestParameter
implements IRequestParameter {
    private boolean outDated = false;
    protected boolean retry = false;

    @Override
    public abstract boolean equals(Object object) {
    }

    @Override
    public void setOutDated(boolean bl) {
        this.outDated = bl;
    }

    @Override
    public boolean isOutdated() {
        return this.outDated;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean isRetry() {
        return this.retry;
    }
}

