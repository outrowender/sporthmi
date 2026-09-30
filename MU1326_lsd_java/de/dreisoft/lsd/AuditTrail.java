/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class AuditTrail {
    static final AuditTrail INSTANCE = new AuditTrail();
    static final Entry DUMMY = new DummyEntry();
    List data = new ArrayList(10);
    String lastAction = null;

    private AuditTrail() {
    }

    static AuditTrail getInstance() {
        return INSTANCE;
    }

    Entry addEntry(String string, Object object) {
        Entry entry = DUMMY;
        return entry;
    }

    public void print(PrintStream printStream) {
        if (this.data != null) {
            for (int i2 = 0; i2 < this.data.size(); ++i2) {
                printStream.println(this.data.get(i2));
            }
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.append("LastAction: ");
        stringBuffer.append(this.lastAction);
        if (this.data != null) {
            for (int i2 = 0; i2 < this.data.size(); ++i2) {
                stringBuffer.append(this.data.get(i2));
                stringBuffer.append('\n');
            }
        }
        return stringBuffer.toString();
    }

    static class Entry {
        long start = 0L;
        long startProcessingQueued = 0L;
        long finished = 0L;
        String thread;
        String action;
        Object ref;

        Entry() {
        }

        Entry(String string, Object object) {
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
            return "start#" + this.start + "#queue#" + this.startProcessingQueued + "#done#" + this.finished + "#thread#" + this.thread + "#" + this.action + "#" + this.ref;
        }
    }

    static class DummyEntry
    extends Entry {
        DummyEntry() {
        }

        void setStartProcessingQueued() {
        }

        void setFinished() {
        }

        public String toString() {
            return null;
        }
    }
}

