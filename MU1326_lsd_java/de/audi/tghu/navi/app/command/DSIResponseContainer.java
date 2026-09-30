/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.Navigation;
import de.audi.tghu.navi.app.addressinput.asia.DisambiguatedNavLocation;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Selcrit;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.CombinedRouteListElement;
import org.dsi.ifc.navigation.CountryInfo;
import org.dsi.ifc.navigation.DistanceToNextManeuver;
import org.dsi.ifc.navigation.LDListElement;
import org.dsi.ifc.navigation.LISpellerData;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.NavDataBase;
import org.dsi.ifc.navigation.NavPoiInfo;
import org.dsi.ifc.navigation.NavRmRouteListData;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.PoiExtendedInfo;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.TryBestMatchResultData;
import org.dsi.ifc.navigation.TryMatchLocationResultData;
import org.dsi.ifc.navigation.TurnListElement;
import org.dsi.ifc.navigation.ValueListStatus;
import org.dsi.ifc.tmc.TmcMessage;

public final class DSIResponseContainer {
    private String lispCurrentInput;
    private int lispCurrentSelectionCriterion = -1;
    private int lispPreviousSelectionCriterion = -1;
    private boolean lispIsFullMatch;
    private boolean lispIsUndoAvailable;
    private String lispValidCharacters;
    private String lispNextValidCharacters;
    private int lispNextValidCharactersCount;
    private int lispMultiCriteriaCriterion1;
    private int lispMultiCriteriaCriterion2;
    private boolean lispMultiCriteriaIsActive;
    private boolean lispMultiCriteriaIsAmbiguous;
    private int lispInputFormat;
    private LIValueList lispValueList;
    private long lispValueListCount;
    private NavLocation liCurrentLD;
    private int[] liAvailableSelectionCriteria;
    private int[] liUsefulRefinementCriteria;
    private boolean liIsSpellerActive;
    private LDListElement[] dmLastDestinations;
    private NavRmRouteListData[] rmRoutesTourplan;
    private NavRmRouteListData[] rmRoutesWaypoint;
    private NavRmRouteListData[] rmRoutesPress;
    private NavTraceListData[] trTraceList;
    private boolean rgActive;
    private boolean rgStopped;
    private boolean etcDemoMode;
    private LIValueList poiValueList;
    private long poiValueListCount;
    private CalculatedRouteListElement[] rgCalculatedRoutes;
    private int indexOfCalculatedRoutes;
    private boolean rrdActive;
    private NavLocation transformedLocation;
    private boolean afaSpeaking;
    private short[] rgiString;
    private Route rmRouteGet;
    private long addedRouteId;
    private PosPosition soPosPosition;
    private NavLocation soPosPositionDescription;
    private boolean inProgressData;
    private String language;
    private String[] availableLanguages;
    private NavRouteListData[] rgDestinationInfo;
    private int navstateOfOperation;
    private DistanceToNextManeuver distanceToNextManeuver;
    private long rgTimeAfaToDestination;
    private TryBestMatchResultData[] tryBestMatchResultData;
    private TryMatchLocationResultData[] tryMatchLocationResultData;
    private int etcMetricSystem;
    private String[] navMedia;
    private int rgRouteCalculationState;
    private byte[] locationToStreamResult;
    private NavLocation streamToLocationResult;
    private RgInfoForNextDestination rgInfoForNextDestination;
    private NavDataBase navDataBase;
    private CountryInfo[] countryInfo;
    private boolean routeResumePossible;
    private LISpellerData spellerState;
    private ValueListStatus poiSubstringSearchStatus;
    private TurnListElement[] rgTurnList;
    private Route rmPersistentRoute;
    private NavPoiInfo[] rgPoiInfo;
    private PoiExtendedInfo poiExtendedInfo;
    private int personalPOISearchStatus;
    private int combinedRouteListResultPositionOfFirstListElement;
    private CombinedRouteListElement[] combinedRouteListResultCombinedRouteListElements;
    private long combinedRouteListResultAnchorId;
    private NavLocation rmlPOILocation;
    private NavLocation selectedLocation;
    private int[] categoryTypes;
    private DisambiguatedNavLocation[] disambiguatedNavLocations;
    private NavLocation previewLocation;
    private TmcMessage previewTmcMessage;
    private int predictiveNavOperationMode;
    private boolean isRgPoiInfoEnabled = false;

