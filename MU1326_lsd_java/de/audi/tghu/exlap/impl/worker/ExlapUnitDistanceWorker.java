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
import de.audi.tghu.exlap.impl.worker.ExlapUnitDistanceWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapUnitDistanceWorker
extends ExlapAbstractWorker {
    private static final int UNIT_DISTANCE_PROPERTY;

    public ExlapUnitDistanceWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapUnitDistanceWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(13, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapUnitDistanceWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{13};
    }

    static /* synthetic */ LogChannel access$000(ExlapUnitDistanceWorker exlapUnitDistanceWorker) {
        return exlapUnitDistanceWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapUnitDistanceWorker exlapUnitDistanceWorker, Container container) {
        exlapUnitDistanceWorker.container = container;
        return exlapUnitDistanceWorker.container;
    }

    static /* synthetic */ int access$200(ExlapUnitDistanceWorker exlapUnitDistanceWorker) {
        return exlapUnitDistanceWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapUnitDistanceWorker exlapUnitDistanceWorker) {
        exlapUnitDistanceWorker.trigger();
    }
}

