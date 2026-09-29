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
import de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapBalanceFaderWorker
extends ExlapAbstractWorker {
    private static final int BALANCE_FADER_PROPERTY;

    public ExlapBalanceFaderWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapBalanceFaderWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(45, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapBalanceFaderWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{45};
    }

    static /* synthetic */ LogChannel access$000(ExlapBalanceFaderWorker exlapBalanceFaderWorker) {
        return exlapBalanceFaderWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapBalanceFaderWorker exlapBalanceFaderWorker, Container container) {
        exlapBalanceFaderWorker.container = container;
        return exlapBalanceFaderWorker.container;
    }

    static /* synthetic */ int access$200(ExlapBalanceFaderWorker exlapBalanceFaderWorker) {
        return exlapBalanceFaderWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapBalanceFaderWorker exlapBalanceFaderWorker) {
        exlapBalanceFaderWorker.trigger();
    }
}

