/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.transfer.dsi;

import de.audi.app.media.transfer.dsi.IMediaRecorderListener;
import de.audi.app.media.transfer.dsi.MediaDSIRecorderListener;

class MediaDSIRecorderListener$1
implements Runnable {
    private final /* synthetic */ int val$browserID;
    private final /* synthetic */ boolean val$result;
    private final /* synthetic */ MediaDSIRecorderListener this$0;

    MediaDSIRecorderListener$1(MediaDSIRecorderListener mediaDSIRecorderListener, int n, boolean bl) {
        this.this$0 = mediaDSIRecorderListener;
        this.val$browserID = n;
        this.val$result = bl;
    }

    @Override
    public void run() {
        IMediaRecorderListener iMediaRecorderListener;
        if (MediaDSIRecorderListener.access$000(this.this$0).isInfo()) {
            MediaDSIRecorderListener.access$100(this.this$0).log(1078071040, "[%1.responseSetSelection] browserID='%2', result='%3'.", (Object)"MediaDSIRecorderListener", (Object)new Integer(this.val$browserID), (Object)this.val$result);
        }
        if ((iMediaRecorderListener = MediaDSIRecorderListener.access$200(this.this$0).getRecorderListener()) == null) {
            return;
        }
        iMediaRecorderListener.responseSetSelection(this.val$browserID, this.val$result);
    }

    public String toString() {
        return "DSIMediaRecorder.responseSetSelection";
    }
}

