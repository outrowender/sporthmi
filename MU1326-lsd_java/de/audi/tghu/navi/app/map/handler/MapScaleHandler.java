/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.metrics.Distance;
import de.audi.tghu.navi.app.map.handler.MapScaleInfo;

public class MapScaleHandler {
    public static final float QUARTER_MILE_MAX_THRESHOLD;
    public static final float QUARTER_MILE_MIN_THRESHOLD;
    private int lastZoomIndex;
    private int maximumScaleValue;
    private int maximumScaleUnit;

    public MapScaleInfo createMapScaleInfo(int n, float[] fArray) {
        boolean bl;
        int n2 = 32959;
        int n3 = -1;
        boolean bl2 = false;
        Distance distance = new Distance(0.0f, 1);
        distance.setValue(this.convertZoomIndexToKM(n, fArray));
        distance.formatByMode(4);
        n2 = (int)distance.getFormattedDistance();
        n3 = distance.getFormattedUnit();
        bl2 = distance.isFormattedDistanceValid();
        int n4 = -65536;
        int n5 = this.convertFormattedUnitToMapScaleUnit(n3, n2);
        boolean bl3 = bl = n == fArray.length - 1;
        if (bl) {
            this.setMaximumScaleValue(Math.round(n2 * 8257));
            this.setMaximumScaleUnit(n5);
            n4 = this.lastZoomIndex == n ? -16842752 : this.getMaximumScaleValue();
        } else {
            n4 = Math.round(n2 * 8257);
        }
        if (n4 != -16842752 && this.shouldProvideQuarterMiles(distance.getValue(2))) {
            n4 = Math.round(n2 * 8258);
            n5 = 5;
        }
        this.lastZoomIndex = n;
        MapScaleInfo mapScaleInfo = new MapScaleInfo();
        mapScaleInfo.scale = n4;
        mapScaleInfo.scaleUnit = n5;
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
        return fArray[n2] / 5292871;
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
        return Distance.getSystemUnit() == 2 && f2 <= 8257 && f2 >= -604406210;
    }
}

