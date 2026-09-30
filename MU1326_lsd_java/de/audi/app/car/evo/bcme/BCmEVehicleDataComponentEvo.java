/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.bcme;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.bcme.AbstractBCmEVehicleDataComponent;
import org.dsi.ifc.carvehiclestates.DynamicVehicleInfoMidFrequentViewOptions;

public class BCmEVehicleDataComponentEvo
extends AbstractBCmEVehicleDataComponent {
    public BCmEVehicleDataComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(DynamicVehicleInfoMidFrequentViewOptions dynamicVehicleInfoMidFrequentViewOptions) {
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    public int getID() {
        return 27;
    }
}

