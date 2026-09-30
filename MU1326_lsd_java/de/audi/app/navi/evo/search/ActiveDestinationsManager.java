/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.search;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.PropertyListCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.AbstractMetrics;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceManager;
import de.audi.tghu.navi.app.rp.TripHandler;
import de.audi.tghu.navi.app.util.RouteUtil;
import de.audi.tghu.navi.app.util.addressformatting.AddressFormatter;
import de.audi.tghu.navi.app.util.addressformatting.LocationFormattingResponse;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.NavRouteListData;
import org.dsi.ifc.navigation.Route;
import org.dsi.ifc.navigation.RouteDestination;

public class ActiveDestinationsManager {
    private static final int STAY_IN_SCREEN = 0;
    private static final int START_RG = 1;
    private static final int SHOW_POPUP = 2;
    private BaseListModelApp activeDestinationsList;
    private ButtonModelApp deleteMainDestinationButton;
    private ButtonModelApp deleteAllDestinationsButton;
    private ChoiceModelApp removeActiveDestinationsChoice;
    private final NavigationEnv env;
    private final IStartGuidanceManager routeManager;
    private LogChannel logger;
    private static final String LOGCLASS = "ActiveDestinationsManager";
    private NavLocation mainDestination;
    private NavLocation stopOver;
    private static final int FLAG_ICON_MAIN_DESTINATION = 0;
    private static final int FLAG_ICON_STOPOVER = 1;
    private static final int LAYOUT_ONE_DESTINATION = 0;
    private static final int LAYOUT_TWO_DESTINATIONS = 1;
    private boolean blockListUpdates;
    private boolean rgActive;
    private static final int ACTIVE_DEST_MAIN = 0;
    private static final int ACTIVE_DEST_STOPOVER = 1;
    private static final int FINAL_DEST = 1;

