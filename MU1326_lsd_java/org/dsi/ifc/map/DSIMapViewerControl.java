/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.map.MapOverlay;
import org.dsi.ifc.map.PoiListElement;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerControl
extends DSIBase {
    public static final String VERSION = "2.11.62";
    public static final int ATTR_READY = 1;
    public static final int ATTR_CURRENTVIEWTYPE = 3;
    public static final int ATTR_DAYNIGHTVIEW = 4;
    public static final int ATTR_VIEWSCREENVIEWPORT = 6;
    public static final int ATTR_VIEWVISIBLE = 7;
    public static final int ATTR_VIEWFREEZE = 8;
    public static final int ATTR_ZOOMLEVEL = 9;
    public static final int ATTR_ZOOMLIST = 10;
    public static final int ATTR_ZOOMLISTINDEX = 11;
    public static final int ATTR_MAPROTATION = 12;
    public static final int ATTR_MAPPOSITION = 13;
    public static final int ATTR_MAPORIENTATION = 14;
    public static final int ATTR_CARPOSITION = 15;
    public static final int ATTR_TMCVISIBLE = 16;
    public static final int ATTR_MAPMODE = 18;
    public static final int ATTR_SELECTEDPOI = 19;
    public static final int ATTR_SPEEDANDFLOWVISIBLE = 20;
    public static final int ATTR_AVAILABLEROUTES = 21;
    public static final int ATTR_VIEWPORT = 22;
    public static final int ATTR_SOFTJUMPENABLED = 23;
    public static final int ATTR_SOFTROTATIONENABLED = 24;
    public static final int ATTR_SOFTTILTENABLED = 25;
    public static final int ATTR_SOFTZOOMENABLED = 26;
    public static final int ATTR_ROUTECALCMODEENABLED = 27;
    public static final int ATTR_RBINFOOFSELECTEDSEGMENTS = 28;
    public static final int ATTR_CURRENTLANDUSESTYLE = 30;
    public static final int ATTR_CURRENTMETRICSYSTEM = 31;
    public static final int ATTR_SOFTJUMPRUNNING = 32;
    public static final int ATTR_SOFTROTATIONRUNNING = 33;
    public static final int ATTR_SOFTTILTRUNNING = 34;
    public static final int ATTR_SOFTZOOMRUNNING = 35;
    public static final int ATTR_CITYMODELMODE = 36;
    public static final int ATTR_MAPVIEWERRUNLEVEL = 37;
    public static final int ATTR_MAPVIEWERSUSPENSIONSUPPORTED = 38;
    public static final int ATTR_MAPVIEWERSUSPENSIONANDWAKEUPPROGRESS = 39;
    public static final int ATTR_GENERALPOIVISIBILITY = 40;
    public static final int ATTR_AVAILABLECOUNTRYOVERVIEWS = 41;
    public static final int ATTR_HORIZONMARKERVISIBILITY = 42;
    public static final int ATTR_VIEWSCREENVIEWPORTMAXIMUM = 43;
    public static final int ATTR_DRAGROUTEPOSITION = 44;
    public static final int ATTR_EHCATEGORYVISIBILITY = 45;
    public static final int ATTR_MAPLAYERAVAILABLE = 46;
    public static final int ATTR_MAPLAYERVISIBLE = 47;
    public static final int ATTR_TEMPERATURESCALE = 48;
    public static final int ATTR_SPEEDANDFLOWROADCLASS = 49;
    public static final int ATTR_ROUTEVISIBILITY = 50;
    public static final int ATTR_SOFTANIMATIONSPEED = 51;
    public static final int ATTR_MAPSTYLE = 52;
    public static final int MAPLAYER_SDARS_RADAR = 0;
    public static final int MAPLAYER_SDARS_WEATHER = 1;
    public static final int MAPLAYER_SDARS_ISOBARE = 2;
    public static final int MAPMODE_ROUTEMAP = 0;
    public static final int MAPMODE_POSITIONMAP = 1;
    public static final int MAPMODE_FREEMAP = 2;
    public static final int MAPMODE_CROSSHAIRMAP = 3;
    public static final int MAPMODE_POIMAP = 4;
    public static final int MAPMODE_ROUTESCROLLMAP = 5;
    public static final int MAPMODE_ALTERNATIVEROUTEMAP = 6;
    public static final int MAPMODE_RCCIMAP = 7;
    public static final int MAPMODE_ROUTEBROWSERMAP = 8;
    public static final int MAPMODE_DESTINATIONMAP = 9;
    public static final int MAPMODE_OVERVIEWMAP = 10;
    public static final int MAPMODE_ALTERNATIVEROUTEMAP_DIFFERENTCOLORS = 11;
    public static final int MAPMODE_ROUTEBRIEFING = 12;
    public static final int MAPMODE_COUNTRY_OVERVIEW = 13;
    public static final int MAPMODE_MOBILITY_HORIZON = 14;
    public static final int MAPMODE_MAPOVERLAY = 15;
    public static final int MAPMODE_PREDICTIVE_NAV_OVERVIEW = 16;
    public static final int MAPMODE_PREDICTIVE_OVERLAY = 17;
    public static final int MAPMODE_ROUTEOVERVIEWMAP = 18;
    public static final int MAPMODE_INVALID_MAPMODE = 255;
    public static final int LOCATION_CAR = 0;
    public static final int LOCATION_DESTINATION = 1;
    public static final int LOCATION_STOPOVER = 2;
    public static final int LOCATION_INVALID_LOCATION = 3;
    public static final int MAPVIEWTYPE_VIEW2D = 0;
    public static final int MAPVIEWTYPE_BIRDVIEW = 1;
    public static final int MAPVIEWTYPE_VIEW3D = 3;
    public static final int MAPVIEWTYPE_INVALID_MAPVIEWTYPE = 255;
    public static final int POSITIONINFOTYPE_LOCATION = 0;
    public static final int POSITIONINFOTYPE_POI = 1;
    public static final int POSITIONINFOTYPE_POI_3D = 2;
    public static final int POSITIONINFOTYPE_POI_CONTAINER = 3;
    public static final int POSITIONINFOTYPE_TMC_MESSAGE = 4;
    public static final int POSITIONINFOTYPE_PERSONAL_DEST = 5;
    public static final int POSITIONINFOTYPE_INVALID_POSITION = 6;
    public static final int POSITIONINFOTYPE_AREA = 7;
    public static final int POSITIONINFOTYPE_XT_REPRESENTATION = 8;
    public static final int POSITIONINFOTYPE_PICTURE_DESTINATION = 9;
    public static final int POSITIONINFOTYPE_PICTURE_DESTINATION_STACK = 10;
    public static final int POSITIONINFOTYPE_POI_BY_UID = 11;
    public static final int POSITIONINFOTYPE_POI_STACK_BY_UID = 12;
    public static final int POSITIONINFOTYPE_ROUTESEGMENT = 13;
    public static final int POSITIONINFOTYPE_WEATHERINFORMATION = 14;
    public static final int POSITIONINFOTYPE_CURRENT_CAR_POSITION = 15;
    public static final int POSITIONINFOTYPE_LANDMARK = 16;
    public static final int POSITIONINFOTYPE_SDARS_WEATHERSTATION = 17;
    public static final int POSITIONINFOTYPE_SDARS_SKIRESORT = 18;
    public static final int POSITIONINFOTYPE_SDARS_STORMINFO = 19;
    public static final int POSITIONINFOTYPE_POI_BUILDINGLIST = 20;
    public static final int POSITIONINFOTYPE_INVALID_POSITIONINFOTYPE = 255;
    public static final int MAPTYPE_CITYMAPREAL = 0;
    public static final int MAPTYPE_CITYMAPDRAWING = 1;
    public static final int MAPTYPE_TERRAINMAP = 2;
    public static final int MAPTYPE_IMAGEMAP = 3;
    public static final int MAPTYPE_INVALID_MAPTYPE = 255;
    public static final int ROUTETYPE_NOTYPE = 0;
    public static final int ROUTETYPE_CURRENT = 1;
    public static final int ROUTETYPE_BLOCKED = 2;
    public static final int ROUTETYPE_PLANNED = 3;
    public static final int ROUTETYPE_ALTERNATIVE = 4;
    public static final int ROUTETYPE_TRAVELLED = 5;
    public static final int ROUTETYPE_TRAIL = 6;
    public static final int ROUTETYPE_INVALID_ROUTETYPE = 255;
    public static final int COMMAND_ADD = 0;
    public static final int COMMAND_CLEAR = 1;
    public static final int COMMAND_REMOVE = 2;
    public static final int COMMAND_REPLACE = 3;
    public static final int COMMAND_INVALID_COMMAND = 255;
    public static final int STARTPOS_START_AT_DESTINATION = 0;
    public static final int STARTPOS_START_AT_CARPOSITION = 1;
    public static final int STARTPOS_INVALID_STARTPOS = 255;
    public static final int SCROLLRAMP_RAMP_1 = 0;
    public static final int SCROLLRAMP_RAMP_2 = 1;
    public static final int SCROLLRAMP_RAMP_3 = 2;
    public static final int SCROLLRAMP_RAMP_4 = 3;
    public static final int SCROLLRAMP_ABSOLUTE_PIXELS = 4;
    public static final int SCROLLRAMP_INVALID_SCROLLRAMP = 255;
    public static final int METRICSYSTEM_RESERVED = 0;
    public static final int METRICSYSTEM_DEFAULT = 1;
    public static final int METRICSYSTEM_KILOMETERS_METERS = 2;
    public static final int METRICSYSTEM_IMPERIAL_GB_MILES_YARDS = 3;
    public static final int METRICSYSTEM_IMPERIAL_US_MILES_FEET = 4;
    public static final int CITYMODELMODE_OFF = 0;
    public static final int CITYMODELMODE_STANDARD = 1;
    public static final int CITYMODELMODE_ENHANCED = 2;
    public static final int RESULTCODE_OK = 0;
    public static final int RESULTCODE_FAIL = 1;
    public static final int RESULTCODE_UNSUPPORTED = 2;
    public static final int BRANDICONSTYLE_ACTUALBRANDICON = 0;
    public static final int BRANDICONSTYLE_GENERIC = 1;
    public static final int GUIDANCESYMBOL_NONE = 0;
    public static final int GUIDANCESYMBOL_ARROW = 1;
    public static final int FRAMERATEMODE_IMAGE_FROZEN = 0;
    public static final int FRAMERATEMODE_NORMAL_FRAMERATE = 1;
    public static final int FRAMERATEMODE_BACKGROUND_RENDERING = 2;
    public static final int FRAMERATEMODE_BOOST_FRAMERATE = 3;
    public static final int FRAMERATEMODE_THROTTELED_FRAMERATE = 4;
    public static final int FRAMERATEMODE_LIMITED_CLUSTER_INSTRUMENT = 5;
    public static final int ROUTECOLORINGPOLICY_COLOR_BY_ROUTETOPTION = 0;
    public static final int ROUTECOLORINGPOLICY_COLOR_BY_ROUTEALTERNATIVE = 1;
    public static final int CROSSHAIRSCOLOR_BLUE = 1;
    public static final int CROSSHAIRSCOLOR_GREEN = 2;
    public static final int VIEWPORTBORDER_NONE = 1;
    public static final int VIEWPORTBORDER_STYLE1 = 2;
    public static final int VIEWPORTBORDER_STYLE2 = 3;
    public static final int MAPVIEWERRUNLEVEL_SUSPENSION_IN_PROGRESS = 0;
    public static final int MAPVIEWERRUNLEVEL_SUSPENDED = 1;
    public static final int MAPVIEWERRUNLEVEL_WAKEUP_IN_PROGRESS = 2;
    public static final int MAPVIEWERRUNLEVEL_AWAKE = 4;
    public static final int MAPVIEWERRUNLEVEL_ERROR_SUSPENSION_NOT_POSSIBLE = 5;
    public static final int MAPVIEWERRUNLEVEL_ERROR_WAKEUP_NOT_POSSIBLE = 6;
    public static final int MAPVIEWERSUSPENSIONSUPPORTED_NO = 0;
    public static final int MAPVIEWERSUSPENSIONSUPPORTED_YES = 1;
    public static final int MOBILITYHORIZONZOOMMODE_HORIZON = 0;
    public static final int MOBILITYHORIZONZOOMMODE_HORIZON_CARPOS = 1;
    public static final int MOBILITYHORIZONZOOMMODE_HORIZON_ROUTE = 2;
    public static final int MOBILITYHORIZONZOOMMODE_HORIZON_ALLPOLYGONS = 3;
    public static final int DRAGROUTEMARKERSTYLE_NOMARKER = 0;
    public static final int DRAGROUTEMARKERSTYLE_SMALLMARKER = 1;
    public static final int DRAGROUTEMARKERSTYLE_BIGMARKER = 2;
    public static final int ROUTEHIGHLIGHTSTYLE_NONE = 0;
    public static final int ROUTEHIGHLIGHTSTYLE_SIMPLE = 1;
    public static final int ROUTEHIGHLIGHTSTYLE_BLOCKPREVIEW = 2;
    public static final int MAPSTYLETYPE_STANDARD = 0;
    public static final int MAPSTYLETYPE_SATELLITE = 1;
    public static final int MAPSTYLETYPE_TRAFFIC = 2;
    public static final int MAPOVERLAYTYPE_UNDEFINED = 0;
    public static final int MAPOVERLAYTYPE_WEATHERRADAR = 1;
    public static final int TEMPERATURESCALE_UNDEFINED = 0;
    public static final int TEMPERATURESCALE_CELSIUS = 1;
    public static final int TEMPERATURESCALE_FAHRENHEIT = 2;
    public static final int SPEEDANDFLOWROADCLASS_UNDEFINED = 0;
    public static final int SPEEDANDFLOWROADCLASS_EXPRESSWAY = 1;
    public static final int SPEEDANDFLOWROADCLASS_NORMALROAD = 2;
    public static final int SPEEDANDFLOWROADCLASS_AUTO = 3;
    public static final int SPEEDANDFLOWROADCLASS_ALL = 4;
    public static final int TEXTALIGN_CENTER = 0;
    public static final int TEXTALIGN_LEFT = 1;
    public static final int TEXTALIGN_RIGHT = 2;
    public static final int TEXTVERTALIGN_MIDDLE = 3;
    public static final int TEXTVERTALIGN_BOTTOM = 4;
    public static final int TEXTVERTALIGN_TOP = 5;
    public static final int RT_CONFIGUREFLAGS = 1001;
    public static final int RT_DRAGMAP = 1003;
    public static final int RT_ENSURETMCVISIBILITY = 1004;
    public static final int RT_GETINFOFORPOSITION = 1005;
    public static final int RT_GETINFOFORSCREENPOSITION = 1006;
    public static final int RT_GETNUMBEROFPOIS = 1007;
    public static final int RT_GOTOTMCMESSAGE = 1008;
    public static final int RT_PACKPOICONTAINER = 1009;
    public static final int RT_RBSELECTALTERNATIVEROUTE = 1010;
    public static final int RT_RBSELECTNEXTSEGMENT = 1011;
    public static final int RT_RBSELECTPREVIOUSSEGMENT = 1012;
    public static final int RT_RBSETPOSITION = 1013;
    public static final int RT_SCROLLTODIRECTION = 1014;
    public static final int RT_SELECTNEXTPOI = 1015;
    public static final int RT_SELECTPREVPOI = 1016;
    public static final int RT_SET3DLANDMARKSVISIBLE = 1018;
    public static final int RT_SETCARPOSITION = 1019;
    public static final int RT_SETDAYVIEW = 1021;
    public static final int RT_SETNIGHTVIEW = 1022;
    public static final int RT_SETENABLEROUTECALCMODE = 1023;
    public static final int RT_SETENABLESOFTJUMP = 1024;
    public static final int RT_SETENABLESOFTROTATION = 1025;
    public static final int RT_SETENABLESOFTTILT = 1026;
    public static final int RT_SETENABLESOFTZOOM = 1027;
    public static final int RT_SETLOCATION = 1028;
    public static final int RT_SETLOCATIONBYLOCATION = 1029;
    public static final int RT_SETLOCATIONBYLOCATIONANDVIEW = 1030;
    public static final int RT_SETMAPPOSITION = 1031;
    public static final int RT_SETMAPVIEWPORT = 1032;
    public static final int RT_SETMAPVIEWPORTBYLD = 1033;
    public static final int RT_SETMODE = 1034;
    public static final int RT_SETORIENTATION = 1035;
    public static final int RT_SETROTATION = 1036;
    public static final int RT_SETVIEWTYPE = 1037;
    public static final int RT_SETZOOMAREA = 1038;
    public static final int RT_SETZOOMLEVEL = 1039;
    public static final int RT_SHOWTMCMESSAGES = 1041;
    public static final int RT_STARTSCROLLTODIRECTION = 1042;
    public static final int RT_STOPSCROLLTODIRECTION = 1043;
    public static final int RT_UNPACKPOICONTAINER = 1044;
    public static final int RT_VIEWFREEZE = 1045;
    public static final int RT_VIEWSETSCREENVIEWPORT = 1046;
    public static final int RT_VIEWSETVISIBLE = 1047;
    public static final int RT_SETHOTPOINT = 1050;
    public static final int RT_SETMETRICSYSTEM = 1052;
    public static final int RT_SETVIEWFOCUSONBLOCK = 1054;
    public static final int RT_STARTTODRAWNEWRECTANGLEINMAP = 1055;
    public static final int RT_SETSOUTHWESTCORNEROFRECTANGLEINMAP = 1056;
    public static final int RT_SETNORTHEASTCORNEROFRECTANGLEINMAP = 1057;
    public static final int RT_FINISHDRAWRECTANGLEINMAP = 1058;
    public static final int RT_EDITRECTANGLEINMAP = 1059;
    public static final int RT_SETCITYMODELMODE = 1060;
    public static final int RT_SETVIEWFOCUSONPOI = 1061;
    public static final int RT_DISPLAYREMAININGRANGEOFVEHICLE = 1062;
    public static final int RT_TOUCHAPPROACH = 1063;
    public static final int RT_SETBRANDICONSTYLE = 1064;
    public static final int RT_STARTSCROLLBYVECTOR = 1065;
    public static final int RT_SETGUIDANCESYMBOL = 1066;
    public static final int RT_SETHOVLANEVISIBILITY = 1067;
    public static final int RT_RBGETIDOFSELECTEDSEGMENT = 1068;
    public static final int RT_RBGETRRDTOSELECTEDSEGMENT = 1069;
    public static final int RT_SETTOLLROADHIGHLIGHTING = 1070;
    public static final int RT_SETMOUNTAINPEAKMARKER = 1071;
    public static final int RT_SETVIEWFOCUSONCOMBINEDROUTELISTELEMENTS = 1072;
    public static final int RT_SETFRAMERATEMODE = 1073;
    public static final int RT_SETSCROLLBYCROSSHAIRS = 1074;
    public static final int RT_SETSCROLLBYCROSSHAIRSBOUNDINGBOX = 1075;
    public static final int RT_SETROUTECOLORINGPOLICY = 1076;
    public static final int RT_SETWEATHERVISUALIZATION = 1077;
    public static final int RT_SETPICTURENAVIGATIONICONVISIBILITY = 1078;
    public static final int RT_SETMOBILITYHORIZONVISIBILITY = 1079;
    public static final int RT_SETTRAFFICMAPSTYLE = 1080;
    public static final int RT_SHOWSPEEDANDFLOWFREEFLOW = 1081;
    public static final int RT_SHOWSPEEDANDFLOWCONGESTIONS = 1082;
    public static final int RT_SETCROSSHAIRSCOLOR = 1084;
    public static final int RT_SETVIEWPORTBORDER = 1085;
    public static final int RT_SETTERRAINELEVATION = 1086;
    public static final int RT_ENSUREPOIVISIBILITY = 1087;
    public static final int RT_SUSPENDMAPVIEWER = 1088;
    public static final int RT_WAKEUPMAPVIEWER = 1089;
    public static final int RT_SETCOUNTRYOVERVIEWCOUNTRY = 1090;
    public static final int RT_SETGENERALPOIVISIBILITY = 1091;
    public static final int RT_SHOWRICHCONTENT = 1092;
    public static final int RT_SETMOBILITYHORIZONZOOMMODE = 1093;
    public static final int RT_ISDETAILEDMAPMATERIALAVAILABLE = 1094;
    public static final int RT_SETHORIZONMARKERVISIBILITY = 1095;
    public static final int RT_VIEWSETSCREENVIEWPORTMAXIMUM = 1096;
    public static final int RT_SETMAPVIEWPORTBYWGS84RECTANGLE = 1097;
    public static final int RT_ENSURETRAFFICEVENTICONSVISIBILITY = 1098;
    public static final int RT_STARTROUTEDRAGGING = 1099;
    public static final int RT_DRAGROUTE = 1100;
    public static final int RT_SETDRAGROUTEMARKER = 1101;
    public static final int RT_HIGHLIGHTROUTEBASEDONLENGTH = 1102;
    public static final int RT_EHSETCATEGORYVISIBILITY = 1103;
    public static final int RT_EHSETCATEGORYVISIBILITYTODEFAULT = 1104;
    public static final int RT_SETMAPOVERLAYS = 1105;
    public static final int RT_SETMAPLAYERVISIBLE = 1106;
    public static final int RT_SETTEMPERATURESCALE = 1107;
    public static final int RT_SETSOFTANIMATIONSPEED = 1108;
    public static final int RT_SETSPEEDANDFLOWROADCLASS = 1109;
    public static final int RT_SETROUTEVISIBILITY = 1110;
    public static final int RT_SETVISIBLEROUTES = 1111;
    public static final int RT_SHOWTRAFFICEVENTLISTVIEW = 1112;
    public static final int RT_SETMAPSTYLE = 1113;
    public static final int RT_SETCOPYRIGHTPOSITION = 1114;
    public static final int RP_CONFIGUREFLAGS = 2000;
    public static final int RP_GETINFOFORPOSITION = 2001;
    public static final int RP_GETNUMBEROFPOIS = 2002;
    public static final int RP_UNPACKPOICONTAINERRESULT = 2003;
    public static final int RP_SETVIEWFOCUSONBLOCKRESULT = 2004;
    public static final int RP_STARTTODRAWNEWRECTANGLEINMAPRESULT = 2005;
    public static final int RP_SETSOUTHWESTCORNEROFRECTANGLEINMAPRESULT = 2006;
    public static final int RP_SETNORTHEASTCORNEROFRECTANGLEINMAPRESULT = 2007;
    public static final int RP_FINISHDRAWRECTANGLEINMAPRESULT = 2008;
    public static final int RP_DISPLAYREMAININGRANGEOFVEHICLERESULT = 2009;
    public static final int RP_TOUCHAPPROACHRESULT = 2010;
    public static final int RP_SETBRANDICONSTYLERESULT = 2011;
    public static final int RP_SETGUIDANCESYMBOLRESULT = 2012;
    public static final int RP_SETHOVLANEVISIBILITYRESULT = 2013;
    public static final int RP_RBGETIDOFSELECTEDSEGMENTRESULT = 2014;
    public static final int RP_RBGETRRDTOSELECTEDSEGMENTRESULT = 2015;
    public static final int RP_SETTOLLROADHIGHLIGHTINGRESULT = 2016;
    public static final int RP_SETMOUNTAINPEAKMARKERRESULT = 2017;
    public static final int RP_SUSPENDMAPVIEWERRESULT = 2019;
    public static final int RP_WAKEUPMAPVIEWERRESULT = 2020;
    public static final int RP_ISDETAILEDMAPMATERIALAVAILABLE = 2021;
    public static final int RP_SETMAPOVERLAYSRESULT = 2022;

    public void configureFlags(int var1, MapFlag[] var2);

    public void dragMap(short var1, short var2);

    public void ensureTMCVisibility(long var1);

    public void getInfoForPosition();

    public void getInfoForScreenPosition(Point var1);

    public void getNumberOfPOIs();

    public void goToTMCMessage(long var1);

    public void packPOIContainer();

    public void rbSelectAlternativeRoute(int var1);

    public void rbSelectNextSegment();

    public void rbSelectPreviousSegment();

    public void rbSetPosition(int var1);

    public void scrollToDirection(short var1, int var2, short var3);

    public void selectNextPOI();

    public void selectPrevPOI();

    public void set3DLandmarksVisible(boolean var1);

    public void setCarPosition(Point var1);

    public void setDayView();

    public void setEnableRouteCalcMode(boolean var1);

    public void setEnableSoftJump(boolean var1);

    public void setEnableSoftRotation(boolean var1);

    public void setEnableSoftTilt(boolean var1);

    public void setEnableSoftZoom(boolean var1);

    public void setHotPoint(Point var1);

    public void setLocation(int var1, short var2);

    public void setLocationByLocation(NavLocation var1);

    public void setLocationByLocationAndView(NavLocation var1, short var2, int var3);

    public void setMapPosition(NavLocationWgs84 var1);

    public void setMapViewPort(NavLocationWgs84 var1, short var2, int var3);

    public void setMapViewPortByLD(NavLocation var1, NavLocation var2, int var3);

    public void setMode(int var1);

    public void setNightView();

    public void setOrientation(int var1, Point var2);

    public void setRotation(short var1);

    public void setViewType(int var1);

    public void setZoomArea(Rect var1);

    public void setZoomLevel(float var1, int var2);

    public void setCountryOverviewCountry(String var1);

    public void showTMCMessages(boolean var1);

    public void startScrollToDirection(int var1);

    public void stopScrollToDirection();

    public void unpackPOIContainer(long var1);

    public void viewFreeze(boolean var1);

    public void viewSetScreenViewport(Rect var1);

    public void viewSetScreenViewportMaximum(Rect var1);

    public void viewSetVisible(boolean var1);

    public void setMetricSystem(int var1);

    public void setViewFocusOnBlock(long[] var1);

    public void setViewFocusOnPoi(PoiListElement[] var1);

    public void startToDrawNewRectangleInMap();

    public void editRectangleInMap(long var1);

    public void setSouthWestCornerOfRectangleInMap(Point var1);

    public void setNorthEastCornerOfRectangleInMap(Point var1);

    public void finishDrawRectangleInMap();

    public void setCityModelMode(int var1);

    public void displayRemainingRangeOfVehicle(boolean var1);

    public void touchApproach(boolean var1);

    public void setBrandIconStyle(int[] var1, int var2);

    public void startScrollByVector(int var1, int var2);

    public void setGuidanceSymbol(int var1);

    public void setHOVLaneVisibility(boolean var1);

    public void rbGetIDOfSelectedSegment();

    public void rbGetRRDToSelectedSegment(long var1);

    public void setTollRoadHighLighting(boolean var1);

    public void setMountainPeakMarker(boolean var1);

    public void setViewFocusOnCombinedRouteListElements(long[] var1);

    public void setFrameRateMode(int var1);

    public void setScrollByCrossHairs(boolean var1);

    public void setScrollByCrossHairsBoundingBox(Rect var1);

    public void setRouteColoringPolicy(int var1);

    public void setWeatherVisualization(boolean var1);

    public void setPictureNavigationIconVisibility(boolean var1, int var2);

    public void setMobilityHorizonVisibility(boolean var1);

    public void setTrafficMapStyle(boolean var1);

    public void showSpeedAndFlowFreeFlow(boolean var1);

    public void showSpeedAndFlowCongestions(boolean var1);

    public void showRichContent(boolean var1);

    public void setGeneralPoiVisibility(boolean var1);

    public void setCrossHairsColor(int var1);

    public void setViewPortBorder(int var1);

    public void setTerrainElevation(boolean var1);

    public void ensurePoiVisibility(NavLocation[] var1);

    public void suspendMapViewer();

    public void wakeupMapViewer();

    public void setMobilityHorizonZoomMode(int var1);

    public void isDetailedMapMaterialAvailable(NavLocationWgs84 var1);

    public void setHorizonMarkerVisibility(boolean var1);

    public void ensureTrafficEventIconsVisibility(long[] var1);

    public void setMapViewPortByWGS84Rectangle(NavRectangle var1, int var2);

    public void startRouteDragging(NavLocationWgs84 var1);

    public void dragRoute(short var1, short var2);

    public void setDragRouteMarker(int var1);

    public void highlightRouteBasedOnLength(long var1, long var3, int var5);

    public void ehSetCategoryVisibility(int var1, int[] var2, boolean[] var3);

    public void ehSetCategoryVisibilityToDefault(int var1);

    public void setMapOverlays(int var1, MapOverlay[] var2, int var3, int var4);

    public void setMapLayerVisible(int[] var1);

    public void setTemperatureScale(int var1);

    public void setSoftAnimationSpeed(int var1);

    public void setSpeedAndFlowRoadClass(int var1);

    public void setRouteVisibility(boolean var1);

    public void setVisibleRoutes(NavSegmentID[] var1);

    public void showTrafficEventListView(long[] var1, boolean var2, boolean var3);

    public void setMapStyle(int var1);

    public void setCopyrightPosition(NavRectangle var1, int var2, int var3);
}

