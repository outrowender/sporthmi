/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.dsi;

import de.audi.atip.log.LogChannel;
import org.dsi.ifc.base.DSIListener;
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
import org.dsi.ifc.carhybrid.DSICarHybrid;

public class NullDSICarHybrid
implements DSICarHybrid {
    private final LogChannel logChan;

    public NullDSICarHybrid(LogChannel logChannel) {
        this.logChan = logChannel;
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlImmediately(int n, int n2) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlTimerState(BatteryControlProgrammedTimer batteryControlProgrammedTimer) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlTimer(int n, int n2, int n3, int n4, int n5, int n6, BatteryControlWeekdays batteryControlWeekdays, int n7) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlSetFactoryDefault() {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void requestBatteryControlProfileList(BatteryControlProfilesAH batteryControlProfilesAH) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlPowerProviderRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlPowerProviderRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlPowerProviderRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlPowerProviderRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlPowerProviderRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void requestBatteryControlPowerProviderList(BatteryControlPowerProviderAH batteryControlPowerProviderAH) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setHybridTargetRange(short s, int n) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setHybridEnergyAssistControl(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlPastErrorReason(int n) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setBatteryControlRemainingChargeTime(int n, short s, int n2, short s2) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }

    @Override
    public void setHybridActivePedal(boolean bl) {
        this.logChan.log(1000, "null-call at NullDSICarHybrid");
    }
}

