/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.intercommunication;

import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneArrowCombined;

public class MixedListConstants$LaneGuidance {
    public static final int MAX_LANE_COUNT;
    private MixedListConstants$LaneArrowCombined[] directionArrow = null;

    public MixedListConstants$LaneArrowCombined[] getDirectionArrow() {
        return this.directionArrow;
    }

    public void setDirectionArrow(MixedListConstants$LaneArrowCombined[] mixedListConstants$LaneArrowCombinedArray) {
        this.directionArrow = mixedListConstants$LaneArrowCombinedArray;
    }

    public boolean equals(Object object) {
        if (object instanceof MixedListConstants$LaneGuidance) {
            MixedListConstants$LaneGuidance mixedListConstants$LaneGuidance = (MixedListConstants$LaneGuidance)object;
            MixedListConstants$LaneArrowCombined[] mixedListConstants$LaneArrowCombinedArray = mixedListConstants$LaneGuidance.getDirectionArrow();
            if (this.directionArrow != null && mixedListConstants$LaneArrowCombinedArray != null) {
                if (this.directionArrow.length != mixedListConstants$LaneArrowCombinedArray.length) {
                    return false;
                }
                for (int i2 = 0; i2 < this.directionArrow.length; ++i2) {
                    if (this.directionArrow[i2].equals(mixedListConstants$LaneArrowCombinedArray[i2])) continue;
                    return false;
                }
                return true;
            }
            return this.directionArrow == null && mixedListConstants$LaneArrowCombinedArray == null;
        }
        return false;
    }

    public String toString() {
        return new StringBuffer().append("LaneGuidance[").append(this.directionArrow != null ? String.valueOf(this.directionArrow.length) : "null").append("]").toString();
    }
}

