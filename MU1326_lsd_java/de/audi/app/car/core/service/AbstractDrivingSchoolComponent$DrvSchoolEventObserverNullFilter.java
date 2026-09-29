/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.service;

import de.audi.app.car.core.service.AbstractDrivingSchoolComponent;
import de.audi.atip.hmi.event.KeyEvent;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;

public class AbstractDrivingSchoolComponent$DrvSchoolEventObserverNullFilter
extends BaseJobFilter {
    private final /* synthetic */ AbstractDrivingSchoolComponent this$0;

    public AbstractDrivingSchoolComponent$DrvSchoolEventObserverNullFilter(AbstractDrivingSchoolComponent abstractDrivingSchoolComponent) {
        this.this$0 = abstractDrivingSchoolComponent;
    }

    @Override
    public void enqueue(Job job, int n) {
        super.enqueue(job, n);
        if (this.this$0.drvSchoolMode && job.getPayload() instanceof KeyEvent) {
            KeyEvent keyEvent = (KeyEvent)job.getPayload();
            this.this$0.getLogChannel().log(-2137614336, "%1: event %2", (Object)"DrvSchoolEventObserverNullFilter.enqueue", (Object)keyEvent);
            boolean bl = AbstractDrivingSchoolComponent.access$000(this.this$0).getFrameworkAccess().getHMIService().getEventDispatcherAdmin().isUserInteraction(keyEvent);
            if (bl) {
                this.this$0.getLogChannel().log(-2137614336, "%1: user interaction - restarting Timer!", (Object)"DrvSchoolEventObserverNullFilter.enqueue");
                this.this$0.deactivateDisplay();
                this.this$0.timer.restart();
            }
        }
    }
}

