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
import de.audi.tghu.exlap.impl.worker.ExlapLocationWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapLocationWorker
extends ExlapAbstractWorker {
    private static final int LOCATION_PROPERTY;

    public ExlapLocationWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapLocationWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(1, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapLocationWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{1};
    }

    static /* synthetic */ LogChannel access$000(ExlapLocationWorker exlapLocationWorker) {
        return exlapLocationWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapLocationWorker exlapLocationWorker, Container container) {
        exlapLocationWorker.container = container;
        return exlapLocationWorker.container;
    }

    static /* synthetic */ int access$200(ExlapLocationWorker exlapLocationWorker) {
        return exlapLocationWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapLocationWorker exlapLocationWorker) {
        exlapLocationWorker.trigger();
    }
}

