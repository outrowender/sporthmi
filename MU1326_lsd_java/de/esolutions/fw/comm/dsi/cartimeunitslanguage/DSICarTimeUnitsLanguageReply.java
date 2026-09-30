/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cartimeunitslanguage;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.cartimeunitslanguage.ClockDate;
import org.dsi.ifc.cartimeunitslanguage.ClockDayLightSavingData;
import org.dsi.ifc.cartimeunitslanguage.ClockGPSSyncData;
import org.dsi.ifc.cartimeunitslanguage.ClockSources;
import org.dsi.ifc.cartimeunitslanguage.ClockTime;
import org.dsi.ifc.cartimeunitslanguage.ClockViewOptions;
import org.dsi.ifc.cartimeunitslanguage.UTCOffset;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterViewOptions;

public interface DSICarTimeUnitsLanguageReply {
    public static final String IPL_COMM_UUID = "01263cc4-0929-5a81-a342-f8319d605c3a";
    public static final String IPL_COMM_INTERFACE_KEY = "52c43d02-c9d9-5770-917f-6a23f69a2ac8";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.26";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.26";

    public void updateUnitmasterViewOptions(UnitmasterViewOptions var1, int var2) throws MethodException;

    public void updateMenuLanguage(int var1, int var2) throws MethodException;

    public void updateTemperatureUnit(int var1, int var2) throws MethodException;

    public void updateDistanceUnit(int var1, int var2) throws MethodException;

    public void updateSpeedUnit(int var1, int var2) throws MethodException;

    public void updatePressureUnit(int var1, int var2) throws MethodException;

    public void updateVolumeUnit(int var1, int var2) throws MethodException;

    public void updateConsumptionPetrolUnit(int var1, int var2) throws MethodException;

    public void updateConsumptionGasUnit(int var1, int var2) throws MethodException;

    public void updateConsumptionElectricUnit(int var1, int var2) throws MethodException;

    public void updateClockFormat(int var1, int var2) throws MethodException;

    public void updateDateFormat(int var1, int var2) throws MethodException;

    public void updateClockViewOptions(ClockViewOptions var1, int var2) throws MethodException;

    public void updateClockDate(ClockDate var1, int var2) throws MethodException;

    public void updateClockTime(ClockTime var1, int var2) throws MethodException;

    public void updateClockSource(int var1, int var2) throws MethodException;

    public void updateClockDayLightSaving(boolean var1, int var2) throws MethodException;

    public void updateClockDayLightSavingData(ClockDayLightSavingData var1, int var2) throws MethodException;

    public void updateClockTimeZoneOffset(float var1, int var2) throws MethodException;

    public void updateClockTimeSourcesAvailable(ClockSources var1, int var2) throws MethodException;

    public void updateClockGPSSyncData(ClockGPSSyncData var1, int var2) throws MethodException;

    public void acknowledgeUmSetFactoryDefault(boolean var1) throws MethodException;

    public void updateUTCOffset(UTCOffset var1, int var2) throws MethodException;

    public void updateSkin(int var1, int var2) throws MethodException;

    public void updateWeightUnit(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

