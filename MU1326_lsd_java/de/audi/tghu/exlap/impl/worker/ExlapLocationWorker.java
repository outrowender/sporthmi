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

public class ExlapLocationWorker
extends ExlapAbstractWorker {
    private static final int LOCATION_PROPERTY = 1;

    public ExlapLocationWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapLocationWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(1, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapNavigationEmptyListener(){

            public void updateLocation(AddressContainer addressContainer) {
                ExlapLocationWorker.this.log.log(10000000, "[new ExlapNavigationEmptyListener#updateLocation] received new container: %1", (Object)addressContainer);
                ExlapLocationWorker.this.container = addressContainer;
                if (ExlapLocationWorker.this.interval != -1) {
                    ExlapLocationWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{1};
    }
}

