/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.RadioFrequencyRangesContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapRadioFrequencyRangesWorker
extends ExlapAbstractWorker {
    private static final int RADIO_FREQUENCY_RANGES_PROPERTY = 40;

    public ExlapRadioFrequencyRangesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapRadioFrequencyRangesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(40, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateRadioFrequencyRanges(RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
                ExlapRadioFrequencyRangesWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateRadioFrequencyRanges] received new container: %1", (Object)radioFrequencyRangesContainer);
                ExlapRadioFrequencyRangesWorker.this.container = radioFrequencyRangesContainer;
                if (ExlapRadioFrequencyRangesWorker.this.interval != -1) {
                    ExlapRadioFrequencyRangesWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{40};
    }
}

