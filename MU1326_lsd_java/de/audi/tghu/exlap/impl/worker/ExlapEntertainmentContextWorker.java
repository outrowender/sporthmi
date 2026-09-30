/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.EntertainmentContextContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSoundEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapEntertainmentContextWorker
extends ExlapAbstractWorker {
    private static final int ENTERTAINMENT_CONTEXT_PROPERTY = 58;

    public ExlapEntertainmentContextWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapEntertainmentContextWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(58, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapSoundEmptyListener(){

            public void updateEntertainmentContext(EntertainmentContextContainer entertainmentContextContainer) {
                ExlapEntertainmentContextWorker.this.log.log(10000000, "[new ExlapSoundEmptyListener#updateEntertainmentContext] received new container: %1", (Object)entertainmentContextContainer);
                ExlapEntertainmentContextWorker.this.container = entertainmentContextContainer;
                if (ExlapEntertainmentContextWorker.this.interval != -1) {
                    ExlapEntertainmentContextWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{58};
    }
}

