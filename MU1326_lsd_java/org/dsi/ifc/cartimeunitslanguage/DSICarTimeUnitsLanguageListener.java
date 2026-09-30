/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public interface DSICarTimeUnitsLanguageListener
extends DSIListener {
    public void updateUnitmasterViewOptions(UnitmasterViewOptions var1, int var2);

    public void updateMenuLanguage(int var1, int var2);

    public void updateTemperatureUnit(int var1, int var2);

    public void updateDistanceUnit(int var1, int var2);

    public void updateSpeedUnit(int var1, int var2);

    public void updatePressureUnit(int var1, int var2);

    public void updateVolumeUnit(int var1, int var2);

    public void updateConsumptionPetrolUnit(int var1, int var2);

    public void updateConsumptionGasUnit(int var1, int var2);

    public void updateConsumptionElectricUnit(int var1, int var2);

    public void updateClockFormat(int var1, int var2);

    public void updateDateFormat(int var1, int var2);

    public void updateClockViewOptions(ClockViewOptions var1, int var2);

    public void updateClockDate(ClockDate var1, int var2);

    public void updateClockTime(ClockTime var1, int var2);

    public void updateClockSource(int var1, int var2);

    public void updateClockDayLightSaving(boolean var1, int var2);

    public void updateClockDayLightSavingData(ClockDayLightSavingData var1, int var2);

    public void updateClockTimeZoneOffset(float var1, int var2);

    public void updateClockTimeSourcesAvailable(ClockSources var1, int var2);

    public void updateClockGPSSyncData(ClockGPSSyncData var1, int var2);

    public void acknowledgeUmSetFactoryDefault(boolean var1);

    public void updateUTCOffset(UTCOffset var1, int var2);

    public void updateSkin(int var1, int var2);

    public void updateWeightUnit(int var1, int var2);
}

