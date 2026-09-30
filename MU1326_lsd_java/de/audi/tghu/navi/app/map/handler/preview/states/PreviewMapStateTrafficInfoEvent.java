/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview.states;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateTrafficInfo;
import org.dsi.ifc.global.NavLocation;

public class PreviewMapStateTrafficInfoEvent
extends PreviewMapStateTrafficInfo {
    protected long trafficInfoEvent;

    public PreviewMapStateTrafficInfoEvent(PreviewMapHandlerAbstract previewMapHandlerAbstract, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer, long l) {
        super(previewMapHandlerAbstract, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
        this.trafficInfoEvent = l;
    }

    public void applyToScreenDetail() {
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().resetEventVisibilities();
        this.getPreviewMapHandler().getPreviewMapEventVisibilities().ensureTMCVisibility(new long[]{this.trafficInfoEvent}, false);
        this.getPreviewMapHandler().setPreviewMapModeAndFrameRate(2);
        this.getMapForPreview().getGuiInterface().showPreviewMap(true);
        this.getMapForPreview().getMVRequest().goToTMCMessage(this.trafficInfoEvent);
    }

    public void applyToScreenDetailModels() {
    }

    public void applyToScreenFullMap() {
        AbstractMap abstractMap = this.getMapForFullScreen();
        abstractMap.getMVRequest().setMode(2);
        if (this.getPreviewMapHandler().isPreviewMapPositionRefreshAllowed()) {
            abstractMap.getMVRequest().goToTMCMessage(this.trafficInfoEvent);
        }
        if (this.getPreviewMapClientId() == 0) {
            abstractMap.getMapDataContainer().showLastTmcFromCtxCrosshairInMapGeneral = true;
        } else {
            abstractMap.getMapDataContainer().showLastTmcFromCtxCrosshairEnterInMapRequested = true;
        }
        abstractMap.getNaviInterface().requestTmcMessage((int)this.trafficInfoEvent);
        abstractMap.getMVRequest().ensureTMCVisibility((int)this.trafficInfoEvent);
    }

    public NavLocation getNavLocationForEnterInMap() {
        return null;
    }

    public String toString() {
        return "PreviewMapStateTrafficInfoEvent()";
    }
}

