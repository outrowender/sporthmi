/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;
import de.audi.atip.interapp.IWordPredictionCallback;
import de.audi.atip.interapp.NaviMsgDetails;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.esolutions.fw.util.commons.Buffer;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.RrdCalculationInfo;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcMessage;

public interface NaviService
extends AbstractSDSApplicationService {
    public static final byte RESULT_OK = 0;
    public static final byte RESULT_ERROR = 1;
    public static final byte RESULT_AMBIGUOUS = 2;
    public static final byte RESULT_INVALID = 3;
    public static final byte OPERATION_STATE_FULLY_OPERABLE = 0;
    public static final byte OPERATION_STATE_NOT_OPERABLE = 1;
    public static final byte OPERATION_STATE_SD_REMOVED = 2;
    public static final byte GUIDANCE_MODE_COMPACT = 0;
    public static final byte GUIDANCE_MODE_COMPLETE = 1;
    public static final byte GUIDANCE_MODE_TRAFFIC = 2;
    public static final byte GUIDANCE_MODE_OFF = 3;
    public static final byte ROUTE_OPTION_DYNAMIC_AUTO = 0;
    public static final byte ROUTE_OPTION_DYNAMIC_MANUAL = 1;
    public static final byte ROUTE_OPTION_DYNAMIC_OFF = 2;
    public static final byte DESTINATION_TYPE_COUNTRY = 0;
    public static final byte DESTINATION_TYPE_CITY = 1;
    public static final byte DESTINATION_TYPE_STREET = 2;
    public static final byte DESTINATION_TYPE_HOUSE_NUMBER = 3;
    public static final byte DESTINATION_TYPE_CENTER = 4;
    public static final byte DESTINATION_TYPE_JUNCTION = 5;
    public static final byte DESTINATION_TYPE_ZIP = 6;
    public static final byte DESTINATION_TYPE_STATE = 7;
    public static final byte DESTINATION_TYPE_CITY_AND_STREET = 8;
    public static final byte DESTINATION_TYPE_LASTDEST = 9;
    public static final byte DESTINATION_TYPE_POI = 10;
    public static final byte DESTINATION_TYPE_SUBMUNICIPALTOWN_AND_STREET = 11;
    public static final byte DESTINATION_TYPE_PLACENAME = 12;
    public static final byte DESTINATION_TYPE_CHOME = 13;
    public static final byte DESTINATION_TYPE_WARD = 14;
    public static final byte DESTINATION_TYPE_VILLAGE_AND_STREET = 15;
    public static final byte DESTINATION_TYPE_TELENUMBER = 16;
    public static final byte DESTINATION_TYPE_PREFECTURE = 17;
    public static final byte DESTINATION_TYPE_PROVINCE = 18;
    public static final byte DESTINATION_TYPE_MAPCODE = 19;
    public static final byte DESTINATION_TYPE_TELEPHONENUMBER = 20;
    public static final byte DESTINATION_TYPE_CITY_FOR_STATE = 21;
    public static final byte DESTINATION_STATUS_NAVIGABLE = 0;
    public static final byte DESTINATION_STATUS_NOT_NAVIGABLE = 1;
    public static final byte POI_TYPE_CLASS_CATEGORY = 0;
    public static final byte POI_TYPE_NAME = 1;
    public static final byte POI_SEARCH_AREA_NATIONWIDE = 0;
    public static final byte POI_SEARCH_AREA_CURRENT_POSITION = 1;
    public static final byte POI_SEARCH_AREA_TARGET_POSITION = 2;
    public static final byte POI_SEARCH_AREA_ALONG_ROUTE = 3;
    public static final byte POI_SEARCH_AREA_OTHER_TOWN = 4;
    public static final byte POI_SEARCH_AREA_OTHER_COUNTRY = 5;
    public static final byte POI_SEARCH_AREA_STOPOVER_POSITION = 6;
    public static final byte POI_RETURN_TYPE_LIST = 0;
    public static final byte POI_RETURN_VALUE_LIST = 1;
    public static final byte POI_RETURN_MAIN_SCREEN = 2;
    public static final byte NAVI_FAVORITE_NORMAL = 0;
    public static final byte NAVI_FAVORITE_NODATA = 1;
    public static final int BLOCK_ROUTE_NEXT_SECTION = -1;
    public static final int BLOCK_ROUTE_MINIMAL_OFFSET = 10;
    public static final int BLOCK_ROUTE_MINIMAL_DISTANCE = 300;
    public static final int BLOCK_ROUTE_REACTION_TIME = 10;
    public static final long SUI_ID_NONE = -1L;
    public static final byte ALTERNATIVE_ROUTE_NUMBER_1 = 0;
    public static final byte ALTERNATIVE_ROUTE_NUMBER_2 = 1;
    public static final byte ALTERNATIVE_ROUTE_NUMBER_3 = 2;
    public static final String NAVI_SERVICE_NAME = "AppNavi";
    public static final byte SDS_INPUT_MODE_NONE = 0;
    public static final byte SDS_INPUT_MODE_ADDRESS = 1;
    public static final byte SDS_INPUT_MODE_LASTDEST = 2;
    public static final byte SDS_INPUT_MODE_FAVORITE = 3;
    public static final byte SDS_INPUT_MODE_NAVIGATETO = 4;
    public static final byte SDS_INPUT_MODE_HOME = 5;
    public static final byte SDS_INPUT_MODE_ONE_SHOT = 6;
    public static final byte SDS_INPUT_MODE_ADDRESS_ONLINE_POI = 7;
    public static final byte SDS_INPUT_MODE_INTELLIDEST = 8;
    public static final byte SDS_INPUT_MODE_OFFICE = 9;
    public static final String SDS_ONE_SHOT_COUNTRY = "SDS_ONE_SHOT_COUNTRY";
    public static final String SDS_ONE_SHOT_CITY = "SDS_ONE_SHOT_CITY";
    public static final String SDS_ONE_SHOT_STREET = "SDS_ONE_SHOT_STREET";
    public static final String SDS_ONE_SHOT_HOUSENUMBER = "SDS_ONE_SHOT_HOUSENUMBER";
    public static final String SDS_ONE_SHOT_JUNCTION = "SDS_ONE_SHOT_JUNCTION";
    public static final String SDS_ONE_SHOT_PROVINCE = "SDS_ONE_SHOT_PROVINCE";
    public static final String SDS_ONE_SHOT_PREFECTURE = "SDS_ONE_SHOT_PREFECTURE";
    public static final String SDS_ONE_SHOT_WARD = "SDS_ONE_SHOT_WARD";
    public static final String SDS_ONE_SHOT_PLACENAME = "SDS_ONE_SHOT_PLACENAME";
    public static final String SDS_ONE_SHOT_CHOME = "SDS_ONE_SHOT_CHOME";
    public static final String SDS_ONE_SHOT_SUBMUNICIPALTOWN_AND_STREET = "SDS_ONE_SHOT_SUBMUNICIPALTOWN_AND_STREET";
    public static final String SDS_ONE_SHOT_VILLAGE_AND_STREET = "SDS_ONE_SHOT_VILLAGE_AND_STREET";
    public static final byte SDS_INPUT_POI_TOP_POI_LIST = 0;
    public static final byte SDS_INPUT_POI_PICK_LIST = 1;
    public static final byte SDS_INPUT_POI_RESULT_LIST = 2;
    public static final byte SDS_INPUT_SUI_PICKLIST = 3;
    public static final byte NATURAL_POI_CATEGORY_FUEL = 1;
    public static final byte NATURAL_POI_CATEGORY_RESTAURANT = 2;
    public static final byte NATURAL_POI_CATEGORY_REST_AREA = 3;
    public static final byte NATURAL_POI_CATEGORY_REST_AREA_NAR = 102;
    public static final byte NATURAL_POI_CATEGORY_WC = 4;
    public static final byte NATURAL_POI_CATEGORY_ATM = 5;
    public static final byte INFO_DETAILS_DISTANCE_UNIT_KM = 0;
    public static final byte INFO_DETAILS_DISTANCE_UNIT_METER = 1;
    public static final byte INFO_DETAILS_DISTANCE_UNIT_MILES = 2;
    public static final byte INFO_DETAILS_DISTANCE_UNIT_YARDS = 3;
    public static final byte INFO_DETAILS_DISTANCE_UNIT_FEET = 4;
    public static final byte SPEED_LIMIT_UNIT_INVALID = -1;
    public static final byte SPEED_LIMIT_UNIT_KMH = 0;
    public static final byte SPEED_LIMIT_UNIT_MPH = 1;
    public static final byte SEMDIDYN_ROUTE_TYPE_OLD_ROUTE = 0;
    public static final byte SEMIDYN_ROUTE_TYPE_BETTER_ROUTE = 1;
    public static final int ROUTE_PROFILE_FAST = 0;
    public static final int ROUTE_PROFILE_SHORT = 1;
    public static final int ROUTE_PROFILE_ECO = 2;
    public static final int ROUTE_PROFILE_AVOIDTOLL = 3;
    public static final int ROUTE_PROFILE_RECOMMENDED = 4;
    public static final int LOCATIONDISAMBIGUATION_DEFAULT = 0;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_MOTORWAY = 1;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_TUNNEL = 2;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_FERRY = 3;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_TOOLLROAD = 4;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_BRIDGE = 5;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_OTHERROAD = 6;
    public static final String LIST_OF_STREAMED_LOCATIONS = "LIST_OF_STREAMED_LOCATIONS";
    public static final int STOPOVER_INDEX_NEXT_STOPOVER = -1;
    public static final int STOPOVER_INDEX_BEFORE_DESTINATION = -2;
    public static final int STOPOVER_INDEX_DEFAULT = -1;
    public static final int DESTINATION_INDEX_LAST_DESTINATION = -1;
    public static final int DESTINATION_INDEX_ALL_DESTINATIONS = -2;
    public static final int NAVI_OPERATOR_CALL_SHOW_DETAIL_SCREEN = 0;
    public static final int NAVI_OPERATOR_CALL_ADD_TO_FAVORITES = 1;
    public static final int NAVI_OPERATOR_CALL_ADD_TO_CONTACT = 2;
    public static final int NAVI_OPERATOR_CALL_SAVE_AS_HOMEADDRESS = 3;
    public static final int NAVI_OPERATOR_CALL_SAVE_TO_CONTACT = 4;

    public void insertAsStopover(byte var1, int var2, boolean var3, boolean var4);

    public void insertAsStopover(NavLocation var1, int var2, boolean var3);

    public int computeRelativeDirection(int var1, int var2);

    public int computeRelativeAirDistance(int var1, int var2);

    public void calculateRRDForNavArray(NavLocation[] var1, IRRDCallback var2);

    public void calculateRRDForNavLocationWgs84Array(NavLocationWgs84[] var1, IRRDCallback var2);

    public void stopRRDCalculation();

    public void setMOSTFrameVisible(boolean var1);

    public void setAnnouncementRepeatMode(boolean var1);

    public void abortActiveAnnouncement();

    public void setTrailerStatus(boolean var1);

    public NaviOnlineService getNaviOnlineService();

    public void setOnlineTraffic(boolean var1);

    public void setLocation(byte[] var1);

    public void setLocation(NavLocation var1);

    public void setLocation(OperatorCallResult var1);

    public byte getOperationState();

    public boolean getRgActiveStatus();

    public void stopRouteGuidance();

    public void startRouteGuidance(byte var1, boolean var2);

    public void addSelectedDestinationAtIndex(int var1, boolean var2);

    public void calculateAlternativeRoutes();

    public void selectAlternativeRoute(byte var1);

    public boolean isEtcDemoMode();

    public boolean isDieselPrimaryEngineType();

    public void setGuidanceMode(byte var1);

    public NaviInfoDetails getAddressDetails(byte var1);

    public void setRouteOptionDynamic(int var1);

    public void synchronizeSpeechCountryWithCurrentLD();

    public void dialDetailsNumber();

    public void notifyAbort();

    public void startDestinationInput(int var1);

    public void startDestinationInputWithCurrentLD(int var1);

    public void nextDestinationInput(int var1);

    public void triggerAddressInputReturn(int var1);

    public void triggerAddressInputReturn(int var1, int var2);

    public void startRouteGuidance(int var1, int var2);

    public void startRouteGuidance(boolean var1, NavLocation var2);

    public void startPoiSearchByName();

    public void checkRouteGuidance();

    public void setCountry(String var1, String var2);

    public void setState(String var1, String var2);

    public void setCountryAndState(String var1, String var2, String var3, String var4);

    public void setCity(String var1, String var2);

    public void setCenter();

    public void setStreet(String var1, String var2);

    public void setJunction(String var1, String var2);

    public void setHouseNumber(String var1, String var2);

    public void setHouseNumberByIndex(int var1);

    public void setZIPCode(String var1, String var2);

    public void setProvince(String var1, String var2);

    public void setPrefecture(String var1, String var2);

    public void setPlacename(String var1, String var2);

    public void setWard(String var1, String var2);

    public void setChome(String var1, String var2);

    public void setSubmunicipaltownOrStreet(String var1, String var2);

    public void setVillageAndStreet(String var1, String var2);

    public void setOneShotData(Map var1);

    public void querySpelledCityResultList(String var1);

    public void querySpelledStreetResultList(String var1);

    public void selectSpelledCityName(boolean var1, Object var2);

    public void selectSpelledStreetName(boolean var1, Object var2);

    public void querySpelledStreetResultList2(String var1);

    public void selectSpelledStreetName2(boolean var1, Object var2);

    public void validateSpelledStreetName(String var1);

    public void queryCityListLength();

    public void queryZIPCodeListLength();

    public void queryStreetListLength();

    public void queryIntersectionListLength();

    public void queryHouseNrListLength();

    public boolean isDestTypeAvailable(int var1);

    public boolean isDestTypeSet(int var1);

    public boolean isLastDestAvailable();

    public boolean isHomeAvailable();

    public boolean isOfficeAvailable();

    public byte setHomeAddress();

    public byte setOfficeAddress();

    public byte selectHomeAddressForRouteGuidance();

    public byte selectOfficeAddressForRouteGuidance();

    public boolean isRouteGuidancePossible();

    public String getCurrentCountryCode();

    public String getAIFCountryCode();

    public byte fillNaviPickList(SDSListEntry[] var1);

    public byte fillNaviFavoritePickList(SDSListEntry[] var1);

    public byte fillLastDestinationPickList(SDSListEntry[] var1);

    public byte fillNaviSUIList(NaviSUIDetails[] var1);

    public void reduceRouteToFinalDestination();

    public NaviInfoDetails getNaviInfo(boolean var1);

    public byte setPOISearchArea(byte var1);

    public void triggerPOIReturn();

    public POISDSListEntry getPOIEntryDetails(int var1, byte var2);

    public byte fillPOIPickList(SDSListEntry[] var1);

    public void selectPOI(int var1);

    public void selectPOIbyListIndex(int var1);

    public void selectTopPOI(int var1);

    public void blockRoute(int var1);

    public void unblockRoute();

    public void requestPostCodeFormat();

    public void flushPOIPicklistModelGroup();

    public void switchToSemidynamicRouteGuidance();

    public boolean hasBetterRoute();

    public int getSavingTime();

    public long getTrafficDelayOnCurrentRoute();

    public void selectRoute(byte var1, boolean var2);

    public void requestCurrentSpeedLimit();

    public void diagStartDemoRouteGuidance(int[] var1);

    public void diagStopRouteGuidance();

    public int startTrufflesSearch(String var1, String[] var2);

    public void cancelSDSTrufflesSearch(boolean var1);

    public boolean isTrufflesConflictmodeAvailable();

    public int triggerTrufflesConflictmode(String var1, String[] var2);

    public void setLastDestinationByIndex(int var1);

    public void setLastDestinationById(long var1);

    public void setFavoriteDestinationByIndex(int var1);

    public void setFavoriteDestinationById(long var1);

    public void setIntelliDestinationByIndex(int var1);

    public void setDestination(AdbEntry var1, int var2);

    public void setDestination(String var1, String var2);

    public String getPoiName(NavLocation var1);

    public String getAdditionalNameFromNavLocation(NavLocation var1);

    public NavLocation getCurrentNavLocation();

    public NavLocation getCurrentPoiSearchAreaLocation();

    public NaviInfoDetails getFormattedPoiSearchAreaLocation();

    public NavLocation getCurrentCarPosition();

    public int getCurrentCarHeading();

    public NavLocation getLastDestination();

    public void startGeoCoordinateInput();

    public void disclaimerAccept();

    public byte sdsEnterRubberband();

    public byte setSdsRouteInfo(int var1);

    public void updateDetailScreenInfo();

    public void setRouteProfile(int var1);

    public boolean isCruiseMode();

    public void enterMapCode();

    public void inputMapCode(String var1);

    public void deleteLastMapCodeInput();

    public void clearMapCode();

    public void disambiguateMapCode();

    public void triggerMapCodeReturn();

    public void selectDisambiguatedMapCodeByIndex(int var1);

    public String getLastValidMapCodeBlock();

    public String getCurrentMapCode();

    public boolean isCurrentMapCodeNavigable();

    public boolean isFurtherMapCodeInputPossible();

    public void enterTelephoneNumber();

    public void inputTelephoneNumber(String var1);

    public void deleteLastTelephoneNumberInput();

    public void clearTelephoneNumber();

    public void selectTelephoneNumberByIndex(int var1);

    public String getLastValidTelephoneNumberBlock();

    public String getCurrentTelephoneNumber();

    public boolean isFurtherTelephonenumberInputPossible();

    public void startTpegPOI();

    public void getTpegPOIResultsByCategoryIndex(int var1);

    public void selectTpegPOIResultByIndex(int var1);

    public void triggerTpegPoiReturn();

    public void destOptShowInMap(NavLocation var1, boolean var2, boolean var3);

    public void destOptShowInMap(NavLocationWgs84 var1, boolean var2, boolean var3);

    public void sendOperatorCallResult(OperatorCallResult var1, int var2);

    public void setVisibleKombiMapOrStreetView(boolean var1);

    public RenderingInfoProvider getRenderingInfoProvider();

    public void saveAsFavorite(NavLocation var1, boolean var2);

    public void saveAsFavorite(byte var1, String var2, boolean var3);

    public void saveAsFavorite(NavLocationWgs84 var1, String var2, boolean var3);

    public void setOperatorCallResultLocation(NavLocationWgs84 var1);

    public void indicateVICSEmergencyPopupShown(boolean var1);

    public void getDatabaseNamesForWordPrediction(IWordPredictionCallback var1);

    public void setFavoriteContext(int var1);

    public void updateLocalHazardInformation(LocalHazardInformation[] var1);

    public void showPoiDetailsPopup();

    public NaviMsgDetails requestCurrentNaviDataforMessage();

    public void savePreviewLocation(NavLocation var1);

    public void savePreviewTmcMsg(TmcMessage var1);

    public void fillToolTipInformationContainerByNavLocation(NavLocation var1, GuiTooltipInformationContainer var2);

    public static class NaviDetails {
        public String country;
        public String countryAbbreviation;
        public String state;
        public String stateAbbreviation;
        public String city;
        public String cityStringID;
        public String street;
        public String streetStringID;
        public String houseNumber;
        public String houseNumberStringID;
        public long poiID;
        public String poiName;
        public String provinceOrPrefecture;
        public String provinceOrPrefectureStringID;
        public String placeName;
        public String placeNameStringID;
        public String ward;
        public String wardStringID;
        public String chome;
        public String chomeStringID;

        public String toString() {
            Buffer buffer = new Buffer("country=");
            buffer.append(this.country).append(" (").append(this.countryAbbreviation).append("), state=").append(this.state).append(" (").append(this.stateAbbreviation).append("), city=").append(this.city).append(" (").append(this.cityStringID).append("), street=").append(this.street).append(" (").append(this.streetStringID).append("), houseNumber=").append(this.houseNumber).append(" (").append(this.houseNumberStringID).append("), poiName=").append(this.poiName).append(" (").append(this.poiID).append("), provinceOrPrefecture=").append(this.provinceOrPrefecture).append(" (").append(this.provinceOrPrefectureStringID).append("), placeName=").append(this.placeName).append(" (").append(this.placeNameStringID).append("), ward=").append(this.ward).append(" (").append(this.wardStringID).append("), chome=").append(this.chome).append(" (").append(this.chomeStringID).append(")");
            return buffer.toString();
        }
    }

    public static class OneshotData {
        private final String text;
        private final long id;
        private final String stringID;

        public OneshotData(String string, String string2, long l) {
            this.text = string;
            this.stringID = string2;
            this.id = l;
        }

        public OneshotData(String string, String string2) {
            this.text = string;
            this.stringID = string2;
            this.id = -1L;
        }

        public String getText() {
            return this.text;
        }

        public long getObjId() {
            return this.id;
        }

        public String getStringId() {
            return this.stringID;
        }

        public final String toString() {
            return new Buffer().append(this.text).append(" (").append(this.id).append(", ").append(this.stringID).append(")").toString();
        }

        public int hashCode() {
            int n = 1;
            n = 31 * n + (int)(this.id ^ this.id >>> 32);
            n = 31 * n + (this.stringID == null ? 0 : this.stringID.hashCode());
            n = 31 * n + (this.text == null ? 0 : this.text.hashCode());
            return n;
        }

        public boolean equals(Object object) {
            if (this == object) {
                return true;
            }
            if (object == null) {
                return false;
            }
            if (this.getClass() != object.getClass()) {
                return false;
            }
            OneshotData oneshotData = (OneshotData)object;
            if (this.text != oneshotData.getText()) {
                return false;
            }
            if (this.stringID != oneshotData.getStringId()) {
                return false;
            }
            return this.id == oneshotData.getObjId();
        }
    }

    public static interface IRRDCallback {
        public void updateRrdItems(RrdCalculationInfo[] var1);
    }

    public static class NaviSUIDetails
    extends NaviDetails {
        public long poiIconID = -1L;
        public long adbID = -1L;
        public String adbName = "";
        public int entryChildren = 0;

        public String toString() {
            Buffer buffer = new Buffer(super.toString());
            buffer.append(", poiIconID=").append(this.poiIconID).append("; adbName=").append(this.adbName).append(" (").append(this.adbID).append("); entryChildren=").append(this.entryChildren);
            return buffer.toString();
        }
    }

    public static class NaviInfoDetails
    extends NaviDetails {
        public float distance;
        public int distanceUnit;
        public DateMetric time;

        public String toString() {
            Buffer buffer = new Buffer(super.toString());
            buffer.append(", distance=").append(this.distance).append(", unit=").append(this.distanceUnit).append(", time=").append(this.time != null ? this.time.format() : "??:??");
            return buffer.toString();
        }
    }

    public static class POISDSListEntry
    extends SDSListEntry {
        private final Distance distance;

        public POISDSListEntry() {
            super("", 0L);
            this.distance = new Distance(0.0f, 1);
        }

        public POISDSListEntry(String string, long l) {
            super(string, l);
            this.distance = new Distance(0.0f, 1);
        }

        public POISDSListEntry(String string, long l, Distance distance) {
            super(string, l);
            this.distance = distance;
        }

        public Distance getDistance() {
            return this.distance;
        }

        public String toString() {
            return new Buffer(super.toString()).append(", poiDistance=").append(this.distance).toString();
        }
    }
}

