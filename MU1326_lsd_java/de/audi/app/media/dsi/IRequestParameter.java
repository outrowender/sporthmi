/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi;

public interface IRequestParameter {
    public int getClientID();

    public boolean isOutdated();

    public void setOutDated(boolean var1);

    public boolean equals(Object var1);

    public boolean isRetry();
}

