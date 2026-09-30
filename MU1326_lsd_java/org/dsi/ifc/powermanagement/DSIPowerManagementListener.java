/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.powermanagement;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.powermanagement.ClampSignal;

public interface DSIPowerManagementListener
extends DSIListener {
    public void updatePowerManagementState(int var1, int var2, int var3);

    public void updatePowerManagementStateRight(int var1, int var2, int var3);

    public void updateBEMState(int var1, int var2);

    public void updateTelMaxPopup(boolean var1, int var2);

    public void updateTStandbyPopup(boolean var1, int var2);

    public void updateClampSignal(ClampSignal var1, int var2);

    public void updateRVCActive(boolean var1, int var2);

    public void updateChildLockState(int var1, int var2);

    public void updateLastOn(int var1, int var2);

    public void updateSplashScreenAnimation(int var1, int var2);
}

