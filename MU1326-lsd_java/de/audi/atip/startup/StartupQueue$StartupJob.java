/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.esolutions.fw.util.commons.job.Job;

final class StartupQueue$StartupJob
extends Job {
    private String queueName = "";

    StartupQueue$StartupJob(Runnable runnable) {
        super(runnable);
    }

    public String getQueueName() {
        return this.queueName;
    }

    public void setQueueName(String string) {
        this.queueName = string;
    }

    @Override
    public String toString() {
        return new StringBuffer().append("Job: [").append(this.getQueueName()).append("] ").append(this.getPayload()).toString();
    }
}

