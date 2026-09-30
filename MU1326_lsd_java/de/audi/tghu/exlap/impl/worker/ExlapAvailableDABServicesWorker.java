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

public class ExlapAvailableDABServicesWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_DABSERVICES_PROPERTY = 34;

    public ExlapAvailableDABServicesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapAvailableDABServicesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(34, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateAvailableDABServices(RadioStationsContainer radioStationsContainer) {
                ExlapAvailableDABServicesWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateAvailableDABServices] received new container: %1", (Object)radioStationsContainer);
                ExlapAvailableDABServicesWorker.this.container = radioStationsContainer;
                if (ExlapAvailableDABServicesWorker.this.interval != -1) {
                    ExlapAvailableDABServicesWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{34};
    }
}

