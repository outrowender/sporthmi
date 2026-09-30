/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.GuidanceRemainingContainer;
import de.audi.tghu.exlap.impl.listener.ExlapNavigationEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapGuidanceRemainingWorker
extends ExlapAbstractWorker {
    private static final int GUIDANCE_REMAINING_PROPERTY = 24;

    public ExlapGuidanceRemainingWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapGuidanceRemainingWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(24, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapNavigationEmptyListener(){

            public void updateGuidanceRemaining(GuidanceRemainingContainer guidanceRemainingContainer) {
                ExlapGuidanceRemainingWorker.this.log.log(10000000, "[new ExlapNavigationEmptyListener#updateGuidanceRemaining] received new container: %1", (Object)guidanceRemainingContainer);
                ExlapGuidanceRemainingWorker.this.container = guidanceRemainingContainer;
                if (ExlapGuidanceRemainingWorker.this.interval != -1) {
                    ExlapGuidanceRemainingWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{24};
    }
}

