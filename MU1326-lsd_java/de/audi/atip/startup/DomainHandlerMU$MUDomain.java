/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.startup;

import de.audi.atip.startup.DomainHandlerMU;
import java.io.PrintStream;

class DomainHandlerMU$MUDomain {
    int id;
    int requested;
    int responded;
    int updated;
    int propagated;
    long[] timeRequested = new long[17];
    long[] timeResponded = new long[17];
    long[] timeUpdated = new long[17];
    private final /* synthetic */ DomainHandlerMU this$0;

    DomainHandlerMU$MUDomain(DomainHandlerMU domainHandlerMU, int n) {
        this.this$0 = domainHandlerMU;
        this.id = n;
        this.requested = 0;
        this.responded = 0;
        this.updated = 0;
        this.propagated = 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean isDomainStarted(int n) {
        Object object = DomainHandlerMU.access$000(this.this$0);
        synchronized (object) {
            return this.responded >= n || this.updated >= n;
        }
    }

    void propagateState(int n) {
        if (n > this.propagated) {
            this.propagated = n;
            this.this$0.getDomainHandler().updateMUDomain(this.id, n);
        }
    }

    boolean startPrepare(int n) {
        if (n > this.requested) {
            this.requested = n;
            if (this.timeRequested[n] == 0L) {
                this.timeRequested[n] = System.currentTimeMillis();
            }
            return true;
        }
        return false;
    }

    void finishedPrepare(int n) {
        if (n > this.responded) {
            this.responded = n;
            if (this.timeResponded[n] == 0L) {
                this.timeResponded[n] = System.currentTimeMillis();
            }
            this.propagateState(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void updateState(int n) {
        Object object = DomainHandlerMU.access$000(this.this$0);
        synchronized (object) {
            if (n > this.updated) {
                this.updated = n;
                if (this.timeUpdated[n] == 0L) {
                    this.timeUpdated[n] = System.currentTimeMillis();
                }
                this.propagateState(n);
            }
        }
    }

    void dumpState(PrintStream printStream, String string) {
        printStream.print(string);
        printStream.print("Domain: ");
        printStream.print(this.id);
        printStream.print(" ( state, requested, responded, updated )");
        for (int i2 = 2; i2 <= 16; ++i2) {
            printStream.print(string);
            printStream.print("(");
            printStream.print(i2);
            printStream.print(",");
            printStream.print(this.timeRequested[i2]);
            printStream.print(",");
            printStream.print(this.timeResponded[i2]);
            printStream.print(",");
            printStream.print(this.timeUpdated[i2]);
            printStream.print(")");
        }
    }
}

