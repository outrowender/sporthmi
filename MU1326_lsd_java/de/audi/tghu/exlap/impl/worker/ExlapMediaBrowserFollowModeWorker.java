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
import de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFollowModeWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapMediaBrowserFollowModeWorker
extends ExlapAbstractWorker {
    private static final int MEDIA_BROWSER_FOLLOW_MODE_PROPERTY;

    public ExlapMediaBrowserFollowModeWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapMediaBrowserFollowModeWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(43, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapMediaBrowserFollowModeWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{43};
    }

    static /* synthetic */ LogChannel access$000(ExlapMediaBrowserFollowModeWorker exlapMediaBrowserFollowModeWorker) {
        return exlapMediaBrowserFollowModeWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapMediaBrowserFollowModeWorker exlapMediaBrowserFollowModeWorker, Container container) {
        exlapMediaBrowserFollowModeWorker.container = container;
        return exlapMediaBrowserFollowModeWorker.container;
    }

    static /* synthetic */ int access$200(ExlapMediaBrowserFollowModeWorker exlapMediaBrowserFollowModeWorker) {
        return exlapMediaBrowserFollowModeWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapMediaBrowserFollowModeWorker exlapMediaBrowserFollowModeWorker) {
        exlapMediaBrowserFollowModeWorker.trigger();
    }
}

