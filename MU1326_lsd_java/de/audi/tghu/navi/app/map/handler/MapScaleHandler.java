/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.map.handler.MapScaleInfo;

public class MapScaleHandler {
    public static final float QUARTER_MILE_MAX_THRESHOLD = 10.0f;
    public static final float QUARTER_MILE_MIN_THRESHOLD = 0.249f;
    private int lastZoomIndex;
    private int maximumScaleValue;
    private int maximumScaleUnit;

    public MapScaleInfo createMapScaleInfo(int n, float[] fArray) {
        boolean bl;
        float f2 = -1.0f;
        int n2 = -1;
        boolean bl2 = false;
        Distance distance = new Distance(0.0f, 1);
        distance.setValue(this.convertZoomIndexToKM(n, fArray));
        distance.formatByMode(4);
        f2 = distance.getFormattedDistance();
        n2 = distance.getFormattedUnit();
        bl2 = distance.isFormattedDistanceValid();
        int n3 = 65535;
        int n4 = this.convertFormattedUnitToMapScaleUnit(n2, f2);
        boolean bl3 = bl = n == fArray.length - 1;
        if (bl) {
            this.setMaximumScaleValue(Math.round(f2 * 10.0f));
            this.setMaximumScaleUnit(n4);
            n3 = this.lastZoomIndex == n ? 65534 : this.getMaximumScaleValue();
        } else {
            n3 = Math.round(f2 * 10.0f);
        }
        if (n3 != 65534 && this.shouldProvideQuarterMiles(distance.getValue(2))) {
            n3 = Math.round(f2 * 40.0f);
            n4 = 5;
        }
        this.lastZoomIndex = n;
        MapScaleInfo mapScaleInfo = new MapScaleInfo();
        mapScaleInfo.scale = n3;
        mapScaleInfo.scaleUnit = n4;
        mapScaleInfo.scaleValidity = bl2;
        mapScaleInfo.isMaxScale = bl;
        return mapScaleInfo;
    }

    public int getMaximumScaleValue() {
        return this.maximumScaleValue;
    }

    private void setMaximumScaleValue(int n) {
        this.maximumScaleValue = n;
    }

    public int getMaximumScaleUnit() {
        return this.maximumScaleUnit;
    }

    private void setMaximumScaleUnit(int n) {
        this.maximumScaleUnit = n;
    }

    private float convertZoomIndexToKM(int n, float[] fArray) {
        if (fArray == null || fArray.length == 0) {
            return 0.0f;
        }
        int n2 = n < 0 ? 0 : (n >= fArray.length ? fArray.length - 1 : n);
        return fArray[n2] / 100000.0f;
    }

    private int convertFormattedUnitToMapScaleUnit(int n, float f2) {
        switch (n) {
            case 0: {
                return this.getKMUnitForMapScale(f2);
            }
            case 1: {
                return 4;
            }
            case 2: {
                return 4;
            }
            case 3: {
                return 3;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 0;
            }
        }
        return 0;
    }

    private int getKMUnitForMapScale(float f2) {
        return this.floatHasDecimals(f2) ? 6 : 1;
    }

    private boolean floatHasDecimals(float f2) {
        return f2 % 1.0f != 0.0f;
    }

    private boolean shouldProvideQuarterMiles(float f2) {
        return Distance.getSystemUnit() == 2 && f2 <= 10.0f && f2 >= 0.249f;
    }
}