    public synchronized NavLocation getLiCurrentLD() {
        return this.liCurrentLD;
    }

    public synchronized String getLispCurrentInput() {
        return this.lispCurrentInput;
    }

    public synchronized void setLispCurrentInput(String string) {
        this.lispCurrentInput = string;
    }

    public synchronized int getLispCurrentSelectionCriterion() {
        return this.lispCurrentSelectionCriterion;
    }

    public synchronized boolean isLispIsFullMatch() {
        return this.lispIsFullMatch;
    }

    public synchronized void setLispIsFullMatch(boolean bl) {
        this.lispIsFullMatch = bl;
    }

    public synchronized boolean isLispIsUndoAvailable() {
        return this.lispIsUndoAvailable;
    }

    public synchronized void setLispIsUndoAvailable(boolean bl) {
        this.lispIsUndoAvailable = bl;
    }

    public synchronized int getLispMultiCriteriaCriterion1() {
        return this.lispMultiCriteriaCriterion1;
    }

    public synchronized void setLispMultiCriteriaCriterion1(int n) {
        this.lispMultiCriteriaCriterion1 = n;
    }

    public synchronized int getLispMultiCriteriaCriterion2() {
        return this.lispMultiCriteriaCriterion2;
    }

    public synchronized void setLispMultiCriteriaCriterion2(int n) {
        this.lispMultiCriteriaCriterion2 = n;
    }

    public synchronized boolean isLispMultiCriteriaIsActive() {
        return this.lispMultiCriteriaIsActive;
    }

    public synchronized void setLispMultiCriteriaIsActive(boolean bl) {
        this.lispMultiCriteriaIsActive = bl;
    }

    public synchronized boolean isLispMultiCriteriaIsAmbiguous() {
        return this.lispMultiCriteriaIsAmbiguous;
    }

    public synchronized void setLispMultiCriteriaIsAmbiguous(boolean bl) {
        this.lispMultiCriteriaIsAmbiguous = bl;
    }

    public synchronized String getLispValidCharacters() {
        return this.lispValidCharacters;
    }

    public synchronized void setLispValidCharacters(String string) {
        this.lispValidCharacters = string;
    }

    public synchronized LIValueList getLispValueList() {
        return this.lispValueList;
    }

    public synchronized void setLispValueList(LIValueList lIValueList) {
        this.lispValueList = lIValueList;
    }

    public synchronized long getLispValueListCount() {
        return this.lispValueListCount;
    }

    public synchronized void setLispValueListCount(long l) {
        this.lispValueListCount = l;
    }

    public synchronized String getLispNextValidCharacters() {
        return this.lispNextValidCharacters;
    }

    public synchronized void setLispNextValidCharacters(String string) {
        this.lispNextValidCharacters = string;
    }

    public synchronized int getLispNextValidCharactersCount() {
        return this.lispNextValidCharactersCount;
    }

    public synchronized void setLispNextValidCharactersCount(int n) {
        this.lispNextValidCharactersCount = n;
    }

    public synchronized boolean isLiIsSpellerActive() {
        return this.liIsSpellerActive;
    }

    public synchronized void setLiIsSpellerActive(boolean bl) {
        this.liIsSpellerActive = bl;
    }

