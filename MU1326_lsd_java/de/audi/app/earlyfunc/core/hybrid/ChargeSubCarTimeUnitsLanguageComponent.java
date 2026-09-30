/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.app.car.common.adapter.AbstractDSICarTimeUnitsLanguageAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.earlyfunc.core.hybrid.IDateTimeChangeListener;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;

public class ChargeSubCarTimeUnitsLanguageComponent
extends AbstractDSICarTimeUnitsLanguageAdapter {
    private ClockViewOptions currentViewOptions = null;
    private final IDateTimeChangeListener mainComponent;

    public ChargeSubCarTimeUnitsLanguageComponent(IDateTimeChangeListener iDateTimeChangeListener, ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
        this.mainComponent = iDateTimeChangeListener;
    }

    public void updateClockTime(ClockTime clockTime, int n) {
        if (n == 1) {
            this.mainComponent.onTimeChange(clockTime);
        }
    }

    public void updateClockDate(ClockDate clockDate, int n) {
        if (n == 1) {
            this.mainComponent.onDateChange(clockDate);
        }
    }

    public void updateClockViewOptions(ClockViewOptions clockViewOptions, int n) {
        if (n == 1) {
            this.currentViewOptions = clockViewOptions;
            this.primaryAttributeFirstSetReceived();
        }
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[]{1}, new int[]{3, 2})};
    }

    public int getID() {
        return 1000;
    }

    public String getName() {
        return "ChargeSubCarTimeUnitsLanguageComponent";
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }
}

