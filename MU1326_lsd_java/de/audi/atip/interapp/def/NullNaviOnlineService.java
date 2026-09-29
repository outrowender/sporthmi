/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.def;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.interapp.NaviOnlineService$MapStateService;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineMapOverlay;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineSearchAreaListener;
import de.audi.atip.interapp.NaviOnlineService$NaviOnlineServiceListener;
import de.audi.atip.interapp.NaviOnlineService$POIOnlineData;
import de.audi.atip.interapp.NaviOnlineService$RRDListener;
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

    @Override
    public void callRRDForListType(int n) {
        super.log();
    }

    @Override
    public void setPOIViewportData(NaviOnlineService$POIOnlineData[] naviOnlineService$POIOnlineDataArray, int n, NavLocationWgs84 navLocationWgs84, ChoiceModelApp choiceModelApp) {
        super.log();
    }

    @Override
    public void setMapOverlays(int n, NaviOnlineService$NaviOnlineMapOverlay[] naviOnlineService$NaviOnlineMapOverlayArray, int n2, ChoiceModelApp choiceModelApp) {
        super.log();
    }

    @Override
    public int getPOIIndexFromUserFlags() {
        super.log();
        return 0;
    }

    @Override
    public void prepareAddressForm() {
        super.log();
    }

    @Override
    public String getDataCountryAbbreviation() {
        super.log();
        return null;
    }

    @Override
    public String getDataDayNightView() {
        super.log();
        return null;
    }

    @Override
    public double[] getDataDestination() {
        super.log();
        return null;
    }

    @Override
    public String getDataFallBackLanguage() {
        super.log();
        return null;
    }

    @Override
    public int getDataScreenWidth() {
        super.log();
        return 0;
    }

    @Override
    public int getDataScreenHeight() {
        super.log();
        return 0;
    }

    @Override
    public double[] getDataVehicleLocation() {
        super.log();
        return null;
    }

    @Override
    public String getDataVIN() {
        super.log();
        return null;
    }

    @Override
    public void setListener(NaviOnlineService$NaviOnlineServiceListener naviOnlineService$NaviOnlineServiceListener) {
        super.log();
    }

    @Override
    public NaviOnlineService$NaviOnlineServiceListener getListener() {
        super.log();
        return null;
    }

    @Override
    public void setSearchAreaListener(NaviOnlineService$NaviOnlineSearchAreaListener naviOnlineService$NaviOnlineSearchAreaListener) {
        super.log();
    }

    @Override
    public NaviOnlineService$NaviOnlineSearchAreaListener getSearchAreaListener() {
        super.log();
        return null;
    }

    @Override
    public boolean getIsNaviFullyOperable() {
        super.log();
        return false;
    }

    @Override
    public void sendRemoteHMIAppsUpdateToNaviAndMap(List list) {
        super.log();
    }

    @Override
    public void sendMiniAppsDownloadError() {
        super.log();
    }

    @Override
    public void setRRDListener(NaviOnlineService$RRDListener naviOnlineService$RRDListener) {
        super.log();
    }

    @Override
    public NaviOnlineService$RRDListener getRRDListener() {
        super.log();
        return null;
    }

    @Override
    public void updateRRDDistances(RrdCalculationInfo[] rrdCalculationInfoArray) {
        super.log();
    }

    @Override
    public int[] getRequestedLatitudes() {
        super.log();
        return null;
    }

    @Override
    public int[] getRequestedLongitudes() {
        super.log();
        return null;
    }

    @Override
    public void triggerRRDRequest(ArrayList arrayList) {
        super.log();
    }

    @Override
    public void updateDirectionAndAirDistance(int[] nArray, int[] nArray2) {
        super.log();
    }

    @Override
    public void exitRRD() {
        super.log();
    }

    @Override
    public void startRouteGuidance(NavLocationWgs84 navLocationWgs84, String string, ChoiceModelApp choiceModelApp, String string2) {
        super.log();
    }

    @Override
    public void insertAsStopover(NavLocationWgs84 navLocationWgs84, String string, ChoiceModelApp choiceModelApp, int n, boolean bl) {
        super.log();
    }

    @Override
    public void triggerADRequest(ArrayList arrayList) {
        super.log();
    }

    @Override
    public void exitAD() {
        super.log();
    }

    @Override
    public void swapModel(Object object, Object object2, Object object3, int n, int n2) {
        super.log();
    }

    @Override
    public void setMapStateService(NaviOnlineService$MapStateService naviOnlineService$MapStateService) {
        super.log();
    }

    @Override
    public NaviOnlineService$MapStateService getMapStateService() {
        super.log();
        return null;
    }
}

