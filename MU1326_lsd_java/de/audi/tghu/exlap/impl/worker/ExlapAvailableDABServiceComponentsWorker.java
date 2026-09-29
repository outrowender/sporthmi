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
import de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServiceComponentsWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAvailableDABServiceComponentsWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_DABSERVICE_COMPONENTS_PROPERTY;

    public ExlapAvailableDABServiceComponentsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapAvailableDABServiceComponentsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(35, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapAvailableDABServiceComponentsWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{35};
    }

    static /* synthetic */ LogChannel access$000(ExlapAvailableDABServiceComponentsWorker exlapAvailableDABServiceComponentsWorker) {
        return exlapAvailableDABServiceComponentsWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapAvailableDABServiceComponentsWorker exlapAvailableDABServiceComponentsWorker, Container container) {
        exlapAvailableDABServiceComponentsWorker.container = container;
        return exlapAvailableDABServiceComponentsWorker.container;
    }

    static /* synthetic */ int access$200(ExlapAvailableDABServiceComponentsWorker exlapAvailableDABServiceComponentsWorker) {
        return exlapAvailableDABServiceComponentsWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapAvailableDABServiceComponentsWorker exlapAvailableDABServiceComponentsWorker) {
        exlapAvailableDABServiceComponentsWorker.trigger();
    }
}

