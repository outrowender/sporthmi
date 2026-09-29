/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneArrow;
import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneArrowCombined;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;

public class MixedListLaneGuidanceController$LaneData {
    private static final int LANE0001;
    private static final int LANE0002;
    private static final int LANE0003;
    private static final int LANE0004;
    private static final int LANE0005;
    private static final int LANE0006;
    private static final int LANE0009;
    private static final int LANE0010;
    private static final int LANE0011;
    private static final int LANE0012;
    private static final int LANE0014;
    private static final int LANE0016;
    private static final int LANE0017;
    private static final int LANE0018;
    private static final int LANE0019;
    private static final int LANE001;
    private static final int LANE0020;
    private static final int LANE0021;
    private static final int LANE0022;
    private static final int LANE0023;
    private static final int LANE0025;
    private static final int LANE0026;
    private static final int LANE0027;
    private static final int LANE0029;
    private static final int LANE0030;
    private static final int LANE0031;
    private static final int LANE0033;
    private static final int LANE0034;
    private static final int LANE0035;
    private static final int LANE0037;
    private static final int LANE0038;
    private static final int LANE0039;
    private static final int LANE003;
    private static final int LANE004;
    private static final int LANE005;
    private static final int LANE006;
    private static final int LANE007;
    private static final int LANE008;
    private static final int LANE009;
    private static final int LANE010;
    private static final int LANE011;
    private static final int LANE013;
    private static final int LANE014;
    private static final int LANE015;
    private static final int LANE016;
    private static final int LANE017;
    private static final int LANE018;
    private static final int LANE019;
    private static final int LANE01;
    private static final int LANE020;
    private static final int LANE021;
    private static final int LANE022;
    private static final int LANE023;
    private static final int LANE024;
    private static final int LANE025;
    private static final int LANE026;
    private static final int LANE027;
    private static final int LANE02;
    private static final int LANE03;
    private static final int LANE04;
    private static final int LANE055;
    private static final int LANE05;
    private static final int LANE061;
    private static final int LANE062;
    private static final int LANE06;
    private static final int LANE07;
    private static final int LANE08;
    private static final int LANE09;
    private static final int OMIT_LANE;
    private static final int[][] LANE_IDX;
    private int arrowCount;
    private int[] atlasIndex;
    private int[] colors;
    private int background;

    private int calculateAtlasIndex(int n, int n2) {
        if (0 <= n2 && n2 < LANE_IDX.length && 0 <= n && n < LANE_IDX[0].length) {
            return LANE_IDX[n2][n];
        }
        IWidgetLogChannel.mixedListItemLogCh.log(10000, "MixedListLaneGuidance#calculateAtlasIndex Table index out of range (%1, %2).", (long)n, (long)n2);
        return -1;
    }

    public int getArrowCount() {
        return this.arrowCount;
    }

    public int[] getAtlasIndex() {
        return this.atlasIndex;
    }

    public int[] getColors() {
        return this.colors;
    }

    public int getBackground() {
        return this.background;
    }

    public MixedListLaneGuidanceController$LaneData(MixedListConstants$LaneArrowCombined mixedListConstants$LaneArrowCombined) {
        if (mixedListConstants$LaneArrowCombined != null) {
            if (mixedListConstants$LaneArrowCombined.arrowType == 1) {
                MixedListConstants$LaneArrow[] mixedListConstants$LaneArrowArray = mixedListConstants$LaneArrowCombined.arrows;
                if (mixedListConstants$LaneArrowArray != null) {
                    this.arrowCount = mixedListConstants$LaneArrowArray.length;
                    this.atlasIndex = new int[this.arrowCount];
                    this.colors = new int[this.arrowCount];
                    for (int i2 = 0; i2 < mixedListConstants$LaneArrowArray.length; ++i2) {
                        MixedListConstants$LaneArrow mixedListConstants$LaneArrow = mixedListConstants$LaneArrowArray[i2];
                        if (mixedListConstants$LaneArrow != null) {
                            this.atlasIndex[i2] = this.calculateAtlasIndex(mixedListConstants$LaneArrow.combinationOfCurve, mixedListConstants$LaneArrow.directionOfArrow);
                            this.colors[i2] = mixedListConstants$LaneArrow.color;
                            continue;
                        }
                        IWidgetLogChannel.mixedListItemLogCh.log(10000, "MixedListLaneGuidance#LaneData Arrow is null.");
                    }
                }
                this.background = mixedListConstants$LaneArrowCombined.background;
            } else {
                this.arrowCount = 1;
                this.atlasIndex = new int[]{78};
                this.colors = new int[]{0};
                this.background = 0;
            }
        }
    }

    static {
        LANE_IDX = new int[][]{{58, 51, 51, -1, 19, 21, 21, 22, 0}, {68, 41, -1, 61, 60, 2, -1, 23, 1}, {68, 41, -1, 61, 59, 2, -1, 25, 3}, {67, 43, -1, 62, 42, 5, -1, 26, 4}, {69, 57, -1, 63, 44, -1, -1, 27, 8}, {69, 57, -1, 63, 56, -1, -1, 29, 9}, {77, 70, -1, 72, -1, 39, -1, 40, -1}, {74, 54, 55, 64, -1, -1, 11, 32, -1}, {74, 54, 46, 64, -1, -1, 13, 34, -1}, {76, 47, 48, 65, -1, 15, 16, 35, -1}, {75, 49, 53, 66, -1, 18, 17, 36, -1}, {75, 49, 52, 66, -1, 18, 20, 38, -1}, {71, 45, -1, 73, -1, 10, -1, 31, -1}, {-1, 19, 51, -1, 19, 0, 21, 22, 0}};
    }
}

