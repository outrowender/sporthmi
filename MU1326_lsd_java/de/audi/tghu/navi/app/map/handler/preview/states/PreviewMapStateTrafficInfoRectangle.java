/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateTrafficInfo;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavRectangle;

public class PreviewMapStateTrafficInfoRectangle
extends PreviewMapStateTrafficInfo {
    protected NavRectangle navRectangleTrafficInfo;
    protected long[] trafficInfoEvent;

    public PreviewMapStateTrafficInfoRectangle(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, NavRectangle navRectangle) {
        super(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
        this.navRectangleTrafficInfo = navRectangle;
    }

    public PreviewMapStateTrafficInfoRectangle(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, NavRectangle navRectangle, long[] lArray) {
        super(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
        this.navRectangleTrafficInfo = navRectangle;
        this.trafficInfoEvent = lArray;
    }

    public void applyToScreenDetail() {
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().resetEventVisibilities();
        if (Util.isNavRectangleValid(this.navRectangleTrafficInfo)) {
            this.getMapForPreview().getMVRequest().showTMCMessages(true);
            this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(2);
            NavLocation navLocation = Util.getLocationFromGeoPos(this.navRectangleTrafficInfo.getXLeft(), this.navRectangleTrafficInfo.getYUp());
            NavLocation navLocation2 = Util.getLocationFromGeoPos(this.navRectangleTrafficInfo.getXRight(), this.navRectangleTrafficInfo.getYBottom());
            int n = this.getMapForPreview().getZoomHandler().getZoomListIndex(IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
            this.getMapForPreview().getMVRequest().setMapViewportByLD(navLocation, navLocation2, n);
            this.getMapForPreview().getGuiInterface().showPreviewMap(true);
        } else {
            this.logger.log(10000, "PreviewMapStateTrafficInfoRectangle#applyToScreenDetail() - could not calculate rectangle => hide preview map instead");
            this.getPreviewMapHandler().hidePreviewMap();
        }
    }

    public void applyToScreenDetailModels() {
    }

    public void applyToScreenFullMap() {
        AbstractMap abstractMap = this.getMapForFullScreen();
        if (Util.isNavRectangleValid(this.navRectangleTrafficInfo)) {
            if (this.getPreviewMapHandler().isPreviewMapPositionRefreshAllowed()) {
                int n = this.getMapForFullScreen().getZoomHandler().getZoomListIndex(100.0f);
                abstractMap.getMVRequest().setMapViewPortByWGS84Rectangle(this.navRectangleTrafficInfo, n);
            }
        } else if (this.trafficInfoEvent != null && this.trafficInfoEvent.length >= 1) {
            this.logger.log(10000, "PreviewMapStateTrafficInfoRectangle#applyToScreenFullMap() - no valid navRectangle - fallback to position of 1st traffic event");
            if (this.getPreviewMapHandler().isPreviewMapPositionRefreshAllowed()) {
                abstractMap.getMVRequest().goToTMCMessage(this.trafficInfoEvent[0]);
            }
        } else {
            this.logger.log(10000, "PreviewMapStateTrafficInfoRectangle#applyToScreenFullMap() - no valid navRectangle");
        }
        if (this.trafficInfoEvent != null && this.trafficInfoEvent.length == 1) {
            this.applyToScreenFullMapSingleTrafficEvent(abstractMap);
        }
    }

    protected void applyToScreenFullMapSingleTrafficEvent(AbstractMap abstractMap) {
        if (this.getPreviewMapClientId() == 0) {
            abstractMap.getMapDataContainer().showLastTmcFromCtxCrosshairInMapGeneral = true;
        } else {
            abstractMap.getMapDataContainer().showLastTmcFromCtxCrosshairEnterInMapRequested = true;
        }
        abstractMap.getNaviInterface().requestTmcMessage((int)this.trafficInfoEvent[0]);
        abstractMap.getMVRequest().ensureTMCVisibility((int)this.trafficInfoEvent[0]);
    }

    public NavLocation getNavLocationForEnterInMap() {
        return null;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("PreviewMapStateTrafficInfoRectangle() traffic ids=");
        if (this.trafficInfoEvent != null && this.trafficInfoEvent.length > 0) {
            for (int i2 = 0; i2 < this.trafficInfoEvent.length; ++i2) {
                buffer.append(this.trafficInfoEvent[i2]);
                if (i2 >= this.trafficInfoEvent.length - 1) continue;
                buffer.append(",");
            }
        }
        return buffer.toString();
    }

    public boolean isPreviewMapItemArea() {
        return Util.isNavRectangleValid(this.navRectangleTrafficInfo) && (this.navRectangleTrafficInfo.xLeft != this.navRectangleTrafficInfo.xLeft || this.navRectangleTrafficInfo.yBottom != this.navRectangleTrafficInfo.yUp);
    }
}

