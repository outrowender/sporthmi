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
import de.audi.tghu.exlap.impl.worker.ExlapEntertainmentContextWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapEntertainmentContextWorker
extends ExlapAbstractWorker {
    private static final int ENTERTAINMENT_CONTEXT_PROPERTY;

    public ExlapEntertainmentContextWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapEntertainmentContextWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(58, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapEntertainmentContextWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{58};
    }

    static /* synthetic */ LogChannel access$000(ExlapEntertainmentContextWorker exlapEntertainmentContextWorker) {
        return exlapEntertainmentContextWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapEntertainmentContextWorker exlapEntertainmentContextWorker, Container container) {
        exlapEntertainmentContextWorker.container = container;
        return exlapEntertainmentContextWorker.container;
    }

    static /* synthetic */ int access$200(ExlapEntertainmentContextWorker exlapEntertainmentContextWorker) {
        return exlapEntertainmentContextWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapEntertainmentContextWorker exlapEntertainmentContextWorker) {
        exlapEntertainmentContextWorker.trigger();
    }
}

