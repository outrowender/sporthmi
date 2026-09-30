/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.job;

import de.audi.atip.job.ReplaceJobFilter;
import de.esolutions.fw.util.commons.job.Job;

public class ReplaceJobByClassFilter
extends ReplaceJobFilter {
    public ReplaceJobByClassFilter(final Class clazz) {
        super(new ReplaceJobFilter.IJobReplaceChecker(){

            public boolean shouldReplace(Job job) {
                return clazz.isInstance(job.getPayload());
            }
        });
    }
}

