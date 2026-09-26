/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.app.navi.evo.search.ActiveDestinationsManager$ActiveDestRow;
import de.audi.app.navi.evo.search.ActiveDestinationsManager$ActiveDestText;
import de.audi.app.navi.evo.search.ActiveDestinationsManager$ActiveDestinationsListListener;
import de.audi.app.navi.evo.search.ActiveDestinationsManager$ActiveDestinationsPopUpButtonListener;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceManager;
import de.audi.tghu.navi.app.rp.TripHandler$TripData;
import de.audi.tghu.navi.app.util.RouteUtil;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public class ActiveDestinationsManager {
    private static final int STAY_IN_SCREEN;
    private static final int START_RG;
    private static final int SHOW_POPUP;
    private BaseListModelApp activeDestinationsList;
    private ButtonModelApp deleteMainDestinationButton;
    private ButtonModelApp deleteAllDestinationsButton;
    private ChoiceModelApp removeActiveDestinationsChoice;
    private final NavigationEnv env;
    private final IStartGuidanceManager routeManager;
    private LogChannel logger;
    private static final String LOGCLASS;
    private NavLocation mainDestination;
    private NavLocation stopOver;
    private static final int FLAG_ICON_MAIN_DESTINATION;
    private static final int FLAG_ICON_STOPOVER;
    private static final int LAYOUT_ONE_DESTINATION;
    private static final int LAYOUT_TWO_DESTINATIONS;
    private boolean blockListUpdates;
    private boolean rgActive;
    private static final int ACTIVE_DEST_MAIN;
    private static final int ACTIVE_DEST_STOPOVER;
    private static final int FINAL_DEST;

    public ActiveDestinationsManager(NavigationEnv navigationEnv, IStartGuidanceManager iStartGuidanceManager) {
        this.logger = navigationEnv.getLogChannel("App.Navi.Search");
        this.env = navigationEnv;
        this.routeManager = iStartGuidanceManager;
        this.removeActiveDestinationsChoice = navigationEnv.getChoiceModel(2164224);
        ActiveDestinationsManager$ActiveDestinationsListListener activeDestinationsManager$ActiveDestinationsListListener = new ActiveDestinationsManager$ActiveDestinationsListListener(this, null);
        this.activeDestinationsList = navigationEnv.getBaseListModel(1595803136);
        this.activeDestinationsList.setListener(activeDestinationsManager$ActiveDestinationsListListener);
        this.deleteMainDestinationButton = navigationEnv.getButtonModel(1612645888);
        this.deleteAllDestinationsButton = navigationEnv.getButtonModel(1595868672);
        ActiveDestinationsManager$ActiveDestinationsPopUpButtonListener activeDestinationsManager$ActiveDestinationsPopUpButtonListener = new ActiveDestinationsManager$ActiveDestinationsPopUpButtonListener(this, null);
        this.deleteMainDestinationButton.setButtonListener(activeDestinationsManager$ActiveDestinationsPopUpButtonListener);
        this.deleteAllDestinationsButton.setButtonListener(activeDestinationsManager$ActiveDestinationsPopUpButtonListener);
    }

    public NavLocation getNavLocation(int n) {
        if (n == 0) {
            return this.mainDestination;
        }
        return this.stopOver;
    }

    public NavLocation getNavLocation(long l) {
        if (this.activeDestinationsList.getIndexForUniqueID(l) == 0) {
            return this.mainDestination;
        }
        return this.stopOver;
    }

    public void routeGuidanceToDestinationRequested() {
        this.blockListUpdates = false;
    }

    public void cancelStartRouteCalculation() {
        this.blockListUpdates = false;
        this.clearActiveDestinations();
    }

    public void loadInitialScreen() {
        this.blockListUpdates = false;
        if (!this.rgActive) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "%1#loadInitialScreen() rgActive: false", (Object)"ActiveDestinationsManager");
            }
            this.clearActiveDestinations();
        }
    }

    public synchronized void updateRgActive(boolean bl) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "%1#updateRgActive()", (Object)"ActiveDestinationsManager");
        }
        this.rgActive = bl;
        if (this.blockListUpdates) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "%2#updateRgActive() blockListUpdates: %1", this.blockListUpdates, (Object)"ActiveDestinationsManager");
            }
            return;
        }
        if (!bl) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "%1#updateRgActive() false", (Object)"ActiveDestinationsManager");
            }
            this.clearActiveDestinations();
            return;
        }
    }

    public synchronized void updateRouteInfo(Route route, TripHandler$TripData tripHandler$TripData) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "%1#updateRouteInfo()", (Object)"ActiveDestinationsManager");
        }
        if (!this.rgActive) {
            this.logger.log(-2137614336, "%2#updateRouteInfo() rgActive: %1, do not update the list", this.rgActive, (Object)"ActiveDestinationsManager");
            return;
        }
        if (this.blockListUpdates) {
            if (this.logger.isDebug2()) {
                this.logger.log(14808325, "%2#updateRouteInfo() blockListUpdates: %1", this.blockListUpdates, (Object)"ActiveDestinationsManager");
            }
            return;
        }
        if (route == null) {
            this.logger.log(-1601830656, "%1#updateRouteInfo() rgCurrentRoute is null", (Object)"ActiveDestinationsManager");
            return;
        }
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        int n = RouteUtil.getNumberOfRemainingDestinations(route, 1);
        if (routeDestinationArray == null || routeDestinationArray.length == 0 || n == 0) {
            this.activeDestinationsList.removeAll();
            return;
        }
        EvoListRow[] evoListRowArray = new ActiveDestinationsManager$ActiveDestRow[n];
        try {
            Object object;
            if (evoListRowArray.length == 1) {
                this.mainDestination = routeDestinationArray[(int)route.getIndexOfCurrentDestination()].getRouteLocation();
                object = new ActiveDestinationsManager$ActiveDestText(this, this.mainDestination, route.routeID, route.routename, true);
                this.addDestinationStringsToList((ActiveDestinationsManager$ActiveDestText)object, true, evoListRowArray, 0);
                this.stopOver = null;
            } else if (evoListRowArray.length > 1) {
                this.mainDestination = routeDestinationArray[1].getRouteLocation();
                this.addDestinationStringsToList(new ActiveDestinationsManager$ActiveDestText(this, this.mainDestination, route.routeID, route.routename, true), true, evoListRowArray, 0);
                if (route.getIndexOfCurrentDestination() == 0L) {
                    this.stopOver = routeDestinationArray[0].getRouteLocation();
                    object = new ActiveDestinationsManager$ActiveDestText(this, this.stopOver, route.routeID, route.routename, false);
                    this.addDestinationStringsToList((ActiveDestinationsManager$ActiveDestText)object, false, evoListRowArray, 1);
                }
            }
            this.updateTimeAndDistance(tripHandler$TripData, evoListRowArray);
            if (n != this.activeDestinationsList.getLength()) {
                object = this.activeDestinationsList.getEmptyCopy();
                for (int i2 = 0; i2 < evoListRowArray.length; ++i2) {
                    object.append(evoListRowArray[i2]);
                }
                this.activeDestinationsList.setLength(evoListRowArray.length);
                this.activeDestinationsList.update((BaseListModelApp)object);
            } else {
                this.activeDestinationsList.setRows(-1, 0, evoListRowArray);
            }
        }
        catch (Exception exception) {
            this.logger.log(10000, "%1#updateRouteInfo() %2", (Object)"ActiveDestinationsManager", (Throwable)exception);
        }
    }

    private void updateTimeAndDistance(TripHandler$TripData tripHandler$TripData, EvoListRow[] evoListRowArray) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "%1#updateTimeAndDistance()", (Object)"ActiveDestinationsManager");
        }
        long l = tripHandler$TripData.etaToNextDestination;
        int n = tripHandler$TripData.distanceToNextDestination;
        if (evoListRowArray.length == 0) {
            return;
        }
        if (evoListRowArray.length == 1) {
            ActiveDestinationsManager$ActiveDestRow activeDestinationsManager$ActiveDestRow = new ActiveDestinationsManager$ActiveDestRow(this, (ActiveDestinationsManager$ActiveDestRow)evoListRowArray[0], this.getEtaAsDateMetric(l, tripHandler$TripData.etaValid), new Distance(n, 5));
            int n2 = 0;
            activeDestinationsManager$ActiveDestRow.setInteger(7, n2);
            evoListRowArray[0] = activeDestinationsManager$ActiveDestRow;
        } else if (evoListRowArray.length == 2) {
            long l2 = this.env.getFramework().getKombiTime() + 0 * tripHandler$TripData.timeToFinalDestination;
            ActiveDestinationsManager$ActiveDestRow activeDestinationsManager$ActiveDestRow = (ActiveDestinationsManager$ActiveDestRow)evoListRowArray[0];
            activeDestinationsManager$ActiveDestRow.setMetrics(3, this.getEtaAsDateMetric(l2, this.getFinalDestReliability()));
            activeDestinationsManager$ActiveDestRow.setMetrics(4, new Distance(tripHandler$TripData.distanceToFinalDestination, 5));
            ActiveDestinationsManager$ActiveDestRow activeDestinationsManager$ActiveDestRow2 = (ActiveDestinationsManager$ActiveDestRow)evoListRowArray[1];
            activeDestinationsManager$ActiveDestRow2.setMetrics(3, this.getEtaAsDateMetric(l, tripHandler$TripData.etaValid));
            activeDestinationsManager$ActiveDestRow2.setMetrics(4, new Distance(n, 5));
            int n3 = 1;
            activeDestinationsManager$ActiveDestRow.setInteger(7, n3);
            activeDestinationsManager$ActiveDestRow2.setInteger(7, n3);
            evoListRowArray[0] = activeDestinationsManager$ActiveDestRow;
            evoListRowArray[1] = activeDestinationsManager$ActiveDestRow2;
        }
    }

    private boolean getFinalDestReliability() {
        NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
        int n = 0;
        if (null == navRouteListDataArray || navRouteListDataArray.length <= 1) {
            this.logger.log(-2137614336, "%1#getFinalDestReliability() rgDestInfo == null", (Object)"ActiveDestinationsManager");
        } else {
            n = navRouteListDataArray[1].remainingTravelTimeStatus;
        }
        return n == 1;
    }

    private DateMetric getEtaAsDateMetric(long l, boolean bl) {
        DateMetric dateMetric = new DateMetric(new Date(l), 1);
        dateMetric.setDateValid(bl);
        return dateMetric;
    }

    private void addDestinationStringsToList(ActiveDestinationsManager$ActiveDestText activeDestinationsManager$ActiveDestText, boolean bl, EvoListRow[] evoListRowArray, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "%1#addDestinationToList()", (Object)"ActiveDestinationsManager");
        }
        int n2 = bl ? 0 : 1;
        ActiveDestinationsManager$ActiveDestRow activeDestinationsManager$ActiveDestRow = new ActiveDestinationsManager$ActiveDestRow(this, evoListRowArray.length + n, activeDestinationsManager$ActiveDestText.getMainTitle(), activeDestinationsManager$ActiveDestText.getSubTitle(), n2, null, null, 0);
        evoListRowArray[n] = activeDestinationsManager$ActiveDestRow;
    }

    private void clearActiveDestinations() {
        if (this.activeDestinationsList.getLength() == 1) {
            this.activeDestinationsList.remove(this.activeDestinationsList.getRow(0));
        } else if (this.activeDestinationsList.getLength() == 2) {
            this.activeDestinationsList.remove(new long[]{this.activeDestinationsList.getRow(0).getUniqueID(), this.activeDestinationsList.getRow(1).getUniqueID()});
        }
    }

    static /* synthetic */ NavigationEnv access$200(ActiveDestinationsManager activeDestinationsManager) {
        return activeDestinationsManager.env;
    }

    static /* synthetic */ LogChannel access$300(ActiveDestinationsManager activeDestinationsManager) {
        return activeDestinationsManager.logger;
    }

    static /* synthetic */ BaseListModelApp access$400(ActiveDestinationsManager activeDestinationsManager) {
        return activeDestinationsManager.activeDestinationsList;
    }

    static /* synthetic */ IStartGuidanceManager access$500(ActiveDestinationsManager activeDestinationsManager) {
        return activeDestinationsManager.routeManager;
    }

    static /* synthetic */ void access$600(ActiveDestinationsManager activeDestinationsManager) {
        activeDestinationsManager.clearActiveDestinations();
    }

    static /* synthetic */ NavLocation access$702(ActiveDestinationsManager activeDestinationsManager, NavLocation navLocation) {
        activeDestinationsManager.mainDestination = navLocation;
        return activeDestinationsManager.mainDestination;
    }

    static /* synthetic */ ChoiceModelApp access$800(ActiveDestinationsManager activeDestinationsManager) {
        return activeDestinationsManager.removeActiveDestinationsChoice;
    }

    static /* synthetic */ boolean access$902(ActiveDestinationsManager activeDestinationsManager, boolean bl) {
        activeDestinationsManager.blockListUpdates = bl;
        return activeDestinationsManager.blockListUpdates;
    }

    static /* synthetic */ NavLocation access$700(ActiveDestinationsManager activeDestinationsManager) {
        return activeDestinationsManager.mainDestination;
    }

    static /* synthetic */ NavLocation access$1002(ActiveDestinationsManager activeDestinationsManager, NavLocation navLocation) {
        activeDestinationsManager.stopOver = navLocation;
        return activeDestinationsManager.stopOver;
    }

    static /* synthetic */ NavLocation access$1000(ActiveDestinationsManager activeDestinationsManager) {
        return activeDestinationsManager.stopOver;
    }

    static /* synthetic */ ButtonModelApp access$1100(ActiveDestinationsManager activeDestinationsManager) {
        return activeDestinationsManager.deleteMainDestinationButton;
    }

    static /* synthetic */ ButtonModelApp access$1200(ActiveDestinationsManager activeDestinationsManager) {
        return activeDestinationsManager.deleteAllDestinationsButton;
    }
}

