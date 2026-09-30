/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.MediaPlayInfoContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapMediaPlayInfoWorker
extends ExlapAbstractWorker {
    private static final int MEDIA_PLAY_INFO_PROPERTY = 22;

    public ExlapMediaPlayInfoWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapMediaPlayInfoWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(22, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapMediaEmptyListener(){

            public void updateMediaPlayInfo(MediaPlayInfoContainer mediaPlayInfoContainer) {
                ExlapMediaPlayInfoWorker.this.log.log(10000000, "[new ExlapMediaEmptyListener#updateMediaPlayInfo] received new container: %1", (Object)mediaPlayInfoContainer);
                ExlapMediaPlayInfoWorker.this.container = mediaPlayInfoContainer;
                if (ExlapMediaPlayInfoWorker.this.interval != -1) {
                    ExlapMediaPlayInfoWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{22};
    }
}

