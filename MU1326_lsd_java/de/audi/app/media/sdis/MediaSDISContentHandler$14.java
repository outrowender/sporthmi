/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.sdis.MediaSDISContentHandler;

class MediaSDISContentHandler$14
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IPlayerSelectionRequest val$pRequest;
    private final /* synthetic */ MediaSDISContentHandler this$0;

    MediaSDISContentHandler$14(MediaSDISContentHandler mediaSDISContentHandler, String string, IPlayerSelectionRequest iPlayerSelectionRequest) {
        this.this$0 = mediaSDISContentHandler;
        this.val$pRequest = iPlayerSelectionRequest;
        super(string);
    }

    @Override
    public void run() {
        MediaSDISContentHandler.access$000(this.this$0).log(1078071040, "[%1.onSetPlaySelection] '%2'", (Object)"MediaSDISContentHandler", (Object)this.val$pRequest);
        MediaSDISContentHandler.access$100(this.this$0).setBrowserPlayerSelection(this.val$pRequest);
    }
}

