/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.intercommunication;

import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneArrow;
import de.esolutions.fw.util.commons.Buffer;

public class MixedListConstants$LaneArrowCombined {
    public static final int MAX_ARROWS;
    public static final int ARROW_TYPE_DOTS;
    public static final int ARROW_TYPE_ARROW;
    public static final int BACKGROUND_4CORNER;
    public static final int BACKGROUND_5CORNER_RIGHT;
    public static final int BACKGROUND_5CORNER_LEFT;
    public MixedListConstants$LaneArrow[] arrows;
    public int background = 0;
    public int arrowType = 1;
    public boolean hasBlueArrow = false;

    public MixedListConstants$LaneArrowCombined(int n, int n2) {
        this.arrowType = n;
        this.background = n2;
    }

    public boolean equals(Object object) {
        if (object instanceof MixedListConstants$LaneArrowCombined) {
            MixedListConstants$LaneArrowCombined mixedListConstants$LaneArrowCombined = (MixedListConstants$LaneArrowCombined)object;
            if (this.arrowType != mixedListConstants$LaneArrowCombined.arrowType) {
                return false;
            }
            if (this.background != mixedListConstants$LaneArrowCombined.background) {
                return false;
            }
            MixedListConstants$LaneArrow[] mixedListConstants$LaneArrowArray = mixedListConstants$LaneArrowCombined.arrows;
            if (this.arrows != null && mixedListConstants$LaneArrowArray != null) {
                for (int i2 = 0; i2 < this.arrows.length; ++i2) {
                    if (this.arrows[i2].equals(mixedListConstants$LaneArrowArray[i2])) continue;
                    return false;
                }
                return true;
            }
            return this.arrows == null && mixedListConstants$LaneArrowArray == null;
        }
        return false;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("arrowType = ");
        buffer.append(this.arrowType);
        buffer.append(", background = ");
        buffer.append(this.background);
        if (this.arrows != null) {
            buffer.append(", ");
            buffer.append(this.arrows.length);
            buffer.append(" arrows as follows:\n");
            int n = 0;
            while (n < this.arrows.length) {
                buffer.append("  -");
                buffer.append(this.arrows[n].toString());
                if (++n >= this.arrows.length) continue;
                buffer.append("\n");
            }
        } else {
            buffer.append(", no arrows");
        }
        return buffer.toString();
    }
}

