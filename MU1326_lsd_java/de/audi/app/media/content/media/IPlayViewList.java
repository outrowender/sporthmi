/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.IPlayerViewListener;

public interface IPlayViewList
extends IPlayerTrackListener,
IPlayerViewListener {
    public static final int INVALID_LIST_SIZE = -1;

    public void activate();

    public void deactivate();

    public int getListSize();

    public void setAutomaticCursorMerge(boolean var1);

    public void blockList();

    public void unblockList();

    public void clear();
}

