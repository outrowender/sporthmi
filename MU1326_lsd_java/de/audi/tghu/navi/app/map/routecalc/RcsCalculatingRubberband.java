/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.atip.timer.Timer;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.via.RgSetRubberbandPosition;
import de.audi.tghu.navi.app.command.via.RgStopRubberBandCommand;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingBase;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$1;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$2;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$3;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$4;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$5;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$6;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$7;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$8;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingRubberband$9;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import de.audi.tghu.navi.app.map.utils.ConstantUtils;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.routeguidance.commands.RgStopRouteCalculation;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

class RcsCalculatingRubberband
extends RcsCalculatingBase {
    public static final int UPDATERGCALCULATEDROUTES_TIMEOUT;
    protected CalculatedRouteListElement manipulatedRoute = null;
    private NavLocationWgs84 rbPointPosition = null;
    private Object requestRbbPointPositioMutex = new Object();
    private final Timer updateRgCalculatedRoutesTimeoutTimer = new Timer("RcsCalculatingRubberband#updateRgCalculatedRoutesTimeoutTimer", 0, true, new RcsCalculatingRubberband$1(this));
    protected boolean prepareCompleteTour;
    protected int prepareDestinationIndex;

    RcsCalculatingRubberband(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsCalculatingRubberband");
    }

    @Override
    public void enter() {
        this.getLogger().log(-2137614336, "RcsCalculatingRubberband#enter() - rbbState:%1", (long)this.getRbbState());
        this.getStateMachine().setRubberbandActive(true);
        this.setRbbState(0);
        if (this.getStateMachine().getLastState() == 2 || this.getStateMachine().getLastState() == 10) {
            this.getStateMachine().naviMap.getMapDataContainer().enterRbbFromRightDrawer = this.getStateMachine().naviMap.getMapDataContainer().enterAltRoutesFromRightDrawer;
            this.getStateMachine().naviMap.getMapDataContainer().enterAltRoutesFromRightDrawer = false;
        }
        this.getStateMachine().cancelAbortCalculationTimer();
    }

    @Override
    public void exit() {
        super.exit();
        this.getLogger().log(-2137614336, "RcsCalculatingRubberband#exit() - rbbState = %1", (long)this.getRbbState());
        this.setRbbState(0);
        this.getStateMachine().naviMap.getMapDataContainer().rubberbandViewPort = null;
    }

    @Override
    public void prepareRubberband(boolean bl, int n) {
        if (this.getRbbState() != 0) {
            this.getLogger().log(-2137614336, "RcsCalculatingRubberband#prepareRubberband() - ignored, rbbState=%1", (long)this.getRbbState());
            return;
        }
        this.getLogger().log(1078071040, "RcsCalculatingRubberband#prepareRubberband() - completeTour:%1, destIndex:%2", bl, (long)n);
        this.prepareCompleteTour = bl;
        this.prepareDestinationIndex = n;
        this.setRbbState(1);
        CommandList commandList = this.getNaviInterface().createCommandList();
        if (!this.data.isRGActive) {
            commandList.add(new RgStopRouteCalculation());
        }
        commandList.add(new RcsCalculatingRubberband$2(this, true));
        commandList.execute("RcsCalculatingRubberband#prepareRubberband()");
    }

    protected void checkPrepareRubberbandFinished() {
        if (this.getRbbState() == 1 && !this.data.isRGActive && this.data.iRgRouteCalculationState == 2) {
            this.finishPrepareRubberbandAndStart();
        }
    }

    protected void finishPrepareRubberbandAndStart() {
        this.getLogger().log(1078071040, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart() - completeTour: %1, destIndex: %2 ", this.prepareCompleteTour, (long)this.prepareDestinationIndex);
        CommandList commandList = this.getNaviInterface().createCommandList();
        commandList.add(new RcsCalculatingRubberband$3(this, this.prepareCompleteTour, this.prepareDestinationIndex));
        commandList.add(new RcsCalculatingRubberband$4(this, "NotifyRubberbandPrepared"));
        if (Util.isHURegionAsia()) {
            this.refreshRubberbandPoint();
        }
        commandList.add(new RcsCalculatingRubberband$5(this, this.prepareDestinationIndex));
        commandList.add(new RcsCalculatingRubberband$6(this, 0L));
        commandList.execute("RcsCalculatingRubberband#finishPrepareRubberbandAndStart()");
    }

    protected void checkStartRubberbandFinished() {
        if (this.getRbbState() == 3 && this.data.rgStartRubberbandManipulationResultOK && this.data.iRgRouteCalculationState == 3) {
            this.finishStartRubberbandAndInitRubberbandPoint();
        }
    }

    protected void finishStartRubberbandAndInitRubberbandPoint() {
        this.getLogger().log(1078071040, "RcsCalculatingRubberband#finishStartRubberbandAndInitRubberbandPoint() ");
        CommandList commandList = this.getNaviInterface().createCommandList();
        commandList.add(new RcsCalculatingRubberband$7(this, "NotifyRubberbandReady"));
        commandList.execute("RcsCalculatingRubberband#finishStartRubberbandAndInitRubberbandPoint()");
    }

    @Override
    public void cancel() {
        this.getLogger().log(1078071040, "RcsCalculatingRubberband#cancelRubberband()");
        this.setRbbState(8);
        CommandList commandList = this.getNaviInterface().createCommandList();
        commandList.add(new RgStopRubberBandCommand(false));
        commandList.add(new RcsCalculatingRubberband$8(this, "NotifyRubberbandCanceled"));
        commandList.execute("RcsCalculatingRubberband#cancelRubberband()");
        if (this.getStateMachine().isBaseRouteReconstructable()) {
            if (Util.isHURegionAsia()) {
                this.goTo(0);
                this.getStateMachine().setIsRGAboutToBeStarted(true, true);
                this.getStateMachine().startRouteCalculation(this.getNaviInterface().getRouteManager().getRoute(), 1, true, false, false);
            } else {
                this.goTo(6);
            }
        } else {
            this.goTo(0);
            this.getStateMachine().fireEvent(211);
        }
    }

    @Override
    protected void onFirstMatchFound() {
        this.getLogger().log(-2137614336, "RcsCalculatingRubberband#onFirstMatchFound( )");
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        super.updateRgCalculatedRoutes(calculatedRouteListElementArray);
        if (calculatedRouteListElementArray != null && calculatedRouteListElementArray.length > 0) {
            int n = this.getStateMachine().getRgRouteCalculationState();
            this.getLogger().log(-2137614336, "RcsCalculatingRubberband#updateRgCalculatedRoutes() - rgCalculatedRoutes[0]: %1, routeCalcState: %2", (Object)calculatedRouteListElementArray[0], (long)n);
            this.manipulatedRoute = calculatedRouteListElementArray[0];
            if (n == 3) {
                this.refreshRubberbandPoint();
            }
        } else {
            this.getLogger().log(-2137614336, "RcsCalculatingRubberband#updateRgCalculatedRoutes() - empty");
        }
    }

    @Override
    public void updateRgRouteCalculationState(int n) {
        this.getLogger().log(-2137614336, "RcsCalculatingRubberband#updateRgRouteCalculationState( %1 )", (Object)ConstantUtils.ROUTECALCULATIONSTATE[n]);
        super.updateRgRouteCalculationState(n);
        this.checkPrepareRubberbandFinished();
        this.checkStartRubberbandFinished();
    }

    @Override
    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        if (bl) {
            if (this.getRbbState() == 7 || this.getRbbState() == 8) {
                this.getLogger().log(1078071040, "RcsCalculatingRubberband#updateRgActive( true ) - Rubberband finished");
            } else {
                this.getLogger().log(-1601830656, "RcsCalculatingRubberband#updateRgActive( true ) - unexpected, because rbbState = %1", (long)this.getRbbState());
            }
            this.goTo(7);
        } else {
            this.getLogger().log(-2137614336, "RcsCalculatingRubberband#updateRgActive( false )");
            this.checkPrepareRubberbandFinished();
        }
    }

    @Override
    public void startRubberbandRG() {
        this.getLogger().log(1078071040, "RcsCalculatingRubberband#startRubberbandRG()");
        this.setRbbState(7);
        this.getStateMachine().goTo(0);
        this.getStateMachine().startRG(0, false);
    }

    private int getRbbState() {
        return this.getData().rbbState;
    }

    protected void setRbbState(int n) {
        this.getLogger().log(-2137614336, "RcsCalculatingRubberband#setRbbState( %1 )", (long)n);
        this.getData().rbbState = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void refreshRubberbandPoint() {
        this.getLogger().log(-2137614336, "RcsCalculatingRubberband#refreshRubberbandPoint()");
        Object object = this.requestRbbPointPositioMutex;
        synchronized (object) {
            this.getData().rbbPoint = null;
        }
        object = this.getNaviInterface().createCommandList();
        ((CommandList)object).add(new RcsCalculatingRubberband$9(this));
        ((CommandList)object).execute("RcsCalculatingRubberband#refreshRubberbandPoint()");
    }

    @Override
    public void setRubberbandPoint(NavLocationWgs84 navLocationWgs84) {
        if (MapUtils.almostEquals(navLocationWgs84, this.getData().rbbPoint)) {
            this.getLogger().log(-2137614336, "RcsCalculatingRubberband#setRubberbandPoint() - almost equals - loc:%1, position:%2", (Object)navLocationWgs84, (Object)this.getData().rbbPoint);
            return;
        }
        this.getLogger().log(-2137614336, "RcsCalculatingRubberband#setRubberbandPoint() - loc:%1", (Object)navLocationWgs84);
        this.getStateMachine().naviMap.onEvent(210);
        this.updateRgCalculatedRoutesTimeoutTimer.restart();
        CommandList commandList = this.getNaviInterface().createCommandList();
        commandList.add(new RgSetRubberbandPosition(navLocationWgs84));
        commandList.execute("RcsCalculatingRubberband#setRubberbandPosition()");
    }

    @Override
    public void rgStartRubberbandManipulationResult(int n) {
        super.rgStartRubberbandManipulationResult(n);
        this.checkStartRubberbandFinished();
    }

    @Override
    public int getValue4Model() {
        return 4;
    }

    static /* synthetic */ NavLocationWgs84 access$002(RcsCalculatingRubberband rcsCalculatingRubberband, NavLocationWgs84 navLocationWgs84) {
        rcsCalculatingRubberband.rbPointPosition = navLocationWgs84;
        return rcsCalculatingRubberband.rbPointPosition;
    }

    static /* synthetic */ NavLocationWgs84 access$000(RcsCalculatingRubberband rcsCalculatingRubberband) {
        return rcsCalculatingRubberband.rbPointPosition;
    }

    static /* synthetic */ Object access$100(RcsCalculatingRubberband rcsCalculatingRubberband) {
        return rcsCalculatingRubberband.requestRbbPointPositioMutex;
    }

    static /* synthetic */ Timer access$200(RcsCalculatingRubberband rcsCalculatingRubberband) {
        return rcsCalculatingRubberband.updateRgCalculatedRoutesTimeoutTimer;
    }
}

