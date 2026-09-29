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
import de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserListWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapMediaBrowserListWorker
extends ExlapAbstractWorker {
    private static final int MEDIA_BROWSER_LIST_PROPERTY;

    public ExlapMediaBrowserListWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapMediaBrowserListWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(41, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapMediaBrowserListWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{41};
    }

    static /* synthetic */ LogChannel access$000(ExlapMediaBrowserListWorker exlapMediaBrowserListWorker) {
        return exlapMediaBrowserListWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapMediaBrowserListWorker exlapMediaBrowserListWorker, Container container) {
        exlapMediaBrowserListWorker.container = container;
        return exlapMediaBrowserListWorker.container;
    }

    static /* synthetic */ int access$200(ExlapMediaBrowserListWorker exlapMediaBrowserListWorker) {
        return exlapMediaBrowserListWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapMediaBrowserListWorker exlapMediaBrowserListWorker) {
        exlapMediaBrowserListWorker.trigger();
    }
}

