/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sdis.MediaSDISContentHandler;

class MediaSDISContentHandler$9
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$pOn;
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$9(MediaSDISContentHandler mediaSDISContentHandler, String string, boolean bl) {
        this.this$0 = mediaSDISContentHandler;
        this.val$pOn = bl;
        super(string);
    }

    @Override
    public void run() {
        MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.onRepeatTitle]", (Object)"MediaSDISContentHandler");
        MediaSDISContentHandler.access$100(this.this$0).getPlaybackModeHandler().setRepeatTitle(this.val$pOn);
    }
}

