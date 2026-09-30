/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.playview;

import de.audi.app.media.combi.bap.CombiBAPMediaEntry;
import de.audi.app.media.combi.bap.CombiBAPUtils;
import de.audi.app.media.combi.bap.playview.AbstractCombiPlayViewJob;
import de.audi.app.media.combi.bap.playview.CombiBAPPlayViewContentAdapter;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class CombiJobGetNextListPos
extends AbstractCombiPlayViewJob {
    private final String LOGCLASS;
    private final int offset;
    private final CombiBAPMediaEntry entry;
    private volatile int destIndex = -1;

    public CombiJobGetNextListPos(LogChannel logChannel, CombiBAPPlayViewContentAdapter combiBAPPlayViewContentAdapter, CombiBAPMediaEntry combiBAPMediaEntry, int n) {
        super(logChannel, combiBAPPlayViewContentAdapter);
        this.LOGCLASS = "CombiJobGetNextListPos";
        this.offset = n;
        this.entry = combiBAPMediaEntry;
    }

    public int getType() {
        return 1;
    }

    public String getName() {
        return "GETNEXTLISTPOS";
    }

    public void abort(boolean bl) {
        this.logger.log(1000000, "[%1.abort]", (Object)"CombiJobGetNextListPos");
        this.sendGetNextListPosResult(false, this.entry, null, 0);
    }

    public void start() {
        if (!this.getCombiAdapter().getPlayer().requestPlayViewListEntryBased(this.getCombiAdapter().getClientID(), this.entry.getEntryID(), 1)) {
            this.logger.log(1000000, "[%1.start] List request failed.", (Object)"CombiJobGetNextListPos");
            this.sendGetNextListPosResult(false, this.entry, null, 0);
            this.getExecutionContext().jobFinished();
            return;
        }
    }

    public void responsePlayViewList(int n, MediaListEntry[] mediaListEntryArray) {
        if (this.destIndex == -1) {
            this.logger.log(100000000, "[%1.responsePlayViewList] Receive response (index).", (Object)"CombiJobGetNextListPos");
            int n2 = CombiBAPUtils.getAbsolutePosition(this.entry.getEntryID(), this.entry.getEntryContentType(), mediaListEntryArray, n);
            this.logger.log(100000000, "[%1.responsePlayViewList] absolutePosition='%2' (currentEntryID='%3').", (Object)"CombiJobGetNextListPos", (long)n2, this.entry.getEntryID());
            if (n2 == 0) {
                this.logger.log(100000, "[%1.responsePlayViewList] Found no absolute position.", (Object)"CombiJobGetNextListPos");
                this.sendGetNextListPosResult(false, this.entry, null, 0);
                this.getExecutionContext().jobFinished();
                return;
            }
            this.destIndex = n2 + this.offset - 1;
            if (!this.getCombiAdapter().getPlayer().requestPlayViewListIndexBased(this.getCombiAdapter().getClientID(), this.destIndex, 1)) {
                this.logger.log(1000000, "[%1.responsePlayViewList] List request failed.", (Object)"CombiJobGetNextListPos");
                this.sendGetNextListPosResult(false, this.entry, null, 0);
                this.getExecutionContext().jobFinished();
                return;
            }
        } else {
            MediaListEntry mediaListEntry;
            this.logger.log(100000000, "[%1.responsePlayViewList] Receive response (pos).", (Object)"CombiJobGetNextListPos");
            try {
                mediaListEntry = mediaListEntryArray[this.destIndex - n];
            }
            catch (Exception exception) {
                this.logger.log(1000000, "[%1.responseList] Element not found in list (destIndex='%2').", (Object)"CombiJobGetNextListPos", (long)this.destIndex);
                this.sendGetNextListPosResult(false, this.entry, null, 0);
                this.getExecutionContext().jobFinished();
                return;
            }
            if (mediaListEntry == null) {
                this.logger.log(100000, "[%1.responsePlayViewList] No dest entry found.", (Object)"CombiJobGetNextListPos");
                this.sendGetNextListPosResult(false, this.entry, null, 0);
                this.getExecutionContext().jobFinished();
                return;
            }
            this.sendGetNextListPosResult(true, this.entry, new CombiBAPMediaEntry(mediaListEntry.getEntryID(), mediaListEntry.getContentType(), mediaListEntry.getEntryFlags(), null), this.destIndex + 1);
            this.getExecutionContext().jobFinished();
        }
    }

    public void errorListRequestAborted() {
        this.logger.log(1000000, "[%1.errorListRequestAborted] List request aborted ('%2').", (Object)"CombiJobGetNextListPos", (Object)this);
        this.sendGetNextListPosResult(false, this.entry, null, 0);
        this.getExecutionContext().jobFinished();
    }

    private void sendGetNextListPosResult(boolean bl, CombiBAPMediaEntry combiBAPMediaEntry, CombiBAPMediaEntry combiBAPMediaEntry2, int n) {
        this.logger.log(100000000, "[%2.sendGetNextListPosResult] ok='%1'", bl, (Object)"CombiJobGetNextListPos");
        this.getCombiAdapter().getCombiAccessor().getNextListPosResult(bl, combiBAPMediaEntry, combiBAPMediaEntry2, n);
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("[entry='");
        buffer.append(this.entry);
        buffer.append("',offset='");
        buffer.append(this.offset);
        buffer.append("',destIdx='");
        buffer.append(this.destIndex);
        buffer.append("']");
        return buffer.toString();
    }
}

