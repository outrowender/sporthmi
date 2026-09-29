/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.intercommunication;

import de.audi.atip.hmi.intercommunication.MixedListConstants$TollgateType_enum;

public class MixedListConstants$TollGateInfo {
    public static final int MAX_LANE_COUNT;
    private MixedListConstants$TollgateType_enum[] tollGateTypes;

    public MixedListConstants$TollgateType_enum[] getTollGateTypes() {
        return this.tollGateTypes;
    }

    public void setTollGateTypes(MixedListConstants$TollgateType_enum[] mixedListConstants$TollgateType_enumArray) {
        this.tollGateTypes = mixedListConstants$TollgateType_enumArray;
    }

    public boolean equals(Object object) {
        if (object instanceof MixedListConstants$TollGateInfo) {
            MixedListConstants$TollGateInfo mixedListConstants$TollGateInfo = (MixedListConstants$TollGateInfo)object;
            if (this.tollGateTypes != null && mixedListConstants$TollGateInfo.tollGateTypes != null && this.tollGateTypes.length == mixedListConstants$TollGateInfo.tollGateTypes.length) {
                for (int i2 = 0; i2 < this.tollGateTypes.length; ++i2) {
                    if (this.tollGateTypes[i2].equals(mixedListConstants$TollGateInfo.tollGateTypes[i2])) continue;
                    return false;
                }
                return true;
            }
        }
        return false;
    }
}

