/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high.widgets;

import de.audi.atip.hmi.intercommunication.MixedListConstants;
import de.audi.atip.util.Util;
import de.esolutions.hmi.widgets.audi.base.widgets.AbstractWidgetController;
import de.esolutions.hmi.widgets.audi.base.widgets.IRenderer;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListLayoutPackage;
import de.esolutions.hmi.widgets.audi.evo.high.widgets.MixedListTollGateInfoRenderer;

public class MixedListTollGateInfoController
extends AbstractWidgetController {
    private static final int ATLAS_INDEX_GENERAL_ONLY = 0;
    private static final int ATLAS_INDEX_ETC_AND_GENRAL_COMBINED_JAPAN = 1;
    private static final int ATLAS_INDEX_ETC_DEDICATED_CHINA_SLIM = 2;
    private static final int ATLAS_INDEX_ETC_DEDICATED_JAPAN_SLIM = 3;
    private static final int ATLAS_INDEX_ETC_DEDICATED_KOREA_SLIM = 4;
    private static final int ATLAS_INDEX_ETC_DEDICATED_CHINA = 5;
    private static final int ATLAS_INDEX_ETC_DEDICATED_JAPAN = 6;
    private static final int ATLAS_INDEX_ETC_DEDICATED_KOREA = 7;
    private static final int ATLAS_INDEX_LANE_OMIT_SLIM = 8;
    private static final int ATLAS_INDEX_OFF = 0;
    private MixedListTollGateInfoRenderer renderer;
    private int laneCount;
    private int[] atlasIndex;
    private Object cached_Data;

    public int getLaneCount() {
        return this.laneCount;
    }

    private int calculateAtlasIndex(MixedListConstants.TollgateType_enum tollgateType_enum, boolean bl) {
        if (tollgateType_enum.equals(MixedListConstants.TollgateType_enum.ETC_DEDICATED)) {
            if (MixedListLayoutPackage.isJp) {
                return bl ? 3 : 6;
            }
            if (MixedListLayoutPackage.isKr) {
                return bl ? 4 : 7;
            }
            return bl ? 2 : 5;
        }
        if (tollgateType_enum.equals(MixedListConstants.TollgateType_enum.ETC_AND_GENERAL_COMBINED)) {
            if (MixedListLayoutPackage.isJp) {
                return 1;
            }
            if (MixedListLayoutPackage.isKr) {
                return bl ? 4 : 7;
            }
            return bl ? 2 : 5;
        }
        if (tollgateType_enum.equals(MixedListConstants.TollgateType_enum.ETC_GENERAL_ONLY)) {
            return 0;
        }
        if (tollgateType_enum.equals(MixedListConstants.TollgateType_enum.ETC_LANE_OMIT)) {
            if (!bl) {
                mixedListLogChannel.log(10000, "MixedListTollGateInfoController#calculateAtlasIndex Displaying ETC_LANE_OMIT for full size boxes is not supported.");
            }
            return 8;
        }
        return 0;
    }

    private void calculateContent(MixedListConstants.TollGateInfo tollGateInfo) {
        MixedListConstants.TollgateType_enum[] tollgateType_enumArray;
        this.clearContent();
        if (tollGateInfo != null && (tollgateType_enumArray = tollGateInfo.getTollGateTypes()) != null) {
            this.laneCount = Math.min(tollgateType_enumArray.length, 12);
            boolean bl = this.laneCount > 6;
            this.atlasIndex = new int[this.laneCount];
            for (int i2 = 0; i2 < this.laneCount; ++i2) {
                this.atlasIndex[i2] = this.calculateAtlasIndex(tollgateType_enumArray[i2], bl);
            }
        }
        this.cached_Data = tollGateInfo;
    }

    private void clearContent() {
        this.laneCount = 0;
        this.atlasIndex = null;
        this.cached_Data = null;
    }

    public void disconnecting() {
        super.disconnecting();
        this.clearContent();
    }

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
        mixedListLogChannel.log(10000000, "MixedListTollGateInfoController#updateContent Update from model %1", this.model);
        if (!(this.model instanceof MixedListConstants.TollGateInfo)) {
            mixedListLogChannel.log(10000000, "MixedListTollGateInfoController#updateContent Model is of wrong type.");
            this.clearContent();
            return;
        }
        if (!Util.equals(this.model, this.cached_Data)) {
            this.calculateContent((MixedListConstants.TollGateInfo)this.model);
            this.setCompositesDirty(true);
            return;
        }
        mixedListLogChannel.log(10000000, "MixedListTollGateInfoController#updateContent Content did not change.");
    }
}

