/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.IPlayerViewListener;

public interface IPlayViewList
extends IPlayerTrackListener,
IPlayerViewListener {
    public static final int INVALID_LIST_SIZE;

    default public void activate() {
    }

    default public void deactivate() {
    }

    default public int getListSize() {
    }

    default public void setAutomaticCursorMerge(boolean bl) {
    }

    default public void blockList() {
    }

    default public void unblockList() {
    }

    default public void clear() {
    }
}

