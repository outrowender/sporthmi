/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

public class MapScaleInfo {
    public int scale;
    public int scaleUnit;
    public boolean scaleValidity;
    public boolean isMaxScale;

    public int hashCode() {
        int n = 1;
        n = 31 * n + (this.isMaxScale ? 1231 : 1237);
        n = 31 * n + this.scale;
        n = 31 * n + this.scaleUnit;
        n = 31 * n + (this.scaleValidity ? 1231 : 1237);
        return n;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        MapScaleInfo mapScaleInfo = (MapScaleInfo)object;
        if (this.isMaxScale != mapScaleInfo.isMaxScale) {
            return false;
        }
        if (this.scale != mapScaleInfo.scale) {
            return false;
        }
        if (this.scaleUnit != mapScaleInfo.scaleUnit) {
            return false;
        }
        return this.scaleValidity == mapScaleInfo.scaleValidity;
    }
}

