/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sdis.MediaSDISContentHandler;

class MediaSDISContentHandler$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ long val$id;
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$2(MediaSDISContentHandler mediaSDISContentHandler, String string, long l) {
        this.this$0 = mediaSDISContentHandler;
        this.val$id = l;
        super(string);
    }

    @Override
    public void run() {
        MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.onPlayEntry] '%2'", (Object)"MediaSDISContentHandler", this.val$id);
        MediaSDISContentHandler.access$100(this.this$0).playEntry(this.val$id);
    }
}

