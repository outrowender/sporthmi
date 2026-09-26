/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.intercommunication.MixedListConstants$TollGateInfo;
import de.audi.atip.hmi.intercommunication.MixedListConstants$TollgateType_enum;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLayoutPackage;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListTollGateInfoRenderer;

public class MixedListTollGateInfoController
extends AbstractWidgetController {
    private static final int ATLAS_INDEX_GENERAL_ONLY;
    private static final int ATLAS_INDEX_ETC_AND_GENRAL_COMBINED_JAPAN;
    private static final int ATLAS_INDEX_ETC_DEDICATED_CHINA_SLIM;
    private static final int ATLAS_INDEX_ETC_DEDICATED_JAPAN_SLIM;
    private static final int ATLAS_INDEX_ETC_DEDICATED_KOREA_SLIM;
    private static final int ATLAS_INDEX_ETC_DEDICATED_CHINA;
    private static final int ATLAS_INDEX_ETC_DEDICATED_JAPAN;
    private static final int ATLAS_INDEX_ETC_DEDICATED_KOREA;
    private static final int ATLAS_INDEX_LANE_OMIT_SLIM;
    private static final int ATLAS_INDEX_OFF;
    private MixedListTollGateInfoRenderer renderer;
    private int laneCount;
    private int[] atlasIndex;
    private Object cached_Data;

    public int getLaneCount() {
        return this.laneCount;
    }

    private int calculateAtlasIndex(MixedListConstants$TollgateType_enum mixedListConstants$TollgateType_enum, boolean bl) {
        if (mixedListConstants$TollgateType_enum.equals(MixedListConstants$TollgateType_enum.ETC_DEDICATED)) {
            if (MixedListLayoutPackage.isJp) {
                return bl ? 3 : 6;
            }
            if (MixedListLayoutPackage.isKr) {
                return bl ? 4 : 7;
            }
            return bl ? 2 : 5;
        }
        if (mixedListConstants$TollgateType_enum.equals(MixedListConstants$TollgateType_enum.ETC_AND_GENERAL_COMBINED)) {
            if (MixedListLayoutPackage.isJp) {
                return 1;
            }
            if (MixedListLayoutPackage.isKr) {
                return bl ? 4 : 7;
            }
            return bl ? 2 : 5;
        }
        if (mixedListConstants$TollgateType_enum.equals(MixedListConstants$TollgateType_enum.ETC_GENERAL_ONLY)) {
            return 0;
        }
        if (mixedListConstants$TollgateType_enum.equals(MixedListConstants$TollgateType_enum.ETC_LANE_OMIT)) {
            if (!bl) {
                mixedListLogChannel.log(10000, "MixedListTollGateInfoController#calculateAtlasIndex Displaying ETC_LANE_OMIT for full size boxes is not supported.");
            }
            return 8;
        }
        return 0;
    }

    private void calculateContent(MixedListConstants$TollGateInfo mixedListConstants$TollGateInfo) {
        MixedListConstants$TollgateType_enum[] mixedListConstants$TollgateType_enumArray;
        this.clearContent();
        if (mixedListConstants$TollGateInfo != null && (mixedListConstants$TollgateType_enumArray = mixedListConstants$TollGateInfo.getTollGateTypes()) != null) {
            this.laneCount = Math.min(mixedListConstants$TollgateType_enumArray.length, 12);
            boolean bl = this.laneCount > 6;
            this.atlasIndex = new int[this.laneCount];
            for (int i2 = 0; i2 < this.laneCount; ++i2) {
                this.atlasIndex[i2] = this.calculateAtlasIndex(mixedListConstants$TollgateType_enumArray[i2], bl);
            }
        }
        this.cached_Data = mixedListConstants$TollGateInfo;
    }

    private void clearContent() {
        this.laneCount = 0;
        this.atlasIndex = null;
        this.cached_Data = null;
    }

    @Override
    public void disconnecting() {
        super.disconnecting();
        this.clearContent();
    }

    @Override
    public IRenderer getRenderer() {
        return this.renderer;
    }

    public int[] getAtlasIndex() {
        return this.atlasIndex;
    }

    public void setRenderer(MixedListTollGateInfoRenderer mixedListTollGateInfoRenderer) {
        this.renderer = mixedListTollGateInfoRenderer;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void updateContent() {
        mixedListLogChannel.log(-2137614336, "MixedListTollGateInfoController#updateContent Update from model %1", this.model);
        if (!(this.model instanceof MixedListConstants$TollGateInfo)) {
            mixedListLogChannel.log(-2137614336, "MixedListTollGateInfoController#updateContent Model is of wrong type.");
            this.clearContent();
            return;
        }
        if (!Util.equals(this.model, this.cached_Data)) {
            this.calculateContent((MixedListConstants$TollGateInfo)this.model);
            this.setCompositesDirty(true);
            return;
        }
        mixedListLogChannel.log(-2137614336, "MixedListTollGateInfoController#updateContent Content did not change.");
    }
}

