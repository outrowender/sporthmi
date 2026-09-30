/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.via.RgGetLocationOnRouteCommand;
import de.audi.tghu.navi.app.command.via.RgGetRouteBoundingRect;
import de.audi.tghu.navi.app.command.via.RgGetRubberBandPointPositionCmd;
import de.audi.tghu.navi.app.command.via.RgPrepareRubberbandCommand;
import de.audi.tghu.navi.app.command.via.RgSetRubberbandPosition;
import de.audi.tghu.navi.app.command.via.RgStartRubberBandCommand;
import de.audi.tghu.navi.app.command.via.RgStopRubberBandCommand;
import de.audi.tghu.navi.app.map.routecalc.RcsCalculatingBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import de.audi.tghu.navi.app.map.utils.ConstantUtils;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.routeguidance.commands.RgStopRouteCalculation;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

class RcsCalculatingRubberband
extends RcsCalculatingBase {
    public static final int UPDATERGCALCULATEDROUTES_TIMEOUT = 1000;
    protected CalculatedRouteListElement manipulatedRoute = null;
    private NavLocationWgs84 rbPointPosition = null;
    private Object requestRbbPointPositioMutex = new Object();
    private final Timer updateRgCalculatedRoutesTimeoutTimer = new Timer("RcsCalculatingRubberband#updateRgCalculatedRoutesTimeoutTimer", 1000L, true, new DefaultTimerListener(){

        public void fireTimer(Timer timer) {
            RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#updateRgCalculatedRoutesTimeoutTimer#fireTimer()");
            if (!Util.isHURegionAsia()) {
                RcsCalculatingRubberband.this.getStateMachine().naviMap.onEvent(209);
            } else {
                RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#updateRgCalculatedRoutesTimeoutTimer#fireTimer() -- ignoring");
            }
        }
    });
    protected boolean prepareCompleteTour;
    protected int prepareDestinationIndex;

    RcsCalculatingRubberband(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsCalculatingRubberband");
    }

    public void enter() {
        this.getLogger().log(10000000, "RcsCalculatingRubberband#enter() - rbbState:%1", (long)this.getRbbState());
        this.getStateMachine().setRubberbandActive(true);
        this.setRbbState(0);
        if (this.getStateMachine().getLastState() == 2 || this.getStateMachine().getLastState() == 10) {
            this.getStateMachine().naviMap.getMapDataContainer().enterRbbFromRightDrawer = this.getStateMachine().naviMap.getMapDataContainer().enterAltRoutesFromRightDrawer;
            this.getStateMachine().naviMap.getMapDataContainer().enterAltRoutesFromRightDrawer = false;
        }
        this.getStateMachine().cancelAbortCalculationTimer();
    }

    public void exit() {
        super.exit();
        this.getLogger().log(10000000, "RcsCalculatingRubberband#exit() - rbbState = %1", (long)this.getRbbState());
        this.setRbbState(0);
        this.getStateMachine().naviMap.getMapDataContainer().rubberbandViewPort = null;
    }

    public void prepareRubberband(boolean bl, int n) {
        if (this.getRbbState() != 0) {
            this.getLogger().log(10000000, "RcsCalculatingRubberband#prepareRubberband() - ignored, rbbState=%1", (long)this.getRbbState());
            return;
        }
        this.getLogger().log(1000000, "RcsCalculatingRubberband#prepareRubberband() - completeTour:%1, destIndex:%2", bl, (long)n);
        this.prepareCompleteTour = bl;
        this.prepareDestinationIndex = n;
        this.setRbbState(1);
        CommandList commandList = this.getNaviInterface().createCommandList();
        if (!this.data.isRGActive) {
            commandList.add(new RgStopRouteCalculation());
        }
        commandList.add(new RgPrepareRubberbandCommand(true){

            public void execute() {
                if (!RcsCalculatingRubberband.this.getStateMachine().isCalculatingRubberband()) {
                    RcsCalculatingRubberband.this.getLogger().log(100000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
                    this.getCommandList().commandFinished();
                    return;
                }
                RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#prepareRubberband() - call rgPrepareRubberbandManipulation");
                if (RcsCalculatingRubberband.this.getData().rbbPoint != null) {
                    RcsCalculatingRubberband.this.rbPointPosition = RcsCalculatingRubberband.this.getData().rbbPoint;
                    RcsCalculatingRubberband.this.getData().rbbPoint = null;
                    RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#prepareRubberband() - restore last rbPoint : %1", (Object)RcsCalculatingRubberband.this.rbPointPosition);
                }
                super.execute();
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RcsCalculatingRubberband#prepareRubberband()");
    }

    protected void checkPrepareRubberbandFinished() {
        if (this.getRbbState() == 1 && !this.data.isRGActive && this.data.iRgRouteCalculationState == 2) {
            this.finishPrepareRubberbandAndStart();
        }
    }

    protected void finishPrepareRubberbandAndStart() {
        this.getLogger().log(1000000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart() - completeTour: %1, destIndex: %2 ", this.prepareCompleteTour, (long)this.prepareDestinationIndex);
        CommandList commandList = this.getNaviInterface().createCommandList();
        commandList.add(new RgGetRouteBoundingRect(this.prepareCompleteTour, this.prepareDestinationIndex){

            public void rgGetRouteBoundingRectangleResult(NavRectangle navRectangle) {
                if (!RcsCalculatingRubberband.this.getStateMachine().isCalculatingRubberband()) {
                    RcsCalculatingRubberband.this.getLogger().log(100000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
                    this.getCommandList().commandFinished();
                    return;
                }
                RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#rgGetRouteBoundingRectangleResult( %1 )", (Object)navRectangle);
                RcsCalculatingRubberband.this.getStateMachine().naviMap.getMapDataContainer().rubberbandViewPort = navRectangle;
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new NavCommand("NotifyRubberbandPrepared"){

            public void execute() {
                if (!RcsCalculatingRubberband.this.getStateMachine().isCalculatingRubberband()) {
                    RcsCalculatingRubberband.this.getLogger().log(100000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
                    this.getCommandList().commandFinished();
                    return;
                }
                RcsCalculatingRubberband.this.getLogger().log(1000000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() ");
                RcsCalculatingRubberband.this.setRbbState(2);
                RcsCalculatingRubberband.this.getStateMachine().naviMap.onEvent(204);
                this.getCommandList().commandFinished();
            }
        });
        if (Util.isHURegionAsia()) {
            this.refreshRubberbandPoint();
        }
        commandList.add(new RgStartRubberBandCommand(this.prepareDestinationIndex){

            public void execute() {
                if (!RcsCalculatingRubberband.this.getStateMachine().isCalculatingRubberband()) {
                    RcsCalculatingRubberband.this.getLogger().log(100000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
                    this.getCommandList().commandFinished();
                    return;
                }
                RcsCalculatingRubberband.this.data.rgStartRubberbandManipulationResultOK = false;
                RcsCalculatingRubberband.this.setRbbState(3);
                super.execute();
                this.getCommandList().commandFinished();
            }
        });
        commandList.add(new RgGetLocationOnRouteCommand(0L){

            public void execute() {
                long l = RcsCalculatingRubberband.this.manipulatedRoute != null ? RcsCalculatingRubberband.this.manipulatedRoute.distance >> 1 : 0L;
                RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart() - calling rgGetLocationOnRoute( %1 ) ", l);
                this.logger.log(10000000, "RgGetLocationOnRouteCommand#execute() - calling rgGetLocationOnRoute( %1 ) ", l);
                this.getDSINavigation().rgGetLocationOnRoute(l);
            }

            public void rgGetLocationOnRouteResult(NavLocation navLocation) {
                RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart() - rgGetLocationOnRouteResult( %1 )", (Object)navLocation);
                RcsCalculatingRubberband.this.getData().rbbPoint = new NavLocationWgs84(navLocation.longitude, navLocation.latitude);
                RcsCalculatingRubberband.this.getStateMachine().naviMap.onEvent(205);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RcsCalculatingRubberband#finishPrepareRubberbandAndStart()");
    }

    protected void checkStartRubberbandFinished() {
        if (this.getRbbState() == 3 && this.data.rgStartRubberbandManipulationResultOK && this.data.iRgRouteCalculationState == 3) {
            this.finishStartRubberbandAndInitRubberbandPoint();
        }
    }

    protected void finishStartRubberbandAndInitRubberbandPoint() {
        this.getLogger().log(1000000, "RcsCalculatingRubberband#finishStartRubberbandAndInitRubberbandPoint() ");
        CommandList commandList = this.getNaviInterface().createCommandList();
        commandList.add(new NavCommand("NotifyRubberbandReady"){

            public void execute() {
                if (!RcsCalculatingRubberband.this.getStateMachine().isCalculatingRubberband()) {
                    RcsCalculatingRubberband.this.getLogger().log(100000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
                    this.getCommandList().commandFinished();
                    return;
                }
                RcsCalculatingRubberband.this.getLogger().log(1000000, "RcsCalculatingRubberband#finishStartRubberbandAndInitRubberbandPoint() - NotifyRubberbandReady");
                RcsCalculatingRubberband.this.setRbbState(4);
                RcsCalculatingRubberband.this.getStateMachine().naviMap.onEvent(206);
                this.getCommandList().commandFinished();
            }
        });
        commandList.execute("RcsCalculatingRubberband#finishStartRubberbandAndInitRubberbandPoint()");
    }

    public void cancel() {
        this.getLogger().log(1000000, "RcsCalculatingRubberband#cancelRubberband()");
        this.setRbbState(8);
        CommandList commandList = this.getNaviInterface().createCommandList();
        commandList.add(new RgStopRubberBandCommand(false));
        commandList.add(new NavCommand("NotifyRubberbandCanceled"){

            public void execute() {
                RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#cancelRubberband() - NotifyRubberbandCanceled");
                RcsCalculatingRubberband.this.getStateMachine().naviMap.onEvent(207);
                RcsCalculatingRubberband.this.getStateMachine().naviMap.getMVRequest().setDragRouteMarker(0);
                this.getCommandList().commandFinished();
            }
        });
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

    protected void onFirstMatchFound() {
        this.getLogger().log(10000000, "RcsCalculatingRubberband#onFirstMatchFound( )");
    }

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        super.updateRgCalculatedRoutes(calculatedRouteListElementArray);
        if (calculatedRouteListElementArray != null && calculatedRouteListElementArray.length > 0) {
            int n = this.getStateMachine().getRgRouteCalculationState();
            this.getLogger().log(10000000, "RcsCalculatingRubberband#updateRgCalculatedRoutes() - rgCalculatedRoutes[0]: %1, routeCalcState: %2", (Object)calculatedRouteListElementArray[0], (long)n);
            this.manipulatedRoute = calculatedRouteListElementArray[0];
            if (n == 3) {
                this.refreshRubberbandPoint();
            }
        } else {
            this.getLogger().log(10000000, "RcsCalculatingRubberband#updateRgCalculatedRoutes() - empty");
        }
    }

    public void updateRgRouteCalculationState(int n) {
        this.getLogger().log(10000000, "RcsCalculatingRubberband#updateRgRouteCalculationState( %1 )", (Object)ConstantUtils.ROUTECALCULATIONSTATE[n]);
        super.updateRgRouteCalculationState(n);
        this.checkPrepareRubberbandFinished();
        this.checkStartRubberbandFinished();
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        if (bl) {
            if (this.getRbbState() == 7 || this.getRbbState() == 8) {
                this.getLogger().log(1000000, "RcsCalculatingRubberband#updateRgActive( true ) - Rubberband finished");
            } else {
                this.getLogger().log(100000, "RcsCalculatingRubberband#updateRgActive( true ) - unexpected, because rbbState = %1", (long)this.getRbbState());
            }
            this.goTo(7);
        } else {
            this.getLogger().log(10000000, "RcsCalculatingRubberband#updateRgActive( false )");
            this.checkPrepareRubberbandFinished();
        }
    }

    public void startRubberbandRG() {
        this.getLogger().log(1000000, "RcsCalculatingRubberband#startRubberbandRG()");
        this.setRbbState(7);
        this.getStateMachine().goTo(0);
        this.getStateMachine().startRG(0, false);
    }

    private int getRbbState() {
        return this.getData().rbbState;
    }

    protected void setRbbState(int n) {
        this.getLogger().log(10000000, "RcsCalculatingRubberband#setRbbState( %1 )", (long)n);
        this.getData().rbbState = n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void refreshRubberbandPoint() {
        this.getLogger().log(10000000, "RcsCalculatingRubberband#refreshRubberbandPoint()");
        Object object = this.requestRbbPointPositioMutex;
        synchronized (object) {
            this.getData().rbbPoint = null;
        }
        object = this.getNaviInterface().createCommandList();
        ((CommandList)object).add(new RgGetRubberBandPointPositionCmd(){

            /*
             * WARNING - Removed try catching itself - possible behaviour change.
             */
            public void rgGetRubberBandPointPositionResult(NavLocationWgs84 navLocationWgs84, boolean bl) {
                if (!RcsCalculatingRubberband.this.getStateMachine().isCalculatingRubberband()) {
                    RcsCalculatingRubberband.this.getLogger().log(100000, "RcsCalculatingRubberband#finishPrepareRubberbandAndStart#NotifyRubberbandPrepared() - not in rubberband state anymore!");
                    this.getCommandList().commandFinished();
                    return;
                }
                RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#refreshRubberbandPoint() - available:%1, position:%2", bl, (Object)navLocationWgs84);
                if (bl) {
                    Object object = RcsCalculatingRubberband.this.requestRbbPointPositioMutex;
                    synchronized (object) {
                        RcsCalculatingRubberband.this.getData().rbbPoint = bl ? navLocationWgs84 : null;
                        RcsCalculatingRubberband.this.updateRgCalculatedRoutesTimeoutTimer.cancel();
                        RcsCalculatingRubberband.this.getStateMachine().naviMap.onEvent(208);
                    }
                    this.getCommandList().commandFinished();
                } else {
                    this.getCommandList().commandFinishedWithPostCommand(new RgGetLocationOnRouteCommand(0L){

                        public void execute() {
                            long l = (this).RcsCalculatingRubberband.this.manipulatedRoute != null ? (this).RcsCalculatingRubberband.this.manipulatedRoute.distance >> 1 : 0L;
                            RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#refreshRubberbandPoint() - calling rgGetLocationOnRoute( %1 ) ", l);
                            this.getDSINavigation().rgGetLocationOnRoute(l);
                        }

                        /*
                         * WARNING - Removed try catching itself - possible behaviour change.
                         */
                        public void rgGetLocationOnRouteResult(NavLocation navLocation) {
                            RcsCalculatingRubberband.this.getLogger().log(10000000, "RcsCalculatingRubberband#refreshRubberbandPoint() - rgGetLocationOnRouteResult( %1 )", (Object)navLocation);
                            Object object = RcsCalculatingRubberband.this.requestRbbPointPositioMutex;
                            synchronized (object) {
                                (this).RcsCalculatingRubberband.this.getData().rbbPoint = new NavLocationWgs84(navLocation.longitude, navLocation.latitude);
                                RcsCalculatingRubberband.this.updateRgCalculatedRoutesTimeoutTimer.cancel();
                                (this).RcsCalculatingRubberband.this.getStateMachine().naviMap.onEvent(208);
                            }
                            this.getCommandList().commandFinished();
                        }
                    });
                }
            }
        });
        ((CommandList)object).execute("RcsCalculatingRubberband#refreshRubberbandPoint()");
    }

    public void setRubberbandPoint(NavLocationWgs84 navLocationWgs84) {
        if (MapUtils.almostEquals(navLocationWgs84, this.getData().rbbPoint)) {
            this.getLogger().log(10000000, "RcsCalculatingRubberband#setRubberbandPoint() - almost equals - loc:%1, position:%2", (Object)navLocationWgs84, (Object)this.getData().rbbPoint);
            return;
        }
        this.getLogger().log(10000000, "RcsCalculatingRubberband#setRubberbandPoint() - loc:%1", (Object)navLocationWgs84);
        this.getStateMachine().naviMap.onEvent(210);
        this.updateRgCalculatedRoutesTimeoutTimer.restart();
        CommandList commandList = this.getNaviInterface().createCommandList();
        commandList.add(new RgSetRubberbandPosition(navLocationWgs84));
        commandList.execute("RcsCalculatingRubberband#setRubberbandPosition()");
    }

    public void rgStartRubberbandManipulationResult(int n) {
        super.rgStartRubberbandManipulationResult(n);
        this.checkStartRubberbandFinished();
    }

    public int getValue4Model() {
        return 4;
    }
}

