/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carhybrid;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderAH;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA0;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA1;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRA2;
import org.dsi.ifc.carhybrid.BatteryControlPowerProviderRAE;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA0;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA1;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA2;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA3;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA4;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA5;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA6;
import org.dsi.ifc.carhybrid.BatteryControlProfileRA7;
import org.dsi.ifc.carhybrid.BatteryControlProfilesAH;
import org.dsi.ifc.carhybrid.BatteryControlProgrammedTimer;
import org.dsi.ifc.carhybrid.BatteryControlWeekdays;

public interface DSICarHybrid
extends DSIBase {
    public static final String VERSION = "2.11.12";
    public static final int RT_SETBATTERYCONTROLIMMEDIATELY = 1000;
    public static final int RT_SETBATTERYCONTROLTIMERSTATE = 1001;
    public static final int RT_SETBATTERYCONTROLTIMER = 1002;
    public static final int RT_SETBATTERYCONTROLSETFACTORYDEFAULT = 1003;
    public static final int RT_REQUESTBATTERYCONTROLPROFILELIST = 1004;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA0 = 1005;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA1 = 1006;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA2 = 1007;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA3 = 1008;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA4 = 1009;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA5 = 1010;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA6 = 1011;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRA7 = 1012;
    public static final int RT_SETBATTERYCONTROLPROFILELISTRAF = 1013;
    public static final int RT_SETBATTERYCONTROLPOWERPROVIDERRA0 = 1014;
    public static final int RT_SETBATTERYCONTROLPOWERPROVIDERRA1 = 1015;
    public static final int RT_SETBATTERYCONTROLPOWERPROVIDERRA2 = 1016;
    public static final int RT_SETBATTERYCONTROLPOWERPROVIDERRAE = 1017;
    public static final int RT_SETBATTERYCONTROLPOWERPROVIDERRAF = 1018;
    public static final int RT_REQUESTBATTERYCONTROLPOWERPROVIDERLIST = 1019;
    public static final int RT_SETHYBRIDTARGETRANGE = 1020;
    public static final int RT_SETHYBRIDENERGYASSISTCONTROL = 1021;
    public static final int RT_SETBATTERYCONTROLPASTERRORREASON = 1022;
    public static final int RT_SETBATTERYCONTROLREMAININGCHARGETIME = 1023;
    public static final int RT_SETHYBRIDACTIVEPEDAL = 1024;
    public static final int RP_ACKNOWLEDGEBATTERYCONTROLSETFACTORYDEFAULT = 2000;
    public static final int RP_ACKNOWLEDGEBATTERYCONTROLIMMEDIATELY = 2001;
    public static final int IN_RESPONSEPROFILELISTRA0 = 3000;
    public static final int IN_RESPONSEPROFILELISTRA1 = 3001;
    public static final int IN_RESPONSEPROFILELISTRA2 = 3002;
    public static final int IN_RESPONSEPROFILELISTRA3 = 3003;
    public static final int IN_RESPONSEPROFILELISTRA4 = 3004;
    public static final int IN_RESPONSEPROFILELISTRA5 = 3005;
    public static final int IN_RESPONSEPROFILELISTRA6 = 3006;
    public static final int IN_RESPONSEPROFILELISTRA7 = 3007;
    public static final int IN_RESPONSEPROFILELISTRAF = 3008;
    public static final int IN_RESPONSEPOWERPROVIDERLISTRA0 = 3009;
    public static final int IN_RESPONSEPOWERPROVIDERLISTRA1 = 3010;
    public static final int IN_RESPONSEPOWERPROVIDERLISTRA2 = 3011;
    public static final int IN_RESPONSEPOWERPROVIDERLISTRAE = 3012;
    public static final int IN_RESPONSEPOWERPROVIDERLISTRAF = 3013;
    public static final int ATTR_HYBRIDVIEWOPTIONS = 1;
    public static final int ATTR_HYBRIDCHARGE = 2;
    public static final int ATTR_HYBRIDENERGYFLOWSTATE = 3;
    public static final int ATTR_HYBRIDRECOVEREDENERGY = 4;
    public static final int ATTR_HYBRIDENERGYFLOW = 5;
    public static final int ATTR_BATTERYCONTROLVIEWOPTIONS = 6;
    public static final int ATTR_BATTERYCONTROLPLUG = 7;
    public static final int ATTR_BATTERYCONTROLCHARGESTATE = 8;
    public static final int ATTR_BATTERYCONTROLCLIMATESTATE = 9;
    public static final int ATTR_BATTERYCONTROLTIMERSTATE = 10;
    public static final int ATTR_BATTERYCONTROLTIMER1 = 11;
    public static final int ATTR_BATTERYCONTROLTIMER2 = 12;
    public static final int ATTR_BATTERYCONTROLTIMER3 = 13;
    public static final int ATTR_BATTERYCONTROLTIMER4 = 14;
    public static final int ATTR_BATTERYCONTROLTOTALNUMBEROFPROFILES = 15;
    public static final int ATTR_BATTERYCONTROLPROFILESLISTUPDATEINFO = 16;
    public static final int ATTR_BATTERYCONTROLTOTALNUMBEROFPOWERPROVIDER = 17;
    public static final int ATTR_BATTERYCONTROLPOWERPROVIDERLISTUPDATEINFO = 18;
    public static final int ATTR_HYBRIDTARGETRANGE = 19;
    public static final int ATTR_HYBRIDENERGYASSISTCONTROL = 20;
    public static final int ATTR_HYBRIDENERGYASSISTSTATE = 21;
    public static final int ATTR_BATTERYCONTROLPASTERRORREASON = 22;
    public static final int ATTR_BATTERYCONTROLPLUGDISPLAYSTATE = 23;
    public static final int ATTR_BATTERYCONTROLREMAININGCHARGETIME = 24;
    public static final int ATTR_BATTERYCONTROLLOWESTMAXCURRENT = 25;
    public static final int ATTR_HYBRIDINHIBITREASON = 26;
    public static final int ATTR_HYBRIDACTIVEPEDAL = 27;
    public static final int MOTIONSTATE_NOTSUPPORTED = 0;
    public static final int MOTIONSTATE_INIT = 1;
    public static final int MOTIONSTATE_STANDSTILL = 2;
    public static final int MOTIONSTATE_FORWARD = 3;
    public static final int MOTIONSTATE_REVERSE = 4;
    public static final int ICESTATE_NOTSUPPORTED = 0;
    public static final int ICESTATE_INIT = 1;
    public static final int ICESTATE_INACTIVE = 2;
    public static final int ICESTATE_GENERATORMODE = 3;
    public static final int ICESTATE_DRIVEMODE = 4;
    public static final int ICESTATE_PASSIVMODE = 5;
    public static final int BATTERYSTATE_NOTSUPPORTED = 0;
    public static final int BATTERYSTATE_INIT = 1;
    public static final int BATTERYSTATE_CHARGING = 2;
    public static final int BATTERYSTATE_INACTIVE = 3;
    public static final int BATTERYSTATE_DISCHARGING = 4;
    public static final int BATTERYSTATE_NOCURRENT = 5;
    public static final int TORQUESTATE_NOTSUPPORTED = 0;
    public static final int TORQUESTATE_INIT = 1;
    public static final int TORQUESTATE_INACTIVENODRIVEREADYNESS = 2;
    public static final int TORQUESTATE_MAXIMUMDRIVETORQUEDEMANDBOOST = 3;
    public static final int TORQUESTATE_POSITIVEDRIVETORQUEDEMAND = 4;
    public static final int TORQUESTATE_NODRIVETORQUEDEMAND = 5;
    public static final int TORQUESTATE_NEGATIVEDRIVETORQUEDEMAND = 6;
    public static final int POWERSUPPLYSTATE_NOTSUPPORTED = 0;
    public static final int POWERSUPPLYSTATE_INIT = 1;
    public static final int POWERSUPPLYSTATE_INACTIVE = 2;
    public static final int POWERSUPPLYSTATE_ICE = 3;
    public static final int POWERSUPPLYSTATE_BATTERYCHARGER = 4;
    public static final int POWERSUPPLYSTATE_HVBATTERY = 5;
    public static final int POWERSUPPLYSTATE_RECUPERATION = 6;
    public static final int POWERSUPPLYSTATE_RECUPERATIONHVBATTERY = 7;
    public static final int POWERSUPPLYSTATE_ICEHVBATTERY = 8;
    public static final int EESTATE_NOTSUPPORTED = 0;
    public static final int EESTATE_INIT = 1;
    public static final int EESTATE_INACTIVE = 2;
    public static final int EESTATE_POSITIVEDRIVETORQUE = 3;
    public static final int EESTATE_NODRIVETORQUE = 4;
    public static final int EESTATE_NEGATIVEDRIVETORQUE = 5;
    public static final int BATTERYCONTROLLOCKSETUP_UNLOCK = 0;
    public static final int BATTERYCONTROLLOCKSETUP_LOCK = 1;
    public static final int BATTERYCONTROLLOCKSETUP_INIT = 15;
    public static final int BATTERYCONTROLLOCKSTATE_AUTOLOCKERROR = 2;
    public static final int BATTERYCONTROLLOCKSTATE_UNLOCKERROR = 3;
    public static final int BATTERYCONTROLLOCKSTATE_INIT = 15;
    public static final int BATTERYCONTROLSUPPLYSTATE_INACTIVE = 0;
    public static final int BATTERYCONTROLSUPPLYSTATE_ACTIVE = 1;
    public static final int BATTERYCONTROLSUPPLYSTATE_CHARGESTATION_CONNECTED = 2;
    public static final int BATTERYCONTROLSUPPLYSTATE_INIT = 15;
    public static final int BATTERYCONTROLPLUGSTATE_NOTPLUGGED = 0;
    public static final int BATTERYCONTROLPLUGSTATE_PLUGGED = 1;
    public static final int BATTERYCONTROLPLUGSTATE_INIT = 15;
    public static final int BATTERYCONTROLCHARGEMODE_OFF = 0;
    public static final int BATTERYCONTROLCHARGEMODE_AC = 1;
    public static final int BATTERYCONTROLCHARGEMODE_DC = 2;
    public static final int BATTERYCONTROLCHARGEMODE_CONDITIONING = 3;
    public static final int BATTERYCONTROLCHARGEMODE_AC_AND_CONDITIONING = 4;
    public static final int BATTERYCONTROLCHARGEMODE_DC_AND_CONDITIONING = 5;
    public static final int BATTERYCONTROLCHARGEMODE_INIT = 15;
    public static final int BATTERYCONTROLCHARGESTATE_INIT = 0;
    public static final int BATTERYCONTROLCHARGESTATE_IDLE = 1;
    public static final int BATTERYCONTROLCHARGESTATE_RUNNING = 2;
    public static final int BATTERYCONTROLCHARGESTATE_CONSERVATION_CHARGING = 3;
    public static final int BATTERYCONTROLCHARGESTATE_ABORTED_TEMPERATURETOOLOW = 6;
    public static final int BATTERYCONTROLCHARGESTATE_ABORTED_GENERALDEVICEERROR = 7;
    public static final int BATTERYCONTROLCHARGESTATE_ABORTED_POWERSUPPLYNOTAVAILABLE = 11;
    public static final int BATTERYCONTROLCHARGESTATE_ABORTED_NOTINPARKINGPOSITION = 12;
    public static final int BATTERYCONTROLCHARGESTATE_COMPLETED = 15;
    public static final int BATTERYCONTROLCHARGESTATE_NO_ERROR = 16;
    public static final int BATTERYCONTROLCHARGESTARTREASON_INIT = 0;
    public static final int BATTERYCONTROLCHARGESTARTREASON_TIMER1 = 1;
    public static final int BATTERYCONTROLCHARGESTARTREASON_TIMER2 = 2;
    public static final int BATTERYCONTROLCHARGESTARTREASON_TIMER3 = 3;
    public static final int BATTERYCONTROLCHARGESTARTREASON_TIMER4 = 4;
    public static final int BATTERYCONTROLCHARGESTARTREASON_IMMEDIATELY = 5;
    public static final int BATTERYCONTROLCHARGESTARTREASON_PUSHBUTTON = 6;
    public static final int BATTERYCONTROLBATTERYCLIMATESTATE_INIT = 0;
    public static final int BATTERYCONTROLBATTERYCLIMATESTATE_OFF = 1;
    public static final int BATTERYCONTROLBATTERYCLIMATESTATE_COOLING = 2;
    public static final int BATTERYCONTROLBATTERYCLIMATESTATE_HEATING = 3;
    public static final int BATTERYCONTROLCLIMATESTATE_INIT = 0;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_CARBODYSHELLOPEN = 1;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_IGNITIONISON = 2;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_PARKHEATER_NOFUEL = 3;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_PARKHEATER_MAX_OPTIME_REACHED = 4;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_NOEXTERNALSUPPLY = 6;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_GENERALDEVICEERROR = 7;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_BATTERYCONDITION = 8;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_BATTERYCHARGING = 9;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_BATTERYLOW = 10;
    public static final int BATTERYCONTROLCLIMATESTATE_IDLE = 11;
    public static final int BATTERYCONTROLCLIMATESTATE_RUNNING = 12;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_NOTINPARKINGPOSITION = 13;
    public static final int BATTERYCONTROLCLIMATESTATE_ABORTED_POWERREDUCTION = 14;
    public static final int BATTERYCONTROLCLIMATESTATE_COMPLETED = 15;
    public static final int BATTERYCONTROLCLIMATESTATE_DEFECTIVE = 16;
    public static final int BATTERYCONTROLCLIMATESTATE_AUXHEATER_DEFECTIVE = 17;
    public static final int BATTERYCONTROLCLIMATESTATE_NO_ERROR = 18;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_INIT = 0;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_ABORTED_IGNITIONISON = 2;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_ABORTED_GENERALDEVICEERROR = 7;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_ABORTED_BATTERYCONDITION = 8;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_ABORTED_BATTERYLOW = 10;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_IDLE = 11;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_RUNNING = 12;
    public static final int BATTERYCONTROLSEATHEATERWINDOWHEATERSTATE_COMPLETED = 15;
    public static final int BATTERYCONTROLTIMER_TIMER_UNKNOWN = 0;
    public static final int BATTERYCONTROLTIMER_TIMER1 = 1;
    public static final int BATTERYCONTROLTIMER_TIMER2 = 2;
    public static final int BATTERYCONTROLTIMER_TIMER3 = 3;
    public static final int BATTERYCONTROLTIMER_TIMER4 = 4;
    public static final int BATTERYCONTROLSCHEDULESTATE_IDLE = 0;
    public static final int BATTERYCONTROLSCHEDULESTATE_CALCULATE = 1;
    public static final int BATTERYCONTROLSCHEDULESTATE_OK = 2;
    public static final int BATTERYCONTROLSCHEDULESTATE_CHARGINGNOTREACHABLE = 3;
    public static final int BATTERYCONTROLSCHEDULESTATE_TIMERINVALID = 4;
    public static final int BATTERYCONTROLARRAYCONTENT_NONE = 0;
    public static final int BATTERYCONTROLARRAYCONTENT_ALL = 1;
    public static final int BATTERYCONTROLARRAYCONTENT_ALL_FORWARD = 2;
    public static final int BATTERYCONTROLARRAYCONTENT_ALL_BACKWARD = 3;
    public static final int BATTERYCONTROLARRAYCONTENT_ONLY_CHANGES = 4;
    public static final int BATTERYCONTROLARRAYCONTENT_ELEMENTS_REMOVED = 5;
    public static final int BATTERYCONTROLARRAYCONTENT_BLOCK_INSERTED = 6;
    public static final int BATTERYCONTROLARRAYCONTENT_BACKWARD = 7;
    public static final int BATTERYCONTROLRECORDCONTENT_RA0 = 0;
    public static final int BATTERYCONTROLRECORDCONTENT_RA1 = 1;
    public static final int BATTERYCONTROLRECORDCONTENT_RA2 = 2;
    public static final int BATTERYCONTROLRECORDCONTENT_RA3 = 3;
    public static final int BATTERYCONTROLRECORDCONTENT_RA4 = 4;
    public static final int BATTERYCONTROLRECORDCONTENT_RA5 = 5;
    public static final int BATTERYCONTROLRECORDCONTENT_RA6 = 6;
    public static final int BATTERYCONTROLRECORDCONTENT_RA7 = 7;
    public static final int BATTERYCONTROLRECORDCONTENT_RAF = 15;
    public static final int PROFILELIST_POS = 15;
    public static final int PROFILELIST_NONE = 16;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENT_RA0 = 0;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENT_RA1 = 1;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENT_RA2 = 2;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENT_RAE = 14;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENT_RAF = 15;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENTLIST_POS = 16;
    public static final int BATTERYCONTROLPROVIDERRECORDCONTENTLIST_NONE = 17;
    public static final int BATTERYCONTROLREMAININGCHARGETIMEMODE_DC = 0;
    public static final int BATTERYCONTROLREMAININGCHARGETIMEMODE_AC_MODE2 = 1;
    public static final int BATTERYCONTROLREMAININGCHARGETIMEMODE_AC_MODE3 = 2;
    public static final int BATTERYCONTROLREMAININGCHARGETIMEMODE_NONE = 15;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATE_OFF = 0;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATE_PERMANENT_ON = 1;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATE_BLINK = 2;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATE_PULSE = 3;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATE_FLASH = 4;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATECOLOR_NONE = 0;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATECOLOR_GREEN = 1;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATECOLOR_YELLOW = 2;
    public static final int BATTERYCONTROLPLUGDISPLAYSTATECOLOR_RED = 3;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_NONE = 0;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_ONBOARD_CHARGE_DEVICE = 1;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_CABLE = 2;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_CHARGING_STATION = 3;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_AC_HEADUNIT = 4;
    public static final int BATTERYCONTROLLOWESTMAXCURRENTSOURCE_INIT = 255;
    public static final int BATTERYCONTROLPASTERRORREASONRESET_NOERROR = 0;
    public static final int BATTERYCONTROLPASTERRORREASONRESET_ERROR = 1;
    public static final int BATTERYCONTROLCHARGESTATETARGETSOC_MINSOC = 0;
    public static final int BATTERYCONTROLCHARGESTATETARGETSOC_MAXSOC = 1;
    public static final int BATTERYCONTROLCHARGESTATETARGETSOC_INIT = 15;
    public static final int ENERGYASSISTSTATE_NOTACTIVE = 0;
    public static final int ENERGYASSISTSTATE_ACTIVE = 1;
    public static final int ENERGYASSISTSTATE_CALCULATION_ACTIVE = 2;
    public static final int ENERGYASSISTSTATE_ROUTEGUIDANCE_NOTACTIVE = 3;
    public static final int ENERGYASSISTSTATE_TEMP_NOTAVAILABLE = 4;
    public static final int ENERGYASSISTSTATE_DEFECTIVE = 5;

    public void setBatteryControlImmediately(int var1, int var2);

    public void setBatteryControlTimerState(BatteryControlProgrammedTimer var1);

    public void setBatteryControlTimer(int var1, int var2, int var3, int var4, int var5, int var6, BatteryControlWeekdays var7, int var8);

    public void setBatteryControlSetFactoryDefault();

    public void setHybridTargetRange(short var1, int var2);

    public void setHybridEnergyAssistControl(boolean var1);

    public void requestBatteryControlProfileList(BatteryControlProfilesAH var1);

    public void setBatteryControlProfileListRA0(BatteryControlProfilesAH var1, BatteryControlProfileRA0[] var2);

    public void setBatteryControlProfileListRA1(BatteryControlProfilesAH var1, BatteryControlProfileRA1[] var2);

    public void setBatteryControlProfileListRA2(BatteryControlProfilesAH var1, BatteryControlProfileRA2[] var2);

    public void setBatteryControlProfileListRA3(BatteryControlProfilesAH var1, BatteryControlProfileRA3[] var2);

    public void setBatteryControlProfileListRA4(BatteryControlProfilesAH var1, BatteryControlProfileRA4[] var2);

    public void setBatteryControlProfileListRA5(BatteryControlProfilesAH var1, BatteryControlProfileRA5[] var2);

    public void setBatteryControlProfileListRA6(BatteryControlProfilesAH var1, BatteryControlProfileRA6[] var2);

    public void setBatteryControlProfileListRA7(BatteryControlProfilesAH var1, BatteryControlProfileRA7[] var2);

    public void setBatteryControlProfileListRAF(BatteryControlProfilesAH var1, int[] var2);

    public void setBatteryControlPowerProviderRA0(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRA0[] var2);

    public void setBatteryControlPowerProviderRA1(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRA1[] var2);

    public void setBatteryControlPowerProviderRA2(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRA2[] var2);

    public void setBatteryControlPowerProviderRAE(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRAE[] var2);

    public void setBatteryControlPowerProviderRAF(BatteryControlPowerProviderAH var1, int[] var2);

    public void requestBatteryControlPowerProviderList(BatteryControlPowerProviderAH var1);

    public void setBatteryControlPastErrorReason(int var1);

    public void setBatteryControlRemainingChargeTime(int var1, short var2, int var3, short var4);

    public void setHybridActivePedal(boolean var1);
}

