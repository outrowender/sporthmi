/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.LastDestinationsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapNavigationEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapLastDestinationsWorker
extends ExlapAbstractWorker {
    private static final int LAST_DESTINATIONS_PROPERTY = 29;

    public ExlapLastDestinationsWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapLastDestinationsWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(29, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapNavigationEmptyListener(){

            public void updateLastDestinations(LastDestinationsContainer lastDestinationsContainer) {
                ExlapLastDestinationsWorker.this.log.log(10000000, "[new ExlapNavigationEmptyListener#updateLastDestinations] received new container: %1", (Object)lastDestinationsContainer);
                ExlapLastDestinationsWorker.this.container = lastDestinationsContainer;
                if (ExlapLastDestinationsWorker.this.interval != -1) {
                    ExlapLastDestinationsWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{29};
    }
}

