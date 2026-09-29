/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.browselist;

import de.audi.app.media.combi.bap.browselist.AbstractCombiBrowserJob;
import de.audi.app.media.combi.bap.browselist.CombiBAPDataBrowserContentAdapter;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;

public class CombiJobUpdateCoverart
extends AbstractCombiBrowserJob {
    private final String LOGCLASS;
    private final ResourceLocator coverart;

    public CombiJobUpdateCoverart(LogChannel logChannel, CombiBAPDataBrowserContentAdapter combiBAPDataBrowserContentAdapter, ResourceLocator resourceLocator) {
        super(logChannel, combiBAPDataBrowserContentAdapter);
        this.LOGCLASS = "CombiJobUpdateCoverart";
        this.coverart = resourceLocator;
    }

    @Override
    public int getType() {
        return 12;
    }

    @Override
    public String getName() {
        return "COVERART";
    }

    @Override
    public void start() {
        ResourceLocator resourceLocator = this.getCombiAdapter().getState().getCurrentCoverart();
        if (resourceLocator != null && resourceLocator.equals(this.coverart)) {
            this.logger.log(14808325, "[%1.start] cover is already updated.", (Object)"CombiJobUpdateCoverart");
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(14808325, "[%1.start] upate cover.", (Object)"CombiJobUpdateCoverart");
        this.getCombiAdapter().getState().setCurrentCoverart(this.coverart);
        this.sendDetailInfo();
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

