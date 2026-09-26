/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.StartupQueue;
import de.audi.atip.startup.StartupQueue$StartupJob;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import java.util.ArrayList;

class StartupQueue$1
extends BaseJobFilter {
    private final /* synthetic */ StartupQueue this$0;

    StartupQueue$1(StartupQueue startupQueue) {
        this.this$0 = startupQueue;
    }

    @Override
    public void enqueue(Job job, int n) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new StartupQueue$StartupJob((Runnable)job.getPayload()));
        this.this$0.addQueue(arrayList, "stop");
    }
}

