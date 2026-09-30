/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.AddressContainer;
import de.audi.tghu.exlap.impl.listener.ExlapNavigationEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapGuidanceDestinationWorker
extends ExlapAbstractWorker {
    private static final int GUIDANCE_DESTINATION_PROPERTY = 8;

    public ExlapGuidanceDestinationWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapGuidanceDestinationWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(8, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapNavigationEmptyListener(){

            public void updateGuidanceDestination(AddressContainer addressContainer) {
                ExlapGuidanceDestinationWorker.this.log.log(10000000, "[new ExlapNavigationEmptyListener#updateGuidanceDestination] received new container: %1", (Object)addressContainer);
                ExlapGuidanceDestinationWorker.this.container = addressContainer;
                if (ExlapGuidanceDestinationWorker.this.interval != -1) {
                    ExlapGuidanceDestinationWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{8};
    }
}

