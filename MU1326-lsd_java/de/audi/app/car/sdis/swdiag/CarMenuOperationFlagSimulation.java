/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.sdis.swdiag;

import de.audi.atip.sysapp.carcoding.CarFuncAdap;

public class CarMenuOperationFlagSimulation
implements CarFuncAdap {
    private final byte[] carFunctions = new byte[56];

    public CarMenuOperationFlagSimulation() {
        this.carFunctions[11] = 9;
        this.carFunctions[13] = 1;
        this.carFunctions[18] = 3;
        this.carFunctions[32] = 5;
        this.carFunctions[19] = 9;
        this.carFunctions[40] = 5;
        this.carFunctions[21] = 5;
        this.carFunctions[8] = 5;
    }

    public CarMenuOperationFlagSimulation(byte by) {
        this.carFunctions[11] = by;
        this.carFunctions[13] = by;
        this.carFunctions[18] = by;
        this.carFunctions[32] = by;
        this.carFunctions[19] = by;
        this.carFunctions[40] = by;
        this.carFunctions[21] = by;
        this.carFunctions[8] = by;
    }

    @Override
    public boolean isMenuDisplayActivated(short s) {
        return (this.carFunctions[s] & 1) == 1;
    }

    @Override
    public boolean isMenuDisClamp15OffActivated(short s) {
        return this.isMenuDisplayActivated(s) && (this.carFunctions[s] & 2) == 1;
    }

    @Override
    public boolean isMenuDisOverThresholdHighActivated(short s) {
        return this.isMenuDisplayActivated(s) && (this.carFunctions[s] & 4) == 0;
    }

    @Override
    public boolean isMenuDisStandstillActivated(short s) {
        return this.isMenuDisplayActivated(s) && (this.carFunctions[s] & 8) == 1;
    }

    @Override
    public boolean isMenuDisAfterDisclaimerActivated(short s) {
        return false;
    }

    @Override
    public byte getByteCoding(short s) {
        return this.carFunctions[s];
    }
}

