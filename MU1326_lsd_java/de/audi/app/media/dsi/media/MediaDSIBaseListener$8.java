/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaVersionListener;
import de.audi.app.media.dsi.media.MediaDSIBaseListener;
import java.util.Iterator;

class MediaDSIBaseListener$8
implements Runnable {
    private final /* synthetic */ String val$versionInfo;
    private final /* synthetic */ MediaDSIBaseListener this$0;

    MediaDSIBaseListener$8(MediaDSIBaseListener mediaDSIBaseListener, String string) {
        this.this$0 = mediaDSIBaseListener;
        this.val$versionInfo = string;
    }

    @Override
    public void run() {
        MediaDSIBaseListener.access$2600(this.this$0).log(1078071040, "[%1.updateMetadataDBVersion] '%2'.", (Object)"MediaDSIBaseListener", (Object)this.val$versionInfo);
        if (this.val$versionInfo == null) {
            MediaDSIBaseListener.access$2700(this.this$0).log(-1601830656, "[%1.updateMetadataDBVersion] Version is null. Ignore.", (Object)"MediaDSIBaseListener");
            return;
        }
        Iterator iterator = MediaDSIBaseListener.access$300(this.this$0).iterator();
        while (iterator.hasNext()) {
            try {
                ((IMediaVersionListener)iterator.next()).updateMetadataDBVersion(this.val$versionInfo);
            }
            catch (Exception exception) {
                MediaDSIBaseListener.access$2800(this.this$0).log(-1601830656, "[%1.updateMetadataDBVersion] %2", (Object)"MediaDSIBaseListener", (Throwable)exception);
            }
        }
    }

    public String toString() {
        return "DSIMediaBase.updateMetadataDBVersion";
    }
}

