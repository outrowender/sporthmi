/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.tmc.TmcListElement;

public abstract class TMCAbstractListRow
extends EvoListRow {
    protected TmcListElement message;

    public TMCAbstractListRow(long l, int n) {
        super(l, n);
    }

    public TMCAbstractListRow(TMCAbstractListRow tMCAbstractListRow) {
        super(tMCAbstractListRow);
        this.message = tMCAbstractListRow.getTmcListElement();
    }

    public TmcListElement getTmcListElement() {
        return this.message;
    }

    @Override
    public abstract EvoListRow copy() {
    }

    public abstract void updateRrdCarToEvent(int n) {
    }

    public abstract void updateDistanceAndDireciton(int n, int n2, int n3) {
    }

    public abstract boolean isLayoutOnRoute() {
    }
}

