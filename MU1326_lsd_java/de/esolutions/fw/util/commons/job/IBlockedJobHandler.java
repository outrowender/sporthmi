/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.Job;

public interface IBlockedJobHandler {
    public void blocked(Job var1, long var2);

    public void unblocked(Job var1);

    public void lengthWarning(int var1, int var2);

    public void lengthExceeded(int var1, int var2);
}

