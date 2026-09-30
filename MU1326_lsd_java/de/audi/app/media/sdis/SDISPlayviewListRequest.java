/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.content.media.AbstractPlayViewListRequest;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.sdis.MediaUtilsSDIS;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;

public class SDISPlayviewListRequest
extends AbstractPlayViewListRequest {
    private static final String LOGCLASS = "SDISPlayviewListRequest";
    private final ASIHMISyncMediaReply reply;
    private final LogChannel logger;

    public SDISPlayviewListRequest(LogChannel logChannel, int n, long l, int n2, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        super(5, n, l, n2);
        this.logger = logChannel;
        this.reply = aSIHMISyncMediaReply;
    }

    public void responsePlayList(boolean bl, int n, MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1000000, "[%1.responsePlayList]", (Object)LOGCLASS);
        try {
            this.reply.responsePlayList(bl, n, MediaUtilsSDIS.convert2ASIMediaEntries(mediaListEntryArray));
        }
        catch (Exception exception) {
            this.logger.log(100000, "[%1.responsePlayList]", (Object)LOGCLASS, (Throwable)exception);
        }
    }
}

