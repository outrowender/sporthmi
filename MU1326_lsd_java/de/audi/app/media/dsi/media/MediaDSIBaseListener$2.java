/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaVersionListener;
import de.audi.app.media.dsi.media.MediaDSIBaseListener;
import java.util.Iterator;

class MediaDSIBaseListener$2
implements Runnable {
    private final /* synthetic */ int val$isAvailable;
    private final /* synthetic */ MediaDSIBaseListener this$0;

    MediaDSIBaseListener$2(MediaDSIBaseListener mediaDSIBaseListener, int n) {
        this.this$0 = mediaDSIBaseListener;
        this.val$isAvailable = n;
    }

    @Override
    public void run() {
        MediaDSIBaseListener.access$200(this.this$0).log(1078071040, "[%1.updateCustomerUpdate] '%2'.", (Object)"MediaDSIBaseListener", (long)this.val$isAvailable);
        Iterator iterator = MediaDSIBaseListener.access$300(this.this$0).iterator();
        while (iterator.hasNext()) {
            try {
                ((IMediaVersionListener)iterator.next()).updateCustomerUpdate(this.val$isAvailable);
            }
            catch (Exception exception) {
                MediaDSIBaseListener.access$400(this.this$0).log(-1601830656, "[%1.updateCustomerUpdate] %2", (Object)"MediaDSIBaseListener", (Throwable)exception);
            }
        }
    }

    public String toString() {
        return "DSIMediaBase.updateCustomerUpdate";
    }
}

