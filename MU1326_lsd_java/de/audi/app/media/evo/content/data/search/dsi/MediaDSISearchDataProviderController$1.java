/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.evo.content.data.search.dsi;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.evo.content.data.search.dsi.IMediaSearchDataProviderListener;
import de.audi.app.media.evo.content.data.search.dsi.MediaDSISearchDataProviderController;

class MediaDSISearchDataProviderController$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ IMediaSearchDataProviderListener val$listener;
    private final /* synthetic */ int val$errorCode;
    private final /* synthetic */ String val$errorMsg;
    private final /* synthetic */ int val$requestType;
    private final /* synthetic */ MediaDSISearchDataProviderController this$0;

    MediaDSISearchDataProviderController$1(MediaDSISearchDataProviderController mediaDSISearchDataProviderController, String string, IMediaSearchDataProviderListener iMediaSearchDataProviderListener, int n, String string2, int n2) {
        this.this$0 = mediaDSISearchDataProviderController;
        this.val$listener = iMediaSearchDataProviderListener;
        this.val$errorCode = n;
        this.val$errorMsg = string2;
        this.val$requestType = n2;
        super(string);
    }

    @Override
    public void run() {
        try {
            this.val$listener.asyncException(this.val$errorCode, this.val$errorMsg, this.val$requestType);
        }
        catch (Exception exception) {
            MediaDSISearchDataProviderController.access$000(this.this$0).log(10000, "[%1.asyncException]", (Object)"MediaDSISearchDataProviderController", (Throwable)exception);
        }
    }
}

