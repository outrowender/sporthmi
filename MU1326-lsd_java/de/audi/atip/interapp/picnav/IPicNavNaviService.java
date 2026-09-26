/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.picnav;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public interface IPicNavNaviService {
    default public void initInterface(ListModelApp listModelApp, ListModelApp listModelApp2) {
    }

    default public void createPicNavLocation(NavLocation navLocation, ResourceLocator resourceLocator) {
    }

    default public void tagPicNavLocationAsImplicit(NavLocation navLocation) {
    }

    default public boolean isPicNavLocation(NavLocation navLocation) {
    }

    default public void focusPreviewMapOnSingleEvent(NavLocation navLocation) {
    }

    default public void focusPreviewMapOnMultipleEvents(NavLocation[] navLocationArray) {
    }

    default public boolean isImplicitNavLocation(NavLocation navLocation) {
    }

    default public void addToFavorites(NavLocation navLocation, String string) {
    }

    default public ResourceLocator getPictureFromPicNavLocation(NavLocation navLocation) {
    }

    default public boolean isPositionValid(NavLocation navLocation) {
    }

    default public boolean isMapFrozen() {
    }

    default public boolean isGoogleActive() {
    }

    default public String getStreetForPicNavLocation(NavLocation navLocation) {
    }

    default public String getCityForPicNavLocation(NavLocation navLocation) {
    }

    default public String getCountryForPicNavLocation(NavLocation navLocation) {
    }

    default public void resolveLocation(String string, String string2, ResourceLocator resourceLocator) {
    }

    default public void prepareStartRouteGuidance() {
    }

    default public void startRouteGuidance(NavLocation navLocation, boolean bl) {
    }

    default public void addAsStopOver(NavLocation navLocation) {
    }

    default public void showPictureMap(NavLocation navLocation) {
    }

    default public void hidePictureMap() {
    }

    default public String getPicNavDistance(NavLocation navLocation) {
    }

    default public void showPictureNavLocationOnMap(NavLocation navLocation, int n, ResourceLocator resourceLocator, boolean bl) {
    }

    default public void resetEditInputMode() {
    }

    default public void handlePicNavCurrentState(NavLocation navLocation, LogChannel logChannel) {
    }

    default public void handlePicNavMapCurrentState(NavLocation navLocation, LogChannel logChannel) {
    }

    default public NavLocation getCCP() {
    }

    default public int computeAirDistanceToCCP(int n, int n2) {
    }

    default public double[] getDistanceCoordinatesFromLocation(NavLocation navLocation, int n) {
    }

    default public NavLocation getFinalDestination() {
    }

    default public int getADBActiveProfile() {
    }

    default public void startStoringAddress(NavLocation navLocation) {
    }

    default public void parkingNearDestination(NavLocation navLocation) {
    }

    default public void addToADB(NavLocation navLocation) {
    }

    default public void showDestinationInMap(NavLocation navLocation) {
    }

    default public void enterPreviewMapScreen() {
    }
}

