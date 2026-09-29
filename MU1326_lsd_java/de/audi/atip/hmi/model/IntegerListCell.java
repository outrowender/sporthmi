/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.FinalIntegerListCell;
import de.audi.atip.hmi.model.ListCell;

public class IntegerListCell
implements ListCell {
    private int maxValue;
    private int value;

    public static IntegerListCell create(int n) {
        if (n == -1) {
            return FinalIntegerListCell.MINUS_ONE_CELL;
        }
        if (n >= 0 && n < FinalIntegerListCell.FINAL_CELLS.length) {
            return FinalIntegerListCell.FINAL_CELLS[n];
        }
        return new IntegerListCell(n);
    }

    public IntegerListCell(int n, int n2) {
        this.value = n;
        this.maxValue = n2;
    }

    public IntegerListCell(int n) {
        this(n, -129);
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public void setValue(int n) {
        this.value = n;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return String.valueOf(this.value);
    }

    public boolean equals(Object object) {
        if (object == null || !(object instanceof IntegerListCell)) {
            return false;
        }
        return this.value == ((IntegerListCell)object).value;
    }

    public int hashCode() {
        return this.value;
    }
}

