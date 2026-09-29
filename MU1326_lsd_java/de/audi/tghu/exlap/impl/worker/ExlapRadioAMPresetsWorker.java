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
import de.audi.tghu.exlap.impl.worker.ExlapRadioAMPresetsWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapRadioAMPresetsWorker
extends ExlapAbstractWorker {
    private static final int RADIO_AMPRESETS_PROPERTY;

    public ExlapRadioAMPresetsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapRadioAMPresetsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(36, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapRadioAMPresetsWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{36};
    }

    static /* synthetic */ LogChannel access$000(ExlapRadioAMPresetsWorker exlapRadioAMPresetsWorker) {
        return exlapRadioAMPresetsWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapRadioAMPresetsWorker exlapRadioAMPresetsWorker, Container container) {
        exlapRadioAMPresetsWorker.container = container;
        return exlapRadioAMPresetsWorker.container;
    }

    static /* synthetic */ int access$200(ExlapRadioAMPresetsWorker exlapRadioAMPresetsWorker) {
        return exlapRadioAMPresetsWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapRadioAMPresetsWorker exlapRadioAMPresetsWorker) {
        exlapRadioAMPresetsWorker.trigger();
    }
}

