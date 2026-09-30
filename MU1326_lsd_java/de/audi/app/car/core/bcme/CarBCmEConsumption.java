/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.bcme;

import de.audi.atip.metrics.Consumption;
import de.esolutions.fw.util.commons.Buffer;

public class CarBCmEConsumption
extends Consumption {
    protected static final int UNDEFINED_CONSUMPTION_VALUE = -1;
    protected static final String TEXT_UNDEFINED_CONSUMPTION_VALUE = "---";
    final int consumptionValue;
    protected static final int MODE_VALUE_ONLY = 11;
    protected static final int MODE_UNIT_ONLY = 12;

    public CarBCmEConsumption(int n) {
        super(0.0f, n);
        this.consumptionValue = -1;
        this.setUseInstanceUnit(true);
    }

    public CarBCmEConsumption(float f2, int n) {
        super(f2, n);
        this.consumptionValue = (int)f2;
        this.setUseInstanceUnit(true);
    }

    public String format(int n) {
        if (n == 11) {
            return this.getFormattedValue();
        }
        if (n == 12) {
            return this.getFormattedUnit(this.unit);
        }
        return super.format(n);
    }

    protected void appendMantissa(Buffer buffer, int n, String string) {
        if (this.consumptionValue == -1) {
            buffer.clear();
            buffer.append(TEXT_UNDEFINED_CONSUMPTION_VALUE);
        } else if (n != 0) {
            super.appendMantissa(buffer, n, string);
        }
    }

    public void setUseInstanceUnit(boolean bl) {
        super.setUseInstanceUnit(true);
    }

    public float getValue() {
        return this.getValue(this.getUnit());
    }
}

