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
import de.audi.tghu.exlap.impl.worker.ExlapRadioTextWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapRadioTextWorker
extends ExlapAbstractWorker {
    private static final int RADIO_TEXT_PROPERTY;

    public ExlapRadioTextWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapRadioTextWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(49, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapRadioTextWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{49};
    }

    static /* synthetic */ LogChannel access$000(ExlapRadioTextWorker exlapRadioTextWorker) {
        return exlapRadioTextWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapRadioTextWorker exlapRadioTextWorker, Container container) {
        exlapRadioTextWorker.container = container;
        return exlapRadioTextWorker.container;
    }

    static /* synthetic */ int access$200(ExlapRadioTextWorker exlapRadioTextWorker) {
        return exlapRadioTextWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapRadioTextWorker exlapRadioTextWorker) {
        exlapRadioTextWorker.trigger();
    }
}

