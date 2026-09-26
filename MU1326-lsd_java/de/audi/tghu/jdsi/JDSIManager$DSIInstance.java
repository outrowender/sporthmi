/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.tghu.jdsi.JDSIManager$PendingDSIStart;
import de.esolutions.fw.util.commons.Buffer;

class JDSIManager$DSIInstance {
    private final String serviceName;
    private final int instanceID;
    private Object service;
    private int state;
    private JDSIManager$PendingDSIStart pendingDSIHandler;
    private int startCounter;

    public JDSIManager$DSIInstance(Object object, String string, int n) {
        this.serviceName = string;
        this.service = object;
        this.instanceID = n;
    }

    public Object getService() {
        return this.service;
    }

    public void setService(Object object) {
        this.service = object;
    }

    public int getInstanceID() {
        return this.instanceID;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int n) {
        this.state = n;
    }

    public JDSIManager$PendingDSIStart getPendingDSIHandler() {
        return this.pendingDSIHandler;
    }

    public void setPendingDSIHandler(JDSIManager$PendingDSIStart jDSIManager$PendingDSIStart) {
        this.pendingDSIHandler = jDSIManager$PendingDSIStart;
        if (jDSIManager$PendingDSIStart != null) {
            this.state = JDSIManager$PendingDSIStart.access$100(jDSIManager$PendingDSIStart);
        }
    }

    public int getStartCounter() {
        return this.startCounter;
    }

    public boolean incrementStartCounter() {
        ++this.startCounter;
        return this.startCounter == 1;
    }

    public boolean decrementStartCounter() {
        if (this.startCounter > 0) {
            --this.startCounter;
            return this.startCounter == 0;
        }
        return false;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("DSIInstance(").append(this.serviceName);
        buffer.append(", ").append(this.instanceID);
        if (this.pendingDSIHandler != null) {
            buffer.append(", ").append(this.pendingDSIHandler);
        }
        buffer.append(")");
        return buffer.toString();
    }
}

