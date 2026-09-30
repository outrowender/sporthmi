/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.LongListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.details.GuiModelAccessDetailsNavi;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.memory.RouteListData;
import de.audi.tghu.navi.app.memory.TourPlanEvoListRow;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.util.FunctionCounter;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavRmRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.Route;

public class TourHandlerModelAccess {
    private static final int SHOW_REMAINING_DISTANCE = 1;
    private static final int HIDE_REMAINING_DISTANCE = 0;
    private static final int REMAINING_DISTANCE_THRESHOLD = 50000;
    private static final int STORE_LIMIT = 20;
    private static final int STORE_NOT_POSSIBLE = 0;
    private static final int STORE_POSSIBLE = 1;
    protected final NavigationEnv env;
    protected final FunctionCounter fc;
    private LogChannel logChannel;
    private NavTraceListData[] trTraceList;
    private NavRmRouteListData[] rmWaypointList;
    private NavRmRouteListData[] rmRouteList;
    private IRouteManager routeManager;
    private GuiModelAccessDetailsNavi detailsAccess;
    private NavNextWayPointInfo nextWaypointInfo;
    private PosPosition soPosPosition;
    private boolean rgActive;
    private MapInterface mapInterface;

    public TourHandlerModelAccess(NavigationEnv navigationEnv, FunctionCounter functionCounter, IRouteManager iRouteManager, GuiModelAccessDetailsNavi guiModelAccessDetailsNavi, MapInterface mapInterface) {
        this.env = navigationEnv;
        this.fc = functionCounter;
        this.routeManager = iRouteManager;
        this.detailsAccess = guiModelAccessDetailsNavi;
        this.logChannel = navigationEnv.getLogChannel();
        this.mapInterface = mapInterface;
        navigationEnv.getChoiceModel(401906).setValue(0);
    }

