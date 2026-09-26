/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaVersionListener;
import de.audi.app.media.dsi.media.MediaDSIBaseListener;
import java.util.Iterator;

class MediaDSIBaseListener$7
implements Runnable {
    private final /* synthetic */ String val$versionInfo;
    private final /* synthetic */ MediaDSIBaseListener this$0;

    MediaDSIBaseListener$7(MediaDSIBaseListener mediaDSIBaseListener, String string) {
        this.this$0 = mediaDSIBaseListener;
        this.val$versionInfo = string;
    }

    @Override
    public void run() {
        MediaDSIBaseListener.access$2300(this.this$0).log(1078071040, "[%1.updateApplicationVersion] '%2'.", (Object)"MediaDSIBaseListener", (Object)this.val$versionInfo);
        if (this.val$versionInfo == null) {
            MediaDSIBaseListener.access$2400(this.this$0).log(-1601830656, "[%1.updateApplicationVersion] Version is null. Ignore.", (Object)"MediaDSIBaseListener");
            return;
        }
        Iterator iterator = MediaDSIBaseListener.access$300(this.this$0).iterator();
        while (iterator.hasNext()) {
            try {
                ((IMediaVersionListener)iterator.next()).updateMediaApplicationVersion(this.val$versionInfo);
            }
            catch (Exception exception) {
                MediaDSIBaseListener.access$2500(this.this$0).log(-1601830656, "[%1.updateApplicationVersion] %2", (Object)"MediaDSIBaseListener", (Throwable)exception);
            }
        }
    }

    public String toString() {
        return "DSIMediaBase.updateApplicationVersion";
    }
}

