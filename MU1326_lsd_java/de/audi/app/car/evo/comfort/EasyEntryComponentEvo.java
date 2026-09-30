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

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(600182, (short)12);
        if (this.isRgsAvailable) {
            this.getApplication().getMenuEntryRegistry().updateSlotBinding(800025, 700063);
        } else {
            this.getApplication().getMenuEntryRegistry().updateSlotBinding(800025, 700071);
        }
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(600182);
    }

    protected void updateMenuEntryVisibility(WiperViewOptions wiperViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(600182, this.getMenuEntryVisibilityState(wiperViewOptions.getEasyEntrySteeringColumn()));
    }

    public int getID() {
        return 34;
    }

    public void updateDoorLockingUserProfileOnOff(DoorLockingUserProfileOnOff doorLockingUserProfileOnOff, int n) {
    }
}

