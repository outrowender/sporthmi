/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.evo.content.data.search.dsi.IMediaSearchDataProviderListener;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController;

class MediaDSISearchDataProviderController$2
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IMediaSearchDataProviderListener val$listener;
    private final /* synthetic */ int val$success;
    private final /* synthetic */ int val$source;
    private final /* synthetic */ MediaDSISearchDataProviderController this$0;

    MediaDSISearchDataProviderController$2(MediaDSISearchDataProviderController mediaDSISearchDataProviderController, String string, IMediaSearchDataProviderListener iMediaSearchDataProviderListener, int n, int n2) {
        this.this$0 = mediaDSISearchDataProviderController;
        this.val$listener = iMediaSearchDataProviderListener;
        this.val$success = n;
        this.val$source = n2;
        super(string);
    }

    @Override
    public void run() {
        try {
            this.val$listener.registerProviderSourceResult(this.val$success == 0, this.val$source);
        }
        catch (Exception exception) {
            MediaDSISearchDataProviderController.access$100(this.this$0).log(10000, "[%1.registerProviderSourceResult]", (Object)"MediaDSISearchDataProviderController", (Throwable)exception);
        }
    }
}

