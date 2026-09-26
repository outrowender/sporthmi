/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.evo.content.data.search.dsi.IMediaSearchDataProviderListener;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController;

class MediaDSISearchDataProviderController$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IMediaSearchDataProviderListener val$listener;
    private final /* synthetic */ int val$source;
    private final /* synthetic */ int val$offset;
    private final /* synthetic */ int val$count;
    private final /* synthetic */ MediaDSISearchDataProviderController this$0;

    MediaDSISearchDataProviderController$5(MediaDSISearchDataProviderController mediaDSISearchDataProviderController, String string, IMediaSearchDataProviderListener iMediaSearchDataProviderListener, int n, int n2, int n3) {
        this.this$0 = mediaDSISearchDataProviderController;
        this.val$listener = iMediaSearchDataProviderListener;
        this.val$source = n;
        this.val$offset = n2;
        this.val$count = n3;
        super(string);
    }

    @Override
    public void run() {
        try {
            this.val$listener.provideData(this.val$source, this.val$offset, this.val$count);
        }
        catch (Exception exception) {
            MediaDSISearchDataProviderController.access$400(this.this$0).log(10000, "[%1.provideData]", (Object)"MediaDSISearchDataProviderController", (Throwable)exception);
        }
    }
}

