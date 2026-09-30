/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.IWordPredictionCallback;
import de.audi.atip.interapp.NaviMsgDetails;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import java.util.Map;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.online.OperatorCallResult;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.tmc.LocalHazardInformation;
import org.dsi.ifc.tmc.TmcMessage;

public class NullNaviService
extends NullService
implements NaviService {
    private boolean isDieselPrimaryEngineType = false;

    public NullNaviService(LogChannel logChannel) {
        super(logChannel, "NaviService");
    }

    public int computeRelativeDirection(int n, int n2) {
        super.log();
        return 0;
    }

    public int computeRelativeAirDistance(int n, int n2) {
        super.log();
        return 0;
    }

    public void calculateRRDForNavArray(NavLocation[] navLocationArray, NaviService.IRRDCallback iRRDCallback) {
        super.log();
    }

    public void stopRRDCalculation() {
        super.log();
    }

    public void setMOSTFrameVisible(boolean bl) {
        super.log();
    }

    public byte getOperationState() {
        super.log();
        return 1;
    }

    public boolean getRgActiveStatus() {
        super.log();
        return false;
    }

    public boolean isEtcDemoMode() {
        super.log();
        return false;
    }

    public boolean isDieselPrimaryEngineType() {
        return this.isDieselPrimaryEngineType;
    }

    public void setDieselAsPrimaryEngineType(boolean bl) {
        this.isDieselPrimaryEngineType = bl;
    }

    public void setGuidanceMode(byte by) {
        super.log();
    }

    public void setSDSProcessing(byte by) {
        super.log();
    }

    public void setRouteOptionCalcType(int n) {
        super.log();
    }

    public void startDestinationInput(int n) {
        super.log();
    }

    public void setCountry(String string, String string2) {
        super.log();
    }

    public void setCity(String string, String string2) {
        super.log();
    }

    public void setStreet(String string, String string2) {
        super.log();
    }

    public void setHouseNumber(String string, String string2) {
        super.log();
    }

    public boolean isHomeAvailable() {
        super.log();
        return false;
    }

    public void setAnnouncementRepeatMode(boolean bl) {
        super.log();
    }

    public void abortActiveAnnouncement() {
        super.log();
    }

    public byte fillNaviPickList(SDSListEntry[] sDSListEntryArray) {
        super.log();
        return 0;
    }

    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    public boolean isDestTypeSet(int n) {
        super.log();
        return false;
    }

    public boolean isDestTypeAvailable(int n) {
        super.log();
        return false;
    }

    public boolean isLastDestAvailable() {
        super.log();
        return false;
    }

    public void setCenter() {
        super.log();
    }

    public void reduceRouteToFinalDestination() {
        super.log();
    }

    public byte setPOISearchArea(byte by) {
        super.log();
        return 0;
    }

    public void triggerPOIReturn() {
        super.log();
    }

    public void selectTopPOI(int n) {
        super.log();
    }

    public void setZIPCode(String string, String string2) {
        super.log();
    }

    public void setLocation(byte[] byArray) {
        super.log();
    }

    public void setSDSAddressInputMode(byte by) {
        super.log();
    }

    public byte getSDSAddressInputMode() {
        super.log();
        return 0;
    }

    public NaviService.POISDSListEntry getPOIEntryDetails(int n, byte by) {
        super.log();
        return null;
    }

    public NaviOnlineService getNaviOnlineService() {
        super.log();
        return null;
    }

    public void setRouteOptionDynamic(int n) {
        super.log();
    }

    public NaviService.NaviInfoDetails getNaviInfo(boolean bl) {
        super.log();
        return null;
    }

    public void setTrailerStatus(boolean bl) {
        super.log();
    }

    public void leavePOIMainScreen() {
        super.log();
    }

    public void blockRoute(int n) {
        super.log();
    }

    public void queryStreetListLength() {
        super.log();
    }

    public void requestPostCodeFormat() {
        super.log();
    }

    public void queryCityListLength() {
        super.log();
    }

    public void queryZIPCodeListLength() {
        super.log();
    }

    public void queryHouseNrListLength() {
        super.log();
    }

    public void queryIntersectionListLength() {
        super.log();
    }

    public boolean isRoutePlanFull() {
        super.log();
        return false;
    }

    public String getCurrentCountryCode() {
        super.log();
        return null;
    }

    public boolean isRouteGuidancePossible() {
        super.log();
        return false;
    }

    public void notifyAbort() {
        super.log();
    }

    public void querySpelledCityResultList(String string) {
        super.log();
    }

    public void querySpelledStreetResultList(String string) {
        super.log();
    }

    public void selectSpelledCityName(boolean bl, Object object) {
        super.log();
    }

    public void selectSpelledStreetName(boolean bl, Object object) {
        super.log();
    }

    public void flushPOIPicklistModelGroup() {
        super.log();
    }

    public void querySpelledStreetResultList2(String string) {
        super.log();
    }

    public void selectSpelledStreetName2(boolean bl, Object object) {
        super.log();
    }

    public void checkRouteGuidance() {
        super.log();
    }

    public void setState(String string, String string2) {
        super.log();
    }

    public void validateSpelledStreetName(String string) {
        super.log();
    }

    public void setJunction(String string, String string2) {
        super.log();
    }

    public NaviService.NaviInfoDetails getAddressDetails(byte by) {
        super.log();
        return null;
    }

    public void switchToSemidynamicRouteGuidance() {
        super.log();
    }

    public boolean hasBetterRoute() {
        super.log();
        return false;
    }

    public int getSavingTime() {
        super.log();
        return 0;
    }

    public void selectRoute(byte by, boolean bl) {
        super.log();
    }

    public byte fillPOIPickList(SDSListEntry[] sDSListEntryArray) {
        super.log();
        return 0;
    }

    public void selectPOI(int n) {
        super.log();
    }

    public void selectPOIbyListIndex(int n) {
        super.log();
    }

    public void requestCurrentSpeedLimit() {
        super.log();
    }

    public byte fillNaviSUIList(String[] stringArray, String[] stringArray2, int[] nArray) {
        super.log();
        return 0;
    }

    public void stopRouteGuidance() {
        super.log();
    }

    public void startRouteGuidance(byte by, boolean bl) {
        super.log();
    }

    public void calculateAlternativeRoutes() {
        super.log();
    }

    public byte fillNaviSUIList(NaviService.NaviSUIDetails[] naviSUIDetailsArray) {
        super.log();
        return 0;
    }

    public byte setHomeAddress() {
        super.log();
        return 0;
    }

    public void addSelectedDestinationAtIndex(int n, boolean bl) {
        super.log();
    }

    public void unblockRoute() {
        super.log();
    }

    public void diagStartDemoRouteGuidance() {
        super.log();
    }

    public void diagStopRouteGuidance() {
        super.log();
    }

    public void setDestination(AdbEntry adbEntry, int n) {
        super.log();
    }

    public void setLastDestinationByIndex(int n) {
        super.log();
    }

    public void setLastDestinationById(long l) {
        super.log();
    }

    public void setFavoriteDestinationByIndex(int n) {
        super.log();
    }

    public void setFavoriteDestinationById(long l) {
        super.log();
    }

    public void setIntelliDestinationByIndex(int n) {
        super.log();
    }

    public void selectAlternativeRoute(byte by) {
        super.log();
    }

    public long getTrafficDelayOnCurrentRoute() {
        return 0L;
    }

    public void setDestination(String string, String string2) {
        super.log();
    }

    public void dialDetailsNumber() {
        super.log();
    }

    public void performIntelliDestQuery(String string) {
    }

    public byte fillLastDestinationPickList(SDSListEntry[] sDSListEntryArray) {
        return 0;
    }

    public void setLocation(NavLocation navLocation) {
    }

    public String getPoiName(NavLocation navLocation) {
        return "";
    }

    public NavLocation getCurrentNavLocation() {
        return null;
    }

    public NavLocation getCurrentPoiSearchAreaLocation() {
        return null;
    }

    public NavLocation getCurrentCarPosition() {
        return null;
    }

    public int getCurrentCarHeading() {
        return 0;
    }

    public byte selectHomeAddressForRouteGuidance() {
        return 0;
    }

    public byte selectOfficeAddressForRouteGuidance() {
        return 0;
    }

    public byte fillNaviFavoritePickList(SDSListEntry[] sDSListEntryArray) {
        return 0;
    }

    public NavLocation getLastDestination() {
        return null;
    }

    public void startGeoCoordinateInput() {
        super.log();
    }

    public void setProvince(String string, String string2) {
        super.log();
    }

    public void setPrefecture(String string, String string2) {
        super.log();
    }

    public void setPlacename(String string, String string2) {
        super.log();
    }

    public void setChome(String string, String string2) {
        super.log();
    }

    public void setSubmunicipaltownOrStreet(String string, String string2) {
        super.log();
    }

    public void setVillageAndStreet(String string, String string2) {
        super.log();
    }

    public void setOneShotData(Map map) {
        super.log();
    }

    public byte setOfficeAddress() {
        return 0;
    }

    public void insertAsStopover(byte by, int n, boolean bl, boolean bl2) {
    }

    public boolean isOfficeAvailable() {
        return false;
    }

    public void disclaimerAccept() {
        super.log();
    }

    public void disclaimerReject() {
        super.log();
    }

    public byte sdsEnterRubberband() {
        return 0;
    }

    public void setLocation(OperatorCallResult operatorCallResult) {
        super.log();
    }

    public byte setSdsRouteInfo(int n) {
        return 0;
    }

    public void setCountryAndState(String string, String string2, String string3, String string4) {
        super.log();
    }

    public void setHouseNumberByIndex(int n) {
        super.log();
    }

    public void updateDetailScreenInfo() {
        super.log();
    }

    public void setRouteProfile(int n) {
        super.log();
    }

    public void setWard(String string, String string2) {
        super.log();
    }

    public boolean isCruiseMode() {
        return false;
    }

    public void enterMapCode() {
        super.log();
    }

    public void inputMapCode(String string) {
        super.log();
    }

    public void deleteLastMapCodeInput() {
        super.log();
    }

    public void clearMapCode() {
        super.log();
    }

    public void disambiguateMapCode() {
        super.log();
    }

    public void selectDisambiguatedMapCodeByIndex(int n) {
        super.log();
    }

    public String getLastValidMapCodeBlock() {
        super.log();
        return null;
    }

    public String getCurrentMapCode() {
        super.log();
        return null;
    }

    public void enterTelephoneNumber() {
        super.log();
    }

    public void inputTelephoneNumber(String string) {
        super.log();
    }

    public void deleteLastTelephoneNumberInput() {
        super.log();
    }

    public void clearTelephoneNumber() {
        super.log();
    }

    public void selectTelephoneNumberByIndex(int n) {
        super.log();
    }

    public String getLastValidTelephoneNumberBlock() {
        super.log();
        return null;
    }

    public String getCurrentTelephoneNumber() {
        super.log();
        return null;
    }

    public void startTpegPOI() {
        super.log();
    }

    public void getTpegPOIResultsByCategoryIndex(int n) {
        super.log();
    }

    public void selectTpegPOIResultByIndex(int n) {
        super.log();
    }

    public void triggerTpegPoiReturn() {
        super.log();
    }

    public void destOptShowInMap(NavLocationWgs84 navLocationWgs84, boolean bl, boolean bl2) {
        super.log();
    }

    public void destOptShowInMap(NavLocation navLocation, boolean bl, boolean bl2) {
        super.log();
    }

    public void sendOperatorCallResult(OperatorCallResult operatorCallResult, int n) {
        super.log();
    }

    public void insertAsStopover(NavLocation navLocation, int n, boolean bl) {
        super.log();
    }

    public void startPoiSearchByName() {
        super.log();
    }

    public void saveAsFavorite(byte by, String string, boolean bl) {
        super.log();
    }

    public void saveAsFavorite(NavLocationWgs84 navLocationWgs84, String string, boolean bl) {
        super.log();
    }

    public void saveAsFavorite(NavLocation navLocation, boolean bl) {
        super.log();
    }

    public void startRouteGuidance(int n, int n2) {
        super.log();
    }

    public int startTrufflesSearch(String string, String[] stringArray) {
        super.log();
        return -1;
    }

    public void setVisibleKombiMapOrStreetView(boolean bl) {
        super.log();
    }

    public void startRouteGuidance(boolean bl, NavLocation navLocation) {
        super.log();
    }

    public void setOperatorCallResultLocation(NavLocationWgs84 navLocationWgs84) {
    }

    public void getDatabaseNamesForWordPrediction(IWordPredictionCallback iWordPredictionCallback) {
    }

    public void triggerAddressInputReturn(int n) {
    }

    public void indicateVICSEmergencyPopupShown(boolean bl) {
    }

    public void setOnlineTraffic(boolean bl) {
        super.log();
    }

    public void diagStartDemoRouteGuidance(int[] nArray) {
    }

    public void synchronizeSpeechCountryWithCurrentLD() {
    }

    public void cancelSDSTrufflesSearch(boolean bl) {
    }

    public boolean isCurrentMapCodeNavigable() {
        return false;
    }

    public boolean isFurtherMapCodeInputPossible() {
        return false;
    }

    public boolean isFurtherTelephonenumberInputPossible() {
        return false;
    }

    public void triggerMapCodeReturn() {
    }

    public void calculateRRDForNavLocationWgs84Array(NavLocationWgs84[] navLocationWgs84Array, NaviService.IRRDCallback iRRDCallback) {
    }

    public String getAdditionalNameFromNavLocation(NavLocation navLocation) {
        return null;
    }

    public void setFavoriteContext(int n) {
    }

    public RenderingInfoProvider getRenderingInfoProvider() {
        return null;
    }

    public void nextDestinationInput(int n) {
    }

    public void triggerAddressInputReturn(int n, int n2) {
    }

    public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray) {
    }

    public NaviMsgDetails requestCurrentNaviDataforMessage() {
        return null;
    }

    public String getAIFCountryCode() {
        return null;
    }

    public void showPoiDetailsPopup() {
    }

    public void savePreviewLocation(NavLocation navLocation) {
    }

    public void savePreviewTmcMsg(TmcMessage tmcMessage) {
    }

    public boolean isTrufflesConflictmodeAvailable() {
        return false;
    }

    public int triggerTrufflesConflictmode(String string, String[] stringArray) {
        return 0;
    }

    public void startDestinationInputWithCurrentLD(int n) {
    }

    public NaviService.NaviInfoDetails getFormattedPoiSearchAreaLocation() {
        return null;
    }

    public void fillToolTipInformationContainerByNavLocation(NavLocation navLocation, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }
}

