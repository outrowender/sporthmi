/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.search;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.Distance;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.command.poi.RRDStartCalculationForPositionCommand;
import de.audi.tghu.navi.app.command.poi.RRDStopCalculationCommand;
import de.audi.tghu.navi.app.guidance.IVehicle;
import de.audi.tghu.navi.app.search.IntelliDestDistanceRow;
import de.audi.tghu.navi.app.util.Util;
import java.util.ArrayList;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RrdCalculationInfo;

public class TrufflesDistanceCalculator
implements TimerListener {
    private static final long AIR_DELAY_UPDATE = 5000L;
    private static final long RRD_DELAY_UPDATE = 60000L;
    private static final long RRD_DELAY_AFTER_USER_INPUT = 5000L;
    private static final int MAX_RRD_ENTRIES = 10;
    private static final int RRD_ARROW_OFFSET = 8;
    private final Timer updateAirdistanceTimer;
    private Timer updateRRDTimer;
    private final LogChannel lc;
    protected final BaseListModelApp listModel;
    protected final IVehicle vehicle;
    protected final Object lock;
    private final ICommandListFactory commandListFactory;
    private EvoListRow[] rrdRowsCache;
    private boolean rrdCalculationIsRunning;

    public TrufflesDistanceCalculator(IVehicle iVehicle, LogChannel logChannel, BaseListModelApp baseListModelApp, Object object, ICommandListFactory iCommandListFactory) {
        this.vehicle = iVehicle;
        this.lc = logChannel;
        this.listModel = baseListModelApp;
        this.lock = object;
        this.commandListFactory = iCommandListFactory;
        this.updateAirdistanceTimer = new Timer("TrufflesDistanceCalculator", 5, this.lc, this, 5000L, false);
        if (Boolean.getBoolean("DRRD_TRUFFLES")) {
            this.updateRRDTimer = new Timer("TrufflesDistanceCalculator", 5, this.lc, this, 60000L, false);
        }
    }

    public void startCalculation() {
        this.updateDirectionAndAirDistance();
        this.updateAirdistanceTimer.start();
        if (this.updateRRDTimer != null) {
            this.triggerRRDCalculation();
            this.updateRRDTimer.start();
        }
    }

    public void stopCalculation() {
        this.updateAirdistanceTimer.cancel();
        if (this.updateRRDTimer == null) {
            return;
        }
        this.updateRRDTimer.cancel();
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RRDStopCalculationCommand());
        commandList.execute("TrufflesDistanceCalculator#stopCalculation()");
    }

    public void userInputChanged() {
        if (this.updateRRDTimer == null) {
            return;
        }
        this.updateRRDTimer.setDelay(5000L);
        this.updateRRDTimer.restart();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected EvoListRow[] getRowsWithCoordinates(BaseListModelApp baseListModelApp, int n) {
        if (baseListModelApp == null) {
            return null;
        }
        Object object = this.lock;
        synchronized (object) {
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < n; ++i2) {
                EvoListRow evoListRow = baseListModelApp.getRow(i2);
                if (!(evoListRow instanceof IntelliDestDistanceRow) || !((IntelliDestDistanceRow)((Object)evoListRow)).hasGeoCoordinates()) continue;
                arrayList.add(evoListRow);
            }
            if (arrayList.size() == 0) {
                if (this.lc.isDebug2()) {
                    this.lc.log(100000000, "TrufflesDistanceCalculator#getAllVisibleRowsFromListModel() Counter is 0 will return NULL");
                }
                return null;
            }
            return (EvoListRow[])arrayList.toArray(new EvoListRow[arrayList.size()]);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void updateDirectionAndAirDistance() {
        PosPosition posPosition = this.vehicle.getPosition();
        Object object = this.lock;
        synchronized (object) {
            EvoListRow[] evoListRowArray = this.getRowsWithCoordinates(this.listModel, this.listModel.getLength());
            if (!this.isUpdatePossible(evoListRowArray)) {
                return;
            }
            for (int i2 = 0; i2 < evoListRowArray.length; ++i2) {
                IntelliDestDistanceRow intelliDestDistanceRow = (IntelliDestDistanceRow)((Object)evoListRowArray[i2]);
                this.updateDirectionArrow(posPosition, intelliDestDistanceRow);
                if (intelliDestDistanceRow.hasRRD()) continue;
                int n = Util.computeAirDistance(posPosition.getLongitude(), posPosition.getLatitude(), intelliDestDistanceRow.getLongitude(), intelliDestDistanceRow.getLatitude());
                intelliDestDistanceRow.setDistanceColumn(new Distance(n, 5));
            }
            BaseListModelApp baseListModelApp = this.listModel.getCopy();
            for (int i3 = 0; i3 < evoListRowArray.length; ++i3) {
                baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(evoListRowArray[i3].getUniqueID()), evoListRowArray[i3]);
            }
            this.listModel.update(baseListModelApp);
            this.checkForNewRrdRows();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateRrdCalculationInfo(RrdCalculationInfo[] rrdCalculationInfoArray) {
        this.lc.log(10000000, "TrufflesDistanceCalculator#updateRrdCalculationInfo() updateRRDTimer is initialized=%1", this.updateRRDTimer != null);
        if (this.updateRRDTimer == null) {
            return;
        }
        if (!this.updateRRDTimer.isRunning() || !this.isUpdatePossible(this.rrdRowsCache)) {
            return;
        }
        PosPosition posPosition = this.vehicle.getPosition();
        Object object = this.lock;
        synchronized (object) {
            BaseListModelApp baseListModelApp = this.listModel.getCopy();
            for (int i2 = 0; i2 < rrdCalculationInfoArray.length; ++i2) {
                if (rrdCalculationInfoArray[i2] == null) continue;
                if (i2 >= this.rrdRowsCache.length || this.rrdRowsCache[i2] == null) {
                    return;
                }
                EvoListRow evoListRow = this.rrdRowsCache[i2];
                EvoListRow evoListRow2 = this.listModel.getRowByUniqueID(evoListRow.getUniqueID());
                if (evoListRow2 == null) {
                    return;
                }
                ((IntelliDestDistanceRow)((Object)evoListRow2)).setHasRRD(true);
                ((IntelliDestDistanceRow)((Object)evoListRow2)).setDistanceColumn(new Distance(rrdCalculationInfoArray[i2].rrdInfo, 5));
                this.updateDirectionArrow(posPosition, (IntelliDestDistanceRow)((Object)evoListRow2));
                baseListModelApp.setRow(baseListModelApp.getIndexForUniqueID(evoListRow2.getUniqueID()), evoListRow2);
            }
            this.listModel.update(baseListModelApp);
            if (this.rrdRowsCache.length == rrdCalculationInfoArray.length) {
                this.rrdCalculationIsRunning = false;
            }
        }
    }

    protected void checkForNewRrdRows() {
        EvoListRow[] evoListRowArray = this.getRowsWithCoordinates(this.listModel, this.listModel.getLength() < 10 ? this.listModel.getLength() : 10);
        if (!(this.rrdRowsCache == null && evoListRowArray != null || this.rrdRowsCache != null && this.rrdRowsCache.length < 10 && evoListRowArray != null && evoListRowArray.length > this.rrdRowsCache.length)) {
            return;
        }
        if (!this.rrdCalculationIsRunning) {
            this.triggerRRDCalculation();
        }
    }

    private void triggerRRDCalculation() {
        this.lc.log(10000000, "TrufflesDistanceCalculator#triggerRRDCalculation() updateRRDTimer is initialized=%1", this.updateRRDTimer != null);
        if (this.updateRRDTimer == null) {
            return;
        }
        this.rrdRowsCache = this.getRowsWithCoordinates(this.listModel, this.listModel.getLength() < 10 ? this.listModel.getLength() : 10);
        if (!this.isUpdatePossible(this.rrdRowsCache)) {
            return;
        }
        this.rrdCalculationIsRunning = true;
        NavLocationWgs84[] navLocationWgs84Array = new NavLocationWgs84[this.rrdRowsCache.length];
        for (int i2 = 0; i2 < this.rrdRowsCache.length; ++i2) {
            IntelliDestDistanceRow intelliDestDistanceRow = (IntelliDestDistanceRow)((Object)this.rrdRowsCache[i2]);
            navLocationWgs84Array[i2] = new NavLocationWgs84(intelliDestDistanceRow.getLongitude(), intelliDestDistanceRow.getLatitude());
        }
        CommandList commandList = this.commandListFactory.createCommandList(1);
        commandList.add(new RRDStopCalculationCommand());
        commandList.add(new RRDStartCalculationForPositionCommand(navLocationWgs84Array));
        commandList.execute("TrufflesDistanceCalculator#triggerRRDCalculation()");
    }

    protected void updateDirectionArrow(PosPosition posPosition, IntelliDestDistanceRow intelliDestDistanceRow) {
        int n = Util.computeAbsoluteDirection(posPosition, intelliDestDistanceRow.getLongitude(), intelliDestDistanceRow.getLatitude());
        int n2 = Util.convertRotatingDirection(n, posPosition.directionAngle);
        if (intelliDestDistanceRow.hasRRD()) {
            intelliDestDistanceRow.setArrowColumn(n2 + 8);
        } else {
            intelliDestDistanceRow.setArrowColumn(n2);
        }
    }

    protected boolean isUpdatePossible(EvoListRow[] evoListRowArray) {
        if (this.listModel == null || evoListRowArray == null || evoListRowArray.length == 0) {
            if (this.listModel == null) {
                this.lc.log(100000, "TrufflesDistanceCalculator#updateDirectionAndAirDistance listModel is null");
            } else if (evoListRowArray == null) {
                if (this.lc.isDebug2()) {
                    this.lc.log(100000000, "TrufflesDistanceCalculator#updateDirectionAndAirDistance visible rows List is null");
                }
            } else if (this.lc.isDebug2()) {
                this.lc.log(100000000, "TrufflesDistanceCalculator#updateDirectionAndAirDistance visible rows List is empty");
            }
            return false;
        }
        return true;
    }

    public void fireTimer(Timer timer) {
        if (this.lc.isDebug2()) {
            this.lc.log(100000000, "IntelliDestDistanceCalculator#fireTimer() - Timer: %1 ", (Object)timer.getName());
        }
        if (timer == this.updateAirdistanceTimer) {
            this.updateDirectionAndAirDistance();
        } else if (timer == this.updateRRDTimer) {
            if (this.updateRRDTimer == null) {
                return;
            }
            this.triggerRRDCalculation();
            this.updateRRDTimer.setDelay(60000L);
            this.updateRRDTimer.restart();
        } else {
            this.lc.log(100000, "IntelliDestDistanceCalculator#fireTimer() - Unknown timer: %1! ", (Object)timer);
        }
    }

    public void cancelTimer(Timer timer) {
    }
}

