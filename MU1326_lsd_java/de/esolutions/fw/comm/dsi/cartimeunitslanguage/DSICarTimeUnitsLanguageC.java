/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSummerTimeData;

public interface DSICarTimeUnitsLanguageC {
    public void setMenuLanguage(int var1) throws MethodException;

    public void setPressureUnit(int var1) throws MethodException;

    public void setVolumeUnit(int var1) throws MethodException;

    public void setTemperatureUnit(int var1) throws MethodException;

    public void setDistanceUnit(int var1) throws MethodException;

    public void setSpeedUnit(int var1) throws MethodException;

    public void setConsumptionPetrolUnit(int var1) throws MethodException;

    public void setConsumptionGasUnit(int var1) throws MethodException;

    public void setConsumptionElectricUnit(int var1) throws MethodException;

    public void setClockFormat(int var1) throws MethodException;

    public void setDateFormat(int var1) throws MethodException;

    public void setClockDate(ClockDate var1) throws MethodException;

    public void setClockTime(byte var1, byte var2, byte var3) throws MethodException;

    public void setClockSource(int var1) throws MethodException;

    public void setClockDayLightSaving(boolean var1) throws MethodException;

    public void setClockTimeZoneOffset(float var1) throws MethodException;

    public void setClockGPSSyncData(ClockGPSSyncData var1) throws MethodException;

    public void setClockSummerTimeData(ClockSummerTimeData var1) throws MethodException;

    public void setUmSetFactoryDefault() throws MethodException;

    public void setSkin(int var1) throws MethodException;

    public void setWeightUnit(int var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

