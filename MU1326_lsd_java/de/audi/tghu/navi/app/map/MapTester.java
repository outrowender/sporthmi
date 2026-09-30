/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.model.BaseListRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.property.PropertyModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.interapp.NavigationUtilities;
import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.NaviInterface;
import de.audi.tghu.navi.app.map.constants.SwitchContextEnum;
import de.audi.tghu.navi.app.map.context.CtxRCCIMap;
import de.audi.tghu.navi.app.map.context.CtxRubberBand;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler;
import de.audi.tghu.navi.app.map.instances.MapMain;
import de.audi.tghu.navi.app.map.minimap.AbstractTrafficMiniMap;
import de.audi.tghu.navi.app.map.utils.MapDebugUtils;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.StringUtils;
import org.dsi.ifc.asiatrafficinfomenu.Interrupt;
import org.dsi.ifc.asiatrafficinfomenu.ResourceInformation;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationDescriptor;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.ManeuverElement;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RouteSectionInfo;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.online.OSRNotifyProperties;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;
import org.dsi.ifc.tmc.TmcMessage;
import org.dsi.ifc.trafficregulation.TrafficSignInformation;

public class MapTester {
    private final MapManager mm;
    private final NavigationEnv env;
    public static final int IRQ_WARNING = 50;
    public static final int IRQ_VOICE = 51;
    public static final int IRQ_MINI_MAP = 52;
    public static final int TIMING_OUT_CONTENT_ID = 30201;
    public static final int NO_MORE_EXISTING_CONTENT_ID = 30202;
    public static final int CONTENT_ID_WITHOUT_RESOURCE_LOCATOR = 30203;

    public MapTester(MapManager mapManager) {
        this.mm = mapManager;
        this.env = this.mm.getNavigationEnv();
    }

    private LogChannel getLogChannel() {
        return this.mm.getLogChannel();
    }

    private MapMain getMapMain() {
        return this.mm.getMapMain();
    }

    private AbstractMap getMapKombi() {
        return this.mm.getMapKombi();
    }

    private AbstractMap getMinorMap() {
        return this.mm.getMinorMap();
    }

