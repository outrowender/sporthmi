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
import de.audi.tghu.exlap.impl.worker.ExlapAvailableFMStationsWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAvailableFMStationsWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_FMSTATIONS_PROPERTY;

    public ExlapAvailableFMStationsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapAvailableFMStationsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(32, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapAvailableFMStationsWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{32};
    }

    static /* synthetic */ LogChannel access$000(ExlapAvailableFMStationsWorker exlapAvailableFMStationsWorker) {
        return exlapAvailableFMStationsWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapAvailableFMStationsWorker exlapAvailableFMStationsWorker, Container container) {
        exlapAvailableFMStationsWorker.container = container;
        return exlapAvailableFMStationsWorker.container;
    }

    static /* synthetic */ int access$200(ExlapAvailableFMStationsWorker exlapAvailableFMStationsWorker) {
        return exlapAvailableFMStationsWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapAvailableFMStationsWorker exlapAvailableFMStationsWorker) {
        exlapAvailableFMStationsWorker.trigger();
    }
}

