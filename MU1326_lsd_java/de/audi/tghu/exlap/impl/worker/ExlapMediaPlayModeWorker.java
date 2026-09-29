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
import de.audi.tghu.exlap.impl.worker.ExlapMediaPlayModeWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapMediaPlayModeWorker
extends ExlapAbstractWorker {
    private static final int MEDIA_PLAY_MODE_PROPERTY;

    public ExlapMediaPlayModeWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapMediaPlayModeWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(23, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapMediaPlayModeWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{23};
    }

    static /* synthetic */ LogChannel access$000(ExlapMediaPlayModeWorker exlapMediaPlayModeWorker) {
        return exlapMediaPlayModeWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapMediaPlayModeWorker exlapMediaPlayModeWorker, Container container) {
        exlapMediaPlayModeWorker.container = container;
        return exlapMediaPlayModeWorker.container;
    }

    static /* synthetic */ int access$200(ExlapMediaPlayModeWorker exlapMediaPlayModeWorker) {
        return exlapMediaPlayModeWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapMediaPlayModeWorker exlapMediaPlayModeWorker) {
        exlapMediaPlayModeWorker.trigger();
    }
}

