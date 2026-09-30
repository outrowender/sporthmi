/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaPlayViewList;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class PlayViewListRequest
extends AbstractQueueJob {
    private static final String LOGCLASS = "PlayViewListRequest";
    private static final int NO_REQUEST_ID = -1;
    private static final int INVALID_ENTRYID = -1;
    private static final int INVALID_INDEX = -1;
    private static final int INVALID_LENGTH = -1;
    private final LogChannel logger;
    private final AbstractMediaPlayViewList playViewList;
    protected final IPlayer player;
    private final int startIndex;
    private final int length;
    private final long entryId;
    private final int requestId;

    private PlayViewListRequest(LogChannel logChannel, AbstractMediaPlayViewList abstractMediaPlayViewList, IPlayer iPlayer, int n, int n2, long l, int n3) {
        this.logger = logChannel;
        this.playViewList = abstractMediaPlayViewList;
        this.startIndex = n;
        this.length = n2;
        this.requestId = n3;
        this.entryId = l;
        this.player = iPlayer;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public PlayViewListRequest(LogChannel logChannel, AbstractMediaPlayViewList abstractMediaPlayViewList, IPlayer iPlayer, int n, int n2) {
        this(logChannel, abstractMediaPlayViewList, iPlayer, n, n2, -1L, -1);
    }

    public PlayViewListRequest(LogChannel logChannel, AbstractMediaPlayViewList abstractMediaPlayViewList, IPlayer iPlayer, int n, int n2, int n3) {
        this(logChannel, abstractMediaPlayViewList, iPlayer, n, n2, -1L, n3);
    }

    public PlayViewListRequest(LogChannel logChannel, AbstractMediaPlayViewList abstractMediaPlayViewList, IPlayer iPlayer, long l) {
        this(logChannel, abstractMediaPlayViewList, iPlayer, -1, -1, l, -1);
    }

    public int getType() {
        return 0;
    }

    public String getName() {
        return LOGCLASS;
    }

    public void start() {
        this.logger.log(1000000, "[%1.start]", (Object)LOGCLASS);
        if (-1L == this.entryId) {
            this.requestPlayViewListIndexBased(this.startIndex, this.length);
        } else {
            this.requestPlayViewList(this.entryId);
        }
    }

    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
        this.logger.log(1000000, "[%1.responsePlayView]", (Object)LOGCLASS);
        this.playViewList.updateList(mediaListEntryArray, n, n2, this.requestId);
        this.getExecutionContext().jobFinished();
    }

    public void abort(boolean bl) {
        this.logger.log(1000000, "[%1.abort] run='%2'", (Object)LOGCLASS, (Object)Boolean.toString(bl));
        if (-1 != this.requestId) {
            this.playViewList.getPlayViewListModel().setRows(this.requestId, this.startIndex, new EvoListRow[0]);
        }
        if (bl) {
            this.player.discardPlayViewRequests(this.playViewList.getClientID());
        }
    }

    protected final void requestPlayViewListIndexBased(int n, int n2) {
        this.logger.log(1000000, "[%1.requestPlayViewListIndexBased] '%2' '%3'.", (Object)LOGCLASS, (long)n, (long)n2);
        if (this.playViewList.getListProgressIndicator() != null) {
            this.playViewList.getListProgressIndicator().startIndication();
        }
        if (this.playViewList.getListSize() > this.playViewList.getWindowRequestSize() && !this.playViewList.isRequestFullList()) {
            this.logger.log(1000000, "[%1.requestPlayViewList] Request window.", (Object)LOGCLASS);
            this.player.requestPlayViewListIndexBased(this.playViewList.getClientID(), n, n2);
        } else {
            this.logger.log(1000000, "[%1.requestPlayViewList] Request full list.", (Object)LOGCLASS);
            this.player.requestPlayViewListIndexBased(this.playViewList.getClientID(), 0, this.playViewList.getListSize());
        }
    }

    protected final void requestPlayViewList(long l) {
        this.logger.log(1000000, "[%1.requestPlayViewList] '%2'.", (Object)LOGCLASS, l);
        if (l == -1L) {
            this.logger.log(10000000, "[%1.requestPlayViewList] Invalid entry ID.", (Object)LOGCLASS);
            return;
        }
        if (this.playViewList.getListProgressIndicator() != null) {
            this.playViewList.getListProgressIndicator().startIndication();
        }
        if (this.playViewList.getListSize() > this.playViewList.getWindowRequestSize() && !this.playViewList.isRequestFullList()) {
            this.logger.log(1000000, "[%1.requestPlayViewList] Request window.", (Object)LOGCLASS);
            this.player.requestPlayViewListEntryBased(this.playViewList.getClientID(), l, this.playViewList.getWindowRequestSize() / 2);
        } else {
            this.logger.log(1000000, "[%1.requestPlayViewList] Request full list.", (Object)LOGCLASS);
            this.player.requestPlayViewListIndexBased(this.playViewList.getClientID(), 0, this.playViewList.getListSize());
        }
    }

    public void errorListRequestAborted() {
        if (-1 == this.requestId) {
            this.logger.log(1000000, "[%1.errorListRequestAborted] Error list request.", (Object)LOGCLASS);
            this.playViewList.errorForJumpToTrackListRequest();
        } else {
            this.logger.log(1000000, "[%1.errorListRequestAborted] Error for widget list request.", (Object)LOGCLASS);
            this.playViewList.getPlayViewListModel().setRows(this.requestId, this.startIndex, new EvoListRow[0]);
        }
        this.getExecutionContext().jobFinished();
    }

    protected long getEntryId() {
        return this.entryId;
    }

    public String toString() {
        Buffer buffer = new Buffer(80);
        buffer.append("PlayViewListRequest [startIndex=");
        buffer.append(this.startIndex);
        buffer.append(", length=");
        buffer.append(this.length);
        buffer.append(", requestId=");
        buffer.append(this.requestId);
        buffer.append(", entryId=");
        buffer.append(this.entryId);
        buffer.append("]");
        return buffer.toString();
    }
}

