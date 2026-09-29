/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneArrow;
import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneArrowCombined;
import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneGuidance;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.routeinfo.LaneGuidanceWrapper$ColumnIndexGenerateStrategy;
import de.audi.tghu.navi.app.map.routeinfo.LaneGuidanceWrapper$ColumnIndexGenerator;
import java.util.ArrayList;
import org.dsi.ifc.navigation.NavLaneGuidanceData;

public class LaneGuidanceWrapper {
    private static final short RIGHT_TURN_ARROW_MASK;
    private static final short LEFT_TURN_ARROW_MASK;
    private static final short U_TURN_ARROW_MASK;
    private static final short MINIMUM_ARROW_VALUE;
    private static final short MAXIMUM_ARROW_VALUE;
    private static final short bit_mask_1;
    private NavLaneGuidanceData[] navLaneGuidanceData = null;
    private MixedListConstants$LaneGuidance laneGuidance = null;
    private LogChannel log = null;
    private LaneGuidanceWrapper$ColumnIndexGenerateStrategy columnIndexGenerator = new LaneGuidanceWrapper$ColumnIndexGenerator(this, null);

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

    public MixedListConstants$LaneGuidance toLaneGuidance() {
        if (this.laneGuidance == null) {
            this.laneGuidance = this.makeLaneGuidance();
        }
        return this.laneGuidance;
    }

    public NavLaneGuidanceData[] getNavLaneGuidanceData() {
        return this.navLaneGuidanceData;
    }

    private MixedListConstants$LaneGuidance makeLaneGuidance() {
        if (this.navLaneGuidanceData == null || this.navLaneGuidanceData.length == 0) {
            this.log.log(1078071040, "LaneGuidanceWrapper#makeLaneGuidance(): NavLaneGuidanceData[] is null or length is empty!");
            return null;
        }
        MixedListConstants$LaneArrowCombined[] mixedListConstants$LaneArrowCombinedArray = new MixedListConstants$LaneArrowCombined[this.navLaneGuidanceData.length];
        for (int i2 = 0; i2 < this.navLaneGuidanceData.length; ++i2) {
            if (this.navLaneGuidanceData[i2] == null) {
                mixedListConstants$LaneArrowCombinedArray[i2] = new MixedListConstants$LaneArrowCombined(1, 0);
                mixedListConstants$LaneArrowCombinedArray[i2].arrows = null;
                continue;
            }
            byte by = this.navLaneGuidanceData[i2].guidanceInfo;
            MixedListConstants$LaneArrowCombined mixedListConstants$LaneArrowCombined = new MixedListConstants$LaneArrowCombined(1, by);
            mixedListConstants$LaneArrowCombined.arrows = this.makeArrows(this.navLaneGuidanceData[i2]);
            mixedListConstants$LaneArrowCombined.hasBlueArrow = this.navLaneGuidanceData[i2].laneType > 0 && this.navLaneGuidanceData[i2].laneType < 4096;
            mixedListConstants$LaneArrowCombinedArray[i2] = mixedListConstants$LaneArrowCombined;
        }
        MixedListConstants$LaneGuidance mixedListConstants$LaneGuidance = new MixedListConstants$LaneGuidance();
        mixedListConstants$LaneGuidance.setDirectionArrow(this.filterLaneCell(mixedListConstants$LaneArrowCombinedArray));
        return mixedListConstants$LaneGuidance;
    }

