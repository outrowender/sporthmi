/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.base;

import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.CarFuncAdap;
import org.dsi.ifc.global.CarViewOption;

public class ViewOptionMapper {
    private final LogChannel logger;
    private CarFuncAdap codingAdapter;
    private final Object mutex = new Object();

    public ViewOptionMapper(LogChannel logChannel, CarFuncAdap carFuncAdap) {
        this.logger = logChannel;
        this.codingAdapter = carFuncAdap;
    }

    public int getVisibilityState(CarViewOption carViewOption, short s) {
        int n;
        short s2 = this.codingAdapter.getByteCoding(s);
        if (this.codingAdapter.isMenuDisplayActivated(s2)) {
            if (carViewOption == null) {
                this.logger.log(1000, "[getMenuEntryVisibilityState] viewOption is null.");
                return 1;
            }
            switch (carViewOption.getState()) {
                case 2: {
                    n = 2;
                    break;
                }
                case 1: {
                    n = this.getDisabledState(carViewOption.getReason());
                    break;
                }
                default: {
                    n = 1;
                    break;
                }
            }
        } else {
            n = 0;
        }
        return n;
    }

    public int getVisibilityState(CarViewOption carViewOption) {
        int n;
        if (carViewOption == null) {
            this.logger.log(1000, "[getMenuEntryVisibilityState] viewOption is null.");
            return 1;
        }
        switch (carViewOption.getState()) {
            case 2: {
                n = 2;
                break;
            }
            case 1: {
                n = this.getDisabledState(carViewOption.getReason());
                break;
            }
            default: {
                n = 1;
            }
        }
        return n;
    }

    public int getVisibilityState(CarViewOption[] carViewOptionArray) {
        int n = 2;
        block5: for (int i2 = 0; i2 < carViewOptionArray.length; ++i2) {
            int n2 = this.getVisibilityState(carViewOptionArray[i2]);
            switch (n2) {
                case 2: {
                    continue block5;
                }
                case 1: {
                    n = n2;
                    continue block5;
                }
                case 3: 
                case 4: 
                case 5: 
                case 7: 
                case 8: 
                case 9: {
                    if (n == 1) continue block5;
                    n = this.getMaxState(n, n2);
                    continue block5;
                }
            }
        }
        return n;
    }

    private int getDisabledState(int n) {
        int n2;
        switch (n) {
            case 2: {
                n2 = 4;
                break;
            }
            case 3: {
                n2 = 5;
                break;
            }
            case 4: {
                n2 = 7;
                break;
            }
            case 5: {
                n2 = 4;
                break;
            }
            case 6: {
                n2 = 8;
                break;
            }
            default: {
                n2 = 3;
            }
        }
        return n2;
    }

    private int getMaxState(int n, int n2) {
        if (n == 1 || n2 == 1) {
            return 1;
        }
        if (n == 9 || n2 == 9) {
            return 9;
        }
        if (n == 3 || n2 == 3) {
            return 3;
        }
        if (n == 4 || n2 == 4) {
            return 4;
        }
        if (n == 7 || n2 == 7) {
            return 7;
        }
        if (n == 5 || n2 == 5) {
            return 5;
        }
        if (n == 8 || n2 == 8) {
            return 8;
        }
        return 2;
    }
}

