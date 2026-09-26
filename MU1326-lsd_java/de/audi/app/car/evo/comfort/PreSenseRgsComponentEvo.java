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

    @Override
    protected void updateMenuEntryVisibility(RGSViewOptions rGSViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateSlotBinding(422906880, -1615984128);
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(724044032, this.getMenuEntryVisibilityState(rGSViewOptions.getPreSenseSystem()));
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1473771264, this.getMenuEntryVisibilityState(rGSViewOptions.getPreSenseWarning()));
        if (super.isLeftHandDriveCar()) {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1574303488, this.getMenuEntryVisibilityState(rGSViewOptions.getBeltPretensionerFrontDataLeft()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1557526272, this.getMenuEntryVisibilityState(rGSViewOptions.getBeltPretensionerFrontDataRight()));
        } else {
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1574303488, this.getMenuEntryVisibilityState(rGSViewOptions.getBeltPretensionerFrontDataRight()));
            this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(-1557526272, this.getMenuEntryVisibilityState(rGSViewOptions.getBeltPretensionerFrontDataLeft()));
        }
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(724044032, (short)28);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1473771264, (short)28);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1574303488, (short)28);
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(-1557526272, (short)28);
        this.getApplication().getMenuEntryRegistry().updateSlotBinding(422906880, -1615984128);
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(724044032);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1473771264);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1574303488);
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(-1557526272);
    }

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }
}

