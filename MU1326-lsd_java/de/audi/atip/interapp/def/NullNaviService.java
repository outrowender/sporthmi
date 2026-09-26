/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.interapp.IWordPredictionCallback;
import de.audi.atip.interapp.NaviMsgDetails;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviService$IRRDCallback;
import de.audi.atip.interapp.NaviService$NaviInfoDetails;
import de.audi.atip.interapp.NaviService$NaviSUIDetails;
import de.audi.atip.interapp.NaviService$POISDSListEntry;
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

    @Override
    public int computeRelativeDirection(int n, int n2) {
        super.log();
        return 0;
    }

    @Override
    public int computeRelativeAirDistance(int n, int n2) {
        super.log();
        return 0;
    }

    @Override
    public void calculateRRDForNavArray(NavLocation[] navLocationArray, NaviService$IRRDCallback naviService$IRRDCallback) {
        super.log();
    }

    @Override
    public void stopRRDCalculation() {
        super.log();
    }

    @Override
    public void setMOSTFrameVisible(boolean bl) {
        super.log();
    }

    @Override
    public byte getOperationState() {
        super.log();
        return 1;
    }

    @Override
    public boolean getRgActiveStatus() {
        super.log();
        return false;
    }

    @Override
    public boolean isEtcDemoMode() {
        super.log();
        return false;
    }

    @Override
    public boolean isDieselPrimaryEngineType() {
        return this.isDieselPrimaryEngineType;
    }

    public void setDieselAsPrimaryEngineType(boolean bl) {
        this.isDieselPrimaryEngineType = bl;
    }

    @Override
    public void setGuidanceMode(byte by) {
        super.log();
    }

    public void setSDSProcessing(byte by) {
        super.log();
    }

    public void setRouteOptionCalcType(int n) {
        super.log();
    }

    @Override
    public void startDestinationInput(int n) {
        super.log();
    }

    @Override
    public void setCountry(String string, String string2) {
        super.log();
    }

    @Override
    public void setCity(String string, String string2) {
        super.log();
    }

    @Override
    public void setStreet(String string, String string2) {
        super.log();
    }

    @Override
    public void setHouseNumber(String string, String string2) {
        super.log();
    }

    @Override
    public boolean isHomeAvailable() {
        super.log();
        return false;
    }

    @Override
    public void setAnnouncementRepeatMode(boolean bl) {
        super.log();
    }

    @Override
    public void abortActiveAnnouncement() {
        super.log();
    }

    @Override
    public byte fillNaviPickList(SDSListEntry[] sDSListEntryArray) {
        super.log();
        return 0;
    }

    @Override
    public byte freezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public byte unfreezeDynamicLists() {
        super.log();
        return 0;
    }

    @Override
    public boolean isDestTypeSet(int n) {
        super.log();
        return false;
    }

    @Override
    public boolean isDestTypeAvailable(int n) {
        super.log();
        return false;
    }

    @Override
    public boolean isLastDestAvailable() {
        super.log();
        return false;
    }

    @Override
    public void setCenter() {
        super.log();
    }

    @Override
    public void reduceRouteToFinalDestination() {
        super.log();
    }

    @Override
    public byte setPOISearchArea(byte by) {
        super.log();
        return 0;
    }

    @Override
    public void triggerPOIReturn() {
        super.log();
    }

    @Override
    public void selectTopPOI(int n) {
        super.log();
    }

    @Override
    public void setZIPCode(String string, String string2) {
        super.log();
    }

    @Override
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

    @Override
    public NaviService$POISDSListEntry getPOIEntryDetails(int n, byte by) {
        super.log();
        return null;
    }

    @Override
    public NaviOnlineService getNaviOnlineService() {
        super.log();
        return null;
    }

    @Override
    public void setRouteOptionDynamic(int n) {
        super.log();
    }

    @Override
    public NaviService$NaviInfoDetails getNaviInfo(boolean bl) {
        super.log();
        return null;
    }

    @Override
    public void setTrailerStatus(boolean bl) {
        super.log();
    }

    public void leavePOIMainScreen() {
        super.log();
    }

    @Override
    public void blockRoute(int n) {
        super.log();
    }

    @Override
    public void queryStreetListLength() {
        super.log();
    }

    @Override
    public void requestPostCodeFormat() {
        super.log();
    }

    @Override
    public void queryCityListLength() {
        super.log();
    }

    @Override
    public void queryZIPCodeListLength() {
        super.log();
    }

    @Override
    public void queryHouseNrListLength() {
        super.log();
    }

    @Override
    public void queryIntersectionListLength() {
        super.log();
    }

    public boolean isRoutePlanFull() {
        super.log();
        return false;
    }

    @Override
    public String getCurrentCountryCode() {
        super.log();
        return null;
    }

    @Override
    public boolean isRouteGuidancePossible() {
        super.log();
        return false;
    }

    @Override
    public void notifyAbort() {
        super.log();
    }

    @Override
    public void querySpelledCityResultList(String string) {
        super.log();
    }

    @Override
    public void querySpelledStreetResultList(String string) {
        super.log();
    }

    @Override
    public void selectSpelledCityName(boolean bl, Object object) {
        super.log();
    }

    @Override
    public void selectSpelledStreetName(boolean bl, Object object) {
        super.log();
    }

    @Override
    public void flushPOIPicklistModelGroup() {
        super.log();
    }

    @Override
    public void querySpelledStreetResultList2(String string) {
        super.log();
    }

    @Override
    public void selectSpelledStreetName2(boolean bl, Object object) {
        super.log();
    }

    @Override
    public void checkRouteGuidance() {
        super.log();
    }

    @Override
    public void setState(String string, String string2) {
        super.log();
    }

    @Override
    public void validateSpelledStreetName(String string) {
        super.log();
    }

    @Override
    public void setJunction(String string, String string2) {
        super.log();
    }

    @Override
    public NaviService$NaviInfoDetails getAddressDetails(byte by) {
        super.log();
        return null;
    }

    @Override
    public void switchToSemidynamicRouteGuidance() {
        super.log();
    }

    @Override
    public boolean hasBetterRoute() {
        super.log();
        return false;
    }

    @Override
    public int getSavingTime() {
        super.log();
        return 0;
    }

    @Override
    public void selectRoute(byte by, boolean bl) {
        super.log();
    }

    @Override
    public byte fillPOIPickList(SDSListEntry[] sDSListEntryArray) {
        super.log();
        return 0;
    }

    @Override
    public void selectPOI(int n) {
        super.log();
    }

    @Override
    public void selectPOIbyListIndex(int n) {
        super.log();
    }

    @Override
    public void requestCurrentSpeedLimit() {
        super.log();
    }

    public byte fillNaviSUIList(String[] stringArray, String[] stringArray2, int[] nArray) {
        super.log();
        return 0;
    }

    @Override
    public void stopRouteGuidance() {
        super.log();
    }

    @Override
    public void startRouteGuidance(byte by, boolean bl) {
        super.log();
    }

    @Override
    public void calculateAlternativeRoutes() {
        super.log();
    }

    @Override
    public byte fillNaviSUIList(NaviService$NaviSUIDetails[] naviService$NaviSUIDetailsArray) {
        super.log();
        return 0;
    }

    @Override
    public byte setHomeAddress() {
        super.log();
        return 0;
    }

    @Override
    public void addSelectedDestinationAtIndex(int n, boolean bl) {
        super.log();
    }

    @Override
    public void unblockRoute() {
        super.log();
    }

    public void diagStartDemoRouteGuidance() {
        super.log();
    }

    @Override
    public void diagStopRouteGuidance() {
        super.log();
    }

    @Override
    public void setDestination(AdbEntry adbEntry, int n) {
        super.log();
    }

    @Override
    public void setLastDestinationByIndex(int n) {
        super.log();
    }

    @Override
    public void setLastDestinationById(long l) {
        super.log();
    }

    @Override
    public void setFavoriteDestinationByIndex(int n) {
        super.log();
    }

    @Override
    public void setFavoriteDestinationById(long l) {
        super.log();
    }

    @Override
    public void setIntelliDestinationByIndex(int n) {
        super.log();
    }

    @Override
    public void selectAlternativeRoute(byte by) {
        super.log();
    }

    @Override
    public long getTrafficDelayOnCurrentRoute() {
        return 0L;
    }

    @Override
    public void setDestination(String string, String string2) {
        super.log();
    }

    @Override
    public void dialDetailsNumber() {
        super.log();
    }

    public void performIntelliDestQuery(String string) {
    }

    @Override
    public byte fillLastDestinationPickList(SDSListEntry[] sDSListEntryArray) {
        return 0;
    }

    @Override
    public void setLocation(NavLocation navLocation) {
    }

    @Override
    public String getPoiName(NavLocation navLocation) {
        return "";
    }

    @Override
    public NavLocation getCurrentNavLocation() {
        return null;
    }

    @Override
    public NavLocation getCurrentPoiSearchAreaLocation() {
        return null;
    }

    @Override
    public NavLocation getCurrentCarPosition() {
        return null;
    }

    @Override
    public int getCurrentCarHeading() {
        return 0;
    }

    @Override
    public byte selectHomeAddressForRouteGuidance() {
        return 0;
    }

    @Override
    public byte selectOfficeAddressForRouteGuidance() {
        return 0;
    }

    @Override
    public byte fillNaviFavoritePickList(SDSListEntry[] sDSListEntryArray) {
        return 0;
    }

    @Override
    public NavLocation getLastDestination() {
        return null;
    }

    @Override
    public void startGeoCoordinateInput() {
        super.log();
    }

    @Override
    public void setProvince(String string, String string2) {
        super.log();
    }

    @Override
    public void setPrefecture(String string, String string2) {
        super.log();
    }

    @Override
    public void setPlacename(String string, String string2) {
        super.log();
    }

    @Override
    public void setChome(String string, String string2) {
        super.log();
    }

    @Override
    public void setSubmunicipaltownOrStreet(String string, String string2) {
        super.log();
    }

    @Override
    public void setVillageAndStreet(String string, String string2) {
        super.log();
    }

    @Override
    public void setOneShotData(Map map) {
        super.log();
    }

    @Override
    public byte setOfficeAddress() {
        return 0;
    }

    @Override
    public void insertAsStopover(byte by, int n, boolean bl, boolean bl2) {
    }

    @Override
    public boolean isOfficeAvailable() {
        return false;
    }

    @Override
    public void disclaimerAccept() {
        super.log();
    }

    public void disclaimerReject() {
        super.log();
    }

    @Override
    public byte sdsEnterRubberband() {
        return 0;
    }

    @Override
    public void setLocation(OperatorCallResult operatorCallResult) {
        super.log();
    }

    @Override
    public byte setSdsRouteInfo(int n) {
        return 0;
    }

    @Override
    public void setCountryAndState(String string, String string2, String string3, String string4) {
        super.log();
    }

    @Override
    public void setHouseNumberByIndex(int n) {
        super.log();
    }

    @Override
    public void updateDetailScreenInfo() {
        super.log();
    }

    @Override
    public void setRouteProfile(int n) {
        super.log();
    }

    @Override
    public void setWard(String string, String string2) {
        super.log();
    }

    @Override
    public boolean isCruiseMode() {
        return false;
    }

    @Override
    public void enterMapCode() {
        super.log();
    }

    @Override
    public void inputMapCode(String string) {
        super.log();
    }

    @Override
    public void deleteLastMapCodeInput() {
        super.log();
    }

    @Override
    public void clearMapCode() {
        super.log();
    }

    @Override
    public void disambiguateMapCode() {
        super.log();
    }

    @Override
    public void selectDisambiguatedMapCodeByIndex(int n) {
        super.log();
    }

    @Override
    public String getLastValidMapCodeBlock() {
        super.log();
        return null;
    }

    @Override
    public String getCurrentMapCode() {
        super.log();
        return null;
    }

    @Override
    public void enterTelephoneNumber() {
        super.log();
    }

    @Override
    public void inputTelephoneNumber(String string) {
        super.log();
    }

    @Override
    public void deleteLastTelephoneNumberInput() {
        super.log();
    }

    @Override
    public void clearTelephoneNumber() {
        super.log();
    }

    @Override
    public void selectTelephoneNumberByIndex(int n) {
        super.log();
    }

    @Override
    public String getLastValidTelephoneNumberBlock() {
        super.log();
        return null;
    }

    @Override
    public String getCurrentTelephoneNumber() {
        super.log();
        return null;
    }

    @Override
    public void startTpegPOI() {
        super.log();
    }

    @Override
    public void getTpegPOIResultsByCategoryIndex(int n) {
        super.log();
    }

    @Override
    public void selectTpegPOIResultByIndex(int n) {
        super.log();
    }

    @Override
    public void triggerTpegPoiReturn() {
        super.log();
    }

    @Override
    public void destOptShowInMap(NavLocationWgs84 navLocationWgs84, boolean bl, boolean bl2) {
        super.log();
    }

    @Override
    public void destOptShowInMap(NavLocation navLocation, boolean bl, boolean bl2) {
        super.log();
    }

    @Override
    public void sendOperatorCallResult(OperatorCallResult operatorCallResult, int n) {
        super.log();
    }

    @Override
    public void insertAsStopover(NavLocation navLocation, int n, boolean bl) {
        super.log();
    }

    @Override
    public void startPoiSearchByName() {
        super.log();
    }

    @Override
    public void saveAsFavorite(byte by, String string, boolean bl) {
        super.log();
    }

    @Override
    public void saveAsFavorite(NavLocationWgs84 navLocationWgs84, String string, boolean bl) {
        super.log();
    }

    @Override
    public void saveAsFavorite(NavLocation navLocation, boolean bl) {
        super.log();
    }

    @Override
    public void startRouteGuidance(int n, int n2) {
        super.log();
    }

    @Override
    public int startTrufflesSearch(String string, String[] stringArray) {
        super.log();
        return -1;
    }

    @Override
    public void setVisibleKombiMapOrStreetView(boolean bl) {
        super.log();
    }

    @Override
    public void startRouteGuidance(boolean bl, NavLocation navLocation) {
        super.log();
    }

    @Override
    public void setOperatorCallResultLocation(NavLocationWgs84 navLocationWgs84) {
    }

    @Override
    public void getDatabaseNamesForWordPrediction(IWordPredictionCallback iWordPredictionCallback) {
    }

    @Override
    public void triggerAddressInputReturn(int n) {
    }

    @Override
    public void indicateVICSEmergencyPopupShown(boolean bl) {
    }

    @Override
    public void setOnlineTraffic(boolean bl) {
        super.log();
    }

    @Override
    public void diagStartDemoRouteGuidance(int[] nArray) {
    }

    @Override
    public void synchronizeSpeechCountryWithCurrentLD() {
    }

    @Override
    public void cancelSDSTrufflesSearch(boolean bl) {
    }

    @Override
    public boolean isCurrentMapCodeNavigable() {
        return false;
    }

    @Override
    public boolean isFurtherMapCodeInputPossible() {
        return false;
    }

    @Override
    public boolean isFurtherTelephonenumberInputPossible() {
        return false;
    }

    @Override
    public void triggerMapCodeReturn() {
    }

    @Override
    public void calculateRRDForNavLocationWgs84Array(NavLocationWgs84[] navLocationWgs84Array, NaviService$IRRDCallback naviService$IRRDCallback) {
    }

    @Override
    public String getAdditionalNameFromNavLocation(NavLocation navLocation) {
        return null;
    }

    @Override
    public void setFavoriteContext(int n) {
    }

    @Override
    public RenderingInfoProvider getRenderingInfoProvider() {
        return null;
    }

    @Override
    public void nextDestinationInput(int n) {
    }

    @Override
    public void triggerAddressInputReturn(int n, int n2) {
    }

    @Override
    public void updateLocalHazardInformation(LocalHazardInformation[] localHazardInformationArray) {
    }

    @Override
    public NaviMsgDetails requestCurrentNaviDataforMessage() {
        return null;
    }

    @Override
    public String getAIFCountryCode() {
        return null;
    }

    @Override
    public void showPoiDetailsPopup() {
    }

    @Override
    public void savePreviewLocation(NavLocation navLocation) {
    }

    @Override
    public void savePreviewTmcMsg(TmcMessage tmcMessage) {
    }

    @Override
    public boolean isTrufflesConflictmodeAvailable() {
        return false;
    }

    @Override
    public int triggerTrufflesConflictmode(String string, String[] stringArray) {
        return 0;
    }

    @Override
    public void startDestinationInputWithCurrentLD(int n) {
    }

    @Override
    public NaviService$NaviInfoDetails getFormattedPoiSearchAreaLocation() {
        return null;
    }

    @Override
    public void fillToolTipInformationContainerByNavLocation(NavLocation navLocation, GuiTooltipInformationContainer guiTooltipInformationContainer) {
    }
}

