/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;

public interface IDateTimeChangeListener {
    default public void dateChanged(ClockDate clockDate) {
    }

    default public void timeChanged(ClockTime clockTime) {
    }
}

