/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carauxheatercooler;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;
import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerTimer;

public interface DSICarAuxHeaterCooler
extends DSIBase {
    public static final String VERSION = "2.11.11";
    public static final int ATTR_AUXHEATERCOOLERVIEWOPTIONS = 1;
    public static final int ATTR_AUXHEATERCOOLERSTATE = 3;
    public static final int ATTR_AUXHEATERCOOLERONOFF = 4;
    public static final int ATTR_AUXHEATERCOOLERREMAININGTIME = 5;
    public static final int ATTR_AUXHEATERCOOLERRUNNINGTIME = 6;
    public static final int ATTR_AUXHEATERCOOLERMODE = 7;
    public static final int ATTR_AUXHEATERCOOLERENGINEHEATER = 8;
    public static final int ATTR_AUXHEATERCOOLERACTIVETIMER = 9;
    public static final int ATTR_AUXHEATERCOOLERTIMER1 = 10;
    public static final int ATTR_AUXHEATERCOOLERTIMER2 = 11;
    public static final int ATTR_AUXHEATERCOOLERTIMER3 = 12;
    public static final int ATTR_AUXHEATERCOOLERDEFAULTSTARTMODE = 13;
    public static final int ATTR_AUXHEATERCOOLERERRORREASON = 14;
    public static final int ATTR_AUXHEATERCOOLERCURRENTHEATERSTATE = 15;
    public static final int ATTR_AUXHEATERCOOLERPOPUP = 16;
    public static final int ATTR_AUXHEATERCOOLERMODE2 = 17;
    public static final int ATTR_AUXHEATERCOOLEREXTENDEDCONDITIONING = 18;
    public static final int ATTR_AUXHEATERCOOLERWINDOWHEATING = 19;
    public static final int ATTR_AUXHEATERCOOLERUNLOCKCLIMATING = 20;
    public static final int ATTR_AUXHEATERCOOLERTARGETTEMPERATURE = 21;
    public static final int ATTR_AUXHEATERCOOLERAIRQUALITY = 22;
    public static final int TIMERMODE_STARTTIMER = 0;
    public static final int TIMERMODE_GOALTIMER = 1;
    public static final int AUXHEATERCOOLERSTATE_OFF = 0;
    public static final int AUXHEATERCOOLERSTATE_HEATING = 1;
    public static final int AUXHEATERCOOLERSTATE_VENTILATION = 2;
    public static final int AUXHEATERCOOLERHEATERSTATE_OK = 0;
    public static final int AUXHEATERCOOLERHEATERSTATE_FUELLOW = 1;
    public static final int AUXHEATERCOOLERHEATERSTATE_BATTERYLOW = 2;
    public static final int AUXHEATERCOOLERHEATERSTATE_FUELLOWBATTERYLOW = 3;
    public static final int AUXHEATERCOOLERHEATERSTATE_HEATERDEFECT = 4;
    public static final int AUXHEATERCOOLERACTIVETIMER_NONE = 0;
    public static final int AUXHEATERCOOLERACTIVETIMER_TIMER1 = 1;
    public static final int AUXHEATERCOOLERACTIVETIMER_TIMER2 = 2;
    public static final int AUXHEATERCOOLERACTIVETIMER_TIMER3 = 3;
    public static final int AUXHEATERCOOLERDEFAULTSTARTMODE_VENTILATION = 1;
    public static final int AUXHEATERCOOLERDEFAULTSTARTMODE_HEATING = 2;
    public static final int AUXHEATERCOOLERDATEMODE_ABSOLUTEDATE = 0;
    public static final int AUXHEATERCOOLERDATEMODE_RELATIVEDATE = 1;
    public static final int AUXHEATERCOOLERDATEMODE_WEEKDATE = 2;
    public static final int AUXHEATERCOOLERDATEMODE_NEXTOCCURENCE = 3;
    public static final int AUXHEATERCOOLERMODE_ECONOMY = 0;
    public static final int AUXHEATERCOOLERMODE_NORMAL = 1;
    public static final int AUXHEATERCOOLERMODE_COMFORT = 2;
    public static final int AUXHEATERCOOLERREASON_NOREASON = 0;
    public static final int AUXHEATERCOOLERREASON_IMMEDIATESTARTUP = 1;
    public static final int AUXHEATERCOOLERREASON_TIMER1 = 2;
    public static final int AUXHEATERCOOLERREASON_TIMER2 = 3;
    public static final int AUXHEATERCOOLERREASON_TIMER3 = 4;
    public static final int AUXHEATERCOOLERPOPUP_NONE = 0;
    public static final int AUXHEATERCOOLERPOPUP_CHANGEAUXHEATERTIMERORSTARTAUXHEATER = 1;
    public static final int AUXHEATERCOOLERUNLOCKCLIMATINGSTATE_OFF = 0;
    public static final int AUXHEATERCOOLERUNLOCKCLIMATINGSTATE_ON = 1;
    public static final int RT_SETAUXHEATERCOOLERONOFF = 1000;
    public static final int RT_SETAUXHEATERCOOLERRUNNINGTIME = 1001;
    public static final int RT_SETAUXHEATERCOOLERMODE = 1002;
    public static final int RT_SETAUXHEATERCOOLERENGINEHEATER = 1003;
    public static final int RT_SETAUXHEATERCOOLERACTIVETIMER = 1004;
    public static final int RT_SETAUXHEATERCOOLERTIMER1 = 1005;
    public static final int RT_SETAUXHEATERCOOLERTIMER2 = 1006;
    public static final int RT_SETAUXHEATERCOOLERTIMER3 = 1007;
    public static final int RT_SETAUXHEATERSETFACTORYDEFAULT = 1008;
    public static final int RT_SETAUXHEATERCOOLERDEFAULTSTARTMODE = 1009;
    public static final int RT_SETAUXHEATERCOOLEREXTENDEDCONDITIONING = 1011;
    public static final int RT_SETAUXHEATERCOOLERWINDOWHEATING = 1012;
    public static final int RT_SETAUXHEATERCOOLERUNLOCKCLIMATING = 1013;
    public static final int RT_SETAUXHEATERCOOLERTARGETTEMPERATURE = 1014;
    public static final int RT_SETAUXHEATERCOOLERAIRQUALITY = 1015;
    public static final int RT_SETAUXHEATERCOOLERPOPUP = 1010;
    public static final int RP_ACKNOWLEDGEAUXHEATERSETFACTORYDEFAULT = 2000;

    public void setAuxHeaterCoolerOnOff(boolean var1);

    public void setAuxHeaterCoolerRunningTime(short var1);

    public void setAuxHeaterCoolerMode(int var1);

    public void setAuxHeaterCoolerDefaultStartMode(int var1);

    public void setAuxHeaterCoolerEngineHeater(boolean var1);

    public void setAuxHeaterCoolerActiveTimer(int var1);

    public void setAuxHeaterCoolerTimer1(AuxHeaterCoolerTimer var1);

    public void setAuxHeaterCoolerTimer2(AuxHeaterCoolerTimer var1);

    public void setAuxHeaterCoolerTimer3(AuxHeaterCoolerTimer var1);

    public void setAuxHeaterCoolerPopup(int var1);

    public void setAuxHeaterSetFactoryDefault();

    public void setAuxHeaterCoolerExtendedConditioning(AuxHeaterCoolerExtendedConditioning var1);

    public void setAuxHeaterCoolerWindowHeating(boolean var1);

    public void setAuxHeaterCoolerUnlockClimating(int var1);

    public void setAuxHeaterCoolerTargetTemperature(float var1);

    public void setAuxHeaterCoolerAirQuality(boolean var1);
}

