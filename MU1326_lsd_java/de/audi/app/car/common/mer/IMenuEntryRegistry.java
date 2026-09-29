/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.IMERVisibilityChangeListener;
import de.audi.app.car.common.mer.IMenuEntry;

public interface IMenuEntryRegistry {
    default public void init() {
    }

    default public void deinit() {
    }

    default public Object getVehicleStatusDump() {
    }

    default public IMenuEntry registerMenuEntry(int n, short s) {
    }

    default public void deregisterMenuEntry(int n) {
    }

    default public void updateMenuEntryCoding(int n, short s) {
    }

    default public void updateMenuEntryVisibility(int n, int n2) {
    }

    default public void registerVisibilityChangeListener(IMERVisibilityChangeListener iMERVisibilityChangeListener) {
    }

    default public void unregisterVisibilityChangeListener(IMERVisibilityChangeListener iMERVisibilityChangeListener) {
    }

    default public void notifyStateChange(IMenuEntry iMenuEntry) {
    }

    default public void stateUpdateForwardingTerminated() {
    }

    default public boolean updateSlotBinding(int n, int n2) {
    }

    default public void updateStateOfAllPossibleSlotsToInvisible(int n) {
    }

    default public int getCurrentMenuEntryState(int n) {
    }
}

