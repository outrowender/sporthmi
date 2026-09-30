/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.hmi.event.ModelUpdateEvent;

public interface EventMediator {
    public static final int MEDIATOR_TYPE_CHANGE = 1;
    public static final int MEDIATOR_TYPE_DATA_UPDATE = 2;
    public static final int MEDIATOR_TYPE_FUNCTION_ACCESS = 3;
    public static final int MEDIATOR_TYPE_HISTORY_RESTORE = 4;
    public static final int MEDIATOR_TYPE_INFO_SYNC = 5;
    public static final int MEDIATOR_TYPE_INFO_TIMER = 6;
    public static final int MEDIATOR_TYPE_JUMP_BACK = 7;
    public static final int MEDIATOR_TYPE_WAIT_SCREEN = 8;
    public static final int MEDIATOR_TYPE_WAIT_SYNC = 9;
    public static final int MEDIATOR_TYPE_WAIT_TIMER = 10;
    public static final int MEDIATOR_TYPE_CHANGE_TIMER = 11;
    public static final int MEDIATOR_TYPE_WAIT_SYNC_TIMEOUT = 12;
    public static final int MEDIATOR_TYPE_WAIT_ON_CHANGE = 13;

    public boolean isStarted();

    public void start();

    public void stop();

    public boolean isActive();

    public int activate(boolean var1);

    public int reactivate(boolean var1);

    public void deactivate();

    public boolean locksScreen();

    public void processUpdate(ModelUpdateEvent var1);

    public int getType();

    public void kill();
}

