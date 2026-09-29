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
import de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServicesWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAvailableDABServicesWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_DABSERVICES_PROPERTY;

    public ExlapAvailableDABServicesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapAvailableDABServicesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(34, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapAvailableDABServicesWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{34};
    }

    static /* synthetic */ LogChannel access$000(ExlapAvailableDABServicesWorker exlapAvailableDABServicesWorker) {
        return exlapAvailableDABServicesWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapAvailableDABServicesWorker exlapAvailableDABServicesWorker, Container container) {
        exlapAvailableDABServicesWorker.container = container;
        return exlapAvailableDABServicesWorker.container;
    }

    static /* synthetic */ int access$200(ExlapAvailableDABServicesWorker exlapAvailableDABServicesWorker) {
        return exlapAvailableDABServicesWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapAvailableDABServicesWorker exlapAvailableDABServicesWorker) {
        exlapAvailableDABServicesWorker.trigger();
    }
}

