/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapRadioAMPresetsWorker
extends ExlapAbstractWorker {
    private static final int RADIO_AMPRESETS_PROPERTY = 36;

    public ExlapRadioAMPresetsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapRadioAMPresetsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(36, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateRadioAMPresets(RadioPresetsContainer radioPresetsContainer) {
                ExlapRadioAMPresetsWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateRadioAMPresets] received new container: %1", (Object)radioPresetsContainer);
                ExlapRadioAMPresetsWorker.this.container = radioPresetsContainer;
                if (ExlapRadioAMPresetsWorker.this.interval != -1) {
                    ExlapRadioAMPresetsWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{36};
    }
}

