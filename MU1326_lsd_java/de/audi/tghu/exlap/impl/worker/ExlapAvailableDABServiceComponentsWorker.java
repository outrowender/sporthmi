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

public class ExlapAvailableDABServiceComponentsWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_DABSERVICE_COMPONENTS_PROPERTY = 35;

    public ExlapAvailableDABServiceComponentsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapAvailableDABServiceComponentsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(35, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateAvailableDABServiceComponents(RadioStationsContainer radioStationsContainer) {
                ExlapAvailableDABServiceComponentsWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateAvailableDABServiceComponents] received new container: %1", (Object)radioStationsContainer);
                ExlapAvailableDABServiceComponentsWorker.this.container = radioStationsContainer;
                if (ExlapAvailableDABServiceComponentsWorker.this.interval != -1) {
                    ExlapAvailableDABServiceComponentsWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{35};
    }
}

