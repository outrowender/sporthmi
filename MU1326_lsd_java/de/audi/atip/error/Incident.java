/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.error;

import de.audi.atip.error.ShutdownGuard;

public class Incident {
    final long timestamp;
    final Throwable ex;
    final String reason;
    final int component;
    final int affected;
    final int persistence;
    final ShutdownGuard guard;

    Incident(long l, Throwable throwable, String string, int n, int n2, int n3, ShutdownGuard shutdownGuard) {
        this.timestamp = l;
        this.ex = throwable;
        this.reason = string;
        this.component = n;
        this.affected = n2;
        this.persistence = n3;
        this.guard = shutdownGuard;
    }

    public boolean needsReset() {
        return this.affected == 3 && this.persistence == 2 && (this.guard == null || this.guard.queryShutdown());
    }

    public boolean needsShutdown() {
        return this.affected == 3 && this.persistence == 3 && (this.guard == null || this.guard.queryShutdown());
    }

    public boolean isTriggeredManually() {
        return this.persistence == 4;
    }
}

