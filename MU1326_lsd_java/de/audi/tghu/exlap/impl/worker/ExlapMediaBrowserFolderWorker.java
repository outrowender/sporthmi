/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.MediaBrowserPathContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapMediaBrowserFolderWorker
extends ExlapAbstractWorker {
    private static final int MEDIA_BROWSER_FOLDER_PROPERTY = 47;

    public ExlapMediaBrowserFolderWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapMediaBrowserFolderWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(47, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapMediaEmptyListener(){

            public void updateMediaBrowserFolder(MediaBrowserPathContainer mediaBrowserPathContainer) {
                ExlapMediaBrowserFolderWorker.this.log.log(10000000, "[new ExlapMediaEmptyListener#updateMediaBrowserFolder] received new container: %1", (Object)mediaBrowserPathContainer);
                ExlapMediaBrowserFolderWorker.this.container = mediaBrowserPathContainer;
                if (ExlapMediaBrowserFolderWorker.this.interval != -1) {
                    ExlapMediaBrowserFolderWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{47};
    }
}

