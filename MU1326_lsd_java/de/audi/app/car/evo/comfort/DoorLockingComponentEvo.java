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

    protected void updateMenuEntryVisibility(DoorLockingViewOptions doorLockingViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600206, this.getMenuEntryVisibilityState(doorLockingViewOptions.getUnlockingMode()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600207, this.getMenuEntryVisibilityState(doorLockingViewOptions.getComfortOpen()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600208, this.getMenuEntryVisibilityState(doorLockingViewOptions.getAutoLock()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600211, this.getMenuEntryVisibilityState(doorLockingViewOptions.getLockingConfirmation()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600209, this.getMenuEntryVisibilityState(doorLockingViewOptions.getClBootLock()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600210, this.getMenuEntryVisibilityState(doorLockingViewOptions.getMirrorProtection()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600822, this.getMenuEntryVisibilityState(doorLockingViewOptions.getKeyless()));
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600206, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600207, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600208, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600211, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600209, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600210, (short)15);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600822, (short)15);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600206);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600207);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600208);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600211);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600209);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600210);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600822);
    }

    public int getID() {
        return 5;
    }

    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }
}

