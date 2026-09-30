/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.AbstractInterappState;
import de.audi.atip.interapp.sm.IInterappEvent;

public interface IInterappSM {
    public static final int SM_COMPONENT_NONE = 0;
    public static final int SM_COMPONENT_PHONE = 1;
    public static final int SM_COMPONENT_CONNECTIVITY_BLUETOOTH = 2;
    public static final int SM_COMPONENT_CONNECTIVITY_WLAN = 3;
    public static final int SM_COMPONENT_CONNECTIVITY_DATA = 4;
    public static final int SM_COMPONENT_CONNECTIVITY_MANAGER = 5;
    public static final int SM_COMPONENT_SIM = 6;
    public static final int SM_COMPONENT_MAX_COUNT = 7;

    public int getSmComponentId();

    public void init();

    public void deinit();

    public AbstractInterappState getDefaultState();

    public void dispatchEvent(IInterappEvent var1);

    public void handleRemoteEvent(IInterappEvent var1);
}

