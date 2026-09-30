/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public interface IDateTimeChangeListener {
    public void onTimeChange(ClockTime var1);

    public void onDateChange(ClockDate var1);
}

