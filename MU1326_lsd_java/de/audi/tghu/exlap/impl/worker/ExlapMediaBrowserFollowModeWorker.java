/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.FollowModeContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapMediaBrowserFollowModeWorker
extends ExlapAbstractWorker {
    private static final int MEDIA_BROWSER_FOLLOW_MODE_PROPERTY = 43;

    public ExlapMediaBrowserFollowModeWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapMediaBrowserFollowModeWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(43, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapMediaEmptyListener(){

            public void updateMediaBrowserFollowMode(FollowModeContainer followModeContainer) {
                ExlapMediaBrowserFollowModeWorker.this.log.log(10000000, "[new ExlapMediaEmptyListener#updateMediaBrowserFollowMode] received new container: %1", (Object)followModeContainer);
                ExlapMediaBrowserFollowModeWorker.this.container = followModeContainer;
                if (ExlapMediaBrowserFollowModeWorker.this.interval != -1) {
                    ExlapMediaBrowserFollowModeWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{43};
    }
}

