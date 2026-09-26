/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviOnlineService$MapStateService;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineMapOverlay;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineSearchAreaListener;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineServiceListener;
import de.audi.atip.interapp.NaviOnlineService$POIOnlineData;
import de.audi.atip.interapp.NaviOnlineService$RRDListener;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public interface NaviOnlineService {
    public static final int STOPOVER_INDEX_NEXT_STOPOVER;
    public static final int STOPOVER_INDEX_BEFORE_DESTINATION;
    public static final int STOPOVER_INDEX_DEFAULT;

    default public void callRRDForListType(int n) {
    }

    default public void setPOIViewportData(POIOnlineData[] pOIOnlineDataArray, int n, NavLocationWgs84 navLocationWgs84, ChoiceModelApp choiceModelApp) {
    }

    default public void setMapOverlays(int n, NaviOnlineService$NaviOnlineMapOverlay[] naviOnlineService$NaviOnlineMapOverlayArray, int n2, ChoiceModelApp choiceModelApp) {
    }

    default public int getPOIIndexFromUserFlags() {
    }

    default public void prepareAddressForm() {
    }

    default public String getDataCountryAbbreviation() {
    }

    default public String getDataDayNightView() {
    }

    default public double[] getDataDestination() {
    }

    default public String getDataFallBackLanguage() {
    }

    default public int getDataScreenWidth() {
    }

    default public int getDataScreenHeight() {
    }

    default public double[] getDataVehicleLocation() {
    }

    default public String getDataVIN() {
    }

    default public void setListener(NaviOnlineService$NaviOnlineServiceListener naviOnlineService$NaviOnlineServiceListener) {
    }

    default public NaviOnlineService$NaviOnlineServiceListener getListener() {
    }

    default public void setSearchAreaListener(NaviOnlineService$NaviOnlineSearchAreaListener naviOnlineService$NaviOnlineSearchAreaListener) {
    }

    default public NaviOnlineService$NaviOnlineSearchAreaListener getSearchAreaListener() {
    }

    default public boolean getIsNaviFullyOperable() {
    }

    default public void sendRemoteHMIAppsUpdateToNaviAndMap(List list) {
    }

    default public void sendMiniAppsDownloadError() {
    }

    default public void setRRDListener(NaviOnlineService$RRDListener naviOnlineService$RRDListener) {
    }

    default public NaviOnlineService$RRDListener getRRDListener() {
    }

    default public void updateRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }

    default public int[] getRequestedLatitudes() {
    }

    default public int[] getRequestedLongitudes() {
    }

    default public void triggerRRDRequest(ArrayList arrayList) {
    }

    default public void updateDirectionAndAirDistance(int[] nArray, int[] nArray2) {
    }

    default public void exitRRD() {
    }

    default public void startRouteGuidance(NavLocationWgs84 navLocationWgs84, String string, ChoiceModelApp choiceModelApp, String string2) {
    }

    default public void insertAsStopover(NavLocationWgs84 navLocationWgs84, String string, ChoiceModelApp choiceModelApp, int n, boolean bl) {
    }

    default public void triggerADRequest(ArrayList arrayList) {
    }

    default public void exitAD() {
    }

    default public void swapModel(Object object, Object object2, Object object3, int n, int n2) {
    }

    default public void setMapStateService(NaviOnlineService$MapStateService naviOnlineService$MapStateService) {
    }

    default public NaviOnlineService$MapStateService getMapStateService() {
    }
}

