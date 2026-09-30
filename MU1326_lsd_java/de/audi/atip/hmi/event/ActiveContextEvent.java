/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.view.IDisplayListener;

public class ActiveContextEvent
extends ATIPEvent {
    private int terminal;
    private int activeContext;
    private int sessionID;
    private IDisplayListener displayListener;

    public ActiveContextEvent(ATIPEventListener aTIPEventListener, int n, int n2, int n3, IDisplayListener iDisplayListener) {
        super(aTIPEventListener, 19001);
        this.terminal = n;
        this.activeContext = n2;
        this.sessionID = n3;
        this.displayListener = iDisplayListener;
    }

    public String toString() {
        return "ActiveContextEvent: [" + this.getPosted() + "] terminal: " + this.terminal + " activeContext: " + this.activeContext + " sessionID: " + this.sessionID;
    }

    public int getTerminal() {
        return this.terminal;
    }

    public int getActiveContext() {
        return this.activeContext;
    }

    public int getSessionID() {
        return this.sessionID;
    }

    public IDisplayListener getDisplayListener() {
        return this.displayListener;
    }
}

