/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.BatteryControlClimateState;
import org.dsi.ifc.carhybrid.BatteryControlPlug;
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
import org.dsi.ifc.carhybrid.BatteryControlRemainingChargeTime;
import org.dsi.ifc.carhybrid.BatteryControlTimer;
import org.dsi.ifc.carhybrid.BatteryControlTimerState;
import org.dsi.ifc.carhybrid.BatteryControlViewOptions;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridInhibitReason;
import org.dsi.ifc.carhybrid.HybridTargetRange;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public interface DSICarHybridReply {
    public static final String IPL_COMM_UUID = "023777d7-a4e9-5bf7-aab8-23522ef8034c";
    public static final String IPL_COMM_INTERFACE_KEY = "bd73133f-ab5d-5ae5-bf96-1d21680fa177";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.12";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.12";

    public void updateHybridViewOptions(HybridViewOptions var1, int var2) throws MethodException;

    public void updateHybridCharge(int var1, int var2) throws MethodException;

    public void updateHybridEnergyFlowState(HybridEnergyFlowState var1, int var2) throws MethodException;

    public void updateHybridRecoveredEnergy(int var1, int var2) throws MethodException;

    public void updateHybridEnergyFlow(int var1, int var2) throws MethodException;

    public void updateHybridEnergyAssistControl(boolean var1, int var2) throws MethodException;

    public void updateHybridEnergyAssistState(int var1, int var2) throws MethodException;

    public void updateBatteryControlViewOptions(BatteryControlViewOptions var1, int var2) throws MethodException;

    public void updateBatteryControlPlug(BatteryControlPlug var1, int var2) throws MethodException;

    public void updateBatteryControlChargeState(BatteryControlChargeState var1, int var2) throws MethodException;

    public void updateBatteryControlClimateState(BatteryControlClimateState var1, int var2) throws MethodException;

    public void updateBatteryControlTimerState(BatteryControlTimerState var1, int var2) throws MethodException;

    public void updateBatteryControlTimer1(BatteryControlTimer var1, int var2) throws MethodException;

    public void updateBatteryControlTimer2(BatteryControlTimer var1, int var2) throws MethodException;

    public void updateBatteryControlTimer3(BatteryControlTimer var1, int var2) throws MethodException;

    public void updateBatteryControlTimer4(BatteryControlTimer var1, int var2) throws MethodException;

    public void updateBatteryControlTotalNumberOfProfiles(int var1, int var2) throws MethodException;

    public void updateBatteryControlProfilesListUpdateInfo(BatteryControlProfilesAH var1, int[] var2, int var3) throws MethodException;

    public void updateBatteryControlTotalNumberOfPowerProvider(int var1, int var2) throws MethodException;

    public void updateBatteryControlPowerProviderListUpdateInfo(BatteryControlPowerProviderAH var1, int[] var2, int var3) throws MethodException;

    public void acknowledgeBatteryControlSetFactoryDefault(boolean var1) throws MethodException;

    public void acknowledgeBatteryControlImmediately(boolean var1, int var2) throws MethodException;

    public void responseProfileListRA0(BatteryControlProfilesAH var1, BatteryControlProfileRA0[] var2) throws MethodException;

    public void responseProfileListRA1(BatteryControlProfilesAH var1, BatteryControlProfileRA1[] var2) throws MethodException;

    public void responseProfileListRA2(BatteryControlProfilesAH var1, BatteryControlProfileRA2[] var2) throws MethodException;

    public void responseProfileListRA3(BatteryControlProfilesAH var1, BatteryControlProfileRA3[] var2) throws MethodException;

    public void responseProfileListRA4(BatteryControlProfilesAH var1, BatteryControlProfileRA4[] var2) throws MethodException;

    public void responseProfileListRA5(BatteryControlProfilesAH var1, BatteryControlProfileRA5[] var2) throws MethodException;

    public void responseProfileListRA6(BatteryControlProfilesAH var1, BatteryControlProfileRA6[] var2) throws MethodException;

    public void responseProfileListRA7(BatteryControlProfilesAH var1, BatteryControlProfileRA7[] var2) throws MethodException;

    public void responseProfileListRAF(BatteryControlProfilesAH var1, int[] var2) throws MethodException;

    public void responsePowerProviderListRA0(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRA0[] var2) throws MethodException;

    public void responsePowerProviderListRA1(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRA1[] var2) throws MethodException;

    public void responsePowerProviderListRA2(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRA2[] var2) throws MethodException;

    public void responsePowerProviderListRAE(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRAE[] var2) throws MethodException;

    public void responsePowerProviderListRAF(BatteryControlPowerProviderAH var1, int[] var2) throws MethodException;

    public void updateHybridTargetRange(HybridTargetRange var1, int var2) throws MethodException;

    public void updateBatteryControlPastErrorReason(int var1, int var2, int var3, int var4) throws MethodException;

    public void updateBatteryControlPlugDisplayState(int var1, int var2, int var3) throws MethodException;

    public void updateBatteryControlRemainingChargeTime(BatteryControlRemainingChargeTime var1, BatteryControlRemainingChargeTime var2, int var3) throws MethodException;

    public void updateBatteryControlLowestMaxCurrent(int var1, int var2) throws MethodException;

    public void updateHybridInhibitReason(HybridInhibitReason var1, int var2) throws MethodException;

    public void updateHybridActivePedal(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

