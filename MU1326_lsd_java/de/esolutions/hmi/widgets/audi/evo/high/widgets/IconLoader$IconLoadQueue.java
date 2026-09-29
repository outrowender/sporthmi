/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.IconLoader$IconLoadQueue$1;
import java.util.List;

final class IconLoader$IconLoadQueue
extends JobQueue {
    public IconLoader$IconLoadQueue(ITimeSource iTimeSource) {
        super(iTimeSource);
        this.initFilterChain(new IconLoader$IconLoadQueue$1(this));
    }

    static /* synthetic */ List access$000(IconLoader$IconLoadQueue iconLoader$IconLoadQueue) {
        return iconLoader$IconLoadQueue.getJobs();
    }

    static /* synthetic */ Job access$100(IconLoader$IconLoadQueue iconLoader$IconLoadQueue, int n) {
        return iconLoader$IconLoadQueue.getJob(n);
    }

    static /* synthetic */ ITimeSource access$200(IconLoader$IconLoadQueue iconLoader$IconLoadQueue) {
        return iconLoader$IconLoadQueue.getTimeSource();
    }
}

