/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLaneGuidanceRenderer;

public class MixedListLaneGuidanceController
extends AbstractWidgetController {
    private MixedListLaneGuidanceRenderer renderer;
    private Object cached_Data;
    private int laneCount;
    private LaneData[] laneData;

    private void clearContent() {
        this.laneCount = 0;
        this.laneData = null;
        this.cached_Data = null;
    }

    private void calculateContent(MixedListConstants.LaneGuidance laneGuidance) {
        this.clearContent();
        if (laneGuidance != null) {
            MixedListConstants.LaneArrowCombined[] laneArrowCombinedArray = laneGuidance.getDirectionArrow();
            if (laneArrowCombinedArray != null) {
                this.laneCount = laneArrowCombinedArray.length;
                this.laneData = new LaneData[this.laneCount];
                mixedListItemLogCh.log(10000000, "MixedListLaneGuidance#calculateContent laneCount = %1", (long)this.laneCount);
                for (int i2 = 0; i2 < this.laneCount; ++i2) {
                    this.laneData[i2] = new LaneData(laneArrowCombinedArray[i2]);
                    if (!mixedListItemLogCh.isDebug()) continue;
                    mixedListItemLogCh.log(10000000, "MixedListLaneGuidance#calculateContent %1", (Object)laneArrowCombinedArray[i2].toString());
                }
            } else {
                mixedListItemLogCh.log(10000000, "MixedListLaneGuidance#calculateContent directionArrows is null");
            }
        }
        this.cached_Data = laneGuidance;
    }

    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
    }

    public void disconnecting() {
        super.disconnecting();
        this.clearContent();
    }

    public int getLaneCount() {
        return this.laneCount;
    }

    public LaneData[] getLaneData() {
        return this.laneData;
    }

    public IRenderer getRenderer() {
        return this.renderer;
    }

    public void setRenderer(MixedListLaneGuidanceRenderer mixedListLaneGuidanceRenderer) {
        this.renderer = mixedListLaneGuidanceRenderer;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void updateContent() {
        mixedListLogChannel.log(10000000, "MixedListLaneGuidanceController#updateContent Update from model %1", this.model);
        if (!(this.model instanceof MixedListConstants.LaneGuidance)) {
            mixedListLogChannel.log(10000000, "MixedListLaneGuidanceController#updateContent Model is of wrong type.");
            this.clearContent();
            return;
        }
        if (!Util.equals(this.model, this.cached_Data)) {
            this.calculateContent((MixedListConstants.LaneGuidance)this.model);
            this.setCompositesDirty(true);
            return;
        }
        mixedListLogChannel.log(10000000, "MixedListLaneGuidanceController#updateContent Content did not change.");
    }

    public static class LaneData {
        private static final int LANE0001 = 0;
        private static final int LANE0002 = 1;
        private static final int LANE0003 = 2;
        private static final int LANE0004 = 3;
        private static final int LANE0005 = 4;
        private static final int LANE0006 = 5;
        private static final int LANE0009 = 8;
        private static final int LANE0010 = 9;
        private static final int LANE0011 = 10;
        private static final int LANE0012 = 11;
        private static final int LANE0014 = 13;
        private static final int LANE0016 = 15;
        private static final int LANE0017 = 16;
        private static final int LANE0018 = 17;
        private static final int LANE0019 = 18;
        private static final int LANE001 = 19;
        private static final int LANE0020 = 20;
        private static final int LANE0021 = 21;
        private static final int LANE0022 = 22;
        private static final int LANE0023 = 23;
        private static final int LANE0025 = 25;
        private static final int LANE0026 = 26;
        private static final int LANE0027 = 27;
        private static final int LANE0029 = 29;
        private static final int LANE0030 = 31;
        private static final int LANE0031 = 32;
        private static final int LANE0033 = 34;
        private static final int LANE0034 = 35;
        private static final int LANE0035 = 36;
        private static final int LANE0037 = 38;
        private static final int LANE0038 = 39;
        private static final int LANE0039 = 40;
        private static final int LANE003 = 41;
        private static final int LANE004 = 42;
        private static final int LANE005 = 43;
        private static final int LANE006 = 44;
        private static final int LANE007 = 45;
        private static final int LANE008 = 46;
        private static final int LANE009 = 47;
        private static final int LANE010 = 48;
        private static final int LANE011 = 49;
        private static final int LANE013 = 51;
        private static final int LANE014 = 52;
        private static final int LANE015 = 53;
        private static final int LANE016 = 54;
        private static final int LANE017 = 55;
        private static final int LANE018 = 56;
        private static final int LANE019 = 57;
        private static final int LANE01 = 58;
        private static final int LANE020 = 59;
        private static final int LANE021 = 60;
        private static final int LANE022 = 61;
        private static final int LANE023 = 62;
        private static final int LANE024 = 63;
        private static final int LANE025 = 64;
        private static final int LANE026 = 65;
        private static final int LANE027 = 66;
        private static final int LANE02 = 67;
        private static final int LANE03 = 68;
        private static final int LANE04 = 69;
        private static final int LANE055 = 70;
        private static final int LANE05 = 71;
        private static final int LANE061 = 72;
        private static final int LANE062 = 73;
        private static final int LANE06 = 74;
        private static final int LANE07 = 75;
        private static final int LANE08 = 76;
        private static final int LANE09 = 77;
        private static final int OMIT_LANE = 78;
        private static final int[][] LANE_IDX = new int[][]{{58, 51, 51, -1, 19, 21, 21, 22, 0}, {68, 41, -1, 61, 60, 2, -1, 23, 1}, {68, 41, -1, 61, 59, 2, -1, 25, 3}, {67, 43, -1, 62, 42, 5, -1, 26, 4}, {69, 57, -1, 63, 44, -1, -1, 27, 8}, {69, 57, -1, 63, 56, -1, -1, 29, 9}, {77, 70, -1, 72, -1, 39, -1, 40, -1}, {74, 54, 55, 64, -1, -1, 11, 32, -1}, {74, 54, 46, 64, -1, -1, 13, 34, -1}, {76, 47, 48, 65, -1, 15, 16, 35, -1}, {75, 49, 53, 66, -1, 18, 17, 36, -1}, {75, 49, 52, 66, -1, 18, 20, 38, -1}, {71, 45, -1, 73, -1, 10, -1, 31, -1}, {-1, 19, 51, -1, 19, 0, 21, 22, 0}};
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

        public LaneData(MixedListConstants.LaneArrowCombined laneArrowCombined) {
            if (laneArrowCombined != null) {
                if (laneArrowCombined.arrowType == 1) {
                    MixedListConstants.LaneArrow[] laneArrowArray = laneArrowCombined.arrows;
                    if (laneArrowArray != null) {
                        this.arrowCount = laneArrowArray.length;
                        this.atlasIndex = new int[this.arrowCount];
                        this.colors = new int[this.arrowCount];
                        for (int i2 = 0; i2 < laneArrowArray.length; ++i2) {
                            MixedListConstants.LaneArrow laneArrow = laneArrowArray[i2];
                            if (laneArrow != null) {
                                this.atlasIndex[i2] = this.calculateAtlasIndex(laneArrow.combinationOfCurve, laneArrow.directionOfArrow);
                                this.colors[i2] = laneArrow.color;
                                continue;
                            }
                            IWidgetLogChannel.mixedListItemLogCh.log(10000, "MixedListLaneGuidance#LaneData Arrow is null.");
                        }
                    }
                    this.background = laneArrowCombined.background;
                } else {
                    this.arrowCount = 1;
                    this.atlasIndex = new int[]{78};
                    this.colors = new int[]{0};
                    this.background = 0;
                }
            }
        }
    }
}

