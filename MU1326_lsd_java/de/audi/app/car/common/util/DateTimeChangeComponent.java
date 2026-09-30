/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

import de.audi.app.car.common.adapter.AbstractDSICarTimeUnitsLanguageAdapter;
import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.CarDSIAttributesSet;
import de.audi.app.car.common.util.IDateTimeChangeListener;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public class DateTimeChangeComponent
extends AbstractDSICarTimeUnitsLanguageAdapter {
    private final IDateTimeChangeListener listener;

    public DateTimeChangeComponent(ICarApplication iCarApplication, String string, IDateTimeChangeListener iDateTimeChangeListener) {
        super(iCarApplication, string);
        this.listener = iDateTimeChangeListener;
    }

    public void updateClockDate(ClockDate clockDate, int n) {
        if (n == 1) {
            this.listener.dateChanged(clockDate);
        }
    }

    public void updateClockTime(ClockTime clockTime, int n) {
        if (n == 1) {
            this.listener.timeChanged(clockTime);
        }
    }

    public String getName() {
        return "DateTimeChangeComponent";
    }

    protected void initModels() {
    }

    protected void deinitModels() {
    }

    protected void initVisibility() {
    }

    protected void deinitVisibility() {
    }

    public CarDSIAttributesSet[] getDSIAttributesSets() {
        return new CarDSIAttributesSet[]{new CarDSIAttributesSet(0, new int[0], new int[]{3, 2})};
    }

    public int getID() {
        return 0;
    }
}