    public ActiveDestinationsManager(NavigationEnv navigationEnv, IStartGuidanceManager iStartGuidanceManager) {
        this.logger = navigationEnv.getLogChannel("App.Navi.Search");
        this.env = navigationEnv;
        this.routeManager = iStartGuidanceManager;
        this.removeActiveDestinationsChoice = navigationEnv.getChoiceModel(401664);
        ActiveDestinationsListListener activeDestinationsListListener = new ActiveDestinationsListListener();
        this.activeDestinationsList = navigationEnv.getBaseListModel(400991);
        this.activeDestinationsList.setListener(activeDestinationsListListener);
        this.deleteMainDestinationButton = navigationEnv.getButtonModel(401248);
        this.deleteAllDestinationsButton = navigationEnv.getButtonModel(401247);
        ActiveDestinationsPopUpButtonListener activeDestinationsPopUpButtonListener = new ActiveDestinationsPopUpButtonListener();
        this.deleteMainDestinationButton.setButtonListener(activeDestinationsPopUpButtonListener);
        this.deleteAllDestinationsButton.setButtonListener(activeDestinationsPopUpButtonListener);
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
                this.logger.log(100000000, "%1#loadInitialScreen() rgActive: false", (Object)LOGCLASS);
            }
            this.clearActiveDestinations();
        }
    }

    public synchronized void updateRgActive(boolean bl) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "%1#updateRgActive()", (Object)LOGCLASS);
        }
        this.rgActive = bl;
        if (this.blockListUpdates) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "%2#updateRgActive() blockListUpdates: %1", this.blockListUpdates, (Object)LOGCLASS);
            }
            return;
        }
        if (!bl) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "%1#updateRgActive() false", (Object)LOGCLASS);
            }
            this.clearActiveDestinations();
            return;
        }
    }

    public synchronized void updateRouteInfo(Route route, TripHandler.TripData tripData) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "%1#updateRouteInfo()", (Object)LOGCLASS);
        }
        if (!this.rgActive) {
            this.logger.log(10000000, "%2#updateRouteInfo() rgActive: %1, do not update the list", this.rgActive, (Object)LOGCLASS);
            return;
        }
        if (this.blockListUpdates) {
            if (this.logger.isDebug2()) {
                this.logger.log(100000000, "%2#updateRouteInfo() blockListUpdates: %1", this.blockListUpdates, (Object)LOGCLASS);
            }
            return;
        }
        if (route == null) {
            this.logger.log(100000, "%1#updateRouteInfo() rgCurrentRoute is null", (Object)LOGCLASS);
            return;
        }
        RouteDestination[] routeDestinationArray = route.getRoutelist();
        int n = RouteUtil.getNumberOfRemainingDestinations(route, 1);
        if (routeDestinationArray == null || routeDestinationArray.length == 0 || n == 0) {
            this.activeDestinationsList.removeAll();
            return;
        }
        EvoListRow[] evoListRowArray = new ActiveDestRow[n];
        try {
            Object object;
            if (evoListRowArray.length == 1) {
                this.mainDestination = routeDestinationArray[(int)route.getIndexOfCurrentDestination()].getRouteLocation();
                object = new ActiveDestText(this.mainDestination, route.routeID, route.routename, true);
                this.addDestinationStringsToList((ActiveDestText)object, true, evoListRowArray, 0);
                this.stopOver = null;
            } else if (evoListRowArray.length > 1) {
                this.mainDestination = routeDestinationArray[1].getRouteLocation();
                this.addDestinationStringsToList(new ActiveDestText(this.mainDestination, route.routeID, route.routename, true), true, evoListRowArray, 0);
                if (route.getIndexOfCurrentDestination() == 0L) {
                    this.stopOver = routeDestinationArray[0].getRouteLocation();
                    object = new ActiveDestText(this.stopOver, route.routeID, route.routename, false);
                    this.addDestinationStringsToList((ActiveDestText)object, false, evoListRowArray, 1);
                }
            }
            this.updateTimeAndDistance(tripData, evoListRowArray);
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
            this.logger.log(10000, "%1#updateRouteInfo() %2", (Object)LOGCLASS, (Throwable)exception);
        }
    }

    private void updateTimeAndDistance(TripHandler.TripData tripData, EvoListRow[] evoListRowArray) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "%1#updateTimeAndDistance()", (Object)LOGCLASS);
        }
        long l = tripData.etaToNextDestination;
        int n = tripData.distanceToNextDestination;
        if (evoListRowArray.length == 0) {
            return;
        }
        if (evoListRowArray.length == 1) {
            ActiveDestRow activeDestRow = new ActiveDestRow((ActiveDestRow)evoListRowArray[0], this.getEtaAsDateMetric(l, tripData.etaValid), new Distance(n, 5));
            int n2 = 0;
            activeDestRow.setInteger(7, n2);
            evoListRowArray[0] = activeDestRow;
        } else if (evoListRowArray.length == 2) {
            long l2 = this.env.getFramework().getKombiTime() + 1000L * tripData.timeToFinalDestination;
            ActiveDestRow activeDestRow = (ActiveDestRow)evoListRowArray[0];
            activeDestRow.setMetrics(3, this.getEtaAsDateMetric(l2, this.getFinalDestReliability()));
            activeDestRow.setMetrics(4, new Distance(tripData.distanceToFinalDestination, 5));
            ActiveDestRow activeDestRow2 = (ActiveDestRow)evoListRowArray[1];
            activeDestRow2.setMetrics(3, this.getEtaAsDateMetric(l, tripData.etaValid));
            activeDestRow2.setMetrics(4, new Distance(n, 5));
            int n3 = 1;
            activeDestRow.setInteger(7, n3);
            activeDestRow2.setInteger(7, n3);
            evoListRowArray[0] = activeDestRow;
            evoListRowArray[1] = activeDestRow2;
        }
    }

    private boolean getFinalDestReliability() {
        NavRouteListData[] navRouteListDataArray = this.env.getContainer().getRgDestinationInfo();
        int n = 0;
        if (null == navRouteListDataArray || navRouteListDataArray.length <= 1) {
            this.logger.log(10000000, "%1#getFinalDestReliability() rgDestInfo == null", (Object)LOGCLASS);
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

    private void addDestinationStringsToList(ActiveDestText activeDestText, boolean bl, EvoListRow[] evoListRowArray, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "%1#addDestinationToList()", (Object)LOGCLASS);
        }
        int n2 = bl ? 0 : 1;
        ActiveDestRow activeDestRow = new ActiveDestRow(evoListRowArray.length + n, activeDestText.getMainTitle(), activeDestText.getSubTitle(), n2, null, null, 0);
        evoListRowArray[n] = activeDestRow;
    }

    private void clearActiveDestinations() {
        if (this.activeDestinationsList.getLength() == 1) {
            this.activeDestinationsList.remove(this.activeDestinationsList.getRow(0));
        } else if (this.activeDestinationsList.getLength() == 2) {
            this.activeDestinationsList.remove(new long[]{this.activeDestinationsList.getRow(0).getUniqueID(), this.activeDestinationsList.getRow(1).getUniqueID()});
        }
    }

    private class ActiveDestRow
    extends EvoListRow {
        public static final int ICON_ID_COLUMNS = 0;
        public static final int DESTINATION_COLUMN = 1;
        public static final int ADDITIONAL_INFO_COLUMN = 2;
        public static final int ETA_COLUMN = 3;
        public static final int DTD_COLUMN = 4;
        public static final int PROPERTY_COLUMN = 5;
        public static final int TEXT_INDEX_COLUMN = 6;
        public static final int LAYOUT_COLUMN = 7;
        public static final int MAX_LIST_COLUMNS = 8;

        public ActiveDestRow(long l, String string, String string2, int n, AbstractMetrics abstractMetrics, AbstractMetrics abstractMetrics2, int n2) {
            super(l, 8);
            this.setPropertyCell(5, new PropertyListCell(698976777, new int[0]));
            this.setText(1, string);
            this.setText(2, string2);
            this.setInteger(0, n);
            this.setInteger(6, 0 == n ? 0 : 1);
            this.setInteger(7, n2);
            this.setMetrics(3, abstractMetrics);
            this.setMetrics(4, abstractMetrics2);
        }

        protected ActiveDestRow(ActiveDestRow activeDestRow, DateMetric dateMetric, Distance distance) {
            super(activeDestRow.getUniqueID(), 8);
            this.setPropertyCell(5, new PropertyListCell(698976777, new int[0]));
            this.setText(1, activeDestRow.getText(1));
            this.setText(2, activeDestRow.getText(2));
            this.setInteger(0, activeDestRow.getInteger(0));
            this.setInteger(7, activeDestRow.getInteger(7));
            this.setMetrics(3, dateMetric);
            this.setMetrics(4, distance);
        }

        private ActiveDestRow(ActiveDestRow activeDestRow) {
            this(activeDestRow.getUniqueID(), activeDestRow.getText(1), activeDestRow.getText(2), activeDestRow.getInteger(0), activeDestRow.getMetrics(3), activeDestRow.getMetrics(4), activeDestRow.getInteger(7));
        }

        public EvoListRow copy() {
            return new ActiveDestRow(this);
        }
    }

    class ActiveDestText {
        private final LocationFormattingResponse formattedAddress;
        private final long routeID;
        private final String routeName;
        private final boolean isMainDest;

        ActiveDestText(NavLocation navLocation, long l, String string, boolean bl) {
            this.routeID = l;
            this.routeName = string;
            this.isMainDest = bl;
            this.formattedAddress = AddressFormatter.formatTwoLines(navLocation, ActiveDestinationsManager.this.env);
        }

        String getMainTitle() {
            if (1000L == this.routeID) {
                if (this.isMainDest) {
                    return this.routeName;
                }
                return ActiveDestinationsManager.this.env.getTranslatedText(21);
            }
            return this.formattedAddress.getFirstLineAsText();
        }

        String getSubTitle() {
            if (1000L == this.routeID) {
                return "";
            }
            return this.formattedAddress.getSecondLineAsText();
        }
    }

    private class ActiveDestinationsListListener
    extends DefaultBaseListModelListener {
        private ActiveDestinationsListListener() {
        }

        public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            ActiveDestinationsManager.this.logger.log(10000000, "%1#itemSelected row = %2, index = %3", (Object)ActiveDestinationsManager.LOGCLASS, (Object)evoListRow, (long)n2);
            if (ActiveDestinationsManager.this.activeDestinationsList.getLength() == 1) {
                ActiveDestinationsManager.this.routeManager.stopRouteGuidance();
                ActiveDestinationsManager.this.clearActiveDestinations();
                ActiveDestinationsManager.this.mainDestination = null;
                ActiveDestinationsManager.this.removeActiveDestinationsChoice.setValue(0);
            } else if (ActiveDestinationsManager.this.activeDestinationsList.getLength() == 2 && n2 == 1) {
                ActiveDestinationsManager.this.blockListUpdates = true;
                ActiveDestinationsManager.this.routeManager.startRouteGuidanceToSingleDestination(ActiveDestinationsManager.this.mainDestination);
                ActiveDestinationsManager.this.activeDestinationsList.remove(evoListRow.getUniqueID());
                ActiveDestinationsManager.this.stopOver = null;
                ActiveDestinationsManager.this.removeActiveDestinationsChoice.setValue(1);
            } else {
                ActiveDestinationsManager.this.removeActiveDestinationsChoice.setValue(2);
            }
            ActiveDestinationsManager.this.activeDestinationsList.fireEvent(n4);
        }
    }

    private class ActiveDestinationsPopUpButtonListener
    extends DefaultButtonListener {
        private ActiveDestinationsPopUpButtonListener() {
        }

        public void keyPressed(int n, int n2, int n3) {
            ActiveDestinationsManager.this.logger.log(10000000, "%1#keyPressed modelID = %2", (Object)ActiveDestinationsManager.LOGCLASS, (long)n);
            switch (n) {
                case 401248: {
                    ActiveDestinationsManager.this.blockListUpdates = true;
                    ActiveDestinationsManager.this.routeManager.startRouteGuidanceToSingleDestination(ActiveDestinationsManager.this.stopOver);
                    ActiveDestinationsManager.this.activeDestinationsList.remove(ActiveDestinationsManager.this.activeDestinationsList.getRow(0).getUniqueID());
                    ActiveDestinationsManager.this.mainDestination = ActiveDestinationsManager.this.stopOver;
                    ActiveDestinationsManager.this.stopOver = null;
                    ActiveDestinationsManager.this.removeActiveDestinationsChoice.setValue(1);
                    ActiveDestinationsManager.this.deleteMainDestinationButton.fireEvent(n3);
                    break;
                }
                case 401247: {
                    ActiveDestinationsManager.this.routeManager.stopRouteGuidance();
                    ActiveDestinationsManager.this.clearActiveDestinations();
                    ActiveDestinationsManager.this.mainDestination = null;
                    ActiveDestinationsManager.this.stopOver = null;
                    ActiveDestinationsManager.this.removeActiveDestinationsChoice.setValue(0);
                    ActiveDestinationsManager.this.deleteAllDestinationsButton.fireEvent(n3);
                    break;
                }
            }
        }
    }
}