    public void updateRmRoutesTourplan(NavRmRouteListData[] navRmRouteListDataArray) {
        Object object;
        int n;
        this.rmRouteList = navRmRouteListDataArray;
        this.updateBaseList();
        this.env.getChoiceModel(400554).setValue(0);
        int n2 = -1;
        for (n = 0; n < navRmRouteListDataArray.length; ++n) {
            if (!navRmRouteListDataArray[n].getName().equals("@_TOUR_BACKUP_@")) continue;
            this.logChannel.log(10000000, "TourHandler#updateRmRoutesTourplan() - <tour plan backup found>");
            this.env.getChoiceModel(400554).setValue(1);
            n2 = n;
            break;
        }
        n = navRmRouteListDataArray.length - (n2 >= 0 ? 1 : 0);
        n = n > 50 ? 50 : n;
        this.env.getChoiceModel(401906).setValue(n >= 20 ? 0 : 1);
        this.env.getChoiceModel(400548).setValue(n);
        this.env.getChoiceModel(400568).setValue(n > 0 ? 1 : 0);
        this.logChannel.log(10000000, "TourHandler#updateRmRoutesTourplan() - (# %1)", (long)n);
        ListModelApp listModelApp = this.env.getListModel(400552);
        ListModelApp listModelApp2 = this.env.getListModel(400549);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < n + (n2 >= 0 && n2 < n ? 1 : 0); ++i2) {
            object = navRmRouteListDataArray[i2].getName();
            long l = navRmRouteListDataArray[i2].getRouteId();
            if (((String)object).equals("@_TOUR_BACKUP_@")) {
                this.logChannel.log(10000000, "TourHandler#updateRmRoutesTourplan() - #%1: <found tour plan backup>", (long)i2);
                continue;
            }
            this.logChannel.log(10000000, "TourHandler#updateRmRoutesTourplan() - #%3: %1 (id: %2)", object, l, (long)i2);
            arrayList.add(new RouteListData((String)object, l, 1));
        }
        Collections.sort(arrayList);
        Util.beginTransaction(listModelApp);
        Util.beginTransaction(listModelApp2);
        listModelApp.clear();
        listModelApp2.clear();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            object = (RouteListData)iterator.next();
            listModelApp.addRow(new ListCell[]{new TextListCell(((RouteListData)object).name), new LongListCell(((RouteListData)object).id)});
            listModelApp2.addRow(new ListCell[]{new TextListCell(((RouteListData)object).name), new LongListCell(((RouteListData)object).id)});
        }
        Util.endTransaction(listModelApp);
        Util.endTransaction(listModelApp2);
    }

    public void updateRmRoutesWaypoint(NavRmRouteListData[] navRmRouteListDataArray) {
        this.rmWaypointList = navRmRouteListDataArray;
    }

    public void updateRmRoutesPress(NavRmRouteListData[] navRmRouteListDataArray) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.routes(navRmRouteListDataArray, 2));
        Collections.sort(arrayList);
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(401985);
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            RouteListData routeListData = (RouteListData)iterator.next();
            baseListModelApp2.append(new TourPlanEvoListRow(routeListData));
        }
        baseListModelApp.update(baseListModelApp2);
    }

    private void updateBaseList() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.routes(this.rmWaypointList, 0));
        arrayList.addAll(this.routes(this.rmRouteList, 1));
        arrayList.addAll(this.trails(this.trTraceList));
        Collections.sort(arrayList);
        BaseListModelApp baseListModelApp = this.env.getBaseListModel(401905);
        BaseListModelApp baseListModelApp2 = baseListModelApp.getEmptyCopy();
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            RouteListData routeListData = (RouteListData)iterator.next();
            baseListModelApp2.append(new TourPlanEvoListRow(routeListData));
        }
        baseListModelApp.update(baseListModelApp2);
    }

    private ArrayList routes(NavRmRouteListData[] navRmRouteListDataArray, int n) {
        if (navRmRouteListDataArray != null) {
            int n2 = navRmRouteListDataArray.length;
            n2 = n2 > 50 ? 50 : n2;
            ArrayList arrayList = new ArrayList(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                String string = navRmRouteListDataArray[i2].getName();
                long l = navRmRouteListDataArray[i2].getRouteId();
                this.logChannel.log(10000000, "TourHandler#updateRmRoutesTourplan() - #%3: %1 (id: %2)", (Object)string, l, (long)i2);
                arrayList.add(new RouteListData(string, l, n));
            }
            return arrayList;
        }
        return new ArrayList(0);
    }

    private ArrayList trails(NavTraceListData[] navTraceListDataArray) {
        if (navTraceListDataArray != null) {
            int n = navTraceListDataArray.length;
            n = n > 50 ? 50 : n;
            ArrayList arrayList = new ArrayList(n);
            this.logChannel.log(10000000, "TourHandler#updateTrails() - (# %1)", (long)n);
            for (int i2 = 0; i2 < n; ++i2) {
                String string = navTraceListDataArray[i2].getName();
                NavSegmentID navSegmentID = navTraceListDataArray[i2].getTraceID();
                this.logChannel.log(10000000, "TourHandler#updateTrails() - #%3: %1 (id: %2)", (Object)string, (Object)navSegmentID, (long)i2);
                arrayList.add(new RouteListData(string, navSegmentID));
            }
            return arrayList;
        }
        return new ArrayList(0);
    }

    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray) {
        this.trTraceList = navTraceListDataArray;
        this.updateBaseList();
    }

    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization) {
        short s = navTraceMemoryUtilization.getUtilization();
        long l = navTraceMemoryUtilization.getNumberOfTrackpoints();
        long l2 = navTraceMemoryUtilization.getTotalNumberOfTrackPoints();
        long l3 = navTraceMemoryUtilization.getMaximumNumberOfTrackPoints();
        int n = navTraceMemoryUtilization.getRecordingDistance();
        int n2 = navTraceMemoryUtilization.getRemainingDistance();
        this.logChannel.log(10000000, "TourHandler#updateTrMemoryUtilization( totalNumberOfTrackPoints: %1, maximumNumberOfTrackPoints:%2, numberOfTrackpoints:%3 )", l2, l3, l);
        Route route = this.routeManager.getRoute();
        if (route != null && route.getRouteID() != 0L) {
            this.env.getChoiceModel(401922).setValue(s == 255 ? 1 : 0);
            this.env.getChoiceModel(401921).setValue(l < l3 ? 1 : 0);
            MetricsModelApp metricsModelApp = this.env.getMetricsModel(402298);
            metricsModelApp.setMetric(new Distance(n, 5));
            MetricsModelApp metricsModelApp2 = this.env.getMetricsModel(402299);
            if (n2 > 50000) {
                metricsModelApp2.setStatus(0);
            } else {
                metricsModelApp2.setStatus(1);
            }
            metricsModelApp2.setMetric(new Distance(n2, 5));
        }
    }

    public void updateTrOperatingMode(int n) {
    }

    public void updateTrRecordingState(int n) {
        this.env.getChoiceModel(401923).setValue(n == 2 ? 1 : 0);
        this.env.getChoiceModel(401921).setValue(1);
    }

    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint) {
    }

    public void showTour(Route route) {
        if (this.detailsAccess != null) {
            int n = route.getRoutelist().length;
            NavLocation[] navLocationArray = new NavLocation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navLocationArray[i2] = route.getRoutelist()[i2].getRouteLocation();
            }
            try {
                this.mapInterface.getPreviewMap().setPreviewTour(navLocationArray, route.routename, 12, this.detailsAccess, null);
            }
            catch (Exception exception) {
                this.logChannel.log(10000, "GuiModelAccessDetailsNaviFavoritePCore#onUpdateLocation() - ERROR=%1", (Throwable)exception);
                exception.printStackTrace();
            }
        }
    }

    public void showTourName(String string) {
        if (this.detailsAccess != null) {
            NavLocation navLocation = new NavLocation();
            Util.setFavoriteNameOnLocation(navLocation, string);
            this.detailsAccess.onUpdateLocation(navLocation);
        }
    }

    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo) {
        this.nextWaypointInfo = navNextWayPointInfo;
        this.updateAngles();
    }

    public void refreshPosPosition(PosPosition posPosition) {
        this.soPosPosition = posPosition;
        this.updateAngles();
    }

    private void updateAngles() {
        boolean bl;
        Route route = this.routeManager.getRoute();
        boolean bl2 = bl = this.soPosPosition != null && this.nextWaypointInfo != null && this.rgActive && route != null && route.getRouteID() == 2L;
        if (!bl) {
            this.env.getChoiceModel(401957).setValue(0);
            this.env.getChoiceModel(401958).setValue(0);
            this.env.getMetricsModel(402583).setMetric(new Distance(0.0f, 5));
        } else {
            int n = this.soPosPosition.getDirectionAngle();
            int n2 = Util.computeAbsoluteDirection(this.soPosPosition, this.nextWaypointInfo.longitude, this.nextWaypointInfo.latitude);
            int n3 = (360 - n + n2) % 360;
            this.env.getChoiceModel(401957).setValue(n2);
            this.env.getChoiceModel(401958).setValue(n3);
            int n4 = Util.computeAirDistance(this.soPosPosition.longitude, this.soPosPosition.latitude, this.nextWaypointInfo.longitude, this.nextWaypointInfo.latitude);
            this.env.getMetricsModel(402583).setMetric(new Distance(n4, 5));
        }
    }

    public void updateRgActive(boolean bl) {
        this.rgActive = bl;
        this.updateAngles();
    }
}

