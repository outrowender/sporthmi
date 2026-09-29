/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sdis.MediaSDISContentHandler;

class MediaSDISContentHandler$8
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$pOn;
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$8(MediaSDISContentHandler mediaSDISContentHandler, String string, boolean bl) {
        this.this$0 = mediaSDISContentHandler;
        this.val$pOn = bl;
        super(string);
    }

    @Override
    public void run() {
        MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.onMix]", (Object)"MediaSDISContentHandler");
        MediaSDISContentHandler.access$100(this.this$0).getPlaybackModeHandler().setRepeatScope(MediaSDISContentHandler.access$100(this.this$0).getPlaybackModeHandler().getActiveRepeatScope(), this.val$pOn);
    }
}

