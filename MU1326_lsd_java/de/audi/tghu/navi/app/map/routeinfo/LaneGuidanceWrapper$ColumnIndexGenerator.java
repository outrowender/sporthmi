/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routeinfo;

import de.audi.tghu.navi.app.map.routeinfo.LaneGuidanceWrapper;
import de.audi.tghu.navi.app.map.routeinfo.LaneGuidanceWrapper$1;
import de.audi.tghu.navi.app.map.routeinfo.LaneGuidanceWrapper$ColumnIndexGenerateStrategy;
import org.dsi.ifc.navigation.NavLaneGuidanceData;

class LaneGuidanceWrapper$ColumnIndexGenerator
implements LaneGuidanceWrapper$ColumnIndexGenerateStrategy {
    private final /* synthetic */ LaneGuidanceWrapper this$0;

    private LaneGuidanceWrapper$ColumnIndexGenerator(LaneGuidanceWrapper laneGuidanceWrapper) {
        this.this$0 = laneGuidanceWrapper;
    }

    @Override
    public int getColumnIndex(NavLaneGuidanceData navLaneGuidanceData) {
        short s = (short)(navLaneGuidanceData.laneDirection | navLaneGuidanceData.laneType);
        boolean bl = (s & 0x3E) > 0;
        boolean bl2 = (s & 0xF80) > 0;
        boolean bl3 = (s & 0x40) > 0;
        boolean bl4 = bl2 && !bl;
        boolean bl5 = !bl2 && bl;
        boolean bl6 = bl2 && bl;
        int n = LaneGuidanceWrapper.access$100(this.this$0, navLaneGuidanceData.laneDirection) + LaneGuidanceWrapper.access$100(this.this$0, navLaneGuidanceData.laneType);
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
                LaneGuidanceWrapper.access$200(this.this$0).log(-1601830656, "ColumnIndexGenerator#getColumnIndex(), 2 arrows, failed to get a correct column index, arrow data: laneDirection: (%1) and laneType: (%2)", (long)navLaneGuidanceData.laneDirection, (long)navLaneGuidanceData.laneType);
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
                LaneGuidanceWrapper.access$200(this.this$0).log(-1601830656, "ColumnIndexGenerator#getColumnIndex(), 3 arrows, failed to get a correct column index, arrow data: laneDirection: (%1) and laneType: (%2)", (long)navLaneGuidanceData.laneDirection, (long)navLaneGuidanceData.laneType);
                break;
            }
            default: {
                LaneGuidanceWrapper.access$200(this.this$0).log(-1601830656, "ColumnIndexGenerator#getColumnIndex(), more than 3 arrows or has no arrow, failed to get a correct column index, arrow data: laneDirection: (%1) and laneType: (%2)", (long)navLaneGuidanceData.laneDirection, (long)navLaneGuidanceData.laneType);
            }
        }
        return n2;
    }

    /* synthetic */ LaneGuidanceWrapper$ColumnIndexGenerator(LaneGuidanceWrapper laneGuidanceWrapper, LaneGuidanceWrapper$1 laneGuidanceWrapper$1) {
        this(laneGuidanceWrapper);
    }
}

