/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.hmi.event.ModelUpdateEvent;

public interface EventMediator {
    public static final int MEDIATOR_TYPE_CHANGE;
    public static final int MEDIATOR_TYPE_DATA_UPDATE;
    public static final int MEDIATOR_TYPE_FUNCTION_ACCESS;
    public static final int MEDIATOR_TYPE_HISTORY_RESTORE;
    public static final int MEDIATOR_TYPE_INFO_SYNC;
    public static final int MEDIATOR_TYPE_INFO_TIMER;
    public static final int MEDIATOR_TYPE_JUMP_BACK;
    public static final int MEDIATOR_TYPE_WAIT_SCREEN;
    public static final int MEDIATOR_TYPE_WAIT_SYNC;
    public static final int MEDIATOR_TYPE_WAIT_TIMER;
    public static final int MEDIATOR_TYPE_CHANGE_TIMER;
    public static final int MEDIATOR_TYPE_WAIT_SYNC_TIMEOUT;
    public static final int MEDIATOR_TYPE_WAIT_ON_CHANGE;

    default public boolean isStarted() {
    }

    default public void start() {
    }

    default public void stop() {
    }

    default public boolean isActive() {
    }

    default public int activate(boolean bl) {
    }

    default public int reactivate(boolean bl) {
    }

    default public void deactivate() {
    }

    default public boolean locksScreen() {
    }

    default public void processUpdate(ModelUpdateEvent modelUpdateEvent) {
    }

    default public int getType() {
    }

    default public void kill() {
    }
}

