/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.EvoListRow;

class LeagueRow
extends EvoListRow {
    private static final int INDEX_LEAGUE_NAME;
    private static final int INDEX_LEAGUE_CHECKBOX;
    private static final int INDEX_LEAGUE_ID;
    private static final int LEAGUE_COLUMNS;

    LeagueRow(int n, String string, int n2) {
        super(n, 3);
        this.setText(0, string);
        this.setInteger(1, n2);
        this.setInteger(2, n);
    }

    private LeagueRow(LeagueRow leagueRow) {
        super(leagueRow);
    }

    @Override
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

