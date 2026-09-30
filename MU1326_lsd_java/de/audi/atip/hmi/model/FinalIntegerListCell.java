/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.IntegerListCell;

public class FinalIntegerListCell
extends IntegerListCell {
    static final FinalIntegerListCell MINUS_ONE_CELL = new FinalIntegerListCell(-1);
    static final FinalIntegerListCell[] FINAL_CELLS = new FinalIntegerListCell[]{new FinalIntegerListCell(0), new FinalIntegerListCell(1), new FinalIntegerListCell(2), new FinalIntegerListCell(3), new FinalIntegerListCell(4), new FinalIntegerListCell(5), new FinalIntegerListCell(6), new FinalIntegerListCell(7), new FinalIntegerListCell(8), new FinalIntegerListCell(9)};

    FinalIntegerListCell(int n) {
        super(n);
    }

    public void setValue(int n) {
        throw new IllegalArgumentException("Changing value of FinalIntegerListCell not allowed!");
    }
}

