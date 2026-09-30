/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.playview;

import de.audi.app.media.combi.bap.playview.AbstractCombiPlayViewJob;
import de.audi.app.media.combi.bap.playview.CombiBAPPlayViewContentAdapter;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.ResourceLocator;

public class CombiJobUpdateCoverart
extends AbstractCombiPlayViewJob {
    private final String LOGCLASS;
    private final ResourceLocator coverart;

    public CombiJobUpdateCoverart(LogChannel logChannel, CombiBAPPlayViewContentAdapter combiBAPPlayViewContentAdapter, ResourceLocator resourceLocator) {
        super(logChannel, combiBAPPlayViewContentAdapter);
        this.LOGCLASS = "CombiJobUpdateCoverart";
        this.coverart = resourceLocator;
    }

    public int getType() {
        return 7;
    }

    public String getName() {
        return "COVERART";
    }

    public void abort(boolean bl) {
    }

    public void start() {
        ResourceLocator resourceLocator = this.getCombiAdapter().getState().getCurrentCoverart();
        if (resourceLocator != null && resourceLocator.equals(this.coverart)) {
            this.logger.log(100000000, "[%1.start] cover is already updated.", (Object)"CombiJobUpdateCoverart");
            this.getExecutionContext().jobFinished();
            return;
        }
        this.logger.log(100000000, "[%1.start] upate cover.", (Object)"CombiJobUpdateCoverart");
        this.getCombiAdapter().getState().setCurrentCoverart(this.coverart);
        if (this.getCombiAdapter().getState().getAbsolutePositionCurrentTrack() == 0 && this.getCombiAdapter().getState().isPlayViewSupported()) {
            this.logger.log(1000000, "[%1.start] Current track not in list. Currently do not update detail infos in combi.", (Object)"CombiJobUpdateCoverart");
            this.getCombiAdapter().getState().setCoverUpdateBlocked(true);
            this.getExecutionContext().jobFinished();
            return;
        }
        this.sendDetailInfo();
        this.getExecutionContext().jobFinished();
    }

    public void responsePlayViewList(int n, MediaListEntry[] mediaListEntryArray) {
    }

    public void errorListRequestAborted() {
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("[coverart='");
        buffer.append(this.coverart);
        buffer.append("']");
        return buffer.toString();
    }
}

