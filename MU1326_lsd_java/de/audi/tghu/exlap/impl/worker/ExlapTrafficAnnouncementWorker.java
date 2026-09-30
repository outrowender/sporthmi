/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.app.ExlapAbstractWorker;
import de.audi.tghu.exlap.app.ExlapDispatcher;
import de.audi.tghu.exlap.impl.container.TrafficAnnouncementContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import org.dsi.ifc.has.DSIHAS;

public class ExlapTrafficAnnouncementWorker
extends ExlapAbstractWorker {
    private static final int TRAFFIC_ANNOUNCEMENT_PROPERTY = 48;

    public ExlapTrafficAnnouncementWorker(IFrameworkAccess iFrameworkAccess, ExlapDispatcher exlapDispatcher, DSIHAS dSIHAS) {
        super(iFrameworkAccess, exlapDispatcher, dSIHAS);
    }

    public void sendUpdates() {
        this.log.log(10000000, "[ExlapTrafficAnnouncementWorker#sendUpdates] sending container: %1", (Object)this.container);
        if (this.container != null) {
            this.dsiHas.propertyUpdate(48, this.container.createContainer(), 0);
        }
    }

    public ExlapListener createListener() {
        return new ExlapRadioEmptyListener(){

            public void updateTrafficAnnouncement(TrafficAnnouncementContainer trafficAnnouncementContainer) {
                ExlapTrafficAnnouncementWorker.this.log.log(10000000, "[new ExlapRadioEmptyListener#updateTrafficAnnouncement] received new container: %1", (Object)trafficAnnouncementContainer);
                ExlapTrafficAnnouncementWorker.this.container = trafficAnnouncementContainer;
                if (ExlapTrafficAnnouncementWorker.this.interval != -1) {
                    ExlapTrafficAnnouncementWorker.this.trigger();
                }
            }
        };
    }

    public int[] getAttributes() {
        return new int[]{48};
    }
}

