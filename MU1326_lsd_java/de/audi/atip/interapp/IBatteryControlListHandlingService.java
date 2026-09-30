/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.IBatteryControlListHandlingCallback;
import de.audi.atip.interapp.IBatteryControlListHandlingConstants;
import org.dsi.ifc.carhybrid.BatteryControlProfileOperation;

public interface IBatteryControlListHandlingService
extends IBatteryControlListHandlingConstants {
    public int getProfile1Pos();

    public int getProfile2Pos();

    public int getProfile3Pos();

    public int getProfileListLength();

    public BatteryControlProfileOperation getBatteryControlProfileOperation(int var1);

    public void setBatteryControlProfileOperation(int var1, boolean var2, boolean var3, boolean var4);

    public boolean isProfileXOperationCharge(int var1);

    public void setProfileXOperationCharge(int var1, boolean var2);

    public boolean isProfileXOperationClimate(int var1);

    public void setProfileXOperationClimate(int var1, boolean var2);

    public boolean isProfileXOperation2Heater(int var1);

    public void setProfileXOperation2Heater(int var1, boolean var2);

    public boolean isProfileXOperation2HeaterAutomatic(int var1);

    public void setProfileXOperation2HeaterAutomatic(int var1, boolean var2);

    public int getProfileXProviderDataId(int var1);

    public void setProfile1ProviderDataId(int var1);

    public void setProfile2ProviderDataId(int var1);

    public void setProfile3ProviderDataId(int var1);

    public void setAuxAcClimateSystem(int var1, int var2);

    public void registerCalledBackComponent(IBatteryControlListHandlingCallback var1);

    public void setPreferredLoadingTimer1();

    public void setPreferredLoadingTimer2();
}

