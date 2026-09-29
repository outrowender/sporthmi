/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;

public class SelectionData {
    private final MediaBrowserSelectionData data;

    public SelectionData(MediaBrowserSelectionData mediaBrowserSelectionData) {
        this.data = mediaBrowserSelectionData;
    }

    public int getBrowserInstance() {
        return this.data.getBrowserInstance();
    }

    public long getTrackID() {
        return this.data.getTrackID();
    }
}

