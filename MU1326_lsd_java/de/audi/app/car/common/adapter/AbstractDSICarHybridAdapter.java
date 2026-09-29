/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.adapter;

import de.audi.app.car.common.app.ICarApplication;
import de.audi.app.car.common.comp.AbstractCarComponent;
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
import org.dsi.ifc.carhybrid.DSICarHybrid;
import org.dsi.ifc.carhybrid.DSICarHybridListener;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridInhibitReason;
import org.dsi.ifc.carhybrid.HybridTargetRange;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public abstract class AbstractDSICarHybridAdapter
extends AbstractCarComponent
implements DSICarHybridListener {
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybridListener;
    static /* synthetic */ Class class$org$dsi$ifc$carhybrid$DSICarHybrid;

    public AbstractDSICarHybridAdapter(ICarApplication iCarApplication, String string) {
        super(iCarApplication, string);
    }

    public final DSICarHybrid getDSI() {
        return (DSICarHybrid)this.getBaseDSI();
    }

    @Override
    public final String getDSIListenerClassName() {
        return (class$org$dsi$ifc$carhybrid$DSICarHybridListener == null ? (class$org$dsi$ifc$carhybrid$DSICarHybridListener = AbstractDSICarHybridAdapter.class$("org.dsi.ifc.carhybrid.DSICarHybridListener")) : class$org$dsi$ifc$carhybrid$DSICarHybridListener).getName();
    }

    @Override
    public final String getDSIClassName() {
        return (class$org$dsi$ifc$carhybrid$DSICarHybrid == null ? (class$org$dsi$ifc$carhybrid$DSICarHybrid = AbstractDSICarHybridAdapter.class$("org.dsi.ifc.carhybrid.DSICarHybrid")) : class$org$dsi$ifc$carhybrid$DSICarHybrid).getName();
    }

    @Override
    public final boolean isUsingDSI() {
        return true;
    }

    @Override
    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateHybridCharge(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState, int n) {
        this.logStub();
    }

    @Override
    public void updateHybridRecoveredEnergy(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateHybridEnergyFlow(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlViewOptions(BatteryControlViewOptions batteryControlViewOptions, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlPlug(BatteryControlPlug batteryControlPlug, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlClimateState(BatteryControlClimateState batteryControlClimateState, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlTimerState(BatteryControlTimerState batteryControlTimerState, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlTimer1(BatteryControlTimer batteryControlTimer, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlTimer2(BatteryControlTimer batteryControlTimer, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlTimer3(BatteryControlTimer batteryControlTimer, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlTimer4(BatteryControlTimer batteryControlTimer, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlTotalNumberOfProfiles(int n, int n2) {
        this.logStub();
    }

    public void updateBatteryControlProfilesListUpdateInfo(BatteryControlProfilesAH batteryControlProfilesAH, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlTotalNumberOfPowerProvider(int n, int n2) {
        this.logStub();
    }

    public void updateBatteryControlPowerProviderListUpdateInfo(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int n) {
        this.logStub();
    }

    @Override
    public void acknowledgeBatteryControlSetFactoryDefault(boolean bl) {
        this.logStub();
    }

    @Override
    public void acknowledgeBatteryControlImmediately(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void responseProfileListRA0(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA0[] batteryControlProfileRA0Array) {
        this.logStub();
    }

    @Override
    public void responseProfileListRA1(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA1[] batteryControlProfileRA1Array) {
        this.logStub();
    }

    @Override
    public void responseProfileListRA2(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA2[] batteryControlProfileRA2Array) {
        this.logStub();
    }

    @Override
    public void responseProfileListRA3(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA3[] batteryControlProfileRA3Array) {
        this.logStub();
    }

    @Override
    public void responseProfileListRA4(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA4[] batteryControlProfileRA4Array) {
        this.logStub();
    }

    @Override
    public void responseProfileListRA5(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA5[] batteryControlProfileRA5Array) {
        this.logStub();
    }

    @Override
    public void responseProfileListRA6(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA6[] batteryControlProfileRA6Array) {
        this.logStub();
    }

    @Override
    public void responseProfileListRA7(BatteryControlProfilesAH batteryControlProfilesAH, BatteryControlProfileRA7[] batteryControlProfileRA7Array) {
        this.logStub();
    }

    @Override
    public void responseProfileListRAF(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray) {
        this.logStub();
    }

    @Override
    public void responsePowerProviderListRA0(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA0[] batteryControlPowerProviderRA0Array) {
        this.logStub();
    }

    @Override
    public void responsePowerProviderListRA1(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA1[] batteryControlPowerProviderRA1Array) {
        this.logStub();
    }

    @Override
    public void responsePowerProviderListRA2(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRA2[] batteryControlPowerProviderRA2Array) {
        this.logStub();
    }

    @Override
    public void responsePowerProviderListRAE(BatteryControlPowerProviderAH batteryControlPowerProviderAH, BatteryControlPowerProviderRAE[] batteryControlPowerProviderRAEArray) {
        this.logStub();
    }

    @Override
    public void responsePowerProviderListRAF(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray) {
        this.logStub();
    }

    @Override
    public void updateHybridTargetRange(HybridTargetRange hybridTargetRange, int n) {
        this.logStub();
    }

    @Override
    public void updateHybridEnergyAssistControl(boolean bl, int n) {
        this.logStub();
    }

    @Override
    public void updateHybridEnergyAssistState(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlPastErrorReason(int n, int n2, int n3, int n4) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlPlugDisplayState(int n, int n2, int n3) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlRemainingChargeTime(BatteryControlRemainingChargeTime batteryControlRemainingChargeTime, BatteryControlRemainingChargeTime batteryControlRemainingChargeTime2, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlLowestMaxCurrent(int n, int n2) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlProfilesListUpdateInfo(BatteryControlProfilesAH batteryControlProfilesAH, int[] nArray, int n) {
        this.logStub();
    }

    @Override
    public void updateBatteryControlPowerProviderListUpdateInfo(BatteryControlPowerProviderAH batteryControlPowerProviderAH, int[] nArray, int n) {
        this.logStub();
    }

    @Override
    public void updateHybridInhibitReason(HybridInhibitReason hybridInhibitReason, int n) {
        this.logStub();
    }

    @Override
    public void updateHybridActivePedal(boolean bl, int n) {
        this.logStub();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

