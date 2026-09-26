/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.model.AdditionalScreenData;
import de.esolutions.fw.util.commons.Buffer;

public class StateMachineEvent
extends ATIPEvent {
    public static final int STATEMACHINE_FIRST;
    public static final int TRIGGER_STATEMACHINE;
    public static final int STATEMACHINE_LAST;
    private int smID = -1;
    private int smEventID = -1;
    private final AdditionalScreenData metaData;

    public StateMachineEvent(ATIPEventListener aTIPEventListener, int n, int n2, int n3) {
        this(aTIPEventListener, n, n2, n3, null);
    }

    public StateMachineEvent(ATIPEventListener aTIPEventListener, int n, int n2, int n3, AdditionalScreenData additionalScreenData) {
        super(aTIPEventListener, n);
        this.smID = n2;
        this.smEventID = n3;
        this.metaData = additionalScreenData;
    }

    public int getStateMachineID() {
        return this.smID;
    }

    public int getSMEventID() {
        return this.smEventID;
    }

    public AdditionalScreenData getMetaData() {
        return this.metaData;
    }

    public String toString() {
        return new Buffer().append("StateMachineEvent: StateMachineID = ").append(this.smID).append(" SMEventID = ").append(this.smEventID).toString();
    }
}

