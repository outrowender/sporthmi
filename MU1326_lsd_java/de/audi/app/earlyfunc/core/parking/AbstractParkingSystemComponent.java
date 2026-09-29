/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.car.common.adapter.AbstractDSICarParkingSystemAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.earlyfunc.core.parking.IParkingFocusPropertyConfig;
import de.audi.app.earlyfunc.core.parking.IParkingSystem;
import de.audi.app.earlyfunc.core.parking.IParkingSystemController;
import org.dsi.ifc.carparkingsystem.DisplayContent;
import org.dsi.ifc.carparkingsystem.ParkingSystemViewOptions;

public abstract class AbstractParkingSystemComponent
extends AbstractDSICarParkingSystemAdapter
implements IParkingSystem {
    protected IParkingSystemController controller;
    protected volatile ParkingSystemViewOptions currentViewOptions;

    public AbstractParkingSystemComponent(ICarApplication iCarApplication, IParkingSystemController iParkingSystemController, String string) {
        super(iCarApplication, string);
        this.controller = iParkingSystemController;
    }

    @Override
    public void requestParkingPopup(DisplayContent displayContent) {
    }

    @Override
    public void acknowledgeParkingPopup(DisplayContent displayContent) {
    }

    @Override
    public void updateParkingSystemViewOptions(ParkingSystemViewOptions parkingSystemViewOptions, int n) {
        if (n == 1) {
            this.currentViewOptions = parkingSystemViewOptions;
        }
    }

    @Override
    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    @Override
    public IParkingFocusPropertyConfig createFocusPropertyDecorator(IParkingFocusPropertyConfig iParkingFocusPropertyConfig) {
        return iParkingFocusPropertyConfig;
    }
}

