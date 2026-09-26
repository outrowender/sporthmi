/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview;

import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstractMapStateSingle;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;

public class PreviewMapHandlerAbstractMapStateSingle$PreviewMapState {
    public static final int STATE_CCP;
    public static final int STATE_ROAD_SEGMENT;
    public static final int STATE_ROUTE;
    public static final int STATE_TMC_RECTANGLE;
    public static final int STATE_TMC_EVENT;
    public static final int STATE_POIS;
    public static final int STATE_LOCATION;
    public static final int STATE_SELENA_ROUTE;
    public static final int STATE_OFFROAD_ROUTE;
    public static final int STATE_PREVIEWMAP_HIDDEN;
    public static final int STATE_TPEG_POI;
    public int previewMapState = -1;
    public int xLeft;
    public int xRight;
    public int yBottom;
    public int yUp;
    public long startDistance;
    public long endDistance;
    public boolean completeRoute;
    public long[] messageIds;
    public NavRectangle rectangle;
    public long tmcEvent;
    public int pivotStyle;
    public NavLocation[] pois;
    public boolean forSdsShowNumberedMapPins;
    public boolean forTourShowNumberedMapPins;
    public boolean centerOnPivot;
    public NavLocationWgs84 locationPivotOrCcpWgs84;
    public NavLocationWgs84[] locations;
    public float defaultZoomLevel;
    public boolean previewMapWasReady;
    public NavSegmentID[] routeId;
    public int applicationContext = -1;
    public NavLocation toolTipLocation;
    public String toolTipLine1;
    public String toolTipLine2;
    public boolean isOnlinePOI;
    public boolean isConciergePOI;
    public boolean isTPEGPOI;
    private final /* synthetic */ PreviewMapHandlerAbstractMapStateSingle this$0;

    public PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(PreviewMapHandlerAbstractMapStateSingle previewMapHandlerAbstractMapStateSingle) {
        this.this$0 = previewMapHandlerAbstractMapStateSingle;
    }

    public void apply(IPreviewMap iPreviewMap) {
        this.this$0.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStateSingle#PreviewMapState#apply() appCtx=%1 state=%2", (long)this.applicationContext, (long)this.previewMapState);
        switch (this.previewMapState) {
            case 0: {
                this.this$0.setPreviewAreaAroundCCP(-1);
                break;
            }
            case 1: {
                this.this$0.setPreviewRoadSegment(this.xLeft, this.xRight, this.yBottom, this.yUp, this.startDistance, this.endDistance);
                break;
            }
            case 2: {
                this.this$0.setPreviewRoute(this.completeRoute, -1, null, null);
                break;
            }
            case 3: {
                this.this$0.setPreviewTMCEvents(this.messageIds, this.rectangle);
                break;
            }
            case 6: {
                this.this$0.focusOnLocationsAndCreateNewPreviewMapStateAsCurrent(this.locations, this.forSdsShowNumberedMapPins, this.forTourShowNumberedMapPins, this.centerOnPivot, this.locationPivotOrCcpWgs84, this.pivotStyle, this.defaultZoomLevel);
                break;
            }
            case 5: {
                this.this$0.focusOnPOIsAndCreateNewPreviewMapState(this.pois, this.forSdsShowNumberedMapPins, this.forTourShowNumberedMapPins, this.centerOnPivot, this.locationPivotOrCcpWgs84, this.pivotStyle, this.defaultZoomLevel);
                break;
            }
            case 4: {
                this.this$0.setPreviewTMCEvent(this.tmcEvent);
                break;
            }
            case 7: {
                this.this$0.setPreviewPredictiveNavigationRoutes(this.routeId, -1, null, null);
                break;
            }
            case 8: {
                this.this$0.setPreviewRouteOffroad(this.routeId[0], -1, null, null);
                break;
            }
            case 9: {
                this.this$0.hidePreviewMap();
                break;
            }
            default: {
                this.this$0.logger.log(10000, "PreviewMapHandlerAbstractMapStateSingle#PreviewMapState#apply() - unknown state: %1 ", (long)this.previewMapState);
            }
        }
    }

    public String toString() {
        switch (this.previewMapState) {
            case 0: {
                return "CCP";
            }
            case 1: {
                return "ROAD_SEGMENT";
            }
            case 2: {
                return "ROUTE";
            }
            case 3: {
                return "TMC_RECTANGLE";
            }
            case 4: {
                return "TMC_EVENT";
            }
            case 5: {
                return "POIS";
            }
            case 6: {
                return "LOCATION";
            }
            case 7: {
                return "SELENA_ROUTE";
            }
            case 8: {
                return "OFFROAD_ROUTE";
            }
        }
        return Integer.toString(this.previewMapState);
    }
}

