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
import de.audi.tghu.exlap.impl.worker.ExlapAvailableAMStationsWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAvailableAMStationsWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_AMSTATIONS_PROPERTY;

    public ExlapAvailableAMStationsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapAvailableAMStationsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(31, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapAvailableAMStationsWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{31};
    }

    static /* synthetic */ LogChannel access$000(ExlapAvailableAMStationsWorker exlapAvailableAMStationsWorker) {
        return exlapAvailableAMStationsWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapAvailableAMStationsWorker exlapAvailableAMStationsWorker, Container container) {
        exlapAvailableAMStationsWorker.container = container;
        return exlapAvailableAMStationsWorker.container;
    }

    static /* synthetic */ int access$200(ExlapAvailableAMStationsWorker exlapAvailableAMStationsWorker) {
        return exlapAvailableAMStationsWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapAvailableAMStationsWorker exlapAvailableAMStationsWorker) {
        exlapAvailableAMStationsWorker.trigger();
    }
}

