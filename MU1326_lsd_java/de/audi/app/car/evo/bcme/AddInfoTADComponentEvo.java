/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.bcme;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.bcme.AbstractAddInfoTADComponent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoHighFrequentViewOptions;

public class AddInfoTADComponentEvo
extends AbstractAddInfoTADComponent {
    public AddInfoTADComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(281, (short)40);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(281);
    }

    protected void updateMenuEntryVisibility(DynamicVehicleInfoHighFrequentViewOptions dynamicVehicleInfoHighFrequentViewOptions) {
        this.getApplication().getMenuEntryRegistry().updateMenuEntryVisibility(281, this.getMenuEntryVisibilityState(dynamicVehicleInfoHighFrequentViewOptions.getWheelAngle()));
    }

    public int getID() {
        return 41;
    }
}

