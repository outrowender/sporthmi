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
import de.audi.tghu.exlap.impl.worker.ExlapGuidanceDestinationWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapGuidanceDestinationWorker
extends ExlapAbstractWorker {
    private static final int GUIDANCE_DESTINATION_PROPERTY;

    public ExlapGuidanceDestinationWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapGuidanceDestinationWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(8, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapGuidanceDestinationWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{8};
    }

    static /* synthetic */ LogChannel access$000(ExlapGuidanceDestinationWorker exlapGuidanceDestinationWorker) {
        return exlapGuidanceDestinationWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapGuidanceDestinationWorker exlapGuidanceDestinationWorker, Container container) {
        exlapGuidanceDestinationWorker.container = container;
        return exlapGuidanceDestinationWorker.container;
    }

    static /* synthetic */ int access$200(ExlapGuidanceDestinationWorker exlapGuidanceDestinationWorker) {
        return exlapGuidanceDestinationWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapGuidanceDestinationWorker exlapGuidanceDestinationWorker) {
        exlapGuidanceDestinationWorker.trigger();
    }
}

