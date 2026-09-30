/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.UnitDistanceContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSystemEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapUnitDistanceWorker
extends ExlapAbstractWorker {
    private static final int UNIT_DISTANCE_PROPERTY = 13;

    public ExlapUnitDistanceWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapUnitDistanceWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(13, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapSystemEmptyListener(){

            public void updateUnitDistance(UnitDistanceContainer unitDistanceContainer) {
                ExlapUnitDistanceWorker.this.log.log(10000000, "[new ExlapSystemEmptyListener#updateUnitDistance] received new container: %1", (Object)unitDistanceContainer);
                ExlapUnitDistanceWorker.this.container = unitDistanceContainer;
                if (ExlapUnitDistanceWorker.this.interval != -1) {
                    ExlapUnitDistanceWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{13};
    }
}

