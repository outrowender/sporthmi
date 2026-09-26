/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaLanguageListener;
import de.audi.app.media.dsi.media.MediaDSIBaseListener;
import java.util.Iterator;

class MediaDSIBaseListener$6
implements Runnable {
    private final /* synthetic */ String val$pPreferredLanguage;
    private final /* synthetic */ MediaDSIBaseListener this$0;

    MediaDSIBaseListener$6(MediaDSIBaseListener mediaDSIBaseListener, String string) {
        this.this$0 = mediaDSIBaseListener;
        this.val$pPreferredLanguage = string;
    }

    @Override
    public void run() {
        MediaDSIBaseListener.access$1900(this.this$0).log(1078071040, "[%1.updatePreferredLanguage] '%2'.", (Object)"MediaDSIBaseListener", (Object)this.val$pPreferredLanguage);
        if (this.val$pPreferredLanguage == null) {
            MediaDSIBaseListener.access$2000(this.this$0).log(-1601830656, "[%1.updatePreferredLanguage] Language is null. Ignore.", (Object)"MediaDSIBaseListener");
            return;
        }
        Iterator iterator = MediaDSIBaseListener.access$2100(this.this$0).iterator();
        while (iterator.hasNext()) {
            try {
                ((IMediaLanguageListener)iterator.next()).updatePreferredLanguage(this.val$pPreferredLanguage);
            }
            catch (Exception exception) {
                MediaDSIBaseListener.access$2200(this.this$0).log(-1601830656, "[%1.updatePreferredLanguage] %2", (Object)"MediaDSIBaseListener", (Throwable)exception);
            }
        }
    }

    public String toString() {
        return "DSIMediaBase.updatePreferredLanguage";
    }
}

