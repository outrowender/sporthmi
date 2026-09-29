/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ long val$entryID;
    private final /* synthetic */ String val$path;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$5(MediaDSIPlayerListener mediaDSIPlayerListener, String string, long l, String string2) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$entryID = l;
        this.val$path = string2;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$1500(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$1600(this.this$0).log(1078071040, "[%1.responseFullyQualifiedName] [%2] entryID='%3',path='%4'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)new Long(this.val$entryID), (Object)this.val$path);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responseFullyQualifiedName(this.val$entryID, this.val$path);
    }
}

