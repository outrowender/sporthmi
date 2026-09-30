/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

public interface IMediaBrowserListener {
    public void browseSourceActivated();

    public void browseSourceDeactivated();

    public void browseSourceInvalidated();

    public void asyncException(int var1, String var2, int var3);
}

