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
import de.audi.tghu.exlap.impl.worker.ExlapAvailableMediaSourcesWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAvailableMediaSourcesWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_MEDIA_SOURCES_PROPERTY;

    public ExlapAvailableMediaSourcesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapAvailableMediaSourcesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(27, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapAvailableMediaSourcesWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{27};
    }

    static /* synthetic */ LogChannel access$000(ExlapAvailableMediaSourcesWorker exlapAvailableMediaSourcesWorker) {
        return exlapAvailableMediaSourcesWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapAvailableMediaSourcesWorker exlapAvailableMediaSourcesWorker, Container container) {
        exlapAvailableMediaSourcesWorker.container = container;
        return exlapAvailableMediaSourcesWorker.container;
    }

    static /* synthetic */ int access$200(ExlapAvailableMediaSourcesWorker exlapAvailableMediaSourcesWorker) {
        return exlapAvailableMediaSourcesWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapAvailableMediaSourcesWorker exlapAvailableMediaSourcesWorker) {
        exlapAvailableMediaSourcesWorker.trigger();
    }
}

