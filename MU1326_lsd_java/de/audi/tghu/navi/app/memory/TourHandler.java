/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.memory;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import de.audi.atip.power.PowerEventListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.RGStopGuidanceCommand;
import de.audi.tghu.navi.app.command.TrDeleteAllTraces;
import de.audi.tghu.navi.app.command.TrExportTrails;
import de.audi.tghu.navi.app.command.TrImportTrails;
import de.audi.tghu.navi.app.command.TrStopTraceRecording;
import de.audi.tghu.navi.app.command.TrStoreTrace;
import de.audi.tghu.navi.app.command.storage.RmRouteAddCommand;
import de.audi.tghu.navi.app.command.storage.RmRouteDeleteAllCommand;
import de.audi.tghu.navi.app.command.storage.RmRouteDeleteCommand;
import de.audi.tghu.navi.app.command.storage.RmRouteGet;
import de.audi.tghu.navi.app.command.translate.TranslateTourCommand;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.memory.TourHandlerModelAccess;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import de.audi.tghu.navi.app.routeguidance.commands.RgCalculateRouteCommand;
import de.audi.tghu.navi.app.setup.RouteCriteriaManager;
import de.audi.tghu.navi.app.util.FunctionCounter;
import de.audi.tghu.navi.app.util.IMyLocationAccessorFactory;
import de.audi.tghu.navi.app.util.NaviLocationAccessor;
import de.audi.tghu.navi.app.util.RouteUtil;
import java.util.Date;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.DirectionToWaypoint;
import org.dsi.ifc.navigation.NavNextWayPointInfo;
import org.dsi.ifc.navigation.NavRmRouteListArrayData;
import org.dsi.ifc.navigation.NavRmRouteListData;
import org.dsi.ifc.navigation.NavTraceListData;
import org.dsi.ifc.navigation.NavTraceMemoryUtilization;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.Route;

