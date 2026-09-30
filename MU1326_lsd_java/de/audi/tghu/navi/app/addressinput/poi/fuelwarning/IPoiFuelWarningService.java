/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.fuelwarning;

public interface IPoiFuelWarningService {
    public void resetSettings();

    public boolean isFuelWarningActive();

    public void setFuelWarningActive(boolean var1);

    public void checkPendingEvents();
}

