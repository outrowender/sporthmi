/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.ContextStatesContainer;
import de.audi.tghu.exlap.impl.listener.ExlapExlapEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapContextStatesWorker
extends ExlapAbstractWorker {
    private static final int CONTEXT_STATES_PROPERTY = 0x1000000;

    public ExlapContextStatesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapContextStatesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(0x1000000, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapExlapEmptyListener(){

            public void updateContextStates(ContextStatesContainer contextStatesContainer) {
                ExlapContextStatesWorker.this.log.log(10000000, "[new ExlapExlapEmptyListener#updateContextStates] received new container: %1", (Object)contextStatesContainer);
                ExlapContextStatesWorker.this.container = contextStatesContainer;
                if (ExlapContextStatesWorker.this.interval != -1) {
                    ExlapContextStatesWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{0x1000000};
    }
}

