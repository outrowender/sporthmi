/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class DrawerEvent
extends ATIPEvent {
    public static final int CLOSE_SELECTION_DRAWER = 1;
    public static final int CLOSE_OPTION_DRAWER = 2;
    public static final int CLOSE_ENTERTAINMENT_DRAWER = 4;
    public static final int CLOSE_ALL_DRAWERS = 7;
    public static final int OPEN_SELECTION_DRAWER = 8;
    public static final int OPEN_OPTION_DRAWER = 16;
    public static final int OPEN_ENTERTAINMENT_DRAWER = 32;
    private final int action;

    public DrawerEvent(ATIPEventListener aTIPEventListener, int n) {
        super(aTIPEventListener, n);
        this.action = n;
    }

    public int getAction() {
        return this.action;
    }
}