    private MixedListConstants$LaneArrowCombined[] filterLaneCell(MixedListConstants$LaneArrowCombined[] mixedListConstants$LaneArrowCombinedArray) {
        int n;
        if (mixedListConstants$LaneArrowCombinedArray == null || mixedListConstants$LaneArrowCombinedArray.length <= 6) {
            return mixedListConstants$LaneArrowCombinedArray;
        }
        int n2 = -1;
        int n3 = -1;
        MixedListConstants$LaneArrowCombined[] mixedListConstants$LaneArrowCombinedArray2 = new MixedListConstants$LaneArrowCombined[6];
        for (n = 0; n < mixedListConstants$LaneArrowCombinedArray.length; ++n) {
            if (!mixedListConstants$LaneArrowCombinedArray[n].hasBlueArrow) continue;
            n2 = n;
            break;
        }
        if (n2 == -1) {
            for (n = 0; n < 6; ++n) {
                mixedListConstants$LaneArrowCombinedArray2[n] = mixedListConstants$LaneArrowCombinedArray[n];
            }
            mixedListConstants$LaneArrowCombinedArray2[mixedListConstants$LaneArrowCombinedArray2.length - 1].arrowType = 0;
            return mixedListConstants$LaneArrowCombinedArray2;
        }
        for (n = mixedListConstants$LaneArrowCombinedArray.length - 1; n >= 0; --n) {
            if (!mixedListConstants$LaneArrowCombinedArray[n].hasBlueArrow) continue;
            n3 = n;
            break;
        }
        n = 0;
        int n4 = 0;
        while (!(n4 >= mixedListConstants$LaneArrowCombinedArray.length || mixedListConstants$LaneArrowCombinedArray[n4].hasBlueArrow || n4 < mixedListConstants$LaneArrowCombinedArray.length - 1 && mixedListConstants$LaneArrowCombinedArray[n4 + 1].hasBlueArrow || mixedListConstants$LaneArrowCombinedArray.length - n4 <= 6 || n3 - n4 + 1 < 6)) {
            n = ++n4;
        }
        n4 = n;
        for (int i2 = 0; n4 < mixedListConstants$LaneArrowCombinedArray.length && i2 < mixedListConstants$LaneArrowCombinedArray2.length; ++n4, ++i2) {
            mixedListConstants$LaneArrowCombinedArray2[i2] = mixedListConstants$LaneArrowCombinedArray[n4];
            if (i2 == 0 && n4 != 0) {
                mixedListConstants$LaneArrowCombinedArray2[i2].arrowType = 0;
                continue;
            }
            if (i2 != mixedListConstants$LaneArrowCombinedArray2.length - 1 || n4 >= mixedListConstants$LaneArrowCombinedArray.length - 1) continue;
            mixedListConstants$LaneArrowCombinedArray2[i2].arrowType = 0;
        }
        return mixedListConstants$LaneArrowCombinedArray2;
    }

    private MixedListConstants$LaneArrow[] makeArrows(NavLaneGuidanceData navLaneGuidanceData) {
        boolean bl = navLaneGuidanceData.laneDescription == 0;
        int n = this.columnIndexGenerator.getColumnIndex(navLaneGuidanceData);
        if (n == -1) {
            this.log.log(-1601830656, "LaneGuidanceWrapper#makeArrows(), failed to get a correct column index, NavLaneGuidanceData: (%1)", (Object)navLaneGuidanceData);
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
            Object[] objectArray = new MixedListConstants$LaneArrow[arrayList.size()];
            arrayList.toArray(objectArray);
            return objectArray;
        }
        return null;
    }

    private void addArrowToList(ArrayList arrayList, short s, int n, int n2, boolean bl) {
        int n3 = 0;
        while (s > 0) {
            if ((s & 1) == 1) {
                MixedListConstants$LaneArrow mixedListConstants$LaneArrow = new MixedListConstants$LaneArrow(n2, n3, n);
                if (!bl && 0 == mixedListConstants$LaneArrow.directionOfArrow) {
                    mixedListConstants$LaneArrow.directionOfArrow = 13;
                } else if (!bl && 6 == mixedListConstants$LaneArrow.directionOfArrow) {
                    mixedListConstants$LaneArrow.directionOfArrow = 12;
                }
                arrayList.add(mixedListConstants$LaneArrow);
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

    static /* synthetic */ int access$100(LaneGuidanceWrapper laneGuidanceWrapper, short s) {
        return laneGuidanceWrapper.countArrows(s);
    }

    static /* synthetic */ LogChannel access$200(LaneGuidanceWrapper laneGuidanceWrapper) {
        return laneGuidanceWrapper.log;
    }
}

