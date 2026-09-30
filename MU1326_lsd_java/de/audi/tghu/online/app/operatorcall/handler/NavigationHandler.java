/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.operatorcall.handler;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.IFormattingRequest;
import de.audi.atip.interapp.INaviFormattingService;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.interapp.online.IOperatorCallNaviService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.online.app.Online;
import de.audi.tghu.online.app.operator.porsche.ConciergeCallModelHandlerPorscheCommon;
import de.audi.tghu.online.app.operatorcall.AbstractOperatorCallMain;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractModelHandler;
import de.audi.tghu.online.app.operatorcall.abstractclasses.AbstractOperatorCall;
import de.audi.tghu.online.app.operatorcall.data.PoiResultListRow;
import de.audi.tghu.online.app.operatorcall.handler.TestHandler;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallData;
import org.dsi.ifc.online.OperatorCallResult;

public class NavigationHandler
implements IOperatorCallNaviService {
    private final LogChannel logChannel = Online.getInstance().getOperatorCallLogChannel();
    private NaviService naviService;
    private ChoiceModelApp naviModel;
    private IPreviewMap previewMap;
    private int enterMode = 0;
    private AbstractOperatorCallMain operatorCall;
    private INaviFormattingService naviFormattingService;
    private static final int SHOW_DETAIL_SCREEN = 0;
    private static final int ADD_TO_FAVOURITE = 1;
    private static final int ADD_TO_CONTACT = 2;

    public NavigationHandler(ChoiceModelApp choiceModelApp, AbstractOperatorCallMain abstractOperatorCallMain) {
        this.naviModel = choiceModelApp;
        this.operatorCall = abstractOperatorCallMain;
    }

    public void setNaviService(NaviService naviService) {
        if (naviService == null) {
            this.logChannel.log(1000000, "NavigationHandler#setNaviService: NaviService is null. Removing naviService");
            this.naviService = naviService;
            return;
        }
        if (this.naviService != null) {
            this.logChannel.log(100000, "NavigationHandler#setNaviService: NaviService already exists. Ignoring new NaviService!");
            return;
        }
        this.logChannel.log(1000000, "NavigationHandler#setNaviService: New Naviservice is available");
        this.naviService = naviService;
    }

    public boolean isNaviServiceAvailable() {
        boolean bl = this.naviService != null;
        boolean bl2 = TestHandler.isNavSimulation();
        this.logChannel.log(10000000, "NavigationHandler#isNaviServiceAvailable: real = %1, simulation = %2", bl, bl2);
        return this.naviService != null || TestHandler.isNavSimulation();
    }

    public OperatorCallData getCarPositionData(boolean bl) {
        NavLocationWgs84 navLocationWgs84 = null;
        NavLocationWgs84 navLocationWgs842 = null;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        if (!bl) {
            this.logChannel.log(100000, "NavigationHandler#getCarPositionData: transmission is not allowed");
            return new OperatorCallData(n2, n, navLocationWgs84, navLocationWgs842, n3);
        }
        if (this.naviService == null) {
            this.logChannel.log(100000, "NavigationHandler#getCarPositionData: naviService is not available");
            return new OperatorCallData(n2, n, navLocationWgs84, navLocationWgs842, n3);
        }
        NavLocation navLocation = this.naviService.getCurrentCarPosition();
        if (navLocation != null) {
            navLocationWgs84 = new NavLocationWgs84(navLocation.getLongitude(), navLocation.getLatitude());
            n3 += 4;
            n = navLocation.getAltitude();
            n3 += 2;
            n2 = this.naviService.getCurrentCarHeading();
            ++n3;
        } else {
            this.logChannel.log(100000, "NavigationHandler#getCarPositionData: no current car position available");
        }
        NavLocation navLocation2 = this.naviService.getLastDestination();
        if (navLocation2 != null) {
            navLocationWgs842 = new NavLocationWgs84(navLocation2.getLongitude(), navLocation2.getLatitude());
            n3 += 8;
        } else {
            this.logChannel.log(100000, "NavigationHandler#getCarPositionData: no car destination available");
        }
        return new OperatorCallData(n2, n, navLocationWgs84, navLocationWgs842, n3);
    }

    public NaviService getNaviService() {
        return this.naviService;
    }

    public boolean startRouteGuidance(String string, NavLocationWgs84 navLocationWgs84, AbstractOperatorCall abstractOperatorCall) {
        if (this.naviService != null) {
            NaviOnlineService naviOnlineService = this.naviService.getNaviOnlineService();
            if (naviOnlineService == null || !naviOnlineService.getIsNaviFullyOperable() || navLocationWgs84 == null) {
                if (naviOnlineService == null) {
                    this.logChannel.log(100000, "NavigationHandler#startRouteGuidance: NaviOnlineService is null!");
                } else if (navLocationWgs84 == null) {
                    this.logChannel.log(100000, "NavigationHandler#startRouteGuidance: Location object is null!");
                } else {
                    this.logChannel.log(100000, "NavigationHandler#startRouteGuidance: NaviOnlineService is not fully operable!");
                }
                if (abstractOperatorCall != null) {
                    AbstractModelHandler abstractModelHandler = abstractOperatorCall.getModelHandler();
                    abstractModelHandler.setCurrentState(12);
                    abstractModelHandler.showDefaultError(true, 2);
                }
                return false;
            }
            int n = navLocationWgs84.getLatitude();
            int n2 = navLocationWgs84.getLongitude();
            String string2 = "POI ID";
            Buffer buffer = new Buffer();
            buffer.append("lat = ");
            buffer.append(n);
            buffer.append(", lon = ");
            buffer.append(n2);
            buffer.append(", poiName = ");
            buffer.append(string);
            buffer.append(", naviModelID =");
            buffer.append(this.naviModel.getID());
            buffer.append(", destinationID = ");
            buffer.append(string2);
            this.logChannel.log(1000000, "NavigationHandler#startRouteGuidance: Starting route guidance with %1", (Object)buffer.toString());
            naviOnlineService.startRouteGuidance(navLocationWgs84, string, this.naviModel, string2);
            this.logChannel.log(10000000, "NavigationHandler#startRouteGuidance: naviModel = %1", (Object)this.naviModel);
            return true;
        }
        this.logChannel.log(100000, "NavigationHandler#startRouteGuidance: NaviService is null!");
        if (abstractOperatorCall != null) {
            abstractOperatorCall.getModelHandler().showDefaultError(true, 2);
        }
        return false;
    }

    public void setPreviewMap(IPreviewMap iPreviewMap) {
        if (this.previewMap != null && iPreviewMap != null) {
            this.logChannel.log(100000, "NavigationHandler#setPreviewMap: previewMap already exists! Ignoring ...");
            return;
        }
        this.previewMap = iPreviewMap;
    }

    public void showPreviewMap(NavLocationWgs84[] navLocationWgs84Array) {
        this.logChannel.log(1000000, "NavigationHandler#showPreviewMap(locations): number of locations = %1", (long)navLocationWgs84Array.length);
        if (this.previewMap != null) {
            this.previewMap.setPreviewLocationsForOperatorCall(navLocationWgs84Array, 4, null, null);
        } else {
            this.logChannel.log(100000, "NavigationHandler#showPreviewMap(location): previewMap is null! Cannot show preview");
        }
    }

    public void showPreviewMapForLocationConcierge(NavLocationWgs84 navLocationWgs84, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logChannel.log(1000000, "NavigationHandler#showPreviewMapForLocationConcierge(location): latitude = %1, longitude = %2", (long)navLocationWgs84.getLatitude(), (long)navLocationWgs84.getLongitude());
        this.logChannel.log(1000000, "NavigationHandler#showPreviewMapForLocationConcierge(location): firstLine = %1 secondLine = %2", (Object)guiTooltipInformationContainer.toolTipTwoLinesLine1st, (Object)guiTooltipInformationContainer.toolTipTwoLinesLine2nd);
        if (this.previewMap != null) {
            this.previewMap.setPreviewLocationConcierge(navLocationWgs84, 4, null, guiTooltipInformationContainer);
        } else {
            this.logChannel.log(100000, "NavigationHandler#showPreviewMap(location): previewMap is null! Cannot show preview.");
        }
    }

    public void showPreviewMap(NavLocationWgs84 navLocationWgs84) {
        this.logChannel.log(1000000, "NavigationHandler#showPreviewMap(location): latitude = %1, longitude = %2", (long)navLocationWgs84.getLatitude(), (long)navLocationWgs84.getLongitude());
        NavLocation navLocation = new NavLocation();
        navLocation.latitude = navLocationWgs84.getLatitude();
        navLocation.longitude = navLocationWgs84.getLongitude();
        if (this.previewMap != null) {
            this.previewMap.setPreviewLocationAroundCCP(navLocation, 3, null, null);
        } else {
            this.logChannel.log(100000, "NavigationHandler#showPreviewMap(location): previewMap is null! Cannot show preview.");
        }
    }

    public void enterOperatorCall(int n, int n2) {
        this.setEnterMode(n2);
        this.operatorCall.enterServiceByOtherContext(n);
    }

    public int getEnterMode() {
        return this.enterMode;
    }

    public void setEnterMode(int n) {
        this.enterMode = n;
    }

    public boolean poiSelected(PoiResultListRow poiResultListRow, AbstractOperatorCall abstractOperatorCall) {
        this.logChannel.log(1000000, "NavigationHandler#poiSelected: enterMode = %1", (long)this.enterMode);
        if (poiResultListRow == null || this.naviService == null) {
            this.logChannel.log(100000, "NavigationHandler#poiSelected: result = %1, naviService = %2", (Object)poiResultListRow, (Object)this.naviService);
            AbstractModelHandler abstractModelHandler = abstractOperatorCall.getModelHandler();
            abstractModelHandler.setCurrentState(11);
            abstractModelHandler.showDefaultError(true, 2);
            return false;
        }
        switch (this.enterMode) {
            case 0: {
                return this.startRouteGuidance(poiResultListRow.getName(), poiResultListRow.getLocation(), abstractOperatorCall);
            }
        }
        OperatorCallResult operatorCallResult = poiResultListRow.getOperatorCallResult();
        this.logChannel.log(1000000, "NavigationHandler#poiSelected: call sendOperatorCallResult with %1 with entermode = %2", (Object)operatorCallResult, (long)this.enterMode);
        this.naviService.sendOperatorCallResult(poiResultListRow.getOperatorCallResult(), this.enterMode);
        abstractOperatorCall.triggerJumpToNavi();
        return false;
    }

    public boolean addToFavorite(OperatorCallResult operatorCallResult) {
        if (operatorCallResult == null || this.naviService == null) {
            this.logChannel.log(100000, "NavigationHandler#addToFavorite: poi = %1, naviService = %2", (Object)operatorCallResult, (Object)this.naviService);
            return false;
        }
        int n = 1;
        this.logChannel.log(1000000, "NavigationHandler#addToFavorite: call sendOperatorCallResult with %1 with entermode = %2", (Object)operatorCallResult, (long)n);
        this.naviService.sendOperatorCallResult(operatorCallResult, n);
        return true;
    }

    public boolean addToContact(OperatorCallResult operatorCallResult) {
        if (operatorCallResult == null || this.naviService == null) {
            this.logChannel.log(100000, "NavigationHandler#addToContact: poi = %1, naviService = %2", (Object)operatorCallResult, (Object)this.naviService);
            return false;
        }
        int n = 2;
        this.logChannel.log(1000000, "NavigationHandler#addToContact: call sendOperatorCallResult with %1 with entermode = %2", (Object)operatorCallResult, (long)n);
        this.naviService.sendOperatorCallResult(operatorCallResult, n);
        return true;
    }

    public boolean showDetails(OperatorCallResult operatorCallResult) {
        if (operatorCallResult == null || this.naviService == null) {
            this.logChannel.log(100000, "NavigationHandler#showDetails: poi = %1, naviService = %2", (Object)operatorCallResult, (Object)this.naviService);
            return false;
        }
        int n = 0;
        this.logChannel.log(1000000, "NavigationHandler#showDetails: call sendOperatorCallResult with %1 with entermode = %2", (Object)operatorCallResult, (long)n);
        this.naviService.sendOperatorCallResult(operatorCallResult, n);
        return true;
    }

    public boolean showInMap(OperatorCallResult operatorCallResult, int n) {
        if (operatorCallResult == null || this.naviService == null) {
            this.logChannel.log(100000, "NavigationHandler#showInMap: poi = %1, naviService = %2", (Object)operatorCallResult, (Object)this.naviService);
            return false;
        }
        NavLocationWgs84 navLocationWgs84 = operatorCallResult.getLocation();
        if (n == 2) {
            boolean bl = true;
            this.logChannel.log(1000000, "NavigationHandler#showInMap: call destOptShowInMap with location %1 with showPin = %2", (Object)navLocationWgs84, (Object)Boolean.toString(bl));
            this.naviService.destOptShowInMap(navLocationWgs84, bl, true);
        } else {
            this.logChannel.log(1000000, "NavigationHandler#showInMap: call setOperatorCallResultLocation with location %1 with showPin = %2", (Object)navLocationWgs84);
            this.naviService.setOperatorCallResultLocation(operatorCallResult.getLocation());
        }
        return true;
    }

    public void showCcpInMap() {
        this.logChannel.log(1000000, "NavigationHandler#showCcpInMap called");
        if (this.previewMap == null) {
            this.logChannel.log(100000, "NavigationHandler#showCcpInMap(): previewMap is null! Cannot show preview");
            return;
        }
        this.previewMap.setPreviewAreaAroundCCP(3);
    }

    public void requestRRDCalculation(NavLocation[] navLocationArray, NaviService.IRRDCallback iRRDCallback) {
        if (navLocationArray == null) {
            this.logChannel.log(1000000, "NavigationHandler#requestRRDCalculation poi is null stopping rrd calculation");
            this.naviService.stopRRDCalculation();
            return;
        }
        this.naviService.calculateRRDForNavArray(navLocationArray, iRRDCallback);
    }

    public void setNaviFormattingService(INaviFormattingService iNaviFormattingService) {
        this.naviFormattingService = iNaviFormattingService;
    }

    public INaviFormattingService getNaviFormattingService() {
        return this.naviFormattingService;
    }

    public IFormattingRequest getFormattingRequestFromPoiResult(ConciergeCallModelHandlerPorscheCommon.ConciergeResultPoi conciergeResultPoi) {
        IFormattingRequest iFormattingRequest = this.naviFormattingService.createNewFormattingRequest();
        iFormattingRequest.setCity(conciergeResultPoi.city);
        iFormattingRequest.setStreet(conciergeResultPoi.street);
        iFormattingRequest.setZip(conciergeResultPoi.zip);
        return iFormattingRequest;
    }
}

