/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceAccess;
import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentTopologyAccess;
import de.audi.app.phone.core.dsi.NullTelDSIMobileEquipmentDeviceAccess;

public abstract class AbstractMobileEquipementTopologyAccess
extends AbstractPhoneComponent
implements ITelDSIMobileEquipmentTopologyAccess {
    protected final NullTelDSIMobileEquipmentDeviceAccess nullTelDSIMobileEquipmentDeviceAccess;

    protected static int getRoleIDFromSlot(int n) {
        switch (n) {
            case 0: {
                return 65536;
            }
            case 1: {
                return 131072;
            }
            case 2: {
                return 196608;
            }
        }
        return -65536;
    }

    public static int getSlotIDFromRoleID(int n) {
        switch (n) {
            case 65536: {
                return 0;
            }
            case 131072: {
                return 1;
            }
            case 196608: {
                return 2;
            }
        }
        return -1;
    }

    public AbstractMobileEquipementTopologyAccess(ITelApplication iTelApplication, String string) {
        super(iTelApplication, string);
        this.nullTelDSIMobileEquipmentDeviceAccess = new NullTelDSIMobileEquipmentDeviceAccess(this.log);
    }

    public ITelDSIMobileEquipmentDeviceAccess getNullDeviceAccess() {
        return this.nullTelDSIMobileEquipmentDeviceAccess;
    }
}