    public synchronized void setLispUpdateSpellerResult(String string, int n, boolean bl, boolean bl2, String string2, int n2, int n3, boolean bl3, boolean bl4, int n4) {
        LogChannel logChannel = Navigation.getInstance().getEnv().getLogChannel();
        if (logChannel.isDebug2()) {
            logChannel.log(100000000, "DSIResponseContainer#setLispUpdateSpellerResult - lispCurrentInput=%1, lispCurrentSelectionCriterion=%2, lispIsFullMatch=%3, lispValidCharacters=%4", (Object)string, (Object)(n + ""), (Object)Boolean.toString(bl), (Object)string2);
        }
        this.lispCurrentInput = string;
        if (n == 127 && this.lispCurrentSelectionCriterion != 127) {
            this.lispPreviousSelectionCriterion = this.lispCurrentSelectionCriterion == 0 ? this.lispMultiCriteriaCriterion1 : this.lispCurrentSelectionCriterion;
        }
        this.lispCurrentSelectionCriterion = n;
        this.lispIsFullMatch = bl;
        this.lispIsUndoAvailable = bl2;
        this.lispValidCharacters = string2;
        this.lispMultiCriteriaCriterion1 = n2;
        this.lispMultiCriteriaCriterion2 = n3;
        this.lispMultiCriteriaIsActive = bl3;
        this.lispMultiCriteriaIsAmbiguous = bl4;
        this.lispInputFormat = n4;
    }

    public synchronized void setLiValueList(LIValueList lIValueList, long l) {
        this.lispValueList = lIValueList;
        this.lispValueListCount = l;
    }

    public synchronized void setNextValidCharsAndCount(String string, int n) {
        this.lispNextValidCharacters = string;
        this.lispNextValidCharactersCount = n;
    }

    public synchronized void setLiCurrentState(NavLocation navLocation, int[] nArray, int[] nArray2) {
        Navigation.getInstance().getEnv().getLogChannel().log(10000000, "DSIResponseContainer#setLiCurrentState - liCurrentLD=%1, liAvailableSelectionCriteria=%2, liUsefulRefinementCriteria=%3", (Object)LocationFormatter.formatLocationShort(navLocation), (Object)Selcrit.asString(nArray), (Object)Selcrit.asString(nArray2));
        this.liCurrentLD = navLocation;
        this.liAvailableSelectionCriteria = nArray;
        this.liUsefulRefinementCriteria = nArray2;
    }

    public synchronized boolean selectionCriterionAvailable(int n) {
        if (this.getLiAvailableSelectionCriteria() != null) {
            for (int i2 = 0; i2 < this.getLiAvailableSelectionCriteria().length; ++i2) {
                if (this.getLiAvailableSelectionCriteria()[i2] != n) continue;
                return true;
            }
        }
        return false;
    }

    public synchronized boolean refinementCriterionAvailable(int n) {
        if (this.liUsefulRefinementCriteria != null) {
            for (int i2 = 0; i2 < this.liUsefulRefinementCriteria.length; ++i2) {
                if (this.liUsefulRefinementCriteria[i2] != n) continue;
                return true;
            }
        }
        return false;
    }

    public synchronized int getLispPreviousSelectionCriterion() {
        return this.lispPreviousSelectionCriterion;
    }

    public synchronized LDListElement[] getDmLastDestinations() {
        return this.dmLastDestinations;
    }

    public synchronized void setDmLastDestinations(LDListElement[] lDListElementArray) {
        this.dmLastDestinations = lDListElementArray;
    }

    public synchronized void setRmRoutesTourplan(NavRmRouteListData[] navRmRouteListDataArray) {
        this.rmRoutesTourplan = navRmRouteListDataArray;
    }

    public synchronized NavRmRouteListData[] getRmRoutesTourplan() {
        return this.rmRoutesTourplan;
    }

    public synchronized void setRmRoutesWaypoint(NavRmRouteListData[] navRmRouteListDataArray) {
        this.rmRoutesWaypoint = navRmRouteListDataArray;
    }

    public synchronized NavRmRouteListData[] getRmRoutesWaypoint() {
        return this.rmRoutesWaypoint;
    }

    public synchronized void setRmRoutesPress(NavRmRouteListData[] navRmRouteListDataArray) {
        this.rmRoutesPress = navRmRouteListDataArray;
    }

    public synchronized NavRmRouteListData[] getRmRoutesPress() {
        return this.rmRoutesPress;
    }

