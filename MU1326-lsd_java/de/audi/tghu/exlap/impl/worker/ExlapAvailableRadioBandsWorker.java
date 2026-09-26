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
import de.audi.tghu.exlap.impl.worker.ExlapAvailableRadioBandsWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAvailableRadioBandsWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_RADIO_BANDS_PROPERTY;

    public ExlapAvailableRadioBandsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapAvailableRadioBandsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(28, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapAvailableRadioBandsWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{28};
    }

    static /* synthetic */ LogChannel access$000(ExlapAvailableRadioBandsWorker exlapAvailableRadioBandsWorker) {
        return exlapAvailableRadioBandsWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapAvailableRadioBandsWorker exlapAvailableRadioBandsWorker, Container container) {
        exlapAvailableRadioBandsWorker.container = container;
        return exlapAvailableRadioBandsWorker.container;
    }

    static /* synthetic */ int access$200(ExlapAvailableRadioBandsWorker exlapAvailableRadioBandsWorker) {
        return exlapAvailableRadioBandsWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapAvailableRadioBandsWorker exlapAvailableRadioBandsWorker) {
        exlapAvailableRadioBandsWorker.trigger();
    }
}

