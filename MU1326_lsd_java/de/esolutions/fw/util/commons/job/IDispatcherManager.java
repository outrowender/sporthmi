/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.IInterceptor;
import de.esolutions.fw.util.commons.job.IJobLogger;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import de.esolutions.fw.util.commons.timeout.ITimeSource;

public interface IDispatcherManager {
    public DispatcherBase createDispatcher(String var1, IJobLogger var2);

    public DispatcherBase createDispatcher(String var1, IJobLogger var2, JobQueue var3);

    public DispatcherBase createDispatcher(String var1, IJobLogger var2, JobQueue var3, IInterceptor var4, Job var5);

    public void destroyDispatcher(String var1);

    public ITimeSource getTimeSource();
}

