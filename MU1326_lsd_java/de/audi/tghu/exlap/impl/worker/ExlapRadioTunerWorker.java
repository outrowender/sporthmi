/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapRadioTunerWorker
extends ExlapAbstractWorker {
    private static final int RADIO_TUNER_PROPERTY = 39;

    public ExlapRadioTunerWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapRadioTunerWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(39, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateRadioTuner(RadioStationInfoContainer radioStationInfoContainer) {
                ExlapRadioTunerWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateRadioTuner] received new container: %1", (Object)radioStationInfoContainer);
                ExlapRadioTunerWorker.this.container = radioStationInfoContainer;
                if (ExlapRadioTunerWorker.this.interval != -1) {
                    ExlapRadioTunerWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{39};
    }
}

