/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.hybrid;

import de.audi.atip.base.IFrameworkAccess;

public class CarNetworkPlatformInfo {
    public static final int CAR_TYPE_DEFAULT = -1;
    public static final int CAR_TYPE_AU736 = 0;
    public static final int CAR_TYPE_AU49X = 1;
    public static final int CAR_TYPE_AU426 = 2;
    public static final int CAR_TYPE_AU37x = 3;
    private final int carClass;
    private final int carGeneration;
    private final int carDerivate;

    public CarNetworkPlatformInfo(IFrameworkAccess iFrameworkAccess) {
        this.carClass = iFrameworkAccess.getSysConst(466);
        this.carGeneration = iFrameworkAccess.getSysConst(469);
        this.carDerivate = iFrameworkAccess.getSysConst(467);
    }

    public int getCarType() {
        int n;
        block0 : switch (this.carClass) {
            case 3: {
                switch (this.carGeneration) {
                    case 7: {
                        n = 3;
                        break block0;
                    }
                }
                n = -1;
                break;
            }
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

    public boolean isMLBEvo() {
        return 0 == this.getCarType() || 1 == this.getCarType() || 2 == this.getCarType();
    }

    public boolean isAU37x() {
        return 3 == this.getCarType();
    }
}

