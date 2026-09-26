/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaDSIBrowserListener;
import de.esolutions.fw.util.commons.Buffer;

class MediaDSIBrowserListener$7
implements Runnable {
    private final /* synthetic */ int val$validFlag;
    private final /* synthetic */ int val$searchCountTotal;
    private final /* synthetic */ int val$searchCountArtist;
    private final /* synthetic */ int val$searchCountAlbum;
    private final /* synthetic */ int val$searchCountTitle;
    private final /* synthetic */ MediaDSIBrowserListener this$0;

    MediaDSIBrowserListener$7(MediaDSIBrowserListener mediaDSIBrowserListener, int n, int n2, int n3, int n4, int n5) {
        this.this$0 = mediaDSIBrowserListener;
        this.val$validFlag = n;
        this.val$searchCountTotal = n2;
        this.val$searchCountArtist = n3;
        this.val$searchCountAlbum = n4;
        this.val$searchCountTitle = n5;
    }

    @Override
    public void run() {
        Object object;
        if (!MediaDSIBrowserListener.access$2600(this.this$0, "updateSearchSize", MediaDSIBrowserListener.access$000(this.this$0).getInstanceID(), this.val$validFlag)) {
            return;
        }
        if (MediaDSIBrowserListener.access$2700(this.this$0).isInfo()) {
            object = new Buffer();
            ((Buffer)object).append("#total='").append(this.val$searchCountTotal).append("',#artist='").append(this.val$searchCountArtist).append("',#album='").append(this.val$searchCountAlbum).append("',#album='").append(this.val$searchCountAlbum).append("',#title='").append(this.val$searchCountTitle).append("'");
            MediaDSIBrowserListener.access$2800(this.this$0).log(1078071040, "[%1.updateSearchSize] [%3] %2", (Object)"MediaDSIBrowserListener", object, (long)MediaDSIBrowserListener.access$000(this.this$0).getInstanceID());
        }
        if ((object = MediaDSIBrowserListener.access$000(this.this$0).getBrowserSearchListener()) == null) {
            MediaDSIBrowserListener.access$2900(this.this$0).log(-1601830656, "[%1.updateSearchSize] No search listener registered!", (Object)"MediaDSIBrowserListener");
            return;
        }
        object.updateSearchSize(this.val$searchCountTotal, this.val$searchCountArtist, this.val$searchCountAlbum, this.val$searchCountTitle);
    }

    public String toString() {
        return new StringBuffer().append(MediaDSIBrowserListener.access$700(this.this$0)).append("updateSearchSize").toString();
    }
}

