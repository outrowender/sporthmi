/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import de.audi.app.media.dsi.media.requests.RequestParameterEntryID;
import de.audi.app.media.logger.LogUtil;
import org.dsi.ifc.media.EntryInfo;

class MediaDSIPlayerListener$4
extends AbstractDispatcherRunnable {
    private final /* synthetic */ EntryInfo val$pEntryInfo;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$4(MediaDSIPlayerListener mediaDSIPlayerListener, String string, EntryInfo entryInfo) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$pEntryInfo = entryInfo;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$500(this.this$0).log(1078071040, "[%1.responseDetailInfo] [%2]", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID());
        RequestParameterEntryID requestParameterEntryID = (RequestParameterEntryID)MediaDSIPlayerListener.access$000(this.this$0).getRequestDetailInfoHandler().dataResponded();
        if (this.val$pEntryInfo == null) {
            MediaDSIPlayerListener.access$600(this.this$0).log(-1601830656, "[%1.responseDetailInfo] [%2] Detail info null. Ignore.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID());
            return;
        }
        if (MediaDSIPlayerListener.access$700(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$800(this.this$0).log(1078071040, "[%1.responseDetailInfo] entryID='%2',fileName='%3',title='%4'", (Object)"MediaDSIPlayerListener", (Object)String.valueOf(this.val$pEntryInfo.getEntryID()), (Object)this.val$pEntryInfo.getFilename(), (Object)this.val$pEntryInfo.getTitle());
            MediaDSIPlayerListener.access$900(this.this$0).log(1078071040, "[%1.responseDetailInfo] albumID ='%2',album ='%3'", (Object)"MediaDSIPlayerListener", (Object)String.valueOf(this.val$pEntryInfo.getAlbumID()), (Object)this.val$pEntryInfo.getAlbum());
            MediaDSIPlayerListener.access$1000(this.this$0).log(1078071040, "[%1.responseDetailInfo] artistID='%2',artist='%3'", (Object)"MediaDSIPlayerListener", (Object)String.valueOf(this.val$pEntryInfo.getArtistID()), (Object)this.val$pEntryInfo.getArtist());
            MediaDSIPlayerListener.access$1100(this.this$0).log(1078071040, "[%1.responseDetailInfo] genreID ='%2',genre ='%3'", (Object)"MediaDSIPlayerListener", (Object)String.valueOf(this.val$pEntryInfo.getGenreID()), (Object)this.val$pEntryInfo.getGenre());
            MediaDSIPlayerListener.access$1200(this.this$0).log(1078071040, "[%1.responseDetailInfo] contentType='%2'", (Object)"MediaDSIPlayerListener", (Object)LogUtil.getListEntryContentTypeStr(this.val$pEntryInfo.getContentType()));
            MediaDSIPlayerListener.access$1300(this.this$0).log(1078071040, "[%1.responseDetailInfo] flags='%2'", (Object)"MediaDSIPlayerListener", (long)this.val$pEntryInfo.flags);
            if (null != this.val$pEntryInfo.getChapterInfo()) {
                MediaDSIPlayerListener.access$1400(this.this$0).log(1078071040, "[%1.responseDetailInfo] activeChapter='%2' totalChapter='%3'", (Object)"MediaDSIPlayerListener", (long)this.val$pEntryInfo.getChapterInfo().getActiveChapter(), (long)this.val$pEntryInfo.getChapterInfo().getNumChapters());
            }
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responseDetailInfo(requestParameterEntryID, this.val$pEntryInfo);
    }
}

