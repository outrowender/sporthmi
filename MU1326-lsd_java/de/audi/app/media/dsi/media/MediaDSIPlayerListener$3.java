/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import de.audi.app.media.dsi.media.requests.RequestParameterEntryID;
import org.dsi.ifc.global.ResourceLocator;

class MediaDSIPlayerListener$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ long val$pEntryID;
    private final /* synthetic */ ResourceLocator val$pResourceLocator;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$3(MediaDSIPlayerListener mediaDSIPlayerListener, String string, long l, ResourceLocator resourceLocator) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$pEntryID = l;
        this.val$pResourceLocator = resourceLocator;
        super(string);
    }

    @Override
    public void run() {
        if (MediaDSIPlayerListener.access$300(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$400(this.this$0).log(1078071040, "[%1.responseCoverArtURL] [%2] entryID='%3',rl='%4'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)new Long(this.val$pEntryID), (Object)this.val$pResourceLocator);
        }
        RequestParameterEntryID requestParameterEntryID = (RequestParameterEntryID)MediaDSIPlayerListener.access$000(this.this$0).getRequestCoverartURLHandler().dataResponded();
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responseCoverArtURL(requestParameterEntryID, this.val$pEntryID, this.val$pResourceLocator);
    }
}

