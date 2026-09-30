/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.Job;
import java.io.PrintStream;

public interface IJobFilter {
    public IJobFilter getNext();

    public void setNext(IJobFilter var1);

    public void enqueue(Job var1, int var2);

    public void dump(PrintStream var1);
}

