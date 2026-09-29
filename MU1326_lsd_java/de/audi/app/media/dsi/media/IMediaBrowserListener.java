/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

public interface IMediaBrowserListener {
    default public void browseSourceActivated() {
    }

    default public void browseSourceDeactivated() {
    }

    default public void browseSourceInvalidated() {
    }

    default public void asyncException(int n, String string, int n2) {
    }
}

