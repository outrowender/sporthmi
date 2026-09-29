/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.IPlayerViewListener;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.dsi.media.MediaListEntry;
import org.dsi.ifc.global.ResourceLocator;

public class AbstractMediaPlayViewList$PlayerViewListenerProxy
implements IPlayerViewListener {
    protected final IPlayerViewListener listener;

    public AbstractMediaPlayViewList$PlayerViewListenerProxy(IPlayerViewListener iPlayerViewListener) {
        this.listener = iPlayerViewListener;
    }

    @Override
    public void listInvalidated() {
        this.listener.listInvalidated();
    }

    @Override
    public void listChangeOnSelection(boolean bl) {
        this.listener.listChangeOnSelection(bl);
    }

    @Override
    public void listChanged(boolean bl, long l, int n, int n2) {
        this.listener.listChanged(bl, l, n, n2);
    }

    @Override
    public int getClientID() {
        return this.listener.getClientID();
    }

    @Override
    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
        this.listener.responsePlayView(n, mediaListEntryArray, n2);
    }

    @Override
    public void errorListRequestAborted() {
        this.listener.errorListRequestAborted();
    }

    @Override
    public void notifySameTrackSelected(MediaDetailInfo mediaDetailInfo, ResourceLocator resourceLocator) {
        this.listener.notifySameTrackSelected(mediaDetailInfo, resourceLocator);
    }
}

