/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAvailableFMStationsWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_FMSTATIONS_PROPERTY = 32;

    public ExlapAvailableFMStationsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapAvailableFMStationsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(32, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateAvailableFMStations(RadioStationsContainer radioStationsContainer) {
                ExlapAvailableFMStationsWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateAvailableFMStations] received new container: %1", (Object)radioStationsContainer);
                ExlapAvailableFMStationsWorker.this.container = radioStationsContainer;
                if (ExlapAvailableFMStationsWorker.this.interval != -1) {
                    ExlapAvailableFMStationsWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{32};
    }
}

