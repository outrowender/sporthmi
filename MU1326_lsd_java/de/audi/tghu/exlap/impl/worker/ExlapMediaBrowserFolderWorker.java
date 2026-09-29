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
import de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFolderWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapMediaBrowserFolderWorker
extends ExlapAbstractWorker {
    private static final int MEDIA_BROWSER_FOLDER_PROPERTY;

    public ExlapMediaBrowserFolderWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapMediaBrowserFolderWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(47, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapMediaBrowserFolderWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{47};
    }

    static /* synthetic */ LogChannel access$000(ExlapMediaBrowserFolderWorker exlapMediaBrowserFolderWorker) {
        return exlapMediaBrowserFolderWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapMediaBrowserFolderWorker exlapMediaBrowserFolderWorker, Container container) {
        exlapMediaBrowserFolderWorker.container = container;
        return exlapMediaBrowserFolderWorker.container;
    }

    static /* synthetic */ int access$200(ExlapMediaBrowserFolderWorker exlapMediaBrowserFolderWorker) {
        return exlapMediaBrowserFolderWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapMediaBrowserFolderWorker exlapMediaBrowserFolderWorker) {
        exlapMediaBrowserFolderWorker.trigger();
    }
}