public class TourHandler
implements PowerEventListener {
    private static final int TRACING_ACTIVE = 1;
    public static final String TOUR_INDEX = "TOUR_INDEX";
    public static final String TOUR_BACKUP_TITLE = "@_TOUR_BACKUP_@";
    protected final NavigationEnv env;
    protected final FunctionCounter fc;
    private LogChannel logChannel;
    private volatile int loadedMemoryID;
    private volatile long loadedTourID;
    private Route loadedTour;
    private volatile long tourBackupID;
    private volatile NavSegmentID navSegmentId;
    private final ICommandListFactory commandListFactory;
    private TourHandlerModelAccess modelAccess;
    private RouteCriteriaManager routeCriteriaManager;
    private MapInterface mapInterface;
    private NaviLocationAccessor naviLocationAccessor;
    private IRouteManager routeManager;
    protected volatile String lastTourName = "";

    public TourHandler(NavigationEnv navigationEnv, FunctionCounter functionCounter, ICommandListFactory iCommandListFactory, RouteCriteriaManager routeCriteriaManager, MapInterface mapInterface, TourHandlerModelAccess tourHandlerModelAccess, NaviLocationAccessor naviLocationAccessor, IRouteManager iRouteManager) {
        this.env = navigationEnv;
        this.fc = functionCounter;
        this.commandListFactory = iCommandListFactory;
        this.routeCriteriaManager = routeCriteriaManager;
        this.mapInterface = mapInterface;
        this.modelAccess = tourHandlerModelAccess;
        this.naviLocationAccessor = naviLocationAccessor;
        this.routeManager = iRouteManager;
        this.logChannel = navigationEnv.getLogChannel();
        this.invalidateLoadedTour();
    }

    public void updateRmRouteList(NavRmRouteListArrayData[] navRmRouteListArrayDataArray) {
        this.invalidateLoadedTour();
        NavRmRouteListData[] navRmRouteListDataArray = new NavRmRouteListData[]{};
        NavRmRouteListData[] navRmRouteListDataArray2 = new NavRmRouteListData[]{};
        NavRmRouteListData[] navRmRouteListDataArray3 = new NavRmRouteListData[]{};
        block0: for (int i2 = 0; i2 < navRmRouteListArrayDataArray.length; ++i2) {
            if (navRmRouteListArrayDataArray[i2].getRmId() == 0) {
                navRmRouteListDataArray = navRmRouteListArrayDataArray[i2].getRouteList();
                this.tourBackupID = -1L;
                for (int i3 = 0; i3 < navRmRouteListDataArray.length; ++i3) {
                    if (!navRmRouteListDataArray[i3].getName().equals(TOUR_BACKUP_TITLE)) continue;
                    this.logChannel.log(10000000, "TourHandler#updateRmRoutesTourplan() - <tour plan backup found>");
                    this.env.getChoiceModel(400554).setValue(1);
                    this.tourBackupID = navRmRouteListDataArray[i3].getRouteId();
                    continue block0;
                }
                continue;
            }
            if (navRmRouteListArrayDataArray[i2].getRmId() == 1) {
                navRmRouteListDataArray2 = navRmRouteListArrayDataArray[i2].getRouteList();
                continue;
            }
            if (navRmRouteListArrayDataArray[i2].getRmId() == 2) {
                navRmRouteListDataArray3 = navRmRouteListArrayDataArray[i2].getRouteList();
                continue;
            }
            this.logChannel.log(100000, "TourHandler#updateRmRouteList() unknow route type");
        }
        this.env.getContainer().setRmRoutesWaypoint(navRmRouteListDataArray);
        this.env.getContainer().setRmRoutesTourplan(navRmRouteListDataArray2);
        this.env.getContainer().setRmRoutesPress(navRmRouteListDataArray3);
        if (this.modelAccess != null) {
            this.modelAccess.updateRmRoutesWaypoint(navRmRouteListDataArray);
            this.modelAccess.updateRmRoutesTourplan(navRmRouteListDataArray2);
            this.modelAccess.updateRmRoutesPress(navRmRouteListDataArray3);
        }
    }

    public void updateTrTraceList(NavTraceListData[] navTraceListDataArray) {
        if (this.modelAccess != null) {
            this.modelAccess.updateTrTraceList(navTraceListDataArray);
        }
    }

    public void updateTrMemoryUtilization(NavTraceMemoryUtilization navTraceMemoryUtilization) {
        if (this.modelAccess != null) {
            this.modelAccess.updateTrMemoryUtilization(navTraceMemoryUtilization);
        }
    }

    public void updateTrOperatingMode(int n) {
        if (this.modelAccess != null) {
            this.modelAccess.updateTrOperatingMode(n);
        }
    }

    public void updateTrRecordingState(int n) {
        if (this.modelAccess != null) {
            this.modelAccess.updateTrRecordingState(n);
        }
    }

    public void updateTrDirectionToWaypoint(DirectionToWaypoint directionToWaypoint) {
        if (this.modelAccess != null) {
            this.modelAccess.updateTrDirectionToWaypoint(directionToWaypoint);
        }
    }

    public void deleteAllTours() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RmRouteDeleteAllCommand(1));
        commandList.add(new TrDeleteAllTraces());
        commandList.execute("TourHandler#deleteAllTours");
    }

    public void deleteAllPressTours() {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new RmRouteDeleteAllCommand(2));
        commandList.execute("TourHandler#deleteAllTours");
    }

    public void importTrails(String string) {
        CommandList commandList = this.commandListFactory.createCommandList();
        commandList.add(new TrImportTrails(string));
        commandList.execute("TourHandler#importTrails");
    }

    public void exportTrails(String string) {
        NavTraceListData[] navTraceListDataArray = this.env.getContainer().getTrTraceList();
        if (navTraceListDataArray != null) {
            int n = navTraceListDataArray.length;
            NavSegmentID[] navSegmentIDArray = new NavSegmentID[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navSegmentIDArray[i2] = navTraceListDataArray[i2].getTraceID();
            }
            CommandList commandList = this.commandListFactory.createCommandList();
            commandList.add(new TrExportTrails(navSegmentIDArray, string));
            commandList.execute("TourHandler#importTrails");
        }
    }

    public CommandList saveTourPlanBackup(Route route) {
        Route route2 = RouteUtil.cloneRoute(route, this.routeCriteriaManager.getRouteCriteria().getRouteOptions(false));
        route2.routename = TOUR_BACKUP_TITLE;
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.getTourBackupID() >= 0L) {
            commandList.add(new RmRouteDeleteCommand(1, this.getTourBackupID()));
        }
        if (RouteUtil.getRouteLength(route2) > 0) {
            commandList.add(new RmRouteAddCommand(1, route2, route2.routename));
        }
        return commandList;
    }

    private void invalidateLoadedTour() {
        this.logChannel.log(10000000, "TourHandler#invalidateLoadedTour()");
        this.setLoadedMemoryID(-1);
        this.setLoadedTourID(-1L);
        this.loadedTour = null;
    }

    public CommandList loadTour(final int n, final int n2, final long l) {
        CommandList commandList = this.commandListFactory.createCommandList(0);
        commandList.put(TOUR_INDEX, new Integer(n2));
        if (this.getLoadedMemoryID() != n || this.getLoadedTourID() != l || this.loadedTour == null) {
            commandList.add(new RmRouteGet(n, l));
            commandList.add(new TranslateTourCommand());
        } else {
            commandList.add(new NavCommand(){

                public void execute() {
                    TourHandler.this.showTour(n2, n, l, TourHandler.this.loadedTour);
                    this.getCommandList().commandFinished();
                }
            });
        }
        return commandList;
    }

    public void showTour(int n, int n2, long l, Route route) {
        this.logChannel.log(10000000, "TourHandler#showTour( %2, %1 )", (Object)RouteUtil.formatRouteShort(route), l);
        this.setLoadedMemoryID(n2);
        this.setLoadedTourID(l);
        this.loadedTour = route;
        this.setNavSegmentId(null);
        try {
            this.modelAccess.showTour(route);
        }
        catch (Exception exception) {
            this.logChannel.log(10000, "TourHandler#showTour() - ERROR=%1", (Throwable)exception);
            exception.printStackTrace();
        }
    }

    public void showTour(NavSegmentID navSegmentID, String string, int n) {
        this.setNavSegmentId(navSegmentID);
        this.modelAccess.showTourName(string);
        this.previewTour(n, string);
    }

    public void previewTourLast(int n) {
        this.previewTour(n, this.lastTourName);
    }

    public void previewTour(int n, final String string) {
        this.lastTourName = string;
        NavLocation navLocation = this.getLocationFromNavSegmentId();
        Route route = this.routeManager.getOffroadRouteFromNavLocation(navLocation, n);
        CommandList commandList = this.commandListFactory.createCommandList();
        if (this.env.getChoiceModel(401923).getValue() == 1) {
            commandList.add(new TrStopTraceRecording());
            commandList.add(new TrStoreTrace(null));
        }
        commandList.add(new RGStopGuidanceCommand());
        commandList.add(new RgCalculateRouteCommand(route, 1));
        commandList.add(new NavCommand("previewTour"){

            public void execute() {
                GuiTooltipInformationContainer guiTooltipInformationContainer = new GuiTooltipInformationContainer();
                guiTooltipInformationContainer.toolTipTwoLinesLine1st = string;
                guiTooltipInformationContainer.toolTipTwoLinesLine2nd = "";
                guiTooltipInformationContainer.toolTipOneLineLine1st = string;
                TourHandler.this.mapInterface.getPreviewMap().setPreviewRouteOffroad(TourHandler.this.navSegmentId, 12, null, guiTooltipInformationContainer);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("TourHandler#previewTour");
    }

    public Route getLoadedTour() {
        return this.loadedTour;
    }

    public Route getEmptyRoute(int n) {
        Route route = new Route();
        route.setRouteID(n);
        route.setRoutename("EmptyRoute");
        return route;
    }

    public NavSegmentID getNavSegmentId() {
        return this.navSegmentId;
    }

    public void setNavSegmentId(NavSegmentID navSegmentID) {
        this.navSegmentId = navSegmentID;
    }

    public int getLoadedMemoryID() {
        return this.loadedMemoryID;
    }

    public void setLoadedMemoryID(int n) {
        this.loadedMemoryID = n;
    }

    public long getLoadedTourID() {
        return this.loadedTourID;
    }

    public void setLoadedTourID(long l) {
        this.loadedTourID = l;
    }

    public long getTourBackupID() {
        return this.tourBackupID;
    }

    public void setTourBackupID(long l) {
        this.tourBackupID = l;
    }

    public void updateTrInfoForNextWaypoint(NavNextWayPointInfo navNextWayPointInfo) {
        if (this.modelAccess != null) {
            this.modelAccess.updateTrInfoForNextWaypoint(navNextWayPointInfo);
        }
    }

    public void refreshPosPosition(PosPosition posPosition) {
        if (this.modelAccess != null) {
            this.modelAccess.refreshPosPosition(posPosition);
        }
    }

    public NavLocation getLocationFromNavSegmentId() {
        IMyLocationAccessorFactory iMyLocationAccessorFactory = this.naviLocationAccessor.getLocationAccessorFactory();
        return iMyLocationAccessorFactory.toLocation(iMyLocationAccessorFactory.fromTraceId(this.getNavSegmentId()));
    }

    public void updateRgActive(boolean bl) {
        if (this.modelAccess != null) {
            this.modelAccess.updateRgActive(bl);
        }
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
        if (n == 2 && this.env.getChoiceModel(401923).getValue() == 1) {
            this.env.getLogChannel().log(10000000, "TourHandler#setPowerEvent(POWERSTATE_STANDBY) - store active offroad trace!");
            StringBuffer stringBuffer = new StringBuffer();
            DateMetric dateMetric = new DateMetric(new Date(this.env.getFramework().getKombiTime()), 0);
            stringBuffer.append("Tour");
            stringBuffer.append(" ");
            stringBuffer.append(dateMetric.getFormattedValue());
            CommandList commandList = null;
            commandList = this.commandListFactory.createCommandList();
            commandList.add(new TrStopTraceRecording());
            commandList.add(new TrStoreTrace(stringBuffer.toString()));
            commandList.execute("TourHandler#Save OffroadRoute on stop Navigation!");
        }
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }
}

