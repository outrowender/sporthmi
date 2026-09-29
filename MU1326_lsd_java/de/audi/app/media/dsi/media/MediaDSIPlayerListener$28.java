/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import de.esolutions.fw.util.commons.Buffer;

class MediaDSIPlayerListener$28
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int[] val$subtitleList;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$28(MediaDSIPlayerListener mediaDSIPlayerListener, String string, int[] nArray) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$subtitleList = nArray;
        super(string);
    }

    @Override
    public void run() {
        if (this.val$subtitleList == null) {
            MediaDSIPlayerListener.access$6200(this.this$0).log(-1601830656, "[%1.updateSubtitleList] [%2] Subtitle list is null. Ignore.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID());
            return;
        }
        if (MediaDSIPlayerListener.access$6300(this.this$0).isInfo()) {
            Buffer buffer = new Buffer(20);
            for (int i2 = 0; i2 < this.val$subtitleList.length; ++i2) {
                buffer.append(i2).append(",");
            }
            MediaDSIPlayerListener.access$6400(this.this$0).log(1078071040, "[%1.updateSubtitleList] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)buffer);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updateSubtitleList(this.val$subtitleList);
    }
}

