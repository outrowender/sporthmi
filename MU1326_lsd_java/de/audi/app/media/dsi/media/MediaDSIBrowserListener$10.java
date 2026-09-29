/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaBrowserStateListener;
import de.audi.app.media.dsi.media.MediaDSIBrowserListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import org.dsi.ifc.media.ListEntry;

class MediaDSIBrowserListener$10
implements Runnable {
    private final /* synthetic */ ListEntry[] val$activeBrowsingFolder;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$10(MediaDSIBrowserListener mediaDSIBrowserListener, ListEntry[] listEntryArray) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$activeBrowsingFolder = listEntryArray;
    }

    @Override
    public void run() {
        IMediaBrowserStateListener iMediaBrowserStateListener;
        if (this.val$activeBrowsingFolder == null) {
            MediaDSIBrowserListener.access$3600(this.this$0).log(-1601830656, "[%1.updateBrowseFolder] [%2] Folder is null", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
            return;
        }
        if (this.val$activeBrowsingFolder.length <= 0) {
            MediaDSIBrowserListener.access$3700(this.this$0).log(-1601830656, "[%1.updateBrowseFolder] [%2] Folder length <= 0", (Object)"MediaDSIBrowserListener", (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
            return;
        }
        if (MediaDSIBrowserListener.access$3800(this.this$0).isInfo()) {
            MediaDSIBrowserListener.access$3900(this.this$0).log(1078071040, "[%1.updateBrowseFolder] [%3] '%2'.", (Object)"MediaDSIBrowserListener", (Object)LogUtil.listEntryToStr(this.val$activeBrowsingFolder), (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
        }
        if ((iMediaBrowserStateListener = MediaDSIBrowserListener.access$000(this.this$0).getBrowserStateListener()) == null) {
            MediaDSIBrowserListener.access$4000(this.this$0).log(-1601830656, "[%1.updateBrowseFolder] No state listener registered!", (Object)"MediaDSIBrowserListener");
            return;
        }
        iMediaBrowserStateListener.updateBrowseFolder(MediaListEntry.convert(this.val$activeBrowsingFolder));
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("updateBrowseFolder").toString();
    }
}

