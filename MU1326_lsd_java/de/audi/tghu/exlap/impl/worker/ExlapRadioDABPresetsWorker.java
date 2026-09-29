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
import de.audi.tghu.exlap.impl.worker.ExlapRadioDABPresetsWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapRadioDABPresetsWorker
extends ExlapAbstractWorker {
    private static final int RADIO_DABPRESETS_PROPERTY;

    public ExlapRadioDABPresetsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapRadioDABPresetsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(38, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapRadioDABPresetsWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{38};
    }

    static /* synthetic */ LogChannel access$000(ExlapRadioDABPresetsWorker exlapRadioDABPresetsWorker) {
        return exlapRadioDABPresetsWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapRadioDABPresetsWorker exlapRadioDABPresetsWorker, Container container) {
        exlapRadioDABPresetsWorker.container = container;
        return exlapRadioDABPresetsWorker.container;
    }

    static /* synthetic */ int access$200(ExlapRadioDABPresetsWorker exlapRadioDABPresetsWorker) {
        return exlapRadioDABPresetsWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapRadioDABPresetsWorker exlapRadioDABPresetsWorker) {
        exlapRadioDABPresetsWorker.trigger();
    }
}

