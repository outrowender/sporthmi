/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.evo.content.data.search.dsi.IMediaSearchDataProviderListener;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController;

class MediaDSISearchDataProviderController$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IMediaSearchDataProviderListener val$listener;
    private final /* synthetic */ int val$source;
    private final /* synthetic */ MediaDSISearchDataProviderController this$0;

    MediaDSISearchDataProviderController$3(MediaDSISearchDataProviderController mediaDSISearchDataProviderController, String string, IMediaSearchDataProviderListener iMediaSearchDataProviderListener, int n) {
        this.this$0 = mediaDSISearchDataProviderController;
        this.val$listener = iMediaSearchDataProviderListener;
        this.val$source = n;
        super(string);
    }

    @Override
    public void run() {
        try {
            this.val$listener.activateProviderSource(this.val$source);
        }
        catch (Exception exception) {
            MediaDSISearchDataProviderController.access$200(this.this$0).log(10000, "[%1.activateProviderSource]", (Object)"MediaDSISearchDataProviderController", (Throwable)exception);
        }
    }
}

