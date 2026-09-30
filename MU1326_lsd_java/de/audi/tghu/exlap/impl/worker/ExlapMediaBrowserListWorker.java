/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.ListStateContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapMediaBrowserListWorker
extends ExlapAbstractWorker {
    private static final int MEDIA_BROWSER_LIST_PROPERTY = 41;

    public ExlapMediaBrowserListWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapMediaBrowserListWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(41, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapMediaEmptyListener(){

            public void updateMediaBrowserList(ListStateContainer listStateContainer) {
                ExlapMediaBrowserListWorker.this.log.log(10000000, "[new ExlapMediaEmptyListener#updateMediaBrowserList] received new container: %1", (Object)listStateContainer);
                ExlapMediaBrowserListWorker.this.container = listStateContainer;
                if (ExlapMediaBrowserListWorker.this.interval != -1) {
                    ExlapMediaBrowserListWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{41};
    }
}

