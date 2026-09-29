/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.sdis.MediaSDISContentHandler;

class MediaSDISContentHandler$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$count;
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$5(MediaSDISContentHandler mediaSDISContentHandler, String string, int n) {
        this.this$0 = mediaSDISContentHandler;
        this.val$count = n;
        super(string);
    }

    @Override
    public void run() {
        MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.onSkip]", (Object)"MediaSDISContentHandler");
        MediaSDISContentHandler.access$100(this.this$0).skip(this.val$count > 0, Math.abs(this.val$count));
    }
}

