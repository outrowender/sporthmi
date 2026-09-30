/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.GuidanceStateContainer;
import de.audi.tghu.exlap.impl.listener.ExlapNavigationEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapGuidanceStateWorker
extends ExlapAbstractWorker {
    private static final int GUIDANCE_STATE_PROPERTY = 7;

    public ExlapGuidanceStateWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapGuidanceStateWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(7, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapNavigationEmptyListener(){

            public void updateGuidanceState(GuidanceStateContainer guidanceStateContainer) {
                ExlapGuidanceStateWorker.this.log.log(10000000, "[new ExlapNavigationEmptyListener#updateGuidanceState] received new container: %1", (Object)guidanceStateContainer);
                ExlapGuidanceStateWorker.this.container = guidanceStateContainer;
                if (ExlapGuidanceStateWorker.this.interval != -1) {
                    ExlapGuidanceStateWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{7};
    }
}

