/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

public interface IPlayerSelectionRequest {
    public int getBrowserID();

    public long getEntryID();

    public boolean isSeamless();

    public boolean waitForPlayposition();

    public void responseSetSelection(boolean var1);
}

