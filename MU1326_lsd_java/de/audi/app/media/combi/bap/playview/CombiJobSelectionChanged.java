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

    public int getType() {
        return 6;
    }

    public String getName() {
        return "SELECTION_CHANGED";
    }

    public void abort(boolean bl) {
    }

    public void start() {
        this.getCombiAdapter().getCombiAccessor().trackChangeIsComing();
        this.getExecutionContext().jobFinished();
    }

    public void responsePlayViewList(int n, MediaListEntry[] mediaListEntryArray) {
    }

    public void errorListRequestAborted() {
    }
}

