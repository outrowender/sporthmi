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
import de.audi.tghu.exlap.impl.worker.ExlapLastDestinationsWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapLastDestinationsWorker
extends ExlapAbstractWorker {
    private static final int LAST_DESTINATIONS_PROPERTY;

    public ExlapLastDestinationsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapLastDestinationsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(29, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapLastDestinationsWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{29};
    }

    static /* synthetic */ LogChannel access$000(ExlapLastDestinationsWorker exlapLastDestinationsWorker) {
        return exlapLastDestinationsWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapLastDestinationsWorker exlapLastDestinationsWorker, Container container) {
        exlapLastDestinationsWorker.container = container;
        return exlapLastDestinationsWorker.container;
    }

    static /* synthetic */ int access$200(ExlapLastDestinationsWorker exlapLastDestinationsWorker) {
        return exlapLastDestinationsWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapLastDestinationsWorker exlapLastDestinationsWorker) {
        exlapLastDestinationsWorker.trigger();
    }
}

