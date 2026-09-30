/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.job;

import de.esolutions.fw.util.commons.job.BaseJobFilter;
import de.esolutions.fw.util.commons.job.Job;

public class ReplaceJobFilter
extends BaseJobFilter {
    private Job current = null;
    private final IJobReplaceChecker comp;

    public ReplaceJobFilter(IJobReplaceChecker iJobReplaceChecker) {
        this.comp = iJobReplaceChecker;
    }

    public void enqueue(Job job, int n) {
        if (job != null && this.comp.shouldReplace(job)) {
            if (this.current != null) {
                this.current.cancel();
            }
            this.current = job;
        }
        super.enqueue(job, n);
    }

    static interface IJobReplaceChecker {
        public boolean shouldReplace(Job var1);
    }
}

