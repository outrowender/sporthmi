/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.dsi;

import de.audi.app.phone.core.dsi.ITelDSIMobileEquipmentDeviceState;
import de.audi.app.phone.core.state.CallStateStruct;

public class TelDSIUtils {
    static int getAcceptMode(ITelDSIMobileEquipmentDeviceState iTelDSIMobileEquipmentDeviceState) {
        CallStateStruct callStateStruct;
        if (iTelDSIMobileEquipmentDeviceState != null && iTelDSIMobileEquipmentDeviceState.getCallState() != null && (callStateStruct = iTelDSIMobileEquipmentDeviceState.getCallState()).isHasIncomingCall()) {
            if (callStateStruct.isHasActiveCall() && !iTelDSIMobileEquipmentDeviceState.isMultipartySupported() || callStateStruct.isMultipartyActive()) {
                return 1;
            }
            if (callStateStruct.isHasActiveCall() ^ callStateStruct.isHasOnHoldCall() && callStateStruct.getHeldCall() != null && callStateStruct.getHeldCall().getTelCallState() != 8 && iTelDSIMobileEquipmentDeviceState.isMultipartySupported()) {
                return 2;
            }
            return 0;
        }
        return 0;
    }

    public static String getRoleName(int n) {
        switch (n) {
            case 65536: {
                return "ROLE_PRIMARY";
            }
            case 131072: {
                return "ROLE_ASSOCIATED";
            }
            case 196608: {
                return "ROLE_DATA";
            }
        }
        return "ROLE_UNKNOWN";
    }
}

