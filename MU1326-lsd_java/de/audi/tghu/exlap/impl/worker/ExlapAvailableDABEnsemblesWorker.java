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
import de.audi.tghu.exlap.impl.worker.ExlapAvailableDABEnsemblesWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAvailableDABEnsemblesWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_DABENSEMBLES_PROPERTY;

    public ExlapAvailableDABEnsemblesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapAvailableDABEnsemblesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(33, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapAvailableDABEnsemblesWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{33};
    }

    static /* synthetic */ LogChannel access$000(ExlapAvailableDABEnsemblesWorker exlapAvailableDABEnsemblesWorker) {
        return exlapAvailableDABEnsemblesWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapAvailableDABEnsemblesWorker exlapAvailableDABEnsemblesWorker, Container container) {
        exlapAvailableDABEnsemblesWorker.container = container;
        return exlapAvailableDABEnsemblesWorker.container;
    }

    static /* synthetic */ int access$200(ExlapAvailableDABEnsemblesWorker exlapAvailableDABEnsemblesWorker) {
        return exlapAvailableDABEnsemblesWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapAvailableDABEnsemblesWorker exlapAvailableDABEnsemblesWorker) {
        exlapAvailableDABEnsemblesWorker.trigger();
    }
}

