/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

public interface IPlayerSelectionRequest {
    default public int getBrowserID() {
    }

    default public long getEntryID() {
    }

    default public boolean isSeamless() {
    }

    default public boolean waitForPlayposition() {
    }

    default public void responseSetSelection(boolean bl) {
    }
}

