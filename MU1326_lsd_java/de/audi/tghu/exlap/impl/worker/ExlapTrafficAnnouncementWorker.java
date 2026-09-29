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
import de.audi.tghu.exlap.impl.worker.ExlapTrafficAnnouncementWorker$1;
import org.dsi.ifc.has.DSIHAS;

public class ExlapTrafficAnnouncementWorker
extends ExlapAbstractWorker {
    private static final int TRAFFIC_ANNOUNCEMENT_PROPERTY;

    public ExlapTrafficAnnouncementWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    @Override
    public void sendUpdates() {
        this.log.log(-2137614336, "[ExlapTrafficAnnouncementWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(48, this.container.createContainer(), 0);
        }
    }

    @Override
    public ExlapListener createListener() {
        return new ExlapTrafficAnnouncementWorker$1(this);
    }

    @Override
    public int[] getAttributes() {
        return new int[]{48};
    }

    static /* synthetic */ LogChannel access$000(ExlapTrafficAnnouncementWorker exlapTrafficAnnouncementWorker) {
        return exlapTrafficAnnouncementWorker.log;
    }

    static /* synthetic */ Container access$102(ExlapTrafficAnnouncementWorker exlapTrafficAnnouncementWorker, Container container) {
        exlapTrafficAnnouncementWorker.container = container;
        return exlapTrafficAnnouncementWorker.container;
    }

    static /* synthetic */ int access$200(ExlapTrafficAnnouncementWorker exlapTrafficAnnouncementWorker) {
        return exlapTrafficAnnouncementWorker.interval;
    }

    static /* synthetic */ void access$300(ExlapTrafficAnnouncementWorker exlapTrafficAnnouncementWorker) {
        exlapTrafficAnnouncementWorker.trigger();
    }
}

