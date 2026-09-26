/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.log.LogChannel;
import de.audi.atip.sysapp.carcoding.Coding;
import de.audi.tghu.hmi.evo.ICarCodingHelper;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.evo.InvalidCarCodingException;

public class CarCodingHelper
implements ICarCodingHelper,
IWidgetLogChannel {
    private int carType;
    private int carClass;
    private int carGeneration;
    private int carDerivate;
    private int carDerivateSub;
    private IFrameworkAccess framework;
    private LogChannel logCarCoding;
    private boolean initialized;

    public CarCodingHelper(IFrameworkAccess iFrameworkAccess) {
        this.framework = iFrameworkAccess;
        this.logCarCoding = IWidgetLogChannel.logCarCoding;
    }

    public CarCodingHelper(IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        this.framework = iFrameworkAccess;
        this.logCarCoding = logChannel;
    }

    protected boolean checkInitialization() {
        if (this.initialized) {
            return true;
        }
        if (this.framework.isSimulator()) {
            this.getCodingFromVMOptions();
        } else {
            boolean bl = this.readCarCoding();
            if (!bl) {
                this.logCarCoding.log(10000, "CarCodingHelper#checkInitialization carCoding is null");
                return false;
            }
        }
        this.calculateCarType();
        this.initialized = true;
        this.logCarCoding.log(1078071040, "CarCodingHelper#checkInitialization %1", (Object)this);
        return true;
    }

    protected void getCodingFromVMOptions() {
        this.logCarCoding.log(1078071040, "CarCodingHelper#checkInitialization simulation is running, checking vmoptions");
        int n = this.framework.getScreenRes();
        if (n == 4) {
            this.readVMOptionsWithDefaults(3, 3, 4, 0);
        } else if (n == 1) {
            this.readVMOptionsWithDefaults(4, 9, 1, 0);
        } else if (n == 0) {
            this.readVMOptionsWithDefaults(2, 7, 6, 0);
        } else {
            this.readVMOptionsWithDefaults(7, 3, 6, 1);
        }
    }

    protected void readVMOptionsWithDefaults(int n, int n2, int n3, int n4) {
        this.carClass = Integer.getInteger("CAR_CLASS", n);
        this.carGeneration = Integer.getInteger("CAR_GENERATION", n2);
        this.carDerivate = Integer.getInteger("CAR_DERIVATE", n3);
        this.carDerivateSub = Integer.getInteger("CAR_DERIVATE_SUPPLEMENT", n4);
    }

    protected boolean readCarCoding() {
        Coding coding = this.framework.getSysConstManager().getCarCoding();
        if (coding == null) {
            return false;
        }
        this.carClass = coding.getCarClass();
        this.carGeneration = coding.getCarGeneration();
        this.carDerivate = coding.getCarDerivate();
        this.carDerivateSub = coding.getCarDerivateSupplement();
        return true;
    }

    private void calculateCarType() {
        try {
            this.carType = this.calculateCarTypeImpl();
        }
        catch (InvalidCarCodingException invalidCarCodingException) {
            invalidCarCodingException.printStackTrace();
            this.carType = -1;
        }
    }

    private int calculateCarTypeImpl() {
        if (this.carClass == 2) {
            if (this.carGeneration == 7 && this.carDerivate == 6) {
                return 13;
            }
        } else if (this.carClass == 3) {
            if (this.carGeneration == 3 && this.carDerivate == 4) {
                return 20;
            }
            if (this.carGeneration == 3 && this.carDerivate == 5) {
                return 21;
            }
            if (this.carGeneration == 7 && this.carDerivate == 0) {
                return 50;
            }
            if (this.carGeneration == 7 && this.carDerivate == 1) {
                return 51;
            }
            if (this.carGeneration == 7 && this.carDerivate == 3) {
                if (this.carDerivateSub == 9) {
                    return 54;
                }
                return 52;
            }
            if (this.carGeneration == 7 && this.carDerivate == 5) {
                return 53;
            }
        } else if (this.carClass == 4) {
            if (this.carGeneration == 2 && this.carDerivate == 6) {
                if (this.carDerivateSub == 9) {
                    return 14;
                }
                return 12;
            }
            if (this.carGeneration == 9 && this.carDerivate == 1) {
                return 30;
            }
            if (this.carGeneration == 9 && this.carDerivate == 2) {
                if (this.carDerivateSub == 4) {
                    return 32;
                }
                return 31;
            }
            if (this.carGeneration == 9 && this.carDerivate == 3) {
                return 33;
            }
            if (this.carGeneration == 9 && this.carDerivate == 4) {
                return 34;
            }
            if (this.carGeneration == 9 && this.carDerivate == 5) {
                return 35;
            }
        } else if (this.carClass == 7) {
            if (this.carGeneration == 2 && this.carDerivate == 4) {
                if (this.carDerivateSub == 7) {
                    return 44;
                }
                if (this.carDerivateSub == 8) {
                    return 41;
                }
                return 40;
            }
            if (this.carGeneration == 2 && this.carDerivate == 5) {
                if (this.carDerivateSub == 8) {
                    return 43;
                }
                return 42;
            }
            if (this.carGeneration == 3 && this.carDerivate == 6) {
                if (this.carDerivateSub == 9) {
                    return 11;
                }
                return 10;
            }
        }
        this.logCarCoding.log(1000, "CarCodingHelper#calculateCarType unknown car type:  %1", (Object)this);
        throw new InvalidCarCodingException(new StringBuffer().append("UNKNOWN CAR TYPE: ").append(this.toString()).toString());
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("CarCodingHelper:\n\t carClass=").append(this.carClass);
        buffer.append(",\n\t carGeneration=").append(this.carGeneration);
        buffer.append(",\n\t carDerivate=").append(this.carDerivate);
        buffer.append(",\n\t carDerivateSublement=").append(this.carDerivateSub);
        buffer.append(",\n\t carType=").append(this.carType);
        return buffer.toString();
    }

    @Override
    public int getCarType() {
        this.checkInitialization();
        return this.carType;
    }

    @Override
    public String getKanziCarID() {
        int n = 0;
        switch (this.carType) {
            case 42: {
                n = 725;
                break;
            }
            case 31: {
                n = 492;
                break;
            }
            case 44: {
                n = 725;
                break;
            }
            case 51: {
                n = 371;
                break;
            }
            case 53: {
                n = 375;
                break;
            }
            default: {
                return "";
            }
        }
        Buffer buffer = new Buffer();
        buffer.append(n);
        return buffer.toString();
    }

    @Override
    public boolean isR8orTT() {
        this.checkInitialization();
        return this.isTT() || this.isR8();
    }

    @Override
    public boolean isTT() {
        this.checkInitialization();
        return this.carType == 20 || this.carType == 21;
    }

    @Override
    public boolean isR8() {
        this.checkInitialization();
        return this.carType == 40 || this.carType == 42 || this.carType == 44 || this.carType == 41 || this.carType == 43;
    }

    @Override
    public boolean isB9() {
        this.checkInitialization();
        return this.carType == 30 || this.carType == 32 || this.carType == 31 || this.carType == 33 || this.carType == 34 || this.carType == 35;
    }

    @Override
    public boolean isPHEVCar() {
        this.checkInitialization();
        return this.carType == 11 || this.carType == 44 || this.carType == 54 || this.carType == 14;
    }

    @Override
    public boolean isQ7() {
        this.checkInitialization();
        return this.carType == 10 || this.carType == 11;
    }

    @Override
    public boolean isA3() {
        this.checkInitialization();
        return this.carType == 53 || this.carType == 50 || this.carType == 51 || this.carType == 54 || this.carType == 52;
    }

    @Override
    public boolean isQ2() {
        this.checkInitialization();
        return this.carType == 13;
    }

    @Override
    public boolean isQ5() {
        this.checkInitialization();
        return this.carType == 12 || this.carType == 14;
    }

    @Override
    public boolean hasGyro() {
        this.checkInitialization();
        return this.carType == 12 || this.carType == 14 || this.carType == 10 || this.carType == 11 || this.carType == 13;
    }
}

