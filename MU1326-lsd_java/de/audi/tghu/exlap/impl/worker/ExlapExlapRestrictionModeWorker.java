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
import de.audi.tghu.exlap.impl.worker.ExlapExlapRestrictionModeWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapExlapRestrictionModeWorker
extends ExlapAbstractWorker {
    private static final int EXLAP_RESTRICTION_MODE_PROPERTY;

    public ExlapExlapRestrictionModeWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapExlapRestrictionModeWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(30, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapExlapRestrictionModeWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{30};
    }

    static /* synthetic */ LogChannel access$000(ExlapExlapRestrictionModeWorker exlapExlapRestrictionModeWorker) {
        return exlapExlapRestrictionModeWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapExlapRestrictionModeWorker exlapExlapRestrictionModeWorker, Container container) {
        exlapExlapRestrictionModeWorker.container = container;
        return exlapExlapRestrictionModeWorker.container;
    }

    static /* synthetic */ int access$200(ExlapExlapRestrictionModeWorker exlapExlapRestrictionModeWorker) {
        return exlapExlapRestrictionModeWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapExlapRestrictionModeWorker exlapExlapRestrictionModeWorker) {
        exlapExlapRestrictionModeWorker.trigger();
    }
}

