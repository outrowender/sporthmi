/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import de.esolutions.fw.util.commons.Buffer;

class MediaDSIPlayerListener$13
extends AbstractDispatcherRunnable {
    private final /* synthetic */ long val$deviceID;
    private final /* synthetic */ long val$mediaID;
    private final /* synthetic */ int val$groupID;
    private final /* synthetic */ int val$playerID;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$13(MediaDSIPlayerListener mediaDSIPlayerListener, String string, long l, long l2, int n, int n2) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$deviceID = l;
        this.val$mediaID = l2;
        this.val$groupID = n;
        this.val$playerID = n2;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$3200(this.this$0).isInfo()) {
            Buffer buffer = new Buffer(20);
            buffer.append("deviceID='").append(this.val$deviceID).append("',mediaID='").append(this.val$mediaID).append("',groupID='").append(this.val$groupID).append("',playerID='").append(this.val$playerID).append("'");
            MediaDSIPlayerListener.access$3300(this.this$0).log(1078071040, "[%1.updateActiveMedia] [%2] %3", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)buffer);
        }
        MediaDSIPlayerListener.access$3400(this.this$0);
        if (this.val$deviceID == 0L && this.val$mediaID == 0L) {
            MediaDSIPlayerListener.access$3500(this.this$0).log(1078071040, "[%1.updateActiveMedia] [%2] Player deactivated.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID());
            MediaDSIPlayerListener.access$000(this.this$0).sourceDeviceDeactivated();
            return;
        }
        MediaDSIPlayerListener.access$000(this.this$0).sourceDeviceActivated(this.val$deviceID, this.val$mediaID, this.val$playerID, true);
    }
}

