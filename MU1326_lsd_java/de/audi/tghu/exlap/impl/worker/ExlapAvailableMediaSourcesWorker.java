/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.MediaSourcesContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapAvailableMediaSourcesWorker
extends ExlapAbstractWorker {
    private static final int AVAILABLE_MEDIA_SOURCES_PROPERTY = 27;

    public ExlapAvailableMediaSourcesWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapAvailableMediaSourcesWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(27, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapMediaEmptyListener(){

            public void updateAvailableMediaSources(MediaSourcesContainer mediaSourcesContainer) {
                ExlapAvailableMediaSourcesWorker.this.log.log(10000000, "[new ExlapMediaEmptyListener#updateAvailableMediaSources] received new container: %1", (Object)mediaSourcesContainer);
                ExlapAvailableMediaSourcesWorker.this.container = mediaSourcesContainer;
                if (ExlapAvailableMediaSourcesWorker.this.interval != -1) {
                    ExlapAvailableMediaSourcesWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{27};
    }
}

