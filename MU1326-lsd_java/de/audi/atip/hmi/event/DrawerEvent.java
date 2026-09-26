/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class DrawerEvent
extends ATIPEvent {
    public static final int CLOSE_SELECTION_DRAWER;
    public static final int CLOSE_OPTION_DRAWER;
    public static final int CLOSE_ENTERTAINMENT_DRAWER;
    public static final int CLOSE_ALL_DRAWERS;
    public static final int OPEN_SELECTION_DRAWER;
    public static final int OPEN_OPTION_DRAWER;
    public static final int OPEN_ENTERTAINMENT_DRAWER;
    private final int action;

    public DrawerEvent(ATIPEventListener aTIPEventListener, int n) {
        super(aTIPEventListener, n);
        this.action = n;
    }

    public int getAction() {
        return this.action;
    }
}

