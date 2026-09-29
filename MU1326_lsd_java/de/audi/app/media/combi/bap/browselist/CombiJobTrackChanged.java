/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.combi.bap.browselist.AbstractCombiBrowserJob;
import de.audi.app.media.combi.bap.browselist.CombiBAPDataBrowserContentAdapter;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;

public class CombiJobTrackChanged
extends AbstractCombiBrowserJob {
    public CombiJobTrackChanged(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
    }

    @Override
    public int getType() {
        return 9;
    }

    @Override
    public String getName() {
        return "TRACK_CHANGE";
    }

    @Override
    public void start() {
        this.getCombiAdapter().getState().setCurrentCoverart(null);
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void responseList(int n, MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    public void errorListRequestAborted() {
    }

    @Override
    public void browseFolderChanged(MediaListEntry[] mediaListEntryArray, int n) {
    }

    @Override
    public void errorFolderChangeAborted() {
    }
}

