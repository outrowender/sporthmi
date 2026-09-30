/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.utils.MapPin;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;

public class PreviewMapEventVisibilities {
    protected LogChannel logger;
    protected PreviewMapHandlerAbstract previewMapHandler;

    public PreviewMapEventVisibilities(PreviewMapHandlerAbstract previewMapHandlerAbstract) {
        this.previewMapHandler = previewMapHandlerAbstract;
        this.logger = previewMapHandlerAbstract.getLogChannel();
    }

    public void resetEventVisibilitiesPredictiveNav() {
        this.resetEventVisibilities();
    }

    public void resetEventVisibilities() {
        this.resetEventVisibilities(false, true);
    }

    public void resetEventVisibilities(boolean bl, boolean bl2) {
        this.logger.log(100000000, "PreviewMapEventVisibilities#resetEventVisibilities() resetVisibleRoutes: %1", bl2);
        if (this.previewMapHandler.isPreviewMapOperable()) {
            this.previewMapHandler.getMapForPreview().getMapFlagHandler().setTemporaryPins(new MapPin[0]);
            if (bl2) {
                this.resetVisibleRoutes();
            }
            this.ensurePOIVisibility(null, bl);
            this.ensureTMCVisibility(null, bl);
            this.removeRouteHighlighting();
        } else {
            this.logger.log(100000, "PreviewMapEventVisibilities#resetEventVisibilities() - preview map currently not operable!");
        }
    }

    public void resetVisibleRoutes() {
        this.previewMapHandler.getMapForPreview().getMVRequest().setVisibleRoutes(new NavSegmentID[0]);
    }

    public void ensurePOIVisibility(NavLocation[] navLocationArray, boolean bl) {
        this.logger.log(100000000, "PreviewMapEventVisibilities#ensurePOIVisibility() - number of POIs: %1", navLocationArray == null ? 0L : (long)navLocationArray.length);
        if (bl || this.previewMapHandler.isPreviewMapReady()) {
            if (navLocationArray == null) {
                navLocationArray = new NavLocation[]{};
            }
            this.previewMapHandler.getMapForPreview().getMVRequest().ensurePoiVisibility(navLocationArray);
        } else {
            this.logger.log(100000, "PreviewMapEventVisibilities#ensurePOIVisibility() - preview map currently not active!");
        }
    }

    public void ensureTMCVisibility(long[] lArray, boolean bl) {
        this.logger.log(100000000, "PreviewMapHandler#ensureTMCVisibility() - number of messageIds: %1", lArray == null ? 0L : (long)lArray.length);
        if (bl || this.previewMapHandler.isPreviewMapReady()) {
            if (lArray == null) {
                lArray = new long[]{0L};
                this.previewMapHandler.getMapForPreview().getMVRequest().showTMCMessages(false);
            } else {
                this.previewMapHandler.getMapForPreview().getMVRequest().showTMCMessages(true);
            }
            for (int i2 = 0; i2 < lArray.length; ++i2) {
                this.previewMapHandler.getMapForPreview().getMVRequest().ensureTMCVisibility(lArray[i2]);
            }
        } else {
            this.logger.log(100000, "PreviewMapEventVisibilities#ensureTMCVisibility() - preview map currently not active!");
        }
    }

    protected void removeRouteHighlighting() {
        this.logger.log(100000000, "PreviewMapEventVisibilities#removeRouteHighlighting()");
        this.previewMapHandler.getMapForPreview().getMVRequest().highlightRouteBasedOnLength(0L, 0L, 0);
    }
}

