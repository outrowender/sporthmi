/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.comfort.AbstractDoorLockingComponent;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.DoorLockingViewOptions;

public class DoorLockingComponentEvo
extends AbstractDoorLockingComponent {
    public DoorLockingComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    @Override
    protected void updateMenuEntryVisibility(DoorLockingViewOptions doorLockingViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1909978880, this.getMenuEntryVisibilityState(doorLockingViewOptions.getUnlockingMode()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1893201664, this.getMenuEntryVisibilityState(doorLockingViewOptions.getComfortOpen()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1876424448, this.getMenuEntryVisibilityState(doorLockingViewOptions.getAutoLock()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1826092800, this.getMenuEntryVisibilityState(doorLockingViewOptions.getLockingConfirmation()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1859647232, this.getMenuEntryVisibilityState(doorLockingViewOptions.getClBootLock()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1842870016, this.getMenuEntryVisibilityState(doorLockingViewOptions.getMirrorProtection()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-165017344, this.getMenuEntryVisibilityState(doorLockingViewOptions.getKeyless()));
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1909978880, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1893201664, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1876424448, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1826092800, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1859647232, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1842870016, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-165017344, (short)15);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1909978880);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1893201664);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1876424448);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1826092800);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1859647232);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1842870016);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-165017344);
    }

    @Override
    public int getID() {
        return 5;
    }

    @Override
    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }
}

