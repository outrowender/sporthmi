/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.LIExtData;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.NavLastDest;
import org.dsi.ifc.navigation.NavPoiInfoConfiguration;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteOptions;
import org.dsi.ifc.navigation.TryBestMatchData;
import org.dsi.ifc.navigation.TryMatchLocationData;

public interface DSINavigation
extends DSIBase {
    public static final String VERSION = "2.11.71";
    public static final int ATTR_AFAMODE = 1;
    public static final int ATTR_AFASPEAKING = 2;
    public static final int ATTR_ETCDEMOMODESTATE = 4;
    public static final int ATTR_ETCLANGUAGELOADPROGRESS = 5;
    public static final int ATTR_ETCLANGUAGELOADSTATUS = 6;
    public static final int ATTR_ETCMETRICSYSTEM = 7;
    public static final int ATTR_DMLASTDESTINATIONSLIST = 8;
    public static final int ATTR_DMRECENTROUTESLIST = 9;
    public static final int ATTR_LISPISSPELLERACTIVE = 10;
    public static final int ATTR_RGACTIVE = 11;
    public static final int ATTR_RGCURRENTROUTE = 13;
    public static final int ATTR_RGCURRENTROUTEOPTIONS = 14;
    public static final int ATTR_RGLANEGUIDANCE = 64;
    public static final int ATTR_RGTURNTOSTREET = 21;
    public static final int ATTR_RGUNFULFILLEDROUTEOPTIONS = 22;
    public static final int ATTR_RGDESTINATIONINFO = 23;
    public static final int ATTR_RGSTREETLIST = 24;
    public static final int ATTR_RGPOIINFO = 25;
    public static final int ATTR_SOPOSPOSITION = 28;
    public static final int ATTR_SOPOSPOSITIONDESCRIPTION = 29;
    public static final int ATTR_RRDACTIVE = 31;
    public static final int ATTR_RRDCALCULATIONINFO = 32;
    public static final int ATTR_ETCVERSIONINFO = 34;
    public static final int ATTR_RGDETAILEDSTREETLIST = 37;
    public static final int ATTR_RMPERSISTENTROUTE = 38;
    public static final int ATTR_RGTIMEAFATODESTINATION = 39;
    public static final int ATTR_RGCALCULATEDROUTES = 42;
    public static final int ATTR_RGROUTECOSTCHANGEINFORMATION = 43;
    public static final int ATTR_TRMEMORYUTILIZATION = 45;
    public static final int ATTR_TROPERATINGMODE = 46;
    public static final int ATTR_TRTRACELIST = 47;
    public static final int ATTR_RMROUTELIST = 48;
    public static final int ATTR_RGROUTECALCULATIONSTATE = 49;
    public static final int ATTR_NAVSTATEOFOPERATION = 52;
    public static final int ATTR_NAVMEDIA = 53;
    public static final int ATTR_RGTURNLIST = 54;
    public static final int ATTR_AVAILABLELANGUAGES = 55;
    public static final int ATTR_LANGUAGE = 56;
    public static final int ATTR_DISTANCETONEXTMANEUVER = 57;
    public static final int ATTR_TRDIRECTIONTOWAYPOINT = 61;
    public static final int ATTR_POISUBSTRINGSEARCHSTATUS = 62;
    public static final int ATTR_TRRECORDINGSTATE = 63;
    public static final int ATTR_DMFLAGDESTINATION = 65;
    public static final int ATTR_LICITYHISTORY = 66;
    public static final int ATTR_LICOUNTRYFORCITYANDSTREETHISTORY = 67;
    public static final int ATTR_LISTREETHISTORY = 68;
    public static final int ATTR_RGTURNLISTCALCULATIONHORIZON = 69;
    public static final int ATTR_RGPOIINFOCALCULATIONHORIZON = 70;
    public static final int ATTR_RGINFOFORNEXTDESTINATION = 75;
    public static final int ATTR_BAPMANEUVERDESCRIPTOR = 76;
    public static final int ATTR_RGROUTEPROPERTIES = 77;
    public static final int ATTR_ETCCURRENTNAVDATABASE = 78;
    public static final int ATTR_ETCAVAILABLENAVDATABASES = 81;
    public static final int ATTR_AUDIOREQUEST = 82;
    public static final int ATTR_LITHESAURUSHISTORY = 83;
    public static final int ATTR_COUNTRYINFO = 84;
    public static final int ATTR_BAPTURNTOINFO = 85;
    public static final int ATTR_RGISTRING = 86;
    public static final int ATTR_STYLEDBPATHS = 87;
    public static final int ATTR_ROUTERESUMEPOSSIBLE = 88;
    public static final int ATTR_POISENTERINGPROXIMITYRANGE = 89;
    public static final int ATTR_ETCAVAILABLEPERSONALPOIDATABASES = 91;
    public static final int ATTR_PERSONALPOISEARCHSTATUS = 92;
    public static final int ATTR_LISTATEHISTORY = 93;
    public static final int ATTR_NAVDBREGIONSSTATE = 94;
    public static final int ATTR_TRINFOFORNEXTWAYPOINT = 95;
    public static final int ATTR_RGENHANCEDSIGNPOSTINFOSTATUS = 96;
    public static final int ATTR_SOPOSTIMEINFORMATION = 97;
    public static final int ATTR_RGVIRTUALDESTINATIONINFO = 98;
    public static final int ATTR_RGMOTORWAYINFO = 99;
    public static final int ATTR_RGTURNTOINFO = 100;
    public static final int ATTR_RGPERSISTEDROUTEDATAAVAILABLE = 101;
    public static final int ATTR_MAPINTEGRATIONSTATE = 102;
    public static final int ATTR_MAPINTEGRATIONPROGRESS = 103;
    public static final int ATTR_BAPMANEUVERSTATE = 104;
    public static final int ATTR_RMIMPORTTOURSFROMGPXFILESTATUS = 105;
    public static final int ATTR_BAPMANEUVERINFORMATION = 106;
    public static final int ATTR_PROFILESTATE = 107;
    public static final int STARTRGRETURNCODE_NOTPOSSIBLE = 0;
    public static final int STARTRGRETURNCODE_OK = 1;
    public static final int NAVLANLOADSTATUS_NLS_IDLE = 0;
    public static final int NAVLANLOADSTATUS_NLS_LOADING = 1;
    public static final int NAVLANLOADSTATUS_NLS_SUCCEEDED = 2;
    public static final int NAVLANLOADSTATUS_NLS_FAILED = 3;
    public static final int AFAMODE_AFAMODE_OFF = 0;
    public static final int AFAMODE_AFAMODE_CURRENTGUIDANCEOFF = 1;
    public static final int AFAMODE_AFAMODE_ON = 2;
    public static final int SELCRITDES_RESERVED = 0;
    public static final int SELCRITDES_COUNTRY = 1;
    public static final int SELCRITDES_TOWN = 2;
    public static final int SELCRITDES_STREET = 3;
    public static final int SELCRITDES_JUNCTION = 4;
    public static final int SELCRITDES_HOUSENUMBER = 5;
    public static final int SELCRITDES_ZIP_CODE = 6;
    public static final int SELCRITDES_TELEPHONENUMBER = 8;
    public static final int SELCRITDES_TOWNCENTER = 16;
    public static final int SELCRITDES_ROAD_DISTANCE = 122;
    public static final int SELCRITDES_NAVIGATION_INTERNAL_DATA = 121;
    public static final int SELCRITDES_AIR_DISTANCE = 123;
    public static final int SELCRITDES_GEOGRAPHICAL_POSITION = 124;
    public static final int SELCRITDES_REFINEBYADDITONALCRITERIA = 125;
    public static final int SELCRITDES_REFINEBYINCLUSION = 126;
    public static final int SELCRITDES_REFINEBYASSOCIATION = 127;
    public static final int SELCRITDES_COUNTRYABBREVIATION = 263;
    public static final int SELCRITDES_SEGMENTID = 281;
    public static final int SELCRITDES_SUBICONINDEX = 282;
    public static final int SELCRITDES_ICONINDEX = 520;
    public static final int SELCRITDES_MMI_INTERNAL_DATA = 768;
    public static final int SELCRITDES_POI_INDEX = 1279;
    public static final int SELCRITDES_XAC_POI = 1281;
    public static final int SELCRITDES_XAC_POI_MAX = 1455;
    public static final int SELCRITDES_INDEX_TYPE = 4096;
    public static final int SELCRITDES_INDEX_VALUE = 4097;
    public static final int SELCRITDES_POI_INDEX_NAME = 16641;
    public static final int SELCRITDES_POI_INDEX_TYPE = 16642;
    public static final int SELCRITDES_POI = 32768;
    public static final int SELCRITDES_POI_BY_CLASS = 32769;
    public static final int SELCRITDES_POI_BY_CATEGORY = 32770;
    public static final int SELCRITDES_POI_BY_NAME = 32771;
    public static final int SELCRITDES_POI_BY_CHILD = 32772;
    public static final int SELCRITDES_POI_BY_CHILD_CLASS = 32773;
    public static final int SELCRITDES_POI_BY_CHILD_CATEGORY = 32774;
    public static final int SELCRITDES_POI_BY_CHILD_NAME = 32775;
    public static final int SELCRITDES_POI_BY_PHONE = 32776;
    public static final int SELCRITDES_POI_BY_TOP_POI = 32777;
    public static final int SELCRITDES_POI_BY_SUBSTRING = 32778;
    public static final int SELCRITDES_POI_BY_THESAURUS = 32779;
    public static final int SELCRITDES_POI_BY_PARENT_POI = 32780;
    public static final int SELCRITDES_POI_BY_STACK = 32781;
    public static final int SELCRITDES_STREET_FIRST = 32782;
    public static final int SELCRITDES_POI_CATEGORY_BY_UID = 32783;
    public static final int SELCRITDES_POI_ADDITIONAL_FLAGS = 32784;
    public static final int SELCRITDES_POI_MULTISUBSTRING = 32785;
    public static final int SELCRITDES_POI_FROMPOIINFO = 32786;
    public static final int SELCRITDES_MAX = 65535;
    public static final int SELCRITDES_SSPVDE_ADMINID = 16384;
    public static final int SELCRITDES_SSPVDE_CLUSTERID = 16385;
    public static final int SELCRITDES_SSPVDE_EXPORTZONE = 16386;
    public static final int SELCRITDES_URLADDRESS = 128;
    public static final int SELCRITDES_COUNTRIES_WITH_VIGNETTE = 129;
    public static final int SELCRITDES_CITIES_WITH_VIGNETTE = 130;
    public static final int SELCRITDES_VIAPOINTS = 131;
    public static final int SELCRITDES_LICENSEPLATE_CODE = 133;
    public static final int SELCRITDES_VIAPOINTCOUNTRYLIST = 134;
    public static final int SELCRITDES_HOUSENUMBER_FREETEXT = 135;
    public static final int SELCRITDES_HOUSENUMBER_ALTERNATIVES = 136;
    public static final int SELCRITDES_TOWN_AND_ZIP = 137;
    public static final int SELCRITDES_STATE = 138;
    public static final int SELCRITDES_COUNTRY_STATE = 139;
    public static final int SELCRITDES_HOUSENUMBER_EXTENDED_ALTERNATIVES = 140;
    public static final int SELCRITDES_STREET_FULLNAME = 141;
    public static final int SELCRITDES_MAPCODE = 142;
    public static final int SELCRITDES_DISTRICT = 143;
    public static final int SELCRITDES_CHOME = 144;
    public static final int SELCRITDES_TOWN_WITHOUTDISTRICT = 145;
    public static final int SELCRITDES_POI_BY_BUILDING = 146;
    public static final int SELCRITDES_PLACENAME = 147;
    public static final int SELCRITDES_SUBMUNICIPALTOWN = 148;
    public static final int SELCRITDES_VILLAGE = 149;
    public static final int SELCRITDES_SUBMUNICIPALTOWN_AND_STREET = 150;
    public static final int SELCRITDES_VILLAGE_AND_STREET = 151;
    public static final int SELCRITDES_WARD = 152;
    public static final int SELCRITDES_POI_BY_TPEG = 153;
    public static final int SELCRITDES_HOUSENUMBER_BYSDS = 154;
    public static final int ISLIT_ATTR_UNKNOWN = 0;
    public static final int ISLIT_ATTR_NAME = 1;
    public static final int ISLIT_ATTR_TYPE = 2;
    public static final int ISLIT_ATTR_SUBTYPE = 3;
    public static final int ISLIT_ATTR_COUNTRY = 4;
    public static final int ISLIT_ATTR_CITYNAME = 5;
    public static final int ISLIT_ATTR_HOUSENUMBER = 6;
    public static final int ISLIT_ATTR_STREET = 7;
    public static final int ISLIT_ATTR_POSTALAREA = 8;
    public static final int ISLIT_ATTR_PHONENUMBER = 9;
    public static final int ISLIT_ATTR_FAXNUMBER = 10;
    public static final int ISLIT_ATTR_BRAND = 11;
    public static final int ISLIT_ATTR_TOCOUNTRY = 12;
    public static final int ISLIT_ATTR_FOODTYPE = 13;
    public static final int ISLIT_ATTR_PARKINGTYPE = 14;
    public static final int ISLIT_ATTR_SPECIAL = 15;
    public static final int ISLIT_ATTR_GEOPOS = 16;
    public static final int ISLIT_ATTR_TOCOUNTRYID = 17;
    public static final int ISLIT_ATTR_ONAME = 18;
    public static final int ISLIT_ATTR_PREMIUMTYPE = 19;
    public static final int ISLIT_ATTR_SUPERTYPE = 20;
    public static final int ISLIT_ATTR_ROUTEPATCHEDGEOPOS = 21;
    public static final int ISLIT_ATTR_HTMLFILEREFERENCE = 22;
    public static final int ISLIT_NUMBEROFATTRS = 23;
    public static final int ISLIT_ATTR_GEOPOS_NVC = 24;
    public static final int ISLIT_ATTR_GEOPOS_MULTISUBSTRING = 25;
    public static final int ISLIT_ATTR_ALTROTATIONBIT = 128;
    public static final int DATATYPE_NODATA = 0;
    public static final int DATATYPE_STRING = 1;
    public static final int DATATYPE_U8 = 2;
    public static final int DATATYPE_S8 = 3;
    public static final int DATATYPE_U16 = 4;
    public static final int DATATYPE_S16 = 5;
    public static final int DATATYPE_U32 = 6;
    public static final int DATATYPE_S32 = 7;
    public static final int DATATYPE_E8 = 8;
    public static final int DATATYPE_B8 = 9;
    public static final int DATATYPE_S16_LENGTH10M = 10;
    public static final int DATATYPE_S16_LENGTH100M = 11;
    public static final int DATATYPE_CLOCKTIME = 12;
    public static final int DATATYPE_DATE = 13;
    public static final int DATATYPE_S16_TIMEMINUTES = 14;
    public static final int DATATYPE_S16_SPEEDCMS = 15;
    public static final int DATATYPE_U8_DIRECTIONABSOLUTE = 16;
    public static final int DATATYPE_U8_DIRECTIONRELATIVE = 17;
    public static final int DATATYPE_POSITIONWGS84 = 18;
    public static final int DATATYPE_LOCATIONDESCRIPTION = 19;
    public static final int DATATYPE_S32_LENGTH10M = 20;
    public static final int DATATYPE_CONTAINER = 21;
    public static final int DATATYPE_B16 = 22;
    public static final int DATATYPE_OLDCONTAINER = 23;
    public static final int ROUTEDESTINATIONTYPE_RESERVED = 0;
    public static final int ROUTEDESTINATIONTYPE_HARDDESTINATION = 1;
    public static final int ROUTEDESTINATIONTYPE_SOFTDESTINATION = 2;
    public static final int ROUTEDESTINATIONTYPE_WAYPOINT = 128;
    public static final int METRICSYSTEM_RESERVED = 0;
    public static final int METRICSYSTEM_DEFAULT = 1;
    public static final int METRICSYSTEM_KILOMETERS_METERS = 2;
    public static final int METRICSYSTEM_IMPERIAL_GB_MILES_YARDS = 3;
    public static final int METRICSYSTEM_IMPERIAL_US_MILES_FEET = 4;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CENTER = 0;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CITY_FOR_COUNTRY = 1;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_COUNTRY = 2;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_HOUSENR = 3;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_LASTDEST = 4;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_CITY = 5;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_ZIP = 6;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_POI = 7;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_JUNCTION = 8;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_POI_TYPE = 9;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_POI_VALUE = 10;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_VICINITY = 11;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CITY_AND_STREET = 12;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_COUNTRY = 13;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CITY_FOR_STREET = 14;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STATE = 15;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CITY_FOR_STATE = 16;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_STATE = 17;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_HOUSENUMBER_FOR_STATE = 18;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_HOUSENUMBER_FOR_COUNTRY = 19;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_DISTRICT = 20;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_CHOME = 21;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_DISTRICT = 22;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_SUBMUNICIPALTOWN = 23;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_STREET_FOR_SUBMUNICIPALTOWN = 24;
    public static final int DESTINATIONTYPE_DESTINATION_TYPE_PLACENAME = 25;
    public static final int ICONTYPE_ROAD = 0;
    public static final int ICONTYPE_POI = 1;
    public static final int ICONTYPE_TMC_EVENT = 2;
    public static final int ICONTYPE_ROAD_CLASS = 3;
    public static final int ICONTYPE_TRAFFIC_REGULATION = 4;
    public static final int ICONTYPE_TARGET = 5;
    public static final int ICONTYPE_ROADSEGMENT_PROPERTY = 6;
    public static final int INPUTTYPE_FULL_WORD = 0;
    public static final int INPUTTYPE_SPELLING = 1;
    public static final int FILESTATUS_FILE_STATUS_AVAILABLE = 0;
    public static final int FILESTATUS_FILE_STATUS_PROVIDING_NOT_FINISHED = 1;
    public static final int POIMODE_CURRENT_POSITION = 0;
    public static final int POIMODE_NATIONWIDE = 1;
    public static final int POIMODE_ON_ROUTE = 2;
    public static final int POIMODE_OTHER_TOWN = 3;
    public static final int POIMODE_POI_PHONE_NUMBER = 4;
    public static final int POIMODE_POI_SHORTCUT = 5;
    public static final int POIMODE_STOPOVER_POSITION = 6;
    public static final int POIMODE_TARGET_POSITION = 7;
    public static final int POILISTSTYLE_DEFAULT = 0;
    public static final int POILISTSTYLE_FLAT = 1;
    public static final int POILISTSTYLE_HIERARCHICAL = 2;
    public static final int DESTINATIONSET_AMBIGUOUS = 0;
    public static final int DESTINATIONSET_NOT_AMBIGUOUS = 1;
    public static final int DESTINATIONSET_INVALID = 2;
    public static final int ITEMCHECK_ITEM_CHECK_AMBIGUOUS = 0;
    public static final int ITEMCHECK_ITEM_CHECK_HIERARCHICAL = 1;
    public static final int ITEMCHECK_ITEM_CHECK_NOTAMBIGUOUS = 2;
    public static final int ITEMCHECK_ITEM_CHECK_NOTVALID = 3;
    public static final int ITEMCHECK_ITEM_CHECK_INVALIDVALUE = 4;
    public static final int LIVALUELISTOUTPUTMETHOD_DSI = 0;
    public static final int LIVALUELISTFILESTATUS_COMPLETE = 1;
    public static final int LIVALUELISTFILESTATUS_ERROR = 0;
    public static final int LIVALUELISTFILETYPE_DYNAMIC = 0;
    public static final int LIVALUELISTFILETYPE_STATIC = 1;
    public static final int MANEUVERELEMENTELEMENT_NOSYMBOL = 0;
    public static final int MANEUVERELEMENTELEMENT_NOINFO = 1;
    public static final int MANEUVERELEMENTELEMENT_DIRECTIONTODESTINATION = 2;
    public static final int MANEUVERELEMENTELEMENT_ARRIVED = 3;
    public static final int MANEUVERELEMENTELEMENT_NEARDESTINATION = 4;
    public static final int MANEUVERELEMENTELEMENT_ARRIVEDDESTINATIONOFFROAD = 5;
    public static final int MANEUVERELEMENTELEMENT_OFFROAD = 6;
    public static final int MANEUVERELEMENTELEMENT_OFFMAP = 7;
    public static final int MANEUVERELEMENTELEMENT_NOROUTE = 8;
    public static final int MANEUVERELEMENTELEMENT_CALCROUTE = 9;
    public static final int MANEUVERELEMENTELEMENT_RECALCROUTE = 10;
    public static final int MANEUVERELEMENTELEMENT_FOLLOWSTREET = 11;
    public static final int MANEUVERELEMENTELEMENT_CHANGELANE = 12;
    public static final int MANEUVERELEMENTELEMENT_TURN = 13;
    public static final int MANEUVERELEMENTELEMENT_TURNONMAINROAD = 14;
    public static final int MANEUVERELEMENTELEMENT_EXITRIGHT = 15;
    public static final int MANEUVERELEMENTELEMENT_EXITLEFT = 16;
    public static final int MANEUVERELEMENTELEMENT_SERVICEROADRIGHT = 17;
    public static final int MANEUVERELEMENTELEMENT_SERVICEROADLEFT = 18;
    public static final int MANEUVERELEMENTELEMENT_FORK2 = 19;
    public static final int MANEUVERELEMENTELEMENT_FORK3 = 20;
    public static final int MANEUVERELEMENTELEMENT_ROUNDABOUTTRSRIGHT = 21;
    public static final int MANEUVERELEMENTELEMENT_ROUNDABOUTTRSLEFT = 22;
    public static final int MANEUVERELEMENTELEMENT_SQUARETRSRIGHT = 23;
    public static final int MANEUVERELEMENTELEMENT_SQUARETRSLEFT = 24;
    public static final int MANEUVERELEMENTELEMENT_UTURN = 25;
    public static final int MANEUVERELEMENTELEMENT_EXITROUNDABOUTTRSRIGHT = 26;
    public static final int MANEUVERELEMENTELEMENT_EXITROUNDABOUTTRSLEFT = 27;
    public static final int MANEUVERELEMENTELEMENT_PREPARETURN = 28;
    public static final int MANEUVERELEMENTELEMENT_PREPAREROUNDABOUT = 29;
    public static final int MANEUVERELEMENTELEMENT_PREPARESQUARE = 30;
    public static final int MANEUVERELEMENTELEMENT_PREPAREUTURN = 31;
    public static final int MANEUVERELEMENTELEMENT_EXITRIGHTRAMPUP = 32;
    public static final int MANEUVERELEMENTELEMENT_EXITRIGHTRAMPDOWN = 33;
    public static final int MANEUVERELEMENTELEMENT_MICHIGANTURN = 34;
    public static final int MANEUVERELEMENTELEMENT_DOUBLETURN = 35;
    public static final int MANEUVERELEMENTELEMENT_EXITLEFTRAMPUP = 36;
    public static final int MANEUVERELEMENTELEMENT_EXITLEFTRAMPDOWN = 37;
    public static final int MANEUVERELEMENTELEMENT_DIRECTIONTOWAYPOINT = 38;
    public static final int MANEUVERELEMENTELEMENT_SIDESTREET = 128;
    public static final int MANEUVERELEMENTELEMENT_PROHIBITEDSIDESTREET = 129;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_TRAFFICINFORMATION_CAUSING_DELAY = 130;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_TRAFFICINFORMATION_NOT_CAUSING_DELAY = 131;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_VIGNETTE_OBLIGATION = 132;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_TOLL_OBLIGATION = 133;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_LOW_PETROL_LEVEL = 134;
    public static final int MANEUVERELEMENTELEMENT_LASTEXIT_BEFORE_BORDER_CROSSING = 135;
    public static final int MANEUVERELEMENTELEMENT_START_HOV_LANE = 256;
    public static final int MANEUVERELEMENTELEMENT_LEAVE_HOV_LANE = 257;
    public static final int MANEUVERELEMENTELEMENT_BORDER_CROSSING = 136;
    public static final int MANEUVERELEMENTELEMENT_DRIVE_ONTO_FERRY = 137;
    public static final int MANEUVERELEMENTELEMENT_DRIVE_OFF_FERRY = 138;
    public static final int MANEUVERELEMENTELEMENT_DRIVE_ONTO_CARTRAIN = 139;
    public static final int MANEUVERELEMENTELEMENT_DRIVE_OFF_CARTRAIN = 140;
    public static final int MANEUVERELEMENTATTRIBUTE_ENTRYSTREET = 128;
    public static final int MANEUVERELEMENTATTRIBUTE_SINGLECARRIAGE = 64;
    public static final int MANEUVERELEMENTATTRIBUTE_MULTICARRIAGE = 32;
    public static final int MANEUVERELEMENTATTRIBUTE_ABSTRACT_MTWY_EXIT = 33;
    public static final int MANEUVERELEMENTATTRIBUTE_ABSTRACT_MANEUVER_MTWY_CHANGE = 34;
    public static final int MANEUVERELEMENTATTRIBUTE_AUDIBLE = 1;
    public static final int CRITERIANUMBER_CLASS_PPOI = 10;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_RESTAREA_WC = 19;
    public static final int CRITERIANUMBER_CLASS_PARK_AND_REFUEL = 41;
    public static final int CRITERIANUMBER_CATEGORY_PETROLSTATION = 56;
    public static final int CRITERIANUMBER_CATEGORY_MOTORWAYEXIT = 1;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_PETROLSTATION = 101;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_PARKINGLOT = 102;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_RESTSTOP = 103;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_RESTAURANT = 104;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_HOTEL = 105;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_AUDISERVICE = 106;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_RAILROADSTATION = 107;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_AIRPORT = 108;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_HOSPITAL = 109;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_VW_SERVICE = 110;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_BENTLEY_SERVICE = 111;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_PORSCHE_SERVICE = 112;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_CONVENIENCE_STORE = 113;
    public static final int CRITERIANUMBER_CLASS_PARKING = 119;
    public static final int CRITERIANUMBER_CLASS_REFUEL = 120;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_PETROLSTATION_DIESEL_NAR = 121;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_POLICE_NAR = 127;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_ATM_NAR = 128;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_COFFEESHOP_NAR = 129;
    public static final int CRITERIANUMBER_CATEGORY_SPEEDCAMERA = 130;
    public static final int CRITERIANUMBER_CATEGORY_OTHERCAMERA = 131;
    public static final int CRITERIANUMBER_CATEGORY_CHARGINGSTATION_FAST = 132;
    public static final int CRITERIANUMBER_CATEGORY_CHARGINGSTATION_NORMAL = 133;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_CHARGINGSTATION = 134;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_CNGSTATION = 135;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_LPGSTATION = 136;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_HYDROGENSTATION = 137;
    public static final int CRITERIANUMBER_CATEGORY_NEXT_E100ETHANOLSTATION = 138;
    public static final int CRITERIANUMBER_CATEGORY_PPOI_CHARGINGSTATION_FAST = 150;
    public static final int CRITERIANUMBER_CATEGORY_PPOI_CHARGINGSTATION_NORMAL = 151;
    public static final int TBMSTATE_OK = 0;
    public static final int TBMSTATE_UNKNOWN = 1;
    public static final int TBMSTATE_MISSING = 2;
    public static final int TBMSTATE_AMBIGIOUS = 3;
    public static final int TBMSTATE_INCONSISTENT = 4;
    public static final int TBMSTATE_INCOMPLETE = 5;
    public static final int GUIDANCE_MODE_COMPACT = 0;
    public static final int GUIDANCE_MODE_COMPLETE = 1;
    public static final int GUIDANCE_MODE_TRAFFIC = 2;
    public static final int GUIDANCE_MODE_OFF = 3;
    public static final int TRACERECORDINGMODE_DELETESTART = 0;
    public static final int TRACERECORDINGMODE_RESUMESTART = 1;
    public static final int NAVRESULTCODE_OK = 0;
    public static final int NAVRESULTCODE_NOT_OPERABLE = 1;
    public static final int NAVRESULTCODE_ERROR = 2;
    public static final int NAVRESULTCODE_UNSUPPORTED = 3;
    public static final int TRACEERROR_NOERROR = 0;
    public static final int TRACEERROR_COMMUNICATION = 1;
    public static final int TRACEERROR_WRONGTRACEID = 2;
    public static final int TRACEERROR_NOTRACEMEMORY = 3;
    public static final int TRACEOPERATINGMODE_DEFAULT = 0;
    public static final int TRACEOPERATINGMODE_AUTOMATIC = 1;
    public static final int TRACEOPERATINGMODE_EQUIDISTANT = 2;
    public static final int TRACEOPERATINGMODE_DISABLE = 3;
    public static final int RMID_WAYPOINTROUTES = 0;
    public static final int RMID_ROUTEPLAN = 1;
    public static final int RMID_PRESSROUTES = 2;
    public static final int ROUTECALCULATIONSTATE_IDLE = 0;
    public static final int ROUTECALCULATIONSTATE_CALCULATING = 1;
    public static final int ROUTECALCULATIONSTATE_READY = 2;
    public static final int ROUTECALCULATIONSTATE_RUBBERBANDREADY = 3;
    public static final int AFAREPEATSOURCE_NAV_INFO_REPEAT = 0;
    public static final int AFAREPEATSOURCE_MFL_REPEAT = 1;
    public static final int AFAREPEATSOURCE_SDS_REPEAT = 2;
    public static final int AFAREPEATSOURCE_ANNOUNCE_SELECT_ROUTE = 3;
    public static final int AFAREPEATSOURCE_ANNOUNCE_BLOCKEDROUTE = 4;
    public static final int AFAREPEATSOURCE_ANNOUNCE_MUCHBETTERROUTE = 5;
    public static final int AFAREPEATSOURCE_ANNOUNCE_EMERGENCYEVENT = 6;
    public static final int NAVSTATEOFOPERATION_UNKNOWN = 0;
    public static final int NAVSTATEOFOPERATION_DISKREQUEST_NOT_ACTIVATED = 1;
    public static final int NAVSTATEOFOPERATION_DISKREQUEST_DAMAGED = 2;
    public static final int NAVSTATEOFOPERATION_DISKREQUEST_EJECT = 3;
    public static final int NAVSTATEOFOPERATION_DISKREQUEST_DISKERROR = 4;
    public static final int NAVSTATEOFOPERATION_FULLY_OPERABLE = 5;
    public static final int NAVSTATEOFOPERATION_NOT_COMPATIBLE = 6;
    public static final int NAVSTATEOFOPERATION_NOT_IDENTICAL_MEDIUM = 7;
    public static final int NAVSTATEOFOPERATION_CHECKING_MEDIUM = 8;
    public static final int NAVSTATEOFOPERATION_NO_COMPLETE_DATA = 9;
    public static final int NAVSTATEOFOPERATION_REINITIALISATION = 10;
    public static final int NAVSTATEOFOPERATION_LOCKED = 11;
    public static final int NAVSTATEOFOPERATION_READY4NAV = 12;
    public static final int NAVSTATEOFOPERATION_GLOVE_BOX_OPEN = 13;
    public static final int NAVSTATEOFOPERATION_REINIT_CUSTOMERUPDATE = 14;
    public static final int ADDITIONALFLAG_POI_24H = 1;
    public static final int ADDITIONALFLAG_POI_3D = 2;
    public static final int ADDITIONALFLAG_POI_PREMIUM = 4;
    public static final int ADDITIONALFLAG_POI_DIESEL = 8;
    public static final int ADDITIONALFLAG_ISSTREETBASENAME = 16;
    public static final int ADDITIONALFLAG_POI_PAYBYCREDITCARD = 32;
    public static final int ADDITIONALFLAG_POI_PARKINGPOSSIBLE = 64;
    public static final int ADDITIONALFLAG_ISLOCATIONINCITYSTATE = 0x2000000;
    public static final int ADDITIONALFLAG_IS_SPELLED_STATE = 0x4000000;
    public static final int ADDITIONALFLAG_ISFULLPOSTALCODE = 0x8000000;
    public static final int ADDITIONALFLAG_NEEDEDFORREFINEMENT_TOWNREFINEMENT = 0x10000000;
    public static final int ADDITIONALFLAG_NEEDEDFORREFINEMENT_ZIPCODE = 0x20000000;
    public static final int ADDITIONALFLAG_ISSPELLED_ZIPCODE = 0x40000000;
    public static final int ADDITIONALFLAG_TOWNISORDER9 = Integer.MIN_VALUE;
    public static final int BOOLEANVALUE_UNDEFINED = -1;
    public static final int BOOLEANVALUE_FALSE = 0;
    public static final int BOOLEANVALUE_TRUE = 1;
    public static final int ADDITIONALPOIATTRIBUTE_PROVIDER = 0;
    public static final int ADDITIONALPOIATTRIBUTE_PAY = 1;
    public static final int ADDITIONALPOIATTRIBUTE_SUBSCRIPTION = 2;
    public static final int ADDITIONALPOIATTRIBUTE_ON_SITE_PAYMENT = 3;
    public static final int ADDITIONALPOIATTRIBUTE_ACCESS = 4;
    public static final int ADDITIONALPOIATTRIBUTE_OPEN_24_H = 5;
    public static final int ADDITIONALPOIATTRIBUTE_ADDITIONALINFO = 6;
    public static final int ADDITIONALPOIATTRIBUTEACCESS_INVALID = -1;
    public static final int ADDITIONALPOIATTRIBUTEACCESS_PRIVATE = 0;
    public static final int ADDITIONALPOIATTRIBUTEACCESS_PUBLIC = 1;
    public static final int ADDITIONALPOIATTRIBUTEACCESS_SEMI_PRIVATE = 2;
    public static final int ADDITIONALPOIATTRIBUTEACCESS_SEMI_PUBLIC = 3;
    public static final int CONNECTORATTRIBUTE_CHARGE_MODE = 0;
    public static final int CONNECTORATTRIBUTE_CHARGE_LEVEL = 1;
    public static final int CONNECTORATTRIBUTE_NAME = 2;
    public static final int CONNECTORATTRIBUTE_TYPE = 3;
    public static final int CONNECTORATTRIBUTE_FUSE_PROTECTION = 4;
    public static final int CONNECTORATTRIBUTE_POWER_OUTPUT = 5;
    public static final int CONNECTORATTRIBUTE_COUNT_AVAILABLE = 6;
    public static final int CONNECTORATTRIBUTETYPE_UNSPECIFIED = -1;
    public static final int CONNECTORATTRIBUTETYPE_DOMESTIC = 15;
    public static final int CONNECTORATTRIBUTETYPE_TYPE_1 = 32;
    public static final int CONNECTORATTRIBUTETYPE_TYPE_2 = 33;
    public static final int CONNECTORATTRIBUTETYPE_COMBO_1 = 42;
    public static final int CONNECTORATTRIBUTETYPE_COMBO_2 = 43;
    public static final int CONNECTORATTRIBUTETYPE_CHADEMO = 31;
    public static final int CONNECTORATTRIBUTETYPE_OTHER = 41;
    public static final int POISORTORDER_NATURAL = 0;
    public static final int POISORTORDER_ALPHABETICALLY = 1;
    public static final int POISORTORDER_BY_DISTANCE = 2;
    public static final int DESTINATIONSTATUS_AVAILABLE = 0;
    public static final int DESTINATIONSTATUS_NAVIGABLE = 1;
    public static final int DESTINATIONSTATUS_NOT_AVAILABLE = 2;
    public static final int DESTINATIONSTATUS_NOT_DEFINED = 3;
    public static final int DESTINATIONSTATUS_NOT_NAVIGABLE = 4;
    public static final int CALCULATIONSTATE_NOT_CALCULATED = 0;
    public static final int CALCULATIONSTATE_CALCULATING = 1;
    public static final int CALCULATIONSTATE_PRELIMINARY_CALCULATED = 2;
    public static final int CALCULATIONSTATE_CALCULATED = 3;
    public static final int CALCULATIONSTATE_CALCULATION_FAILED = 4;
    public static final int CALCULATIONSTATE_RGACTIVE = 5;
    public static final int POISEARCHSTATUS_INVALID = 0;
    public static final int POISEARCHSTATUS_CANCELED = 1;
    public static final int POISEARCHSTATUS_RUNNING = 2;
    public static final int POISEARCHSTATUS_FINISHED = 3;
    public static final int ROUTEID_ONROAD = 0;
    public static final int ROUTEID_WAYPOINT = 1;
    public static final int ROUTEID_TRAIL = 2;
    public static final int TRACERECORDINGSTATE_INVALID = 0;
    public static final int TRACERECORDINGSTATE_IDLE = 1;
    public static final int TRACERECORDINGSTATE_ACTIVE = 2;
    public static final int TRACERECORDINGSTATE_BUFFER_FULL = 3;
    public static final int ROUTECALCTYPE_FAST = 0;
    public static final int ROUTECALCTYPE_SHORT = 1;
    public static final int ROUTECALCTYPE_SCENIC_1 = 2;
    public static final int ROUTECALCTYPE_SCENIC_2 = 3;
    public static final int ROUTECALCTYPE_WAYPOINT = 4;
    public static final int ROUTECALCTYPE_OPTIMAL = 5;
    public static final int ROUTECALCTYPE_EFFICIENCY = 6;
    public static final int ROUTECALCTYPE_ECOLOGICAL = 7;
    public static final int ROUTECALCTYPE_ACTIVEROUTE = 8;
    public static final int ROUTECALCTYPE_FAST_DYNAMIC = 9;
    public static final int ROUTECALCTYPE_ECOLOGICAL_DYNAMIC = 10;
    public static final int ROUTEOPTHYBRIDMODE_NO = 0;
    public static final int ROUTEOPTHYBRIDMODE_MID = 1;
    public static final int ROUTEOPTHYBRIDMODE_FULL = 2;
    public static final int ROUTEOPTHYBRIDMODE_ECAR = 3;
    public static final int ROUTEOPTSTATE_UNKNOWN = -1;
    public static final int ROUTEOPTSTATE_IGNORE = 0;
    public static final int ROUTEOPTSTATE_USE = 1;
    public static final int ROUTEOPTSTATE_EXCLUDE = 2;
    public static final int ROUTEOPTSTATE_AVOID = 3;
    public static final int ROUTEOPTSTATE_PREFER = 4;
    public static final int ROUTEOPTSTATE_AUTOMATIC = 5;
    public static final int ROUTEOPTSTATE_ENABLE = 6;
    public static final int ROUTEOPTSTATE_DISABLE = 7;
    public static final int ROUTEOPTSTATE_EXCLUDE_EXCEPTLIST = 8;
    public static final int ROUTEOPTSTATE_AVOID_EXCEPTLIST = 9;
    public static final int ROUTEOPTSTATE_MANUAL = 10;
    public static final int ROUTEOPTSTATE_MANUAL_TMC = 11;
    public static final int ROUTEOPTTRAIL_OFF = 0;
    public static final int ROUTEOPTTRAIL_FORWARD = 1;
    public static final int ROUTEOPTTRAIL_FORWARD_ENTER = 2;
    public static final int ROUTEOPTTRAIL_BACKWARD_ENTER = 3;
    public static final int ROUTEOPTTRAIL_BACKWARD = 4;
    public static final int ROUTEOPTWAY_ON = 0;
    public static final int ROUTEOPTWAY_MAP_MATCHER_OFF = 1;
    public static final int ROUTEOPTWAY_OFF = 2;
    public static final int ROUTESTYLEID_DEFAULT = 0;
    public static final int ROUTEOPTHOVLANES_DONT_USE = 0;
    public static final int ROUTEOPTHOVLANES_USE_ALL = 1;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_2 = 2;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_3 = 3;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_4 = 4;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_5 = 5;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_6 = 6;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_7 = 7;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_8 = 8;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_9 = 9;
    public static final int ROUTEOPTHOVLANES_MINIMUMPASSENGERS_10 = 10;
    public static final int GPSSTATE_NOFIX = 0;
    public static final int GPSSTATE_2DFIX = 1;
    public static final int GPSSTATE_3DFIX = 2;
    public static final int GPSSTATE_ANTENNA_NOT_CONNECTED = 3;
    public static final int GPSSTATE_ERROR = 4;
    public static final int RELIABILITY_BIT_CALIBRATED = 512;
    public static final int RELIABILITY_BIT_MATCHED_TO_DIGITAL_MAP = 1024;
    public static final int RELIABILITY_BIT_INSIDE_DIGITIZED_AREA = 4096;
    public static final int NAV_GPS_TICKS_PER_DEGR = 0xB60B60;
    public static final int NAV_GPS_TICKS_PER_MIN = 198841;
    public static final int NAV_GPS_TICKS_PER_SEC = 3314;
    public static final int RGERROR_NOT_EXISTS = 1;
    public static final int RGERROR_POS_AQUISITION = 2;
    public static final int RGERROR_SYSTEM_ERROR = 3;
    public static final int RGEXCEPTION_SPECIAL_ROADCLASS = 1;
    public static final int RGEXCEPTION_ROUTE_CHANGED = 4;
    public static final int RGEXCEPTION_ROUTE_CRITERIA = 5;
    public static final int RGEXCEPTION_DESTINATION_INACCESSIBLE = 6;
    public static final int LOCATIONTYPE_DEFAULT = 0;
    public static final int LOCATIONTYPE_POI = 1;
    public static final int LOCATIONTYPE_GEOGRAPHICAL_POSITION = 2;
    public static final int LOCATIONTYPE_TRACEREFERENCE = 3;
    public static final int LOCATIONTYPE_TPEGPOI = 4;
    public static final int LATEST_VERSION_OF_LOCATION_STRUCTURE = 10;
    public static final int AUDIOMODE_START = 0;
    public static final int AUDIOMODE_REPEAT = 1;
    public static final int AUDIOMODE_ABORT = 2;
    public static final int AUDIOMODE_PROCESSING = 3;
    public static final int AUDIOMODE_STOPPED = 4;
    public static final int AUDIOMODE_ABORTED = 5;
    public static final int AUDIOMODE_ERROR_BUSY = 6;
    public static final int AUDIOMODE_ERROR_NOT_POSSIBLE = 7;
    public static final int AUDIOMODE_ERROR_REGISTRATION_MISSING = 8;
    public static final int AUDIOMODE_ERROR_INTERNAL = 9;
    public static final int AUDIOSTATE_ACTIVE = 1;
    public static final int AUDIOSTATE_IDLE = 2;
    public static final int AUDIOSTATE_REQUEST = 3;
    public static final int AUDIOSTATE_ERROR = 4;
    public static final int MAPSETTYPE_STANDARD = 0;
    public static final int MAPSETTYPE_GOOGLE = 1;
    public static final int MAPSETTYPE_TRAFFIC = 2;
    public static final int MAPSETTYPE_SMALLMAP = 3;
    public static final int SPELLERINPUTFORMAT_NUMERIC = 1;
    public static final int SPELLERINPUTFORMAT_ALPHABETIC = 2;
    public static final int SPELLERINPUTFORMAT_SPECIAL = 4;
    public static final int PERSONALPOISEARCHSTATUS_FULLY_OPERABLE = 0;
    public static final int PERSONALPOISEARCHSTATUS_NOT_OPERABLE = 1;
    public static final int VEHICLEFUELTYPE_REGULAR = 0;
    public static final int VEHICLEFUELTYPE_DIESEL = 1;
    public static final int VEHICLEFUELTYPE_LPG = 2;
    public static final int VEHICLEFUELTYPE_CNG = 3;
    public static final int VEHICLEFUELTYPE_ELECTRIC = 4;
    public static final int CURRENCY_INVALID = 0;
    public static final int CURRENCY_EUR_1000 = 1;
    public static final int CURRENCY_CNY_1000 = 2;
    public static final int CURRENCY_USD_1000 = 3;
    public static final int CURRENCY_GBP_1000 = 4;
    public static final int EXTDATATYPE_UNKNOWN = 0;
    public static final int EXTDATATYPE_PINYIN_UF = 1;
    public static final int EXTDATATYPE_CHINESE_UF = 2;
    public static final int EXTDATATYPE_ENGLISH_UF = 3;
    public static final int EXTDATATYPE_FULLSTREETNAME_UF = 4;
    public static final int EXTDATATYPE_BASENAME_UF = 5;
    public static final int EXTDATATYPE_PHONEME = 6;
    public static final int EXTDATATYPE_PHONEMEALPHABET = 7;
    public static final int EXTDATATYPE_BASENAMEAFFIX = 8;
    public static final int EXTDATATYPE_JUNCTIONNAME = 9;
    public static final int EXTDATATYPE_TOWN = 10;
    public static final int EXTDATATYPE_TOWNDISAMBIGUATION = 11;
    public static final int EXTDATATYPE_HOUSENUMBER = 12;
    public static final int EXTDATATYPE_STREETDISAMBIGUATION = 13;
    public static final int EXTDATATYPE_BUILDING_FLOORNUMBER = 14;
    public static final int EXTDATATYPE_POINAME = 15;
    public static final int EXTDATATYPE_COMPLETEADDRESS = 16;
    public static final int TRYMATCHLOCATIONLEVEL_UNKNOWN = 0;
    public static final int TRYMATCHLOCATIONLEVEL_FULL = 1;
    public static final int TRYMATCHLOCATIONLEVEL_COORDINATE = 2;
    public static final int TRYMATCHLOCATIONLEVEL_ADDRESS_FULL = 3;
    public static final int TRYMATCHLOCATIONLEVEL_ADDRESS_PARTIAL = 4;
    public static final int TRYMATCHLOCATIONLEVEL_HOUSENUMBER_INCORRECT = 5;
    public static final int TRYMATCHLOCATIONLEVEL_HOUSENUMBER_INCOMPLETE = 6;
    public static final int TRYMATCHLOCATIONORIGIN_UNDEFINED = 0;
    public static final int TRYMATCHLOCATIONORIGIN_INTERNAL = 1;
    public static final int TRYMATCHLOCATIONORIGIN_EXTERNAL = 2;
    public static final int TRIPTIMESTATUS_UNDEFINED = 0;
    public static final int TRIPTIMESTATUS_AVAILABLEANDVALID = 1;
    public static final int TRIPTIMESTATUS_UNRELIABLE = 2;
    public static final int DBREGIONCHECKRESULT_OK = 0;
    public static final int DBREGIONCHECKRESULT_NOK = 1;
    public static final int DBREGIONCHECKRESULT_UNKNOWN = 2;
    public static final int DBREGIONCHECKRESULT_CUSTOMER_DL = 3;
    public static final int TRDATARESULT_OK = 0;
    public static final int TRDATARESULT_FAILED = 1;
    public static final int TRDATARESULT_MEMOVERFLOW = 2;
    public static final int TRDATARESULT_INVALIDVALUES = 3;
    public static final int TRDATARESULT_NOMEDIUM = 4;
    public static final int TRDATARESULT_WRITEPROTECTED = 5;
    public static final int TRDATARESULT_NOTENOUGHDISKSPACE = 6;
    public static final int TRDATARESULT_TRACKMEMORYFULL = 7;
    public static final int NVCRANGE_DEFAULT = 0;
    public static final int NVCRANGE_EXCLUDE_HANZI = 1;
    public static final int NVCRANGE_INCLUDE_HANZI_TOP = 2;
    public static final int NVCRANGE_HANZI_ONLY = 3;
    public static final int NVCRANGE_INLCUDE_STROKES = 4;
    public static final int NVCRANGE_INCLUDE_STROKES = 5;
    public static final int CATEGORYADDITIONALFLAG_PROXIMITYWARNING = 1;
    public static final int PHONEMEELEMENT_COUNTRY = 0;
    public static final int PHONEMEELEMENT_STATE = 1;
    public static final int PHONEMEELEMENT_TOWN = 2;
    public static final int PHONEMEELEMENT_TOWNREFINEMENT = 3;
    public static final int PHONEMEELEMENT_TOWNCENTER = 4;
    public static final int PHONEMEELEMENT_STREET = 5;
    public static final int PHONEMEELEMENT_STREETREFINEMENT = 6;
    public static final int PHONEMEELEMENT_JUNCTION = 7;
    public static final int PHONEMEELEMENT_POINAME = 8;
    public static final int ROADCLASS_UNKNOWN = 0;
    public static final int ROADCLASS_MOTORWAY = 1;
    public static final int ROADCLASS_CARRIAGEWAY_MULTIPLE = 2;
    public static final int ROADCLASS_CARRIAGEWAY_SINGLE = 3;
    public static final int ROADCLASS_ROAD = 4;
    public static final int ROADCLASS_ROUNDABOUT = 5;
    public static final int ROADCLASS_OTHER = 6;
    public static final int TURNLISTELEMENTTYPE_UNDEFINED = 0;
    public static final int TURNLISTELEMENTTYPE_MANEUVER_NON_CONTROLLED_ACCESS = 1;
    public static final int TURNLISTELEMENTTYPE_MANEUVER_CONTROLLED_ACCESS = 2;
    public static final int TURNLISTELEMENTTYPE_MANEUVER_PASSING_POINT = 3;
    public static final int TURNLISTELEMENTTYPE_TOLLGATE = 4;
    public static final int TURNLISTELEMENTTYPE_FERRY = 5;
    public static final int TURNLISTELEMENTTYPE_TUNNEL = 6;
    public static final int TURNLISTELEMENTTYPE_DESTINATION = 7;
    public static final int TURNLISTELEMENTTYPE_WARNING_OFFROAD = 8;
    public static final int TURNLISTELEMENTTYPE_WARNING_NARROWROAD = 9;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_TIMERESTRICTION = 10;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_SEASONALRESTRICTION = 11;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_MOTORWAY = 12;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_FERRY = 13;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_TOLL = 14;
    public static final int TURNLISTELEMENTTYPE_WARNING_CRITERION_SMALLROAD = 15;
    public static final int TURNLISTICONTYPE_UNDEFINED = 0;
    public static final int TURNLISTICONTYPE_MANEUVERMARKER = 1;
    public static final int TURNLISTICONTYPE_TRAFFICLIGHT = 2;
    public static final int TURNLISTICONTYPE_TOLLGATE = 3;
    public static final int TURNLISTICONTYPE_TOLLGATE_ETC = 4;
    public static final int TURNLISTICONTYPE_FERRY = 5;
    public static final int TURNLISTICONTYPE_TUNNEL = 6;
    public static final int TURNLISTICONTYPE_DESTINATION = 7;
    public static final int NAVPOIINFOTYPE_UNDEFINED = 0;
    public static final int NAVPOIINFOTYPE_CONTROLLEDACCESS = 1;
    public static final int NAVPOIINFOTYPE_POIONROUTE = 2;
    public static final int TURNLISTMODE_UNDEFINED = 0;
    public static final int TURNLISTMODE_COMPLETE = 1;
    public static final int TURNLISTMODE_COMPACT = 2;
    public static final int TURNLISTMODE_COMPLETEWITHWARNINGS = 3;
    public static final int TURNLISTMODE_COMPACT2 = 4;
    public static final int XT9LDBMODE_COMMON_LDB = 0;
    public static final int XT9LDBMODE_VINCINITY_SEARCH = 1;
    public static final int XT9LDBMODE_ALONG_THE_ROUTE = 2;
    public static final int XT9LDBMODE_AREA_SEARCH = 3;
    public static final int CATEGORYAUDIOWARNING_ALL = -1;
    public static final int CATEGORYAUDIOWARNING_SUPPORTING = -2;
    public static final int POICATEGORYTYPE_UNDEFINED = 0;
    public static final int POICATEGORYTYPE_TOPPOI = 1;
    public static final int POICATEGORYTYPE_GENERIC = 2;
    public static final int POICATEGORYTYPE_PPOI = 3;
    public static final int POICATEGORYTYPE_OTHER = 255;
    public static final int ADDITIONALROUTEDATAKEY_UNDEFINED = 0;
    public static final int ADDITIONALROUTEDATAKEY_FIRST_MOTORWAY_ENTRY = 1;
    public static final int ADDITIONALROUTEDATAKEY_LAST_MOTORWAY_EXIT = 2;
    public static final int LOCATIONDISAMBIGUATION_DEFAULT = 0;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_MOTORWAY = 1;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_TUNNEL = 2;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_FERRY = 3;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_TOOLLROAD = 4;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_BRIDGE = 5;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_OTHERROAD = 6;
    public static final int MAPINTEGRATIONSTATE_IDLE = 0;
    public static final int MAPINTEGRATIONSTATE_IN_PROGRESS = 1;
    public static final int MAPINTEGRATIONSTATE_FINISHED = 2;
    public static final int RESTARTREASON_MAPINTEGRATION = 1;
    public static final int POISEARCHMODE_OTHER = 0;
    public static final int POISEARCHMODE_PROXIMITY_CCP = 1;
    public static final int POISEARCHMODE_PROXIMITY_COORDINATE = 2;
    public static final int POISEARCHMODE_ADMINISTRATIVE_NATIONWIDE = 3;
    public static final int POISEARCHMODE_ADMINISTRATIVE = 3;
    public static final int ADDITIONALLOCATIONINFO_TOWN_UF = 1;
    public static final int BAPMANEUVERSTATE_NOTACTIVE = 0;
    public static final int BAPMANEUVERSTATE_FOLLOW = 1;
    public static final int BAPMANEUVERSTATE_PREPARE = 2;
    public static final int BAPMANEUVERSTATE_DISTANCE = 3;
    public static final int BAPMANEUVERSTATE_NOW = 4;
    public static final int RMIMPORTSTATUS_IDLE = 0;
    public static final int RMIMPORTSTATUS_INPROGRESS = 1;
    public static final int RMIMPORTSTATUS_SUCCESS = 2;
    public static final int RMIMPORTSTATUS_FAILED = 3;
    public static final int RMIMPORTSTATUS_ABORTED = 4;
    public static final int RMIMPORTSTATUS_ABORTED_POWERDOWN = 5;
    public static final int RT_AFAREPEAT = 1001;
    public static final int RT_RGSETROUTEGUIDANCEMODE = 1002;
    public static final int RT_ETCSETDEMOMODE = 1004;
    public static final int RT_ETCSETMETRICSYSTEM = 1005;
    public static final int RT_ETCSETDEMOMODESPEED = 1006;
    public static final int RT_DMLASTDESTINATIONSDELETEALL = 1008;
    public static final int RT_DMLASTDESTINATIONSDELETE = 1009;
    public static final int RT_DMLASTDESTINATIONSGET = 1010;
    public static final int RT_DMLASTDESTINATIONSREPLACE = 1011;
    public static final int RT_DMRECENTROUTESADD = 1012;
    public static final int RT_DMRECENTROUTESDELETEALL = 1013;
    public static final int RT_DMRECENTROUTESDELETE = 1014;
    public static final int RT_DMRECENTROUTESGET = 1015;
    public static final int RT_DMRECENTROUTESREPLACE = 1016;
    public static final int RT_LIGETSTATE = 1017;
    public static final int RT_LIRESTORESTATE = 1018;
    public static final int RT_LISETCURRENTLD = 1019;
    public static final int RT_LISPADDCHARACTER = 1020;
    public static final int RT_LISPCANCELSPELLER = 1021;
    public static final int RT_LISPDELETEALLCHARACTERS = 1022;
    public static final int RT_LISPSELECTLISTITEM = 1025;
    public static final int RT_LISPSETINPUT = 1026;
    public static final int RT_LISPUNDOCHARACTER = 1027;
    public static final int RT_LISTARTMULTICRITERIASPELLER = 1028;
    public static final int RT_LISTARTSPELLER = 1029;
    public static final int RT_RGSETROUTEOPTIONS = 1031;
    public static final int RT_RGSTOPGUIDANCE = 1033;
    public static final int RT_RGSETPOSITION = 1035;
    public static final int RT_LIGETCURRENTSTATE = 1036;
    public static final int RT_POISETCONTEXT = 1037;
    public static final int RT_POISTARTSPELLERALONGROUTE = 1038;
    public static final int RT_POISELECTSELECTIONCRITERIA = 1040;
    public static final int RT_LIGETLOCATIONDESCRIPTIONTRANSFORM = 1054;
    public static final int RT_RMMAKEROUTEPERSISTENT = 1055;
    public static final int RT_POISETSORTORDER2 = 1058;
    public static final int RT_RGCALCULATEROUTE = 1061;
    public static final int RT_RGSTARTGUIDANCECALCULATEDROUTE = 1062;
    public static final int RT_LITRYBESTMATCH = 1063;
    public static final int RT_ETCGETCOUNTRYABBREVIATION = 1064;
    public static final int RT_RRDSTARTCALCULATIONFORPOSITION = 1066;
    public static final int RT_TRSTARTTRACERECORDING = 1068;
    public static final int RT_TRSTOPTRACERECORDING = 1069;
    public static final int RT_TRSTORETRACE = 1070;
    public static final int RT_TRRENAMETRACE = 1071;
    public static final int RT_TRDELETETRACE = 1072;
    public static final int RT_TRDELETEALLTRACES = 1073;
    public static final int RT_RMROUTEADD = 1074;
    public static final int RT_RMROUTEDELETE = 1075;
    public static final int RT_RMROUTEDELETEALL = 1076;
    public static final int RT_RMROUTEGET = 1077;
    public static final int RT_RMROUTERENAME = 1078;
    public static final int RT_SETLANGUAGE = 1080;
    public static final int RT_CREATEEXPORTFILE = 1081;
    public static final int RT_IMPORTFILE = 1082;
    public static final int RT_LANGUAGESPELLABLECHARACTERS = 1083;
    public static final int RT_ENABLERGSTREETLISTS = 1084;
    public static final int RT_ENABLERGPOIINFO = 1086;
    public static final int RT_DMLASTDESTINATIONSADDLIST = 1089;
    public static final int RT_TRCREATEWAYPOINT = 1090;
    public static final int RT_TRANSLATEROUTE = 1091;
    public static final int RT_LOCATIONTOSTREAM = 1092;
    public static final int RT_STREAMTOLOCATION = 1093;
    public static final int RT_LIVALUELISTFILENAME = 1094;
    public static final int RT_LIVALUELISTOUTPUTMETHOD = 1095;
    public static final int RT_ENABLERGLANEGUIDANCE = 1096;
    public static final int RT_DMFLAGDESTINATIONSET = 1097;
    public static final int RT_LISETCOUNTRYFORCITYANDSTREETHISTORY = 1098;
    public static final int RT_LIGETLASTCITYHISTORYENTRY = 1099;
    public static final int RT_LILASTCITYHISTORYADD = 1100;
    public static final int RT_LILASTCITYHISTORYDELETE = 1101;
    public static final int RT_LILASTSTREETHISTORYADD = 1102;
    public static final int RT_LILASTSTREETHISTORYDELETE = 1103;
    public static final int RT_ETCSELECTDATABASE = 1107;
    public static final int RT_LISPREQUESTVALUELISTBYLISTINDEX = 1109;
    public static final int RT_REQUESTSOPOSPOSITIONDESCRIPTIONVEHICLE = 1111;
    public static final int RT_LISTRIPLOCATION = 1112;
    public static final int RT_RRDSTARTCALCULATIONBYLISTINDEX = 1113;
    public static final int RT_DMFLAGDESTINATIONREMOVE = 1115;
    public static final int RT_DMFLAGDESTINATIONSETNAME = 1116;
    public static final int RT_ETCSELECTNAVDATABASE = 1117;
    public static final int RT_LIGETLASTSTREETHISTORYENTRY = 1120;
    public static final int RT_LILASTCITYHISTORYDELETEALL = 1121;
    public static final int RT_LILASTSTREETHISTORYDELETEALL = 1122;
    public static final int RT_REQUESTAUDIOTRIGGER = 1123;
    public static final int RT_LITHESAURUSHISTORYADD = 1124;
    public static final int RT_LITHESAURUSHISTORYGETENTRY = 1125;
    public static final int RT_LITHESAURUSHISTORYDELETE = 1126;
    public static final int RT_LITHESAURUSHISTORYDELETEALL = 1127;
    public static final int RT_EHGETALLCATEGORIES = 1128;
    public static final int RT_EHGETALLBRANDSOFCATEGORY = 1129;
    public static final int RT_EHSETCATEGORYVISIBILITY = 1130;
    public static final int RT_EHSETBRANDVISIBILITY = 1131;
    public static final int RT_EHSETBRANDPREFERENCE = 1132;
    public static final int RT_SETREMAININGRANGEOFVEHICLE = 1133;
    public static final int RT_RRDSTOPCALCULATION = 1135;
    public static final int RT_SETUSERDEFINEDPOIS = 1136;
    public static final int RT_SETTRAILERSTATUS = 1137;
    public static final int RT_EHSETCATEGORYAUDIOWARNING = 1138;
    public static final int RT_REQUESTCOUNTRYINFO = 1140;
    public static final int RT_JUMPTONEXTMANEUVER = 1141;
    public static final int RT_LISPSELECTBYCATEGORYUID = 1142;
    public static final int RT_LIGETVIAPOINTLIST = 1143;
    public static final int RT_LISELECTVIAPOINT = 1144;
    public static final int RT_RGSTARTGUIDANCECALCULATEDROUTEBYUID = 1145;
    public static final int RT_EHSETCATEGORYMONITORING = 1146;
    public static final int RT_LIGETSPELLABLECHARACTERS = 1148;
    public static final int RT_LISTOPSPELLER = 1149;
    public static final int RT_LIVALUELISTMAXIMUMLENGTH = 1150;
    public static final int RT_RGSTOPROUTECALCULATION = 1151;
    public static final int RT_SETVEHICLEFUELTYPE = 1152;
    public static final int RT_SETPATHSTOPERSONALPOIDATABASES = 1153;
    public static final int RT_LISPSELECTLISTITEMBYIDENT = 1154;
    public static final int RT_CREATENAVLOCATIONOFPOIUID = 1155;
    public static final int RT_RMROUTEREPLACE = 1156;
    public static final int RT_DELETEPERSONALPOIDATABASES = 1157;
    public static final int RT_RGSWITCHTONEXTPOSSIBLEROAD = 1158;
    public static final int RT_LISETHISTORY = 1159;
    public static final int RT_LIDELETEHISTORY = 1160;
    public static final int RT_LIGETLASTSTATEHISTORYENTRY = 1161;
    public static final int RT_LILASTSTATEHISTORYADD = 1162;
    public static final int RT_LILASTSTATEHISTORYADDEXTENDED = 1163;
    public static final int RT_LILASTSTATEHISTORYDELETE = 1164;
    public static final int RT_LILASTSTATEHISTORYDELETEALL = 1165;
    public static final int RT_LILASTSTREETHISTORYADDEXTENDED = 1166;
    public static final int RT_LILASTCITYHISTORYADDEXTENDED = 1167;
    public static final int RT_LISPSELECTITEMFROMLOCATION = 1168;
    public static final int RT_LISPSELECTBYMULTIPLECATEGORYUIDS = 1169;
    public static final int RT_POISTARTSPELLERALONGROUTEADVANCED = 1170;
    public static final int RT_EHSETCATEGORYVISIBILITYTODEFAULT = 1171;
    public static final int RT_LIVALUELISTWINDOWSIZE = 1172;
    public static final int RT_SETNAVINTERNALDATATOFACTORYSETTINGS = 1173;
    public static final int RT_LITRYMATCHLOCATION = 1174;
    public static final int RT_LIGETVIAPOINTCOUNTRYLIST = 1175;
    public static final int RT_LISETVIAPOINTCOUNTRY = 1176;
    public static final int RT_LISETSTREETFORCITYHISTORY = 1177;
    public static final int RT_TRIMPORTTRAILS = 1178;
    public static final int RT_TREXPORTTRAILS = 1179;
    public static final int RT_RGSKIPNEXTWAYPOINTS = 1180;
    public static final int RT_RGREVERSETRAILDIRECTION = 1181;
    public static final int RT_RGPREPARERUBBERBANDMANIPULATION = 1182;
    public static final int RT_RGSTARTRUBBERBANDMANIPULATION = 1183;
    public static final int RT_RGSETRUBBERBANDPOSITION = 1184;
    public static final int RT_RGGETROUTEBOUNDINGRECTANGLE = 1185;
    public static final int RT_RGGETLOCATIONONROUTE = 1186;
    public static final int RT_RGSTOPRUBBERBANDMANIPULATION = 1187;
    public static final int RT_RGENABLEENHANCEDSIGNPOSTINFO = 1188;
    public static final int RT_RGDELETECALCULATEDRUBBERBANDPOINT = 1189;
    public static final int RT_RGGETRUBBERBANDPOINTPOSITION = 1190;
    public static final int RT_LISETNVCRANGE = 1191;
    public static final int RT_LISPGETMATCHINGNVC = 1192;
    public static final int RT_LISPGETLOCATIONFROMLIVALUELISTELEMENT = 1193;
    public static final int RT_POIGETXT9LDBS = 1194;
    public static final int RT_POISETLISTSTYLE = 1195;
    public static final int RT_RGTRIGGERRCCIUPDATE = 1196;
    public static final int RT_RGSETTURNLISTMODE = 1197;
    public static final int RT_LILASTSTREETHISTORYSETCITY = 1198;
    public static final int RT_LILASTCITYHISTORYSETSTREET = 1199;
    public static final int RT_LIHISTORYADDLOCATION = 1200;
    public static final int RT_ENABLERGMOTORWAYINFO = 1201;
    public static final int RT_LIGETLOCATIONDESCRIPTIONTRANSFORMNEARBY = 1202;
    public static final int RT_ETCGETPOSITIONTIMEINFO = 1203;
    public static final int RT_POIGETCATEGORYTYPESFROMUID = 1204;
    public static final int RT_RGCALCULATE1STROUTEANDPOSTPONEREMAINING = 1205;
    public static final int RT_RGDELETEPERSISTEDROUTEDATA = 1206;
    public static final int RT_TRIGGEREVENTAUDIOMESSAGE = 1207;
    public static final int RT_LIDISAMBIGUATELOCATION = 1208;
    public static final int RT_LISPADDSTROKE = 1209;
    public static final int RT_LISPREQUESTNVCLIST = 1210;
    public static final int RT_POICONFIGURECONTEXT = 1211;
    public static final int RT_ETCTRIGGERNAVIGATIONRESTART = 1212;
    public static final int RT_RMIMPORTTOURSFROMGPXFILE = 1213;
    public static final int RT_RMABORTIMPORTTOURSFROMGPXFILE = 1214;
    public static final int RT_IMPORTROUTEFROMGPXFILE = 1215;
    public static final int RT_POIREQUESTEXTENDEDINFO = 1216;
    public static final int RT_RGCONFIGUREPOIINFO = 1217;
    public static final int RT_TRCLEARRECORDEDTRACECACHE = 1218;
    public static final int RT_SETVIRTUALROUTEGUIDANCE = 1223;
    public static final int RT_DELETESATELLITECACHE = 1224;
    public static final int RT_PROFILECHANGE = 1219;
    public static final int RT_PROFILECOPY = 1220;
    public static final int RT_PROFILERESET = 1221;
    public static final int RT_PROFILERESETALL = 1222;
    public static final int RP_RGSETROUTEGUIDANCEMODERESULT = 2000;
    public static final int RP_DMLASTDESTINATIONSGETRESULT = 2001;
    public static final int RP_DMRECENTROUTESGETRESULT = 2002;
    public static final int RP_DMRESULT = 2003;
    public static final int RP_LIGETSTATERESULT = 2004;
    public static final int RP_LIRESULT = 2005;
    public static final int RP_LISPUPDATESPELLERRESULT = 2006;
    public static final int RP_LIVALUELIST = 2008;
    public static final int RP_LIVALUELISTFILESTATUS = 2045;
    public static final int RP_LIVALUELISTOUTPUTMETHOD = 2046;
    public static final int RP_POIVALUELIST = 2010;
    public static final int RP_LIGETLOCATIONDESCRIPTIONTRANSFORMRESULT = 2018;
    public static final int RP_RMMAKEROUTEPERSISTENTRESULT = 2019;
    public static final int RP_LITRYBESTMATCHRESULT = 2020;
    public static final int RP_ETCGETCOUNTRYABBREVIATIONRESULT = 2021;
    public static final int RP_TRSTARTTRACERECORDINGRESULT = 2023;
    public static final int RP_TRSTOPTRACERECORDINGRESULT = 2024;
    public static final int RP_TRSTORETRACERESULT = 2025;
    public static final int RP_TRRENAMETRACERESULT = 2026;
    public static final int RP_TRDELETETRACERESULT = 2027;
    public static final int RP_TRDELETEALLTRACESRESULT = 2028;
    public static final int RP_RMROUTEADDRESULT = 2029;
    public static final int RP_RMROUTEDELETERESULT = 2030;
    public static final int RP_RMROUTEDELETEALLRESULT = 2031;
    public static final int RP_RMROUTEGETRESULT = 2032;
    public static final int RP_RMROUTERENAMERESULT = 2033;
    public static final int RP_CREATEEXPORTFILERESULT = 2035;
    public static final int RP_IMPORTFILERESULT = 2036;
    public static final int RP_LANGUAGESPELLABLECHARACTERSRESULT = 2037;
    public static final int RP_TRANSLATEROUTERESULT = 2041;
    public static final int RP_LOCATIONTOSTREAMRESULT = 2043;
    public static final int RP_STREAMTOLOCATIONRESULT = 2044;
    public static final int RP_LIGETLASTCITYHISTORYENTRYRESULT = 2048;
    public static final int RP_LILASTCITYANDSTREETHISTORYRESULT = 2049;
    public static final int RP_SOPOSPOSITIONDESCRIPTIONVEHICLERESULT = 2051;
    public static final int RP_LISTRIPLOCATIONRESULT = 2053;
    public static final int RP_LIGETLASTSTREETHISTORYENTRYRESULT = 2055;
    public static final int RP_LICURRENTSTATE = 2056;
    public static final int RP_LISETCOUNTRYFORCITYANDSTREETHISTORYRESULT = 2057;
    public static final int RP_RESPONSEAUDIOTRIGGER = 2059;
    public static final int RP_RGSTARTGUIDANCECALCULATEDROUTERESULT = 2060;
    public static final int RP_LITHESAURUSHISTORYADDRESULT = 2061;
    public static final int RP_LITHESAURUSHISTORYGETENTRYRESULT = 2062;
    public static final int RP_LITHESAURUSHISTORYDELETERESULT = 2063;
    public static final int RP_LITHESAURUSHISTORYDELETEALLRESULT = 2064;
    public static final int RP_EHRESULT = 2065;
    public static final int RP_EHGETALLCATEGORIESRESULT = 2066;
    public static final int RP_EHGETALLBRANDSOFCATEGORYRESULT = 2067;
    public static final int RP_SETREMAININGRANGEOFVEHICLERESULT = 2068;
    public static final int RP_SETUSERDEFINEDPOISRESULT = 2069;
    public static final int RP_SETTRAILERSTATUSRESULT = 2070;
    public static final int RP_SETVEHICLECONSUMPTIONINFORESULT = 2071;
    public static final int RP_REQUESTCOUNTRYINFORESULT = 2072;
    public static final int RP_LIGETVIAPOINTLISTRESULT = 2073;
    public static final int RP_LISELECTVIAPOINTRESULT = 2074;
    public static final int RP_RGSTARTGUIDANCECALCULATEDROUTEBYUIDRESULT = 2075;
    public static final int RP_LIGETSPELLABLECHARACTERSRESULT = 2077;
    public static final int RP_SETVEHICLEFUELTYPERESULT = 2078;
    public static final int RP_CREATENAVLOCATIONOFPOIUIDRESULT = 2079;
    public static final int RP_RMROUTEREPLACERESULT = 2080;
    public static final int RP_DELETEPERSONALPOIDATABASESRESULT = 2081;
    public static final int RP_RGSWITCHTONEXTPOSSIBLEROADRESULT = 2082;
    public static final int RP_LIGETLASTSTATEHISTORYENTRYRESULT = 2083;
    public static final int RP_LIHISTORYRESULT = 2084;
    public static final int RP_SETNAVINTERNALDATATOFACTORYSETTINGSRESULT = 2085;
    public static final int RP_LITRYMATCHLOCATIONRESULT = 2086;
    public static final int RP_TRIMPORTTRAILSRESULT = 2087;
    public static final int RP_TREXPORTTRAILSRESULT = 2088;
    public static final int RP_RGGETLOCATIONONROUTERESULT = 2089;
    public static final int RP_RGGETROUTEBOUNDINGRECTANGLERESULT = 2090;
    public static final int RP_RGRESULT = 2091;
    public static final int RP_RGSTARTRUBBERBANDMANIPULATIONRESULT = 2092;
    public static final int RP_RGGETRUBBERBANDPOINTPOSITIONRESULT = 2093;
    public static final int RP_LISPGETMATCHINGNVCRESULT = 2094;
    public static final int RP_LISPGETLOCATIONFROMLIVALUELISTRESULT = 2095;
    public static final int RP_ETCSETDEMOMODERESULT = 2096;
    public static final int RP_RGTRIGGERRCCIUPDATERESULT = 2097;
    public static final int RP_LIGETLOCATIONDESCRIPTIONTRANSFORMNEARBYRESULT = 2098;
    public static final int RP_POIGETXT9LDBSRESULT = 2099;
    public static final int RP_ETCGETPOSITIONTIMEINFORESULT = 2100;
    public static final int RP_POIGETCATEGORYTYPESFROMUIDRESULT = 2101;
    public static final int RP_TRIGGEREVENTAUDIOMESSAGERESULT = 2102;
    public static final int RP_LIDISAMBIGUATELOCATIONRESULT = 2103;
    public static final int RP_LISPREQUESTNVCLISTRESULT = 2104;
    public static final int RP_ETCTRIGGERNAVIGATIONRESTARTRESULT = 2105;
    public static final int RP_RMIMPORTTOURSFROMGPXFILERESULT = 2106;
    public static final int RP_IMPORTROUTEFROMGPXFILERESULT = 2107;
    public static final int RP_POIREQUESTEXTENDEDINFORESULT = 2108;
    public static final int RP_TRCLEARRECORDEDTRACECACHERESULT = 2109;
    public static final int RP_DELETESATELLITECACHERESULT = 2114;
    public static final int RP_PROFILECHANGED = 2110;
    public static final int RP_PROFILECOPIED = 2111;
    public static final int RP_PROFILERESET = 2112;
    public static final int RP_PROFILERESETALL = 2113;
    public static final int IN_RGEXCEPTION = 3001;
    public static final int IN_ETCSENSORDATAREPLAYROUTE = 3002;
    public static final int IN_ETCSENSORDATAREPLAYGUIDANCE = 3003;
    public static final int IN_RGNOTPOSSIBLE = 3004;

    public void afaRepeat(int var1);

    public void createExportFile(String var1, int var2);

    public void dmFlagDestinationSet(NavLocation var1);

    public void dmFlagDestinationRemove();

    public void dmFlagDestinationSetName(String var1);

    public void dmLastDestinationsAddList(NavLastDest[] var1);

    public void dmLastDestinationsDelete(long var1);

    public void dmLastDestinationsDeleteAll();

    public void dmLastDestinationsGet(long var1);

    public void dmLastDestinationsReplace(long var1, NavLocation var3, String var4);

    public void dmRecentRoutesAdd(Route var1, String var2);

    public void dmRecentRoutesDelete(long var1);

    public void dmRecentRoutesDeleteAll();

    public void dmRecentRoutesGet(long var1);

    public void dmRecentRoutesReplace(long var1, Route var3, String var4);

    public void enableRgStreetLists(boolean var1);

    public void enableRgLaneGuidance(boolean var1);

    public void enableRgPoiInfo(boolean var1);

    public void etcGetCountryAbbreviation(String var1);

    public void etcSetDemoMode(boolean var1);

    public void etcSetDemoModeSpeed(long var1);

    public void etcSetMetricSystem(int var1);

    public void etcSelectDatabase(int var1);

    public void etcSelectNavDataBase(int var1);

    public void importFile(String var1, int var2);

    public void languageSpellableCharacters(String var1);

    public void liGetCurrentState();

    public void liGetLastCityHistoryEntry(long var1);

    public void liGetLastStreetHistoryEntry(long var1);

    public void liGetLocationDescriptionTransform(NavLocation var1);

    public void liGetLocationDescriptionTransformNearBy(NavLocation var1);

    public void liGetState();

    public void liGetLastStateHistoryEntry(long var1);

    public void liLastStateHistoryAdd(NavLocation var1, boolean var2, String var3);

    public void liLastStateHistoryAddExtended(NavLocation var1, boolean var2, String var3, LIExtData[] var4);

    public void liLastStateHistoryDelete(long var1);

    public void liLastStateHistoryDeleteAll();

    public void liLastCityHistoryAdd(NavLocation var1, boolean var2, String var3);

    public void liLastCityHistoryAddExtended(NavLocation var1, boolean var2, String var3, LIExtData[] var4);

    public void liLastCityHistoryDelete(long var1);

    public void liLastCityHistoryDeleteAll();

    public void liLastStreetHistoryAdd(NavLocation var1, String var2);

    public void liLastStreetHistoryAddExtended(NavLocation var1, String var2, LIExtData[] var3);

    public void liLastStreetHistoryDelete(long var1);

    public void liLastStreetHistoryDeleteAll();

    public void liRestoreState(LISpellerData var1);

    public void liSetCountryForCityAndStreetHistory(String var1);

    public void liSetHistory(String var1, String var2);

    public void liSetStreetForCityHistory(String var1);

    public void liDeleteHistory();

    public void liSetCurrentLD(NavLocation var1);

    public void lispAddCharacter(String var1);

    public void lispCancelSpeller();

    public void lispDeleteAllCharacters();

    public void lispRequestValueListByListIndex(int var1, boolean var2);

    public void lispSelectListItem(int var1);

    public void lispSelectItemFromLocation(NavLocation var1);

    public void lispSelectByCategoryUid(int var1);

    public void lispSelectByMultipleCategoryUids(int[] var1);

    public void lispSetInput(String var1, boolean var2);

    public void lispGetMatchingNVC(String var1);

    public void lispUndoCharacter();

    public void liStartMultiCriteriaSpeller(int var1, int var2, boolean var3, boolean var4, boolean var5);

    public void liStartSpeller(int var1, boolean var2, boolean var3, boolean var4);

    public void liTryBestMatch(TryBestMatchData var1);

    public void liValueListFilename(String var1);

    public void liValueListOutputMethod(int var1);

    public void locationToStream(NavLocation var1);

    public void poiSelectSelectionCriteria(long var1);

    public void poiSetContext(NavLocation var1);

    public void poiSetSortOrder2(int var1);

    public void poiStartSpellerAlongRoute(int var1, long var2, long var4);

    public void poiStartSpellerAlongRouteAdvanced(int var1, long var2, long var4, long var6, boolean var8);

    public void requestSoPosPositionDescriptionVehicle();

    public void rgCalculateRoute(Route var1, int var2);

    public void rgSetPosition(NavLocation var1);

    public void rgSetRouteGuidanceMode(int var1);

    public void rgSetRouteOptions(RouteOptions var1);

    public void rgStartGuidanceCalculatedRoute(int var1);

    public void rgStopGuidance();

    public void rmMakeRoutePersistent(Route var1);

    public void rmRouteAdd(int var1, Route var2, String var3);

    public void rmRouteDelete(int var1, long var2);

    public void rmRouteDeleteAll(int var1);

    public void rmRouteGet(int var1, long var2);

    public void rmRouteRename(int var1, long var2, String var4);

    public void rrdStartCalculationByListIndex(int var1, long var2);

    public void rrdStartCalculationForPosition(NavLocationWgs84[] var1);

    public void rrdStopCalculation();

    public void setLanguage(String var1);

    public void streamToLocation(byte[] var1);

    public void translateRoute(Route var1);

    public void trCreateWaypoint();

    public void trDeleteAllTraces();

    public void trDeleteTrace(NavSegmentID var1);

    public void trRenameTrace(NavSegmentID var1, String var2);

    public void trStartTraceRecording(int var1);

    public void trStopTraceRecording();

    public void trStoreTrace(String var1);

    public void liStripLocation(NavLocation var1, int var2);

    public void liSetNVCRange(int var1);

    public void liValueListWindowSize(int var1);

    public void requestAudioTrigger(int var1);

    public void liThesaurusHistoryAdd(String var1);

    public void liThesaurusHistoryGetEntry(int var1);

    public void liThesaurusHistoryDelete(int var1);

    public void liThesaurusHistoryDeleteAll();

    public void ehGetAllCategories(int var1);

    public void ehGetAllBrandsOfCategory(int var1, int var2);

    public void ehSetCategoryVisibility(int var1, int[] var2, boolean[] var3);

    public void ehSetCategoryVisibilityToDefault(int var1);

    public void ehSetCategoryAudioWarning(int var1, int[] var2, boolean[] var3);

    public void ehSetCategoryMonitoring(int[] var1, boolean[] var2);

    public void ehSetBrandVisibility(int var1, int[] var2, boolean[] var3);

    public void ehSetBrandPreference(int var1, int[] var2, boolean[] var3);

    public void setRemainingRangeOfVehicle(int var1);

    public void setUserDefinedPOIs(NavLocation[] var1);

    public void setTrailerStatus(boolean var1);

    public void requestCountryInfo(String var1);

    public void jumpToNextManeuver();

    public void liGetViaPointCountryList();

    public void liSetViaPointCountry(String var1);

    public void liGetViaPointList(int var1, int var2, int var3, int var4);

    public void liSelectViaPoint(int var1);

    public void rgStartGuidanceCalculatedRouteByUID(NavSegmentID var1);

    public void liGetSpellableCharacters(NavLocation var1, int var2);

    public void liStopSpeller();

    public void liValueListMaximumLength(int var1);

    public void setPathsToPersonalPOIDataBases(String[] var1);

    public void deletePersonalPOIDataBases(String[] var1);

    public void rgStopRouteCalculation();

    public void rgSwitchToNextPossibleRoad();

    public void setVehicleFuelType(int var1);

    public void createNavLocationOfPOIUID(long var1);

    public void lispSelectListItemByIdent(String var1);

    public void rmRouteReplace(int var1, long var2, Route var4);

    public void setNavInternalDataToFactorySettings();

    public void liTryMatchLocation(TryMatchLocationData var1);

    public void trImportTrails(String var1);

    public void trExportTrails(NavSegmentID[] var1, String var2);

    public void rgSkipNextWayPoints(int var1);

    public void rgReverseTrailDirection();

    public void rgPrepareRubberbandManipulation(boolean var1);

    public void rgStartRubberbandManipulation(int var1);

    public void rgSetRubberbandPosition(NavLocationWgs84 var1);

    public void rgGetRouteBoundingRectangle(boolean var1, int var2);

    public void rgGetLocationOnRoute(long var1);

    public void rgStopRubberbandManipulation();

    public void rgDeleteCalculatedRubberbandPoint();

    public void rgGetRubberBandPointPosition();

    public void rgEnableEnhancedSignPostInfo(boolean var1);

    public void lispGetLocationFromLiValueListElement(int var1);

    public void rgSetTurnListMode(int var1);

    public void liHistoryAddLocation(NavLocation var1);

    public void liLastCityHistorySetStreet(NavLocation var1);

    public void liLastStreetHistorySetCity(NavLocation var1);

    public void enableRgMotorwayInfo(boolean var1);

    public void rgTriggerRCCIUpdate();

    public void poiGetXt9LDBs(NavLocation var1, int var2);

    public void poiSetListStyle(int var1);

    public void etcGetPositionTimeInfo(NavLocationWgs84 var1);

    public void poiGetCategoryTypesFromUId(int var1);

    public void rgDeletePersistedRouteData();

    public void rgCalculate1stRouteAndPostponeRemaining(Route var1, int var2, boolean var3);

    public void liDisambiguateLocation(NavLocation var1);

    public void triggerEventAudioMessage(int var1);

    public void lispAddStroke(String var1);

    public void lispRequestNVCList(int var1, int var2, int var3);

    public void poiConfigureContext(String var1, int var2, NavLocation var3, int[] var4);

    public void etcTriggerNavigationRestart(int var1);

    public void rmImportToursFromGpxFile(int var1, String var2);

    public void rmAbortImportToursFromGpxFile();

    public void importRouteFromGpxFile(String var1);

    public void poiRequestExtendedInfo(NavLocation var1);

    public void rgConfigurePoiInfo(NavPoiInfoConfiguration var1);

    public void trClearRecordedTraceCache();

    public void setVirtualRouteGuidance(boolean var1);

    public void profileChange(int var1);

    public void profileCopy(int var1, int var2);

    public void profileReset(int var1);

    public void profileResetAll();

    public void deleteSatelliteCache();
}

