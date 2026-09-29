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

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
    }

    @Override
    public void setMenuLanguage(int n) {
        this.lc.log(-2137614336, "-> setMenuLanguage(%1)", (long)n);
    }

    @Override
    public void setPressureUnit(int n) {
        this.lc.log(-2137614336, "-> setPressureUnit(%1)", (long)n);
    }

    @Override
    public void setVolumeUnit(int n) {
        this.lc.log(-2137614336, "-> setVolumeUnit(%1)", (long)n);
    }

    @Override
    public void setTemperatureUnit(int n) {
        this.lc.log(-2137614336, "-> setTemperatureUnit(%1)", (long)n);
    }

    @Override
    public void setDistanceUnit(int n) {
        this.lc.log(-2137614336, "-> setDistanceUnit(%1)", (long)n);
    }

    @Override
    public void setSpeedUnit(int n) {
        this.lc.log(-2137614336, "-> setSpeedUnit(%1)", (long)n);
    }

    @Override
    public void setConsumptionPetrolUnit(int n) {
        this.lc.log(-2137614336, "-> setConsumptionPetrolUnit(%1)", (long)n);
    }

    @Override
    public void setConsumptionGasUnit(int n) {
        this.lc.log(-2137614336, "-> setConsumptionGasUnit(%1)", (long)n);
    }

    @Override
    public void setConsumptionElectricUnit(int n) {
        this.lc.log(-2137614336, "-> setConsumptionElectricUnit(%1)", (long)n);
    }

    @Override
    public void setClockFormat(int n) {
        this.lc.log(-2137614336, "-> setClockFormat(%1)", (long)n);
    }

    @Override
    public void setDateFormat(int n) {
        this.lc.log(-2137614336, "-> setDateFormat(%1)", (long)n);
    }

    @Override
    public void setClockDate(ClockDate clockDate) {
        this.lc.log(-2137614336, "-> setClockDate(%1)", (Object)clockDate);
    }

    @Override
    public void setClockTime(byte by, byte by2, byte by3) {
        this.lc.log(-2137614336, "-> setClockTime(%1, %2, %3)", (long)by, (long)by2, (long)by3);
    }

    @Override
    public void setClockSource(int n) {
        this.lc.log(-2137614336, "-> setClockSource(%1)", (long)n);
    }

    @Override
    public void setClockDayLightSaving(boolean bl) {
        this.lc.log(-2137614336, "-> setClockDayLightSaving(%1)", bl);
    }

    public void setClockDayLightSavingData(ClockDayLightSavingData clockDayLightSavingData) {
        this.lc.log(-2137614336, "-> setClockDayLightSavingData(%1)", (Object)clockDayLightSavingData);
    }

    @Override
    public void setClockTimeZoneOffset(float f2) {
        this.lc.log(-2137614336, "-> setClockTimeZoneOffset(%1)", (Object)Float.toString(f2));
    }

    @Override
    public void setClockGPSSyncData(ClockGPSSyncData clockGPSSyncData) {
        this.lc.log(-2137614336, "-> setClockGPSSyncData(%1)", (Object)clockGPSSyncData);
    }

    @Override
    public void setUmSetFactoryDefault() {
        this.lc.log(-2137614336, "-> setUmSetFactoryDefault()");
    }

    @Override
    public void setSkin(int n) {
        this.lc.log(-2137614336, "-> setSkin(%1)", (long)n);
    }

    @Override
    public void setClockSummerTimeData(ClockSummerTimeData clockSummerTimeData) {
        this.lc.log(-2137614336, "-> setClockSummerTimeData(%1)", (Object)clockSummerTimeData);
    }

    @Override
    public void setWeightUnit(int n) {
        this.lc.log(-2137614336, "-> setWeightUnit(%1)", (long)n);
    }
}

