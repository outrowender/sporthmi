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

public class ExlapAvailableDABEnsemblesWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_DABENSEMBLES_PROPERTY = 33;

    public ExlapAvailableDABEnsemblesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapAvailableDABEnsemblesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(33, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateAvailableDABEnsembles(RadioStationsContainer radioStationsContainer) {
                ExlapAvailableDABEnsemblesWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateAvailableDABEnsembles] received new container: %1", (Object)radioStationsContainer);
                ExlapAvailableDABEnsemblesWorker.this.container = radioStationsContainer;
                if (ExlapAvailableDABEnsemblesWorker.this.interval != -1) {
                    ExlapAvailableDABEnsemblesWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{33};
    }
}

