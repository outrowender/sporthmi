/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.EvoListRow;

public class BandListRow
extends EvoListRow {
    public BandListRow(int n) {
        super(n, 1);
        this.setInteger(0, n);
    }

    private BandListRow(BandListRow bandListRow) {
        super(bandListRow);
    }

    public EvoListRow copy() {
        return new BandListRow(this);
    }

    public int getBand() {
        return this.getInteger(0);
    }

    public int getPrio(int n) {
        if (this.getInteger(0) == n) {
            return 0;
        }
        switch (this.getInteger(0)) {
            case 1: {
                return 1;
            }
            case 4: {
                return 2;
            }
            case 5: {
                return 3;
            }
            case 7: {
                return 4;
            }
            case 15: {
                return 5;
            }
        }
        throw new IllegalArgumentException();
    }
}

