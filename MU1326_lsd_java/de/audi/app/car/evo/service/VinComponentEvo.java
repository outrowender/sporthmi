/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.evo.service;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.core.service.AbstractVINComponent;
import de.audi.app.car.evo.service.VehicleStatesHelper;
import org.dsi.ifc.global.CarViewOption;

public class VinComponentEvo
extends AbstractVINComponent {
    public VinComponentEvo(ICarApplication iCarApplication) {
        super(iCarApplication);
    }

    protected void updateMenuEntryVisibility(CarViewOption carViewOption) {
        VehicleStatesHelper.updateVinAndKeyDataVisibilityFromVin(carViewOption, this.getMenuEntryVisibilityState(carViewOption), this.getApplication());
    }

    protected void initVisibility() {
        this.getApplication().getMenuEntryRegistry().registerMenuEntry(182, (short)19);
    }

    protected void deinitVisibility() {
        this.getApplication().getMenuEntryRegistry().deregisterMenuEntry(182);
    }

    public int getID() {
        return 7;
    }
}

