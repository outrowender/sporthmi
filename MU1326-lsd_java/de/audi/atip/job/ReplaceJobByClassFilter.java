/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.job;

import de.audi.atip.job.ReplaceJobByClassFilter$1;
import de.audi.atip.job.ReplaceJobFilter;

public class ReplaceJobByClassFilter
extends ReplaceJobFilter {
    public ReplaceJobByClassFilter(Class clazz) {
        super(new ReplaceJobByClassFilter$1(clazz));
    }
}

