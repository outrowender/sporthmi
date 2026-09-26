/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.common.util.MiscHybridHelper;
import de.audi.app.car.core.hybrid.HybridEnergyMonitorViewControllerEVO$CarCodingInfo;
import de.audi.app.car.core.hybrid.IHybridEnergyMonitorViewController;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.carhybrid.BatteryControlChargeState;
import org.dsi.ifc.carhybrid.HybridEnergyFlowState;
import org.dsi.ifc.carhybrid.HybridViewOptions;

public class HybridEnergyMonitorViewControllerEVO
implements IHybridEnergyMonitorViewController {
    public static final int CARGE_UPDATE_METHOD_HYBRID;
    public static final int CARGE_UPDATE_METHOD_BATTERY_CTRL;
    protected final IFrameworkAccess frameworkAccess;
    protected final LogChannel logChannel;
    private final HybridEnergyMonitorViewControllerEVO$CarCodingInfo carCodingInfo;
    private int chargeUpdateMethod = 0;
    private volatile HybridViewOptions currentViewOptions;
    private int wheelDriveType = -1;

    public HybridEnergyMonitorViewControllerEVO(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.frameworkAccess = iFrameworkAccess;
        this.logChannel = logChannel;
        this.carCodingInfo = new HybridEnergyMonitorViewControllerEVO$CarCodingInfo(this, iFrameworkAccess);
    }

    public int getChargeUpdateMethod() {
        return this.chargeUpdateMethod;
    }

    public void setChargeUpdateMethod(int n) {
        this.chargeUpdateMethod = n;
    }

    private void fillHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState) {
        ListModelApp listModelApp = this.frameworkAccess.getHMIService().getListModel(1848314112);
        this.setEnergyFlowStateWheels(listModelApp, hybridEnergyFlowState.getMotionState());
        this.setEnergyFlowStateBattery(listModelApp, hybridEnergyFlowState.getBatteryState());
        this.setEnergyFlowStateCombustionEngine(listModelApp, hybridEnergyFlowState.getICEState());
        this.setEnergyFlowStateArrowsAndCardanShaft(listModelApp, hybridEnergyFlowState);
    }

    private void setEnergyFlowStateWheels(ListModelApp listModelApp, int n) {
        switch (n) {
            case 3: {
                listModelApp.setRow(1, IntegerListCell.create(1));
                break;
            }
            case 4: {
                listModelApp.setRow(1, IntegerListCell.create(2));
                break;
            }
            default: {
                listModelApp.setRow(1, IntegerListCell.create(0));
            }
        }
    }

    private void setEnergyFlowStateBattery(ListModelApp listModelApp, int n) {
        switch (n) {
            case 2: {
                listModelApp.setRow(2, IntegerListCell.create(2));
                break;
            }
            case 4: {
                listModelApp.setRow(2, IntegerListCell.create(3));
                break;
            }
            case 5: {
                listModelApp.setRow(2, IntegerListCell.create(1));
                break;
            }
            default: {
                listModelApp.setRow(2, IntegerListCell.create(0));
            }
        }
    }

    private void setEnergyFlowStateCombustionEngine(ListModelApp listModelApp, int n) {
        if (null == this.currentViewOptions) {
            this.logChannel.log(-1601830656, "[HybridEnergyMonitorViewControllerEVO#setEnergyFlowStateCombustionEngine] No view options received yet.");
            return;
        }
        if (this.currentViewOptions.getHybridConfiguration().isIce()) {
            if (3 == n || 4 == n || 5 == n) {
                listModelApp.setRow(4, IntegerListCell.create(1));
            } else {
                listModelApp.setRow(4, IntegerListCell.create(2));
            }
        } else {
            listModelApp.setRow(4, IntegerListCell.create(0));
        }
    }

    private void setEnergyFlowStateArrowsAndCardanShaft(ListModelApp listModelApp, HybridEnergyFlowState hybridEnergyFlowState) {
        if (null == this.currentViewOptions) {
            this.logChannel.log(-1601830656, "[HybridEnergyMonitorViewControllerEVO#setEnergyFlowStateCombustionEngine] No view options received yet.");
            return;
        }
        int n = 0;
        int n2 = 0;
        int n3 = hybridEnergyFlowState.getTorqueState();
        int n4 = hybridEnergyFlowState.getICEState();
        int n5 = hybridEnergyFlowState.getEe1State();
        listModelApp.setRow(5, IntegerListCell.create(0));
        if (hybridEnergyFlowState.getMotionState() != 4) {
            switch (n3) {
                case 4: {
                    if (this.currentViewOptions.getHybridConfiguration().isEe1() && 3 == n5) {
                        n = 1;
                        n2 = 1;
                    }
                    if (!this.currentViewOptions.getHybridConfiguration().isIce() || 4 != n4) break;
                    n = 2;
                    n2 = 2;
                    break;
                }
                case 6: {
                    if (this.currentViewOptions.getHybridConfiguration().isEe1() && 5 == n5) {
                        n = 4;
                        n2 = 1;
                    }
                    if (!this.currentViewOptions.getHybridConfiguration().isIce() || 4 != n4) break;
                    n = 5;
                    n2 = 2;
                    break;
                }
                case 3: {
                    if (this.currentViewOptions.getHybridConfiguration().isIce() && this.currentViewOptions.getHybridConfiguration().isEe1()) {
                        n = 3;
                        n2 = 3;
                        break;
                    }
                    n = 0;
                    break;
                }
                default: {
                    n = 0;
                }
            }
        }
        listModelApp.setRow(5, IntegerListCell.create(n));
        switch (this.wheelDriveType) {
            case 2: {
                listModelApp.setRow(6, IntegerListCell.create(n2));
                break;
            }
            default: {
                listModelApp.setRow(6, IntegerListCell.create(0));
            }
        }
    }

    @Override
    public void initialize() {
        if (this.carCodingInfo.isChargeUpdateByBatteryCtrl()) {
            this.setChargeUpdateMethod(1);
        }
        ListModelApp listModelApp = this.frameworkAccess.getHMIService().getListModel(1848314112);
        for (int i2 = 0; i2 < 7; ++i2) {
            listModelApp.addRow(IntegerListCell.create(0));
        }
        this.setWheelDriveType(this.carCodingInfo.getWheelDriveType());
        switch (this.wheelDriveType) {
            case 0: {
                listModelApp.setRow(0, IntegerListCell.create(0));
                break;
            }
            case 1: {
                listModelApp.setRow(0, IntegerListCell.create(1));
                break;
            }
            case 2: {
                listModelApp.setRow(0, IntegerListCell.create(2));
                break;
            }
            default: {
                this.logChannel.log(10000, "[HybridEnergyMonitorViewControllerEVO#initModels] Wrong wheel drive type: %1", (long)this.wheelDriveType);
                listModelApp.setRow(0, IntegerListCell.create(2));
            }
        }
    }

    @Override
    public void setWheelDriveType(int n) {
        this.wheelDriveType = n;
    }

    @Override
    public void updateHybridViewOptions(HybridViewOptions hybridViewOptions) {
        this.currentViewOptions = hybridViewOptions;
    }

    @Override
    public void updateHybridEnergyFlowState(HybridEnergyFlowState hybridEnergyFlowState) {
        this.fillHybridEnergyFlowState(hybridEnergyFlowState);
    }

    @Override
    public void updateHybridCharge(int n) {
        if (0 == this.chargeUpdateMethod) {
            int n2 = MiscHybridHelper.getBatterySegmentForPercentage(n);
            ListModelApp listModelApp = this.frameworkAccess.getHMIService().getListModel(1848314112);
            listModelApp.setRow(3, IntegerListCell.create(n2));
        }
    }

    @Override
    public void updateBatteryControlChargeState(BatteryControlChargeState batteryControlChargeState) {
        if (1 == this.chargeUpdateMethod) {
            int n = MiscHybridHelper.getBatterySegmentForPercentage(batteryControlChargeState.getCurrentChargeLevel());
            ListModelApp listModelApp = this.frameworkAccess.getHMIService().getListModel(1848314112);
            listModelApp.setRow(3, IntegerListCell.create(n));
        }
    }
}

