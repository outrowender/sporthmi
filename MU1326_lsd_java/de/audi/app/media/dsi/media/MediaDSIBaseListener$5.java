/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaParentalManagementListener;
import de.audi.app.media.dsi.media.MediaDSIBaseListener;
import java.util.Iterator;

class MediaDSIBaseListener$5
implements Runnable {
    private final /* synthetic */ int val$parentalML;
    private final /* synthetic */ MediaDSIBaseListener this$0;

    MediaDSIBaseListener$5(MediaDSIBaseListener mediaDSIBaseListener, int n) {
        this.this$0 = mediaDSIBaseListener;
        this.val$parentalML = n;
    }

    @Override
    public void run() {
        MediaDSIBaseListener.access$1600(this.this$0).log(1078071040, "[%1.updateParentalML] '%2'.", (Object)"MediaDSIBaseListener", (long)this.val$parentalML);
        Iterator iterator = MediaDSIBaseListener.access$1700(this.this$0).iterator();
        while (iterator.hasNext()) {
            try {
                ((IMediaParentalManagementListener)iterator.next()).updateParentalML(this.val$parentalML);
            }
            catch (Exception exception) {
                MediaDSIBaseListener.access$1800(this.this$0).log(-1601830656, "[%1.updateParentalML] %2", (Object)"MediaDSIBaseListener", (Throwable)exception);
            }
        }
    }

    public String toString() {
        return "DSIMediaBase.updateParentalML";
    }
}

