/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

class AuditTrail$Entry {
    long start = 0L;
    long startProcessingQueued = 0L;
    long finished = 0L;
    String thread;
    String action;
    Object ref;

    AuditTrail$Entry() {
    }

    AuditTrail$Entry(String string, Object object) {
        this.start = System.currentTimeMillis();
        this.thread = Thread.currentThread().getName();
        this.action = string;
        this.ref = object;
    }

    void setStartProcessingQueued() {
        this.startProcessingQueued = System.currentTimeMillis();
    }

    void setFinished() {
        this.finished = System.currentTimeMillis();
    }

    public String toString() {
        return new StringBuffer().append("start#").append(this.start).append("#queue#").append(this.startProcessingQueued).append("#done#").append(this.finished).append("#thread#").append(this.thread).append("#").append(this.action).append("#").append(this.ref).toString();
    }
}

