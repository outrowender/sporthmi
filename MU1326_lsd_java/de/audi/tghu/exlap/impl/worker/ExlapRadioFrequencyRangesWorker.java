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
import de.audi.tghu.exlap.impl.worker.ExlapRadioFrequencyRangesWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapRadioFrequencyRangesWorker
extends ExlapAbstractWorker {
    private static final int RADIO_FREQUENCY_RANGES_PROPERTY;

    public ExlapRadioFrequencyRangesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapRadioFrequencyRangesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(40, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapRadioFrequencyRangesWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{40};
    }

    static /* synthetic */ LogChannel access$000(ExlapRadioFrequencyRangesWorker exlapRadioFrequencyRangesWorker) {
        return exlapRadioFrequencyRangesWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapRadioFrequencyRangesWorker exlapRadioFrequencyRangesWorker, Container container) {
        exlapRadioFrequencyRangesWorker.container = container;
        return exlapRadioFrequencyRangesWorker.container;
    }

    static /* synthetic */ int access$200(ExlapRadioFrequencyRangesWorker exlapRadioFrequencyRangesWorker) {
        return exlapRadioFrequencyRangesWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapRadioFrequencyRangesWorker exlapRadioFrequencyRangesWorker) {
        exlapRadioFrequencyRangesWorker.trigger();
    }
}

