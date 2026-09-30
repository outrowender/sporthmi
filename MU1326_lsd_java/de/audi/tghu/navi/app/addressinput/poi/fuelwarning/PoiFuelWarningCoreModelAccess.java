/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

import de.audi.tghu.navi.app.NavigationEnv;

public abstract class PoiFuelWarningCoreModelAccess {
    protected final int PETROL_STATION_SUFFIX_CHOICE;
    protected final int FUEL_TYPE_CHOICE;
    protected final int FUEL_WARNING_RECOMMENDATION_CHOICE;
    protected final NavigationEnv env;

    public PoiFuelWarningCoreModelAccess(NavigationEnv navigationEnv) {
        this.PETROL_STATION_SUFFIX_CHOICE = 400639;
        this.FUEL_TYPE_CHOICE = 401031;
        this.FUEL_WARNING_RECOMMENDATION_CHOICE = 400370;
        this.env = navigationEnv;
    }
}

