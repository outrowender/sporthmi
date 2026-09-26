/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.browser;

import de.audi.app.media.browser.BrowseListContextImpl;
import de.audi.app.media.browser.IBrowseListListener;
import de.audi.app.media.dsi.media.IMediaBrowserListListener;
import de.audi.app.media.dsi.media.MediaListEntry;

class BrowseListContextImpl$3
implements IMediaBrowserListListener {
    private final /* synthetic */ IBrowseListListener val$pBrowseListListener;
    private final /* synthetic */ BrowseListContextImpl this$0;

    BrowseListContextImpl$3(BrowseListContextImpl browseListContextImpl, IBrowseListListener iBrowseListListener) {
        this.this$0 = browseListContextImpl;
        this.val$pBrowseListListener = iBrowseListListener;
    }

    @Override
    public void responseList(MediaListEntry[] mediaListEntryArray, int n) {
        BrowseListContextImpl.access$100(this.this$0).responseList(false, mediaListEntryArray, n);
        this.val$pBrowseListListener.responseList(false, mediaListEntryArray, n);
    }

    @Override
    public int getClientID() {
        return this.val$pBrowseListListener.getClientId();
    }

    @Override
    public void errorListRequestAborted() {
        BrowseListContextImpl.access$100(this.this$0).responseList(true, null, -1);
        this.val$pBrowseListListener.responseList(true, null, -1);
    }

    @Override
    public void responsePickList(MediaListEntry[] mediaListEntryArray) {
        BrowseListContextImpl.access$100(this.this$0).responsePickList(false, mediaListEntryArray);
        this.val$pBrowseListListener.responsePickList(false, mediaListEntryArray);
    }

    @Override
    public void errorPickListRequestAborted() {
        BrowseListContextImpl.access$100(this.this$0).responsePickList(true, null);
        this.val$pBrowseListListener.responsePickList(true, null);
    }
}

