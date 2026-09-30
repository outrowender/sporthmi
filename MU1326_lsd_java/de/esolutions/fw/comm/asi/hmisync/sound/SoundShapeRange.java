/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.sound;

public class SoundShapeRange {
    public int minXRange;
    public int minYRange;
    public int minZRange;
    public int maxXRange;
    public int maxYRange;
    public int maxZRange;

    public int getMinXRange() {
        return this.minXRange;
    }

    public void setMinXRange(int n) {
        this.minXRange = n;
    }

    public int getMinYRange() {
        return this.minYRange;
    }

    public void setMinYRange(int n) {
        this.minYRange = n;
    }

    public int getMinZRange() {
        return this.minZRange;
    }

    public void setMinZRange(int n) {
        this.minZRange = n;
    }

    public int getMaxXRange() {
        return this.maxXRange;
    }

    public void setMaxXRange(int n) {
        this.maxXRange = n;
    }

    public int getMaxYRange() {
        return this.maxYRange;
    }

    public void setMaxYRange(int n) {
        this.maxYRange = n;
    }

    public int getMaxZRange() {
        return this.maxZRange;
    }

    public void setMaxZRange(int n) {
        this.maxZRange = n;
    }

    public SoundShapeRange() {
    }

    public SoundShapeRange(int n, int n2, int n3, int n4, int n5, int n6) {
        this.minXRange = n;
        this.minYRange = n2;
        this.minZRange = n3;
        this.maxXRange = n4;
        this.maxYRange = n5;
        this.maxZRange = n6;
    }

    public String toString() {
        return "SoundShapeRange{" + "minXRange=" + this.minXRange + ", minYRange=" + this.minYRange + ", minZRange=" + this.minZRange + ", maxXRange=" + this.maxXRange + ", maxYRange=" + this.maxYRange + ", maxZRange=" + this.maxZRange + "}";
    }
}

