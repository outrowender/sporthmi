/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;

public interface ITelDSIMobileEquipmentTopologyAccess {
    public static final int ME_SLOT_STATE_INIT = -2;
    public static final int ME_SLOT_NOT_IN_USE = -1;
    public static final int ME_SLOT_PRIMARY = 0;
    public static final int ME_SLOT_SECONDARY = 1;
    public static final int ME_SLOT_DATA = 2;

    public ITelDSIMobileEquipmentDeviceAccess getPrimaryTelephoneAccess();

    public ITelDSIMobileEquipmentDeviceAccess getSecondaryTelephoneAccess();

    public ITelDSIMobileEquipmentDeviceAccess getDataOnlyNadAccess();

    public ITelDSIMobileEquipmentDeviceAccess getNullDeviceAccess();

    public void togglePhones(int var1, ITelDSIResponseListener var2, ITelDSIResponseListener[] var3);

    public ITelDSIMobileEquipmentDeviceAccess getNADInstance();

    public void restoreFactorySettings(boolean var1, int var2, ITelDSIResponseListener var3, ITelDSIResponseListener[] var4);

    public void requestSetLanguage(String var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public void requestSetNADMode(int var1, boolean var2, int var3, ITelDSIResponseListener var4, ITelDSIResponseListener[] var5);

    public ITelDSIMobileEquipmentDeviceAccess getRoleDeviceAccess(int var1);

    public void requestSetNadRole(int var1, int var2, ITelDSIResponseListener var3, ITelDSIResponseListener[] var4);
}