    public synchronized void setRgActive(boolean bl) {
        this.rgActive = bl;
    }

    public synchronized boolean isRgActive() {
        return this.rgActive;
    }

    public synchronized void setRgStopped(boolean bl) {
        this.rgStopped = bl;
    }

    public synchronized boolean isRgStopped() {
        return this.rgStopped;
    }

    public synchronized void setEtcDemoMode(boolean bl) {
        this.etcDemoMode = bl;
    }

    public synchronized boolean isEtcDemoMode() {
        return this.etcDemoMode;
    }

    public synchronized void setPOIValueList(LIValueList lIValueList) {
        this.poiValueList = lIValueList;
    }

    public synchronized void setPOIValueListCount(long l) {
        this.poiValueListCount = l;
    }

    public synchronized LIValueList getPOIValueList() {
        return this.poiValueList;
    }

    public synchronized long getPOIValueListCount() {
        return this.poiValueListCount;
    }

    public synchronized void setCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        this.rgCalculatedRoutes = calculatedRouteListElementArray;
    }

    public synchronized CalculatedRouteListElement[] getCalculatedRoutes() {
        return this.rgCalculatedRoutes;
    }

    public synchronized void setIndexOfCalculatedRoutes(int n) {
        this.indexOfCalculatedRoutes = n;
    }

    public synchronized int getIndexOfCalculatedRoutes() {
        return this.indexOfCalculatedRoutes;
    }

    public synchronized void setRRDActive(boolean bl) {
        this.rrdActive = bl;
    }

    public synchronized boolean isRRDActive() {
        return this.rrdActive;
    }

    public synchronized NavLocation getTransformedLocation() {
        return this.transformedLocation;
    }

    public synchronized void setTransformedLocation(NavLocation navLocation) {
        this.transformedLocation = navLocation;
    }

    public synchronized void setAfaSpeaking(boolean bl) {
        this.afaSpeaking = bl;
    }

    public synchronized boolean isAfaSpeaking() {
        return this.afaSpeaking;
    }

    public synchronized void setRGIString(short[] sArray) {
        this.rgiString = sArray;
    }

    public synchronized short[] getRGIString() {
        return this.rgiString;
    }

    public synchronized void setRmRouteGet(Route route) {
        this.rmRouteGet = route;
    }

    public synchronized Route getRmRouteGet() {
        return this.rmRouteGet;
    }

    public synchronized long getAddedRouteId() {
        return this.addedRouteId;
    }

    public synchronized void setAddedRouteId(long l) {
        this.addedRouteId = l;
    }

    public synchronized PosPosition getSoPosPosition() {
        return this.soPosPosition;
    }

    public synchronized void setSoPosPosition(PosPosition posPosition) {
        this.soPosPosition = posPosition;
    }

    public synchronized void setSoPosPositionDescription(NavLocation navLocation) {
        this.soPosPositionDescription = navLocation;
    }

    public synchronized NavLocation getSoPosPositionDescription() {
        return this.soPosPositionDescription;
    }

    public synchronized void setInProgressData(boolean bl) {
        this.inProgressData = bl;
    }

    public synchronized boolean getInProgressData() {
        return this.inProgressData;
    }

    public synchronized void setLanguage(String string) {
        this.language = string;
    }

    public synchronized String getLanguage() {
        return this.language;
    }

    public synchronized void setAvailableLanguages(String[] stringArray) {
        this.availableLanguages = stringArray;
    }

    public synchronized String[] getAvailableLanguages() {
        return this.availableLanguages;
    }

    public synchronized void setRgDestinationInfo(NavRouteListData[] navRouteListDataArray) {
        this.rgDestinationInfo = navRouteListDataArray;
    }

    public synchronized NavRouteListData[] getRgDestinationInfo() {
        return this.rgDestinationInfo;
    }

    public synchronized void setNavstateOfOperation(int n) {
        this.navstateOfOperation = n;
    }

    public synchronized int getNavstateOfOperation() {
        return this.navstateOfOperation;
    }

    public synchronized void setDistanceToNextManeuver(DistanceToNextManeuver distanceToNextManeuver) {
        this.distanceToNextManeuver = distanceToNextManeuver;
    }

    public synchronized DistanceToNextManeuver getDistanceToNextManeuver() {
        return this.distanceToNextManeuver;
    }

    public synchronized void setRgTimeAfaToDestination(long l) {
        this.rgTimeAfaToDestination = l;
    }

    public synchronized long getRgTimeAfaToDestination() {
        return this.rgTimeAfaToDestination;
    }

    public synchronized void setTryBestMatchResultData(TryBestMatchResultData[] tryBestMatchResultDataArray) {
        this.tryBestMatchResultData = tryBestMatchResultDataArray;
    }

    public synchronized TryBestMatchResultData[] getTryBestMatchResultData() {
        return this.tryBestMatchResultData;
    }

    public synchronized void setTryMatchLocationResultData(TryMatchLocationResultData[] tryMatchLocationResultDataArray) {
        this.tryMatchLocationResultData = tryMatchLocationResultDataArray;
    }

    public synchronized TryMatchLocationResultData[] getTryMatchLocationResultData() {
        return this.tryMatchLocationResultData;
    }

    public synchronized void setEtcMetricSystem(int n) {
        this.etcMetricSystem = n;
    }

    public synchronized int getEtcMetricSystem() {
        return this.etcMetricSystem;
    }

    public synchronized void setNavMedia(String[] stringArray) {
        this.navMedia = stringArray;
    }

    public synchronized String[] getNavMedia() {
        return this.navMedia;
    }

    public synchronized void setRgRouteCalculationState(int n) {
        this.rgRouteCalculationState = n;
    }

    public synchronized int getRgRouteCalculationState() {
        return this.rgRouteCalculationState;
    }

    public synchronized byte[] getLocationToStreamResult() {
        return this.locationToStreamResult;
    }

    public synchronized void setLocationToStreamResult(byte[] byArray) {
        this.locationToStreamResult = byArray;
    }

    public synchronized NavLocation getStreamToLocationResult() {
        return this.streamToLocationResult;
    }

    public synchronized void setStreamToLocationResult(NavLocation navLocation) {
        this.streamToLocationResult = navLocation;
    }

    public synchronized RgInfoForNextDestination getRgInfoForNextDestination() {
        return this.rgInfoForNextDestination;
    }

    public synchronized void setRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        this.rgInfoForNextDestination = rgInfoForNextDestination;
    }

    public synchronized NavDataBase getNavDataBase() {
        return this.navDataBase;
    }

    public synchronized void setNavDataBase(NavDataBase navDataBase) {
        this.navDataBase = navDataBase;
    }

    public synchronized CountryInfo[] getCountryInfo() {
        return this.countryInfo;
    }

    public synchronized void setCountryInfo(CountryInfo[] countryInfoArray) {
        this.countryInfo = countryInfoArray;
    }

    public synchronized boolean isRouteResumePossible() {
        return this.routeResumePossible;
    }

    public synchronized void setRouteResumePossible(boolean bl) {
        this.routeResumePossible = bl;
    }

    public synchronized LISpellerData getSpellerState() {
        return this.spellerState;
    }

    public synchronized void setSpellerState(LISpellerData lISpellerData) {
        this.spellerState = lISpellerData;
    }

    public synchronized ValueListStatus getPoiSubstringSearchStatus() {
        return this.poiSubstringSearchStatus;
    }

    public synchronized void setPoiSubstringSearchStatus(ValueListStatus valueListStatus) {
        this.poiSubstringSearchStatus = valueListStatus;
    }

    public synchronized TurnListElement[] getRgTurnList() {
        return this.rgTurnList;
    }

    public synchronized void setRgTurnList(TurnListElement[] turnListElementArray) {
        this.rgTurnList = turnListElementArray;
    }

    public synchronized Route getRmPersistentRoute() {
        return this.rmPersistentRoute;
    }

    public synchronized void setRmPersistentRoute(Route route) {
        this.rmPersistentRoute = route;
    }

    public synchronized NavPoiInfo[] getRgPoiInfo() {
        return this.rgPoiInfo;
    }

    public synchronized PoiExtendedInfo getPoiExtendedInfo() {
        return this.poiExtendedInfo;
    }

    public synchronized void setRgPoiInfo(NavPoiInfo[] navPoiInfoArray) {
        this.rgPoiInfo = navPoiInfoArray;
    }

    public synchronized void setPoiExtendedInfo(PoiExtendedInfo poiExtendedInfo) {
        this.poiExtendedInfo = poiExtendedInfo;
    }

    public synchronized int getPersonalPOISearchStatus() {
        return this.personalPOISearchStatus;
    }

    public synchronized void setPersonalPOISearchStatus(int n) {
        this.personalPOISearchStatus = n;
    }

    public synchronized void setCombinedRouteListResult(long l, CombinedRouteListElement[] combinedRouteListElementArray, int n) {
        this.combinedRouteListResultAnchorId = l;
        this.combinedRouteListResultCombinedRouteListElements = combinedRouteListElementArray;
        this.combinedRouteListResultPositionOfFirstListElement = n;
    }

    public synchronized int getCombinedRouteListResultPositionOfFirstListElement() {
        return this.combinedRouteListResultPositionOfFirstListElement;
    }

    public synchronized CombinedRouteListElement[] getCombinedRouteListResultCombinedRouteListElements() {
        return this.combinedRouteListResultCombinedRouteListElements;
    }

    public synchronized long getCombinedRouteListResultAnchorId() {
        return this.combinedRouteListResultAnchorId;
    }

    public void setRMLPOILocation(NavLocation navLocation) {
        this.rmlPOILocation = navLocation;
    }

    public NavLocation getRMLPOILocation() {
        return this.rmlPOILocation;
    }

    public void setSelectedLocation(NavLocation navLocation) {
        this.selectedLocation = navLocation;
    }

    public NavLocation getSelectedLocation() {
        return this.selectedLocation;
    }

    public void setPoiGetCategoryTypesFromUId(int[] nArray) {
        this.categoryTypes = nArray;
    }

    public int[] getPoiGetCategoryTypesFromUId() {
        return this.categoryTypes;
    }

    public void setEnableRgPoiInfo(boolean bl) {
        this.isRgPoiInfoEnabled = bl;
    }

    public boolean isRgPoiInfoEnabled() {
        return this.isRgPoiInfoEnabled;
    }

    public int[] getLiAvailableSelectionCriteria() {
        return this.liAvailableSelectionCriteria;
    }

    public synchronized void setDisambiguatedNavLocations(DisambiguatedNavLocation[] disambiguatedNavLocationArray) {
        this.disambiguatedNavLocations = disambiguatedNavLocationArray;
    }

    public synchronized DisambiguatedNavLocation[] getDisambiguatedNavLocations() {
        return this.disambiguatedNavLocations;
    }

    public synchronized void setTrTraceList(NavTraceListData[] navTraceListDataArray) {
        this.trTraceList = navTraceListDataArray;
    }

    public synchronized NavTraceListData[] getTrTraceList() {
        return this.trTraceList;
    }

    public synchronized int getPredictiveNavOperationMode() {
        return this.predictiveNavOperationMode;
    }

    public synchronized void setPredictiveNavOperationMode(int n) {
        this.predictiveNavOperationMode = n;
    }

    public synchronized NavLocation getPreviewLocation() {
        return this.previewLocation;
    }

    public synchronized void setPreviewLocation(NavLocation navLocation) {
        this.previewLocation = navLocation;
    }

    public synchronized TmcMessage getPreviewTmc() {
        return this.previewTmcMessage;
    }

    public void setPreviewTmc(TmcMessage tmcMessage) {
        this.previewTmcMessage = tmcMessage;
    }
}

