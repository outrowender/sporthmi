/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.evo.content.data.search.dsi.IMediaSearchDataProviderListener;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController;

class MediaDSISearchDataProviderController$7
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IMediaSearchDataProviderListener val$listener;
    private final /* synthetic */ int val$success;
    private final /* synthetic */ int val$source;
    private final /* synthetic */ long val$dataSetId;
    private final /* synthetic */ MediaDSISearchDataProviderController this$0;

    MediaDSISearchDataProviderController$7(MediaDSISearchDataProviderController mediaDSISearchDataProviderController, String string, IMediaSearchDataProviderListener iMediaSearchDataProviderListener, int n, int n2, long l) {
        this.this$0 = mediaDSISearchDataProviderController;
        this.val$listener = iMediaSearchDataProviderListener;
        this.val$success = n;
        this.val$source = n2;
        this.val$dataSetId = l;
        super(string);
    }

    @Override
    public void run() {
        try {
            this.val$listener.deleteDataSetResult(this.val$success == 0, this.val$source, this.val$dataSetId);
        }
        catch (Exception exception) {
            MediaDSISearchDataProviderController.access$600(this.this$0).log(10000, "[%1.deleteDataSetResult]", (Object)"MediaDSISearchDataProviderController", (Throwable)exception);
        }
    }
}

