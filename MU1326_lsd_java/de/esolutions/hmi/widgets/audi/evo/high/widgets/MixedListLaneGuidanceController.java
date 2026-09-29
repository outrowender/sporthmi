/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneArrowCombined;
import de.audi.atip.hmi.intercommunication.MixedListConstants$LaneGuidance;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.InitializationContext;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLaneGuidanceController$LaneData;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLaneGuidanceRenderer;

public class MixedListLaneGuidanceController
extends AbstractWidgetController {
    private MixedListLaneGuidanceRenderer renderer;
    private Object cached_Data;
    private int laneCount;
    private MixedListLaneGuidanceController$LaneData[] laneData;

    private void clearContent() {
        this.laneCount = 0;
        this.laneData = null;
        this.cached_Data = null;
    }

    private void calculateContent(MixedListConstants$LaneGuidance mixedListConstants$LaneGuidance) {
        this.clearContent();
        if (mixedListConstants$LaneGuidance != null) {
            MixedListConstants$LaneArrowCombined[] mixedListConstants$LaneArrowCombinedArray = mixedListConstants$LaneGuidance.getDirectionArrow();
            if (mixedListConstants$LaneArrowCombinedArray != null) {
                this.laneCount = mixedListConstants$LaneArrowCombinedArray.length;
                this.laneData = new MixedListLaneGuidanceController$LaneData[this.laneCount];
                mixedListItemLogCh.log(-2137614336, "MixedListLaneGuidance#calculateContent laneCount = %1", (long)this.laneCount);
                for (int i2 = 0; i2 < this.laneCount; ++i2) {
                    this.laneData[i2] = new MixedListLaneGuidanceController$LaneData(mixedListConstants$LaneArrowCombinedArray[i2]);
                    if (!mixedListItemLogCh.isDebug()) continue;
                    mixedListItemLogCh.log(-2137614336, "MixedListLaneGuidance#calculateContent %1", (Object)mixedListConstants$LaneArrowCombinedArray[i2].toString());
                }
            } else {
                mixedListItemLogCh.log(-2137614336, "MixedListLaneGuidance#calculateContent directionArrows is null");
            }
        }
        this.cached_Data = mixedListConstants$LaneGuidance;
    }

    @Override
    public void connected(InitializationContext initializationContext) {
        super.connected(initializationContext);
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
        this.clearContent();
    }

    public int getLaneCount() {
        return this.laneCount;
    }

    public MixedListLaneGuidanceController$LaneData[] getLaneData() {
        return this.laneData;
    }

    @Override
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
        mixedListLogChannel.log(-2137614336, "MixedListLaneGuidanceController#updateContent Update from model %1", this.model);
        if (!(this.model instanceof MixedListConstants$LaneGuidance)) {
            mixedListLogChannel.log(-2137614336, "MixedListLaneGuidanceController#updateContent Model is of wrong type.");
            this.clearContent();
            return;
        }
        if (!Util.equals(this.model, this.cached_Data)) {
            this.calculateContent((MixedListConstants$LaneGuidance)this.model);
            this.setCompositesDirty(true);
            return;
        }
        mixedListLogChannel.log(-2137614336, "MixedListLaneGuidanceController#updateContent Content did not change.");
    }
}

