/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public interface IDateTimeChangeListener {
    default public void onTimeChange(ClockTime clockTime) {
    }

    default public void onDateChange(ClockDate clockDate) {
    }
}

