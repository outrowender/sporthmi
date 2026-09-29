/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.intercommunication;

import de.esolutions.fw.util.commons.Buffer;

public class MixedListConstants$LaneArrow {
    public static final int COLOR_GRAY;
    public static final int COLOR_BLUE;
    public static final int STRAIGHT1;
    public static final int UTURN2;
    public static final int LEFT_ONLY2;
    public static final int LEFT_AND_RIGHT2;
    public static final int RIGHT_ONLY2;
    public static final int UTURN3;
    public static final int LEFT_ONLY3;
    public static final int LEFT_AND_RIGHT3;
    public static final int RIGHT_ONLY3;
    public static final int DIRECTION0_LEFT_HAND_TRAFFIC;
    public static final int DIRECTION1;
    public static final int DIRECTION3;
    public static final int DIRECTION4;
    public static final int DIRECTION5;
    public static final int DIRECTION7;
    public static final int DIRECTION8_LEFT_HAND_TRAFFIC;
    public static final int DIRECTION9;
    public static final int DIRECTION11;
    public static final int DIRECTION12;
    public static final int DIRECTION13;
    public static final int DIRECTION15;
    public static final int DIRECTION8_RIGHT_HAND_TRAFFIC;
    public static final int DIRECTION0_RIGHT_HAND_TRAFFIC;
    public int combinationOfCurve;
    public int directionOfArrow;
    public int color;

    public MixedListConstants$LaneArrow(int n, int n2, int n3) {
        this.combinationOfCurve = n;
        this.directionOfArrow = n2;
        this.color = n3;
    }

    public boolean equals(Object object) {
        if (object instanceof MixedListConstants$LaneArrow) {
            MixedListConstants$LaneArrow mixedListConstants$LaneArrow = (MixedListConstants$LaneArrow)object;
            if (this.combinationOfCurve != mixedListConstants$LaneArrow.combinationOfCurve) {
                return false;
            }
            if (this.directionOfArrow != mixedListConstants$LaneArrow.directionOfArrow) {
                return false;
            }
            return this.color == mixedListConstants$LaneArrow.color;
        }
        return false;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("combinationOfCurve = ");
        buffer.append(this.combinationOfCurve);
        buffer.append(", directionOfArrow = ");
        buffer.append(this.directionOfArrow);
        buffer.append(", color = ");
        buffer.append(this.color);
        return buffer.toString();
    }
}

