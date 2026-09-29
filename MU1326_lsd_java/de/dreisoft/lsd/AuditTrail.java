/*
 * Decompiled with CFR 0.152.
 */
package de.dreisoft.lsd;

import de.dreisoft.lsd.AuditTrail$DummyEntry;
import de.dreisoft.lsd.AuditTrail$Entry;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class AuditTrail {
    static final AuditTrail INSTANCE = new AuditTrail();
    static final AuditTrail$Entry DUMMY = new AuditTrail$DummyEntry();
    List data = new ArrayList(10);
    String lastAction = null;

    private AuditTrail() {
    }

    static AuditTrail getInstance() {
        return INSTANCE;
    }

    AuditTrail$Entry addEntry(String string, Object object) {
        AuditTrail$Entry entry = DUMMY;
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
}

