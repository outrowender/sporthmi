/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.service;

public class WheelTemperatures {
    public int temperatureUnit;
    public int frontLeft;
    public int frontRight;
    public int rearLeft;
    public int rearRight;
    public int spareWheel;

    public int getTemperatureUnit() {
        return this.temperatureUnit;
    }

    public void setTemperatureUnit(int n) {
        this.temperatureUnit = n;
    }

    public int getFrontLeft() {
        return this.frontLeft;
    }

    public void setFrontLeft(int n) {
        this.frontLeft = n;
    }

    public int getFrontRight() {
        return this.frontRight;
    }

    public void setFrontRight(int n) {
        this.frontRight = n;
    }

    public int getRearLeft() {
        return this.rearLeft;
    }

    public void setRearLeft(int n) {
        this.rearLeft = n;
    }

    public int getRearRight() {
        return this.rearRight;
    }

    public void setRearRight(int n) {
        this.rearRight = n;
    }

    public int getSpareWheel() {
        return this.spareWheel;
    }

    public void setSpareWheel(int n) {
        this.spareWheel = n;
    }

    public WheelTemperatures() {
    }

    public WheelTemperatures(int n, int n2, int n3, int n4, int n5, int n6) {
        this.temperatureUnit = n;
        this.frontLeft = n2;
        this.frontRight = n3;
        this.rearLeft = n4;
        this.rearRight = n5;
        this.spareWheel = n6;
    }

    public String toString() {
        return "WheelTemperatures{" + "temperatureUnit=" + this.temperatureUnit + ", frontLeft=" + this.frontLeft + ", frontRight=" + this.frontRight + ", rearLeft=" + this.rearLeft + ", rearRight=" + this.rearRight + ", spareWheel=" + this.spareWheel + "}";
    }
}

