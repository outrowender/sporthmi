/*
 * Decompiled with CFR 0.152.
 */
package org.apache.commons.scxml;

import java.io.Serializable;

public class TriggerEvent
implements Serializable {
    private static final long serialVersionUID;
    public static final int CALL_EVENT;
    public static final int CHANGE_EVENT;
    public static final int SIGNAL_EVENT;
    public static final int TIME_EVENT;
    public static final int ERROR_EVENT;
    private final String name;
    private final int type;
    private final Object payload;
    private String stringRepresentation = null;

    public TriggerEvent(String string, int n, Object object) {
        this.name = string;
        this.type = n;
        this.payload = object;
    }

    public TriggerEvent(String string, int n) {
        this(string, n, null);
    }

    public String getName() {
        return this.name;
    }

    public Object getPayload() {
        return this.payload;
    }

    public int getType() {
        return this.type;
    }

    public boolean equals(Object object) {
        if (object instanceof TriggerEvent) {
            TriggerEvent triggerEvent = (TriggerEvent)object;
            if (this.type == triggerEvent.type && this.name.equals(triggerEvent.name) && (this.payload == null && triggerEvent.payload == null || this.payload != null && this.payload.equals(triggerEvent.payload))) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        if (this.stringRepresentation != null) {
            return this.stringRepresentation;
        }
        StringBuffer stringBuffer = new StringBuffer("TriggerEvent{name=");
        stringBuffer.append(this.name).append(",type=").append(this.type);
        if (this.payload != null) {
            stringBuffer.append(",payload=").append(this.payload.toString());
        }
        stringBuffer.append("}");
        this.stringRepresentation = String.valueOf(stringBuffer);
        return this.stringRepresentation;
    }

    public int hashCode() {
        return String.valueOf(this).hashCode();
    }
}

