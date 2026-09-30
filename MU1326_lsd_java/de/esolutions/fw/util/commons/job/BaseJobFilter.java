/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.IJobFilter;
import de.esolutions.fw.util.commons.job.Job;
import java.io.PrintStream;

public class BaseJobFilter
implements IJobFilter {
    private IJobFilter next;

    public void enqueue(Job job, int n) {
        if (this.next != null) {
            this.next.enqueue(job, n);
        }
    }

    public IJobFilter getNext() {
        return this.next;
    }

    public void setNext(IJobFilter iJobFilter) {
        this.next = iJobFilter;
    }

    public void dump(PrintStream printStream) {
        printStream.println("  " + this);
        if (this.next != null) {
            this.next.dump(printStream);
        }
    }
}

