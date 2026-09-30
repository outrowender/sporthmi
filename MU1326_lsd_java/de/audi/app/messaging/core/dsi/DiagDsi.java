/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi;

import de.audi.app.messaging.core.util.Classes;
import de.audi.app.messaging.core.util.Strings;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;

public class DiagDsi
implements DSIBase {
    protected final String className = Classes.getShortClassName(this.getClass());
    protected final LogChannel log;
    public final DispatcherBase upcallDispatcher;
    private volatile boolean responsesEnabled = true;
    private volatile long responseDelayOffset = 0L;

    public DiagDsi(LogChannel logChannel, DispatcherBase dispatcherBase) {
        this.log = logChannel;
        this.upcallDispatcher = dispatcherBase;
    }

    public boolean isResponsesEnabled() {
        return this.responsesEnabled;
    }

    public void setResponsesEnabled(boolean bl) {
        this.log.log(10000000, "[%1#%2] responsesEnabled = %3", (Object)this.className, (Object)this.currentMethodName(), (Object)String.valueOf(bl));
        this.responsesEnabled = bl;
    }

    public long getResponseDelayOffset() {
        return this.responseDelayOffset;
    }

    public void setResponseDelayOffset(long l) {
        this.log.log(10000000, "[%1#%2] responseDelayOffset = %3", (Object)this.className, (Object)this.currentMethodName(), l);
        this.responseDelayOffset = l;
    }

    protected final void logNoResponseDefined(String string) {
        this.log.log(100000, "[%1#%2] No response defined for request. Doing nothing.", (Object)this.className, (Object)string);
    }

    public final void respond(String string, long l, Runnable runnable) {
        if (!this.responsesEnabled) {
            this.log.log(10000000, "[%1#%2] Responses disabled. Doing nothing.", (Object)this.className, (Object)string);
        } else {
            long l2 = this.getResponseDelayOffset() + l;
            this.upcall(string, l2, runnable);
        }
    }

    protected final void upcall(String string, long l, Runnable runnable) {
        this.log.log(10000000, "[%1#%2] Scheduling a DSI listener call for T + %3 ms.", (Object)this.className, (Object)string, l);
        this.upcallDispatcher.execute(runnable, l);
    }

    protected String currentMethodName() {
        String string = null;
        StackTraceElement[] stackTraceElementArray = new Throwable().getStackTrace();
        if (stackTraceElementArray.length > 1) {
            string = stackTraceElementArray[1].getMethodName();
        }
        return !Strings.isNullOrEmpty(string) ? string : "<UNKNOWN>";
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void setNotification(DSIListener dSIListener) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.logNoResponseDefined(this.currentMethodName());
    }

    public void clearNotification(DSIListener dSIListener) {
        this.logNoResponseDefined(this.currentMethodName());
    }
}

