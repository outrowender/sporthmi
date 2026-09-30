/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.kombi;

import de.audi.app.car.common.adapter.AbstractDSICarKombiAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.core.kombi.CarSDSServiceHandler;
import org.dsi.ifc.carkombi.BCViewOptions;
import org.dsi.ifc.global.CarBCCurrentRange;

public abstract class AbstractSDSComponent
extends AbstractDSICarKombiAdapter {
    private static final String LOGCHANNEL_NAME = "App.Car.SDS";
    private volatile BCViewOptions currentViewOptions;
    private final CarSDSServiceHandler serviceHandler;

    public AbstractSDSComponent(ICarApplication iCarApplication) {
        super(iCarApplication, LOGCHANNEL_NAME);
        this.serviceHandler = new CarSDSServiceHandler(iCarApplication, this.getLogChannel());
    }

    public void init() {
        super.init();
        this.serviceHandler.init();
    }

    public void deinit() {
        this.serviceHandler.deinit();
        super.deinit();
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{4}, new int[]{8})};
    }

    public String getCurrentViewOptions() {
        if (this.currentViewOptions == null) {
            return "no view options received yet";
        }
        return this.currentViewOptions.toString();
    }

    public String getName() {
        return "SDS InterApp";
    }

    public void updateBCViewOptions(BCViewOptions bCViewOptions, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCViewOptions: '%1', valid='%2'", (Object)(bCViewOptions != null ? this.formatViewOptionsLog(bCViewOptions.toString()) : "null"), (long)n);
        }
        if (n == 1 && bCViewOptions != null) {
            this.currentViewOptions = bCViewOptions;
            this.serviceHandler.updateRemainingRangeViewOption(this.getMenuEntryVisibilityState(this.currentViewOptions.getCurrentRange1()));
            this.primaryAttributeFirstSetReceived();
        }
    }

    public void updateBCCurrentRange1(CarBCCurrentRange carBCCurrentRange, int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1000000, "updateBCCurrentRange(%1), valid='%1'", (Object)(carBCCurrentRange != null ? carBCCurrentRange.toString() : "null"), (long)n);
        }
        if (n == 1 && carBCCurrentRange != null) {
            this.serviceHandler.updateRemainingRange(carBCCurrentRange.getState() == 1, carBCCurrentRange.getCurrentRangeValue(), carBCCurrentRange.getCurrentRangeUnit() == 0 ? 0 : 1);
        }
    }
}

