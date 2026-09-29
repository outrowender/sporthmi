/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.IBatteryControlListHandlingCallback;
import de.audi.atip.interapp.IBatteryControlListHandlingConstants;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;

public interface IBatteryControlListHandlingService
extends IBatteryControlListHandlingConstants {
    default public int getProfile1Pos() {
    }

    default public int getProfile2Pos() {
    }

    default public int getProfile3Pos() {
    }

    default public int getProfileListLength() {
    }

    default public BatteryControlProfileOperation getBatteryControlProfileOperation(int n) {
    }

    default public void setBatteryControlProfileOperation(int n, boolean bl, boolean bl2, boolean bl3) {
    }

    default public boolean isProfileXOperationCharge(int n) {
    }

    default public void setProfileXOperationCharge(int n, boolean bl) {
    }

    default public boolean isProfileXOperationClimate(int n) {
    }

    default public void setProfileXOperationClimate(int n, boolean bl) {
    }

    default public boolean isProfileXOperation2Heater(int n) {
    }

    default public void setProfileXOperation2Heater(int n, boolean bl) {
    }

    default public boolean isProfileXOperation2HeaterAutomatic(int n) {
    }

    default public void setProfileXOperation2HeaterAutomatic(int n, boolean bl) {
    }

    default public int getProfileXProviderDataId(int n) {
    }

    default public void setProfile1ProviderDataId(int n) {
    }

    default public void setProfile2ProviderDataId(int n) {
    }

    default public void setProfile3ProviderDataId(int n) {
    }

    default public void setAuxAcClimateSystem(int n, int n2) {
    }

    default public void registerCalledBackComponent(IBatteryControlListHandlingCallback iBatteryControlListHandlingCallback) {
    }

    default public void setPreferredLoadingTimer1() {
    }

    default public void setPreferredLoadingTimer2() {
    }
}

