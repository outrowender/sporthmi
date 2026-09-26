/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.playview;

import de.audi.app.media.combi.bap.playview.AbstractCombiPlayViewJob;
import de.audi.app.media.combi.bap.playview.CombiBAPPlayViewContentAdapter;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;

public class CombiJobSelectionChanged
extends AbstractCombiPlayViewJob {
    public CombiJobSelectionChanged(LogChannel logChannel, CombiBAPPlayViewContentAdapter combiBAPPlayViewContentAdapter) {
        super(logChannel, combiBAPPlayViewContentAdapter);
    }

    @Override
    public int getType() {
        return 6;
    }

    @Override
    public String getName() {
        return "SELECTION_CHANGED";
    }

    @Override
    public void abort(boolean bl) {
    }

    @Override
    public void start() {
        this.getCombiAdapter().getCombiAccessor().trackChangeIsComing();
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void responsePlayViewList(int n, MediaListEntry[] mediaListEntryArray) {
    }

    @Override
    public void errorListRequestAborted() {
    }
}

