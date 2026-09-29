/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaDSIBrowserListener;
import de.esolutions.fw.util.commons.Buffer;

class MediaDSIBrowserListener$9
implements Runnable {
    private final /* synthetic */ int val$result;
    private final /* synthetic */ int val$selectionState;
    private final /* synthetic */ long val$entriesSelected;
    private final /* synthetic */ boolean val$filesExist;
    private final /* synthetic */ long val$sizeAvail;
    private final /* synthetic */ long val$sizeSelected;
    private final /* synthetic */ long val$entriesAvail;
    private final /* synthetic */ long val$playlistsSelected;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$9(MediaDSIBrowserListener mediaDSIBrowserListener, int n, int n2, long l, boolean bl, long l2, long l3, long l4, long l5) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$result = n;
        this.val$selectionState = n2;
        this.val$entriesSelected = l;
        this.val$filesExist = bl;
        this.val$sizeAvail = l2;
        this.val$sizeSelected = l3;
        this.val$entriesAvail = l4;
        this.val$playlistsSelected = l5;
    }

    @Override
    public void run() {
        Object object;
        if (MediaDSIBrowserListener.access$3300(this.this$0).isInfo()) {
            object = new Buffer(20);
            ((Buffer)object).append("result='").append(this.val$result).append("',state='").append(this.val$selectionState).append("',#entriesSelected='").append(this.val$entriesSelected).append("'");
            MediaDSIBrowserListener.access$3400(this.this$0).log(1078071040, "[%1.selectionResult] [%3] '%2'", (Object)"MediaDSIBrowserListener", object, (Object)new Integer(MediaDSIBrowserListener.access$000(this.this$0).getInstanceID()));
        }
        if ((object = MediaDSIBrowserListener.access$000(this.this$0).getBrowserStateListener()) == null) {
            MediaDSIBrowserListener.access$3500(this.this$0).log(-1601830656, "[%1.selectionResult] No state listener registered!", (Object)"MediaDSIBrowserListener");
            return;
        }
        object.selectionResult(this.val$result, this.val$selectionState, this.val$filesExist, this.val$sizeAvail, this.val$sizeSelected, this.val$entriesAvail, this.val$entriesSelected, this.val$playlistsSelected);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("selectionResult").toString();
    }
}

