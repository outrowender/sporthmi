/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.esolutions.fw.util.commons.Buffer;
import java.io.Serializable;

class SimUsageUserDecision
implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String simCardID;
    private final int nadMode;

    SimUsageUserDecision(String string, int n) {
        this.simCardID = string;
        this.nadMode = n;
    }

    String getSimCardID() {
        return this.simCardID;
    }

    int getNadMode() {
        return this.nadMode;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("SimUsageUserDecision(");
        buffer.append("simCardID=");
        buffer.append(this.simCardID);
        buffer.append(", ");
        buffer.append("nadMode=");
        buffer.append(this.nadMode);
        buffer.append(")");
        return buffer.toString();
    }
}

