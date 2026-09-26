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
import de.audi.tghu.exlap.impl.worker.ExlapGuidanceRemainingWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapGuidanceRemainingWorker
extends ExlapAbstractWorker {
    private static final int GUIDANCE_REMAINING_PROPERTY;

    public ExlapGuidanceRemainingWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapGuidanceRemainingWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(24, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapGuidanceRemainingWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{24};
    }

    static /* synthetic */ LogChannel access$000(ExlapGuidanceRemainingWorker exlapGuidanceRemainingWorker) {
        return exlapGuidanceRemainingWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapGuidanceRemainingWorker exlapGuidanceRemainingWorker, Container container) {
        exlapGuidanceRemainingWorker.container = container;
        return exlapGuidanceRemainingWorker.container;
    }

    static /* synthetic */ int access$200(ExlapGuidanceRemainingWorker exlapGuidanceRemainingWorker) {
        return exlapGuidanceRemainingWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapGuidanceRemainingWorker exlapGuidanceRemainingWorker) {
        exlapGuidanceRemainingWorker.trigger();
    }
}

