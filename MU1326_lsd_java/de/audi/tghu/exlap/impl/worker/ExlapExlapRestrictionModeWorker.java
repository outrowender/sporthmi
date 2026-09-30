/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.ExlapRestrictionModeContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSettingsEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapExlapRestrictionModeWorker
extends ExlapAbstractWorker {
    private static final int EXLAP_RESTRICTION_MODE_PROPERTY = 30;

    public ExlapExlapRestrictionModeWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapExlapRestrictionModeWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(30, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapSettingsEmptyListener(){

            public void updateExlapRestrictionMode(ExlapRestrictionModeContainer exlapRestrictionModeContainer) {
                ExlapExlapRestrictionModeWorker.this.log.log(10000000, "[new ExlapSettingsEmptyListener#updateExlapRestrictionMode] received new container: %1", (Object)exlapRestrictionModeContainer);
                ExlapExlapRestrictionModeWorker.this.container = exlapRestrictionModeContainer;
                if (ExlapExlapRestrictionModeWorker.this.interval != -1) {
                    ExlapExlapRestrictionModeWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{30};
    }
}

