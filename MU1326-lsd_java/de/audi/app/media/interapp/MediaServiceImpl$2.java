/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.interapp;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.interapp.MediaServiceImpl;
import de.audi.app.media.source.ActivationContext;
import de.audi.app.media.source.ISource;
import de.audi.app.media.source.ISourceController;

class MediaServiceImpl$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ISourceController val$sourceController;
    private final /* synthetic */ ISource val$source;
    private final /* synthetic */ int val$pSlotIdx;
    private final /* synthetic */ MediaServiceImpl this$0;

    MediaServiceImpl$2(MediaServiceImpl mediaServiceImpl, String string, ISourceController iSourceController, ISource iSource, int n) {
        this.this$0 = mediaServiceImpl;
        this.val$sourceController = iSourceController;
        this.val$source = iSource;
        this.val$pSlotIdx = n;
        super(string);
    }

    @Override
    public void run() {
        this.val$sourceController.activateSource(new ActivationContext(this.val$source.getSlot(this.val$pSlotIdx)));
    }
}

