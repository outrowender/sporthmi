/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.seek;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.sdars.seek.AbstractTeamRow;

public class TeamRow
extends AbstractTeamRow {
    private static final int INDEX_TEAM_NAME = 0;
    private static final int INDEX_TEAM_CHECKBOX_ID = 1;
    private static final int INDEX_TEAM_ID = 2;
    private static final int INDEX_TEAM_INITIAL_CHECKBOX_VALUE = 3;
    private static final int TEAM_COLUMNS = 4;

    TeamRow(int n, String string, int n2, int n3, int n4) {
        super(n, n3, 4);
        this.setText(0, string);
        this.setInteger(1, n2);
        this.setInteger(2, n);
        this.setInteger(3, n4);
    }

    private TeamRow(TeamRow teamRow) {
        super(teamRow);
    }

    public EvoListRow copy() {
        return new TeamRow(this);
    }

    int getTeamID() {
        return this.getInteger(2);
    }

    int getActivationCheckBox() {
        return this.getInteger(1);
    }

    int getInitialCheckbox() {
        return this.getInteger(3);
    }
}

