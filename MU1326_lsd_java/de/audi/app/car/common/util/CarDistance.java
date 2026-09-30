/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.util;

import de.audi.atip.metrics.Distance;
import de.esolutions.fw.util.commons.Buffer;

public class CarDistance
extends Distance {
    protected static final String TEXT_NO_DISTANCE = "--";
    private boolean undefinedDistance = false;

    public CarDistance() {
        super(0.0f, 1);
        this.undefinedDistance = true;
    }

    public CarDistance(float f2, int n) {
        super(f2, n);
        this.value = f2;
    }

    public String format(int n) {
        if (this.undefinedDistance) {
            this.lastFormat = TEXT_NO_DISTANCE;
            return this.lastFormat;
        }
        if (n == 2) {
            Buffer buffer = new Buffer();
            buffer.append((int)this.value).append(CarDistance.getText(1));
            if (!CarDistance.contentEquals(this.lastFormat, buffer)) {
                this.lastFormat = buffer.toString();
            }
            return this.lastFormat;
        }
        return super.format(n);
    }

    public String getFormattedUnit(int n) {
        if (this.undefinedDistance) {
            return "";
        }
        if (n == 2) {
            String string = CarDistance.getText(1);
            return null != string ? string.trim() : "";
        }
        return super.getFormattedUnit(n);
    }

    public String getFormattedValue(int n) {
        if (this.undefinedDistance) {
            return TEXT_NO_DISTANCE.trim();
        }
        if (2 == n) {
            return Integer.toString((int)this.value);
        }
        return super.getFormattedValue(n);
    }
}

