/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public interface IDateTimeChangeListener {
    public void dateChanged(ClockDate var1);

    public void timeChanged(ClockTime var1);
}

