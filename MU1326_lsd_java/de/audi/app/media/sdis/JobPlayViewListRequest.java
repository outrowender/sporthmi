/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.content.media.IPlayViewListRequest;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.queue.IQueueExecutionContext;
import de.audi.app.media.sdis.AbstractPlayerJob;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class JobPlayViewListRequest
extends AbstractPlayerJob {
    private static final String LOGCLASS = "JobPlayViewListRequest";
    private final IPlayViewListRequest clientRequest;

    public JobPlayViewListRequest(LogChannel logChannel, IPlayViewListRequest iPlayViewListRequest, IPlayer iPlayer) {
        super(logChannel, "PlayViewRequest", iPlayer);
        this.clientRequest = iPlayViewListRequest;
    }

    public void abort(boolean bl) {
        this.logger.log(1000000, "[%1.abort]", (Object)LOGCLASS);
        this.clientRequest.responsePlayList(false, 0, new MediaListEntry[0]);
        IQueueExecutionContext iQueueExecutionContext = this.getExecutionContext();
        if (iQueueExecutionContext != null) {
            iQueueExecutionContext.jobFinished();
        } else {
            this.logger.log(100000, "[%1.abort] The context is null.", (Object)LOGCLASS);
        }
    }

    public void start() {
        if (this.clientRequest.getId() == -1L) {
            this.logger.log(1000000, "[%1.start] Index based list request.", (Object)LOGCLASS);
            if (!this.player.requestPlayViewListIndexBased(this.clientRequest.getClientID(), this.clientRequest.getIndex(), this.clientRequest.getSize())) {
                this.logger.log(100000, "[%1.start] Request failed.", (Object)LOGCLASS);
                this.abort(false);
            }
        } else {
            this.logger.log(1000000, "[%1.start] Entry based list request.", (Object)LOGCLASS);
            if (!this.player.requestPlayViewListEntryBased(this.clientRequest.getClientID(), this.clientRequest.getId(), this.clientRequest.getSize())) {
                this.logger.log(100000, "[%1.start] Request failed.", (Object)LOGCLASS);
                this.abort(false);
            }
        }
    }

    public void responsePlayView(boolean bl, int n, MediaListEntry[] mediaListEntryArray) {
        if (this.logger.isInfo()) {
            Buffer buffer = new Buffer();
            buffer.append(bl ? "OK" : "NOK").append(",idx='").append(n).append("',size='").append(mediaListEntryArray != null ? mediaListEntryArray.length : -1).append("'");
            this.logger.log(1000000, "[%1.responsePlayView] %2", (Object)LOGCLASS, (Object)buffer);
        }
        this.clientRequest.responsePlayList(bl, n, null == mediaListEntryArray ? new MediaListEntry[]{} : mediaListEntryArray);
        this.getExecutionContext().jobFinished();
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("idx='").append(this.clientRequest.getIndex()).append("',entryID='").append(this.clientRequest.getId()).append("',size='").append(this.clientRequest.getSize()).append("'");
        return buffer.toString();
    }
}

