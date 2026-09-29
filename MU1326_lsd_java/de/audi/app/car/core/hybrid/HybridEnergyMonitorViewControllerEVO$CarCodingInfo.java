/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import de.audi.app.car.core.hybrid.HybridEnergyMonitorViewControllerEVO;
import de.audi.atip.base.IFrameworkAccess;

class HybridEnergyMonitorViewControllerEVO$CarCodingInfo {
    public static final int CAR_TYPE_DEFAULT;
    public static final int CAR_TYPE_AU736;
    public static final int CAR_TYPE_AU49X;
    public static final int CAR_TYPE_AU426;
    public static final int CAR_TYPE_AU724;
    private final int carClass;
    private final int carGeneration;
    private final int carDerivate;
    private final /* synthetic */ HybridEnergyMonitorViewControllerEVO this$0;

    public HybridEnergyMonitorViewControllerEVO$CarCodingInfo(HybridEnergyMonitorViewControllerEVO hybridEnergyMonitorViewControllerEVO, IFrameworkAccess iFrameworkAccess) {
        this.this$0 = hybridEnergyMonitorViewControllerEVO;
        this.carClass = iFrameworkAccess.getSysConst(466);
        this.carGeneration = iFrameworkAccess.getSysConst(469);
        this.carDerivate = iFrameworkAccess.getSysConst(467);
    }

    public int getCarType() {
        int n;
        block0 : switch (this.carClass) {
            case 4: {
                switch (this.carGeneration) {
                    case 2: {
                        switch (this.carDerivate) {
                            case 6: {
                                n = 2;
                                break block0;
                            }
                        }
                        n = -1;
                        break block0;
                    }
                    case 9: {
                        n = 1;
                        break block0;
                    }
                }
                n = -1;
                break;
            }
            case 7: {
                switch (this.carGeneration) {
                    case 2: {
                        switch (this.carDerivate) {
                            case 4: {
                                n = 3;
                                break block0;
                            }
                        }
                        n = -1;
                        break block0;
                    }
                    case 3: {
                        switch (this.carDerivate) {
                            case 6: {
                                n = 0;
                                break block0;
                            }
                        }
                        n = -1;
                        break block0;
                    }
                }
                n = -1;
                break;
            }
            default: {
                n = -1;
            }
        }
        return n;
    }

    public boolean isChargeUpdateByBatteryCtrl() {
        return 0 == this.getCarType() || 1 == this.getCarType() || 2 == this.getCarType();
    }

    public int getWheelDriveType() {
        return 3 == this.getCarType() ? 1 : 2;
    }
}

