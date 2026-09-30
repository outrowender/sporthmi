/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.interapp.ADBHMIAppService;
import de.audi.atip.search.AbstractSearch;
import de.audi.tghu.navi.app.rp.TripHandler;
import de.audi.tghu.navi.app.search.ILastDestHandler;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public interface IntelliDestAccess {
    public NavLocation getNavLocationByIndex(int var1);

    public int startTrufflesSearch(String var1, String[] var2);

    public void updateRouteInfo(Route var1, TripHandler.TripData var2);

    public void updateRgActive(boolean var1);

    public ILastDestHandler getLastDestHandler();

    public void enterDestinationContext(int var1);

    public void exitDestinationContext(int var1);

    public void enterDestinationContextDownTransition(int var1);

    public void exitTrufflesRangeSelect();

    public AbstractSearch getMainSearch();

    public void updateRrdCalculationInfo(RrdCalculationInfo[] var1);

    public void resetSettings();

    public void setADBHMIAppService(ADBHMIAppService var1);

    public void updateRmRoutesPress();

    public void cancelSDSTrufflesSearch(boolean var1);

    public boolean isTrufflesConflictmodeAvailable();

    public int triggerTrufflesConflictmode(String var1, String[] var2);
}

