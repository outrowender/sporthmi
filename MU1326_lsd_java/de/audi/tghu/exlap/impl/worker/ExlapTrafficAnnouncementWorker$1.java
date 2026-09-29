/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.TrafficAnnouncementContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapTrafficAnnouncementWorker;

class ExlapTrafficAnnouncementWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapTrafficAnnouncementWorker this$0;

    ExlapTrafficAnnouncementWorker$1(ExlapTrafficAnnouncementWorker exlapTrafficAnnouncementWorker) {
        this.this$0 = exlapTrafficAnnouncementWorker;
    }

    @Override
    public void updateTrafficAnnouncement(TrafficAnnouncementContainer trafficAnnouncementContainer) {
        ExlapTrafficAnnouncementWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateTrafficAnnouncement] received new container: %1", (Object)trafficAnnouncementContainer);
        ExlapTrafficAnnouncementWorker.access$102(this.this$0, trafficAnnouncementContainer);
        if (ExlapTrafficAnnouncementWorker.access$200(this.this$0) != -1) {
            ExlapTrafficAnnouncementWorker.access$300(this.this$0);
        }
    }
}

