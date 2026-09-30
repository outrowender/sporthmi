/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import java.util.ArrayList;
import java.util.List;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class NullNaviOnlineService
extends NullService
implements NaviOnlineService {
    public NullNaviOnlineService(LogChannel logChannel) {
        super(logChannel, "NaviOnlineService");
    }

    public void callRRDForListType(int n) {
        super.log();
    }

    public void setPOIViewportData(NaviOnlineService.POIOnlineData[] pOIOnlineDataArray, int n, NavLocationWgs84 navLocationWgs84, ChoiceModelApp choiceModelApp) {
        super.log();
    }

    public void setMapOverlays(int n, NaviOnlineService.NaviOnlineMapOverlay[] naviOnlineMapOverlayArray, int n2, ChoiceModelApp choiceModelApp) {
        super.log();
    }

    public int getPOIIndexFromUserFlags() {
        super.log();
        return 0;
    }

    public void prepareAddressForm() {
        super.log();
    }

    public String getDataCountryAbbreviation() {
        super.log();
        return null;
    }

    public String getDataDayNightView() {
        super.log();
        return null;
    }

    public double[] getDataDestination() {
        super.log();
        return null;
    }

    public String getDataFallBackLanguage() {
        super.log();
        return null;
    }

    public int getDataScreenWidth() {
        super.log();
        return 0;
    }

    public int getDataScreenHeight() {
        super.log();
        return 0;
    }

    public double[] getDataVehicleLocation() {
        super.log();
        return null;
    }

    public String getDataVIN() {
        super.log();
        return null;
    }

    public void setListener(NaviOnlineService.NaviOnlineServiceListener naviOnlineServiceListener) {
        super.log();
    }

    public NaviOnlineService.NaviOnlineServiceListener getListener() {
        super.log();
        return null;
    }

    public void setSearchAreaListener(NaviOnlineService.NaviOnlineSearchAreaListener naviOnlineSearchAreaListener) {
        super.log();
    }

    public NaviOnlineService.NaviOnlineSearchAreaListener getSearchAreaListener() {
        super.log();
        return null;
    }

    public boolean getIsNaviFullyOperable() {
        super.log();
        return false;
    }

    public void sendRemoteHMIAppsUpdateToNaviAndMap(List list) {
        super.log();
    }

    public void sendMiniAppsDownloadError() {
        super.log();
    }

    public void setRRDListener(NaviOnlineService.RRDListener rRDListener) {
        super.log();
    }

    public NaviOnlineService.RRDListener getRRDListener() {
        super.log();
        return null;
    }

    public void updateRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
        super.log();
    }

    public int[] getRequestedLatitudes() {
        super.log();
        return null;
    }

    public int[] getRequestedLongitudes() {
        super.log();
        return null;
    }

    public void triggerRRDRequest(ArrayList arrayList) {
        super.log();
    }

    public void updateDirectionAndAirDistance(int[] nArray, int[] nArray2) {
        super.log();
    }

    public void exitRRD() {
        super.log();
    }

    public void startRouteGuidance(NavLocationWgs84 navLocationWgs84, String string, ChoiceModelApp choiceModelApp, String string2) {
        super.log();
    }

    public void insertAsStopover(NavLocationWgs84 navLocationWgs84, String string, ChoiceModelApp choiceModelApp, int n, boolean bl) {
        super.log();
    }

    public void triggerADRequest(ArrayList arrayList) {
        super.log();
    }

    public void exitAD() {
        super.log();
    }

    public void swapModel(Object object, Object object2, Object object3, int n, int n2) {
        super.log();
    }

    public void setMapStateService(NaviOnlineService.MapStateService mapStateService) {
        super.log();
    }

    public NaviOnlineService.MapStateService getMapStateService() {
        super.log();
        return null;
    }
}

