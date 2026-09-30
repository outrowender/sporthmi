/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface IEntertainmentDrawerGapEventHandler {
    public static final int VALUE_CHANGED_MAX_GAP_WIDTH = 0;
    public static final int VALUE_EVENT_HANDLER_REGISTERED = 1;
    public static final String[] VALUES_TO_STRING = new String[]{"VALUE_CHANGED_MAX_GAP_WIDTH", "VALUE_EVENT_HANDLER_REGISTERED"};

    public boolean onGapDataChanged(int var1);
}

