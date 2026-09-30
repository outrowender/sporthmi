/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.RadioBandsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAvailableRadioBandsWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_RADIO_BANDS_PROPERTY = 28;

    public ExlapAvailableRadioBandsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapAvailableRadioBandsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(28, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateAvailableRadioBands(RadioBandsContainer radioBandsContainer) {
                ExlapAvailableRadioBandsWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateAvailableRadioBands] received new container: %1", (Object)radioBandsContainer);
                ExlapAvailableRadioBandsWorker.this.container = radioBandsContainer;
                if (ExlapAvailableRadioBandsWorker.this.interval != -1) {
                    ExlapAvailableRadioBandsWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{28};
    }
}

