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

    public abstract EvoListRow copy();

    public abstract void updateRrdCarToEvent(int var1);

    public abstract void updateDistanceAndDireciton(int var1, int var2, int var3);

    public abstract boolean isLayoutOnRoute();
}

