/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;
import org.dsi.ifc.global.CharacterInfo;

class MediaDSIBrowserListener$17
implements Runnable {
    private final /* synthetic */ CharacterInfo[] val$characterInfos;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$17(MediaDSIBrowserListener mediaDSIBrowserListener, CharacterInfo[] characterInfoArray) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$characterInfos = characterInfoArray;
    }

    @Override
    public void run() {
        if (MediaDSIBrowserListener.access$5600(this.this$0).isInfo()) {
            MediaDSIBrowserListener.access$5700(this.this$0).log(1078071040, "[%1.updateAlphabeticalIndex] [%2]", (Object)"MediaDSIBrowserListener", (Object)String.valueOf(MediaDSIBrowserListener.access$000(this.this$0).getInstanceID()));
        }
        if (null == this.val$characterInfos) {
            MediaDSIBrowserListener.access$5800(this.this$0).log(-1601830656, "[%1.updateAlphabeticalIndex] Invalid character information", (Object)"MediaDSIBrowserListener");
            return;
        }
        IMediaBrowserStateListener iMediaBrowserStateListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserStateListener();
        if (iMediaBrowserStateListener == null) {
            return;
        }
        iMediaBrowserStateListener.updateAlphabeticalIndex(this.val$characterInfos);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("updateAlphabeticalIndex").toString();
    }
}

