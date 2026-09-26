/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sdis.MediaSDISContentHandler;

class MediaSDISContentHandler$17
extends AbstractDispatcherRunnable {
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$17(MediaSDISContentHandler mediaSDISContentHandler, String string) {
        this.this$0 = mediaSDISContentHandler;
        super(string);
    }

    @Override
    public void run() {
        MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.onToggleMixMode]", (Object)"MediaSDISContentHandler");
        MediaSDISContentHandler.access$100(this.this$0).getPlaybackModeHandler().toggleMixMode();
    }
}

