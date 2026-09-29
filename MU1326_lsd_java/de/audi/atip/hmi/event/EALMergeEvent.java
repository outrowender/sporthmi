/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class EALMergeEvent
extends ATIPEvent {
    private String nodeName;

    public String getNodeName() {
        return this.nodeName;
    }

    public EALMergeEvent(ATIPEventListener aTIPEventListener, String string) {
        super(aTIPEventListener, 19001);
        this.setNodename(string);
    }

    public void setNodename(String string) {
        this.nodeName = string;
    }

    public String toString() {
        return new StringBuffer().append("EALMergeEvent: nodeName = ").append(this.nodeName).toString();
    }
}

