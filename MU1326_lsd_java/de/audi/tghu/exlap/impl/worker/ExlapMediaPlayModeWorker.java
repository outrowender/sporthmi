/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.MediaPlayModeContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapMediaPlayModeWorker
extends ExlapAbstractWorker {
    private static final int MEDIA_PLAY_MODE_PROPERTY = 23;

    public ExlapMediaPlayModeWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapMediaPlayModeWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(23, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapMediaEmptyListener(){

            public void updateMediaPlayMode(MediaPlayModeContainer mediaPlayModeContainer) {
                ExlapMediaPlayModeWorker.this.log.log(10000000, "[new ExlapMediaEmptyListener#updateMediaPlayMode] received new container: %1", (Object)mediaPlayModeContainer);
                ExlapMediaPlayModeWorker.this.container = mediaPlayModeContainer;
                if (ExlapMediaPlayModeWorker.this.interval != -1) {
                    ExlapMediaPlayModeWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{23};
    }
}

