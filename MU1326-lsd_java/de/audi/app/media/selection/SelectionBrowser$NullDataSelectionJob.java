/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.selection;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.queue.IQueueExecutionContext;
import de.audi.app.media.selection.IDataSelectionJob;
import de.audi.atip.log.LogChannel;

class SelectionBrowser$NullDataSelectionJob
implements IDataSelectionJob {
    private static final String LOGCLASS;
    private final LogChannel logChannel;

    public SelectionBrowser$NullDataSelectionJob(LogChannel logChannel) {
        this.logChannel = logChannel;
    }

    @Override
    public void browserActivated() {
        this.logChannel.log(-1601830656, "[%1.browserActivated]", (Object)"NullDataSelectionJob");
    }

    @Override
    public void browserDeactivated(boolean bl) {
        this.logChannel.log(-1601830656, "[%1.browserDeactivated]", (Object)"NullDataSelectionJob");
    }

    @Override
    public void browseModeChanged(boolean bl, int n) {
        this.logChannel.log(-1601830656, "[%1.browseModeChanged]", (Object)"NullDataSelectionJob");
    }

    @Override
    public void browseFolderChanged(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logChannel.log(-1601830656, "[%1.browseFolderChanged]", (Object)"NullDataSelectionJob");
    }

    @Override
    public void responseList(boolean bl, MediaListEntry[] mediaListEntryArray, int n) {
        this.logChannel.log(-1601830656, "[%1.responseList]", (Object)"NullDataSelectionJob");
    }

    @Override
    public void responsePicklist(boolean bl, MediaListEntry[] mediaListEntryArray) {
        this.logChannel.log(-1601830656, "[%1.responsePicklist]", (Object)"NullDataSelectionJob");
    }

    @Override
    public void addSelectionResult(boolean bl, int n, int n2, boolean bl2, long l, long l2, long l3, long l4, long l5) {
        this.logChannel.log(-1601830656, "[%1.addSelectionResult]", (Object)"NullDataSelectionJob");
    }

    @Override
    public int getType() {
        this.logChannel.log(-1601830656, "[%1.getType]", (Object)"NullDataSelectionJob");
        return 0;
    }

    @Override
    public String getName() {
        this.logChannel.log(-1601830656, "[%1.getName]", (Object)"NullDataSelectionJob");
        return "NullDataSelectionJob";
    }

    @Override
    public void start(IQueueExecutionContext iQueueExecutionContext) {
        this.logChannel.log(-1601830656, "[%1.start]", (Object)"NullDataSelectionJob");
    }

    @Override
    public void abort(boolean bl) {
        this.logChannel.log(-1601830656, "[%1.abort]", (Object)"NullDataSelectionJob");
    }
}

