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
import de.audi.tghu.exlap.impl.worker.ExlapRadioTunerWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapRadioTunerWorker
extends ExlapAbstractWorker {
    private static final int RADIO_TUNER_PROPERTY;

    public ExlapRadioTunerWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapRadioTunerWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(39, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapRadioTunerWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{39};
    }

    static /* synthetic */ LogChannel access$000(ExlapRadioTunerWorker exlapRadioTunerWorker) {
        return exlapRadioTunerWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapRadioTunerWorker exlapRadioTunerWorker, Container container) {
        exlapRadioTunerWorker.container = container;
        return exlapRadioTunerWorker.container;
    }

    static /* synthetic */ int access$200(ExlapRadioTunerWorker exlapRadioTunerWorker) {
        return exlapRadioTunerWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapRadioTunerWorker exlapRadioTunerWorker) {
        exlapRadioTunerWorker.trigger();
    }
}

