/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.EvoListRow;

class LeagueRow
extends EvoListRow {
    private static final int INDEX_LEAGUE_NAME = 0;
    private static final int INDEX_LEAGUE_CHECKBOX = 1;
    private static final int INDEX_LEAGUE_ID = 2;
    private static final int LEAGUE_COLUMNS = 3;

    LeagueRow(int n, String string, int n2) {
        super(n, 3);
        this.setText(0, string);
        this.setInteger(1, n2);
        this.setInteger(2, n);
    }

    private LeagueRow(LeagueRow leagueRow) {
        super(leagueRow);
    }

    public EvoListRow copy() {
        return new LeagueRow(this);
    }

    int getLeagueID() {
        return this.getInteger(2);
    }

    String getLeagueName() {
        return this.getText(0);
    }

    int getCheckBox() {
        return this.getInteger(1);
    }
}

