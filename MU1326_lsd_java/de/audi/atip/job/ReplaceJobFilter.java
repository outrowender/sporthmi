/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.job;

import de.audi.atip.job.ReplaceJobFilter$IJobReplaceChecker;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;

public class ReplaceJobFilter
extends BaseJobFilter {
    private Job current = null;
    private final ReplaceJobFilter$IJobReplaceChecker comp;

    public ReplaceJobFilter(ReplaceJobFilter$IJobReplaceChecker iJobReplaceChecker) {
        this.comp = iJobReplaceChecker;
    }

    @Override
    public void enqueue(Job job, int n) {
        if (job != null && this.comp.shouldReplace(job)) {
            if (this.current != null) {
                this.current.cancel();
            }
            this.current = job;
        }
        super.enqueue(job, n);
    }
}

