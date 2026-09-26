/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import org.dsi.ifc.media.AudioStream;

class MediaDSIPlayerListener$16
extends AbstractDispatcherRunnable {
    private final /* synthetic */ AudioStream[] val$audioStreamList;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$16(MediaDSIPlayerListener mediaDSIPlayerListener, String string, AudioStream[] audioStreamArray) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$audioStreamList = audioStreamArray;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$4000(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$4100(this.this$0).log(1078071040, "[%1.updateAudioStreamList] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)this.val$audioStreamList);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updateAudioStreamList(this.val$audioStreamList);
    }
}

