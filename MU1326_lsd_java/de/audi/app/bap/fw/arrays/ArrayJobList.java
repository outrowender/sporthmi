/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

import de.audi.app.bap.fw.arrays.AbstractArrayJobListMonitor;
import de.audi.app.bap.fw.arrays.GetArrayJob;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.Monitor;

public class ArrayJobList
extends CommandList {
    private AbstractArrayJobListMonitor jobListMonitor;

    public ArrayJobList(CommandListManager commandListManager) {
        super(commandListManager);
    }

    public void addMonitor(Monitor monitor) {
        if (monitor instanceof AbstractArrayJobListMonitor) {
            this.jobListMonitor = (AbstractArrayJobListMonitor)monitor;
        }
        super.addMonitor(monitor);
    }

    public void commandFinished() {
        GetArrayJob getArrayJob = (GetArrayJob)this.getActiveCommand();
        int n = getArrayJob.getJobID();
        if (this.jobListMonitor != null && n != -1) {
            this.jobListMonitor.notifyJobFinished(n);
        }
        super.commandFinished();
    }

    public void commandAborted(long l) {
        this.commandAborted();
        super.commandAborted(l);
    }

    public void commandAborted(Exception exception) {
        this.commandAborted();
        super.commandAborted(exception);
    }

    public void commandAborted(String string, String string2) {
        this.commandAborted();
        super.commandAborted(string, string2);
    }

    public void commandAborted(String string) {
        this.commandAborted();
        super.commandAborted(string);
    }

    private void commandAborted() {
        GetArrayJob getArrayJob = (GetArrayJob)this.getActiveCommand();
        int n = getArrayJob.getJobID();
        if (this.jobListMonitor != null && n != -1) {
            this.jobListMonitor.notifyJobCancelled(n);
        }
    }
}

