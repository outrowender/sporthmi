/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.OperationManager;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.hierarchiclist.via.ViaRouteUtil;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.routeguidance.IAlternativeRouteStateManager;
import de.audi.tghu.navi.app.routeguidance.IRouteGuidanceStateModelAccess;
import de.audi.tghu.navi.app.routeguidance.RouteManager;
import de.audi.tghu.navi.app.rp.TripHandler;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.search.IntelliDestAccess;
import de.audi.tghu.navi.app.setup.RouteCriteriaManager;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.navigation.RgInfoForNextDestination;
import org.dsi.ifc.navigation.Route;
import org.osgi.framework.BundleContext;

public class RouteManagerEvo
extends RouteManager {
    public static final int RG_TYPE_DEFAULT = 0;
    public static final int RG_TYPE_PREDEFINED = 1;
    private IntelliDestAccess intelliDestAccess;

    public RouteManagerEvo(NavigationEnv navigationEnv, int n, RouteCriteriaManager routeCriteriaManager, ICommandListFactory iCommandListFactory, IAlternativeRouteStateManager iAlternativeRouteStateManager, IRouteGuidanceStateModelAccess iRouteGuidanceStateModelAccess, OperationManager operationManager, ISDSController iSDSController, MapInterface mapInterface, ClusterService clusterService) {
        super(navigationEnv, n, routeCriteriaManager, iCommandListFactory, iAlternativeRouteStateManager, iRouteGuidanceStateModelAccess, operationManager, iSDSController, mapInterface, clusterService);
    }

    protected TripHandler createTripHandler(NavigationEnv navigationEnv, MapInterface mapInterface, ClusterService clusterService) {
        return new TripHandler(navigationEnv, this, mapInterface, clusterService);
    }

    public void updateRgInfoForNextDestination(RgInfoForNextDestination rgInfoForNextDestination) {
        super.updateRgInfoForNextDestination(rgInfoForNextDestination);
        this.intelliDestAccess.updateRouteInfo(ViaRouteUtil.filterViaFromRoute(this.route), this.tripHandler.getTripDataAuto());
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.intelliDestAccess.updateRgActive(bl);
    }

    public void setSearchController(IntelliDestAccess intelliDestAccess) {
        this.intelliDestAccess = intelliDestAccess;
    }

    public void rgNotPossible(int n) {
        super.rgNotPossible(n);
        if (n == 4) {
            this.env.getHMIService().showPartialPopup(0, 400346);
            return;
        }
        if (this.alternativeRouteState.getAlternativeRouteState() == 0) {
            if (this.env.getLogChannel().isDebug2()) {
                this.env.getLogChannel().log(100000000, "RouteManagerEvo#rgNotPossible show PartialPopup for CALC_FAIL_SINGLE");
            }
            this.env.getChoiceModel(401582).setValue(1);
        } else {
            if (this.env.getLogChannel().isDebug2()) {
                this.env.getLogChannel().log(100000000, "RouteManagerEvo#rgNotPossible show PartialPopup for CALC_FAIL_MULTI");
            }
            this.env.getChoiceModel(401582).setValue(2);
        }
    }

    public CommandList getStartGuidanceBySegmendIDSequence(NavSegmentID navSegmentID, boolean bl) {
        CommandList commandList = super.getStartGuidanceBySegmendIDSequence(navSegmentID, bl);
        commandList.add(new NavCommand("RouteManagerEvo#getStartGuidanceBySegmendIDSequence set correct routetype"){

            public void execute() {
                this.env.getChoiceModel(402440).setValue(1);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public CommandList getStartGuidanceByRouteSequence(Route route) {
        CommandList commandList = super.getStartGuidanceByRouteSequence(route);
        commandList.add(new NavCommand("RouteManagerEvo#getStartGuidanceBySegmendIDSequence set correct routetype"){

            public void execute() {
                this.env.getChoiceModel(402440).setValue(1);
                this.getCommandList().commandFinished();
            }
        });
        return commandList;
    }

    public void tripDataRefreshed() {
        if (this.intelliDestAccess != null) {
            this.intelliDestAccess.updateRouteInfo(ViaRouteUtil.filterViaFromRoute(this.route), this.tripHandler.getTripDataAuto());
        }
    }

    public void stop(BundleContext bundleContext) throws Exception {
        super.stop(bundleContext);
        this.intelliDestAccess = null;
    }
}

