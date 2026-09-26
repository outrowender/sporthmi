/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.job;

import de.audi.atip.job.ReplaceJobFilter$IJobReplaceChecker;
import de.esolutions.fw.util.commons.job.Job;

class ReplaceJobByClassFilter$1
implements ReplaceJobFilter$IJobReplaceChecker {
    private final /* synthetic */ Class val$type;

    ReplaceJobByClassFilter$1(Class clazz) {
        this.val$type = clazz;
    }

    @Override
    public boolean shouldReplace(Job job) {
        return this.val$type.isInstance(job.getPayload());
    }
}

