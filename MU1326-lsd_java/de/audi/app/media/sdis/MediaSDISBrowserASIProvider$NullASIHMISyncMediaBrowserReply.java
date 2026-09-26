/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.sdis.MediaSDISBrowserASIProvider;
import de.audi.app.media.sdis.MediaSDISBrowserASIProvider$1;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;

final class MediaSDISBrowserASIProvider$NullASIHMISyncMediaBrowserReply
implements ASIHMISyncMediaBrowserReply {
    private final /* synthetic */ MediaSDISBrowserASIProvider this$0;

    private MediaSDISBrowserASIProvider$NullASIHMISyncMediaBrowserReply(MediaSDISBrowserASIProvider mediaSDISBrowserASIProvider) {
        this.this$0 = mediaSDISBrowserASIProvider;
    }

    @Override
    public void responseChangeFolder(boolean bl) {
    }

    @Override
    public void responseAddSelection(boolean bl) {
    }

    @Override
    public void responseList(boolean bl, int n, MediaEntry[] mediaEntryArray) {
    }

    @Override
    public void updateASIVersion(String string, boolean bl) {
    }

    @Override
    public void updateActiveSlot(MediaSourceSlot mediaSourceSlot, boolean bl) {
    }

    @Override
    public void updateBrowseMode(int n, boolean bl) {
    }

    @Override
    public void updateDatabaseMode(boolean bl, boolean bl2) {
    }

    @Override
    public void updateRawMode(boolean bl, boolean bl2) {
    }

    @Override
    public void updateBrowseFolder(MediaEntry[] mediaEntryArray, boolean bl) {
    }

    @Override
    public void updateListSize(int n, boolean bl) {
    }

    @Override
    public void updateRequestIDs(short[] sArray, boolean bl) {
    }

    @Override
    public void updateReplyIDs(short[] sArray, boolean bl) {
    }

    /* synthetic */ MediaSDISBrowserASIProvider$NullASIHMISyncMediaBrowserReply(MediaSDISBrowserASIProvider mediaSDISBrowserASIProvider, MediaSDISBrowserASIProvider$1 mediaSDISBrowserASIProvider$1) {
        this(mediaSDISBrowserASIProvider);
    }
}

