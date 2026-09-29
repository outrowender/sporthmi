/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$8
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$pInstanceID;
    private final /* synthetic */ int val$selectionResult;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$8(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int n, int n2) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$pInstanceID = n;
        this.val$selectionResult = n2;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$2300(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$2400(this.this$0).log(1078071040, "[%1.responseSetPlaySelection] [%2] browserInstanceID='%3',result='%4'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)new Integer(this.val$pInstanceID), (long)this.val$selectionResult);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responseSetPlaySelection(this.val$pInstanceID, 0 == this.val$selectionResult);
    }
}

