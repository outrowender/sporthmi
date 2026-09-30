/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sortandindex;

import de.audi.atip.hmi.model.list.EvoListRow;

public class AlphabeticalIndexRow
extends EvoListRow {
    private static final int COL_COUNT = 2;
    private static final int COL_CHARACTER = 0;
    private static final int COL_INDEX = 1;

    public AlphabeticalIndexRow(int n, int n2) {
        super(n, 2);
        this.setInteger(0, n);
        this.setInteger(1, n2);
    }
}

