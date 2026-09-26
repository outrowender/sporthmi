/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapRadioListener;
import de.audi.tghu.exlap.impl.container.TrafficAnnouncementContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractRadioService;

class ExlapAbstractRadioService$12
implements ListenerIterator {
    private final /* synthetic */ TrafficAnnouncementContainer val$trafficAnnouncementProperty;
    private final /* synthetic */ ExlapAbstractRadioService this$0;

    ExlapAbstractRadioService$12(ExlapAbstractRadioService exlapAbstractRadioService, TrafficAnnouncementContainer trafficAnnouncementContainer) {
        this.this$0 = exlapAbstractRadioService;
        this.val$trafficAnnouncementProperty = trafficAnnouncementContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapRadioListener)exlapListener).updateTrafficAnnouncement(this.val$trafficAnnouncementProperty);
    }
}

