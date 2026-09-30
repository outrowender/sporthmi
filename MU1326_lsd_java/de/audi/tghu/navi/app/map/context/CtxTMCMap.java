/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.interapp.icon.ExtRenderingInfo;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CTags;
import de.audi.tghu.navi.app.map.context.CtxFreeMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.tmc.TmcListElement;
import org.dsi.ifc.tmc.TmcMessage;

public class CtxTMCMap
extends CtxFreeMap
implements CTags.HasDefaultZoom,
CTags.HasZoomArea {
    public CtxTMCMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enter() {
        this.getLogChannel().log(10000000, "CtxTMCMap#enter()");
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        iMapRequest.setViewType(0);
        iMapRequest.setMode(2);
        iMapRequest.setRotation((short)0);
        super.enter();
        this.container.sMessage = null;
        this.container.sTMCNumber = 0;
        this.container.sTMCTotal = 0;
        this.container.sMessageId = -1L;
        this.shutdownAdditionalInfos();
        Rect rect = this.getVisibleArea();
        int n = rect.kordX + (rect.diffX >> 1);
        int n2 = rect.kordY + (rect.diffY >> 1);
        this.setHotPoint(n, n2);
        this.updateCrosshairsColor();
        this.getViews().getMainMapView().setOptionIconVisible(false);
        iMapRequest.setGeneralPoiVisibility(false);
        this.focusOnTmc();
    }

    public void exit() {
        super.exit();
        this.getMap().getMVRequest().ensureTMCVisibility(0L);
        this.getViews().getMainMapView().setOptionIconVisible(true);
    }

    public void updateViewFreeze(boolean bl) {
        this.getLogChannel().log(10000000, "CtxTMCMap#updateViewFreeze( %1 )", bl);
        super.updateViewFreeze(bl);
    }

    protected void setVisibleArea() {
        this.getLogChannel().log(10000000, "CtxTMCMap#setVisibleArea()");
        super.setVisibleArea();
    }

    public void mapEntered() {
        this.getLogChannel().log(1000000, "CtxTMCMap#mapEntered()");
        int n = this.naviMap.getActiveContextIndex();
        if (n == 1 || n == 2) {
            this.getLogChannel().log(10000, "CtxTMCMap#mapEntered(): Map is not ready.");
            return;
        }
        this.naviMap.switchToContext(18);
    }

    public void mapLeft() {
        this.getLogChannel().log(1000000, "CtxTMCMap#mapLeft()");
        this.naviMap.switchToContext(3);
    }

    private void focusOnTmc() {
        this.getLogChannel().log(10000000, "CtxTMCMap#focusOnTmc()");
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        if (this.container.sTmcNavRectangle != null) {
            iMapRequest.setMapViewPortByWGS84Rectangle(this.container.sTmcNavRectangle, this.getZoomHandler().getZoomListIndex(this.getDefaultZoomLevel()));
        }
        iMapRequest.showTMCMessages(true);
        if (this.container.sTmcMessageIds != null && this.container.sTmcMessageIds.length != 0) {
            iMapRequest.ensureTMCVisibility(this.container.sTmcMessageIds[0]);
        }
        if (this.container.sTmcListElement != null) {
            this.showToolTip(this.container.sTmcListElement);
        } else if (this.container.tmcMessageToBeShown != null) {
            this.showToolTip(this.container.tmcMessageToBeShown);
        }
    }

    private void showToolTip(TmcMessage tmcMessage) {
        String string = this.naviMap.getTooltipFormatter().formatTMC(tmcMessage);
        ExtRenderingInfo extRenderingInfo = null;
        if (tmcMessage.getRoadNumber() != null) {
            extRenderingInfo = this.naviMap.getIconHandler().resolveStreetIconResourceID(tmcMessage.getStreetSignId(), tmcMessage.getRoadNumber().length());
        }
        int[] nArray = tmcMessage.getIconListId();
        int n = -1;
        if (nArray != null && nArray.length > 0) {
            n = this.naviMap.getIconHandler().resolveTMCIconResourceID(nArray[0], 0);
        }
        this.getLogChannel().log(1000000, "CtxTMCMap#showToolTip() - tooltip text: %1", (Object)string);
        MapItemSelectionInfo mapItemSelectionInfo = MapItemSelectionInfo.create(null, this.getLogChannel());
        mapItemSelectionInfo.textDescriptionSingleLine = string;
        mapItemSelectionInfo.tmc_roadSignInfo = extRenderingInfo;
        mapItemSelectionInfo.tmc_roadNr = tmcMessage.getRoadNumber();
        mapItemSelectionInfo.tmc_eventIconID = n;
        mapItemSelectionInfo.tmcMessage = tmcMessage;
        this.getMap().getViews().getMainMapView().showToolTipTMC(mapItemSelectionInfo);
    }

    public void showToolTip(TmcListElement tmcListElement) {
        if (tmcListElement == null) {
            this.getLogChannel().log(100000, "CtxTMCMap#showToolTip() - tmcListElement is null!");
            return;
        }
        this.getLogChannel().log(10000000, "CtxTMCMap#showToolTip( %1 )", (Object)tmcListElement);
        if (tmcListElement.message != null) {
            TmcMessage tmcMessage = tmcListElement.message;
            this.showToolTip(tmcMessage);
        } else {
            String string = this.naviMap.getTooltipFormatter().formatTMC(tmcListElement);
            ExtRenderingInfo extRenderingInfo = null;
            if (tmcListElement.getRoadNumber() != null) {
                extRenderingInfo = this.naviMap.getIconHandler().resolveStreetIconResourceID(tmcListElement.getStreetSignId(), tmcListElement.getRoadNumber().length());
            }
            int[] nArray = tmcListElement.iconIdList;
            int n = -1;
            if (nArray != null && nArray.length > 0) {
                n = this.naviMap.getIconHandler().resolveTMCIconResourceID(nArray[0], 0);
            }
            this.getLogChannel().log(1000000, "CtxTMCMap#showToolTip() - tooltip text: %1", (Object)string);
            MapItemSelectionInfo mapItemSelectionInfo = MapItemSelectionInfo.create(null, this.getLogChannel());
            mapItemSelectionInfo.textDescriptionSingleLine = string;
            mapItemSelectionInfo.tmc_roadSignInfo = extRenderingInfo;
            mapItemSelectionInfo.tmc_roadNr = tmcListElement.getRoadNumber();
            mapItemSelectionInfo.tmc_eventIconID = n;
            mapItemSelectionInfo.tmcMessage = null;
            this.getMap().getViews().getMainMapView().showToolTipTMC(mapItemSelectionInfo);
        }
    }

    public void increment(int n, int n2) {
        super.increment(n, n2);
        this.tmcToolTipHandling(this.getZoomHandler().getZoom());
    }

    private void tmcToolTipHandling(float f2) {
        boolean bl = this.naviMap.getMVResponseControl().getViewFreeze();
        if (this.container.sMessage != null && !bl && f2 <= 100000.0f) {
            this.getLogChannel().log(10000000, "CtxTMCMap#tmcToolTipHandling(): requesting ToolTip %1", (Object)this.container.sMessage);
            String string = this.container.sMessage;
            this.naviMap.getMapTooltip().showToolTip(string, this.getCrosshairHotPointX(), this.getCrosshairHotPointY(), this.container.sPositionInfo, null, false, false, null);
        } else {
            this.getLogChannel().log(10000000, "CtxTMCMap#tmcToolTipHandling(): hiding ToolTip, mapFrozen: %1, zoomLevel: %2m", bl, (Object)Float.toString(f2));
            this.hideToolTip();
        }
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        if (n != 400447) {
            super.itemSelected(n, n2, n3, n4);
        }
    }

    public void enableAutomaticRouteDiversion(boolean bl) {
        this.getLogChannel().log(1000000, "CtxTMCMap#enableAutomaticRouteDiversion(%1)", bl);
        super.enableAutomaticRouteDiversion(bl);
    }

    public void updateZoomListIndex(int n) {
    }

    public void updateMapOrientation(int n) {
    }

    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
    }

    public void updateInfoForPosition(PosInfo[] posInfoArray) {
    }

    public float getDefaultZoomLevel() {
        return 3000.0f;
    }

    protected void onHKBackClicked() {
        this.getLogChannel().log(10000000, "CtxTMCMap#onHKBackClicked()");
        super.onHKBackClicked();
        this.getGUI().fireHKBackEvent();
    }

    public void joystick(int n, int n2) {
    }

    protected int getMixedListOffset() {
        return 0;
    }

    protected void onDDSClicked() {
        if (this.container.tmcMessageToBeShown != null) {
            this.getLogChannel().log(1000000, "CtxTMCMap#onDDSClicked() - selection event received");
            this.naviMap.getNaviInterface().getTMCGateWay().fillDetailScreen(this.container.tmcMessageToBeShown);
            this.naviMap.getNaviInterface().startDestinationDetailsTMC(this.container.tmcMessageToBeShown);
            this.naviMap.getGuiInterface().setOptMenuType(2);
            this.env.getChoiceModel(401624).setValue(0);
            if (Util.isPreviewMapPresent(this.env.getFramework())) {
                this.getMap().getMapManager().getPreviewMapHandler().setPreviewMapCallbackHandler(this.getMap().getNaviInterface().getDetailsScreen());
            }
            this.naviMap.getGuiInterface().fireModelEvent(401099);
        }
    }
}

