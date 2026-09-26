/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$6
extends AbstractDispatcherRunnable {
    private final /* synthetic */ long val$entryID;
    private final /* synthetic */ boolean val$result;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$6(MediaDSIPlayerListener mediaDSIPlayerListener, String string, long l, boolean bl) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$entryID = l;
        this.val$result = bl;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$1700(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$1800(this.this$0).log(1078071040, "[%1.responsePlaySimilarEntry] [%2] entryID='%3',result='%4'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)new Long(this.val$entryID), (Object)String.valueOf(this.val$result));
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responsePlaySimilarEntry(this.val$entryID, this.val$result);
    }
}

