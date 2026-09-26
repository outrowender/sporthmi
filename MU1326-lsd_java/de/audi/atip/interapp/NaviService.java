/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.AbstractSDSApplicationService;
import de.audi.atip.interapp.IWordPredictionCallback;
import de.audi.atip.interapp.NaviMsgDetails;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviService$IRRDCallback;
import de.audi.atip.interapp.NaviService$NaviInfoDetails;
import de.audi.atip.interapp.NaviService$NaviSUIDetails;
import de.audi.atip.interapp.NaviService$POISDSListEntry;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcMessage;

public interface NaviService
extends AbstractSDSApplicationService {
    public static final byte RESULT_OK;
    public static final byte RESULT_ERROR;
    public static final byte RESULT_AMBIGUOUS;
    public static final byte RESULT_INVALID;
    public static final byte OPERATION_STATE_FULLY_OPERABLE;
    public static final byte OPERATION_STATE_NOT_OPERABLE;
    public static final byte OPERATION_STATE_SD_REMOVED;
    public static final byte GUIDANCE_MODE_COMPACT;
    public static final byte GUIDANCE_MODE_COMPLETE;
    public static final byte GUIDANCE_MODE_TRAFFIC;
    public static final byte GUIDANCE_MODE_OFF;
    public static final byte ROUTE_OPTION_DYNAMIC_AUTO;
    public static final byte ROUTE_OPTION_DYNAMIC_MANUAL;
    public static final byte ROUTE_OPTION_DYNAMIC_OFF;
    public static final byte DESTINATION_TYPE_COUNTRY;
    public static final byte DESTINATION_TYPE_CITY;
    public static final byte DESTINATION_TYPE_STREET;
    public static final byte DESTINATION_TYPE_HOUSE_NUMBER;
    public static final byte DESTINATION_TYPE_CENTER;
    public static final byte DESTINATION_TYPE_JUNCTION;
    public static final byte DESTINATION_TYPE_ZIP;
    public static final byte DESTINATION_TYPE_STATE;
    public static final byte DESTINATION_TYPE_CITY_AND_STREET;
    public static final byte DESTINATION_TYPE_LASTDEST;
    public static final byte DESTINATION_TYPE_POI;
    public static final byte DESTINATION_TYPE_SUBMUNICIPALTOWN_AND_STREET;
    public static final byte DESTINATION_TYPE_PLACENAME;
    public static final byte DESTINATION_TYPE_CHOME;
    public static final byte DESTINATION_TYPE_WARD;
    public static final byte DESTINATION_TYPE_VILLAGE_AND_STREET;
    public static final byte DESTINATION_TYPE_TELENUMBER;
    public static final byte DESTINATION_TYPE_PREFECTURE;
    public static final byte DESTINATION_TYPE_PROVINCE;
    public static final byte DESTINATION_TYPE_MAPCODE;
    public static final byte DESTINATION_TYPE_TELEPHONENUMBER;
    public static final byte DESTINATION_TYPE_CITY_FOR_STATE;
    public static final byte DESTINATION_STATUS_NAVIGABLE;
    public static final byte DESTINATION_STATUS_NOT_NAVIGABLE;
    public static final byte POI_TYPE_CLASS_CATEGORY;
    public static final byte POI_TYPE_NAME;
    public static final byte POI_SEARCH_AREA_NATIONWIDE;
    public static final byte POI_SEARCH_AREA_CURRENT_POSITION;
    public static final byte POI_SEARCH_AREA_TARGET_POSITION;
    public static final byte POI_SEARCH_AREA_ALONG_ROUTE;
    public static final byte POI_SEARCH_AREA_OTHER_TOWN;
    public static final byte POI_SEARCH_AREA_OTHER_COUNTRY;
    public static final byte POI_SEARCH_AREA_STOPOVER_POSITION;
    public static final byte POI_RETURN_TYPE_LIST;
    public static final byte POI_RETURN_VALUE_LIST;
    public static final byte POI_RETURN_MAIN_SCREEN;
    public static final byte NAVI_FAVORITE_NORMAL;
    public static final byte NAVI_FAVORITE_NODATA;
    public static final int BLOCK_ROUTE_NEXT_SECTION;
    public static final int BLOCK_ROUTE_MINIMAL_OFFSET;
    public static final int BLOCK_ROUTE_MINIMAL_DISTANCE;
    public static final int BLOCK_ROUTE_REACTION_TIME;
    public static final long SUI_ID_NONE;
    public static final byte ALTERNATIVE_ROUTE_NUMBER_1;
    public static final byte ALTERNATIVE_ROUTE_NUMBER_2;
    public static final byte ALTERNATIVE_ROUTE_NUMBER_3;
    public static final String NAVI_SERVICE_NAME;
    public static final byte SDS_INPUT_MODE_NONE;
    public static final byte SDS_INPUT_MODE_ADDRESS;
    public static final byte SDS_INPUT_MODE_LASTDEST;
    public static final byte SDS_INPUT_MODE_FAVORITE;
    public static final byte SDS_INPUT_MODE_NAVIGATETO;
    public static final byte SDS_INPUT_MODE_HOME;
    public static final byte SDS_INPUT_MODE_ONE_SHOT;
    public static final byte SDS_INPUT_MODE_ADDRESS_ONLINE_POI;
    public static final byte SDS_INPUT_MODE_INTELLIDEST;
    public static final byte SDS_INPUT_MODE_OFFICE;
    public static final String SDS_ONE_SHOT_COUNTRY;
    public static final String SDS_ONE_SHOT_CITY;
    public static final String SDS_ONE_SHOT_STREET;
    public static final String SDS_ONE_SHOT_HOUSENUMBER;
    public static final String SDS_ONE_SHOT_JUNCTION;
    public static final String SDS_ONE_SHOT_PROVINCE;
    public static final String SDS_ONE_SHOT_PREFECTURE;
    public static final String SDS_ONE_SHOT_WARD;
    public static final String SDS_ONE_SHOT_PLACENAME;
    public static final String SDS_ONE_SHOT_CHOME;
    public static final String SDS_ONE_SHOT_SUBMUNICIPALTOWN_AND_STREET;
    public static final String SDS_ONE_SHOT_VILLAGE_AND_STREET;
    public static final byte SDS_INPUT_POI_TOP_POI_LIST;
    public static final byte SDS_INPUT_POI_PICK_LIST;
    public static final byte SDS_INPUT_POI_RESULT_LIST;
    public static final byte SDS_INPUT_SUI_PICKLIST;
    public static final byte NATURAL_POI_CATEGORY_FUEL;
    public static final byte NATURAL_POI_CATEGORY_RESTAURANT;
    public static final byte NATURAL_POI_CATEGORY_REST_AREA;
    public static final byte NATURAL_POI_CATEGORY_REST_AREA_NAR;
    public static final byte NATURAL_POI_CATEGORY_WC;
    public static final byte NATURAL_POI_CATEGORY_ATM;
    public static final byte INFO_DETAILS_DISTANCE_UNIT_KM;
    public static final byte INFO_DETAILS_DISTANCE_UNIT_METER;
    public static final byte INFO_DETAILS_DISTANCE_UNIT_MILES;
    public static final byte INFO_DETAILS_DISTANCE_UNIT_YARDS;
    public static final byte INFO_DETAILS_DISTANCE_UNIT_FEET;
    public static final byte SPEED_LIMIT_UNIT_INVALID;
    public static final byte SPEED_LIMIT_UNIT_KMH;
    public static final byte SPEED_LIMIT_UNIT_MPH;
    public static final byte SEMDIDYN_ROUTE_TYPE_OLD_ROUTE;
    public static final byte SEMIDYN_ROUTE_TYPE_BETTER_ROUTE;
    public static final int ROUTE_PROFILE_FAST;
    public static final int ROUTE_PROFILE_SHORT;
    public static final int ROUTE_PROFILE_ECO;
    public static final int ROUTE_PROFILE_AVOIDTOLL;
    public static final int ROUTE_PROFILE_RECOMMENDED;
    public static final int LOCATIONDISAMBIGUATION_DEFAULT;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_MOTORWAY;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_TUNNEL;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_FERRY;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_TOOLLROAD;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_BRIDGE;
    public static final int LOCATIONDISAMBIGUATION_ROADSEGMENT_OTHERROAD;
    public static final String LIST_OF_STREAMED_LOCATIONS;
    public static final int STOPOVER_INDEX_NEXT_STOPOVER;
    public static final int STOPOVER_INDEX_BEFORE_DESTINATION;
    public static final int STOPOVER_INDEX_DEFAULT;
    public static final int DESTINATION_INDEX_LAST_DESTINATION;
    public static final int DESTINATION_INDEX_ALL_DESTINATIONS;
    public static final int NAVI_OPERATOR_CALL_SHOW_DETAIL_SCREEN;
    public static final int NAVI_OPERATOR_CALL_ADD_TO_FAVORITES;
    public static final int NAVI_OPERATOR_CALL_ADD_TO_CONTACT;
    public static final int NAVI_OPERATOR_CALL_SAVE_AS_HOMEADDRESS;
    public static final int NAVI_OPERATOR_CALL_SAVE_TO_CONTACT;

    default public void insertAsStopover(byte by, int n, boolean bl, boolean bl2) {
    }

    default public void insertAsStopover(NavLocation navLocation, int n, boolean bl) {
    }

    default public int computeRelativeDirection(int n, int n2) {
    }

    default public int computeRelativeAirDistance(int n, int n2) {
    }

    default public void calculateRRDForNavArray(NavLocation[] navLocationArray, IRRDCallback iRRDCallback) {
    }

    default public void calculateRRDForNavLocationWgs84Array(NavLocationWgs84[] navLocationWgs84Array, IRRDCallback iRRDCallback) {
    }

    default public void stopRRDCalculation() {
    }

    default public void setMOSTFrameVisible(boolean bl) {
    }

    default public void setAnnouncementRepeatMode(boolean bl) {
    }

    default public void abortActiveAnnouncement() {
    }

    default public void setTrailerStatus(boolean bl) {
    }

    default public NaviOnlineService getNaviOnlineService() {
    }

    default public void setOnlineTraffic(boolean bl) {
    }

    default public void setLocation(byte[] byArray) {
    }

    default public void setLocation(NavLocation navLocation) {
    }

    default public void setLocation(OperatorCallResult operatorCallResult) {
    }

    default public byte getOperationState() {
    }

    default public boolean getRgActiveStatus() {
    }

    default public void stopRouteGuidance() {
    }

    default public void startRouteGuidance(byte by, boolean bl) {
    }

    default public void addSelectedDestinationAtIndex(int n, boolean bl) {
    }

    default public void calculateAlternativeRoutes() {
    }

    default public void selectAlternativeRoute(byte by) {
    }

    default public boolean isEtcDemoMode() {
    }

    default public boolean isDieselPrimaryEngineType() {
    }

    default public void setGuidanceMode(byte by) {
    }

    default public NaviInfoDetails getAddressDetails(byte by) {
    }

    default public void setRouteOptionDynamic(int n) {
    }

    default public void synchronizeSpeechCountryWithCurrentLD() {
    }

    default public void dialDetailsNumber() {
    }

    default public void notifyAbort() {
    }

    default public void startDestinationInput(int n) {
    }

    default public void startDestinationInputWithCurrentLD(int n) {
    }

    default public void nextDestinationInput(int n) {
    }

    default public void triggerAddressInputReturn(int n) {
    }

    default public void triggerAddressInputReturn(int n, int n2) {
    }

    default public void startRouteGuidance(int n, int n2) {
    }

    default public void startRouteGuidance(boolean bl, NavLocation navLocation) {
    }

    default public void startPoiSearchByName() {
    }

    default public void checkRouteGuidance() {
    }

    default public void setCountry(String string, String string2) {
    }

    default public void setState(String string, String string2) {
    }

    default public void setCountryAndState(String string, String string2, String string3, String string4) {
    }

    default public void setCity(String string, String string2) {
    }

    default public void setCenter() {
    }

    default public void setStreet(String string, String string2) {
    }

    default public void setJunction(String string, String string2) {
    }

    default public void setHouseNumber(String string, String string2) {
    }

    default public void setHouseNumberByIndex(int n) {
    }

    default public void setZIPCode(String string, String string2) {
    }

    default public void setProvince(String string, String string2) {
    }

    default public void setPrefecture(String string, String string2) {
    }

    default public void setPlacename(String string, String string2) {
    }

    default public void setWard(String string, String string2) {
    }

    default public void setChome(String string, String string2) {
    }

    default public void setSubmunicipaltownOrStreet(String string, String string2) {
    }

    default public void setVillageAndStreet(String string, String string2) {
    }

    default public void setOneShotData(Map map) {
    }

    default public void querySpelledCityResultList(String string) {
    }

    default public void querySpelledStreetResultList(String string) {
    }

    default public void selectSpelledCityName(boolean bl, Object object) {
    }

    default public void selectSpelledStreetName(boolean bl, Object object) {
    }

    default public void querySpelledStreetResultList2(String string) {
    }

    default public void selectSpelledStreetName2(boolean bl, Object object) {
    }

    default public void validateSpelledStreetName(String string) {
    }

    default public void queryCityListLength() {
    }

    default public void queryZIPCodeListLength() {
    }

    default public void queryStreetListLength() {
    }

    default public void queryIntersectionListLength() {
    }

    default public void queryHouseNrListLength() {
    }

    default public boolean isDestTypeAvailable(int n) {
    }

    default public boolean isDestTypeSet(int n) {
    }

    default public boolean isLastDestAvailable() {
    }

    default public boolean isHomeAvailable() {
    }

    default public boolean isOfficeAvailable() {
    }

    default public byte setHomeAddress() {
    }

    default public byte setOfficeAddress() {
    }

    default public byte selectHomeAddressForRouteGuidance() {
    }

    default public byte selectOfficeAddressForRouteGuidance() {
    }

    default public boolean isRouteGuidancePossible() {
    }

    default public String getCurrentCountryCode() {
    }

    default public String getAIFCountryCode() {
    }

    default public byte fillNaviPickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public byte fillNaviFavoritePickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public byte fillLastDestinationPickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public byte fillNaviSUIList(NaviSUIDetails[] naviSUIDetailsArray) {
    }

    default public void reduceRouteToFinalDestination() {
    }

    default public NaviInfoDetails getNaviInfo(boolean bl) {
    }

    default public byte setPOISearchArea(byte by) {
    }

    default public void triggerPOIReturn() {
    }

    default public POISDSListEntry getPOIEntryDetails(int n, byte by) {
    }

    default public byte fillPOIPickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public void selectPOI(int n) {
    }

    default public void selectPOIbyListIndex(int n) {
    }

    default public void selectTopPOI(int n) {
    }

    default public void blockRoute(int n) {
    }

    default public void unblockRoute() {
    }

    default public void requestPostCodeFormat() {
    }

    default public void flushPOIPicklistModelGroup() {
    }

    default public void switchToSemidynamicRouteGuidance() {
    }

    default public boolean hasBetterRoute() {
    }

    default public int getSavingTime() {
    }

    default public long getTrafficDelayOnCurrentRoute() {
    }

    default public void selectRoute(byte by, boolean bl) {
    }

    default public void requestCurrentSpeedLimit() {
    }

    default public void diagStartDemoRouteGuidance(int[] nArray) {
    }

    default public void diagStopRouteGuidance() {
    }

    default public int startTrufflesSearch(String string, String[] stringArray) {
    }

    default public void cancelSDSTrufflesSearch(boolean bl) {
    }

    default public boolean isTrufflesConflictmodeAvailable() {
    }

    default public int triggerTrufflesConflictmode(String string, String[] stringArray) {
    }

    default public void setLastDestinationByIndex(int n) {
    }

    default public void setLastDestinationById(long l) {
    }

    default public void setFavoriteDestinationByIndex(int n) {
    }

    default public void setFavoriteDestinationById(long l) {
    }

    default public void setIntelliDestinationByIndex(int n) {
    }

    default public void setDestination(AdbEntry adbEntry, int n) {
    }

    default public void setDestination(String string, String string2) {
    }

    default public String getPoiName(NavLocation navLocation) {
    }

    default public String getAdditionalNameFromNavLocation(NavLocation navLocation) {
    }

    default public NavLocation getCurrentNavLocation() {
    }

    default public NavLocation getCurrentPoiSearchAreaLocation() {
    }

    default public NaviInfoDetails getFormattedPoiSearchAreaLocation() {
    }

    default public NavLocation getCurrentCarPosition() {
    }

    default public int getCurrentCarHeading() {
    }

    default public NavLocation getLastDestination() {
    }

    default public void startGeoCoordinateInput() {
    }

    default public void disclaimerAccept() {
    }

    default public byte sdsEnterRubberband() {
    }

    default public byte setSdsRouteInfo(int n) {
    }

    default public void updateDetailScreenInfo() {
    }

    default public void setRouteProfile(int n) {
    }

    default public boolean isCruiseMode() {
    }

    default public void enterMapCode() {
    }

    default public void inputMapCode(String string) {
    }

    default public void deleteLastMapCodeInput() {
    }

    default public void clearMapCode() {
    }

    default public void disambiguateMapCode() {
    }

    default public void triggerMapCodeReturn() {
    }

    default public void selectDisambiguatedMapCodeByIndex(int n) {
    }

    default public String getLastValidMapCodeBlock() {
    }

    default public String getCurrentMapCode() {
    }

    default public boolean isCurrentMapCodeNavigable() {
    }

    default public boolean isFurtherMapCodeInputPossible() {
    }

    default public void enterTelephoneNumber() {
    }

    default public void inputTelephoneNumber(String string) {
    }

    default public void deleteLastTelephoneNumberInput() {
    }

    default public void clearTelephoneNumber() {
    }

    default public void selectTelephoneNumberByIndex(int n) {
    }

    default public String getLastValidTelephoneNumberBlock() {
    }

    default public String getCurrentTelephoneNumber() {
    }

    default public boolean isFurtherTelephonenumberInputPossible() {
    }

    default public void startTpegPOI() {
    }

    default public void getTpegPOIResultsByCategoryIndex(int n) {
    }

    default public void selectTpegPOIResultByIndex(int n) {
    }

    default public void triggerTpegPoiReturn() {
    }

    default public void destOptShowInMap(NavLocation navLocation, boolean bl, boolean bl2) {
    }

    default public void destOptShowInMap(NavLocationWgs84 navLocationWgs84, boolean bl, boolean bl2) {
    }

    default public void sendOperatorCallResult(OperatorCallResult operatorCallResult, int n) {
    }

    default public void setVisibleKombiMapOrStreetView(boolean bl) {
    }

    default public RenderingInfoProvider getRenderingInfoProvider() {
    }

    default public void saveAsFavorite(NavLocation navLocation, boolean bl) {
    }

    default public void saveAsFavorite(byte by, String string, boolean bl) {
    }

    default public void saveAsFavorite(NavLocationWgs84 navLocationWgs84, String string, boolean bl) {
    }

    default public void setOperatorCallResultLocation(NavLocationWgs84 navLocationWgs84) {
    }

    default public void indicateVICSEmergencyPopupShown(boolean bl) {
    }

    default public void getDatabaseNamesForWordPrediction(IWordPredictionCallback iWordPredictionCallback) {
    }

    default public void setFavoriteContext(int n) {
    }

    default public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray) {
    }

    default public void showPoiDetailsPopup() {
    }

    default public NaviMsgDetails requestCurrentNaviDataforMessage() {
    }

    default public void savePreviewLocation(NavLocation navLocation) {
    }

    default public void savePreviewTmcMsg(TmcMessage tmcMessage) {
    }

    default public void fillToolTipInformationContainerByNavLocation(NavLocation navLocation, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }
}

