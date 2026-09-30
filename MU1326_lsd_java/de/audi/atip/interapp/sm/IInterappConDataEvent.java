/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.IInterappEvent;

public interface IInterappConDataEvent
extends IInterappEvent {
    public static final int EVENT_ERROR_CHANGED_MU = 8;
    public static final int EVENT_DENY_ONLINE_CONTEXT = 16;
    public static final int EVENT_ENTER_GUIDE_CONTEXT_CHECK = 23;
    public static final int EVENT_LEAVE_GUIDE_CONTEXT_CHECK = 24;
    public static final int EVENT_DATA_SHOW_UNLOCK_STATEMACHINE = 100;
    public static final int EVENT_DATA_CONNECTION_ACTIVE = 101;
    public static final int EVENT_DATA_CONNECTION_LOST = 102;
}

