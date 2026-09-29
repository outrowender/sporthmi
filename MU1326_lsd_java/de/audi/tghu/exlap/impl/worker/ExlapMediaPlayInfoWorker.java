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
import de.audi.tghu.exlap.impl.worker.ExlapMediaPlayInfoWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapMediaPlayInfoWorker
extends ExlapAbstractWorker {
    private static final int MEDIA_PLAY_INFO_PROPERTY;

    public ExlapMediaPlayInfoWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapMediaPlayInfoWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(22, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapMediaPlayInfoWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{22};
    }

    static /* synthetic */ LogChannel access$000(ExlapMediaPlayInfoWorker exlapMediaPlayInfoWorker) {
        return exlapMediaPlayInfoWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapMediaPlayInfoWorker exlapMediaPlayInfoWorker, Container container) {
        exlapMediaPlayInfoWorker.container = container;
        return exlapMediaPlayInfoWorker.container;
    }

    static /* synthetic */ int access$200(ExlapMediaPlayInfoWorker exlapMediaPlayInfoWorker) {
        return exlapMediaPlayInfoWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapMediaPlayInfoWorker exlapMediaPlayInfoWorker) {
        exlapMediaPlayInfoWorker.trigger();
    }
}

