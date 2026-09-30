/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.EvoListRow;

abstract class AbstractTeamRow
extends EvoListRow {
    private final int leagueId;

    AbstractTeamRow(long l, int n, int n2) {
        super(l, n2);
        this.leagueId = n;
    }

    protected AbstractTeamRow(AbstractTeamRow abstractTeamRow) {
        super(abstractTeamRow);
        this.leagueId = abstractTeamRow.leagueId;
    }

    abstract int getTeamID();

    abstract int getActivationCheckBox();

    public int getLeagueId() {
        return this.leagueId;
    }
}

