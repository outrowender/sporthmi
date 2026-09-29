/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sdis.MediaSDISContentHandler;

class MediaSDISContentHandler$6
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$pForward;
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$6(MediaSDISContentHandler mediaSDISContentHandler, String string, boolean bl) {
        this.this$0 = mediaSDISContentHandler;
        this.val$pForward = bl;
        super(string);
    }

    @Override
    public void run() {
        MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.onStartSeek]", (Object)"MediaSDISContentHandler");
        MediaSDISContentHandler.access$100(this.this$0).startSeek(this.val$pForward);
    }
}

