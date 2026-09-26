/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaDeviceListener;
import de.audi.app.media.dsi.media.MediaDSIBaseListener;
import de.audi.app.media.logger.LogUtil;
import java.util.Iterator;
import org.dsi.ifc.media.MediaInfo;

class MediaDSIBaseListener$4
implements Runnable {
    private final /* synthetic */ MediaInfo[] val$mediaList;
    private final /* synthetic */ MediaDSIBaseListener this$0;

    MediaDSIBaseListener$4(MediaDSIBaseListener mediaDSIBaseListener, MediaInfo[] mediaInfoArray) {
        this.this$0 = mediaDSIBaseListener;
        this.val$mediaList = mediaInfoArray;
    }

    @Override
    public void run() {
        if (this.val$mediaList == null) {
            MediaDSIBaseListener.access$1100(this.this$0).log(-1601830656, "[%1.updateMediaList] Media list is null. Ignore.", (Object)"MediaDSIBaseListener");
            return;
        }
        if (this.val$mediaList.length == 0) {
            MediaDSIBaseListener.access$1200(this.this$0).log(-1601830656, "[%1.updateMediaList] Media list contains no entries. Ignore.", (Object)"MediaDSIBaseListener");
            return;
        }
        if (MediaDSIBaseListener.access$1300(this.this$0).isInfo()) {
            for (int i2 = 0; i2 < this.val$mediaList.length; ++i2) {
                MediaDSIBaseListener.access$1400(this.this$0).log(1078071040, "[%1.updateMediaList] MediaInfo[%2] %3", (Object)"MediaDSIBaseListener", (Object)new Integer(i2), (Object)LogUtil.mediaInfoToStr(this.val$mediaList[i2]));
            }
        }
        Iterator iterator = MediaDSIBaseListener.access$900(this.this$0).iterator();
        while (iterator.hasNext()) {
            try {
                ((IMediaDeviceListener)iterator.next()).updateMediaList(this.val$mediaList);
            }
            catch (Exception exception) {
                MediaDSIBaseListener.access$1500(this.this$0).log(-1601830656, "[%1.updateMediaList] %2", (Object)"MediaDSIBaseListener", (Throwable)exception);
            }
        }
    }

    public String toString() {
        return "DSIMediaBase.updateMediaList";
    }
}

