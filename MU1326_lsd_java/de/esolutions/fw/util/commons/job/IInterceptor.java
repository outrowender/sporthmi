/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.commons.job;

import de.esolutions.fw.util.commons.job.Job;
import java.io.PrintStream;

public interface IInterceptor {
    public IInterceptor getNext();

    public void setNext(IInterceptor var1);

    public void execute(Job var1);

    public void dump(PrintStream var1);
}

