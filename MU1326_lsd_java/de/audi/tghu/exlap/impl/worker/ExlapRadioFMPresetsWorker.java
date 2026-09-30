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

public class ExlapRadioFMPresetsWorker
extends ExlapAbstractWorker {
    private static final int RADIO_FMPRESETS_PROPERTY = 37;

    public ExlapRadioFMPresetsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapRadioFMPresetsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(37, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateRadioFMPresets(RadioPresetsContainer radioPresetsContainer) {
                ExlapRadioFMPresetsWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateRadioFMPresets] received new container: %1", (Object)radioPresetsContainer);
                ExlapRadioFMPresetsWorker.this.container = radioPresetsContainer;
                if (ExlapRadioFMPresetsWorker.this.interval != -1) {
                    ExlapRadioFMPresetsWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{37};
    }
}

