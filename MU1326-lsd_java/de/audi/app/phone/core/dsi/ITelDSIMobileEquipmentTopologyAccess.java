/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.ITelDSIResponseListener;

public interface ITelDSIMobileEquipmentTopologyAccess {
    public static final int ME_SLOT_STATE_INIT;
    public static final int ME_SLOT_NOT_IN_USE;
    public static final int ME_SLOT_PRIMARY;
    public static final int ME_SLOT_SECONDARY;
    public static final int ME_SLOT_DATA;

    default public ITelDSIMobileEquipmentDeviceAccess getPrimaryTelephoneAccess() {
    }

    default public ITelDSIMobileEquipmentDeviceAccess getSecondaryTelephoneAccess() {
    }

    default public ITelDSIMobileEquipmentDeviceAccess getDataOnlyNadAccess() {
    }

    default public ITelDSIMobileEquipmentDeviceAccess getNullDeviceAccess() {
    }

    default public void togglePhones(int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public ITelDSIMobileEquipmentDeviceAccess getNADInstance() {
    }

    default public void restoreFactorySettings(boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetLanguage(String string, boolean bl, int n, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public void requestSetNADMode(int n, boolean bl, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }

    default public ITelDSIMobileEquipmentDeviceAccess getRoleDeviceAccess(int n) {
    }

    default public void requestSetNadRole(int n, int n2, ITelDSIResponseListener iTelDSIResponseListener, ITelDSIResponseListener[] iTelDSIResponseListenerArray) {
    }
}

