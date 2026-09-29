/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.esolutions.fw.util.commons.Buffer;

public class ProximityEvent
extends ATIPEvent {
    public static final int OFFSET_EVENT_ID;
    public static final int PROXIMITY_EVENT;
    private final long timestamp;
    private final int distance;
    private final int terminalID;

    public ProximityEvent(ATIPEventListener aTIPEventListener, long l, int n, int n2) {
        super(aTIPEventListener, 11001);
        this.timestamp = l;
        this.distance = n;
        this.terminalID = n2;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public int getDistance() {
        return this.distance;
    }

    public int getTerminalID() {
        return this.terminalID;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ProximityEvent:[receiver: ").append(this.getReceiver()).append(", id: ").append(this.getID()).append(", timestamp: ").append(this.timestamp).append(", distance: ").append(this.distance).append(", terminalID: ").append(this.terminalID).append(")]");
        return buffer.toString();
    }
}

