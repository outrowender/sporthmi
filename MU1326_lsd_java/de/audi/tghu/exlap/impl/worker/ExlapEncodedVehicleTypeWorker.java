/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.EncodedVehicleTypeContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSystemEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapEncodedVehicleTypeWorker
extends ExlapAbstractWorker {
    private static final int ENCODED_VEHICLE_TYPE_PROPERTY = 51;

    public ExlapEncodedVehicleTypeWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapEncodedVehicleTypeWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(51, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapSystemEmptyListener(){

            public void updateEncodedVehicleType(EncodedVehicleTypeContainer encodedVehicleTypeContainer) {
                ExlapEncodedVehicleTypeWorker.this.log.log(10000000, "[new ExlapSystemEmptyListener#updateEncodedVehicleType] received new container: %1", (Object)encodedVehicleTypeContainer);
                ExlapEncodedVehicleTypeWorker.this.container = encodedVehicleTypeContainer;
                if (ExlapEncodedVehicleTypeWorker.this.interval != -1) {
                    ExlapEncodedVehicleTypeWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{51};
    }
}

