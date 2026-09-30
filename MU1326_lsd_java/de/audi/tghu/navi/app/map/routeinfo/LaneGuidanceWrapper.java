/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import org.dsi.ifc.navigation.NavLaneGuidanceData;

public class LaneGuidanceWrapper {
    private static final short RIGHT_TURN_ARROW_MASK = 62;
    private static final short LEFT_TURN_ARROW_MASK = 3968;
    private static final short U_TURN_ARROW_MASK = 64;
    private static final short MINIMUM_ARROW_VALUE = 0;
    private static final short MAXIMUM_ARROW_VALUE = 4096;
    private static final short bit_mask_1 = 1;
    private NavLaneGuidanceData[] navLaneGuidanceData = null;
    private MixedListConstants.LaneGuidance laneGuidance = null;
    private LogChannel log = null;
    private ColumnIndexGenerateStrategy columnIndexGenerator = new ColumnIndexGenerator();

    public LaneGuidanceWrapper(LogChannel logChannel, NavLaneGuidanceData[] navLaneGuidanceDataArray) {
        this.log = logChannel;
        this.navLaneGuidanceData = navLaneGuidanceDataArray;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof LaneGuidanceWrapper)) {
            return false;
        }
        if (this == object) {
            return true;
        }
        LaneGuidanceWrapper laneGuidanceWrapper = (LaneGuidanceWrapper)object;
        NavLaneGuidanceData[] navLaneGuidanceDataArray = laneGuidanceWrapper.getNavLaneGuidanceData();
        if (this.navLaneGuidanceData == null && navLaneGuidanceDataArray == null) {
            return true;
        }
        if (this.navLaneGuidanceData == null && navLaneGuidanceDataArray != null || this.navLaneGuidanceData != null && navLaneGuidanceDataArray == null) {
            return false;
        }
        if (this.navLaneGuidanceData.length != navLaneGuidanceDataArray.length) {
            return false;
        }
        for (int i2 = 0; i2 < this.navLaneGuidanceData.length; ++i2) {
            if (this.navLaneGuidanceData[i2] == null && navLaneGuidanceDataArray[i2] == null || this.navLaneGuidanceData[i2] == navLaneGuidanceDataArray[i2]) continue;
            if (this.navLaneGuidanceData[i2] == null && navLaneGuidanceDataArray[i2] != null || this.navLaneGuidanceData[i2] != null && navLaneGuidanceDataArray[i2] == null) {
                return false;
            }
            if (this.navLaneGuidanceData[i2].guidanceInfo != navLaneGuidanceDataArray[i2].guidanceInfo) {
                return false;
            }
            if (this.navLaneGuidanceData[i2].laneDescription != navLaneGuidanceDataArray[i2].laneDescription) {
                return false;
            }
            if (this.navLaneGuidanceData[i2].laneDirection != navLaneGuidanceDataArray[i2].laneDirection) {
                return false;
            }
            if (this.navLaneGuidanceData[i2].laneType != navLaneGuidanceDataArray[i2].laneType) {
                return false;
            }
            if (this.navLaneGuidanceData[i2].pos == navLaneGuidanceDataArray[i2].pos) continue;
            return false;
        }
        return true;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public MixedListConstants.LaneGuidance toLaneGuidance() {
        if (this.laneGuidance == null) {
            this.laneGuidance = this.makeLaneGuidance();
        }
        return this.laneGuidance;
    }

    public NavLaneGuidanceData[] getNavLaneGuidanceData() {
        return this.navLaneGuidanceData;
    }

    private MixedListConstants.LaneGuidance makeLaneGuidance() {
        if (this.navLaneGuidanceData == null || this.navLaneGuidanceData.length == 0) {
            this.log.log(1000000, "LaneGuidanceWrapper#makeLaneGuidance(): NavLaneGuidanceData[] is null or length is empty!");
            return null;
        }
        MixedListConstants.LaneArrowCombined[] laneArrowCombinedArray = new MixedListConstants.LaneArrowCombined[this.navLaneGuidanceData.length];
        for (int i2 = 0; i2 < this.navLaneGuidanceData.length; ++i2) {
            if (this.navLaneGuidanceData[i2] == null) {
                laneArrowCombinedArray[i2] = new MixedListConstants.LaneArrowCombined(1, 0);
                laneArrowCombinedArray[i2].arrows = null;
                continue;
            }
            byte by = this.navLaneGuidanceData[i2].guidanceInfo;
            MixedListConstants.LaneArrowCombined laneArrowCombined = new MixedListConstants.LaneArrowCombined(1, by);
            laneArrowCombined.arrows = this.makeArrows(this.navLaneGuidanceData[i2]);
            laneArrowCombined.hasBlueArrow = this.navLaneGuidanceData[i2].laneType > 0 && this.navLaneGuidanceData[i2].laneType < 4096;
            laneArrowCombinedArray[i2] = laneArrowCombined;
        }
        MixedListConstants.LaneGuidance laneGuidance = new MixedListConstants.LaneGuidance();
        laneGuidance.setDirectionArrow(this.filterLaneCell(laneArrowCombinedArray));
        return laneGuidance;
    }

    private MixedListConstants.LaneArrowCombined[] filterLaneCell(MixedListConstants.LaneArrowCombined[] laneArrowCombinedArray) {
        int n;
        if (laneArrowCombinedArray == null || laneArrowCombinedArray.length <= 6) {
            return laneArrowCombinedArray;
        }
        int n2 = -1;
        int n3 = -1;
        MixedListConstants.LaneArrowCombined[] laneArrowCombinedArray2 = new MixedListConstants.LaneArrowCombined[6];
        for (n = 0; n < laneArrowCombinedArray.length; ++n) {
            if (!laneArrowCombinedArray[n].hasBlueArrow) continue;
            n2 = n;
            break;
        }
        if (n2 == -1) {
            for (n = 0; n < 6; ++n) {
                laneArrowCombinedArray2[n] = laneArrowCombinedArray[n];
            }
            laneArrowCombinedArray2[laneArrowCombinedArray2.length - 1].arrowType = 0;
            return laneArrowCombinedArray2;
        }
        for (n = laneArrowCombinedArray.length - 1; n >= 0; --n) {
            if (!laneArrowCombinedArray[n].hasBlueArrow) continue;
            n3 = n;
            break;
        }
        n = 0;
        int n4 = 0;
        while (!(n4 >= laneArrowCombinedArray.length || laneArrowCombinedArray[n4].hasBlueArrow || n4 < laneArrowCombinedArray.length - 1 && laneArrowCombinedArray[n4 + 1].hasBlueArrow || laneArrowCombinedArray.length - n4 <= 6 || n3 - n4 + 1 < 6)) {
            n = ++n4;
        }
        n4 = n;
        for (int i2 = 0; n4 < laneArrowCombinedArray.length && i2 < laneArrowCombinedArray2.length; ++n4, ++i2) {
            laneArrowCombinedArray2[i2] = laneArrowCombinedArray[n4];
            if (i2 == 0 && n4 != 0) {
                laneArrowCombinedArray2[i2].arrowType = 0;
                continue;
            }
            if (i2 != laneArrowCombinedArray2.length - 1 || n4 >= laneArrowCombinedArray.length - 1) continue;
            laneArrowCombinedArray2[i2].arrowType = 0;
        }
        return laneArrowCombinedArray2;
    }

    private MixedListConstants.LaneArrow[] makeArrows(NavLaneGuidanceData navLaneGuidanceData) {
        boolean bl = navLaneGuidanceData.laneDescription == 0;
        int n = this.columnIndexGenerator.getColumnIndex(navLaneGuidanceData);
        if (n == -1) {
            this.log.log(100000, "LaneGuidanceWrapper#makeArrows(), failed to get a correct column index, NavLaneGuidanceData: (%1)", (Object)navLaneGuidanceData);
            return null;
        }
        ArrayList arrayList = new ArrayList(3);
        if (navLaneGuidanceData.laneDirection > 0 && navLaneGuidanceData.laneDirection < 4096) {
            this.addArrowToList(arrayList, navLaneGuidanceData.laneDirection, 0, n, bl);
        }
        if (navLaneGuidanceData.laneType > 0 && navLaneGuidanceData.laneType < 4096) {
            this.addArrowToList(arrayList, navLaneGuidanceData.laneType, 1, n, bl);
        }
        if (arrayList.size() > 0) {
            Object[] objectArray = new MixedListConstants.LaneArrow[arrayList.size()];
            arrayList.toArray(objectArray);
            return objectArray;
        }
        return null;
    }

    private void addArrowToList(ArrayList arrayList, short s, int n, int n2, boolean bl) {
        int n3 = 0;
        while (s > 0) {
            if ((s & 1) == 1) {
                MixedListConstants.LaneArrow laneArrow = new MixedListConstants.LaneArrow(n2, n3, n);
                if (!bl && 0 == laneArrow.directionOfArrow) {
                    laneArrow.directionOfArrow = 13;
                } else if (!bl && 6 == laneArrow.directionOfArrow) {
                    laneArrow.directionOfArrow = 12;
                }
                arrayList.add(laneArrow);
            }
            s = (short)(s >> 1);
            ++n3;
        }
    }

    private int countArrows(short s) {
        int n = 0;
        while (s > 0) {
            if ((s & 1) == 1) {
                ++n;
            }
            s = (short)(s >> 1);
        }
        return n;
    }

    private class ColumnIndexGenerator
    implements ColumnIndexGenerateStrategy {
        private ColumnIndexGenerator() {
        }

        public int getColumnIndex(NavLaneGuidanceData navLaneGuidanceData) {
            short s = (short)(navLaneGuidanceData.laneDirection | navLaneGuidanceData.laneType);
            boolean bl = (s & 0x3E) > 0;
            boolean bl2 = (s & 0xF80) > 0;
            boolean bl3 = (s & 0x40) > 0;
            boolean bl4 = bl2 && !bl;
            boolean bl5 = !bl2 && bl;
            boolean bl6 = bl2 && bl;
            int n = LaneGuidanceWrapper.this.countArrows(navLaneGuidanceData.laneDirection) + LaneGuidanceWrapper.this.countArrows(navLaneGuidanceData.laneType);
            int n2 = -1;
            switch (n) {
                case 1: {
                    n2 = 0;
                    break;
                }
                case 2: {
                    if (bl3) {
                        n2 = 1;
                        break;
                    }
                    if (!bl3 && bl4) {
                        n2 = 2;
                        break;
                    }
                    if (!bl3 && bl6) {
                        n2 = 3;
                        break;
                    }
                    if (!bl3 && bl5) {
                        n2 = 4;
                        break;
                    }
                    LaneGuidanceWrapper.this.log.log(100000, "ColumnIndexGenerator#getColumnIndex(), 2 arrows, failed to get a correct column index, arrow data: laneDirection: (%1) and laneType: (%2)", (long)navLaneGuidanceData.laneDirection, (long)navLaneGuidanceData.laneType);
                    break;
                }
                case 3: {
                    if (bl3 && (bl4 || bl5)) {
                        n2 = 5;
                        break;
                    }
                    if (!bl3 && bl4) {
                        n2 = 6;
                        break;
                    }
                    if (bl6) {
                        n2 = 7;
                        break;
                    }
                    if (!bl3 && bl5) {
                        n2 = 8;
                        break;
                    }
                    LaneGuidanceWrapper.this.log.log(100000, "ColumnIndexGenerator#getColumnIndex(), 3 arrows, failed to get a correct column index, arrow data: laneDirection: (%1) and laneType: (%2)", (long)navLaneGuidanceData.laneDirection, (long)navLaneGuidanceData.laneType);
                    break;
                }
                default: {
                    LaneGuidanceWrapper.this.log.log(100000, "ColumnIndexGenerator#getColumnIndex(), more than 3 arrows or has no arrow, failed to get a correct column index, arrow data: laneDirection: (%1) and laneType: (%2)", (long)navLaneGuidanceData.laneDirection, (long)navLaneGuidanceData.laneType);
                }
            }
            return n2;
        }
    }

    private static interface ColumnIndexGenerateStrategy {
        public static final int INVALID_COL_INDEX = -1;

        public int getColumnIndex(NavLaneGuidanceData var1);
    }
}