    public void execute(String string) {
        this.getLogChannel().log(1000000, "MapTester#doGeneralTest( %1 )", (Object)string);
        if (string.equals("cmdMapSetup()")) {
            this.getLogChannel().log(1000000, "%1\n%2", (Object)this.mm.getSetupMain(), (Object)this.mm.getSetupKombi());
        } else {
            String[] stringArray = StringUtils.splitString(string, ' ');
            int n = Integer.parseInt(stringArray[0]);
            if (0 <= n && n <= 9) {
                this.handle00x(n, stringArray);
            } else if (10 <= n && n <= 19) {
                this.handle01x(n, stringArray);
            } else if (20 <= n && n <= 29) {
                this.handle02x(n, stringArray);
            } else if (3000 <= n && n <= 3999) {
                this.handle3xxx(n, stringArray);
            } else {
                IMapRequest iMapRequest = this.getMapMain().getMVRequest();
                block0 : switch (n) {
                    case 100: {
                        IMapRequest iMapRequest2 = this.getMinorMap().getMVRequest();
                        iMapRequest2.setMapPosition(new NavLocationWgs84(136307906, 581757572));
                        break;
                    }
                    case 101: {
                        IMapRequest iMapRequest3 = this.getMinorMap().getMVRequest();
                        iMapRequest3.setMapPosition(new NavLocationWgs84(138125346, 574289702));
                        break;
                    }
                    case 200: {
                        iMapRequest.setMapPosition(new NavLocationWgs84(136307906, 581757572));
                        break;
                    }
                    case 201: {
                        iMapRequest.setMapPosition(new NavLocationWgs84(138125346, 574289702));
                        break;
                    }
                    case 203: {
                        if (this.getMapMain().getMapPosition() != null) {
                            this.getLogChannel().log(1000000, "lat=%1, long=%2", (long)this.getMapMain().getMapPosition().latitude, (long)this.getMapMain().getMapPosition().longitude);
                            break;
                        }
                        this.getLogChannel().log(1000000, "mapPosition = null");
                        break;
                    }
                    case 309: {
                        iMapRequest.dragMap((short)8, (short)0);
                        break;
                    }
                    case 300: {
                        iMapRequest.dragMap((short)0, (short)8);
                        break;
                    }
                    case 303: {
                        iMapRequest.dragMap((short)-8, (short)0);
                        break;
                    }
                    case 306: {
                        iMapRequest.dragMap((short)0, (short)-8);
                        break;
                    }
                    case 310: {
                        IRouteInfo iRouteInfo = this.getMapMain().getRouteInfo();
                        if (iRouteInfo.isMixedListVisible()) {
                            this.getLogChannel().log(1000000, "MapTester#doGeneralTest() - RouteInfo is visible, hide it.");
                            iRouteInfo.hide();
                            break;
                        }
                        this.getLogChannel().log(1000000, "MapTester#doGeneralTest() - RouteInfo is invisible, show it.");
                        break;
                    }
                    case 311: {
                        this.mm.getViews().getMainMapView().showToolTip(stringArray[1] + "\n" + "====xxcvbnm");
                        break;
                    }
                    case 312: {
                        this.mm.getViews().getMainMapView().showToolTip(stringArray[1] + "\n" + "====xxcvbnm", false, "yxxxx", -1);
                        break;
                    }
                    case 313: {
                        this.mm.getViews().getMainMapView().showToolTip(stringArray[1] + "\n" + "====xxcvbnm", true, "yxxxx", -1);
                        break;
                    }
                    case 320: {
                        iMapRequest.setRotation((short)90);
                        break;
                    }
                    case 321: {
                        this.getMapMain().getGuiInterface().stickN(401688, 0);
                        break;
                    }
                    case 400: {
                        CommandList commandList = this.getMapMain().getNaviInterface().getPOICategoryManager().fetchPOICategories(this.getMapMain().getCurrentMapStyle());
                        commandList.execute("Context#keyPressed()");
                        break;
                    }
                    case 401: {
                        this.getMapMain().getMVRequest().ehSetCategoryVisibilityToDefault(this.getMapMain().getCurrentMapStyle());
                        break;
                    }
                    case 402: {
                        this.getMapMain().getMVRequest().ehSetCategoryVisibility(this.getMapMain().getCurrentMapStyle(), new int[]{Integer.parseInt(stringArray[1])}, new boolean[]{Boolean.getBoolean(stringArray[2])});
                        break;
                    }
                    case 403: {
                        this.getMapMain().getMVRequest().setGeneralPoiVisibility(true);
                        break;
                    }
                    case 404: {
                        this.getMapMain().getMVRequest().setGeneralPoiVisibility(false);
                        break;
                    }
                    case 450: {
                        this.getMapMain().getGuiInterface().controlMixedList(1, 1);
                        break;
                    }
                    case 451: {
                        this.getMapMain().getGuiInterface().controlMixedList(2, 0);
                        break;
                    }
                    case 452: {
                        this.env.getFramework().getUtilThreadPool().execute(MapDebugUtils.createTestCase(this.getMapMain().getRouteInfo()));
                        break;
                    }
                    case 453: {
                        this.env.getFramework().getUtilThreadPool().execute(MapDebugUtils.createTestCase2(this.getMapMain().getRouteInfo()));
                        break;
                    }
                    case 454: {
                        this.env.getFramework().getUtilThreadPool().execute(MapDebugUtils.createTestCaseLaneGuidance(this.getMapMain().getRouteInfo()));
                        break;
                    }
                    case 455: {
                        this.env.getFramework().getUtilThreadPool().execute(MapDebugUtils.createTestCase3(this.getMapMain().getRouteInfo()));
                        break;
                    }
                    case 465: {
                        this.mm.getPartialPopupHandler().showOnlineTrafficWarningPPU(Integer.parseInt(stringArray[1]) == 1);
                        break;
                    }
                    case 500: {
                        this.getLogChannel().log(1000000, "MapTester#doGeneralTest() - set map mode");
                        this.getMapMain().getMVRequest().setMode(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 501: {
                        this.getLogChannel().log(1000000, "MapTester#doGeneralTest() - switch map context");
                        this.getMapMain().switchToContext(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 502: {
                        this.getLogChannel().log(1000000, "MapTester#doGeneralTest() - fetch POI categories.");
                        this.getMapMain().getActiveContext().keyPressed(400785, -1);
                        break;
                    }
                    case 503: {
                        this.getLogChannel().log(1000000, "MapTester#doGeneralTest() - set map view type");
                        this.getMapMain().getMVRequest().setViewType(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 600: {
                        if (stringArray.length > 1) {
                            this.mm.getViews().getSemidynRGView().showPopupBetterRouteAvailable(Long.parseLong(stringArray[1]));
                            break;
                        }
                        this.mm.getViews().getSemidynRGView().hidePopupBetterRouteAvailable();
                        break;
                    }
                    case 601: {
                        this.mm.getViews().getSemidynRGView().enterSemidynRGView();
                        break;
                    }
                    case 602: {
                        this.mm.getViews().getSemidynRGView().setRouteChangeInfo(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]), Long.parseLong(stringArray[3]), Long.parseLong(stringArray[4]));
                        break;
                    }
                    case 603: {
                        this.mm.getViews().getSemidynRGView().showPopupSemidynBlockMain();
                        break;
                    }
                    case 604: {
                        this.mm.getViews().getSemidynRGView().showPopupSemidynBetterMain();
                        break;
                    }
                    case 605: {
                        this.mm.getViews().getSemidynRGView().hidePopupSemidynBlockMain();
                        break;
                    }
                    case 606: {
                        this.mm.getViews().getSemidynRGView().hidePopupSemidynBetterMain();
                        break;
                    }
                    case 612: {
                        this.mm.getViews().getSemidynRGView().showShortInfo();
                        break;
                    }
                    case 620: {
                        this.getMapMain().getActiveContext().itemFocused(0, 0);
                        break;
                    }
                    case 621: {
                        this.getMapMain().getActiveContext().itemFocused(0, 1);
                        break;
                    }
                    case 622: {
                        this.getMapMain().getActiveContext().itemFocused(0, 2);
                        break;
                    }
                    case 623: {
                        ((CtxRCCIMap)this.getMapMain().getActiveContext()).increment(402387, 1);
                        break;
                    }
                    case 624: {
                        ((CtxRCCIMap)this.getMapMain().getActiveContext()).keyPressed(401004, 15);
                        break;
                    }
                    case 800: {
                        this.getLogChannel().log(1000000, "MapTester#doGeneralTest() - [Rubberband] init");
                        this.getMapMain().switchToContext(34);
                        break;
                    }
                    case 801: {
                        this.getLogChannel().log(1000000, "MapTester#doGeneralTest() - [Rubberband] drag route dx=%1, dy=%2", (long)Integer.parseInt(stringArray[1]), (long)Integer.parseInt(stringArray[2]));
                        if (this.getMapMain().getActiveContextIndex() == 34) {
                            this.getMapMain().getActiveContext().touchPadPositionMoved(-1, 1, 0, Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
                            break;
                        }
                        this.getLogChannel().log(10000, "MapTester#doGeneralTest() - please call rubberband init firstly.");
                        break;
                    }
                    case 802: {
                        break;
                    }
                    case 803: {
                        this.getLogChannel().log(1000000, "MapTester#doGeneralTest() - [Rubberband] finish");
                        if (this.getMapMain().getActiveContextIndex() == 34) {
                            ((CtxRubberBand)this.getMapMain().getActiveContext()).finishRubberband();
                            break;
                        }
                        this.getLogChannel().log(10000, "MapTester#doGeneralTest() - please call rubberband init firstly.");
                        break;
                    }
                    case 900: {
                        break;
                    }
                    case 901: {
                        break;
                    }
                    case 902: {
                        this.env.getChoiceModel(400683).setStatus(0);
                        break;
                    }
                    case 903: {
                        this.env.getChoiceModel(401124).setValue(0);
                        break;
                    }
                    case 904: {
                        this.env.getChoiceModel(401124).setValue(1);
                        break;
                    }
                    case 905: {
                        this.env.getChoiceModel(401126).setValue(0);
                        break;
                    }
                    case 906: {
                        this.env.getChoiceModel(401126).setValue(1);
                        break;
                    }
                    case 907: {
                        this.env.getChoiceModel(401126).setValue(2);
                        break;
                    }
                    case 908: {
                        int n2 = Integer.parseInt(stringArray[1]);
                        int n3 = Integer.parseInt(stringArray[2]);
                        this.getMapMain().getMVRequest().setCarPosition(new Point(n2, n3));
                        break;
                    }
                    case 909: {
                        break;
                    }
                    case 910: {
                        this.getMapMain().getZoomHandler().setZoomLevel(Float.parseFloat(stringArray[1]));
                        break;
                    }
                    case 911: {
                        this.getMapMain().getMVRequest().setHotPoint(new Point(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2])));
                        break;
                    }
                    case 912: {
                        this.getMapMain().getZoomHandler().setZoomArea(new Rect(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3]), Integer.parseInt(stringArray[4])));
                        break;
                    }
                    case 913: {
                        switch (Integer.parseInt(stringArray[1])) {
                            case 1: {
                                this.getMinorMap().getMVRequest().viewSetScreenViewportMaximum(new Rect(0, 0, Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3])));
                                break block0;
                            }
                            case 2: {
                                this.getMinorMap().getMVRequest().viewSetScreenViewport(new Rect(0, 0, Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3])));
                                break block0;
                            }
                            case 3: {
                                this.getMinorMap().getMVRequest().setViewPortBorder(Integer.parseInt(stringArray[2]));
                                break block0;
                            }
                        }
                        break;
                    }
                    case 914: {
                        switch (Integer.parseInt(stringArray[1])) {
                            case 1: {
                                this.getMapKombi().getZoomHandler().setZoomLevel(Float.parseFloat(stringArray[2]));
                                break block0;
                            }
                        }
                        break;
                    }
                    case 915: {
                        this.getLogChannel().log(10000000, "MapTester#toggleTMC()");
                        this.getMapMain().getMapDataContainer().sMapContentList.toggleTMC();
                        break;
                    }
                    case 916: {
                        this.env.getChoiceModel(401126).setValue(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 917: {
                        NavLocation navLocation = Util.getLocationFromGeoPos(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
                        this.mm.getMapInterface().destOptShowInMap(navLocation);
                        break;
                    }
                    case 918: {
                        NavLocation navLocation = new NavLocation();
                        navLocation.longitude = Integer.parseInt(stringArray[1]);
                        navLocation.latitude = Integer.parseInt(stringArray[2]);
                        this.getMapMain().getMVRequest().setLocationByLocation(navLocation);
                        break;
                    }
                    case 919: {
                        this.getMapMain().getMapFlagHandler().setPins(new MapPin[]{new MapPin(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]), 0, 0)});
                        break;
                    }
                    case 920: {
                        this.getMapMain().getMapFlagHandler().cleanPins(null);
                        break;
                    }
                    case 921: {
                        this.getMapMain().getMVRequest().setMapPosition(new NavLocationWgs84(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2])));
                        break;
                    }
                    case 924: {
                        this.getMapKombi().getZoomHandler().incrementWithDelay(1);
                        break;
                    }
                    case 925: {
                        this.getMapKombi().getZoomHandler().incrementWithDelay(-1);
                        break;
                    }
                    case 926: {
                        this.getMapKombi().switchToAShownContext();
                        break;
                    }
                    case 927: {
                        int n4 = this.env.getChoiceModel(401364).getValue();
                        this.env.getChoiceModel(401364).setValue(1 - n4);
                        if (n4 != 0) break;
                        BaseListModelApp baseListModelApp = this.env.getBaseListModel(401333);
                        baseListModelApp.removeAll();
                        EvoListRow evoListRow = new EvoListRow(0L, 2);
                        evoListRow.setInteger(0, 100);
                        evoListRow.setLong(1, 30000000L);
                        EvoListRow evoListRow2 = new EvoListRow(1L, 2);
                        evoListRow2.setInteger(0, 80);
                        evoListRow2.setLong(1, 9000000L);
                        baseListModelApp.append(new EvoListRow[]{evoListRow, evoListRow2});
                        break;
                    }
                    case 928: {
                        this.getMapMain().getMapDataContainer().sHomeAddress = stringArray.length > 1 ? Util.getLocationFromGeoPos(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2])) : null;
                        break;
                    }
                    case 929: {
                        this.mm.getMapInterface().toggleDayNightView();
                        break;
                    }
                    case 930: {
                        this.getLogChannel().log(1000000, "MapTester#930 - %1", (Object)this.mm.getViews().getMapSetupView());
                        break;
                    }
                    case 931: {
                        BaseListRow baseListRow;
                        ListModelApp listModelApp = this.mm.guiEventDispatcher.getmScreenLayout();
                        if (listModelApp == null || (baseListRow = listModelApp.getRow(0)) == null) break;
                        for (int i2 = 0; i2 < baseListRow.getColumnCount(); ++i2) {
                            this.getLogChannel().log(10000000, "%1: %2", (long)i2, (long)baseListRow.getInteger(i2));
                        }
                        break;
                    }
                    case 932: {
                        this.getMapMain().getMVRequest().setHorizonMarkerVisibility(true);
                        break;
                    }
                    case 933: {
                        this.getMapMain().getMVRequest().setLandmarksVisible(false);
                        break;
                    }
                    case 934: {
                        switch (Integer.parseInt(stringArray[1])) {
                            case 1: {
                                this.getMapMain().getMVRequest().viewSetScreenViewportMaximum(new Rect(0, 0, Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3])));
                                break block0;
                            }
                            case 2: {
                                this.getMapMain().getMVRequest().viewSetScreenViewport(new Rect(0, 0, Integer.parseInt(stringArray[2]), Integer.parseInt(stringArray[3])));
                                break block0;
                            }
                            case 3: {
                                this.getMapMain().getMVRequest().setViewPortBorder(Integer.parseInt(stringArray[2]));
                                break block0;
                            }
                        }
                        break;
                    }
                    case 935: {
                        this.mm.getViews().getMainMapView().setTrafficDelay(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 936: {
                        PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray = new PoiOnlineSearchValuelistElement[10];
                        for (int i3 = 0; i3 < poiOnlineSearchValuelistElementArray.length; ++i3) {
                            poiOnlineSearchValuelistElementArray[i3] = new PoiOnlineSearchValuelistElement();
                            poiOnlineSearchValuelistElementArray[i3].longitude = this.mm.getMapMain().getMVResponseControl().getMapPosition().longitude + i3 * 2000;
                            poiOnlineSearchValuelistElementArray[i3].latitude = this.mm.getMapMain().getMVResponseControl().getMapPosition().latitude + i3 * 1500;
                            poiOnlineSearchValuelistElementArray[i3].type = (byte)2;
                            poiOnlineSearchValuelistElementArray[i3].url = "www.test.ve";
                            poiOnlineSearchValuelistElementArray[i3].name = "name " + i3;
                        }
                        OnlinePOIResultList onlinePOIResultList = new OnlinePOIResultList(this.getLogChannel());
                        onlinePOIResultList.updateResultList(poiOnlineSearchValuelistElementArray, null);
                        this.mm.getMapInterface().setRemoteHMIResultFlags(onlinePOIResultList);
                        this.mm.getMapInterface().enterRemoteHMIResultMap();
                        break;
                    }
                    case 937: {
                        PoiOnlineSearchValuelistElement[] poiOnlineSearchValuelistElementArray = new PoiOnlineSearchValuelistElement[10];
                        for (int i4 = 0; i4 < poiOnlineSearchValuelistElementArray.length; ++i4) {
                            poiOnlineSearchValuelistElementArray[i4] = new PoiOnlineSearchValuelistElement();
                            poiOnlineSearchValuelistElementArray[i4].longitude = this.mm.getMapMain().getMVResponseControl().getMapPosition().longitude + i4 * 2000;
                            poiOnlineSearchValuelistElementArray[i4].latitude = this.mm.getMapMain().getMVResponseControl().getMapPosition().latitude + i4 * 1500;
                            poiOnlineSearchValuelistElementArray[i4].type = (byte)2;
                            poiOnlineSearchValuelistElementArray[i4].url = "www.test.ve";
                            poiOnlineSearchValuelistElementArray[i4].name = "name " + i4;
                        }
                        OnlinePOIResultList onlinePOIResultList = new OnlinePOIResultList(this.getLogChannel());
                        onlinePOIResultList.updateResultList(poiOnlineSearchValuelistElementArray, null);
                        this.mm.getMapInterface().setOnlineResultFlags(onlinePOIResultList);
                        this.mm.getMapInterface().enterOnlineResultMap();
                        break;
                    }
                    case 938: {
                        int n5 = Integer.parseInt(stringArray[1]);
                        if (stringArray.length > 2) {
                            int n6 = Integer.parseInt(stringArray[2]);
                            this.mm.getMaps()[n6].getMVResponseGoogleCtrl().updateGoogleDataStatus(n5, 1);
                            break;
                        }
                        this.mm.getMapMain().getMVResponseGoogleCtrl().updateGoogleDataStatus(n5, 1);
                        break;
                    }
                    case 939: {
                        int n7 = Integer.parseInt(stringArray[1]);
                        this.mm.getMapInterface().setMapColor(n7);
                        break;
                    }
                    case 940: {
                        this.mm.getMapInterface().onlineStateChanged();
                        break;
                    }
                    case 941: {
                        PropertyModelApp propertyModelApp = this.env.getPropertyModel(401551);
                        propertyModelApp.setProperties(Integer.parseInt(stringArray[1]), new int[]{Integer.parseInt(stringArray[2])});
                        break;
                    }
                    case 942: {
                        int n8 = Integer.parseInt(stringArray[1]);
                        TrafficSignInformation trafficSignInformation = new TrafficSignInformation();
                        trafficSignInformation.highestPrioritySign = 1;
                        trafficSignInformation.trafficSignOne = n8;
                        trafficSignInformation.variant = 0x310000;
                        this.mm.naviInterface.getTrafficRegulationService().updateCurrentTrafficSign(trafficSignInformation, 1);
                        break;
                    }
                    case 943: {
                        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1, 168);
                        choiceModelApp.addHint(Integer.parseInt(stringArray[1]));
                        choiceModelApp.publishHints();
                        break;
                    }
                    case 944: {
                        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1, 168);
                        choiceModelApp.removeHint(Integer.parseInt(stringArray[1]));
                        choiceModelApp.publishHints();
                        break;
                    }
                    case 945: {
                        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1, 168);
                        choiceModelApp.addHint(4);
                        choiceModelApp.addHint(16);
                        choiceModelApp.publishHints();
                        choiceModelApp.removeHint(4);
                        choiceModelApp.removeHint(16);
                        choiceModelApp.publishHints();
                        break;
                    }
                    case 946: {
                        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1, 168);
                        choiceModelApp.removeHint(4);
                        choiceModelApp.removeHint(16);
                        choiceModelApp.publishHints();
                        choiceModelApp.addHint(4);
                        choiceModelApp.addHint(16);
                        choiceModelApp.publishHints();
                        break;
                    }
                    case 947: {
                        ((NaviInterface)this.mm.naviInterface).getNavigation().getInterAppService().setRouteOptionDynamic(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 948: {
                        int n9;
                        int n10 = Integer.parseInt(stringArray[1]);
                        LayerProperty[] layerPropertyArray = new LayerProperty[n10];
                        for (n9 = 0; n9 < n10; ++n9) {
                            layerPropertyArray[n9] = new LayerProperty("/gemib/models/GoogleEarthPOILayerIcon_places.png", "DummyLayer" + n9, n9, 0, 1);
                        }
                        if (stringArray.length > 2) {
                            n9 = Integer.parseInt(stringArray[2]);
                            this.mm.getMaps()[n9].getMVResponseGoogleCtrl().updateAvailableLayers(layerPropertyArray, 1);
                            break;
                        }
                        this.mm.getMapMain().getMVResponseGoogleCtrl().updateAvailableLayers(layerPropertyArray, 1);
                        break;
                    }
                    case 949: {
                        int n11 = Integer.parseInt(stringArray[1]);
                        int n12 = Integer.parseInt(stringArray[2]);
                        this.mm.getGoogleMapLicenseHandler().updateApplicationState(n11, n12);
                        break;
                    }
                    case 950: {
                        boolean bl = "1".equals(stringArray[1]) || "true".equals(stringArray[1]);
                        boolean bl2 = "1".equals(stringArray[2]) || "true".equals(stringArray[2]);
                        this.mm.getMapInterface().setOnlineMapDataConnectionLicenseStatus(bl, bl2);
                        break;
                    }
                    case 952: {
                        int n13 = 0;
                        int n14 = 0;
                        if (stringArray.length > 1) {
                            n13 = Integer.parseInt(stringArray[1]);
                            if (stringArray.length > 2) {
                                n14 = Integer.parseInt(stringArray[2]);
                            }
                        }
                        this.getMapMain().getMVRequest().dragMap((short)n13, (short)n14);
                        break;
                    }
                    case 953: {
                        TmcMessage tmcMessage = new TmcMessage();
                        tmcMessage.messageID = 2L;
                        tmcMessage.distanceToEvent = 2000L;
                        tmcMessage.eventText = new String[]{"Some accident happened", "Can not reach the destination"};
                        int n15 = NavigationUtilities.degreeToWgs84(3992036.0);
                        int n16 = NavigationUtilities.degreeToWgs84(3992056.0);
                        int n17 = NavigationUtilities.degreeToWgs84(1.16460457E7);
                        int n18 = NavigationUtilities.degreeToWgs84(1.16460458E7);
                        if (stringArray.length == 3) {
                            n15 = NavigationUtilities.degreeToWgs84(Double.parseDouble(stringArray[1]) * 100000.0);
                            n16 = NavigationUtilities.degreeToWgs84(Double.parseDouble(stringArray[1]) * 100000.0 - 0.2);
                            n18 = NavigationUtilities.degreeToWgs84(Double.parseDouble(stringArray[2]) * 100000.0);
                            n17 = NavigationUtilities.degreeToWgs84(Double.parseDouble(stringArray[2]) * 100000.0 + 0.2);
                            this.getLogChannel().log(10000000, "MapTester#953 (%1)", (Object)(Double.parseDouble(stringArray[1]) + ";" + Double.parseDouble(stringArray[2])));
                        } else if (Util.isHURegionCN()) {
                            n15 = NavigationUtilities.degreeToWgs84(3992036.0);
                            n16 = NavigationUtilities.degreeToWgs84(3992035.0);
                            n18 = NavigationUtilities.degreeToWgs84(1.16460456E7);
                            n17 = NavigationUtilities.degreeToWgs84(1.16460457E7);
                        } else if (Util.isHURegionJP()) {
                            n15 = NavigationUtilities.degreeToWgs84(3990874.2);
                            n16 = NavigationUtilities.degreeToWgs84(3990874.1);
                            n18 = NavigationUtilities.degreeToWgs84(1.39764625E7);
                            n17 = NavigationUtilities.degreeToWgs84(1.39764626E7);
                        }
                        NavRectangle navRectangle = new NavRectangle();
                        navRectangle.xLeft = n15;
                        navRectangle.xRight = n16;
                        navRectangle.yBottom = n17;
                        navRectangle.yUp = n18;
                        int n19 = 100;
                        this.mm.getMapInterface().indicateTrafficEventNoticeMap(tmcMessage, navRectangle, n19);
                        break;
                    }
                    case 954: {
                        this.mm.getMapInterface().enableRouteInfoComplete(false);
                        break;
                    }
                    case 955: {
                        this.getMapMain().getMVRequest().setMobilityHorizonVisibility(true);
                        break;
                    }
                    case 956: {
                        this.getMapMain().getActiveContext().updateMobilityHorizonStatus(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 957: {
                        this.mm.getMapInterface().notifyPowerListenerOnExitState();
                        break;
                    }
                    case 958: {
                        int n20 = Integer.parseInt(stringArray[1]);
                        int n21 = Integer.parseInt(stringArray[2]);
                        this.mm.getWeatherLicenseHandler().updateApplicationState(n20, n21);
                        break;
                    }
                    case 959: {
                        this.mm.getMapMain().forceSwitchToContext(Integer.parseInt(stringArray[1]), SwitchContextEnum.NoReason);
                        break;
                    }
                    case 960: {
                        NavRouteListData[] navRouteListDataArray = new NavRouteListData[]{new NavRouteListData()};
                        this.mm.getRouteCalculationHandler().updateRgDestinationInfo(navRouteListDataArray);
                        break;
                    }
                    case 961: {
                        int n22 = Integer.parseInt(stringArray[1]);
                        this.updateActiveInterrupts(n22);
                        break;
                    }
                    case 962: {
                        NavSegmentID navSegmentID = new NavSegmentID(new int[]{1, 2, 3});
                        CalculatedRouteListElement calculatedRouteListElement = new CalculatedRouteListElement(20000L, 10000L, 12000L, 2L, 0L, 0L, 0L, 2, false, false, false, false, false, false, navSegmentID, 0, 100, 5, 5, new int[]{1, 2, 34}, new String[]{"This is", "a hack"}, false);
                        CalculatedRouteListElement calculatedRouteListElement2 = new CalculatedRouteListElement(20000L, 10000L, 1812001L, 2L, 0L, 0L, 0L, 2, false, false, false, false, false, false, navSegmentID, 0, 100, 5, 1, new int[]{1, 2, 34}, new String[]{"This is", "a hack"}, false);
                        NavRectangle navRectangle = new NavRectangle();
                        navRectangle.xLeft = NavigationUtilities.degreeToWgs84(3992036.0);
                        navRectangle.xRight = NavigationUtilities.degreeToWgs84(3992056.0);
                        navRectangle.yBottom = NavigationUtilities.degreeToWgs84(1.16460457E7);
                        navRectangle.yUp = NavigationUtilities.degreeToWgs84(1.16460458E7);
                        RouteSectionInfo[] routeSectionInfoArray = new RouteSectionInfo[]{};
                        RgRouteCostChangeInformation rgRouteCostChangeInformation = new RgRouteCostChangeInformation(calculatedRouteListElement, calculatedRouteListElement2, true, 3, new int[]{3}, navRectangle, routeSectionInfoArray);
                        this.getMapMain().getMapInterface().updateRgRouteCostChangeInformation(rgRouteCostChangeInformation);
                        break;
                    }
                    case 964: {
                        this.mm.getServiceListHandler().updateToken("service_dsi_satellitemaps", "satellitemaps", new Integer(1));
                        break;
                    }
                    case 965: {
                        this.mm.getServiceListHandler().updateToken("service_dsi_satellitemaps", "satellitemaps", new Integer(3));
                        break;
                    }
                    case 980: {
                        Integer n23 = new Integer(stringArray[1]);
                        this.mm.getServiceListHandler().updateToken("service_dsi_satellitemaps", "satellitemaps", n23);
                        break;
                    }
                    case 981: {
                        int n24 = Integer.parseInt(stringArray[1]);
                        int n25 = Integer.parseInt(stringArray[2]);
                        OSRNotifyProperties oSRNotifyProperties = new OSRNotifyProperties("service_dsi_satellitemaps", n24, n25);
                        this.mm.getGoogleMapLicenseHandler().updateApplicationState(new OSRNotifyProperties[]{oSRNotifyProperties});
                        break;
                    }
                    case 982: {
                        Integer n26 = new Integer(stringArray[1]);
                        this.mm.getServiceListHandler().updateToken("service_dsi_onlinetraffic", "lic_traffic", n26);
                        break;
                    }
                    case 983: {
                        int n27 = Integer.parseInt(stringArray[1]);
                        int n28 = Integer.parseInt(stringArray[2]);
                        OSRNotifyProperties oSRNotifyProperties = new OSRNotifyProperties("service_dsi_onlinetraffic", n27, n28);
                        this.getMapMain().getNaviInterface().getOnlineTrafficHandler().updateApplicationState(new OSRNotifyProperties[]{oSRNotifyProperties});
                        break;
                    }
                    case 984: {
                        Integer n29 = new Integer(stringArray[1]);
                        this.mm.getServiceListHandler().updateToken("weatherinmaponlineservice", "weatherGrid", n29);
                        break;
                    }
                    case 985: {
                        int n30 = Integer.parseInt(stringArray[1]);
                        int n31 = Integer.parseInt(stringArray[2]);
                        OSRNotifyProperties oSRNotifyProperties = new OSRNotifyProperties("weatherinmaponlineservice", n30, n31);
                        this.mm.getWeatherLicenseHandler().updateApplicationState(new OSRNotifyProperties[]{oSRNotifyProperties});
                        break;
                    }
                    case 986: {
                        System.out.println("mapmanager.getSatelliteMapsMediator().disableUpdates()");
                        this.mm.getSatelliteMapsMediator().disableUpdates();
                        break;
                    }
                    case 987: {
                        System.out.println("mapmanager.getSatelliteMapsMediator().enableUpdates()");
                        this.mm.getSatelliteMapsMediator().enableUpdates();
                        break;
                    }
                    case 988: {
                        System.out.println("mapmanager.getSatelliteMapsMediator().updateMapStyle(MapConsts.DSI_TYPE_STDMAP,MapService.MAP_REPRESENTATION_STANDARD );");
                        this.mm.getSatelliteMapsMediator().updateMapStyle(0, 0);
                        break;
                    }
                    case 1000: {
                        IRouteInfo iRouteInfo = this.getMapMain().getRouteInfo();
                        TurnListElement[] turnListElementArray = new TurnListElement[]{};
                        iRouteInfo.updateRgTurnList(turnListElementArray);
                        break;
                    }
                    case 1001: {
                        NavPoiInfo navPoiInfo = new NavPoiInfo();
                        navPoiInfo.distance = 1000L;
                        navPoiInfo.remainingTime = 60000L;
                        navPoiInfo.poiLocations = new NavLocation[3];
                        navPoiInfo.poiLocations[0] = new NavLocation();
                        navPoiInfo.poiLocations[0].proprietaryData = new NavLocationDescriptor[]{new NavLocationDescriptor(4097, "Rasthof K\u00f6schinger Forst Ost"), new NavLocationDescriptor(520, "50331767"), new NavLocationDescriptor(282, "536870961")};
                        navPoiInfo.poiLocations[1] = new NavLocation();
                        navPoiInfo.poiLocations[1].proprietaryData = new NavLocationDescriptor[]{new NavLocationDescriptor(4097, "ARAL"), new NavLocationDescriptor(520, "50332649"), new NavLocationDescriptor(282, "553648177")};
                        navPoiInfo.poiLocations[2] = new NavLocation();
                        navPoiInfo.poiLocations[2].proprietaryData = new NavLocationDescriptor[]{new NavLocationDescriptor(4097, "Rasthof K\u00f6schinger Forst Ost"), new NavLocationDescriptor(520, "50333442"), new NavLocationDescriptor(282, "536870961")};
                        IRouteInfo iRouteInfo = this.getMapMain().getRouteInfo();
                        iRouteInfo.updateRgPoiInfo(new NavPoiInfo[]{navPoiInfo});
                        break;
                    }
                    case 1002: {
                        TurnListElement[] turnListElementArray = new TurnListElement[2];
                        turnListElementArray[0] = new TurnListElement(0L, 60L, 0L, null, "Street 0", "Turn to Street 0", "", 0, "Exit 0", "", 0, "", 0, null, null, 0, null, 0L, null);
                        turnListElementArray[0].maneuver = new ManeuverElement[]{new ManeuverElement(16, 64, 0)};
                        turnListElementArray[1] = new TurnListElement(1000L, 60L, 0L, null, "Street 1", "Turn to Street 1", "", 0, "Exit 1", "", 0, "", 0, null, null, 0, null, 0L, null);
                        turnListElementArray[1].maneuver = new ManeuverElement[]{new ManeuverElement(16, 64, 0)};
                        IRouteInfo iRouteInfo = this.getMapMain().getRouteInfo();
                        iRouteInfo.updateRgTurnList(turnListElementArray);
                        break;
                    }
                    case 1003: {
                        ((RenderingInfoProvider.SatelliteMapsLogoCallback)((Object)this.mm.getSatelliteMapsMediator().getMmuSatellitemapsmanagerFSM())).renderingInformationForSatelliteLogo(null);
                        break;
                    }
                    case 1004: {
                        ((RenderingInfoProvider.SatelliteMapsLogoCallback)((Object)this.mm.getSatelliteMapsMediator().getMmuSatellitemapsmanagerFSM())).renderingInformationForSatelliteLogo(new RenderingInfo(1610612755, true));
                        break;
                    }
                    case 2051: {
                        PosPosition posPosition = this.mm.getMapMain().getNaviInterface().getVehicle().getPosition();
                        NavLocation navLocation = Util.getLocationFromGeoPos(posPosition.longitude, posPosition.latitude);
                        NavLocation navLocation2 = this.mm.getRouteCalculationHandler().getDestination();
                        this.getMapMain().getMVRequest().setMapViewportByLD(navLocation, navLocation2, 0);
                        break;
                    }
                    case 2052: {
                        this.getMapMain().getMVResponseZoomEngine().updateRecommendedZoom(Float.parseFloat(stringArray[1]), 1);
                        break;
                    }
                    case 2053: {
                        this.mm.getMapInterface().setHeight(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 2054: {
                        this.mm.getMapInterface().sdsSelectAlternativeRoute(0);
                        break;
                    }
                    case 2055: {
                        this.mm.getMapInterface().cancelStartRouteCalculation();
                        break;
                    }
                    case 2056: {
                        this.mm.getViews().getMainMapView().setTrafficDelay(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 2057: {
                        this.mm.getViews().getMainMapView().setTrafficDelay(-Long.parseLong(stringArray[1]));
                        break;
                    }
                    case 4000: {
                        this.getMapMain().getActiveContext().switchDisplayContextKombi(9);
                        break;
                    }
                    case 4001: {
                        this.getMapMain().getActiveContext().switchDisplayContextKombi(8);
                        break;
                    }
                    case 4002: {
                        this.getMapMain().getNaviInterface().getAeaService().updateAEAAvailable(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 4003: {
                        this.getMapMain().getNaviInterface().triggerUpdateRcci();
                        break;
                    }
                    case 4004: {
                        this.getMapMain().getNaviInterface().afaRepeat(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 4005: {
                        this.getMapMain().getNaviInterface().getAeaService().updateAEASystemState(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 5000: {
                        ((MapContentSyncHandler)this.mm.getMapMain().getMapContentHandler()).checkAll(true);
                        break;
                    }
                    case 5001: {
                        this.getMapMain().getMVRequest().setSpeedAndFlowRoadClass(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 5002: {
                        this.mm.getMapMain().getNaviInterface().getClusterService().reSyncKOMO();
                        break;
                    }
                    case 5003: {
                        ((NaviInterface)this.mm.getMapMain().getNaviInterface()).getNavigation().getInterAppService().setRouteProfile(Integer.parseInt(stringArray[1]));
                        break;
                    }
                    case 5004: {
                        int n32 = this.env.getChoiceModel(402013).getValue();
                        this.env.getChoiceModel(402013).setValue(n32 == 0 ? 1 : 0);
                        break;
                    }
                    case 5005: {
                        this.getMapMain().getMVRequest().setLocation(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
                        break;
                    }
                    case 5006: {
                        this.getMapMain().getNaviInterface().getClusterService().setKDKVisibility(Boolean.valueOf(stringArray[1]) == Boolean.TRUE);
                        break;
                    }
                    case 5007: {
                        this.getMapMain().getGuiInterface().setGridMaskVisible(true);
                        break;
                    }
                    case 5008: {
                        this.getMapMain().getGuiInterface().setGridMaskVisible(false);
                        break;
                    }
                    case 5009: {
                        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(401883);
                        choiceModelApp.setValue(choiceModelApp.getValue() == 1 ? 0 : 1);
                        break;
                    }
                }
            }
        }
    }

    private void handle00x(int n, String[] stringArray) {
        switch (n) {
            case 0: {
                this.getMapMain().getGuiInterface().switchMapScreen(Integer.parseInt(stringArray[1]));
                break;
            }
            case 1: {
                this.getMapMain().switchToContext(Integer.parseInt(stringArray[1]));
                break;
            }
            case 3: {
                switch (Integer.parseInt(stringArray[1])) {
                    default: 
                }
                this.env.getChoiceModel(168).setValue(Integer.parseInt(stringArray[1]));
                break;
            }
            case 4: {
                if (stringArray.length > 2) {
                    this.mm.getMapEventDispatcher().fireEvent(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
                    break;
                }
                this.mm.getMapEventDispatcher().fireEvent(Integer.parseInt(stringArray[1]));
                break;
            }
        }
    }

    private void handle01x(int n, String[] stringArray) {
        block0 : switch (n) {
            case 12: {
                switch (Integer.parseInt(stringArray[1])) {
                    case 0: {
                        this.getLogChannel().log(1000000, "DSI_TYPE_STDMAP:\n%1", (Object)this.getMapMain().getMVResponseControlStd());
                        break block0;
                    }
                    case 1: {
                        this.getLogChannel().log(1000000, "DSI_TYPE_GE:\n%1", (Object)this.getMapMain().getMVResponseGoogleCtrl());
                        break block0;
                    }
                    case 2: {
                        this.getLogChannel().log(1000000, "DSI_TYPE_ADDITIONAL:\n%1", (Object)this.getMinorMap().getMVResponseControlStd());
                        break block0;
                    }
                    case 3: {
                        this.getLogChannel().log(1000000, "DSI_TYPE_KOMBI:\n%1", (Object)this.getMapKombi().getMVResponseControlStd());
                        break block0;
                    }
                    case 4: {
                        this.getLogChannel().log(1000000, "DSI_TYPE_GE2:\n%1", (Object)this.getMapKombi().getMVResponseGoogleCtrl());
                        break block0;
                    }
                }
                break;
            }
        }
    }

    private void handle02x(int n, String[] stringArray) {
        switch (n) {
            case 20: {
                MapEnv.useRgCalculate1stRouteAndPostponeRemaining = !MapEnv.useRgCalculate1stRouteAndPostponeRemaining;
                this.getLogChannel().log(1000000, "MapEnv.useRgCalculate1stRouteAndPostponeRemaining = %1", MapEnv.useRgCalculate1stRouteAndPostponeRemaining);
                break;
            }
            case 21: {
                MapEnv.isRouteInfoHandlerEnabled = !MapEnv.isRouteInfoHandlerEnabled;
                this.getLogChannel().log(1000000, "MapEnv.isRouteInfoHandlerEnabled = %1", MapEnv.isRouteInfoHandlerEnabled);
                break;
            }
            case 22: {
                MapEnv.waitForReadyBeforeEnterMap = !MapEnv.waitForReadyBeforeEnterMap;
                this.getLogChannel().log(1000000, "MapEnv.waitForReadyBeforeEnterMap = %1", MapEnv.waitForReadyBeforeEnterMap);
                break;
            }
            case 23: {
                MapEnv.useTopLeftToCalculateBoundingBox = !MapEnv.useTopLeftToCalculateBoundingBox;
                this.getLogChannel().log(1000000, "MapEnv.useTopLeftToCalculateBoundingBox = %1", MapEnv.useTopLeftToCalculateBoundingBox);
                break;
            }
            case 24: {
                MapEnv.restoreLastRubberbandPoint = !MapEnv.restoreLastRubberbandPoint;
                this.getLogChannel().log(1000000, "MapEnv.restoreLastRubberbandPoint = %1", MapEnv.restoreLastRubberbandPoint);
                break;
            }
            case 25: {
                MapEnv.enableSoftAnimationForRubberband = !MapEnv.enableSoftAnimationForRubberband;
                this.getLogChannel().log(1000000, "MapEnv.enableSoftAnimationForRubberband = %1", MapEnv.enableSoftAnimationForRubberband);
                break;
            }
            case 26: {
                MapEnv.mapModeForRouteBriefing = 10;
                this.getLogChannel().log(1000000, "MapEnv.mapModeForRouteBriefing = %1", (long)MapEnv.mapModeForRouteBriefing);
                break;
            }
            case 27: {
                MapEnv.mapModeForRouteBriefing = 6;
                this.getLogChannel().log(1000000, "MapEnv.mapModeForRouteBriefing = %1", (long)MapEnv.mapModeForRouteBriefing);
                break;
            }
        }
    }

    private void handle3xxx(int n, String[] stringArray) {
        switch (n) {
            case 3000: {
                this.getMapMain().getMVRequest().setEnableSoftJump(false);
                this.getMapMain().getMVRequest().setEnableSoftRotation(false);
                this.getMapMain().getMVRequest().setEnableSoftTilt(false);
                this.getMapMain().getMVRequest().setEnableSoftZoom(false);
                this.getMapMain().getMVRequest().setEnableSoftZoomConditional(false);
                PosPosition posPosition = this.getMapMain().getNaviInterface().getVehicle().getPosition();
                NavLocation navLocation = Util.getLocationFromGeoPos(posPosition.longitude, posPosition.latitude);
                NavLocation navLocation2 = Util.getLocationFromGeoPos(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
                this.getMapMain().getMVRequest().setMapViewportByLD(navLocation, navLocation2, 0);
                this.getMapMain().getMVRequest().setEnableSoftJump(true);
                this.getMapMain().getMVRequest().setEnableSoftRotation(true);
                this.getMapMain().getMVRequest().setEnableSoftTilt(this.getMapMain().isMapEnablingSoftTiltDesired());
                this.getMapMain().getMVRequest().setEnableSoftZoom(true);
                this.getMapMain().getMVRequest().setEnableSoftZoomConditional(true);
                break;
            }
            case 3001: {
                this.getMapMain().getMVRequest().setEnableSoftJump(false);
                this.getMapMain().getMVRequest().setEnableSoftRotation(false);
                this.getMapMain().getMVRequest().setEnableSoftTilt(false);
                this.getMapMain().getMVRequest().setEnableSoftZoom(false);
                this.getMapMain().getMVRequest().setEnableSoftZoomConditional(false);
                this.getMapMain().getMVRequest().viewSetVisible(false);
                this.getMapMain().getMVRequest().viewFreeze(true);
                PosPosition posPosition = this.getMapMain().getNaviInterface().getVehicle().getPosition();
                NavLocation navLocation = Util.getLocationFromGeoPos(posPosition.longitude, posPosition.latitude);
                NavLocation navLocation3 = Util.getLocationFromGeoPos(Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2]));
                this.getMapMain().getMVRequest().setMapViewportByLD(navLocation, navLocation3, 0);
                this.getMapMain().getMVRequest().viewSetVisible(true);
                this.getMapMain().getMVRequest().viewFreeze(false);
                this.getMapMain().getMVRequest().setEnableSoftJump(true);
                this.getMapMain().getMVRequest().setEnableSoftRotation(true);
                this.getMapMain().getMVRequest().setEnableSoftTilt(this.getMapMain().isMapEnablingSoftTiltDesired());
                this.getMapMain().getMVRequest().setEnableSoftZoom(true);
                this.getMapMain().getMVRequest().setEnableSoftZoomConditional(true);
                break;
            }
        }
    }

    public void updateActiveInterrupts(int n) {
        int[] nArray = new int[]{1, 3, 5};
        int[] nArray2 = new int[]{3, 4};
        int[] nArray3 = new int[]{4, 1, 3};
        int[] nArray4 = new int[]{3, 6};
        int[] nArray5 = new int[]{1, 3, 6};
        int[] nArray6 = new int[]{30203};
        int[] nArray7 = new int[]{30201};
        Interrupt[] interruptArray = new Interrupt[3];
        switch (n) {
            case 0: {
                interruptArray[0] = new Interrupt(10, 20, nArray5);
                interruptArray[1] = new Interrupt(11, 14, nArray);
                interruptArray[2] = new Interrupt(12, 14, nArray2);
                break;
            }
            case 1: {
                interruptArray[1] = new Interrupt(11, 14, nArray);
                interruptArray[2] = new Interrupt(12, 14, nArray2);
                break;
            }
            case 2: {
                interruptArray[0] = new Interrupt(20, 20, nArray5);
                break;
            }
            case 3: {
                interruptArray[0] = new Interrupt(21, 11, nArray3);
                break;
            }
            case 4: {
                interruptArray[0] = new Interrupt(22, 20, nArray6);
                break;
            }
            case 5: {
                interruptArray[0] = new Interrupt(23, 8, nArray);
                break;
            }
            case 6: {
                interruptArray[0] = new Interrupt(24, 13, nArray3);
                break;
            }
            case 7: {
                interruptArray[0] = new Interrupt(25, 20, nArray2);
                break;
            }
            case 8: {
                interruptArray[0] = new Interrupt(26, 1, nArray);
                break;
            }
            case 9: {
                interruptArray[0] = new Interrupt(27, 14, nArray);
                interruptArray[1] = new Interrupt(28, 20, nArray5);
                break;
            }
            case 10: {
                interruptArray[0] = new Interrupt(29, 8, nArray7);
                break;
            }
            case 11: {
                interruptArray[0] = new Interrupt(30, 20, nArray6);
                break;
            }
            case 12: {
                interruptArray[0] = new Interrupt(31, 13, nArray3);
                interruptArray[1] = new Interrupt(32, 20, nArray5);
                break;
            }
            case 51: {
                interruptArray = new Interrupt[]{new Interrupt(15, 20, nArray4)};
                break;
            }
            case 52: {
                interruptArray[0] = new Interrupt(24, 21, nArray);
                break;
            }
            case 13: {
                interruptArray[0] = new Interrupt(1, 21, nArray);
                break;
            }
            case 14: {
                interruptArray[0] = new Interrupt(2, 21, nArray);
                break;
            }
            case 15: {
                interruptArray[0] = new Interrupt(1, 21, nArray);
                interruptArray[1] = new Interrupt(2, 21, nArray);
                break;
            }
            case 16: {
                interruptArray = new Interrupt[]{};
                break;
            }
        }
        Interrupt[] interruptArray2 = interruptArray;
        if (this.mm.getTrafficMiniMap() instanceof AbstractTrafficMiniMap) {
            ((AbstractTrafficMiniMap)this.mm.getTrafficMiniMap()).getTrafficMiniMapDSIListener().updateActiveInterrupts(interruptArray2, 1);
        }
        try {
            Thread.sleep(500L);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        if (this.mm.getTrafficMiniMap() instanceof AbstractTrafficMiniMap) {
            ((AbstractTrafficMiniMap)this.mm.getTrafficMiniMap()).getTrafficMiniMapDSIListener().requestResourceInformationResponse(nArray[0], new ResourceInformation(new ResourceLocator(1234), null));
        }
    }
}

