/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.startup.StartupQueue$1;
import de.audi.atip.startup.StartupQueue$StartupJob;
import de.esolutions.fw.util.commons.job.Job;
import de.esolutions.fw.util.commons.job.JobQueue;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class StartupQueue
extends JobQueue {
    private final LogChannel logStartup;
    private final List names = new ArrayList(10);

    StartupQueue(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        super(iFrameworkAccess.getMonotonicTimeSource());
        this.logStartup = logChannel;
        this.initFilterChain(new StartupQueue$1(this));
    }

    @Override
    public synchronized int length() {
        int n = 0;
        for (int i2 = 0; i2 < this.getJobs().size(); ++i2) {
            n += ((ArrayList)this.getJobs().get(i2)).size();
        }
        return n;
    }

    @Override
    public synchronized Job getNextJob() {
        while (true) {
            if (!this.isSuspended()) {
                for (int i2 = 0; i2 < this.getJobs().size(); ++i2) {
                    ArrayList arrayList = (ArrayList)this.getJobs().get(i2);
                    if (arrayList.isEmpty()) continue;
                    StartupQueue$StartupJob startupQueue$StartupJob = (StartupQueue$StartupJob)arrayList.remove(0);
                    startupQueue$StartupJob.setQueueName((String)this.names.get(i2));
                    this.logStartup.log(-2137614336, "getNextJob() returned %1", (Object)startupQueue$StartupJob);
                    return startupQueue$StartupJob;
                }
            }
            try {
                super.wait();
                continue;
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
                continue;
            }
            break;
        }
    }

    @Override
    public synchronized Job peek() {
        for (int i2 = 0; i2 < this.getJobs().size(); ++i2) {
            ArrayList arrayList = (ArrayList)this.getJobs().get(i2);
            if (arrayList.isEmpty()) continue;
            return (Job)arrayList.get(0);
        }
        return null;
    }

    synchronized int addQueue(List list, String string) {
        int n = this.getJobs().size();
        this.getJobs().add(list);
        this.names.add(string);
        super.notifyAll();
        return n;
    }

    synchronized void enqueue(List list, Runnable runnable, boolean bl) {
        StartupQueue$StartupJob startupQueue$StartupJob = new StartupQueue$StartupJob(runnable);
        if (bl) {
            list.add(0, startupQueue$StartupJob);
        } else {
            list.add(startupQueue$StartupJob);
        }
        startupQueue$StartupJob.setPosted(this.getTimeSource().getCurrentTime());
        super.notifyAll();
    }

    @Override
    public synchronized void dump(PrintStream printStream) {
        try {
            printStream.println("StartupQueue contents:");
            for (int i2 = 0; i2 < this.getJobs().size(); ++i2) {
                printStream.println(this.names.get(i2));
                ArrayList arrayList = (ArrayList)this.getJobs().get(i2);
                for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                    printStream.print("\t");
                    printStream.println(arrayList.get(i3));
                }
            }
        }
        catch (Exception exception) {
            this.logStartup.log(-1601830656, "Error when dumping startup manager queue!", (Throwable)exception);
        }
    }
}

