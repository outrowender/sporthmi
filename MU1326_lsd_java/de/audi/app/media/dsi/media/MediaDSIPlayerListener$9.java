/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$9
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pInstanceID;
    private final /* synthetic */ boolean val$pResult;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$9(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n, boolean bl) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$pInstanceID = n;
        this.val$pResult = bl;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$2500(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$2600(this.this$0).log(1078071040, "[%1.responseSetPlaySelectionAB] [%2] coverflowInstanceID='%3',result='%4'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)new Integer(this.val$pInstanceID), (Object)String.valueOf(this.val$pResult));
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responseSetPlaySelectionCoverflow(this.val$pInstanceID, this.val$pResult);
    }
}

