/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.combi.bap.app.audio;

import de.audi.app.combi.bap.app.audio.AppConnectorMedia;
import de.audi.app.combi.bap.app.audio.list.MediaBrowserListHandler;
import edu.emory.mathcs.backport.java.util.concurrent.Callable;

class AppConnectorMedia$1
implements Callable {
    private final /* synthetic */ int val$listSize;
    private final /* synthetic */ AppConnectorMedia this$0;

    AppConnectorMedia$1(AppConnectorMedia appConnectorMedia, int n) {
        this.this$0 = appConnectorMedia;
        this.val$listSize = n;
    }

    @Override
    public Object call() {
        AppConnectorMedia.access$500(this.this$0).log(1078071040, "[AppConnectorMedia#updateBrowserListSize] called (listSize=%1)", (long)this.val$listSize);
        MediaBrowserListHandler mediaBrowserListHandler = (MediaBrowserListHandler)AppConnectorMedia.access$600(this.this$0).getBAPFunctionArrayFSG(36).getArrayHandler();
        mediaBrowserListHandler.notifyListSizeChanged(this.val$listSize);
        return null;
    }
}

