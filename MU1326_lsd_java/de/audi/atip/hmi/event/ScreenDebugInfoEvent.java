/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class ScreenDebugInfoEvent
extends ATIPEvent {
    private String[] debugInfo;
    private int infoType;
    private static final int EVENT_ID = 19001;

    public ScreenDebugInfoEvent(ATIPEventListener aTIPEventListener, String[] stringArray, int n) {
        super(aTIPEventListener, 19001);
        this.debugInfo = stringArray;
        this.infoType = n;
    }

    public String[] getDebugInfo() {
        return this.debugInfo;
    }

    public int getInfoType() {
        return this.infoType;
    }

    public void setDebugInfo(String[] stringArray) {
        this.debugInfo = stringArray;
    }

    public void setInfoType(int n) {
        this.infoType = n;
    }
}

