/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.picnav;

import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;

public interface IPicNavNaviService {
    public void initInterface(ListModelApp var1, ListModelApp var2);

    public void createPicNavLocation(NavLocation var1, ResourceLocator var2);

    public void tagPicNavLocationAsImplicit(NavLocation var1);

    public boolean isPicNavLocation(NavLocation var1);

    public void focusPreviewMapOnSingleEvent(NavLocation var1);

    public void focusPreviewMapOnMultipleEvents(NavLocation[] var1);

    public boolean isImplicitNavLocation(NavLocation var1);

    public void addToFavorites(NavLocation var1, String var2);

    public ResourceLocator getPictureFromPicNavLocation(NavLocation var1);

    public boolean isPositionValid(NavLocation var1);

    public boolean isMapFrozen();

    public boolean isGoogleActive();

    public String getStreetForPicNavLocation(NavLocation var1);

    public String getCityForPicNavLocation(NavLocation var1);

    public String getCountryForPicNavLocation(NavLocation var1);

    public void resolveLocation(String var1, String var2, ResourceLocator var3);

    public void prepareStartRouteGuidance();

    public void startRouteGuidance(NavLocation var1, boolean var2);

    public void addAsStopOver(NavLocation var1);

    public void showPictureMap(NavLocation var1);

    public void hidePictureMap();

    public String getPicNavDistance(NavLocation var1);

    public void showPictureNavLocationOnMap(NavLocation var1, int var2, ResourceLocator var3, boolean var4);

    public void resetEditInputMode();

    public void handlePicNavCurrentState(NavLocation var1, LogChannel var2);

    public void handlePicNavMapCurrentState(NavLocation var1, LogChannel var2);

    public NavLocation getCCP();

    public int computeAirDistanceToCCP(int var1, int var2);

    public double[] getDistanceCoordinatesFromLocation(NavLocation var1, int var2);

    public NavLocation getFinalDestination();

    public int getADBActiveProfile();

    public void startStoringAddress(NavLocation var1);

    public void parkingNearDestination(NavLocation var1);

    public void addToADB(NavLocation var1);

    public void showDestinationInMap(NavLocation var1);

    public void enterPreviewMapScreen();
}

