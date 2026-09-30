/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.mer;

import de.audi.app.car.common.mer.IMERVisibilityChangeListener;
import de.audi.app.car.common.mer.IMenuEntry;

public interface IMenuEntryRegistry {
    public void init();

    public void deinit();

    public Object getVehicleStatusDump();

    public IMenuEntry registerMenuEntry(int var1, short var2);

    public void deregisterMenuEntry(int var1);

    public void updateMenuEntryCoding(int var1, short var2);

    public void updateMenuEntryVisibility(int var1, int var2);

    public void registerVisibilityChangeListener(IMERVisibilityChangeListener var1);

    public void unregisterVisibilityChangeListener(IMERVisibilityChangeListener var1);

    public void notifyStateChange(IMenuEntry var1);

    public void stateUpdateForwardingTerminated();

    public boolean updateSlotBinding(int var1, int var2);

    public void updateStateOfAllPossibleSlotsToInvisible(int var1);

    public int getCurrentMenuEntryState(int var1);
}

