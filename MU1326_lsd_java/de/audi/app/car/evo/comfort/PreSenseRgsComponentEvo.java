/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.comfort.AbstractPreSenseRgsComponent;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.RGSViewOptions;

public class PreSenseRgsComponentEvo
extends AbstractPreSenseRgsComponent {
    public PreSenseRgsComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(RGSViewOptions rGSViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateSlotBinding(800025, 700063);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600107, this.getMenuEntryVisibilityState(rGSViewOptions.getPreSenseSystem()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600232, this.getMenuEntryVisibilityState(rGSViewOptions.getPreSenseWarning()));
        if (super.isLeftHandDriveCar()) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600738, this.getMenuEntryVisibilityState(rGSViewOptions.getBeltPretensionerFrontDataLeft()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600739, this.getMenuEntryVisibilityState(rGSViewOptions.getBeltPretensionerFrontDataRight()));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600738, this.getMenuEntryVisibilityState(rGSViewOptions.getBeltPretensionerFrontDataRight()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600739, this.getMenuEntryVisibilityState(rGSViewOptions.getBeltPretensionerFrontDataLeft()));
        }
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600107, (short)28);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600232, (short)28);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600738, (short)28);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600739, (short)28);
        this.getApplication().getMenuEntryRegistry().updateSlotBinding(800025, 700063);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600107);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600232);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600738);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600739);
    }

    public int getID() {
        return 3;
    }

    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }
}

