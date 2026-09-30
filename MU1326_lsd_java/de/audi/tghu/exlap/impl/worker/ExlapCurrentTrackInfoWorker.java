/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.TrackInfoContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapCurrentTrackInfoWorker
extends ExlapAbstractWorker {
    private static final int CURRENT_TRACK_INFO_PROPERTY = 21;

    public ExlapCurrentTrackInfoWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapCurrentTrackInfoWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(21, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapMediaEmptyListener(){

            public void updateCurrentTrackInfo(TrackInfoContainer trackInfoContainer) {
                ExlapCurrentTrackInfoWorker.this.log.log(10000000, "[new ExlapMediaEmptyListener#updateCurrentTrackInfo] received new container: %1", (Object)trackInfoContainer);
                ExlapCurrentTrackInfoWorker.this.container = trackInfoContainer;
                if (ExlapCurrentTrackInfoWorker.this.interval != -1) {
                    ExlapCurrentTrackInfoWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{21};
    }
}

