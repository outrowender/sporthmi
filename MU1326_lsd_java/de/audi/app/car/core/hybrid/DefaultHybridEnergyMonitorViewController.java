/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.IHybridEnergyMonitorViewController;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public class DefaultHybridEnergyMonitorViewController
implements IHybridEnergyMonitorViewController {
    private static final int MODEL_COLUMN_VALUE = 0;
    private static final int MODEL_COLUMN_SIZE = 1;
    protected final IFrameworkAccess frameworkAccess;
    protected final LogChannel logChannel;
    protected volatile HybridViewOptions currentViewOptions;
    private int wheelDriveType = -1;
    private BaseListModelApp energyMonitorDataListModel;

    public DefaultHybridEnergyMonitorViewController(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.frameworkAccess = iFrameworkAccess;
        this.logChannel = logChannel;
    }

    private void resetEnergyMonitorData() {
        if (null != this.energyMonitorDataListModel) {
            this.energyMonitorDataListModel.setLength(11);
        }
    }

    public void initialize() {
        this.energyMonitorDataListModel = this.frameworkAccess.getHMIService().getBaseListModel(602385);
        this.resetEnergyMonitorData();
        this.setWheelDriveType(2);
    }

    public void setWheelDriveType(int n) {
        switch (n) {
            case 0: 
            case 1: 
            case 2: {
                this.wheelDriveType = n;
                break;
            }
            default: {
                this.logChannel.log(10000, "[DefaultHybridEnergyMonitorViewController#setWheelDriveType] Wrong wheel drive type: %1", (long)n);
                this.wheelDriveType = 2;
            }
        }
        this.setListData(this.energyMonitorDataListModel, new int[][]{{10, this.wheelDriveType}});
    }

    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions) {
        this.currentViewOptions = hybridViewOptions;
    }

    public void updateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState) {
        if (null != hybridEnergyFlowState) {
            this.setListData(this.energyMonitorDataListModel, new int[][]{{0, hybridEnergyFlowState.getICEState()}, {1, hybridEnergyFlowState.getBatteryState()}, {2, hybridEnergyFlowState.getTorqueState()}, {3, hybridEnergyFlowState.getEe1State()}, {4, hybridEnergyFlowState.getEe2State()}, {5, hybridEnergyFlowState.getMotionState()}, {6, hybridEnergyFlowState.getPowerSupplyState()}});
        }
    }

    public void updateHybridCharge(int n) {
        this.setListData(this.energyMonitorDataListModel, new int[][]{{7, n}});
    }

    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState) {
        if (null != batteryControlChargeState) {
            this.setListData(this.energyMonitorDataListModel, new int[][]{{8, batteryControlChargeState.getChargeState()}, {9, batteryControlChargeState.getCurrentChargeLevel()}});
        }
    }

    private EvoListRow createListRow(int n) {
        EvoListRow evoListRow = new EvoListRow(-1L, 1);
        evoListRow.setInteger(0, n);
        return evoListRow;
    }

    protected void setListData(BaseListModelApp baseListModelApp, int[][] nArray) {
        this.energyMonitorDataListModel.setStatus(0);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            EvoListRow evoListRow = this.createListRow(nArray[i2][1]);
            this.energyMonitorDataListModel.setRow(nArray[i2][0], evoListRow);
        }
        this.energyMonitorDataListModel.setStatus(1);
    }
}

