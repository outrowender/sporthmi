/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.IInterappEvent;

public interface IInterappConDataEvent
extends IInterappEvent {
    public static final int EVENT_ERROR_CHANGED_MU;
    public static final int EVENT_DENY_ONLINE_CONTEXT;
    public static final int EVENT_ENTER_GUIDE_CONTEXT_CHECK;
    public static final int EVENT_LEAVE_GUIDE_CONTEXT_CHECK;
    public static final int EVENT_DATA_SHOW_UNLOCK_STATEMACHINE;
    public static final int EVENT_DATA_CONNECTION_ACTIVE;
    public static final int EVENT_DATA_CONNECTION_LOST;
}

