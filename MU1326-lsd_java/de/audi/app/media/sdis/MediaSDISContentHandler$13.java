/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.IPlayViewListRequest;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.sdis.JobPlayViewListRequest;
import de.audi.app.media.sdis.MediaSDISContentHandler;

class MediaSDISContentHandler$13
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IPlayViewListRequest val$pRequest;
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$13(MediaSDISContentHandler mediaSDISContentHandler, String string, IPlayViewListRequest iPlayViewListRequest) {
        this.this$0 = mediaSDISContentHandler;
        this.val$pRequest = iPlayViewListRequest;
        super(string);
    }

    @Override
    public void run() {
        if (!MediaSDISContentHandler.access$100(this.this$0).supportsPlayListHandling()) {
            MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.onRequestPlayList] No list support.", (Object)"MediaSDISContentHandler");
            this.val$pRequest.responsePlayList(false, 0, new MediaListEntry[0]);
            return;
        }
        MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.onRequestPlayList]", (Object)"MediaSDISContentHandler");
        MediaSDISContentHandler.access$400(this.this$0).enqueue(new JobPlayViewListRequest(MediaSDISContentHandler.access$000(this.this$0), this.val$pRequest, MediaSDISContentHandler.access$100(this.this$0)));
    }
}

