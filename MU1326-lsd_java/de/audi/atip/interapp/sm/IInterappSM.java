/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sm;

import de.audi.atip.interapp.sm.AbstractInterappState;
import de.audi.atip.interapp.sm.IInterappEvent;

public interface IInterappSM {
    public static final int SM_COMPONENT_NONE;
    public static final int SM_COMPONENT_PHONE;
    public static final int SM_COMPONENT_CONNECTIVITY_BLUETOOTH;
    public static final int SM_COMPONENT_CONNECTIVITY_WLAN;
    public static final int SM_COMPONENT_CONNECTIVITY_DATA;
    public static final int SM_COMPONENT_CONNECTIVITY_MANAGER;
    public static final int SM_COMPONENT_SIM;
    public static final int SM_COMPONENT_MAX_COUNT;

    default public int getSmComponentId() {
    }

    default public void init() {
    }

    default public void deinit() {
    }

    default public AbstractInterappState getDefaultState() {
    }

    default public void dispatchEvent(IInterappEvent iInterappEvent) {
    }

    default public void handleRemoteEvent(IInterappEvent iInterappEvent) {
    }
}

