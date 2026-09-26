/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.combi.bap.stream;

import de.audi.app.media.combi.bap.AbstractCombiBAPContentAdapter;
import de.audi.app.media.combi.bap.ICombiBAPContentAccessor;
import de.audi.app.media.content.IContent;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;

public class NoDataCombiAdapter
extends AbstractCombiBAPContentAdapter {
    private static final String LOGCLASS;

    public NoDataCombiAdapter(LogChannel logChannel) {
        super(logChannel);
    }

    @Override
    public void activate(IContent iContent, ICombiBAPContentAccessor iCombiBAPContentAccessor) {
        this.logger.log(1078071040, "[%1.activate]", (Object)"NoDataCombiAdapter");
        super.activate(iContent, iCombiBAPContentAccessor);
        this.getCombiAccessor().updateListState(false, 4);
        this.getCombiAccessor().contentAdapterStartupFinished();
    }

    public String toString() {
        Buffer buffer = new Buffer(20);
        buffer.append("NoDataCombiAdapter").append("@").append(this.hashCode());
        return buffer.toString();
    }
}

