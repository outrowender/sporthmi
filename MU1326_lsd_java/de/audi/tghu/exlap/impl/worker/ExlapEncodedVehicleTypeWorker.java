/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.exlap.Container;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.worker.ExlapEncodedVehicleTypeWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapEncodedVehicleTypeWorker
extends ExlapAbstractWorker {
    private static final int ENCODED_VEHICLE_TYPE_PROPERTY;

    public ExlapEncodedVehicleTypeWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapEncodedVehicleTypeWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(51, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapEncodedVehicleTypeWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{51};
    }

    static /* synthetic */ LogChannel access$000(ExlapEncodedVehicleTypeWorker exlapEncodedVehicleTypeWorker) {
        return exlapEncodedVehicleTypeWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapEncodedVehicleTypeWorker exlapEncodedVehicleTypeWorker, Container container) {
        exlapEncodedVehicleTypeWorker.container = container;
        return exlapEncodedVehicleTypeWorker.container;
    }

    static /* synthetic */ int access$200(ExlapEncodedVehicleTypeWorker exlapEncodedVehicleTypeWorker) {
        return exlapEncodedVehicleTypeWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapEncodedVehicleTypeWorker exlapEncodedVehicleTypeWorker) {
        exlapEncodedVehicleTypeWorker.trigger();
    }
}

