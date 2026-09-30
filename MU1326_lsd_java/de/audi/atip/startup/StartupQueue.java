/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.BaseJobFilter;
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
        this.initFilterChain(new BaseJobFilter(){

            public void enqueue(Job job, int n) {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(new StartupJob((Runnable)job.getPayload()));
                StartupQueue.this.addQueue(arrayList, "stop");
            }
        });
    }

    public synchronized int length() {
        int n = 0;
        for (int i2 = 0; i2 < this.getJobs().size(); ++i2) {
            n += ((ArrayList)this.getJobs().get(i2)).size();
        }
        return n;
    }

    public synchronized Job getNextJob() {
        while (true) {
            if (!this.isSuspended()) {
                for (int i2 = 0; i2 < this.getJobs().size(); ++i2) {
                    ArrayList arrayList = (ArrayList)this.getJobs().get(i2);
                    if (arrayList.isEmpty()) continue;
                    StartupJob startupJob = (StartupJob)arrayList.remove(0);
                    startupJob.setQueueName((String)this.names.get(i2));
                    this.logStartup.log(10000000, "getNextJob() returned %1", (Object)startupJob);
                    return startupJob;
                }
            }
            try {
                this.wait();
                continue;
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
                continue;
            }
            break;
        }
    }

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
        this.notifyAll();
        return n;
    }

    synchronized void enqueue(List list, Runnable runnable, boolean bl) {
        StartupJob startupJob = new StartupJob(runnable);
        if (bl) {
            list.add(0, startupJob);
        } else {
            list.add(startupJob);
        }
        startupJob.setPosted(this.getTimeSource().getCurrentTime());
        this.notifyAll();
    }

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
            this.logStartup.log(100000, "Error when dumping startup manager queue!", (Throwable)exception);
        }
    }

    private static final class StartupJob
    extends Job {
        private String queueName = "";

        StartupJob(Runnable runnable) {
            super(runnable);
        }

        public String getQueueName() {
            return this.queueName;
        }

        public void setQueueName(String string) {
            this.queueName = string;
        }

        public String toString() {
            return "Job: [" + this.getQueueName() + "] " + this.getPayload();
        }
    }
}

