/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.settings.timeunitslang.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;
import org.dsi.ifc.cartimeunitslanguage.DSICarTimeUnitsLanguage;

public final class NullDSICarTimeUnitsLanguage
implements DSICarTimeUnitsLanguage {
    private final LogChannel lc;

    public NullDSICarTimeUnitsLanguage(LogChannel logChannel) {
        this.lc = logChannel;
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void setNotification(int n, DSIListener dSIListener) {
    }

    public void setNotification(DSIListener dSIListener) {
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    public void clearNotification(int n, DSIListener dSIListener) {
    }

    public void clearNotification(DSIListener dSIListener) {
    }

    public void setMenuLanguage(int n) {
        this.lc.log(10000000, "-> setMenuLanguage(%1)", (long)n);
    }

    public void setPressureUnit(int n) {
        this.lc.log(10000000, "-> setPressureUnit(%1)", (long)n);
    }

    public void setVolumeUnit(int n) {
        this.lc.log(10000000, "-> setVolumeUnit(%1)", (long)n);
    }

    public void setTemperatureUnit(int n) {
        this.lc.log(10000000, "-> setTemperatureUnit(%1)", (long)n);
    }

    public void setDistanceUnit(int n) {
        this.lc.log(10000000, "-> setDistanceUnit(%1)", (long)n);
    }

    public void setSpeedUnit(int n) {
        this.lc.log(10000000, "-> setSpeedUnit(%1)", (long)n);
    }

    public void setConsumptionPetrolUnit(int n) {
        this.lc.log(10000000, "-> setConsumptionPetrolUnit(%1)", (long)n);
    }

    public void setConsumptionGasUnit(int n) {
        this.lc.log(10000000, "-> setConsumptionGasUnit(%1)", (long)n);
    }

    public void setConsumptionElectricUnit(int n) {
        this.lc.log(10000000, "-> setConsumptionElectricUnit(%1)", (long)n);
    }

    public void setClockFormat(int n) {
        this.lc.log(10000000, "-> setClockFormat(%1)", (long)n);
    }

    public void setDateFormat(int n) {
        this.lc.log(10000000, "-> setDateFormat(%1)", (long)n);
    }

    public void setClockDate(ClockDate clockDate) {
        this.lc.log(10000000, "-> setClockDate(%1)", (Object)clockDate);
    }

    public void setClockTime(byte by, byte by2, byte by3) {
        this.lc.log(10000000, "-> setClockTime(%1, %2, %3)", (long)by, (long)by2, (long)by3);
    }

    public void setClockSource(int n) {
        this.lc.log(10000000, "-> setClockSource(%1)", (long)n);
    }

    public void setClockDayLightSaving(boolean bl) {
        this.lc.log(10000000, "-> setClockDayLightSaving(%1)", bl);
    }

    public void setClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData) {
        this.lc.log(10000000, "-> setClockDayLightSavingData(%1)", (Object)clockDayLightSavingData);
    }

    public void setClockTimeZoneOffset(float f2) {
        this.lc.log(10000000, "-> setClockTimeZoneOffset(%1)", (Object)Float.toString(f2));
    }

    public void setClockGPSSyncData(ClockGPSSyncData clockGPSSyncData) {
        this.lc.log(10000000, "-> setClockGPSSyncData(%1)", (Object)clockGPSSyncData);
    }

    public void setUmSetFactoryDefault() {
        this.lc.log(10000000, "-> setUmSetFactoryDefault()");
    }

    public void setSkin(int n) {
        this.lc.log(10000000, "-> setSkin(%1)", (long)n);
    }

    public void setClockSummerTimeData(ClockSummerTimeData clockSummerTimeData) {
        this.lc.log(10000000, "-> setClockSummerTimeData(%1)", (Object)clockSummerTimeData);
    }

    public void setWeightUnit(int n) {
        this.lc.log(10000000, "-> setWeightUnit(%1)", (long)n);
    }
}

