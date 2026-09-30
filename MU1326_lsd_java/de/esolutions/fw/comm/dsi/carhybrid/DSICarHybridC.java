/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carhybrid;

import de.esolutions.fw.comm.core.method.MethodException;
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

public interface DSICarHybridC {
    public void setBatteryControlImmediately(int var1, int var2) throws MethodException;

    public void setBatteryControlTimerState(BatteryControlProgrammedTimer var1) throws MethodException;

    public void setBatteryControlTimer(int var1, int var2, int var3, int var4, int var5, int var6, BatteryControlWeekdays var7, int var8) throws MethodException;

    public void setBatteryControlSetFactoryDefault() throws MethodException;

    public void setHybridTargetRange(short var1, int var2) throws MethodException;

    public void setHybridEnergyAssistControl(boolean var1) throws MethodException;

    public void requestBatteryControlProfileList(BatteryControlProfilesAH var1) throws MethodException;

    public void setBatteryControlProfileListRA0(BatteryControlProfilesAH var1, BatteryControlProfileRA0[] var2) throws MethodException;

    public void setBatteryControlProfileListRA1(BatteryControlProfilesAH var1, BatteryControlProfileRA1[] var2) throws MethodException;

    public void setBatteryControlProfileListRA2(BatteryControlProfilesAH var1, BatteryControlProfileRA2[] var2) throws MethodException;

    public void setBatteryControlProfileListRA3(BatteryControlProfilesAH var1, BatteryControlProfileRA3[] var2) throws MethodException;

    public void setBatteryControlProfileListRA4(BatteryControlProfilesAH var1, BatteryControlProfileRA4[] var2) throws MethodException;

    public void setBatteryControlProfileListRA5(BatteryControlProfilesAH var1, BatteryControlProfileRA5[] var2) throws MethodException;

    public void setBatteryControlProfileListRA6(BatteryControlProfilesAH var1, BatteryControlProfileRA6[] var2) throws MethodException;

    public void setBatteryControlProfileListRA7(BatteryControlProfilesAH var1, BatteryControlProfileRA7[] var2) throws MethodException;

    public void setBatteryControlProfileListRAF(BatteryControlProfilesAH var1, int[] var2) throws MethodException;

    public void setBatteryControlPowerProviderRA0(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRA0[] var2) throws MethodException;

    public void setBatteryControlPowerProviderRA1(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRA1[] var2) throws MethodException;

    public void setBatteryControlPowerProviderRA2(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRA2[] var2) throws MethodException;

    public void setBatteryControlPowerProviderRAE(BatteryControlPowerProviderAH var1, BatteryControlPowerProviderRAE[] var2) throws MethodException;

    public void setBatteryControlPowerProviderRAF(BatteryControlPowerProviderAH var1, int[] var2) throws MethodException;

    public void requestBatteryControlPowerProviderList(BatteryControlPowerProviderAH var1) throws MethodException;

    public void setBatteryControlPastErrorReason(int var1) throws MethodException;

    public void setBatteryControlRemainingChargeTime(int var1, short var2, int var3, short var4) throws MethodException;

    public void setHybridActivePedal(boolean var1) throws MethodException;

    public void setNotification(int[] var1) throws MethodException;

    public void setNotification(int var1) throws MethodException;

    public void setNotification() throws MethodException;

    public void clearNotification(int[] var1) throws MethodException;

    public void clearNotification(int var1) throws MethodException;

    public void clearNotification() throws MethodException;

    public void yySet(String var1, String var2) throws MethodException;
}

