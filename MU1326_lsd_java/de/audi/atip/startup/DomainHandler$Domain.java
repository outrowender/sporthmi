/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.DomainHandler;
import de.audi.atip.startup.DomainHandler$DomainHistoryElement;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class DomainHandler$Domain {
    int id;
    int updated;
    boolean enabled = true;
    private boolean waitForFrontMU;
    List actionHistory = new LinkedList();
    private final /* synthetic */ DomainHandler this$0;

    DomainHandler$Domain(DomainHandler domainHandler, int n) {
        this.this$0 = domainHandler;
        this.id = n;
        this.updated = 0;
        this.waitForFrontMU = n == 3 || n == 6;
    }

    boolean isUpdated(int n) {
        return DomainHandler.isIncluded(n, this.updated);
    }

    boolean mustWaitForFrontMU() {
        return this.waitForFrontMU;
    }

    void disable() {
        this.enabled = false;
    }

    boolean isEnabled() {
        return this.enabled;
    }

    boolean startPrepare(int n) {
        if (this.isUpdated(n) || DomainHandler.isFailed(this.updated)) {
            return false;
        }
        this.actionHistory.add(new DomainHandler$DomainHistoryElement(this.this$0, 0, n));
        return true;
    }

    void finishedPrepare(int n) {
        this.actionHistory.add(new DomainHandler$DomainHistoryElement(this.this$0, 1, n));
    }

    boolean waitForStartFinished(int n) {
        long l = DomainHandler.access$000(this.this$0).getMonotonicTime() + DomainHandler.access$200();
        long l2 = DomainHandler.access$200() + 1L;
        while (!this.isUpdated(n) && !DomainHandler.isFailed(this.updated) && l2 > 0L) {
            try {
                this.this$0.getDomainSyncer().wait(l2);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
            }
            l2 = l - DomainHandler.access$000(this.this$0).getMonotonicTime() + 1L;
        }
        return this.isUpdated(n) && !DomainHandler.isFailed(this.updated);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void updateState(int n) {
        Object object = this.this$0.getDomainSyncer();
        synchronized (object) {
            this.actionHistory.add(new DomainHandler$DomainHistoryElement(this.this$0, 2, n));
            this.updated = n;
            this.this$0.getDomainSyncer().notifyAll();
        }
    }

    void dumpState(PrintStream printStream, String string) {
        printStream.print(string);
        printStream.print("Domain: ");
        printStream.print(this.id);
        printStream.print(" = ");
        printStream.print(DomainHandler.getDomainName(this.id));
        String string2 = new StringBuffer().append(string).append("\t").toString();
        Iterator iterator = this.actionHistory.iterator();
        while (iterator.hasNext()) {
            printStream.print(string2);
            printStream.print(iterator.next());
        }
    }
}

