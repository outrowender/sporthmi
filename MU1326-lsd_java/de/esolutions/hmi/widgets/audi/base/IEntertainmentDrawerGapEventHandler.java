/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

public interface IEntertainmentDrawerGapEventHandler {
    public static final int VALUE_CHANGED_MAX_GAP_WIDTH;
    public static final int VALUE_EVENT_HANDLER_REGISTERED;
    public static final String[] VALUES_TO_STRING;

    default public boolean onGapDataChanged(int n) {
    }

    static {
        VALUES_TO_STRING = new String[]{"VALUE_CHANGED_MAX_GAP_WIDTH", "VALUE_EVENT_HANDLER_REGISTERED"};
    }
}

