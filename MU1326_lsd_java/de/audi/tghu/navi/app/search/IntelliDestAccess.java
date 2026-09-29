/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.search.AbstractSearch;
import de.audi.tghu.navi.app.rp.TripHandler$TripData;
import de.audi.tghu.navi.app.search.ILastDestHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public interface IntelliDestAccess {
    default public NavLocation getNavLocationByIndex(int n) {
    }

    default public int startTrufflesSearch(String string, String[] stringArray) {
    }

    default public void updateRouteInfo(Route route, TripHandler$TripData tripHandler$TripData) {
    }

    default public void updateRgActive(boolean bl) {
    }

    default public ILastDestHandler getLastDestHandler() {
    }

    default public void enterDestinationContext(int n) {
    }

    default public void exitDestinationContext(int n) {
    }

    default public void enterDestinationContextDownTransition(int n) {
    }

    default public void exitTrufflesRangeSelect() {
    }

    default public AbstractSearch getMainSearch() {
    }

    default public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
    }

    default public void resetSettings() {
    }

    default public void setADBHMIAppService(ADBHMIAppService aDBHMIAppService) {
    }

    default public void updateRmRoutesPress() {
    }

    default public void cancelSDSTrufflesSearch(boolean bl) {
    }

    default public boolean isTrufflesConflictmodeAvailable() {
    }

    default public int triggerTrufflesConflictmode(String string, String[] stringArray) {
    }
}

