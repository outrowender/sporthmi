/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.comfort;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.comfort.AbstractEasyEntryComponent;
import org.dsi.ifc.carcomfort.DoorLockingUserProfileOnOff;
import org.dsi.ifc.carcomfort.WiperViewOptions;

public class EasyEntryComponentEvo
extends AbstractEasyEntryComponent {
    private final boolean isRgsAvailable;

    public EasyEntryComponentEvo(ICarApplication iCarApplication, boolean bl) {
        super(iCarApplication);
        this.isRgsAvailable = bl;
    }

    @Override
    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(1982335232, (short)12);
        if (this.isRgsAvailable) {
            this.getApplication().getMenuEntryRegistry().updateSlotBinding(422906880, -1615984128);
        } else {
            this.getApplication().getMenuEntryRegistry().updateSlotBinding(422906880, -1481766400);
        }
    }

    @Override
    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(1982335232);
    }

    @Override
    protected void updateMenuEntryVisibility(WiperViewOptions wiperViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(1982335232, this.getMenuEntryVisibilityState(wiperViewOptions.getEasyEntrySteeringColumn()));
    }

    @Override
    public int getID() {
        return 34;
    }

    @Override
    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }
}

