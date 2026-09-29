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
    private static final String LOGCLASS;
    private static final int NO_REQUEST_ID;
    private static final int INVALID_ENTRYID;
    private static final int INVALID_INDEX;
    private static final int INVALID_LENGTH;
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

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public String getName() {
        return "PlayViewListRequest";
    }

    @Override
    public void start() {
        this.logger.log(1078071040, "[%1.start]", (Object)"PlayViewListRequest");
        if (-1L == this.entryId) {
            this.requestPlayViewListIndexBased(this.startIndex, this.length);
        } else {
            this.requestPlayViewList(this.entryId);
        }
    }

    public void responsePlayView(int n, MediaListEntry[] mediaListEntryArray, int n2) {
        this.logger.log(1078071040, "[%1.responsePlayView]", (Object)"PlayViewListRequest");
        this.playViewList.updateList(mediaListEntryArray, n, n2, this.requestId);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void abort(boolean bl) {
        this.logger.log(1078071040, "[%1.abort] run='%2'", (Object)"PlayViewListRequest", (Object)Boolean.toString(bl));
        if (-1 != this.requestId) {
            this.playViewList.getPlayViewListModel().setRows(this.requestId, this.startIndex, new EvoListRow[0]);
        }
        if (bl) {
            this.player.discardPlayViewRequests(this.playViewList.getClientID());
        }
    }

    protected final void requestPlayViewListIndexBased(int n, int n2) {
        this.logger.log(1078071040, "[%1.requestPlayViewListIndexBased] '%2' '%3'.", (Object)"PlayViewListRequest", (long)n, (long)n2);
        if (this.playViewList.getListProgressIndicator() != null) {
            this.playViewList.getListProgressIndicator().startIndication();
        }
        if (this.playViewList.getListSize() > this.playViewList.getWindowRequestSize() && !this.playViewList.isRequestFullList()) {
            this.logger.log(1078071040, "[%1.requestPlayViewList] Request window.", (Object)"PlayViewListRequest");
            this.player.requestPlayViewListIndexBased(this.playViewList.getClientID(), n, n2);
        } else {
            this.logger.log(1078071040, "[%1.requestPlayViewList] Request full list.", (Object)"PlayViewListRequest");
            this.player.requestPlayViewListIndexBased(this.playViewList.getClientID(), 0, this.playViewList.getListSize());
        }
    }

    protected final void requestPlayViewList(long l) {
        this.logger.log(1078071040, "[%1.requestPlayViewList] '%2'.", (Object)"PlayViewListRequest", l);
        if (l == -1L) {
            this.logger.log(-2137614336, "[%1.requestPlayViewList] Invalid entry ID.", (Object)"PlayViewListRequest");
            return;
        }
        if (this.playViewList.getListProgressIndicator() != null) {
            this.playViewList.getListProgressIndicator().startIndication();
        }
        if (this.playViewList.getListSize() > this.playViewList.getWindowRequestSize() && !this.playViewList.isRequestFullList()) {
            this.logger.log(1078071040, "[%1.requestPlayViewList] Request window.", (Object)"PlayViewListRequest");
            this.player.requestPlayViewListEntryBased(this.playViewList.getClientID(), l, this.playViewList.getWindowRequestSize() / 2);
        } else {
            this.logger.log(1078071040, "[%1.requestPlayViewList] Request full list.", (Object)"PlayViewListRequest");
            this.player.requestPlayViewListIndexBased(this.playViewList.getClientID(), 0, this.playViewList.getListSize());
        }
    }

    public void errorListRequestAborted() {
        if (-1 == this.requestId) {
            this.logger.log(1078071040, "[%1.errorListRequestAborted] Error list request.", (Object)"PlayViewListRequest");
            this.playViewList.errorForJumpToTrackListRequest();
        } else {
            this.logger.log(1078071040, "[%1.errorListRequestAborted] Error for widget list request.", (Object)"PlayViewListRequest");
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

