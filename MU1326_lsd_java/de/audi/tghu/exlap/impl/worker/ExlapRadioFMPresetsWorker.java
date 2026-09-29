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
import de.audi.tghu.exlap.impl.worker.ExlapRadioFMPresetsWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapRadioFMPresetsWorker
extends ExlapAbstractWorker {
    private static final int RADIO_FMPRESETS_PROPERTY;

    public ExlapRadioFMPresetsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapRadioFMPresetsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(37, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapRadioFMPresetsWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{37};
    }

    static /* synthetic */ LogChannel access$000(ExlapRadioFMPresetsWorker exlapRadioFMPresetsWorker) {
        return exlapRadioFMPresetsWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapRadioFMPresetsWorker exlapRadioFMPresetsWorker, Container container) {
        exlapRadioFMPresetsWorker.container = container;
        return exlapRadioFMPresetsWorker.container;
    }

    static /* synthetic */ int access$200(ExlapRadioFMPresetsWorker exlapRadioFMPresetsWorker) {
        return exlapRadioFMPresetsWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapRadioFMPresetsWorker exlapRadioFMPresetsWorker) {
        exlapRadioFMPresetsWorker.trigger();
    }
}

