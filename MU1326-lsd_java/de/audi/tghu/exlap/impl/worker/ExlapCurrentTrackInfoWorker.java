/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackInfoWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapCurrentTrackInfoWorker
extends ExlapAbstractWorker {
    private static final int CURRENT_TRACK_INFO_PROPERTY;

    public ExlapCurrentTrackInfoWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapCurrentTrackInfoWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(21, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapCurrentTrackInfoWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{21};
    }

    static /* synthetic */ LogChannel access$000(ExlapCurrentTrackInfoWorker exlapCurrentTrackInfoWorker) {
        return exlapCurrentTrackInfoWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapCurrentTrackInfoWorker exlapCurrentTrackInfoWorker, Container container) {
        exlapCurrentTrackInfoWorker.container = container;
        return exlapCurrentTrackInfoWorker.container;
    }

    static /* synthetic */ int access$200(ExlapCurrentTrackInfoWorker exlapCurrentTrackInfoWorker) {
        return exlapCurrentTrackInfoWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapCurrentTrackInfoWorker exlapCurrentTrackInfoWorker) {
        exlapCurrentTrackInfoWorker.trigger();
    }
}

